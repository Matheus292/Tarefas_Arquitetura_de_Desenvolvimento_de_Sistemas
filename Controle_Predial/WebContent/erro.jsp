<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	
	<c:import url="menu.jsp"/>

	<div id="main" class="container">
		<div id="borda">
			<h3 id="h1" class="page-header">Não foi possivel realizar a
				operação! <br> Verifique os dados </h3>
				
			<a href="javascript:history.go(-1);"> <input type="button"
			class="btn btn-default"	value="Voltar" />
			</a>

		</div>
	</div>


	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>