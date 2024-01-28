package com.ah.tablesynclib.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.ah.commonlib.EntityUtil;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component
@Data
public class SyncRequestEndpointProperties {
	
	@Autowired
	Environment env;

	//TODO リソパへの変更
	private String url = "http://localhost:8080/table_sync";

	private final String APARTROWNER = "apartowner";

	private final EntityUtil.methodEnum INSERT = EntityUtil.methodEnum.insert;
	private final EntityUtil.methodEnum UPDATE = EntityUtil.methodEnum.update;
	private final EntityUtil.methodEnum DELETE = EntityUtil.methodEnum.delete;
	
	@PostConstruct
	public void init() {
	//tablesynclib内のyamlからリクエスト先URLの取得
//	this.url = env.getProperty("tablesync.url");
	}
	/**
	 * aparowner/insert の取得
	 * 
	 * @return
	 */
	public String getApartownerInsert() {
		return UriComponentsBuilder.fromHttpUrl(url)
				.pathSegment(APARTROWNER, INSERT.toString())
				.build()
				.toUriString();
	}

	/**
	 * aparowner/update の取得
	 * 
	 * @return
	 */
	public String getApartownerUpdate() {
		return UriComponentsBuilder.fromHttpUrl(url)
				.pathSegment(APARTROWNER, UPDATE.toString())
				.build()
				.toUriString();
	}

	/**
	 * aparowner/delete/{id} の取得
	 * 
	 * @return
	 */
	public String getApartownerDelete(Integer id) {
		return UriComponentsBuilder.fromHttpUrl(url)
				.pathSegment(APARTROWNER, DELETE.toString(), id.toString())
				.build()
				.toUriString();
	}

}
