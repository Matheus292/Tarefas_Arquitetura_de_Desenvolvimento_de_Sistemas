<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.usjt.refatoracao.model.*"%>
<%@ page import="br.com.usjt.refatoracao.service.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar empresa</title>
<link rel="icon" href="./imagens/icone.ico">
<link href="css/estilo.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
	<%@ include file="menu.jsp"%>

	<%
		EmpresaService empresaService = new EmpresaService( );
		ControleTemperaturaService controleService = new ControleTemperaturaService( );	
	
		String cnpj = request.getParameter( "id" );
		Empresa empresa = new Empresa( );
		empresa.setCnpj( cnpj );		
		empresa = empresaService.consultar( empresa.getCnpj( ) );
		
		ControleTemperatura controle = new ControleTemperatura( );
		controle = controleService.consultar( empresa );
	%>

	<div id="main" class="container">


		<h1 class="page-header">Alterar empresa</h1>

		<form name="formulario" action="AlterarEmpresa.do" method="post">

		<input type="hidden" name="cnpj" value=<%=empresa.getCnpj( ) %>>

			<div class="row">
				<div class="form-group col-md-12">
					<label>CNPJ:</label> <input type="text" class="form-control"
						id="fonte"  maxlength="14" required
						value=<%=empresa.getCnpj( ) %>
						placeholder="CNPJ no formato xx.xxx.xxx/xxxx-xx" disabled /><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Razão Social:</label> <input type="text" name="razao"
						class="form-control" id="fonte" required maxlength="100"
						placeholder="Insira a razão social"
						value="<%= empresa.getRazaoSocial( ) %>"> <br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Endereço:</label> <input type="text" name="endereco"
						id="fonte" class="form-control" required
						value="<%= empresa.getEndereco( ) %> "
						placeholder="Insira o endereço" /><br>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label>Telefone:</label> <input type="text" name="fone" required
						id="fonte" class="form-control"
						value="<%=empresa.getTelefone( )%>"
						placeholder="Telefone com ddd no formato (99) 9999-9999" /><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Horário de Funcionameto:</label>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<input type="time" name="horarioInicial" required id="fonte"
						value=<%=empresa.getHorarioAbertura()%> /> <label>às</label> <input
						type="time" name="horarioFinal" required id="fonte"
						value=<%=empresa.getHorarioFechamento()%> /><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label>Funcionamento do Ar Condicionado:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<input type="time" name="arHorarioInicial" value=<%=controle.getHorarioInicial( ) %> required id="fonte" />
					<label>às</label> <input type="time" name="arHorarioFinal" value=<%=controle.getHorarioFinal( ) %> required
						id="fonte" /><br>

				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-8">
					<label>Temperatura máxima do Ar Condicionado:</label>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-8">
					<input type="number" name="temperatura" min="0" max="40" id="fonte" value=<%=controle.getTemperaturaMaxima( ) %>
						required /><br>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					<label>Conjuntos Dísponiveis:</label>
				</div>

				<div class="form-group col-md-6">
					<label>Conjunto ocupado pela empresa</label>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<%
						ConjuntoService servico = new ConjuntoService();
						List<Conjunto> lista = servico.consultarConjuntoDesocupado();

						for (Conjunto conjunto : lista) {
					%>
					<label> <%=conjunto%>
					</label> <input type="radio" name="CONJUNTO" value=<%=conjunto%> checked />
					<%
						}
					%>
				</div>

				<div class="form-group col-md-6">
					<label> <%=servico.consultarConjuntoOcupado( empresa ) %></label> <input
						type="radio" name="CONJUNTO"
						value=<%=servico.consultarConjuntoOcupado( empresa ) %> checked />
				</div>
			</div>
			<hr />

			<br> <input type="submit" class="btn btn-success"
				value="Salvar alterações" /> 
				
				<a href="consultar.jsp"
				class="btn btn-default">Cancelar</a> <br>
			<br>
		</form>
	</div>
</body>
</html>