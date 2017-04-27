<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.usjt.refatoracao.model.*"%>
<%@ page import="br.com.usjt.refatoracao.service.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Nova empresa</title>

</head>

<body>
	<%@ include file="menu.jsp"%>


		<h1>Cadastrar nova empresa</h1>

		<form id="formulario" action="ManterEmpresa.do" method="post">

					<label>CNPJ:</label> <input type="text" 
						name="cnpj" maxlength="14" required
						placeholder="CNPJ no formato xx.xxx.xxx/xxxx-xx" /><br>

					<label>Raz�o Social:</label> <input type="text" name="razao" 
					 required placeholder="Insira a raz�o social" /><br>


					<label>Endere�o:</label> <input type="text" name="endereco" 
						 required placeholder="Insira o endere�o" /><br>
	
					<label>Telefone:</label> <input type="text" name="fone" required 
						placeholder="Telefone com ddd no formato (99) 9999-9999" /><br>
				
					<label>Hor�rio de Funcionameto:</label>
			

					<input type="time" name="horarioInicial" required /> <label>�s</label>
					<input type="time" name="horarioFinal" required  /><br>
				
					<label>Funcionamento do Ar Condicionado:</label>
				

					<input type="time" name="arHorarioInicial" required /> <label>�s</label>
					<input type="time" name="arHorarioFinal" required /><br>

					<label>Temperatura m�xima do Ar Condicionado:</label> 

					<input
						type="number" name="temperatura" min="0" max="40" required/><br>
				
					<label>Conjuntos D�sponiveis:</label>
				
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
					<br>
			<input type="submit" name = "opcao" value="Cadastrar"/>
			 <input type="reset" class="btn btn-default" value="Limpar" />
			<br><br>
		</form>
</body>
</html>