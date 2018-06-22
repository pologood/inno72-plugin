package com.framelib.dubbo.doctor.service;

import com.framelib.common.Result;
import com.framelib.dubbo.doctor.model.DoctorInfo.StatusEnum;
import com.framelib.dubbo.doctor.vo.DoctorGroupVo;

public interface IDoctorGroupService {
	
	/**
	 * 保存分组vo 
	 * 保存新建分组只存储 doctorGroup信息
	 * 保存子级分组插入list中，并附带父分组信息 必要 id  
	 * @param doctorGroupVo 医生组信息
	 * @return
	 */
	public Result<String> saveGroup(DoctorGroupVo doctorGroupVo);
	
	/**
	 * @param id 分组或医生id
	 * @param status 状态枚举{@link com.framelib.dubbo.doctor.DoctorGroupStatus.java}
	 * @return 保存成功结果
	 */
	public Result<String> saveStatus(int id ,StatusEnum status,String optionId,String optionName);
	
	/**
	 * 查找分组信息，
	 * 如果没有传入父级id则直接检索 所有分组信息并包装返回
	 * 如果传入父级id 则只查询该夫级的子集和孙子集
	 * @param doctorGroupVo 参数
	 * @return doctorGroupVo
	 */
	public Result<DoctorGroupVo> findDoctorGroupVo(DoctorGroupVo doctorGroupVo);

}
