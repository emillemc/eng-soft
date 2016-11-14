<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entities.Aluno,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tela de Listagem de Alunos</title>
</head>
<body>
	<a href='/webacademia/cadastrarAluno'>Novo</a>
	<table>
		<tr>
			<td>Nome</td>
			<td>Cpf</td>
			<td>Email</td>
			<td>Data de Nascimento</td>
			<td>Ações</td>
		</tr>
		<%
			List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
		%>
		<% for (Aluno aluno : alunos) {%>
		<tr>
			<td><%=aluno.getNome()%></td>
			<td><%=aluno.getCpf()%></td>
			<td><%=aluno.getEmail()%></td>
			<td><%=aluno.getDataNascimento()%></td>
			<td><a href='/webacademia/cadastrarAluno?id=<%=aluno.getId()%>'>editar</a><a
				href='/webacademia/removerAluno?id=<%=aluno.getId()%>'>excluir</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>