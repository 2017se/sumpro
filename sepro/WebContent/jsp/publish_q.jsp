<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  </head>
  
	   <body>
	   
	   <div class="leader" align="center">
	<img src="../picture/logo.png" width="120px" height="45px" /></a>&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp 
         	 <a href="#"><font>发布问卷</font></a>&nbsp 
     	 	 <a href = "#"><font  >问卷模板</font></a> &nbsp 
     		 <a href = "#"><font  >问卷广场</font></a> &nbsp 
    	     <a href = "#"><font  >个人中心 </font></a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
             <font size="3"  ><i class="fa fa-user fa-lg">username</font></i> 
   </div>   
 <!-- 头部结束 -->
 
 
<br><br>
<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)" width="100%" color=#987cb9 SIZE=1>   <!-- 分割线 -->						
  
	 
	   <div class="boxa"> 
<div class="boxa-l">
 <div id="sideBar">
		<div id="sideBarMain">
 <div class="aa">
	   <ul  id="leftmenu0">
		 <img src="../picture/questionnaire.png" width="100px" height="140px" />
		<div> 问卷缩略图</div>
		<li><a  href="#demo"><font  size="5">锚点例子</font></a></li>
	   </ul>
	   </div>
</div><!--end: sideBarMain -->
	</div><!--end: sideBar 侧边栏容器 -->
	  <table width="1" border="0" cellspacing="0" cellpadding="0" height="800">
  <tr>
    <td width="1" bgcolor="#666666"></td>
  </tr>
  
</table> 
</div> 
<div class="boxb">
 <table border=1 width=800px align="center" hight=20px >
   <tbody>
      <tr>
  <td><br>
      		 
      	   <div class="box1" align="center"><font size="6" >&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp【问卷标题】 </font> </div>
      	 
			
			 <br>
         </td>
         
            </tr>
            
            <tr>
  <td><br>
      		 
      	   <div class="box1" align="left"><font size="4" >真正的科学家应当是个幻想家；谁不是幻想家，谁就只能把自己称为实践家。 —— 巴尔扎克 </font> </div>
      	 <br><br><br><br>
			
			 <br>
         </td>
            </tr>
             <tr>
  <td><br>
      		 
      	   <div  align="left"style="margin-left:50px;">问题一 </div>
      	     <br />
      	 <div align="left"><font size="4" ></font> </div>
          <br />
         <div align="left" style="margin-left:100px;"><label><input align="right" name="Fruit" type="checkbox" value="" /> 选项一 </label> </div>
		<div align="left" style="margin-left:100px;"><label><input align="right" name="Fruit" type="checkbox" value="" /> 选项三 </label> </div>
		<div align="left" style="margin-left:100px;"><label><input align="right" name="Fruit" type="checkbox" value="" /> 选项二 </label> </div>
			<br /><br />
			
       
			 <br>
         </td>
            </tr>
                         <tr>
  <td><br>
      		 
      	   <div  align="left"style="margin-left:50px;">问题二 </div>
      	     <br />
      	 <div align="left"><font size="4" ></font> </div>
          <br />
         <div align="left" style="margin-left:100px;"><label><input align="right" name="Fruit" type="checkbox" value="" /> 选项一 </label> </div>
		<div align="left" style="margin-left:100px;"><label><input align="right" name="Fruit" type="checkbox" value="" /> 选项三 </label> </div>
		<div align="left" style="margin-left:100px;"><label><input align="right" name="Fruit" type="checkbox" value="" /> 选项二 </label> </div>
			<br /><br />
			
       
			 <br>
         </td>
        <tr>
  <td><br>
      		 
      	   <div  align="left"style="margin-left:50px;">问题三</div>
      	     <br />
      	 <div align="left"><font size="4" ></font> </div>
          <br />
     <input  value="多行输入"  style="width:600px;height:100px;margin-left:100px; margin-top:20px" class="input-text"  type="text" colour="white" size="40"   height=30px/></font> 
			<br /><br />
			
       <a id='demo' ></a><!-- 锚点例子  -->
			 <br>
         </td>
            </tr>
           
</div> 
 		
  <div id="mcont0" class="bb">
	   <ul class="block" style="display: none">222222222</ul>
	   <ul class="block" style="display: none">333333333</ul>
	   <ul class="block" style="display: none">4444444444</ul>
	   </div>
	   </body>
	   </html> 
</html>
