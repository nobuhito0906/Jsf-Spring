package com.example.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.interceptor.LoginAspect;
import com.example.service.LoginService;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 暢人
 *
 */
@SessionScoped
@ManagedBean(value = "loginManagedBean")
public class LoginManagedBean implements Serializable {

	/**
	 * シリアルバージョン
	 */
	private static final long serialVersionUID = 5852789692448178228L;

	@Autowired
	private LoginService loginService;
	
	@Inject
	private UserBean userBean;

	//なぜかデバッグログが出力されない
	Logger log = LoggerFactory.getLogger(LoginManagedBean.class);

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String password;

	@Autowired
	private NavigationBean navigationBean;
	

	@PostConstruct
	public void init() {

		log.info("#######init ###########");
	}

	@LoginAspect
	public String login() {
		log.info("LOGIN!!! name:{} pass:{}", name, password);
		UserBean bean = loginService.login(name, password);
		if (bean.isSuccess()) {
			userBean.setName(name);
			userBean.setPassword(password);
			userBean.setAuth(bean.getAuth());
			return navigationBean.successLogin();
		}
		return navigationBean.toLogin();
	}
}
