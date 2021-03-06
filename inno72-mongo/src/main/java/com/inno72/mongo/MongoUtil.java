package com.inno72.mongo;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.mongodb.WriteResult;

/**
 * Mongo工具类. 直接注入使用
 * 
 * @author Houkm
 *
 *         2017年5月5日
 */
@Component
public class MongoUtil {

	@Autowired
	private MongoTemplate template;

	private Logger logger = LoggerFactory.getLogger(MongoUtil.class);

	/**
	 * 保存数据
	 * 
	 * @param obj
	 * @author Houkm 2017年5月2日
	 */
	public void save(Object obj) {

		logger.info("保存数据save: {}", JSON.toJSONString(obj));
		template.save(obj);
	}

	/**
	 * 保存数据
	 * 
	 * @param obj
	 * @author Houkm 2017年5月2日
	 */
	public void insert(Object obj) {
		logger.info("保存数据insert: {}", JSON.toJSONString(obj));
		template.insert(obj);
	}

	/**
	 * 保存数据
	 * 
	 * @param obj
	 * @author Houkm 2017年5月2日
	 */
	public void insert(Object obj, String name) {
		logger.info("保存数据insert: {}", JSON.toJSONString(obj));
		template.insert(obj);
	}

	/**
	 * 保存数据
	 * 
	 * @param obj
	 * @param name
	 * @author Houkm 2017年5月2日
	 */
	public void save(Object obj, String name) {
		logger.info("保存数据{}: {}", name, JSON.toJSONString(obj));
		template.save(obj, name);
	}

