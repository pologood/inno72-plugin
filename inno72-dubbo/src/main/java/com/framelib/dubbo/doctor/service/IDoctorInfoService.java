package com.framelib.dubbo.doctor.service;

import com.framelib.common.Result;
import com.framelib.dubbo.doctor.model.DoctorBusinessProperty;
import com.framelib.dubbo.doctor.model.DoctorBusinessProperty.OpenType;
import com.framelib.dubbo.doctor.model.DoctorInfo;
import com.framelib.dubbo.doctor.model.DoctorInfo.StatusEnum;
import com.framelib.dubbo.doctor.vo.DoctorVo;


/**
 * 医生dubbo 接口
 * 
 * 
 * @author zhouzengbao
 *
 */
public interface IDoctorInfoService {
	/**
	 * 注册医生
	 * 
	 * @param docatorInfo 医生信息
	 * @return DoctorInfo添加保存id
	 */
	public Result<DoctorInfo> registInfo(DoctorInfo docatorInfo);
	
	/**
	 * 认证医生
	 *    保存医生认证资质信息
	 * @param doctorVo
	 * @param staus 枚举{@link com.framelib.dubbo.doctor.model.DoctorInfo.StatusEnum}
	 * @return 完整医生属性
	 */
	public Result<DoctorVo> updatehInfo(DoctorVo doctorVo,StatusEnum status);
	
	/**
	 * 通过id查询医生全部信息
	 * 
	 * @param doctorId
	 * @return
	 */
	public Result<DoctorVo> selectDoctorVoById(int doctorId);
	
	
	/**
	 * 删除医生
	 * @param doctorId 医生id
	 * @return 修改后的结果
	 */
	public Result<DoctorInfo> delDoctor(int doctorId,String optionId,String optionName);
	
	
	/**
	 * 家庭医生在线状态修改
	 * 
	 * @param doctorId 医生id
	 * @param openType
	 * @return
	 */
	public Result<String> homeDoctorOnline(int doctorId,OpenType openType);
	
	/**
	 * 附近医生在线状态修改
	 * 
	 * @param doctorId 医生id
	 * @param openType
	 * @return
	 */
	public Result<String> nearbyDoctorOnline(int doctorId,OpenType openType);
	
	
	/**
	 * 查询医生开关状态
	 * @param doctorId
	 * @return
	 */
	public Result<DoctorBusinessProperty> findSOpenType(Integer doctorId);
	
	/**
	 * 修改医生网络状态
	 * @param doctorId 医生id
	 * @param openType 网络状态 0 关闭；1 开启
	 * @return
	 */
	public Result<String> editSNetworkStatus(Integer doctorId,OpenType openType);

}
