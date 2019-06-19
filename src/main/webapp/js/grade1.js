$(function(){
	var data=[];
	var checked='';
	var $tr;
	console.log($("#tbodyId"));
	console.log($("#tbodyId input[type='checkbox']"));
	var i=0;
	$("#delete").click(function(event) {
		$("#tbodyId input[type='checkbox']").each(function(index, el) {
			checked=$(this).prop('checked');
			console.log(checked);
			if(checked){
				
				$tr=$(this).parent().parent().parent();
				console.log($tr);

				
					data[i]=$tr.find('#no').text();
					i++;
			}
		});
		console.log(data);
		
	/* Act on the event */
	$.ajax({
		url: 'controller1',
		type: 'POST',
		dataType:'json',
        contentType:'application/json;charset=utf-8',
		data:JSON.stringify(data),
		success:function(data){
			alert(data);
			window.location.reload();
		},
		error:function(){
			console.log("that is wrong!");
		}
	})
	
});

});