<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

 <head>
 
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body id = "fonte" >
          <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Empresa</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir esta Empresa?
                        </div>
                        <div class="modal-footer">
                            <form action="controller.do?command=ExcluirEmpresa" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-success"  value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>    <!-- /.modal -->

</body>

</html>
