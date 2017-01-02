package com.shadow.page;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.shadow.bean.ShadowInfoBean;
import com.shadow.util.HttpHeader;
import com.shadow.util.Log;
import com.shadow.util.ShadowPage;
import com.shadow.util.SplitElement;

public class Info51ss extends ShadowPage {
	public static void parseInfo(ArrayList<ShadowInfoBean> beans) {
		try {
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			Document doc = HttpHeader
					.init(Jsoup.connect("https://51ss.info/?cat=1"))
					.ignoreHttpErrors(true).get();
			Elements elements = doc.getElementsMatchingOwnText("继续阅读");
			for (int i = 0; i < elements.size(); i++) {
				Element element = elements.get(i);
				String url = element.attr("href");
				goPage(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void goPage(String url) throws Exception {
		Document doc = HttpHeader.init(Jsoup.connect(url))
				.ignoreHttpErrors(true).get();
		Elements elements = doc.select("br");
		List<Node> nodes = elements.get(0).parentNode().childNodes();
		// &nbsp;
		Element element1 = elements.get(0).parent();
		String lala2 = element1.outerHtml();
		String lala3 = lala2.replace("&nbsp;", "");
		// <p>Your Server IP : 203.78.140.42<br> Your Server Port : 3456<br>
		// Your Password : vpsmm.com<br> Your Encryption Method: aes-256-cfb<br>
		// Protocol : origin<br> obfs : plain</p>
		String[] list1 = lala3.split("<br>");
		for (int i = 0; i < list1.length; i++) {
			String maohao = list1[i];
			String[] list2 = maohao.split(":");
			String gao=list2[1];
			String [] list3=gao.split(".");
			if(list3.length>2){
				
			}
		}
	}
}
