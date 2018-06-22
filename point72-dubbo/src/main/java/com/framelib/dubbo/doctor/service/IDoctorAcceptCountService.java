package com.framelib.dubbo.doctor.service;

import java.util.List;

import com.framelib.common.Result;
import com.framelib.dubbo.doctor.model.AsDoctorCount;

/**
 * 医生统计查询接口
 * 日接单量 全接单量 日搜索量 全搜索量
 * @author zhouzengbao
 *
 */
public interface IDoctorAcceptCountService {
	
	public Result<List<AsDoctorCount>> findDoctorCount(List<Integer> doctorIds);
	
	public Result<String> addCountSearchNum(int doctorId);
	
	public Result<String> addCountOrderNum(int doctorId);

	public int countAcceptOrder(Integer id);

}
