package com.dcr.cms.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumTool {

	private static final Logger logger = LoggerFactory.getLogger(EnumTool.class);

	private Map<String, Map<String, Enum<?>>> enumMapCache = new HashMap<String, Map<String, Enum<?>>>();

	private List<String> packages;

	public Map<String, Enum<?>> getEnumMap(String enumName) {
		Map<String, Enum<?>> map = enumMapCache.get(enumName);
		if (map != null) {
			return map;
		}

		map = new LinkedHashMap<String, Enum<?>>();
		Class<Enum<?>> enumClass = getClassByName(enumName);
		if (enumClass == null) {
			logger.error("can't find class for:" + enumName);
			throw new RuntimeException("can't find class for:" + enumName);
		}
		for (Enum<?> e : enumClass.getEnumConstants()) {
			map.put(e.name(), e);
		}
		enumMapCache.put(enumName, map);
		return map;
	}

	@SuppressWarnings("unchecked")
	private Class<Enum<?>> getClassByName(String name) {
		Class<Enum<?>> enumClass = null;
		try {
			enumClass = (Class<Enum<?>>) Class.forName(name);
		} catch (ClassNotFoundException e1) {
		}
		if (enumClass != null) {
			return enumClass;
		}

		for (String enumPackage : packages) {
			try {
				enumClass = (Class<Enum<?>>) Class.forName(enumPackage + "." + name);
			} catch (ClassNotFoundException e1) {
				continue;
			}
			if (enumClass != null) {
				return enumClass;
			}
		}
		return enumClass;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

}
