package com.example.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Service;

import com.example.bean.UserBean;
import com.example.context.Users;

import lombok.extern.slf4j.Slf4j;

/**
 * ログインサービス
 * @author 暢人
 *
 */
@Service
@Slf4j
public class LoginService {

	public UserBean login(String name, String password) {
		for (Users user : Users.values()) {
			if (name.equals(user.getName())) {
				if (password.equals(user.getPassword())) {
					log.info("Same Pass!!!!!!!!!!!!!");
					return new UserBean(name, password, user.getAuth(), true);
				}
			}
		}
		//エラーメッセージ設定
		FacesMessage msg = new FacesMessage("ユーザ名またはパスワードが違います.");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return new UserBean();
	}

	//TODO ログイン画面でIDとパスを入力
	//パスが間違っていたら画面はそのままでエラーツールチップを表示
	//成功したらIDに紐づくユーザ名を返却
	//ログイン履歴を登録
	//ログイン履歴を見れるページを作成
	//ログイン履歴を削除する機能を追加
}
