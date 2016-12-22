package com.shadow.page;

import java.io.IOException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.shadow.bean.ShadowInfoBean;
import com.shadow.bean.ShadowTotalBean;
import com.shadow.util.HttpHeader;
import com.shadow.util.Log;
import com.shadow.util.ShadowPage;

public class Doubishadowsocks extends ShadowPage {

	public static void parseInfo(ArrayList<ShadowInfoBean> beans) {
		try {
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			Document doc = HttpHeader
					.init(Jsoup.connect("https://www.dou-bi.co/sszhfx/"))
					.ignoreHttpErrors(true).get();
			Elements elements = doc.select("tbody").get(0).select("tr"); // 带有href属性的a元素
			for (int i = 0; i < elements.size(); i++) {
				Elements elements2 = elements.get(i).select("td");
				if (elements2.size() == 6) {
					ShadowInfoBean infoBean = new ShadowInfoBean();
					try {
					infoBean.setMethod(elements2.get(4).text());
					infoBean.setPassword(elements2.get(3).text());
					infoBean.setRemarks(System.currentTimeMillis() + "");
					infoBean.setServer(elements2.get(1).text());
					
						infoBean.setServer_port(Integer.parseInt(elements2.get(
								2).text()));
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
