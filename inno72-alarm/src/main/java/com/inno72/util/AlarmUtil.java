package com.inno72.util;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.inno72.model.AlarmDetailBean;
import com.inno72.model.AlarmDropGoodsBean;
import com.inno72.model.AlarmLackGoodsBean;
import com.inno72.model.AlarmMachineBean;
import com.inno72.redis.IRedisUtil;

@Component
public class AlarmUtil {

	@Autowired
	private MongoOperations mongoTpl;

	@Resource
	private IRedisUtil redisUtil;
	public void saveAlarmDetail(AlarmDetailBean bean){
		Date now = new Date();
		bean.setCreateTime(now);
		String beanId = StringUtil.getUUID();
		bean.setId(beanId);
		mongoTpl.save(bean,"AlarmDetailBean");
		Query query = new Query();
		query.addCriteria(Criteria.where("machineId").is(bean.getMachineId()));
		Update update = new Update();
		int type = bean.getType();
		AlarmMachineBean machineBean = new AlarmMachineBean();
		machineBean.setUpdateTime(now);
		String key = "";
		String timeKey = "";
		if(type == 1){//心跳
			update.set("heartId",beanId);
			update.set("heartTime",now);
			key = CommonConstants.MACHINE_ALARM_HEART_BEF +bean.getMachineId();
			timeKey = CommonConstants.MACHINE_ALARM_HEART_TIME_BEF+bean.getMachineId();
		}else if(type == 2){//网络
			update.set("connectId",beanId);
			update.set("connectTime",now);
			key = CommonConstants.MACHINE_ALARM_CONNECT_BEF+bean.getMachineId();
			timeKey = CommonConstants.MACHINE_ALARM_CONNECT_TIME_BEF+bean.getMachineId();
		}
		update.set("updateTime",now);
		mongoTpl.updateFirst(query,update,"AlarmMachineBean");
		redisUtil.del(key);
		redisUtil.del(timeKey);
	}

	public void saveDropGoodsBean(AlarmDropGoodsBean bean){
		Date now = new Date();
		bean.setCreateTime(now);
		bean.setHandle(0);
		String beanId = StringUtil.getUUID();
		bean.setId(beanId);
		mongoTpl.save(bean,"AlarmDropGoodsBean");
	}

	public void saveLackGoodsBean(AlarmLackGoodsBean bean){
		Date now = new Date();
		bean.setCreateTime(now);
		bean.setHandle(0);
		String beanId = StringUtil.getUUID();
		bean.setId(beanId);
		mongoTpl.save(bean,"AlarmLackGoodsBean");
	}

}
