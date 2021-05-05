package com.example.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 暢人
 *
 */
//@ManagedBean(value = "navigationBean")
//@SessionScoped
@Component
@Slf4j
public class NavigationBean implements Serializable {

	/**
	 * シリアルバージョンUID
	 */
	private static final long serialVersionUID = 219809925448139431L;

	public String toLogin() {
		return "/login.xhtml";
	}

	public String successLogin() {
		log.info("Success!!!!!!!!!!!!!!!!!!");
		return "/result.xhtml";
	}

}
