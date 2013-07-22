<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile loginBean e istanzia un oggetto LoginBean -->
<jsp:useBean id="loginBean" scope="request"
	class="gestione_Catalogo.bean.LoginBean" />

<jsp:setProperty name="loginBean" property="*" />
<!--  Setta automaticamente tutti gli attributi dell'oggetto loginBean -->

<%
	if (request.getParameter("login") != null) {
		if (loginBean.validate()) {
			%>
			<!-- Passa il controllo alla nuova pagina -->
			<jsp:forward page="gestioneCatalogo.jsp" />
			<%
		}
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

</head>
<body>
	<form action="Login.jsp" name="myform" method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><input name="username" type="text" id="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="password" id="password"></td>
			</tr>
			<tr>
				<td colspan=2 align="center" ><input name="login" type="submit"
					id="login" value="login"></td>
			</tr>
		<%
	if (request.getParameter("login") != null) { %>
		<tr><td colspan=2 align="center"><p style="text-color:red;">Dati errati</p></td></tr>
	<% } %>
	</table>
	</form>
</body>
</html>