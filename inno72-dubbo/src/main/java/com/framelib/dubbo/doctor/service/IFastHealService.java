package com.framelib.dubbo.doctor.service;

import java.util.List;

import com.framelib.common.Result;
import com.framelib.dubbo.doctor.FastHealLockTypeEnum;
import com.framelib.dubbo.doctor.model.DoctorBusinessProperty.AcceptType;
import com.framelib.dubbo.doctor.model.DoctorBusinessProperty.OpenType;
import com.framelib.dubbo.doctor.model.DoctorOptionsHis;
import com.framelib.dubbo.doctor.vo.DoctorLog;
import com.framelib.dubbo.doctor.vo.DoctorVo;

/**
 * 速诊医生接口
 * 
 * @author ZhouZengbao
 *
 */
public interface IFastHealService {

	/**
	 * @param doctorId
	 *            医生id
	 * @param openType
	 *            开关枚举
	 *            {@link com.framelib.dubbo.doctor.model.DoctorBusinessProperty.OpenType}
	 * @return 结果
	 */
	public Result<String> onOff(int doctorId, OpenType openType);

	/**
	 * 接诊状态
	 * 
	 * @param doctorId
	 *            医生id
	 * @param acceptType
	 *            {@link com.framelib.dubbo.doctor.model.DoctorBusinessProperty.AcceptType}
	 * @return 结果
	 */
	public Result<String> acceptType(int doctorId, AcceptType acceptType);

	/**
	 * 医生日志接口
	 * 
	 * @param his
	 *            日志对象
	 * @return 记录结果
	 */
	public Result<String> logDoctorMsg(DoctorOptionsHis his);

	/**
	 * @param userId
	 *            用户id
	 * @param locktype
	 *            {@link FastHealLockTypeEnum}
	 * @param doctorType
	 *            问诊类型 array
	 */
	public Result<List<DoctorVo>> findFastDoctor(Integer userId, FastHealLockTypeEnum locktype, String... doctorType);

	/**
	 * 查询速诊医生列表 及当前状态
	 * 
	 * @return
	 */
	public Result<List<DoctorVo>> findDoctorDetailList();

	/**
	 * 手动断开socket
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年4月24日下午4:36:46
	 * @param doctorId
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
//	public Result<String> disConnectSocket(String doctorId);
	
	/**
	 * 解锁
	 * @param userId
	 * @return
	 */
	public Result<String> unLockDoctor(int userId);
	
	/**
	 * 医生在线时长统计
	 * @param doctorLog
	 * @return
	 */
	public Result<DoctorLog> findDoctorTimeLog(DoctorLog doctorLog);
	
	/**
	 * 异常下线
	 * @param doctorId
	 * @return
	 */
	@Deprecated
	public Result<String> abnormalOffLine(String doctorId);
	
	/**
	 * 检查医生是否在速诊业务中被锁定
	 * 
	 * @param doctorId 医生id
	 * 
	 * @return 
	 * success 为 没有被锁定
	 * failure 为 已经被锁定 msg 为被锁定业务的描述
	 * 错误码2000为id是空的
	 * 
	 */
	public Result<String> checkLockByDoctorId(String doctorId);
	
}
