<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<%@ page import="br.com.usjt.refatoracao.model.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirecionamento</title>

<% Empresa empresa = ( Empresa )request.getAttribute( "empresa" ); %>

<script type="text/javascript">
window.setTimeout( alert( "Operação realizada com sucesso !" ) , redirecionar( ) , 3000 );


function redirecionar(  )
{	
	window.location.href = "ManterEmpresa"+".do"+"?opcao=Consultar&id=" + <%=empresa.getCnpj( )%>;
}
</script>
</head>
<body>
	
</body>
</html>