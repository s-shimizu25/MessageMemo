package com.example.MessageMemo;
//2.@Entityモデルを作成する

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_MESSAGE")

public class MessageMemo{

	@Id
	
	//メッセージID
	@Column(name="M_ID" , columnDefinition = "int(11)")
	private int m_id;
	
	//宛先者氏名
	@Column(name="TO_NAME" , columnDefinition = "VARCHAR(40)")
	private String to_name;
	
	//受電者コード
	@Column(name="RECEIVER_CD" , columnDefinition = "CHAR(2)")
	private String receiver_cd;
	
	//受電日時
	@Column(name="RECEIV_TIME" , columnDefinition = "datetime")
	private Timestamp receiv_time;
	
	//顧客コード
	@Column(name="CUSTMER_CD" , columnDefinition = "CHAR(2)")
	private String custmer_cd;
	
	//発信者
	@Column(name="SENDER" , columnDefinition = "VARCHAR(40)")
	private String sender;
	
	//メッセージコード
	@Column(name="MESSAGE_CD" , columnDefinition = "CHAR(1)")
	private String message_cd;
	
	//メモ
	@Column(name="MEMO" , columnDefinition = "VARCHAR(256)")
	private String memo;
	
	//作成日時
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;
	
	//作成者
	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	//更新日時
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")
	private Timestamp update_date;
	
	//更新者
	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;
	
	
	
	

	//宛先者氏名
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	
	//受電者コード
	
	public String getReceiver_cd() {
		return receiver_cd;
	}
	
	public void setReceiver_cd(String receiver_cd) {
		this.receiver_cd = receiver_cd;
	}


	//受電日時
	public Timestamp getReceive_time() {
		return receiv_time;
	}
	
	public void setReceive_time(Timestamp receive_time) {
		this.receiv_time = receive_time;
	}
	
	//発信者
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	//メッセージコード
	public String getMessage_cd() {
		return message_cd;
	}
	
	public void setMessage_cd(String message_cd) {
		this.message_cd = message_cd;
	}
	
	//メモ
		public String getMemo() {
			return memo;
		}
		
		public void setMemo(String memo) {
			this.memo = memo;
		}
	
	
	
	public void setAll(  int countT_message
						,String to_name
						,String e_name
						,Timestamp ts
						,String c_name
						,String sender
						,String check
						,String memo
			) {
		this.m_id = countT_message;
		this.to_name = to_name;
		this.receiver_cd =  e_name;
		this.receiv_time = ts; 
		this.custmer_cd = c_name;
		this.sender = sender;
		this.message_cd = check;
		this.memo = memo; 
	}
	
	
	
	//更新日時、更新者、作成日時、作成者のセット
	
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

	
}