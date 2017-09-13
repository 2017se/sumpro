/**
 * saveQuestionnaire
 * 1.和后端交互的变量名应保持一致，data和options，questions列表结构保持一致；
 * 2.不需要指定questionnaire的id,one_question的id和q_id,以及q_options的q_id；
 * 3.需要用JSON.Stringify()将js列表转化为JSON字符串，但只用一次；
 * */

$(function(){
$("#submit-questionnaire").click(function(e){
	var array_questions = [];
	for(var j = 0; j<2;j++){
		var array_options = [];
		for(var i = 0; i <3 ;i++){
			var option = {
				title : "A", //变量名一致
				property : "option" //变量名一致
			};
			array_options.push(option);
		}
		
		var question = {
			title_num : "6", //变量名一致（题号）
			stem : "stem-test", //变量名一致
			type : "0", //变量名一致
			nessecity : "1", //变量名一致
			options : array_options //变量名一致
		};
		array_questions.push(question);
	}
	jQuery.ajax({
		url : 'saveQuestionnaire',
		type : 'POST', //post
		dataType : "json", //需要指定为json
		data: {
			u_id : "4", //变量名一致
			title : "title-test", //变量名一致
			instruction : "instruction", //变量名一致
			set_date : "2017-7-1 11:22:22", //变量名一致，日期格式："yyyy-mm-dd"
			end_date : "2017-7-22 11:22:22", //变量名一致，日期格式："yyyy-mm-dd"
			questions : JSON.stringify(array_questions) //变量名一致，用JSON.Stringify()封装且只封装一次
		},
		success : function(data){
			alert("success");
		}
	});
});


/**
 * saveAnswer
 * 1.和后端交互的变量名应保持一致，data和answers列表结构保持一致；
 * 2.不需要设置answer_questionnaire的questionnaire属性，但要求其他属性不为空
 * 3.需要用JSON.Stringify()将js列表转化为JSON字符串，但只用一次；
 * */
$("#submit-answer").click(function(e){
	var array_answers = [];
	for(var j = 0; j<1;j++){
		var answer = {
			u_id : "4", //变量名一致（题号）
			o_id : "1", //变量名一致
			answer : "answer-test", //变量名一致
		};
		array_answers.push(answer);
	}
	jQuery.ajax({
		url : 'saveAnsQues',
		type : 'POST', //post
		dataType : "json", //需要指定为json
		data: {
			u_id : "4", //变量名一致
			q_id : "1", //变量名一致,questionnaire_id
			submit_time : "2017-7-1 22:22:22", //变量名一致，日期格式："yyyy-mm-dd"
			if_complete : "1", //变量名一致
			answers : JSON.stringify(array_answers) //变量名一致，用JSON.Stringify()封装且只封装一次
		},
		success : function(data){
			alert("success");
		}
	});
});


/**
 * 发布问卷
 * url不要写成publishQuestionnaire，publishQuestionnaire是跳转到“发布问卷”页面的action
 * */
$("#publish").click(function(e){
	jQuery.ajax({
		url:'publishQuesAction',
		type:'POST',
		data:{
			questionnaireId:"1",
			set_date:"2017-04-19 09:00:09",
			end_date:"2017-09-09 00:00:00"
		},
		success:function(data){
			alert(data);
		},
		error:function(data){
			alert(data);
		}
	});
});

$("#download").click(function(e){
	var dataset = e.currentTarget.dataset;
	var imgURL = dataset.url;
	var oPop = window.open(imgURL,"","width=1, height=1, top=5000, left=5000");
	for(; oPop.document.readyState != "complete"; ){
		if (oPop.document.readyState == "complete"){
			break; 
		}
	}
	oPop.document.execCommand("SaveAs"); oPop.close();
});

});