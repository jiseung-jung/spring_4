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
			<div id=result></div>
			<hr>
			<button class="btn btn-default">더보기</button>
	</div>
	
	
		<script type="text/javascript">
		
			getList();
		
			function getList() {
				$.get("./memoList", function(data) {
					$("#result").html(data);
				});
			}
			//--------------------------------------------
			
			$("#result").on("click", ".del", function() {
				var num = $(this).attr("title");	
				$.post("./memoDelete",{num:num},function(result) {
					result=result.trim();
					alert(result);
					
					if(result=="Delete Success"){
						getList();
					}
				});
			});
			
			//--------------------------------------------
			
			$("#write").click(function() {
				var writer = $("#writer").val();
				var contents = $("#contents").val();
				$.post("./memoWrite",{writer:writer, contents:contents},function(result) {
					alert(result);
					$("#writer").val('');
					$("#contents").val('');
				});
			//--------------------------------------------
			
			getList();
			
			});
			
			//--------------------------------------------
		
		</script>
	
</body>
</html>