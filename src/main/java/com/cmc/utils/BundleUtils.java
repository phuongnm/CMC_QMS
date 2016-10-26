package com.cmc.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleUtils {
	private static ResourceBundle rsConfig = null;
	private static final String MESSAGE = "messages";

	public static String getString(String key, Locale... locale) {
		try {
			if (locale != null) {
				rsConfig = ResourceBundle.getBundle(MESSAGE, locale[0]);
			} else {
				rsConfig = ResourceBundle.getBundle(MESSAGE, new Locale("en"));
			}

			return rsConfig.getString(key);
		} catch (Exception e) {
			return key;
		}
	}
}
