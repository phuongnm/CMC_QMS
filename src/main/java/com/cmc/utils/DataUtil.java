package com.cmc.utils;

import java.util.List;

public class DataUtil {

	public static boolean isStringNullOrEmpty(Object obj1) {
		return obj1 == null || obj1.toString().trim().equals("");
	}

	public static boolean isNullOrEmpty(Object obj1) {
		return obj1 == null || obj1.toString().trim().equals("");
	}

	public static boolean isListNullOrEmpty(List<?> lst) {
		return lst == null || lst.isEmpty();
	}

	public static String getGetterByColumnName(String columnName) {
		return "get" + getHibernateName(columnName);
	}

	public static String getGetterOfColumn(String column) {
		return "get" + upperFirstChar(column);

	}

	public static String getSetterOfColumn(String column) {
		return "set" + upperFirstChar(column);

	}

	public static String getHibernateName(String columnName) {
		columnName = columnName.toLowerCase();
		String[] arrs = columnName.split("_");
		String method = "";
		for (String arr : arrs) {
			method += DataUtil.upperFirstChar(arr);
		}
		return method;
	}

	public static String upperFirstChar(String input) {
		if (DataUtil.isStringNullOrEmpty(input)) {
			return input;
		}
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
}
