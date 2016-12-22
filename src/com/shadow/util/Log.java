package com.shadow.util;

public class Log {
	public static void v(String info, String log) {
		System.out.println(info + "--->" + log);
	}

	public static void v(String log) {
		v("", log);
	}
}
