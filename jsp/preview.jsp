<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.user" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.one_question" %>
<%@ page import="model.q_options" %>
<%@ page import="model.answer_questionnaire" %>
<%@ page import="model.answers" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.min.js"></script>
	<script src="../js/dataTables.bootstrap.min.js"></script>
	<script src="../js/bootbox.min.js"></script>
	
	<script src="../js/saveAnswers.js"></script>
  
  
  <script type="text/javascript">
function setTab(m,n)
{
	var tli=document.getElementById("leftmenu"+m).getElementsByTagName("li");
	var mli=document.getElementById("mcont"+m).getElementsByTagName("ul");
	for(i=0;i<tli.length;i++){    
		tli[i].className=i==n?"hover":"";
		mli[i].style.display=i==n?"block":"none"; 
		}
	}
	</script>
<style type="text/css"> 
.divcss5-top,.divcss5-bottom{width:300px;height:100px;border:1px solid #F00;padding:0px}
.divcss5-bottom{ margin-top:10px}

.aa{ 
	width:120px; 
	float:left;
	position:fixed;
}   
.aa li{
	 padding:5px;
	 cursor:pointer;
} 
.bb{ 
	  width:700px; 
	  float:left; 
	  background:#00ff00;
}
	   
.boxa,.boxb{ margin:0 auto; width:400px;} 
.boxa-l{ float:left; width:280px; height:80px; border:1px } 
.boxa-r{ float:right; width:100px; height:80px; border:1px } 
.boxb{ border:1px ; height:40px;}
	   
nec{color:red}
.box1 {width:70%; float:left; display:inline;}
.box2 {width:30%; float:left; display:inline;}

.leader{ 
	font-family:"斜体";
	font-size:18px;
	width:1200px;
	top:0px;
	position:fixed;
	background-color:#FFF;
}

div{
display:inline
}

submit_location{
position:relative;
left:700px
}

.logo_img{
position:absolute;
top:50px
}

.form-search {
align="right";
font-size:13px;
}



</style>
<title>问卷网</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
<link href="../css/dataTables.bootstrap.css"
	rel="stylesheet">
  </head>
  
	<% 
		answer_questionnaire answer_quesContent=(answer_questionnaire)request.getAttribute("quesContentFilled"); 
		//user user=(user)session.getAttribute("user");
		questionnaire quesContent=answer_quesContent.getQuestionnaire();
		List<answers> answers=answer_quesContent.getAnsList();
	%>

	   <body>
	   
	   <div class="leader" align="center">
	<img src="../picture/logo.png" width="120px" height="45px" /></a>&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp 
         	 <a href="#"><font>发布问卷</font></a>&nbsp 
     	 	 <a href = "#"><font  >问卷模板</font></a> &nbsp 
     		 <a href = "#"><font  >问卷广场</font></a> &nbsp 
    	     <a href = "#"><font  >个人中心 </font></a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
             <font size="3"  ><i class="fa fa-user fa-lg"><//%=user%></i></font>
   </div>   
 <!-- 头部结束 -->
 
 
<br><br>
<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)" width="100%" color=#987cb9 SIZE=1>   <!-- 分割线 -->						
  
	 
 
