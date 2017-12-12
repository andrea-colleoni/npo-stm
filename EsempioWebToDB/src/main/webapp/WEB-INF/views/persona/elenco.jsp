<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elenco persone</title>
</head>
<body>
	<table>
		<caption>Elenco persone</caption>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Indirizzo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${persone}">
				<tr>
					<td>${p.nome}</td>
					<td>${p.cognome}</td>
					<td>${p.indirizzo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>