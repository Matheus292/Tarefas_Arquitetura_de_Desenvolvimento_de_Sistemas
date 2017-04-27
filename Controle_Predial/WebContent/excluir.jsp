<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<%@ page import = "br.com.usjt.refatoracao.model.*" %>
<%@ page import = "br.com.usjt.refatoracao.service.*" %>
<%@ page import = "java.util.*" %> 
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluindo</title>
<meta http-equiv="refresh" content="0; consultar.jsp">
</head>
<body>
			
			
			<%
			EmpresaService empresaService = new EmpresaService( );
			ConjuntoService conjuntoService = new ConjuntoService();
			ControleTemperaturaService controleTemperaturaService= new  ControleTemperaturaService( );
			
			String cnpj = request.getParameter("id");
			
			
			controleTemperaturaService.excluir(cnpj);
			conjuntoService.desocuparConjuntos(cnpj);
			empresaService.excluirPorCnpj(cnpj);
			%>
			
			



</body>
</html>