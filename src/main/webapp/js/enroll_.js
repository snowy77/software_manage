$(function(){
	$("#no").blur(function(event) {
		/* Act on the event */
		if($("#no").val()==""){
			$("#span1").html("学号不能为空");
		}
	});
	$("#name").blur(function(event) {
		/* Act on the event */
		if($("#name").val()=="")
			$("#span2").html("用户名不能为空");
		
	});
	$("#password").blur(function(event) {
		/* Act on the event */
		if($("#password").val()=="")
			$("#span3").html("密码不能为空");
		
	});
	$("#sure").blur(function(event) {
		/* Act on the event */
		if($("#sure").val()!=$("#password").val())
			$("#span4").html("确认密码错误");
		
	});
	$("#email").blur(function(event) {
		/* Act on the event */
		if($("#email").val()==""){
			$("#span5").html("email不能为空");
		}
		
	});
	$("#enroll").click(function(event) {
		/* Act on the event */
		
		var $form=$("form").serializeArray();
		console.log($form);
        console.log(JSON.stringify($form));


		$.ajax({
		url: 'register',
		type: 'post',
//		contentType: "application/json;charset=UTF-8",
		dataType: 'json',
		data: $form,
		success:function(data){
			alert(data);
			window.location.href="index.html";

		},
		error:function(){
			alert("that is wrong!");
		}
		});

	});

	
});