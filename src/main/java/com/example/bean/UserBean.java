package com.example.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザDto
 * @author 暢人
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestScoped
@Named(value = "userBean")
public class UserBean implements Serializable {

	/**
	 * シリアルバージョンUID
	 */
	private static final long serialVersionUID = 2674698136628131650L;

	private String name;

	private String password;

	private String auth;

	private boolean isSuccess;
}
