<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ACADEMIA</title>
</head>
<body>
	<h1>ACADEMIAS</h1>
	<table style="width: 100%">
		<c:forEach items="${academias}" var="academia">
			<tr>
				<td><a href="#">${academia.tipo}</a></td>
				<td> <a href="#">ALTERAR</a></td>
				<td><a href="#">DELETAR</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" class="bacademia" value="INSERIR"/>
	<input type="button" class="bhome" value="HOME"/>
</body>
</html>