	/**
	 * 根据ID查询数据
	 * 
	 * @param id
	 * @param clazz
	 * @param collectionName
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> T findById(Object id, Class<T> clazz, String collectionName) {
		logger.info("查询数据id[{}]，class[{}]", id, clazz.getName());
		T result = template.findById(id, clazz, collectionName);
		logger.info("获取数据: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 根据ID查询数据
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> T findById(Object id, Class<T> clazz) {
		logger.info("查询数据id[{}]，class[{}]", id, clazz.getName());
		T result = template.findById(id, clazz);
		logger.info("获取数据: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 获取一条数据
	 * 
	 * @param query
	 * @param clazz
	 * @return
	 * @author Houkm 2018年5月17日
	 */
	public <T> T findOne(Query query, Class<T> clazz) {
		logger.info(query.toString());
		T result = template.findOne(query, clazz);
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 获取一条数据
	 * 
	 * @param query
	 * @param clazz
	 * @param collectionName
	 * @return
	 * @author Houkm 2018年5月17日
	 */
	public <T> T findOne(Query query, Class<T> clazz, String collectionName) {
		logger.info(query.toString());
		T result = template.findOne(query, clazz, collectionName);
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 获取所有数据
	 * 
	 * @param clazz
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> List<T> findAll(Class<T> clazz) {
		logger.info("查询所有数据class[{}]", clazz.getName());
		List<T> result = template.findAll(clazz);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 获取所有数据
	 * 
	 * @param collection
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> List<T> findAll(Class<T> clazz, String collection) {
		logger.info("查询所有数据class [{}] collection[{}]", clazz.getName(), collection);
		List<T> result = template.findAll(clazz, collection);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 根据条件查询数据
	 * 
	 * @param example
	 * @param clazz
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> List<T> find(T example, Class<T> clazz) {
		logger.info("条件[{}]查询[{}]", JSON.toJSONString(example), clazz.getName());
		Query query = query(example);
		List<T> result = template.find(query, clazz);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 根据条件查询数据
	 * 
	 * @param example
	 * @param clazz
	 * @param collection
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> List<T> find(T example, Class<T> clazz, String collection) {
		logger.info("条件[{}]查询[{}], collection[{}]", JSON.toJSONString(example), clazz.getName(), collection);
		Query query = query(example);
		List<T> result = template.find(query, clazz, collection);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 获取根据条件分页数据
	 * 
	 * @param example
	 * @param clazz
	 * @param skip
	 * @param limit
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> List<T> findRange(T example, Class<T> clazz, int skip, int limit) {
		logger.info("条件[{}]查询[{}]", JSON.toJSONString(example), clazz.getName());
		logger.info("跳过前{}条数据，查询{}条数据", skip, limit);
		Query query = query(example);
		query.skip(skip).limit(limit);
		List<T> result = template.find(query, clazz);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));

		return template.find(query, clazz);
	}

	/**
	 * 获取根据条件分页数据
	 * 
	 * @param example
	 * @param clazz
	 * @param collection
	 * @param skip
	 * @param limit
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	public <T> List<T> findRange(T example, Class<T> clazz, String collection, int skip, int limit) {
		logger.info("条件[{}]查询[{}]", JSON.toJSONString(example), clazz.getName());
		logger.info("跳过前{}条数据，查询{}条数据", skip, limit);
		Query query = query(example);
		query.skip(skip).limit(limit);
		List<T> result = template.find(query, clazz, collection);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));

		return template.find(query, clazz);
	}

	/**
	 *
	 * 
	 * @param query
	 * @param clazz
	 * @return
	 * @author Houkm 2017年6月19日
	 */
	public <T> List<T> find(Query query, Class<T> clazz) {
		logger.info(query.toString());
		List<T> result = template.find(query, clazz);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return template.find(query, clazz);
	}

	/**
	 * 
	 * @param query
	 * @param clazz
	 * @param collectionName
	 * @return
	 * @author Houkm 2018年5月17日
	 */
	public <T> List<T> find(Query query, Class<T> clazz, String collectionName) {
		logger.info(query.toString());
		List<T> result = template.find(query, clazz, collectionName);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return result;
	}

	/**
	 * 获取根据条件分页数据,根据时间区间
	 * 
	 * @param example
	 * @param clazz
	 * @param collection
	 * @param startTime
	 * @param endTime
	 * @param fieldName
	 * @param skip
	 * @param limit
	 * @return
	 * @author Houkm 2017年6月19日
	 */
	public <T> List<T> findRange(Query query, Class<T> clazz) {
		logger.info(query.toString());
		List<T> result = template.find(query, clazz);
		logger.info("查询数据结果: {}条", result.size());
		logger.debug("数据集: {}", JSON.toJSONString(result));
		return template.find(query, clazz);
	}

	/**
	 * 更新数据
	 * 
	 * @param example
	 *            条件
	 * @param updateMap
	 *            更新的字段
	 * @param clazz
	 * @author Houkm 2017年5月2日
	 */
	public <T> void update(T example, Map<String, Object> updateMap, Class<T> clazz) {
		logger.info("更新{}", clazz.getName());
		logger.info("条件: {}", JSON.toJSONString(example));
		logger.info("更新值: {}", JSON.toJSONString(updateMap));
		Query query = query(example);
		Update update = new Update();
		updateMap.forEach((k, v) -> {
			update.set(k, v);
		});
		template.updateMulti(query, update, clazz);
		logger.info("更新成功");
	}

	/**
	 * 生成query
	 * 
	 * @param example
	 * @return
	 * @author Houkm 2017年5月2日
	 */
	private <T> Query query(T example) {
		Query query = new Query(Criteria.byExample(Example.of(example)));
		return query;
	}

	/**
	 * 获取总条数
	 * 
	 * @param example
	 * @param clazz
	 * @return
	 */
	public <T> long count(T example, Class<T> clazz) {
		logger.info("条件[{}]查询[{}]", JSON.toJSONString(example), clazz.getName());
		Query query = query(example);
		long rows = this.template.count(query, clazz);
		logger.info("查询总数结果: {}条", rows);
		return rows;
	}

	/**
	 * 获取总条数
	 * 
	 * @param example
	 * @param clazz
	 * @param collectionName
	 * @return
	 */
	public <T> long count(T example, Class<T> clazz, String collectionName) {
		logger.info("条件[{}]查询[{}]", JSON.toJSONString(example), clazz.getName());
		Query query = query(example);
		long rows = this.template.count(query, collectionName);
		logger.info("查询总数结果: {}条", rows);
		return rows;
	}

	/**
	 * 获取总条数
	 * 
	 * @param query
	 * @param clazz
	 * @return
	 */
	public <T> long count(Query query, Class<T> clazz) {
		long rows = this.template.count(query, clazz);
		logger.info("查询总数结果: {}条", rows);
		return rows;
	}

	/**
	 * 获取总条数
	 * 
	 * @param query
	 * @param collectionName
	 * @return
	 */
	public <T> long count(Query query, String collectionName) {
		long rows = this.template.count(query, collectionName);
		logger.info("查询总数结果: {}条", rows);
		return rows;
	}

	/**
	 * 删除
	 * 
	 * @param query
	 * @param clazz
	 */
	public <T> void delete(Query query, Class<T> clazz) {
		this.template.remove(query, clazz);
	}

	/**
	 * 删除
	 * 
	 * @param query
	 * @param clazz
	 * @param collectionName
	 */
	public <T> void delete(Query query, Class<T> clazz, String collectionName) {
		this.template.remove(query, clazz, collectionName);
	}

	/**
	 * 获取指定coll下一个自增ID
	 * 
	 * @param collName
	 * @return
	 * @author Houkm 2017年6月26日
	 */
	public Long getNextId(String collName) {
		Query query = new Query(Criteria.where("collName").is(collName));
		Update update = new Update();
		update.inc("seqId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.upsert(true);
		options.returnNew(true);
		SequenceId seqId = template.findAndModify(query, update, options, SequenceId.class);
		return seqId.getSeqId();
	}

	public WriteResult updateFirst(Query var1, Update var2, String var3){
		logger.info("修改Mongo数据条件:{}",JSON.toJSON(var1.getQueryObject()));
		logger.info("修改Mongo数据字段:{}",JSON.toJSON(var2));
		logger.info("修改monggo数据所在表:{}",var3);
		WriteResult result = template.updateFirst(var1,var2,var3);
		logger.info("修改mongo数据结果：{}",JSON.toJSON(result.isUpdateOfExisting()));
		return result;
	}

	public WriteResult remove(Query query, String collectionName) {
		logger.info("删除Mongo数据条件:{}",JSON.toJSON(query.getQueryObject()));
		logger.info("删除monggo数据所在表:{}",collectionName);
		WriteResult result = template.remove(query, (Class)null, collectionName);
		logger.info("删除mongo数据结果：{}",JSON.toJSON(result.isUpdateOfExisting()));
		return result;
	}

}