<div class="boxb">
 <table border=1 width=800px align="center" hight=20px >
   <tbody>
      <tr>
  <td><br>
      		 
      	   <div class="box1" align="center"><font size="6" >&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp【<%=quesContent.getTitle() %>】 </font> </div>
      	 
			
			 <br>
         </td>
         
            </tr>
            
            <tr>
  <td><br>
      		 
      	   <div class="box1" align="left"><font size="4" >&nbsp&nbsp &nbsp&nbsp <%=quesContent.getInstruction() %> </font> </div>
      	 <br><br><br><br>
			
			 <br>
         </td>
            </tr>
  <tr>
  
   <td><br>
      		 
      	   <div class="box1" align="left"><font size="3" >&nbsp&nbsp &nbsp&nbsp 发布时间:<%=quesContent.getSet_date() %><br>
														   &nbsp&nbsp &nbsp&nbsp 截止时间:<%=quesContent.getEnd_date() %><br></font> </div>
      	 <br><br><br><br>
			
			 <br>
         </td>
            </tr>
             
  
  <% 
		Set<one_question> questions=quesContent.getQuestions(); 
		one_question question;
		Iterator<one_question> question_it = questions.iterator();
		String answer="";
		
		while (question_it.hasNext()) {  
		  	question=question_it.next();
		  	
		  	for(int i=0;i<answers.size();i++){
		  		if(answers.get(i).getO_id()==question.getId()){
		  			answer=answers.get(i).getAnswer();
		  		}
		  	}
		
		  	Set<q_options> options=question.getOptions();
		  	q_options option;
		  	Iterator<q_options> option_it=options.iterator();%>
		
 <tr>
  <td><br>
      		 
       <div  align="left"style="margin-left:50px;"><%=question.getTitle_num()%>.
		  	<%=question.getStem() %>
		  	<% if(question.getNessecity()==1){%> 
  				<nec>*</nec><br>
  			 <%}%>
       </div><br />
      	 <div align="left"><font size="4" ></font> </div><br />
         
        <% if(question.getType()==2) { %>  
			<div class="blankQuestion">  			
		  		<form name="blankQ">
		  		<input class="blankfill" id="<%=question.getId() %>" name="<%=question.getTitle_num() %>" value="<%=answer%>" disabled="disabled" style="width:600px;height:100px;margin-left:100px; margin-top:20px" class="input-text"  type="text" colour="white" size="40"  height=30px/>
			<br /><br />
		  			<input hidden type="text" name="<%="N"+question.getTitle_num() %>" value="<%=question.getNessecity() %>">
		  			<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  			<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
		  		</form>
		  	</div><br>
		 <% }          
         
        else if(question.getType()==1){ %>
				<div class="mulChooseQuestion">
					<form name="mulQ">
						<input hidden type="text" name="<%="N"+question.getTitle_num() %>" value="<%=question.getNessecity() %>">
						<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  				<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
						<%while(option_it.hasNext()){
							 option=option_it.next();	 
							 if(answer.contains(option.getTitle())){
						%>
						
						<div align="left" style="margin-left:100px;"><label><input align="right" disabled="disabled" checked="true" name="<%=question.getTitle_num()%>" type="checkbox" value="<%=option.getTitle()%>" /><%=option.getTitle() %>.<%=option.getProperty() %> </label> </div>
						
						<%}else{%>
						<div align="left" style="margin-left:100px;"><label><input align="right" disabled="disabled" checked="true" name="<%=question.getTitle_num()%>" type="checkbox" value="<%=option.getTitle()%>" /><%=option.getTitle() %>.<%=option.getProperty() %> </label> </div>
						<%}} %>
					</form>
				
				</div><br>
			<%  }
         
         else{
        	 %>
				<div class="sinChooseQuestion">
					<form name="sinQ">
						<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  				<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
						<input hidden type="text" name="<%="N"+question.getTitle_num() %>" value="<%=question.getNessecity() %>">
						<%while(option_it.hasNext()){ 
							 option=option_it.next();
							 if(option.getTitle().equals(answer)){
						%>
						 <div align="left" style="margin-left:100px;"><label><input align="right" type="radio" disabled="disabled" checked="true" name="<%=question.getTitle_num()%>" value="<%=option.getTitle()%>"><%=option.getTitle()%>.<%=option.getProperty() %><br> </label> </div>
						<%} else{%>
						 <div align="left" style="margin-left:100px;"><label><input align="right" type="radio" disabled="disabled" name="<%=question.getTitle_num()%>" value="<%=option.getTitle()%>"><%=option.getTitle()%>.<%=option.getProperty() %><br> </label> </div>
						<%} 
						}%>
					</form>
				</div><br>	
		   <%
        	 
         }%>
    </td></tr>
    <%} %>
    </tbody>
    
    </table>
    <%if(answer_quesContent.getIf_complete()==1){ %>
    <submit_location>
    	<a HREF="#" class="btn btn-default pull-center"  value="返回">返回</a>
    </submit_location>
    <% } 
    else{%>
    
    
     <span class="edit"><button type="button" class="btn btn-default pull-center" id="edit" value="编辑">编辑</button>
     	
     </span>
    <span class="saveandpreview" hidden><button  type="button" class="btn btn-default pull-center" id="save" value="暂存" >暂存</button>
     <button type="button" class="btn btn-default pull-center" id="preview" value="预览">预览</button></span>
	<button type="button" class="btn btn-default pull-center" id="submit-answer" value="提交">提交</button>    

   	
    </div>       
 	<%} %>

  <div id="mcont0" class="bb">
	   <ul class="block" style="display: none">222222222</ul>
	   <ul class="block" style="display: none">333333333</ul>
	   <ul class="block" style="display: none">4444444444</ul>
  </div> 
  
	
  	<%
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=df.format(new Date());
  	%>
  	<p hidden>
		<input type="text" name="quesnum" value="<%=quesContent.getQuestions().size()%>">
		<input type="text" name="date" value="<%=date %>">
		<input type="text" name="userid" value="<%//=user.getId()%>">
		<input type="text" name="questionnaireid" value="<%=quesContent.getId() %>">
	</p>
  </body> 
</html>
