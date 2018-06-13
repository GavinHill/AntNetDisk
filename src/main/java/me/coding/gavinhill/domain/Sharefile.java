package me.coding.gavinhill.domain;

import java.io.Serializable;

public class Sharefile implements Serializable {
	private static final long serialVersionUID = 1L;

	String shareid;
	String fileid;
	String souaccount;
	String diraccount;
	
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getSouaccount() {
		return souaccount;
	}
	public void setSouaccount(String souaccount) {
		this.souaccount = souaccount;
	}
	public String getDiraccount() {
		return diraccount;
	}
	public void setDiraccount(String diraccount) {
		this.diraccount = diraccount;
	}

}
