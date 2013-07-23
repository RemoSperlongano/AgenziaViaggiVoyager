<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<!-- Si dichiara la variabile trattaBean e istanzia un oggetto TrattaBean -->
	<jsp:useBean id="aggiungiTrattaBean" scope="request"
	class="gestione_Catalogo.bean.AggiungiTrattaBean" />
    
    <jsp:setProperty name="aggiungiTrattaBean" property="*" />
	<!-- Imposta automaticamente tutti gli attributi dell'oggetto aggiungiTrattaBean -->

	<%
	if (request.getParameter("Aggiungi Viaggio") != null) {
		if (aggiungiTrattaBean.validate()) {
			%>
			<!-- Passa il controllo alla nuova pagina -->
			<jsp:forward page="gestioneCatalogo.jsp" />
			<%
		}
		
		%>
		<%-- Passa il controllo alla nuova pagina 
		<jsp:forward page="AggiungiViaggio.jsp" />--%>
		<%
	}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi Viaggio al Catalogo</title>
</head>

<body>

<%-- 	<% if (request.getParameter("AggiungiViaggio") != null) { %>
		<tr><td colspan=2 align="center"><p style="text-color:red;">Viaggio Inserito!</p></td></tr>
	<% } else { %>
		<tr><td colspan=2 align="center"><p style="text-color:red;">Viaggio _NON_ Inserito!</p></td></tr>
	<% } %>
 --%>	
	
<form method="POST">
Ambiente: <select name="ambiente" id="ambiente">
<option value="Aria">Aria</option>
<option value="Mare">Mare</option>
<option value="Terra" selected>Terra</option>
</select>
<br>

Mezzo: <input type="text" name="mezzo" id="mezzo"><br>
Tipo Mezzo: <input type="text" name="tipoMezzo" id="tipoMezzo"><br>
Città di partenza: <input type="text" name="partenza" id="partenza"><br>
Città di arrivo: <input type="text" name="arrivo" id="arrivo"><br>
Via: <input type="text" name="via" id="via"> <br>
Info: <input type="text" name="info" id="info">

 

<input name="Aggiungi Viaggio" type="submit" id="AggiungiViaggio" value="AggiungiViaggio">

</form>
</body>
</html>