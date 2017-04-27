<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.usjt.refatoracao.model.*"%>
<%@ page import="br.com.usjt.refatoracao.service.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empresa</title>

<script src="js/update.js">
( window )
</script>
</head>

<body>
	<%@ include file="menu.jsp"%>

	<%
		Empresa empresa = ( Empresa ) request.getAttribute("empresa");
		ControleTemperatura controle = (ControleTemperatura) request.getAttribute("controle");
		Conjunto conjunto = ( Conjunto )request.getAttribute( "conjunto" );
	%>



	<h1>Dados da empresa</h1>

<br>
				<label>CNPJ:</label>
				<%=empresa.getCnpj()%>
				<br>

						<label>Razão Social:</label>
				<%=empresa.getRazaoSocial()%>
<br>

				<label>Endereço:</label>
				<%=empresa.getEndereco()%>
<br>

				<label>Telefone:</label>
				<%=empresa.getTelefone()%>
<br>

				<label>Horário de Funcionamento:</label>
				<%=empresa.getHorarioAbertura()%>
				<label> às </label><%=" " + empresa.getHorarioFechamento()%><br>


			<label>Funcionamento do Ar Condicionado:</label>
				<%=controle.getHorarioInicial()%>
				<label>às</label>
				<%=controle.getHorarioFinal()%>
				<br>
				
				<label>Temperatura:</label>
				<%=controle.getTemperaturaMaxima()%><br>
			
				<label>Conjunto ocupado pela empresa: </label>
				<%= conjunto %><br>		
			
				<a 	href="consultar.jsp">
						<button title="Listar empresas">Listar empresas</button>
				</a> 
					
				<a href="excluir.jsp?id=<%=empresa.getCnpj()%>" >
						<button  title="Excluir"> Excluir </button>
				</a>
						
						<a href="alterar.jsp?id=<%=empresa.getCnpj()%>">
						<button title="Alterar Empresa"> Alterar Empresa </button>
				</a>
</body>
</html>