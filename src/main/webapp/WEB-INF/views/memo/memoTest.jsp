<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div>
 		<table class="table table-hober">
  			<tr>
  				<td>Num</td>
  				<td>Writer</td>
  				<td>Contents</td>
  				<td>Date</td>
  				<td> </td>
  			</tr>
	
	<c:forEach items="${list}" var="dto">
  			<tr>
  				<td>${dto.num}</td>
  				<td>${dto.contents}</td>
  				<td>${dto.writer}</td>
  				<td>${dto.regdate}</td>
  				<td><button title="${dto.num}" class="btn btn-default del">DEL</button></td>
  			<tr>
  			</c:forEach>
 		 </table>
 	 </div>
 	 
