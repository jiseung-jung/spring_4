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
  <h3>${board} Select Page</h3>
  		<h3 id="num">${oneList.num}</h3>
  		<h3>Title : ${oneList.title}</h3>
  		<h3>Writer : ${oneList.writer}</h3>
  		<h3>Contents : ${oneList.contents}</h3>
  		<input type="button" title="${oneList.num}" value="Delete" class="btn btn-default" id="del">
  		<input type="button" value="Update" class="btn btn-default" id="upd">
  		<c:if test="${board ne'notice'}">
  		<a href="./${board}Reply?num=${oneList.num}" class="btn btn-default">Reply</a></c:if>
</div>

	<script type="text/javascript">
		//$("css선택자").action();
		$("#del").click(function(){
			//var num = $("#num").html();
			//alert(num);
			
			var num = $("#del").attr("title");
			alert(num);
			
			location.href="./${board}Delete?num="+num;
			
		});
		
		$("#upd").click(function () {
			location.href="./${board}Update?num=${dto.num}";
		});	
	

</body>
</html>