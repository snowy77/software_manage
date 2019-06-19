$(function(){
	

	$("#sure").click(function(event) {
		/* Act on the event */
		var data=[];
	$(".main").each(function(index, el) {
			var list={
				grade1:$(this).find("input[name='grade1']").val(),
				grade2:$(this).find("input[name='grade2']").val(),
				grade3:$(this).find("input[name='grade3']").val()
			};
			data.push(list);
			
	});
		
		
		console.log(JSON.stringify(data));
		$.ajax({
			url: 'Controller2',
			type: 'POST',
			dataType:'json',
	        contentType:'application/json;charset=utf-8',
			data:JSON.stringify(data),
			success:function(data){
				alert(data);
				window.location.reload();
				// $.each(data,function(index,el){
					
				// 	var result=$(".result");
				// 	var grade=$(".grade");
				// 	$(result.get(index)).text(this.grade);
				// 	$(grade.get(index)).val("");
				// });
			},
			error:function(){
				console.log("that is wrong!");
			}
		})
		
	});
	$("#submit").click(function(event) {
		/* Act on the event */
		history.back();
	});

});