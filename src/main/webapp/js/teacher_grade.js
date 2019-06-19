$(function(){
	

	$("#sure").click(function(event) {
		/* Act on the event */
		var data=[];
	$(".main").each(function(index, el) {
			var list={
				no:$(this).find(".no").html(),
				grade:$(this).find("input").val()
			};
			data.push(list);
			
	});
		
		
		console.log(JSON.stringify(data));
		$.ajax({
			url: 'AddGrade',
			type: 'POST',
			dataType:'json',
	        contentType:'application/json;charset=utf-8',
			data:JSON.stringify(data),
			success:function(data){
				console.log(data);
				$.each(data,function(index,el){
					
					var result=$(".result");
					var grade=$(".grade");
					$(result.get(index)).text(this.grade);
					$(grade.get(index)).val("");
				});
			},
			error:function(){
				console.log("that is wrong!");
			}
		})
		
	});
	

});