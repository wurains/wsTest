<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>学生信息</h1>
    <table>
        <tr>
            <th>学生编号</th>
            <th>学生姓名</th>
            <th>学生年龄</th>
        </tr>
        <C:forEach items="${list}" var="student">
	        <tr>
	            <td>${student.id}</td>
	            <td>${student.name}</td>
	            <td>${student.age}</td>
	        </tr>
        </C:forEach>
    </table>
</body>
</html>