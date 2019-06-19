$(function(){
	 
	 $("#sure").click(function(){
		 console.log("进来了");
		 $.ajaxFileUpload({
		 
		        url: 'ToUploadFiles', //用于文件上传的服务器端请求地址
		        type:'post',
		        secureuri: false, //是否需要安全协议，一般设置为false
		        fileElementId: ['media','picture'], //文件上传域的ID
		        data:{
		              	"title": $("input[name='title']").val(),
		 				"descript":$("input[name='descript']").val(),
		 				"uptime":$("input[name='uptime']").val()

		        },//一同上传的数据
		        dataType: 'json', //返回值类型一般设置为json
		        success: function (data, status)  //服务器成功响应处理函数
		         {
			 		if(data>0){
		               alert("上传成功");

		            }else{

		               alert("上传失败");

		            }

		         },
		 		error:function(data,status,e){
		 			alert("上传过程中发生错误");
		 		}

		     }) 
	 })
})