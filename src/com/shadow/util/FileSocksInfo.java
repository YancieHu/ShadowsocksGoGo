package com.shadow.util;

import java.util.ArrayList;

import com.shadow.bean.ShadowInfoBean;

public class FileSocksInfo {
	// ip@端口@密码@方法
	private static String info1 = "23.106.133.126@55501@zljw5501@aes-256-cfb";
	private static String info2 = "ss.rainman.me@54082@hVUme2kq9Rw3@aes-256-cfb";
	private static String info3 = "104.160.38.95@443@MGY4M2ViNT@aes-256-cfb";
	private static String info4 = "139.162.98.95@30067@840734@aes-256-cfb";
	private static String info5 = "45.62.113.207@443@laozhang@aes-256-cfb";

	private static ShadowInfoBean createBean(String info) {
		String[] infos = info.split("@");
		ShadowInfoBean infoBean = new ShadowInfoBean();
		infoBean.setServer(infos[0]);
		infoBean.setServer_port(infos[1]);
		infoBean.setPassword(infos[2]);
		infoBean.setMethod(infos[3]);
		return infoBean;
	}

	public static void addBean2List(ArrayList<ShadowInfoBean> infoBeans) {
		infoBeans.add(createBean(info1));
		infoBeans.add(createBean(info2));
		infoBeans.add(createBean(info3));
		infoBeans.add(createBean(info4));
		infoBeans.add(createBean(info5));
	}
}
