<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/academy-management-master/resources/css/academyManagement.css">  
        <title>INSTRUTORES</title>  
	</head>
    <body> 
        <h1><FONT FACE="Franklin Gothic Heavy" SIZE="8" COLOR="white">INSTRUTORES </FONT></h1>
        <table style="width:100%">
                <tr>
                    <th>Cpf</th>
                    <th>Nome</th> 
                    <th>Sexo</th>
                    <th>E-mail</th>
                    <th>Cargo</th>
                </tr>
                <c:forEach var="instrutor" items="${instrutores}">
                    <tr>
                        <td>${instrutor.cpf}</td>
                        <td>${instrutor.nome}</td> 
                        <td>
                        	<c:if test="${instrutor.sexo eq false}">
								Feminino                        	
                        	</c:if>
                        	<c:if test="${instrutor.sexo eq true}">
								Masculino                        	
                        	</c:if>
                        </td>
                        <td>${instrutor.email}</td>
                        <td>${instrutor.cargo}</td>
                        <td class="alterarinst"> <a href="mostraForm?cpf=${instrutor.cpf}">ALTERAR</a></td>
                        <td> <a href="removeIntrutor?cpf=${instrutor.cpf}">DELETAR</a> </td>
                </tr>
                </c:forEach>
            </table>
            
            <form action="novoInstrutor" class="myform">
                <input type="submit" class="binstrutor" value="INSERIR"/>
            </form>
            <form action="/academy-management-master" class="myform">
            	<input type="submit" class="bhome" value="HOME"/>
            </form>
          </body>
        </html>