package me.coding.gavinhill.domain;

import java.io.Serializable;

/**
 * 用户登录类，定义基本属性用户名和密码
 */
public class User implements Serializable{
	
	//默认序列化版本，系统自动生成
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String useraccount;
    private String userpsword;
    private String username;
    private String usertel;
    
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
    public String getUseraccount(){
        return this.useraccount;
    }
    public void setUseraccount(String useraccount){
        this.useraccount = useraccount;
    }
    
    public String getUserpsword(){
        return this.userpsword;
    }
    public void setUserpsword(String userpsword){
        this.userpsword = userpsword;
    }
    
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsertel(){
        return this.usertel;
    }
    public void setUsertel(String usertel){
        this.usertel = usertel;
    }
}
