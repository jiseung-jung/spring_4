<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

</head>
<body>

<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h1>Memo Page</h1>
			<hr>
			<div>
				<div class="form-group">
   			   		<label for="writer">Writer:</label>
      				<input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
   				</div>
    
   				<div class="form-group">
     				 <label for="contents">Contents:</label>
	 				 <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
  				</div>
  				
  				<button type="submit" class="btn btn-default" id="write">Write</button>
			</div>
			
			
			
			
			<hr>
			<div>
				<table id="result" class="table table-hober">
				
				</table>
			</div>
			<hr>
			<button class="btn btn-default" id="more">더보기</button>
	</div>
	
	
		<script type="text/javascript">
			var curPage=1;
			getList();
		
			function getList() {
				
				$.ajax({
					url:"./memoList",
					type: "GET",
					data:{curPage:curPage},
					success:function(data){
						$("#result").append(data);
					}
				});
				
				//$.get("./memoList", function(data) {
				//	$("#result").append(data);
				//});
			}
	//----------------------------more-----------------------------
	
		$("#more").click(function() {
			curPage++;
			getList();
		});
			
			
	//-----------------------------------------------------------
			
			$("#result").on("click", ".del", function() {
				var num = $(this).attr("title");	
				
				
			//	$.post("./memoDelete",{num:num},function(result) {
			//		result=result.trim();
			//		alert(result);
			
				$.ajax({
					url : "./memoDelete",
					type : "POST",
					data : {num:num},
					success : function(result) {
						alert(result)
						$("#result").html('');
						curPage=1;
						getList();
					}
				});
			});
			
			//--------------------------------------------
			
			$("#write").click(function() {
				var writer = $("#writer").val();
				var contents = $("#contents").val();
				
				$.ajax({
					url : "./memoWrite",
					type : "POST",
					data : {writer:writer, contents:contents},
					success : function(result) {
						alert(result);
						$("#writer").val('');
						$("#contents").val('');
						$("#result").html('');
						curPage=1;
						getList();
					}
					
				});
				
			});
				
			//	$.post("./memoWrite",{writer:writer, contents:contents},function(result) {
			//		alert(result);
			//		$("#writer").val('');
			//		$("#contents").val('');
			//	});
			//--------------------------------------------
			
			
			//--------------------------------------------
		
		</script>
	
</body>
</html>