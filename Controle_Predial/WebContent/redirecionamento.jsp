<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirecionamento</title>

<script type="text/javascript">
window.setTimeout( alert( "Operação realizada com sucesso !" ) , redirecionar( ) , 3000 );


function redirecionar(  )
{	
	window.location.href = "ManterEmpresa"+".do"+"?opcao=Consultar&id=" + ${ empresa.cnpj };
}
</script>
</head>
<body>
	
</body>
</html>