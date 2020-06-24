
//年月日の初期表示
function setDate(){
    let today = new Date();
    let nowYear = today.getFullYear();
    let nowMonth = today.getMonth()+1;
    let nowDay = today.getDate();

    document.getElementById("y").value=nowYear;
    document.getElementById("m").value=nowMonth;
    document.getElementById("d").value=nowDay;
}


//伝言あり以外の時、テキストボックスを非活性化
function cantWrite(){
  let obj = document.getElementById("text");
  if(obj.readOnly == false){      //readonlyが解除されている時
    obj.readOnly = true; 		//readonlyに
    obj.value="";
  }
}

//伝言ありの時、テキストボックスを活性化
function canWrite(){
    let obj = document.getElementById("text");
    if(obj.readOnly == true){      //readonlyの時
    	obj.readOnly = false;        //readonlyを解除
    }else{
    	obj.readOnly = true;
    	obj.value="";
    }
}




//時間の初期表示
function setTime(){
  let time = new Date();
  let hour = time.getHours();
  let minute = time.getMinutes();

  if(0<=hour && hour<=12){
	    document.getElementById("am").checked=true;
	  }else if(13<=hour && hour<=23){
	    document.getElementById("pm").checked=true;
	  }


  if(hour>12){
    hour= hour - 12;
  }

 
  document.getElementById("hour").value=hour;
  document.getElementById("minute").value=minute;
  
}


//入力チェック（チェックボックス、テキストボックス）
function checkForm(){
  let flag = 0;
  if( document.checks.c1.checked==false && document.checks.c2.checked==false && document.checks.c3.checked==false){
    flag = 1;
    document.getElementById('memo').textContent="チェックを入れてください";
    } else if(document.checks.memo.value=="" && document.checks.c3.checked==true){
    flag = 1;
    document.getElementById('memo').textContent="テキストを入力してください";
  }
  if(flag){
    return false;
  }else{
    return true;
  }
  
}

//チェックボックスの複数選択不可処理
function checkbox(){
	document.forms['form'].elements['c1'].onclick=ckbox1;
	document.forms['form'].elements['c2'].onclick=ckbox2;
	document.forms['form'].elements['c3'].onclick=ckbox3;
	}
	function ckbox1(){
	document.forms['form'].elements['c2'].checked=false;
	document.forms['form'].elements['c3'].checked=false;
	}
	function ckbox2(){
	document.forms['form'].elements['c1'].checked=false;
	document.forms['form'].elements['c3'].checked=false;
	}
	function ckbox3(){
	document.forms['form'].elements['c1'].checked=false;
	document.forms['form'].elements['c2'].checked=false;
	}
	
	