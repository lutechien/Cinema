package model;

import java.io.Serializable;

public class Member implements Serializable{
	
	private Integer id;
	private String memberno;
	private String name;
	private String username;
	private String password;
	private Integer cash;
	
	public Member() {
		super();
	}

	public Member(String memberno, String name, String username, String password) {
		super();
		this.memberno = memberno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.cash = cash;
	}

	public Member(String memberno, String name, String username, String password,Integer cash) {
		super();
		this.memberno = memberno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.cash = cash;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMemberno() {
		return memberno;
	}


	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public Integer getCash() {
		return cash;
	}


	public void setCash(Integer cash) {
		this.cash = cash;
	}
	
	
	
	

}
