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

	/**
	 * [登録時] table syncサービスへapartownerテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartownerInsert(TableSyncRequestBean body) {
		String url = endpointProperties.getApartownerInsert();
		System.out.println(url);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPostEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [更新時] table syncサービスへapartownerテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartownerUpdate(TableSyncRequestBean body) {
		String url = endpointProperties.getApartownerUpdate();
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPutEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [削除時]  table syncサービスへapartownerテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartownerDelete(Integer apartownerId) {
		String url = endpointProperties.getApartownerDelete(apartownerId);
		RequestEntity<Void> reqEntity = entityFactory.getDeleteEntity(url);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
}
