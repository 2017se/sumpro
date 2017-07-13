/**
 * 
 */
$(document).ready(function(){

$("#submit-answer").click(function(e){
	
	var array_answers = [];
	
	var quesnum=$("input[name='quesnum']").val();
	var date=$("input[name='date']").val();
	var userid=$("input[name='userid']").val();
	var questionnaireid=$("input[name='questionnaireid']").val();

	
	for(var j = 1; j<quesnum+1;j++){
		var type=$("input[name='T"+j+"']").val();
		var questionid=$("input[name='I"+j+"']").val();
		if(type==0){
			var Qanswer=$("input[name='"+j+"']:checked").val();
		}
		else if(type==1){
			var Qanswer="";
			$("input[name='"+j+"']:checked").each(function(){
				Qanswer=Qanswer+($(this).val());
			});
		}
		else{
			var Qanswer=$("input[name='"+j+"']").val();
		}
		var answer = {
			u_id : userid, //变量名一致(userid)
			o_id : questionid, //变量名一致(one_question_id)
			answer : Qanswer, //变量名一致
		};
		array_answers.push(answer);
	}
	
	jQuery.ajax({
		url : 'saveAnsQues',
		type : 'POST', //post
		dataType : "json", //需要指定为json
		data: {
			u_id : userid, //变量名一致(userid)
			q_id : questionnaireid, //变量名一致,questionnaire_id
			submit_time : date, //变量名一致，datetime格式："yyyy-mm-dd hh:mm:ss"
			if_complete : "1", //变量名一致
			answers : JSON.stringify(array_answers) //变量名一致，用JSON.Stringify()封装且只封装一次
		},
		success : function(data){
			alert("success");
		}
	});
});

});