<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<!-- Si dichiara la variabile trattaBean e istanzia un oggetto TrattaBean -->
	<jsp:useBean id="rimuoviTrattaBean" scope="request"
	class="gestione_Catalogo.bean.RimuoviTrattaBean" />
    
    <jsp:setProperty name="rimuoviTrattaBean" property="*" />
	<!-- Imposta automaticamente tutti gli attributi dell'oggetto rimuoviTrattaBean -->

	<%
	
	if (request.getParameter("Rimuovi Viaggio") != null) {
		if (rimuoviTrattaBean.validate()) {
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

<a href="/AgenziaDiViaggio/gestioneCatalogo.jsp" >Torna alla gestione Catalogo</a>

<%-- 	<% if (request.getParameter("AggiungiViaggio") != null) { %>
		<tr><td colspan=2 align="center"><p style="text-color:red;">Viaggio Inserito!</p></td></tr>
	<% } else { %>
		<tr><td colspan=2 align="center"><p style="text-color:red;">Viaggio _NON_ Inserito!</p></td></tr>
	<% } %>
 --%>	
	
<form method="POST">
<table>
			<tr>
				<td> Ambiente: </td>
				<td>
					<select name="ambiente" id="ambiente">
					<option value="Aria">Aria</option>
					<option value="Mare">Mare</option>
					<option value="Terra" selected>Terra</option>
					</select>
				</td>
			</tr>
			<tr>
				<td> Mezzo: </td>
				<td><input type="text" name="mezzo" id="mezzo"> </td>
			</tr>
			<tr>
				<td> Tipo Mezzo: </td>
				<td> <input type="text" name="tipoMezzo" id="tipoMezzo"> </td>
			</tr>
			<tr>
				<td> Città di partenza: </td>
 				<td> <input type="text" name="partenza" id="partenza"> </td>
 			</tr>
			<tr>
				<td> Città di arrivo: </td>
 				<td> <input type="text" name="arrivo" id="arrivo"> </td>
			</tr>
			<tr>
				<td> Via: </td>
 				<td> <input type="text" name="via" id="via"> </td>
			</tr>
			<tr> <td colspan=2></td> </tr>
			<tr>
				<td colspan=2 align="center"> <input name="Aggiungi Viaggio" type="submit" id="AggiungiViaggio" value="AggiungiViaggio"> </td>
			</tr>
</table>

</form>
</body>
</html>