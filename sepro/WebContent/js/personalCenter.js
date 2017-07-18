$(function(){
	
	$(".user-info-edit").click(function(e){
		
		if(e.currentTarget.innerHTML == "[ 编辑 ]"){
			var obj_username = document.getElementById("user-info-username");
			var username_input = document.createElement("input");
			username_input.name = "username";
			username_input.value = obj_username.innerHTML;
			obj_username.innerHTML = "";
			obj_username.appendChild(username_input);
		
			var obj_mail = document.getElementById("user-info-mail");
			var mail_input = document.createElement("input");
			mail_input.name="mail";
			mail_input.value = obj_mail.innerHTML;
			obj_mail.innerHTML = "";
			obj_mail.appendChild(mail_input);
		
			var obj_name = document.getElementById("user-info-name");
			var name_input = document.createElement("input");
			name_input.name="name";
			name_input.value = obj_name.innerHTML;
			obj_name.innerHTML = "";
			obj_name.appendChild(name_input);
		
			var obj_phone = document.getElementById("user-info-phone");
			var phone_input = document.createElement("input");
			phone_input.name="phone";
			phone_input.value = obj_phone.innerHTML;
			obj_phone.innerHTML = "";
			obj_phone.appendChild(phone_input);
		
			var obj_qq = document.getElementById("user-info-qq");
			var qq_input = document.createElement("input");
			qq_input.name="qq";
			qq_input.value = obj_qq.innerHTML;
			obj_qq.innerHTML = "";
			obj_qq.appendChild(qq_input);
		
			e.currentTarget.innerHTML = "[ 保存 ]";
		}
		else{
			var submit_button = document.getElementById("user-info-submit");
			submit_button.submit();
		}
	});
	
	$(".questionnaire-created").click(function(e){
		var dataset = e.currentTarget.dataset;
		var quesid = dataset.quesid;
		var obj = document.getElementById("get-questionnaire");
		$("input[name='questionnaireId']").val(quesid);
		obj.submit();
	});
	
	
	$(".answer-questionnaire").click(function(e){
		var dataset = e.currentTarget.dataset;
		var quesid = dataset.quesid;
		var obj = document.getElementById("fill-questionnaire");
		$("input[name='questionnaireId']").val(quesid);
		obj.submit();
	});
});