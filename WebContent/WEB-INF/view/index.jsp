<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/academy-management-master/resources/css/index.css">
<title>Academy Management</title>
<script type="text/javascript">
	function wip(){
		alert("Trabalho em progresso.")
	}
</script>
</head>
<body>
	<header>

	<h1>
		<img src="http://localhost:8080/academy-management-master/resources/css/imag/acclogo.png" width="400px" height="100px">
	</h1>

	</header>

	<nav>
	<h2 ALIGN="center">
		<FONT FACE="Franklin Gothic Heavy" SIZE="8" COLOR="white">ACADEMY MANAGEMENT</FONT>
	</h2>
		<a class="botao" onclick="wip()">ACADEMIA</a>
		<a class="botao" onclick="wip()">ALUNO</a>
		<a class="botao" href="listaInstrutor">INSTRUTOR</a>

	</nav>
	<footer>
	<address>Produzido para Academia Java</address>
	<address>Por: Emanuelly Oliveitra;
	Kessia Nepomuceno;
	Nathalia Camara;
	Renato Lelis;
	Tatiene Melo</address>
	

	</footer>

</body>
</html>
