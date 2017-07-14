<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="../js/saveQuestionnaireAndAnswer.js"></script> 
  <script type="text/javascript"></script>
<style type="text/css"> 

* { margin:0; padding:0;}

ul, li { list-style:none;}

a { text-decoration:none;}

.nav { border:2px solid #ccc;
 border-right:none; 
 overflow:hidden;
  float:left;
  width:120px;
  font-family:"斜体";
  position:fixed;  
   }

.nav ul li { float:left;}

.nav ul li a { width:120px; height:40px; text-align:top; line-height:40px; display:block; border-right:2px solid #ccc; background:#eee; color:#666;}

.nav ul li a:hover{ color:#f00; }

.nav ul li ul { position:absolute; display:none;}

.nav ul li ul li { float:none;}

.nav ul li ul li a { border-right:none; border-top:1px dotted #ccc; background:#f5f5f5;}

.nav ul li:hover ul{ display:block; }

.divcss5-top,.divcss5-bottom{width:300px;height:100px;border:1px solid #F00;padding:0px}
.divcss5-bottom{ margin-top:10px}

.aa{ 
overflow:hidden
	width:120px; 
	float:left;
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

.logo_img{
position:absolute;
top:50px
}

.form-search {
align="right";
font-size:13px;
}

.item1
{
width:5%
}
.item2
{
width:10%
}
.item3
{
width:20%
}
.item4
{
width:30%
}
.item5
{
width:40%
}
.item6
{
width:45%
}
.item7
{
width:50%
}

</style>
<title>问卷网</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  
	   <body>
	   
	   <div class="leader" align="center" >
	<img src="../picture/logo.png" width="120px" height="45px" /></a>&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp 
         	 <a href="#"><font>发布问卷</font></a>&nbsp 
     	 	 <a href = "#"><font  >问卷模板</font></a> &nbsp 
     		 <a href = "#"><font  >问卷广场</font></a> &nbsp 
    	     <a href = "#"><font  >个人中心 </font></a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
             <font size="3"  ><i class="fa fa-user fa-lg">username</font></i> 
   </div>   
 <!-- 头部结束 -->
 <br /><br />
 

<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#000000,direction:145,strength:15)" width="100%" color=#000000 SIZE=1>   <!-- 分割线 -->						
  
	 
	   <div class="boxa"> 
<div class="boxa-l">
 <div id="sideBar">
		<div id="sideBarMain">
 <div class="nav">
	   <ul  id="leftmenu0">
	   <li><a  href="#begin"><font  size="5">标题</font> </a></li>
	   <li><a  href="#det"><font  size="5">问卷简介</font></a></li>
	   <li><a  href="#que"><font  size="5">编辑问卷</font> </a>
	   		<ul>

            <li><div>
				<input type=button onclick=addNew1() value=单项选择 class=button_index>
					</div>
					</li>

            <li><div>
				<input type=button onclick=addNew2() value=多项选择 class=button_index>
					</div></li>

            <li><div>
				<input type=button onclick=addNew3() value=简答 class=button_index>
					</div></li>


        </ul>
	   </li>
	   <li> <a  href="#end"><font  size="5">结束语</font> </a></li>
	   </ul>
	   </div>
</div><!--end: sideBarMain -->
	</div><!--end: sideBar 侧边栏容器 -->
	  <table width="1" border="0" cellspacing="0" cellpadding="0" height="800" >
  <tr>
    <td width="1" bgcolor="#666666"></td>
  </tr>
  
</table> 
</div> 
<div class="boxb">





<!-- table -->

 <table  border=1 align="center"  id=t136  width=800px>
   <tbody>
	<tr>
  		<td class="item7"colspan="2"><br>
      		   <a id='begin' ></a>
      	   <div class="box1" align="center">
      	     <input  id="tit" value="【问卷标题】" class="input-text"  type="text" colour="white" size="50"/>;
      	   </div><br>
        </td>
         
    </tr>
            
     <tr>
  		<td class="item7" colspan="2"><br>
      		  <a id='det' ></a>
      	   <div class="box1"  align="left">
      	   <input id="wel" value="内容或欢迎语" class="input-text"  type="text" colour="white" size="50"/>;
      	    </div>
      	 <br><br><br><br><br>
         </td>
      </tr>
           
      <tr>
        <td class="item6" ><br>
      		 <div class="que" align="left"heigh="8"><font size="4" >&nbsp&nbsp(1) &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp 
      	    <input id="10" value="编辑题目" class="input-text"  type="text" colour="white" size="50"/></font> 
      	    </div>
      	     <br /><br />
      	 	<div align="left"><font size="4" >&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp 1&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp  
      	 	<input id="11" value="编辑选项" class="input-text"  type="text" colour="white" size="44"/></font> </div>
            <br /><br />
            <div align="left"><font size="4" >&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp 2&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp  
        	<input  id="12"  value="编辑选项" class="input-text"  type="text" colour="white" size="44"/></font> </div>
			<br>
            <div class="options"  style="margin-left:65px;">
			  <div id="0" ></div>
			<i class="fa fa-plus-circle" aria-hidden="true">
			<button id="0" onclick="a(this.id)">新增选项</button></i>
			</div>
            <br />
            <label><input name="Fruit" type="checkbox" value="" /> &nbsp&nbsp &nbsp&nbsp必答 &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp</label>
			 <br>
         </td>
        </tr>
            
       <tr>
        <td class="item6" ><br>
      		  <a id='que' ></a>
      	      <div  align="left"heigh="8"><font size="4" > &nbsp&nbsp(2) &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp  
      	      <input  id="20" value="编辑题目" class="input-text"  type="text" colour="white" size="50"/></font> </div>
      		 <br /> <br />
      	     <div align="left"><font size="4" >&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp 1&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp  
      	     <input  id="21" value="编辑选项" class="input-text"  type="text" colour="white" size="44"/></font> </div>
             <br /><br />
             <div align="left"><font size="4" >&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp 2&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp  
             <input  id="22" value="编辑选项" class="input-text"  type="text" colour="white" size="44"/></font> </div>
		     <br>
		     <div class="options"  style="margin-left:65px;">
			  <div id="1"></div>
			<i class="fa fa-plus-circle" aria-hidden="true">
			  <button id="1" onclick="a(this.id)">新增选项</button></i>
			</div>
      		<br /><br />
			&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp<label>
            <input name="Fruit" type="checkbox" value="" /> &nbsp&nbsp &nbsp&nbsp必答 &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp</label>
            <label><input align="right" name="Fruit" type="checkbox" value="" /> &nbsp&nbsp &nbsp&nbsp限制字数 </label> 
            <input  value="最大字数" class="input-text"  type="text" colour="white" size="5"/></font> 
			 <br>

         </td>
        </tr>
            
    </tbody>
  </table>
			<div style="margin-left:370px;">
			  <input  value="编辑结束语"  style="width:600px;height:80px; " class="input-text"  type="text" colour="white" size="40"   height=30px/></font> 
			
			<a id='end' ></a>
			   <button id="sub"type="submit">提交</button>
                <button type="reset">重置</button>
                </div>
                             <div class="end" align=right style="margin-left:370px;">
			 <label><input name="choice" type="checkbox" value="" /> &nbsp&nbsp 完成后参与抽奖 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
			   </div>
              <div id="u_id">"<%=session.getAttribute("U_id")%>";</div>




         
</div> 
 		

	   </body>
	   </html> 
</html>
