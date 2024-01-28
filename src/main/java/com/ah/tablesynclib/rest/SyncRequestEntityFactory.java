package com.ah.tablesynclib.rest;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

import com.ah.tablesynclib.bean.TableSyncRequestBean;

@Component
public class SyncRequestEntityFactory {

	/**
	 * POST メソッドのRequestEntityの作成メソッド
	 * 
	 * @param url  String リクエストエンドポイント
	 * @param body TableSyncRequestBean リクエストボディ
	 * @return RequestEntity
	 */
	public RequestEntity<TableSyncRequestBean> getPostEntity(String url, TableSyncRequestBean body) {
		HttpHeaders header = new HttpHeaders();
		RequestEntity<TableSyncRequestBean> restEntity = RequestEntity.post(URI.create(url)).headers(header).body(body);

		return restEntity;
	}
	
	/**
	 * PUT メソッドのRequestEntityの作成メソッド
	 * 
	 * @param url  String リクエストエンドポイント
	 * @param body TableSyncRequestBean リクエストボディ
	 * @return RequestEntity
	 */
	public RequestEntity<TableSyncRequestBean> getPutEntity(String url, TableSyncRequestBean body) {
		HttpHeaders header = new HttpHeaders();
		RequestEntity<TableSyncRequestBean> restEntity = RequestEntity.put(URI.create(url)).headers(header).body(body);

		return restEntity;
	}
	
	/**
	 * DELETE メソッドのRequestEntityの作成メソッド
	 * 
	 * @param url  String リクエストエンドポイント
	 * @return RequestEntity
	 */
	public RequestEntity<Void> getDeleteEntity(String url) {
		HttpHeaders header = new HttpHeaders();
		RequestEntity<Void> restEntity = RequestEntity.delete(URI.create(url)).headers(header).build();

		return restEntity;
	}
}
