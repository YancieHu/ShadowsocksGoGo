package com.shadow.bean;

import java.util.ArrayList;

public class ShadowTotalBean {
	private ArrayList<ShadowInfoBean> configs;
	private String strategy;
	private int index;
	private boolean global;
	private boolean enabled;
	private boolean shareOverLan;
	private boolean isDefault;
	private int localPort;
	private String pacUrl;
	private boolean useOnlinePac;

	public ShadowTotalBean() {
		// strategy = "com.shadowsocks.strategy.balancing";// 负载均衡
		strategy = "com.shadowsocks.strategy.ha";// 高可用
		index = -1;
		global = false;
		enabled = true;
		shareOverLan = false;
		isDefault = false;
		localPort = 1080;
		pacUrl = null;
		useOnlinePac = false;
	}

	public ArrayList<ShadowInfoBean> getConfigs() {
		return configs;
	}

	public void setConfigs(ArrayList<ShadowInfoBean> configs) {
		this.configs = configs;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isShareOverLan() {
		return shareOverLan;
	}

	public void setShareOverLan(boolean shareOverLan) {
		this.shareOverLan = shareOverLan;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	public String getPacUrl() {
		return pacUrl;
	}

	public void setPacUrl(String pacUrl) {
		this.pacUrl = pacUrl;
	}

	public boolean isUseOnlinePac() {
		return useOnlinePac;
	}

	public void setUseOnlinePac(boolean useOnlinePac) {
		this.useOnlinePac = useOnlinePac;
	}

}
