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
import com.shadow.util.ShadowPage;
import com.shadow.util.SplitElement;

public class Freevpnss extends ShadowPage {
	public static void parseInfo(ArrayList<ShadowInfoBean> beans) {
		try {
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			Document doc = HttpHeader
					.init(Jsoup.connect("https://freevpnss.cc/"))
					.ignoreHttpErrors(true).get();
			Elements elements = doc.getElementsMatchingOwnText("服务器");
			for (int i = 0; i < elements.size(); i++) {
				Element element = elements.get(i);
				Elements childNodes = element.parent().children();
				if (childNodes.size() == 5) {
					ShadowInfoBean infoBean = new ShadowInfoBean();
					try {
						infoBean.setServer(SplitElement.work(childNodes.get(0)));

						infoBean.setServer_port(Integer.parseInt(SplitElement
								.work(childNodes.get(1))));
						infoBean.setPassword(SplitElement.work(childNodes
								.get(2)));
						infoBean.setMethod(SplitElement.work(childNodes.get(3)));
						infoBean.setRemarks(System.currentTimeMillis() + "");
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
