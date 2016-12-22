package com.shadow.util;

import org.jsoup.nodes.Element;

public class SplitElement {
	public static String work(Element element) {
		if (element != null) {
			String lala = element.text();
			String[] strings = lala.split("£º");
			if(strings.length<2){
				strings=lala.split(":");
			}
			return strings[1];
		}
		return "";
	}
}
