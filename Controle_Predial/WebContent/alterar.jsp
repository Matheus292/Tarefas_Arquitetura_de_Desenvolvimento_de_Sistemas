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

		<h1 >Alterar empresa</h1>

		<form name="formulario" action="AlterarEmpresa.do" method="post">

		<input type="hidden" name="cnpj" value=<%=empresa.getCnpj( ) %>>

					<label>CNPJ:</label> <input type="text" 
						  maxlength="14" required
						value=<%=empresa.getCnpj( ) %>
						placeholder="CNPJ no formato xx.xxx.xxx/xxxx-xx" disabled /><br>
			
			
								<label>Razão Social:</label> <input type="text" name="razao"
						 required maxlength="100"
						placeholder="Insira a razão social"
						value="<%= empresa.getRazaoSocial( ) %>"> <br>
			
								<label>Endereço:</label> <input type="text" name="endereco"
						 required
						value="<%= empresa.getEndereco( ) %> "
						placeholder="Insira o endereço" /><br>
			

					<label>Telefone:</label> <input type="text" name="fone" required
						value="<%=empresa.getTelefone( )%>"
						placeholder="Telefone com ddd no formato (99) 9999-9999" /><br>
			
					<label>Horário de Funcionameto:</label>
			
					<input type="time" name="horarioInicial" required 
						value=<%=empresa.getHorarioAbertura()%> /> 
						<label>às</label> <input
						type="time" name="horarioFinal" required 
						value=<%=empresa.getHorarioFechamento()%> /><br>
			
					<label>Funcionamento do Ar Condicionado:</label>
			

					<input type="time" name="arHorarioInicial" value=<%=controle.getHorarioInicial( ) %> required />
					<label>às</label> <input type="time" name="arHorarioFinal" value=<%=controle.getHorarioFinal( ) %> required
						 /><br>

					<label>Temperatura máxima do Ar Condicionado:</label>

					<input type="number" name="temperatura" min="0" max="40"  value=<%=controle.getTemperaturaMaxima( ) %>
						required /><br>

					<label>Conjuntos Dísponiveis:</label>

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
		
					<br><br>

					<label>Conjunto ocupado pela empresa</label>

					<label> <%=servico.consultarConjuntoOcupado( empresa ) %></label>
					 <input
						type="radio" name="CONJUNTO"
						value=<%=servico.consultarConjuntoOcupado( empresa ) %> checked />
			
			<br> <br>
			<input type="submit" value="Salvar alterações" /> 
					<a href="consultar.jsp">
				<button>Cancelar</button></a> 
				<br>
			<br>
		</form>
</body>
</html>