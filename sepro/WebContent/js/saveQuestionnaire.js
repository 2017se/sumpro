/**
 * saveQuestionnaire
 * 1.和后端交互的变量名应保持一致，data和options，questions列表结构保持一致；
 * 2.不需要指定questionnaire的id,one_question的id和q_id,以及q_options的q_id；
 * 3.需要用JSON.Stringify()将js列表转化为JSON字符串，但只用一次；
 * */


var i=2,arr=new Array('F9F9F9','F0F0F0');
var questionli=[2,2];

function a(id){
	
	questionli[id]++;
	var k=document.createElement('span');
	var j=document.createElement('span');
	
	k.innerHTML="&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp"+questionli[id]+")"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp ";
	
	 var input1 = document.createElement('input');
	    input1.setAttribute('type', 'text');
	    input1.setAttribute('name', 'organizers[]');
	    input1.setAttribute('value', '编辑选项');
	    input1.setAttribute('size','44');
	    input1.setAttribute('style','margin:10px');
	    input1.setAttribute('id',10*id+10+questionli[id]);
	    var btn1 = document.getElementById(id);
	    btn1.appendChild(k);
	    btn1.appendChild(input1);
	    
	    j.innerHTML="<br>"
        btn1.appendChild(j)
   }

function c(){
var arr = document.getElementsByTagName("div");

for(var j=0;j<num;j++)    
 {  
    ha.removeChild(arr[1]); 
 }
}
//单选题的添加
function addNew1(){
	if(i>19){
		alert("only no more than 20 questions are allowed");
		return;
	}
	questionli.push(2);
tr=document.all.t136.insertRow();
tr.style.backgroundColor=arr[i%2];
i++;
tr.insertCell().innerHTML= '<td  class="item6" ><div id='+(i+1000)+'><br><div class="que" style="margin-left:20px "heigh="8">'+(i)+' <input id='+(i*10)+' style="margin-left:80px" value="编辑题目" class="input-text"  type="text"size="50"/> </div><br /><br /><div  style="margin-left:40px "> 1)<input id='+(i*10+1)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text"  size="44"/> </div><br /><br /><div  style="margin-left:40px "> 2)<input  id='+(i*10+2)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text" size="44"/></div><br><div id='+(i-1)+' ></div><i class="fa fa-plus-circle" ><button id='+(i-1)+' onclick="a(this.id)">新增选项</button>	</i>  <br /><div id="'+(10*i+7)+'" style="margin-left:80px" value="0" class="input-text"  type="text" colour="white" size="0"/></font> <div id="'+(10*i+8)+'" title="0"></div><br /><input id="'+(10*i+9)+'" name="Fruit" style="margin-left:40px" type="checkbox" value="" > 必答<br><button id="'+(i+1000)+'"style="margin-right:100px; width:40px" onclick="clearRows(this.id)">删除</button></div></td>'


}
//多选题的添加
function addNew2(){
	if(i>19){
		alert("only no more than 20 questions are allowed");
		return;
	}
	questionli.push(2);
	tr=document.all.t136.insertRow();
	tr.style.backgroundColor=arr[i%2];
	i++;
    tr.insertCell().innerHTML= '<td   class="item6" ><div id='+(i+1000)+'><br><div class="que" style="margin-left:20px "heigh="8">'+(i)+' <input id='+(i*10)+' style="margin-left:80px" value="编辑题目" class="input-text"  type="text"size="50"/> </div><br /><br /><div  style="margin-left:40px "> 1)<input id='+(i*10+1)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text"  size="44"/> </div><br /><br /><div  style="margin-left:40px "> 2)<input  id='+(i*10+2)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text" size="44"/></div><br><div id='+(i-1)+' ></div><i class="fa fa-plus-circle" ><button id='+(i-1)+' onclick="a(this.id)">新增选项</button></i><br /><div>最大选择数：</div><input id="'+(10*i+7)+'" style="margin-left:80px" value="1" class="input-text"  type="text" colour="white" size="2"/></font><div id="'+(10*i+8)+'" title="1"></div><br /><input  id="'+(10*i+9)+'" name="Fruit" style="margin-left:40px" type="checkbox" value="" > 必答<br><button id="'+(i+1000)+'"style="margin-right:100px; width:40px" onclick="clearRows(this.id)">删除</button></div></td>'
}
function addNew3(){
	if(i>19){
		alert("only no more than 20 questions are allowed");
		return;
	}
	questionli.push(0);
	tr=document.all.t136.insertRow();
	tr.style.backgroundColor=arr[i%2];
	i++;
	tr.insertCell().innerHTML= '<td  class="item6" ><div id='+(i+1000)+'><br><div class="que" style="margin-left:20px "heigh="8">'+(i)+' <input id='+(i*10)+' style="margin-left:80px" value="编辑题目" class="input-text"  type="text"size="50"/> </div><lable id="'+(10*i+7)+'" style="margin-left:80px" value="2" class="input-text"  type="text" colour="white" size="0"/><div id="'+(10*i+8)+'" title="2"></div><br /><br /><input  id="'+(i*10+9)+'"name="Fruit" style="margin-left:40px" type="checkbox" value="" /> 必答<br><button id="'+(i+1000)+'" style="margin-right:100px; width:40px" onclick="clearRows(this.id)">删除</button></div></td>'
	
	}

function clearRows(tbodyID)
{
	var el = document.getElementById(tbodyID);
	 el.parentNode.removeChild(el);
	 i--;
	 questionli[tbodyID-1000]=2;
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
} 

function submit(){
	var now=getNowFormatDate();
	if(document.getElementById("starttime").value<now){
		alert("请检查开始回收时间。");
		return;
	};
	if(document.getElementById("starttime").value>document.getElementById("endtime").value){
		alert("请检查结束回收时间。");
		return;
	}
	var len=i+1;
	var array_questions = [];
	for(var j = 1; j<len;j++){
		var array_options = [];
		for(var n = 1; n <questionli[j-1]+1;){
			var id=j*10+n;
			var option = {
				title : n,//变量名一致vv
				set:id,
				property : document.getElementById(id).value,//变量名一致
			};
			n++;
			array_options.push(option);
		}
		
		var question = {
			title_num : j, //变量名一致（题号）
			stem :  document.getElementById(10*j).value, //变量名一致
			type :  document.getElementById(10*j+8).title , //变量名一致
			nessecity :document.getElementById(10*j+9).value, //变量名一致
			options : array_options,//变量名一致
			max_options:document.getElementById(10*j+7).value,//多选题确定选项数

		};
		array_questions.push(question);
	}
	jQuery.ajax({
		url : 'saveQuestionnaire',
		type : 'POST', //post
		dataType : "json", //需要指定为json
		data: {
			u_id :document.getElementById("u_id").innerHTML,
			title : document.getElementById("tit").value, //变量名一致
			instruction : document.getElementById("wel").value, //变量名一致
			set_date : document.getElementById("starttime").value, //变量名一致，datetime格式："yyyy-mm-dd hh:mm:ss"
			end_date : document.getElementById("endtime").value, //变量名一致，datetime格式："yyyy-mm-dd hh:mm:ss"
			questions : JSON.stringify(array_questions) //变量名一致，用JSON.Stringify()封装且只封装一次
		},
		success : function(data){
			var url_jump = "publishPreview?questionnaireId="+data.quesId;
			$(location).attr('href', url_jump);
		},
		error : function(data){
			alert("saving error");
		}
	});
}
