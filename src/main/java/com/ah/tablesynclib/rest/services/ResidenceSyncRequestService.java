package com.ah.tablesynclib.rest.services;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ah.tablesynclib.bean.TableSyncRequestBean;
import com.ah.tablesynclib.rest.SyncRequestEndpointProperties;
import com.ah.tablesynclib.rest.SyncRequestEntityFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResidenceSyncRequestService {

	private final SyncRequestEntityFactory entityFactory;
	private final SyncRequestEndpointProperties endpointProperties;
	
	private final RestTemplate rest = new RestTemplate();
	
	private final String TABLENAME_ADDRESSERRESIDENCES = "addresser_residences";
	private final String TABLENAME_APARTRESIDENCES = "apart_residences";
	
	/**
	 * [addresser_residences登録時] table syncサービスへaddresser_residencesテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncAddresserResidenceInsert(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncInsertUrl(TABLENAME_ADDRESSERRESIDENCES);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPostEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [addresser_residences更新時] table syncサービスへaddresser_residencesテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncAddresserResidenceUpdate(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncUpdateUrl(TABLENAME_ADDRESSERRESIDENCES);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPutEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [addresser_residences削除時]  table syncサービスへaddresser_residencesテーブルの同期リクエストを送る。
	 * @param id
	 * @return
	 */
	public String syncAddresserResidenceDelete(Integer id) {
		String url = endpointProperties.getTableSyncDeleteUrl(TABLENAME_ADDRESSERRESIDENCES, id);
		RequestEntity<Void> reqEntity = entityFactory.getDeleteEntity(url);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	
	/**
	 * [apart_residences登録時] table syncサービスへapart_residencesテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartResidenceInsert(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncInsertUrl(TABLENAME_APARTRESIDENCES);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPostEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apart_residences更新時] table syncサービスへapart_residencesテーブルの同期リクエストを送る。
	 * @param body
	 * @return
	 */
	public String syncApartResidenceUpdate(TableSyncRequestBean body) {
		String url = endpointProperties.getTableSyncUpdateUrl(TABLENAME_APARTRESIDENCES);
		RequestEntity<TableSyncRequestBean> reqEntity = entityFactory.getPutEntity(url, body);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
	
	/**
	 * [apart_residences削除時]  table syncサービスへapart_residencesテーブルの同期リクエストを送る。
	 * @param id
	 * @return
	 */
	public String syncApartResidenceDelete(Integer id) {
		String url = endpointProperties.getTableSyncDeleteUrl(TABLENAME_APARTRESIDENCES, id);
		RequestEntity<Void> reqEntity = entityFactory.getDeleteEntity(url);

		ResponseEntity<String> res = rest.exchange(reqEntity, String.class);
		return res.getBody();
	}
}
