package com.example.MessageMemo;
//2.@Entityモデルを作成する


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_CUSTOMER")

public class MessageCustomer {
	
	@Id
	
	//顧客コード
	@Column(name="C_CD" ,columnDefinition = "VARCHAR(4)")
	private String c_num;
	
	//顧客名
	@Column(name="C_NAME" ,nullable = false ,columnDefinition = "VARCHAR(100)")
	private String c_name;
	
	//住所
	@Column(name="ADDRESS" ,columnDefinition = "VARCHAR(256)")
	private String address;
	
	//電話番号
	@Column(name="TEL" ,columnDefinition = "VARCHAR(11)")
	private String tel;

	//更新日時
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")
	private Timestamp update_date;

	//更新者
	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;

	//作成日時
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;

	//作成者
	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	
	//入力された値をget変数に代入し、引数にsetする
	
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	//更新日時、更新者、作成日時、作成者のセット

	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

}
