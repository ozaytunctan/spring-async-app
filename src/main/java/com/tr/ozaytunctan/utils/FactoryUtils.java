package com.tr.ozaytunctan.utils;

public final class FactoryUtils {

	public static Long tic() {
		return System.currentTimeMillis();
	}

	public static Long toc(Long startTime) {
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
