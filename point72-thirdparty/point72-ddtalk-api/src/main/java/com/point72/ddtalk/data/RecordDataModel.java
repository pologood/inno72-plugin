package com.point72.ddtalk.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 * 记录统计数据对象
 * 
 * @author Houkm
 *
 *         2017年9月12日
 */
public class RecordDataModel {

	private String startTimeMs;
	private String endTimeMs;
	private String module;
	private String originId;
	private String userid;
	private String agentId;
	private String callbackUrl;
	private String extension;

}
