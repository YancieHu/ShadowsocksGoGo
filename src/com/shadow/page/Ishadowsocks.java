package com.shadow.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.shadow.bean.ShadowInfoBean;
import com.shadow.bean.ShadowTotalBean;
import com.shadow.util.HttpHeader;
import com.shadow.util.IOUtil;
import com.shadow.util.Log;
import com.shadow.util.ShadowPage;
import com.shadow.util.SplitElement;

public class Ishadowsocks extends ShadowPage {
	public static void parseInfo(ArrayList<ShadowInfoBean> beans) {
		try {
			// trustAllHttpsCertificates();
			// HttpsURLConnection.setDefaultHostnameVerifier(hv);
			Document doc = HttpHeader
					.init(Jsoup.connect("http://www.ishadowsocks.info/"))
					.ignoreHttpErrors(true).get();
			Elements elements = doc.select("div.col-sm-4.text-center"); // 带有href属性的a元素
			for (int i = 0; i < elements.size(); i++) {
				Element element = elements.get(i);
				Elements elements2 = element.select("h4");
				if (elements2.size() == 6) {
					ShadowInfoBean infoBean = new ShadowInfoBean();
					try {
						infoBean.setMethod(SplitElement.work(elements2.get(3)));
						infoBean.setPassword(SplitElement.work(elements2.get(2)));
						infoBean.setRemarks(System.currentTimeMillis() + "");
						infoBean.setServer(SplitElement.work(elements2.get(0)));
						Log.v(SplitElement.work(elements2.get(1)));
						infoBean.setServer_port(Integer.parseInt(SplitElement
								.work(elements2.get(1))));
					} catch (Exception e) {
						continue;
					}
					beans.add(infoBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
