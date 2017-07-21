<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.user" %>
<%@ page import="model.questionnaire" %>
<%@ page import="model.one_question" %>
<%@ page import="model.q_options" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<style>
 	button_location{
 	position:fixed;
 	right:400px;
 	top:150px
 	}
 </style>


	<%
		String path = request.getContextPath();
	%>
  	<script src="<%=path %>/js/jquery.min.js"></script>
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<script src="<%=path %>/js/jquery.dataTables.min.js"></script>
	<script src="<%=path %>/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path %>/js/bootbox.min.js"></script>
	
	<script src="<%=path %>/js/answerQuestionnaire.js"></script>
  
	<link href="stylesheet" href="icono.min.css">
	<link href="<%=path %>/css/personalCenter.css" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
	

	<script src="<%=path %>/js/personalCenter.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
  

<title>问卷网</title>

<link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">

  </head>
  
	<% 
		questionnaire quesContent=(questionnaire)request.getAttribute("quesContent"); 
		user user=(user)session.getAttribute("user");
	%>

	   <body>
	   
<div class="header">
		<div class="header-logo">
			<img src="<%=path %>/picture/logo.png" alt="logo">
		</div>
		<div class="header-menu">
			<span class="header-menu-span">
				<a href="publishQuestionnaire.action?userId=<%=user.getId()%>">发布问卷</a>
			</span>
			<span class="header-menu-span">
				<a href="#">问卷模板</a>
			</span>
			<span class="header-menu-span">
				<a href="questionnaireSquare.action">问卷广场</a>
			</span>
			<!-- 当前页面将其header-menu-span置换为current -->
			<span class="header-menu-span">
				<a href="personalCenter.action">个人中心</a>
			</span>
		</div>
		<div class="header-username">
			<span><i class="fa fa-user"></i></span>
			<span><%=user.getUsername() %></span>
		</div>
	</div>
	<!-- 标题栏position属性为fixed，这里需要同样大小的元素来占位 -->
	<div class="header-placeholder"></div>
 
 
<br><br>					
  
	 
<div class="boxb">
 <table border=1 width=800px align="center" hight=20px >
   <tbody>
      <tr>
  <td><br>
      		 
      	   <div class="box1" align="center"><font size="6" ><%=quesContent.getTitle() %> </font> </div>
      	 
			
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
		
		
		while (question_it.hasNext()) {  
		  	question=question_it.next();
		  	
		  	Set<q_options> options=question.getOptions();
		  	q_options option;
		  	Iterator<q_options> option_it=options.iterator();%>
		
 <tr>
  <td><br>
      		 
       <div  align="left"style="margin-left:50px;"><%=question.getTitle_num()%>.
		  	<%=question.getStem() %>
		  	<% if(question.getNessecity()==1){%> 
  				<span style="color:red">*</span><br>
  			 <%}%>
       </div><br />
      	 <div align="left"><font size="4" ></font> </div><br />
         
        <% if(question.getType()==2) { %>  
			<div class="blankQuestion">  			
		  		<form name="blankQ">
		  		<input id="<%=question.getId() %>" name="<%=question.getTitle_num() %>" style="width:600px;height:100px;margin-left:100px; margin-top:20px" class="input-text"  type="text" colour="white" size="40"  height=30px/>
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
						%>
						<div align="left" style="margin-left:100px;"><label><input align="right" name="<%=question.getTitle_num()%>" type="checkbox" value="<%=option.getTitle()%>" /><%=option.getTitle() %>.<%=option.getProperty() %> </label> </div>
						
						<%}%>
					</form>
				
				</div><br>
			<% } 
         
         else{
        	 %>
				<div class="sinChooseQuestion">
					<form name="sinQ">
						<input hidden type="text" name="<%="I"+question.getTitle_num() %>" value="<%=question.getId() %>">
		  				<input hidden type="text" name="<%="T"+question.getTitle_num() %>" value="<%=question.getType() %>">
						<input hidden type="text" name="<%="N"+question.getTitle_num() %>" value="<%=question.getNessecity() %>">
						<%while(option_it.hasNext()){ 
							 option=option_it.next();
						%>
						 <div align="left" style="margin-left:100px;"><label><input align="right" type="radio" name="<%=question.getTitle_num()%>" value="<%=option.getTitle()%>"><%=option.getTitle()%>.<%=option.getProperty() %><br> </label> </div>
						<%}%>
					</form>
				</div><br>	
		   <%
        	 
         }}%>
    </td></tr>
    
    </tbody>
    
    </table>
   
<button_location>
    <div class="edit" hidden><button type="button" class="submit-answer-button" id="edit" value="编辑">编辑</button> </div>
    <br>
    <div class="save" ><button  type="button" class="submit-answer-button" id="save" value="暂存" >暂存</button></div>
   	<br>
   	<div class="preview" > <button type="button" class="submit-answer-button" id="preview" value="预览">预览</button></div>
	<br>
	<div> <button type="button" class="submit-answer-button" id="submit-answer" value="提交">提交</button></div>    
 </button_location> 	
    </div>       
 	
  
  	<%
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=df.format(new Date());
		session.setAttribute("quesContent", quesContent);
	%>
  
  	<p hidden>
		<input type="text" name="quesnum" value="<%=quesContent.getQuestions().size()%>">
		<input type="text" name="date" value="<%=date %>">
		<input type="text" name="userid" value="<%=user.getId()%>">
		<input type="text" name="questionnaireid" value="<%=quesContent.getId() %>">
	</p>
  </body> 
</html>
