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
<link rel="icon" href="./imagens/icone.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="menu.jsp"%>
	<%@include file="exclusao.jsp"%>
	<div id="main" class="container">

		<h1 class="page-header">Empresas Cadastradas</h1>


		<%
			EmpresaService empresaService = new EmpresaService();
			List<Empresa> lista = empresaService.consultar();
		%>
		<table class="table table-striped">
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
				<td><a type="button"
					href="ManterEmpresa.do?opcao=Consultar&id=<%=empresa.getCnpj()%>">
						<button class="glyphicon glyphicon-book + btn btn-info"
							title="Consultar"></button>
				</a> 

					<button id="<%=empresa.getCnpj()%>" type="button"
						class="glyphicon glyphicon-trash + btn btn-danger" title="Excluir"
						data-toggle="modal" data-target="#delete-modal"		data-cliente="<%=empresa.getCnpj()%>">
						
						</button> 
						
						<a	type="button" href="alterar.jsp?id=<%=empresa.getCnpj()%>">
						<button class="glyphicon glyphicon-pencil + btn btn-warning"
							title="Alterar Empresa"></button>
				</a>
				
				</td>
			</tr>
			<%
				}
			%>

		</table>

		<script type="text/javascript">
			$("#delete-modal").on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget); //botao que disparou a modal
				var recipient = button.data('cliente');
				$("#id_excluir").val(recipient);
			});
		</script>


	</div>
</body>
</html>