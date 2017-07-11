<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>body,td,div,a,input{font:menu;line-height:150%}</style>
<table cellspacing=1 cellpadding=1 border=0 width=100% id=t136>

<tbody>
</table>


<div>
<input type=button onclick=addNew() value=增加 class=button_index><font color=000080>(按一次增加按钮就可以上传一张图片。)</font>
</div>
</form>
<script>
var i=0,arr=new Array('F9F9F9','F0F0F0');
function addNew(){
	tr=document.all.t136.insertRow();
	tr.style.backgroundColor=arr[i%2];
	tr.insertCell().innerText="图片"+(++i);
	tr.insertCell().innerHTML='<input type=file name=pic'+i+' class=border_index> <a href=javascript:void(0) onclick=del()>删除</a>' 
}
function del(){
document.all.t136.deleteRow(window.event.srcElement.parentElement.parentElement.rowIndex);
for(i=0;i<document.all.t136.rows.length-5;i++){
document.all.t136.rows[i+5].cells[0].innerText="图片"+(i+1);
document.all.t136.rows[i+5].cells[1].children[0].name="pic"+(i+1);
document.all.t136.rows[i+5].style.backgroundColor=arr[i%2];
}
}
</script> 