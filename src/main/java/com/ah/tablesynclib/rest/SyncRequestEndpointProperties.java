package com.ah.tablesynclib.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ah.commonlib.EntityUtil;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component
@Data
public class SyncRequestEndpointProperties {
	
	@Autowired
	Environment env;

	private String url;

	private final String APARTROWNER = "/apartowner/";

	private final EntityUtil.methodEnum INSERT = EntityUtil.methodEnum.insert;
	private final EntityUtil.methodEnum UPDATE = EntityUtil.methodEnum.update;
	private final EntityUtil.methodEnum DELETE = EntityUtil.methodEnum.delete;
	
	@PostConstruct
	public void init() {
	//tablesynclib内のyamlからリクエスト先URLの取得
	this.url = env.getProperty("tablesync.url");
	}
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
