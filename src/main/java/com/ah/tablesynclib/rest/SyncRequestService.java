package com.ah.tablesynclib.rest;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ah.tablesynclib.bean.TableSyncRequestBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SyncRequestService {

	private final SyncRequestEntityFactory entityFactory;
	private final SyncRequestEndpointProperties endpointProperties;

	private final RestTemplate rest = new RestTemplate();
	
	private final String TALBENAME_APARTROWNER = "apartowners";
	private final String TALBENAME_APARTMENT = "apartments";

	/**
	 * [apartowner登録時] table syncサービスへapartownerテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartownerInsert(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncInsertUrl(TALBENAME_APARTROWNER);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPostEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apartowner更新時] table syncサービスへapartownerテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartownerUpdate(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncUpdateUrl(TALBENAME_APARTROWNER);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPutEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apartowner削除時]  table syncサービスへapartownerテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartownerDelete(Integer apartownerId) {
		String url = endpointProperties.getTableSyncDeleteUrl(TALBENAME_APARTROWNER, apartownerId);
		RequestEntity<Void> reqEntity = entityFactory.getDeleteEntity(url);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apartment登録時] table syncサービスへapartmentテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartmentInsert(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncInsertUrl(TALBENAME_APARTMENT);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPostEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apartment更新時] table syncサービスへapartmentテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartmentUpdate(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncUpdateUrl(TALBENAME_APARTMENT);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPutEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apartment削除時]  table syncサービスへapartmentテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartmentDelete(Integer apartownerId) {
		String url = endpointProperties.getTableSyncDeleteUrl(TALBENAME_APARTMENT, apartownerId);
		RequestEntity<Void> reqEntity = entityFactory.getDeleteEntity(url);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
}
