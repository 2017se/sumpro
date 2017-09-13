$(function(){
	
	$(".delete").click(function(e){
		var dataset=e.currentTarget.dataset;
		var id= dataset.id;
		jQuery.ajax({
			url: 'deleteUser',
			data:{
				id : id
			},
			success:function(data){
				location.reload();
			}
		});
	});

	$(".forbid").click(function(e){
		var dataset=e.currentTarget.dataset;
		var id= dataset.id;
		jQuery.ajax({
			url:'forbid',
			data:{
				id : id
			},
			success:function(data){
				location.reload();
			}
		});
	});
	
	$(".allow").click(function(e){
		var dataset=e.currentTarget.dataset;
		var id= dataset.id;
		jQuery.ajax({
			url:'allow',
			data:{
				id : id
			},
			success:function(data){
				location.reload();
			}
		});
	});


	
	$(".assign").click(function(e){
		var dataset=e.currentTarget.dataset;
		var id=dataset.id;
		
		jQuery.ajax({
			url:'assign',
			data:{
				id :id
			},
			success:function(data){
				location.reload();
			}
		});
	});
})

