package com.ah.tableSyncLib.bean;

import com.ah.tableSyncLib.util.EntityUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableSyncRequestBean {

	private String talbeName;

	private EntityUtil.methodEnum method;

	private Object data;

}
