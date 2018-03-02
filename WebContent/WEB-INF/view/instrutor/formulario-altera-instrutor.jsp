<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/academy-management-master/resources/css/academyManagement.css">
<title>INSTRUTOR</title>
</head>
<body>
	<h1><FONT FACE="Franklin Gothic Heavy" SIZE="8" COLOR="white"> EDITAR INSTRUTOR </FONT></h1>

	<form action="alteraInstrutor" method="post">
		<label for="nome">Nome: </label> 
		<input type="text" id="nome" value="${instrutor.nome}" name="nome" /> 
		<label for="cpf">CPF: </label> 
		<input type="text" id="cpf" value="${instrutor.cpf}" name="cpf"/> 
		<label for="sexo">Sexo: </label>
		<select id="sexo" name="sexo">
			<option value="${instrutor.sexo}">
				<c:if test="${instrutor.sexo eq false}">
					Feminno
				</c:if>
				<c:if test="${instrutor.sexo eq true}">
					Masculino
				</c:if>
			</option>
			<c:if test="${instrutor.sexo eq true}">
				<option value="false">
					Feminino
				</option>
			</c:if>
			<c:if test="${instrutor.sexo eq false}">
				<option value="true">
					Masculino
				</option>
			</c:if>
		</select> 
		<label for="email">E-mail: </label>
		<input type="text" id="email" value="${instrutor.email}" name="email"/> 
		<label for="cargo">Cargo: </label> 
		<input type="text" id="cargo" value="${instrutor.cargo}" name="cargo"/>
		</br> </br> 
		<input type="submit" class="binstrutor" value="SALVAR" />
	</form>
	
	<form action="listaInstrutor" method="get">
		<input type="submit" class="bhome" value="CANCELAR" />
	</form>

</body>
</html>