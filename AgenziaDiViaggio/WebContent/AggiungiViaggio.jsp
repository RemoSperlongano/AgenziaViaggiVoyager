<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<!-- Si dichiara la variabile trattaBean e istanzia un oggetto TrattaBean -->
	<jsp:useBean id="AggiungiTrattaBean" scope="request"
	class="gestione_Catalogo.bean.AggiungiTrattaBean" />
    
    <jsp:setProperty name="AggiungiTrattaBean" property="*" />
	<!-- Imposta automaticamente tutti gli attributi dell'oggetto aggiungiTrattaBean -->

	<%
	if (request.getParameter("ambiente") != null) {
		
		if (true) {
			%>
			<!-- Passa il controllo alla nuova pagina 
			<jsp:forward page="AggiungiViaggio.jsp" />-->
			<%
		}
	}
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi Viaggio al Catalogo</title>
</head>

<body>

<form>
Ambiente: <select name="ambiente">
<option value="aria">Aria</option>
<option value="mare">Mare</option>
<option value="terra" selected>Terra</option>
</select>
<br>

Mezzo: <input type="text" name="Mezzo" id="Mezzo"><br>
Città di partenza: <input type="text" name="partenza" id="partenza"><br>
Città di arrivo: <input type="text" name="arrivo" id="arrivo"><br>
Via: <input type="text" name="intermedia" id="intermedia"> <br>
Info: <input type="text" name="info" id="info">

 

<input name="Aggiungi Viaggio" type="submit" id="AggiungiViaggio" value="AggiungiViaggio">

</form>
</body>
</html>