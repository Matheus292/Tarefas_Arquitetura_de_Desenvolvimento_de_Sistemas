<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.usjt.refatoracao.model.*"%>
<%@ page import="br.com.usjt.refatoracao.service.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar</title>
</head>
<body>

	<%@ include file="menu.jsp"%>

		<h1>Empresas Cadastradas</h1>


		<%
			EmpresaService empresaService = new EmpresaService();
			List<Empresa> lista = empresaService.consultar();
		%>
		<table>
			<thead>
				<tr>

					<td><b>CNPJ</b></td>
					<td><b>Razão Social</b></td>
					<td><b>Telefone</b></td>
					<td><b>Endereço</b></td>
					<td><b>Horario de Abertura</b></td>
					<td><b>Horario de Fechamento</b></td>
					<td><b>Ação(es)</b></td>
				</tr>
			</thead>
			<%
				for (Empresa empresa : lista) {
			%>



			<tr>

				<td><%=empresa.getCnpj()%></td>
				<td><%=empresa.getRazaoSocial()%></td>
				<td><%=empresa.getTelefone()%></td>
				<td><%=empresa.getEndereco()%></td>
				<td><%=empresa.getHorarioAbertura()%></td>
				<td><%=empresa.getHorarioFechamento()%></td>
				<td>
				
				<a 	href="ManterEmpresa.do?opcao=Consultar&id=<%=empresa.getCnpj()%>">
						<button title="Consultar">Consultar</button>
				</a> 
					
				<a href="excluir.jsp?id=<%=empresa.getCnpj()%>" >
						<button  title="Excluir"> Excluir </button>
				</a>
						
						<a href="alterar.jsp?id=<%=empresa.getCnpj()%>">
						<button title="Alterar Empresa"> Alterar Empresa </button>
				</a>
				
				</td>
			</tr>
			<%
				}
			%>

		</table>
</body>
</html>