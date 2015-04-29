<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_assuntos"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.HC_Lab_agendamento"%>
<%@page import="com.DBSettings"%>
<%@page import="com.HC_Lab_pessoa"%>
<%@page import="java.sql.ResultSet"%>
<%@ page pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%//codeGenVersion 2.0.72


Connection conn = DBSettings.getConexao();
if(session.getAttribute("usuario")!=null){
	
	
	HC_Lab_agendamento lab = new HC_Lab_agendamento();
	lab.setInTransaction(true);
	lab.setConnexao(conn);
	
	String matricula = request.getParameter("num_matricula") == null?"":request.getParameter("num_matricula").trim();
	String data_ini = request.getParameter("data_ini") == null?"":request.getParameter("data_ini").trim();
	String hora_ini = request.getParameter("hora_ini") == null?"":request.getParameter("hora_ini").trim();
	String cod_assunto = request.getParameter("cod_assunto") == null?"":request.getParameter("cod_assunto").trim();
	String okcancelado = request.getParameter("okcancelado") == null?"":request.getParameter("okcancelado").trim();
	
	if(!cod_assunto.equalsIgnoreCase("")){
		lab.setCodassunto(Integer.parseInt(cod_assunto));
	}
	
	lab.setFiltroIntervalo("1=1");
	Date dtIni = null;
	boolean errodata = false;
	try{
			dtIni = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data_ini+" 00:00:00");
	}catch(Exception e){
		errodata = true;
	}
	
	if(session.getAttribute("tipo").toString().equalsIgnoreCase("AL")){
		lab.setCodaluno(Long.parseLong(session.getAttribute("usuario").toString()));
	};
	
	ResultSet rs = null;
	//lab.lista();
	if ((data_ini!=null) && (!data_ini.equals(""))){
		rs = lab.carregaTabelaHorarios(data_ini);
	}
	
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
        <title>Cadastro de agendamento</title>

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
		form.action="cad_agendamento.jsp";
		form.submit();
	});

	$("#incluir").button().click(function(){
		var form = document.getElementById('forme');
		form.action="cad_agendamento.jsp";
		form.submit();
	});	
	
	$( ".data" ).datepicker();
	$(".ui-datepicker-trigger").css('position', 'relative');
	$(".ui-datepicker-trigger").css('top', '3px');
	$(".ui-datepicker-trigger").css('left', '1px');
	$(".data").mask("99/99/9999");
    
	$(".sys_remove").button().click(function(){
		$.blockUI({ message: 'Cancelado agendamento...' });
			cancelaAgendamento($(this).attr("seqagend"));
	 	$.unblockUI();
		return false;
		
	});
	
});


function cancelaAgendamento(seqagend){


	
	$.ajax({
	      type: "POST",                                                                                          
	      url: "lista_agendamentos_ajax.jsp",
	      dataType: "json",         
	      async: true, 
	      data: { cmd: 'cancelar',seqagend:seqagend
	      },
	      success:function (data) {
	    	  
	    	  if(data.msg!=undefined){
	    		 	 alert( "Erro: " + data.msg );
	    		 	 
		      }else{
					  alert('Agendamento cancelado!');
					  location.reload(true); 
		      }
	    	  
	      $.unblockUI();
	      },
	      error: function(msg){
	    	$.unblockUI();
	        alert( "Erro: " + msg.msg );
	      }
	   }); 
	
	
} 

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

function validaCampos(tipo){
	var data_ini = forme.data_ini.value;
	var hora_ini = forme.hora_ini.value;
	var cod_assunto = forme.cod_assunto.value;
	
	if (data_ini == ""){
		alert('Informe a data!');
		forme.data_ini.focus();
		return false;
	}
	
	if (tipo == "2"){
		if (hora_ini == ""){
			alert('Informe a hora!');
			forme.hora_ini.focus();
			return false;
		}
		
		if (cod_assunto == ""){
			alert('Escolha o assunto!');
			forme.cod_assunto.focus();
			return false;
		}
	}
}

