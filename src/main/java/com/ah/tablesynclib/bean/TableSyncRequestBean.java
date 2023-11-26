package com.ah.tablesynclib.bean;


import com.ah.commonlib.EntityUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableSyncRequestBean {

	private String talbeName;

	private EntityUtil.methodEnum method;

	private Object data;

}
