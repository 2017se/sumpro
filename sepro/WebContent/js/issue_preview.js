/**
 * 
 */
$(document).ready(function(){
	
	var userid=$("input[name='userid']").val();
	var url="publishQuestionnaire.action?userId="+userid;
	
	$("#issue").click(function(){
		var array_answers = [];
		
		var date=$("input[name='date']").val();
		var questionnaireid=$("input[name='questionnaireid']").val();
		
		
		var begintime=$("input[name='issueTime']").val();
		var endtime=$("input[name='endTime']").val();
		
		
		if(date>begintime){
			alert("发布时间必须早于此刻");
			return;
		}
		jQuery.ajax({
			url:"publishQuesAction",
			type:'POST',
			data:{
				questionnaireId:questionnaireid,
				set_date:begintime,
				end_date:endtime
			},
			success:function(data){
				alert(data);
				$(location).attr('href', url);
			}
		});
	});
	
	$("#return").click(function(){
		$(location).attr('href', url);
	});
});