</script>
        
        
    </head>
    <form id="forme" action="post">
    <body>
        <br>     
        <div style="width: 85%" class="container bs-docs-container">
            
            <div class="row">
		         
		         	<%if(!session.getAttribute("tipo").toString().equalsIgnoreCase("AL")){%>
		           <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">  
		           
		       				   <strong>Matricula:</strong><br> &nbsp;<input class="glowing-border" style="WIDTH: 80%"   onkeypress="return isNumberKey(event)"  id="num_matricula" name="num_matricula" type="text" maxlength="100">
		           
		           </div>
		           <% }%>
		           
		           <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">                
		           		   	  <strong>Data :</strong><br> &nbsp;<input class="data glowing-border" style="WIDTH: 80%" id="data_ini" name="data_ini" type="text" maxlength="100" value="<%=data_ini %>">
		           </div>
            
	               <div class="col-xs-3col-sm-3 col-md-3 col-lg-3">  
	           
	       				   <strong>Hora:</strong><br>
	       				    <select style="width: 80%" id="hora_ini" name="hora_ini"" class="glowing-border" >
	       				    <option value="">Escolha a Hora</option>
	       				    <option value="07:00" <%="07:00".equals(hora_ini)?"selected='selected'":"" %>>07:00</option>
	       				    <option value="08:00" <%="08:00".equals(hora_ini)?"selected='selected'":"" %>>08:00</option>
	       				    <option value="09:00" <%="09:00".equals(hora_ini)?"selected='selected'":"" %>>09:00</option>
	       				    <option value="10:00" <%="10:00".equals(hora_ini)?"selected='selected'":"" %>>10:00</option>
	       				    <option value="11:00" <%="11:00".equals(hora_ini)?"selected='selected'":"" %>>11:00</option>
	       				    <option value="13:00" <%="13:00".equals(hora_ini)?"selected='selected'":"" %>>13:00</option>
	       				    <option value="14:00" <%="14:00".equals(hora_ini)?"selected='selected'":"" %>>14:00</option>
	       				    <option value="15:00" <%="15:00".equals(hora_ini)?"selected='selected'":"" %>>15:00</option>
	       				    <option value="16:00" <%="16:00".equals(hora_ini)?"selected='selected'":"" %>>16:00</option>
	       				    <option value="19:00" <%="19:00".equals(hora_ini)?"selected='selected'":"" %>>19:00</option>
	       				    <option value="20:00" <%="20:00".equals(hora_ini)?"selected='selected'":"" %>>20:00</option>
	       				    <option value="21:00" <%="21:00".equals(hora_ini)?"selected='selected'":"" %>>21:00</option>
	       				    </select>
		           
		           </div>
		           
		           <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
		                     
		           		   	  <strong>Assunto:</strong><br> &nbsp;
		           		   	  <%HC_Lab_assuntos assuntos = new HC_Lab_assuntos();
		           		   	   assuntos.setConnexao(conn);
		           		   	   assuntos.setInTransaction(true);
		           		   	   assuntos.setOrderBy("desc_assunto");
		           		   	   assuntos.lista();
		           		   	  %>
		           		   	  
		           		   	  <select class="glowing-border" style="WIDTH: 80%" id="cod_assunto" name="cod_assunto" type="text" maxlength="100" >  
		           		   	  <option value="">Escolha o assunto:</option>
		           		   	  <%while(assuntos.next()){%>
		           		   		  <option value="<%=assuntos.getRsCodassunto()%>" <%=cod_assunto.equals(assuntos.getRsCodassunto().toString())?"selected='selected'":"" %>>  <%=assuntos.getRsDescassunto() %></option>
		           		   	  <% }%>
		           		   	  </select>
		           		   	  
		           </div>
		           
		     </div> 
		   <div class="row">  
            
              		<div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">       
              			<br>         
		           			<button class="btn btn-primary" id="filtrar" onclick="return validaCampos(1)">Visualizar Agendamentos</button>
		           	</div>
		           	
              		<div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">       
              			<br>         
		           			<button class="btn btn-primary" id="incluir" onclick="return validaCampos(2)">Incluir Agendamento</button>
		           	</div>
		           	
            </div>
            
             <div class="row">  
		         
           		 	
            
            </div>
            
            <br>
            <div class="row">
                <div id="divTab" class="bs-example"  style="height: 750px;  overflow-y: scroll;">
                    <table id="maquinasTab" class="table  header-fixed  table-striped table-bordered table-hover ">
                       <thead class="header">
                       <% if (rs!=null) { %>
                            <tr>
                                <th style="text-align: center; width: 10%">Hora:</th>
                                <th style="text-align: center; width: 15%">Segunda</th>
                                <th style="text-align: center; width: 15%">Terça</th>
                                <th style="text-align: center; width: 15%">Quarta</th>
                                <th style="text-align: center; width: 15%">Quinta</th>
                                <th style="text-align: center; width: 15%">Sexta</th>
                                <th style="text-align: center; width: 15%">Sábado</th>
                            </tr>
                        <% } %>
                        </thead>
                        <tbody>
                        <%
                        while((rs!=null) && (rs.next())){
                        %>
                        	<tr>
                        	    <td style="text-align: center; width: 10%" ><%=rs.getString("hora")+":00" %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("segunda") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("terca") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("quarta") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("quinta") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("sexta") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("sabado") %></td>
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
</body>
</form>
        
</html>
<%}else{%>
	
	Você não está logado
	
	
<%} %>
