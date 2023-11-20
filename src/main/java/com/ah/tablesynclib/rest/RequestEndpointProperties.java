package com.ah.tablesynclib.rest;

import org.springframework.stereotype.Component;

import com.ah.tablesynclib.util.EntityUtil;

import lombok.Data;

@Component
@Data
public class RequestEndpointProperties {

	private String url;

	private final String APARTROWNER = "/apartowner/";

	private final EntityUtil.methodEnum INSERT = EntityUtil.methodEnum.insert;
	private final EntityUtil.methodEnum UPDATE = EntityUtil.methodEnum.update;
	private final EntityUtil.methodEnum DELETE = EntityUtil.methodEnum.delete;

	/**
	 * aparowner/insert の取得
	 * 
	 * @return
	 */
	public String getApartownerInsert() {
		return url + APARTROWNER + INSERT;
	}

	/**
	 * aparowner/update の取得
	 * 
	 * @return
	 */
	public String getApartownerUpdate() {
		return url + APARTROWNER + UPDATE;
	}

	/**
	 * aparowner/delete の取得
	 * 
	 * @return
	 */
	public String getApartownerDelete() {
		return url + APARTROWNER + DELETE;
	}

}
