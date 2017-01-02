package com.shadow.util;

import java.io.IOException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.shadow.bean.ShadowInfoBean;
import com.shadow.bean.ShadowTotalBean;
import com.shadow.page.Freessr;
import com.shadow.page.Freevpnss;
import com.shadow.page.Doubishadowsocks;
import com.shadow.page.Info51ss;
import com.shadow.page.Ishadowsocks;

public class HelloWorld {
	public static String rootFile = "D:/fanqiang";
	public static String ssFile = rootFile + "/Shadowsocks.exe";
	public static String cfFile = rootFile + "/gui-config.json";

	public static void main(String[] args) throws IOException {
		pcWork();
		// getInfo();
	}

	public static void pcWork() {
		ShadowTotalBean shadowTotalBean = getInfo();
		String text = JSON.toJSONString(shadowTotalBean);
		IOUtil.fileWriterHandle(cfFile, text);
		IOUtil.closeExe();
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IOUtil.doExe(ssFile);
	}

	public static ShadowTotalBean getInfo() {
		ShadowTotalBean shadowTotalBean = new ShadowTotalBean();
		ArrayList<ShadowInfoBean> beans = new ArrayList<ShadowInfoBean>();
		FileSocksInfo.addBean2List(beans);
		Ishadowsocks.parseInfo(beans);
		Freessr.parseInfo(beans);
		Doubishadowsocks.parseInfo(beans);
		Freevpnss.parseInfo(beans);
		shadowTotalBean.setConfigs(beans);
//		Info51ss.parseInfo(beans);
		return shadowTotalBean;
	}

}
