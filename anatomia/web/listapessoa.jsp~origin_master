<%@page import="com.HC_Lab_curso"%>
<%@page import="com.DBSettings"%>
<%@page import="com.HC_Lab_pessoa"%>
<%@ page pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%//codeGenVersion 2.0.72

if(session.getAttribute("usuario")!=null){
	
	   Connection conn = DBSettings.getConexao();
       HC_Lab_pessoa lab_pessoa = new HC_Lab_pessoa(); 
       lab_pessoa.setConnexao(conn);
       lab_pessoa.setInTransaction(true);
   
       
    String matricula = request.getParameter("num_matricula") == null?"":request.getParameter("num_matricula").trim(); 
   	String cod = request.getParameter("cod_pessoa") == null?"":request.getParameter("cod_pessoa").trim();
   	String nome = request.getParameter("desc_nome") == null?"":request.getParameter("desc_nome").trim();
   	String txtcurso = request.getParameter("txtcurso") == null?"":request.getParameter("txtcurso").trim();
   	String ativobloqueado = request.getParameter("ativobloqueado") == null?"":request.getParameter("ativobloqueado").trim();
   	
   	if(!matricula.equalsIgnoreCase(""))
   		lab_pessoa.setNummatricula(Long.parseLong(matricula));
   	
   	if(!cod.equalsIgnoreCase(""))
   		lab_pessoa.setCodpessoa(Long.parseLong(cod));
   	
   	if(!nome.equalsIgnoreCase(""))
   		lab_pessoa.setFiltroIntervalo("desc_nome ilike '%"+nome+"%'");
   	
   	if(!txtcurso.equalsIgnoreCase(""))
   		lab_pessoa.setCodcurso(Long.parseLong(txtcurso));
   	
   	if(!ativobloqueado.equalsIgnoreCase(""))
   		lab_pessoa.setFlagsituacao(ativobloqueado);
   	
    lab_pessoa.lista();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<html>

<style>

	.radius {
		-moz-border-radius: 6px;
		-webkit-border-radius: 6px;
		border-radius: 6px;
	}
	
	
	.glowing-border {
		border: 2px solid #dadada;
		border-radius: 7px;
	}
	
	.glowing-border:focus {
		outline: none;
		border-color: #9ecaed;
		box-shadow: 0 0 10px #9ecaed;
	}
</style>




    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista pessoas</title>

        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/autoNumeric.1.9.22.js" charset="utf-8"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.blockUI.js"></script>  
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquerydatepicker-ptbr.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.dataTables.js" charset="utf-8" language="javascript"></script>
        <link rel="stylesheet" type="text/css" href="JavaScript/jquery-ui-1.10.4.custom/css/ui-blitz/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="JavaScript/jquery-ui-1.10.4.custom/css/jquery.dataTables.css" />
        <script type="text/javascript" src="JavaScript/bootbox.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="JavaScript/bootstrap-3.2.0-dist/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="JavaScript/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="JavaScript/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
        <script src="JavaScript/jquery.modern-blink.js"></script>
        
            <script>
        
$(document).ready(function() {
	
	$("#filtrar").button().click(function(){
		var form = document.getElementById('forme');
		form.action="listapessoa.jsp";
		form.submit();
	});
	
	
	$(".sys_edit").button().click(function(){
		var form = document.getElementById('forme');
		form.action="telpessoanovo.jsp?cod_pessoa="+$(this).attr("codpess");
		form.submit();
	});
	
 
  
	
});

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
//-->
</script>
        
    </head>
    <body>
    
    <form method="post" id="forme">
        <br>     
        <div class="container bs-docs-container">
        
           <div class="row">  
		           <div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">                
		           		   	  <strong>Cód pessoa:</strong><br> <input class="glowing-border" style="WIDTH: 80%"   onkeypress="return isNumberKey(event)"  id="cod_pessoa" name="cod_pessoa" type="text" maxlength="100">
		           </div>
            
           		 	<div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">                
		           		   	  <strong>Nome:</strong><br> <input class="glowing-border" style="WIDTH: 80%"    id="desc_nome" name="desc_nome" type="text" maxlength="100">
		           </div>
               
            
         
		           
		             <div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">  
		           
		       				   <strong>Matricula:</strong><br> <input class="glowing-border" style="WIDTH: 80%"   onkeypress="return isNumberKey(event)"  id="num_matricula" name="num_matricula" type="text" maxlength="100">
		           
		           </div>
            </div>
        
                  <div class="row">
		         
		         
		           <div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">
		                     
		           		   	  <strong>Curso:</strong><br> 
		           		   	  <%HC_Lab_curso curso = new HC_Lab_curso();
				           		 curso.setConnexao(conn);
				           		curso.setInTransaction(true);
				           		curso.setOrderBy("desc_curso");
				           		curso.lista();
		           		   	  %>
		           		   	  
		           		   	  <select  class="glowing-border" style="WIDTH: 80%" id="txtcurso" name="txtcurso" type="text" maxlength="100" >  
		           		   	  <option value=""> Todos</option>
		           		   	  <%while(curso.next()){%>
		           		   		  <option value="<%=curso.getRsCodcurso()%>" >  <%=curso.getRsDesccurso() %></option>
		           		   	  <% }%>
		           		   	  </select>
		           		   	  
		           </div>
		             <div class="col-xs-4col-sm-4 col-md-3 col-lg-3">  
		           
		       				   <strong >Liberado/Bloqueado:</strong><br>
		       				    <select style="width: 80%" id="ativobloqueado" name="ativobloqueado"" class="glowing-border" >
		       				    <option value="">Ambos</option>
		       				    <option value="L">Liberado</option>
		       				    <option value="B">Bloqueado</option>
		       				    </select>
		           
		           </div>
		           
		                <div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">     
              <br>           
		           		   	 <button class="btn btn-primary" id="filtrar">Filtrar</button>
		           </div>
		         
		     </div> 
		
            
        
        <br>
            <div class="row">
                <div id="divTab" class="bs-example"  style="height: 400px;  overflow-y: scroll;">
                    <table id="maquinasTab" class="table table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <th style="text-align: center; width: 5%">Cód</th>
                                <th style="text-align: center; width: 20%">nome</th>
                                <th style="text-align: center; width: 10%">Matricula</th>
                                <th style="text-align: center; width: 20%">curso</th>
                                <th style="text-align: center; width: 10%">Num telefone</th>
                                <th style="text-align: center; width: 15%">Email</th>
                                <th style="text-align: center; width: 15%">Situação</th>
                                   <th style="text-align: center; width: 15%"></th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        <%
                     
                        while(lab_pessoa.next()){
	                        String situacao = "";
	                        if(lab_pessoa.getRsFlagsituacao()==null){
	                        	situacao  = "Liberado";
	                        }else if(lab_pessoa.getRsFlagsituacao().equalsIgnoreCase("")){
	                        	situacao  = "Liberado";
	                        }else if(lab_pessoa.getRsFlagsituacao().equalsIgnoreCase("L")){
	                        	situacao  = "Liberado";
	                        }else if(lab_pessoa.getRsFlagsituacao().equalsIgnoreCase("B")){
	                        	situacao  = "Bloqueado";
	                        }
                        %>
                        	<tr>
								<td><%=lab_pessoa.getRsCodpessoa()%></td>
								<td><%=lab_pessoa.getRsDescnome()%></td>
								<td><%=lab_pessoa.getRsNummatricula()%></td>
								<td><%=lab_pessoa.getObCodcurso().getRsDesccurso()%></td>
								<td><%=lab_pessoa.getRsNumtelefone()%></td>
								<td><%=lab_pessoa.getRsDescemail()%></td>
								<td><%=situacao%></td>
								<td><button class="sys_edit btn btn-primary" codpess="<%=lab_pessoa.getRsCodpessoa()%>" >Editar</button></td>                        	
                        	</tr>

                        <%}
                        conn.close();
                        %>
                        
                            <tr class="active">
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        </form>
       </body>
</html>
<%}else{%>
	
	Você não está logado
	
	
<%} %>
