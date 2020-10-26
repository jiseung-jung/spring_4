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
		<h3>Member Join Page</h3>
		
	<form action="./memberJoin" method="post">
    	<div class="form-group">
      		<label for="id">ID:</label>
      		<input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
      		<div id="idResult"></div>
    	</div>
    
    	<div class="form-group">
      		<label for="pw">Password:</label>
      		<input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    	</div>
    
    	<div class="form-group">
      		<label for="pw">Password:</label>
      		<input type="password" class="form-control" id="pw1" placeholder="Enter password" name="pw1">
    	</div>
    
    	<div class="form-group">
      		<label for="name">Name:</label>
      		<input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    	</div>
    
    	<div class="form-group">
      		<label for="email">Email:</label>
      		<input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
    	</div>
    
    <button type="submit" class="btn btn-default">Join</button>
  </form>
	</div>

</body>
</html>