package com.example.context;

import lombok.Getter;

/**
 * ユーザEnum.
 * @author 暢人
 *
 */
@Getter
public enum Users {
	USER1("kato", "000001", "RW"), USER2("sato", "000002", "RW"), USER3("ito", "000003", "RO");

	private String name;

	private String password;

	private String auth;

	Users(String name, String password, String auth) {
		this.name = name;
		this.password = password;
		this.auth = auth;
	}
}
