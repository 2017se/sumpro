/**
 * saveQuestionnaire

 * 1.和后端交互的变量名应保持一致，data和options，questions列表结构保持一致；
 * 2.不需要指定questionnaire的id,one_question的id和q_id,以及q_options的q_id；
 * 3.需要用JSON.Stringify()将js列表转化为JSON字符串，但只用一次；
 * */


var i=2,arr=new Array('F9F9F9','F0F0F0');
var questionli=[2,2];

function a(id){

	questionli[id]=questionli[id]+1;
	var k=document.createElement('span');
	var j=document.createElement('span');
	
	k.innerHTML="&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp"+questionli[id]+")"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp &nbsp&nbsp";
	
	 var input1 = document.createElement('input');
	    input1.setAttribute('type', 'text');
	    input1.setAttribute('name', 'organizers[]');
	    input1.setAttribute('value', '编辑选项');
	    input1.setAttribute('style','width:800px;');
	    input1.setAttribute('style','margin:10px');
	    input1.setAttribute('id',10*id+10+questionli[id]);
	    var btn1 = document.getElementById(id);
	    btn1.appendChild(k);
	    btn1.appendChild(input1)
	    
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
	questionli.push(2);
tr=document.all.t136.insertRow();
tr.style.backgroundColor=arr[i%2];
tr.insertCell().innerHTML= '<td  class="item6" ><div id='+(i+1000)+'><br><div class="que" style="margin-left:20px "heigh="8">'+(i+1)+' <input id='+(i*10)+' style="margin-left:80px" value="编辑题目" class="input-text"  type="text"size="50"/> </div><br /><br /><div  style="margin-left:40px "> 1)<input id='+(i*10+1)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text"  size="44"/> </div><br /><br /><div  style="margin-left:40px "> 2)<input  id='+(i*10+2)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text" size="44"/></div><br><div id='+(i)+' ></div><i class="fa fa-plus-circle" ><button id='+(i)+' onclick="a(this.id)">新增选项</button>	</i><div id="'+(10*i+8)+'" title="1"></div><br /><label><input id="'+(10*i+9)+'" name="Fruit" style="margin-left:40px" type="checkbox" value="" /> 必答</label><br><button id="'+(i+1000)+'"style="margin-right:100px; width:40px" onclick="clearRows(this.id)">删除</button></div></td>'
i++;
}
//多选题的添加
function addNew2(){
	questionli.push(2);
	tr=document.all.t136.insertRow();
	tr.style.backgroundColor=arr[i%2];
    tr.insertCell().innerHTML= '<td   class="item6" ><div id='+(i+1000)+'><br><div class="que" style="margin-left:20px "heigh="8">'+(i+1)+' <input id='+(i*10)+' style="margin-left:80px" value="编辑题目" class="input-text"  type="text"size="50"/> </div><br /><br /><div  style="margin-left:40px "> 1)<input id='+(i*10+1)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text"  size="44"/> </div><br /><br /><div  style="margin-left:40px "> 2)<input  id='+(i*10+2)+' style="margin-left:100px" value="编辑选项" class="input-text"  type="text" size="44"/></div><br><div id='+(i)+' ></div><i class="fa fa-plus-circle" ><button id='+(i)+' onclick="a(this.id)">新增选项</button></i><div id="'+(10*i+8)+'" title="2"></div><br /><label><input  id="'+(10*i+9)+'" name="Fruit" style="margin-left:40px" type="checkbox" value="" /> 必答</label><br><button id="'+(i+1000)+'"style="margin-right:100px; width:40px" onclick="clearRows(this.id)">删除</button></div></td>'

	i++;

}
function addNew3(){
	questionli.push(0);
	tr=document.all.t136.insertRow();
	tr.style.backgroundColor=arr[i%2];
	tr.insertCell().innerHTML= '<td  class="item6" ><div id='+(i+1000)+'><br><div class="que" style="margin-left:20px "heigh="8">'+(i+1)+' <input id='+(i*10)+' style="margin-left:80px" value="编辑题目" class="input-text"  type="text"size="50"/> </div><div id="'+(10*i+8)+'" title="2"></div><br /><br /><label><input  id="'+(i*10+9)+'"name="Fruit" style="margin-left:40px" type="checkbox" value="" /> 必答</label><br><button id="'+(i+1000)+'" style="margin-right:100px; width:40px" onclick="clearRows(this.id)">删除</button></div></td>'
	i++;
	}

function clearRows(tbodyID)
{
	var el = document.getElementById(tbodyID);
	 el.parentNode.removeChild(el);
	 i--;
	 questionli.remove[tbodyID];
}

function submit(){
	var len=questionli.length+1;
	var array_questions = [];
	for(var j = 1; j<len;j++){
		var array_options = [];
		for(var i = 1; i <questionli[j-1];i++){
			var id=j*10+i;
			var option = {
				title : i, //变量名一致
				property : document.getElementById(id).value//变量名一致
			};
			array_options.push(option);
		}
		
		var question = {
			title_num : j, //变量名一致（题号）
			stem :  document.getElementById(10*j).value, //变量名一致
			type :  document.getElementById(10*j+8).title , //变量名一致
			nessecity :document.getElementById(10*j+9).value, //变量名一致
			options : array_options //变量名一致
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
			set_date : "", //变量名一致，datetime格式："yyyy-mm-dd hh:mm:ss"
			end_date : "", //变量名一致，datetime格式："yyyy-mm-dd hh:mm:ss"
			questions : JSON.stringify(array_questions) //变量名一致，用JSON.Stringify()封装且只封装一次
		},
		success : function(data){
			var url_jump = "publishPreview?questionnaireId="+data.quesId;
			$(location).attr('href', url_jump);
		},
		error : function(data){
			alert("");
		}
	});
}

