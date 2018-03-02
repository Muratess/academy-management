<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/academy-management-master/resources/css/academyManagement.css">  
<title>Instrutor</title>
</head>
<body>
	<h1> <FONT FACE="Franklin Gothic Heavy" SIZE="8" COLOR="white">NOVO INSTRUTOR </FONT></h1>

	<form action="adicionaInstrutor" method="post" class="myform">
	<label for="nome">Nome:</label>
	<input type="text" id="nome" name="nome" />

	<label for="cpf">CPF:</label>
	<input type="text" id="cpf" name="cpf" maxlength="11"/>

	<label for="sexo">Sexo:</label>
	<select name="sexo" id="sexo">
		<option value=""></option>
		<option value="true">Masculino</option>
		<option value="false">Feminino</option>
	</select>
	
	<label for="email">E-mail:</label>
	<input type="text" id="email" name="email"/>

	<label for="cargo">Cargo:</label>
	<input type="text" id="cargo" name="cargo"/>

	<br>
	<br>

	
		<input type="submit" class="binstrutor" value="SALVAR" />
	</form>
	<form action="listaInstrutor" method="get" class=myform>
		<input type="submit" class="bhome" value="CANCELAR" />
	</form>

</body>
</html>