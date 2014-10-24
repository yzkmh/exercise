/*-------------------------------------------------------------------------
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：杨照昆	
 * 联系方式：yangzhaokun@gyyx.cn
 * 创建时间：2014年10月23日 下午3:17:23
 * 版本号：v1.0
 * 本类主要用途描述：
 *  -------------------------------------------------------------------------*/




package cn.gyyx.java.model;

public class Game {
	
	private int id;
	private String username;
	private String password;
	private String age;
	private String sex;
	private String mail;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
