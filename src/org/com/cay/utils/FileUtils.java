package org.com.cay.utils;

import java.util.UUID;

public class FileUtils {

	public static String getUUIDName(String fileName) {
		int index = fileName.lastIndexOf('.');
		fileName = fileName.substring(index, fileName.length());

		String uuid = UUID.randomUUID().toString().replace("-", "");

		return uuid + fileName;
	}
}
