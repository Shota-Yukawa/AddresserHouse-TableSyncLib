package com.ah.tablesynclib.rest;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.ah.commonlib.EntityUtil;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component
@Data
public class SyncRequestEndpointProperties {

	private String url ;

	private final String APARTROWNER = "apartowner";

	private final EntityUtil.methodEnum INSERT = EntityUtil.methodEnum.insert;
	private final EntityUtil.methodEnum UPDATE = EntityUtil.methodEnum.update;
	private final EntityUtil.methodEnum DELETE = EntityUtil.methodEnum.delete;
	
	@PostConstruct
	public void init() {
		//tablesynclib内のpropertiesからリクエスト先URLの取得
		try {
			ClassPathResource resource = new ClassPathResource("tablesynclib.properties");
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			this.url = properties != null ? properties.getProperty("tablesync.url") : null;
		} catch (IOException e) {
			e.printStackTrace();
		}
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
