package com.miot.common.network.mlcc.pojo.response;

import java.util.Map;

import com.miot.commom.network.mlcc.utils.MLCCCodeConfig;

public class RespSmartConnectedAck extends RespBaseAck{

	
	public RespSmartConnectedAck() {
		super.chazzType = this.getClass();
		super.clazzTypeDesc = MLCCCodeConfig.MLCCCodeReturn.SMART_CONNECTED;
	}
	
	public static final String RESULT_SUCCESS = "1";
	public static final String RESULT_FAIL = "0";

	private String codeName;
	private String mac;

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	@Override
	public void make(Map<String, String> resultMap) {

		super.setResultMap(resultMap);
	}

	@Override
	public String toString() {
		return "RespSmartConnectedAck [codeName=" + codeName + ", mac=" + mac
				+ "]";
	}
	
	

}
