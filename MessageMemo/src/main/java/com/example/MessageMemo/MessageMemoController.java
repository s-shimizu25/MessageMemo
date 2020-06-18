package com.example.MessageMemo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;


@Controller 
public class MessageMemoController {
	@Autowired
	private MessageMemoRepository messageMemoRepository;
	
	@Autowired
	private MessageEmployeeRepository messageEmployeeRepository;
	
	@Autowired
	private MessageCustmerRepository messageCustomerRepository;
	
	@Autowired
	private MessageMemoRepository rep;
	
	


	
	@RequestMapping("/msgmemo/inputForm")
    public String index(Model model){
	
		// M_CUSTOMERテーブルの全データを取得
		Iterable<MessageEmployee> employeeList = messageEmployeeRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("employeeList",employeeList);
		
		Iterable<MessageCustomer> customerList = messageCustomerRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("customerList",customerList);

		// データ一覧画面(html)を表示
		model.addAttribute("click", false);
		return "index.html";
	}
	
	
	
	
	
	
	//伝言メモの登録
	
		@PostMapping(path="/msgmemo/inputForm")
		public String addNewMessageMemo(	  Model model
														, @RequestParam String to_name //宛先者氏名
														, @RequestParam String yyyy
														, @RequestParam String MM
														, @RequestParam String dd
														, @RequestParam (value="receiv_ampm", required=false)int receiv_ampm //AM,PM　　　
														, @RequestParam String hh
														, @RequestParam String mm
														, @RequestParam String c_name //顧客コード
														, @RequestParam String sender //発信者氏名
														, @RequestParam String check
														, @RequestParam String memo 
														, @RequestParam String e_name) { //従業員コード
			
			//AMPM判断
			if(receiv_ampm == 1) {
				int h = Integer.parseInt(hh);
				h = h + 12;
				hh = String.valueOf(h);
			}else if(receiv_ampm == 0) {
				int h = Integer.parseInt(hh);
				hh = String.valueOf(h);
			}
			
			
			//自動採番
			int countT_message = 0;
			int ctm = rep.findT_message();
			if(rep.findT_message() == 0) {
				countT_message = 1;
			}else{
				countT_message = ctm + 1;
			}
			
			
			
		
		try {
			
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			String receiv_time = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm;
			Date date = sdf.parse(receiv_time);
			
			Timestamp ts = new Timestamp(date.getTime());
			

		
		
			//messageMemoAddDataに代入
			MessageMemo messageMemoAddData = new MessageMemo();			//customerAddDataオブジェクトの生成
			messageMemoAddData.setAll(countT_message, to_name, e_name, ts, c_name, sender, check, memo);	//引数の代入
			
			
			
			
			//作成日時、作成者、更新日時、更新者の代入
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			messageMemoAddData.setCreate_date(timestamp);
			messageMemoAddData.setCreate_user("springuser");
			messageMemoAddData.setUpdate_date(timestamp);
			messageMemoAddData.setUpdate_user("springuser");
			
			messageMemoRepository.save(messageMemoAddData);
			
			
			
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
		}
		Iterable<MessageEmployee> employeeList = messageEmployeeRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("employeeList",employeeList);
		
		Iterable<MessageCustomer> customerList = messageCustomerRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("customerList",customerList);
			
			model.addAttribute("msg", to_name + "さん宛てのメッセージを登録しました");
			return "index.html";
		}

}


	
	