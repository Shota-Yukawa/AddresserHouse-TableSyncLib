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


	private final String INSERT = EntityUtil.methodEnum.insert.toString();
	private final String UPDATE = EntityUtil.methodEnum.update.toString();
	private final String DELETE = EntityUtil.methodEnum.delete.toString();
	
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
	 * {tableName}/insert のurl取得
	 * @return
	 */
	public String getTableSyncInsertUrl(String talbeName) {
		return UriComponentsBuilder.fromHttpUrl(url)
				.pathSegment(talbeName, INSERT)
				.build()
				.toUriString();
	}

	/**
	 * {tableName}/update のurl取得
	 * @return
	 */
	public String getTableSyncUpdateUrl(String talbeName) {
		return UriComponentsBuilder.fromHttpUrl(url)
				.pathSegment(talbeName, UPDATE)
				.build()
				.toUriString();
	}

	/**
	 * {tableName}/delete/{id} のurl取得
	 * @return
	 */
	public String getTableSyncDeleteUrl(String talbeName, Integer id) {
		return UriComponentsBuilder.fromHttpUrl(url)
				.pathSegment(talbeName, DELETE, id.toString())
				.build()
				.toUriString();
	}

}
