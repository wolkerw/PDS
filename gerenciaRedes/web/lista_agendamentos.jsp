<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_assuntos"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.HC_Lab_agendamento"%>
<%@page import="com.DBSettings"%>
<%@page import="com.HC_Lab_pessoa"%>
<%@ page pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%//codeGenVersion 2.0.72


Connection conn = DBSettings.getConexao();
if(session.getAttribute("usuario")!=null){
	
	
	HC_Lab_agendamento lab = new HC_Lab_agendamento();
	lab.setInTransaction(true);
	lab.setConnexao(conn);
	lab.setOrderBy("data_ini desc");
	lab.setJoin(
	" FROM lab_agendamento "  +
    "	LEFT join lab_pessoa " +  
    "	  ON lab_agendamento.cod_aluno = lab_pessoa.cod_pessoa " + 
    "	LEFT join lab_assuntos   " +
    "	  ON lab_agendamento.cod_assunto = lab_assuntos.cod_assunto "); 
	
	String matricula = request.getParameter("num_matricula") == null?"":request.getParameter("num_matricula").trim();
	String data_fim = request.getParameter("data_fim") == null?"":request.getParameter("data_fim").trim();
	String data_ini = request.getParameter("data_ini") == null?"":request.getParameter("data_ini").trim();
	String cod_assunto = request.getParameter("cod_assunto") == null?"":request.getParameter("cod_assunto").trim();
	String okcancelado = request.getParameter("okcancelado") == null?"":request.getParameter("okcancelado").trim();
	String flagpresenca = request.getParameter("flagpresenca") == null?"":request.getParameter("flagpresenca").trim();
	String checkmodo = request.getParameter("checkmodo") == null?"N":"S";
	
	
	
	
	if(!cod_assunto.equalsIgnoreCase("")){
		lab.setCodassunto(Integer.parseInt(cod_assunto));
	}
	
	lab.setFiltroIntervalo("1=1");
	Date dtIni = null;
	Date dtFim = null;
	boolean errodata = false;
	try{
			dtIni = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data_ini+" 00:00:00");
	}catch(Exception e){
		errodata = true;
	}
	try{
			dtFim = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data_fim+" 23:59:59");
	}catch(Exception e){
		errodata = true;
	}
	
	if(okcancelado.equalsIgnoreCase("")){
		
	}else if(okcancelado.equalsIgnoreCase("O")){
		lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and Coalesce(flag_staus,'O') = 'O' ");		
	} else if(okcancelado.equalsIgnoreCase("C")){
		lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and flag_staus = 'C' ");
	}

	
	if(!errodata)
		lab.setFiltroIntervalo(lab.getFiltroIntervalo() + "  AND Lab_agendamento.data_ini BETWEEN '"+ new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(dtIni) +"' AND '"+ new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(dtFim) +"' ");
	
	if(!matricula.equalsIgnoreCase("")){
		lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and lab_pessoa.num_matricula = " +  matricula );
	}
	
	if(!flagpresenca.equalsIgnoreCase("")){
	
		if(flagpresenca.equalsIgnoreCase("A")){
			lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and Coalesce(flag_presenca,'A') = 'A' and  Coalesce(flag_staus,'O') = 'O'  ");		
		} else if(flagpresenca.equalsIgnoreCase("S")){
			lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and flag_presenca = 'S' and  Coalesce(flag_staus,'O') = 'O'");
		} else if(flagpresenca.equalsIgnoreCase("N")){
			lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and flag_presenca = 'N' and  Coalesce(flag_staus,'O') = 'O' ");
		}
		
	}
	
	if(session.getAttribute("tipo").toString().equalsIgnoreCase("AL")){
		lab.setCodaluno(Long.parseLong(session.getAttribute("usuario").toString()));
	};
	
	if(checkmodo.equalsIgnoreCase("S")){
		lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and data_ini  >= '" +  new SimpleDateFormat("yyyyMMdd ").format(new Date())+"' ");
		lab.setOrderBy("data_ini asc");
	}
	
	
	lab.setTop("1000");
	lab.lista();
	
	
	
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
        <title>Lista agendamentos</title>

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
		form.action="lista_agendamentos.jsp";
		form.submit();
	});
	
	$( ".data" ).datepicker();
	$(".ui-datepicker-trigger").css('position', 'relative');
	$(".ui-datepicker-trigger").css('top', '3px');
	$(".ui-datepicker-trigger").css('left', '1px');
	$(".data").mask("99/99/9999");
    
	$(".sys_cancela").button().click(function(){
		$.blockUI({ message: 'Cancelado agendamento...' });
			cancelaAgendamento($(this).attr("seqagend"));
	 	$.unblockUI();
		return false;
		
	});
	
		
	$(".sys_presenca").button().click(function(){
	   $("#div_presenca").dialog("open");
	   
	   carregaPresenca($(this).attr("seqagend"));
		return false;
	});
	
	
	$('#div_presenca').dialog({
		height : 500,
		width : 650,
		title : 'Presença',
		zIndex : 500,
		autoOpen : false,
		modal : true,
		 closeOnEscape: true,
		   open: function(event, ui) {
					
			   
			
			 $(this).parent().children().children(".ui-dialog-titlebar-close").hide();
    	},
		position : [ 'center', 'center' ],
		buttons:{
			
		 "Cancelar": function(){
	  	         $("#div_presenca").dialog("close");		
 	     },
 	     "Salvar": function(){
 	    	 
 	    	salvar();
 	    	 
 	    	    $("#seq_agendamento").val("");
				$("#desc_motivo").val("");
				$("input[name='opc_presen'][value='A']").prop('checked', true);
 	       	     $("#div_presenca").dialog("close");		
     	  }

		}
})	;
	
	
	
	
});


function carregaPresenca(seqagend){
	
	$.ajax({
	      type: "POST",                                                                                          
	      url: "lista_agendamentos_ajax.jsp",
	      dataType: "json",         
	      async: true, 
	      data: { cmd: 'carregapresenca',seqagend:seqagend
	      },
	      success:function (data) {
	    	  
	    	  if(data.msg!=undefined){
	    		 	 alert( "Erro: " + data.msg );
	    		 	 
		      }else{
					
		    	    $("#seq_agendamento").val(data.seq_agendamento);
					$("#desc_motivo").val(data.motivo);
					$("input[name='opc_presen'][value='" + data.flag_presenca + "']").prop('checked', true);
		    	  
		      }
	    	  
	      $.unblockUI();
	      },
	      error: function(msg){
	    	$.unblockUI();
	        alert( "Erro: " + msg.msg );
	      }
	   });
	
	
}

function salvar(){
	
var seqagend =    $("#seq_agendamento").val();
var desc_motivo = 	$("#desc_motivo").val();
var presen =$("input[name='opc_presen']:checked").val() 
	
	$.ajax({
	      type: "POST",                                                                                          
	      url: "lista_agendamentos_ajax.jsp",
	      dataType: "json",         
	      async: true, 
	      data: { cmd: 'salvar',
	    	  seqagend:seqagend,
	    	  desc_motivo:desc_motivo,
	    	  presen:presen
	    	  
	      },
	      success:function (data) {
	    	  if(data.msg!=undefined){
	    		 	 alert( "Erro: " + data.msg );
	    		 	 
		      }else{
					  alert('Dados salvos!');
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
		                     
		           		   	  <strong>Assunto:</strong><br> &nbsp;
		           		   	  <%HC_Lab_assuntos assuntos = new HC_Lab_assuntos();
		           		   	   assuntos.setConnexao(conn);
		           		   	   assuntos.setInTransaction(true);
		           		   	   assuntos.setOrderBy("desc_assunto");
		           		   	   
		           		   	   assuntos.lista();
		           		   	  %>
		           		   	  
		           		   	  <select class="glowing-border" style="WIDTH: 80%" id="cod_assunto" name="cod_assunto" type="text" maxlength="100" >  
		           		   	  <option value=""> Todos</option>
		           		   	  <%while(assuntos.next()){%>
		           		   		  <option value="<%=assuntos.getRsCodassunto()%>" >  <%=assuntos.getRsDescassunto() %></option>
		           		   	  <% }%>
		           		   	  </select>
		           		   	  
		           </div>
		           
		           
		               <div class="col-xs-3col-sm-3 col-md-3 col-lg-3">  
		           
		       				   <strong >OK/Cancelado:</strong><br>
		       				    <select style="width: 80%" id="okcancelado" name="okcancelado"" class="glowing-border" >
		       				    <option value="">Ambos</option>
		       				    <option value="O">Ok</option>
		       				    <option value="C">Cancelado</option>
		       				    </select>
		           
		           </div>
		         
		           
		               <div class="col-xs-3col-sm-3 col-md-3 col-lg-3">  
		           
		       				   <strong >Presença:</strong><br>
		       				    <select style="width: 80%" id="okcancelado" name="flagpresenca"" class="glowing-border" >
		       				    <option value=""></option>
		       				    <option value="A">Em aberto</option>
		       				    <option value="S">Presente</option>
		       				    <option value="N">Ausente</option>
		       				    </select>
		           
		           </div>
		         
		     </div> 
		   <div class="row">  
		           <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">                
		           		   	  <strong>Período - Data inicial :</strong><br> &nbsp;<input class="data glowing-border" style="WIDTH: 80%" id="data_ini" name="data_ini" type="text" maxlength="100">
		           </div>
            
           		 	<div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">                
		           		   	  <strong>Período - Data final :</strong><br> &nbsp;<input class="data glowing-border" style="WIDTH: 80%" id="data_fim" name="data_fim" type="text" maxlength="100">
		           </div>
            
            
             <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">       
              <br>         
		           		   <strong>Modo relatório:</strong> &nbsp;<input title="Lista os registros somente apartir da data atual e em ordem crescente."   id="checkmodo" name="checkmodo" type="checkbox" >
		           </div>
            
            
              <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">       
              <br>         
		           		   	 <button class="btn btn-primary" title="" id="filtrar">Filtrar</button>
		           </div>
            </div>
            
             <div class="row">  
		         
           		 	
            
            </div>
            
            <br>
            <div class="row">
                <div id="divTab" class="bs-example"  style="height: 750px;  overflow-y: scroll;">
                <strong>Máximo de 1000 registros serão listados.</strong>
                <br>
                    <table style="font-size: 80%" id="maquinasTab" class="table  header-fixed  table-striped table-bordered table-hover ">
                       <thead class="header">
                            <tr>
                                <th style="text-align: center; width: 15%">Aluno</th>
                                <th style="text-align: center; width: 15%">Professor</th>
                                <th style="text-align: center; width: 20%">Assunto</th>
                                <th style="text-align: center; width: 15%">Data</th>
                                <th style="text-align: center; width: 25%">Presença/Motivo</th>
                                <th style="text-align: center; width: 5%">Status</th>
                                
                                <th style="text-align: center; width: 5%"></th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                        while(lab.next()){
                        	String status ="";
                        	if(lab.getRsFlagstaus()==null){
                        		status = "Ok";
                        	}
                        	else if(lab.getRsFlagstaus().equalsIgnoreCase("C")){
                        		status = "Cancelado";
                        	}else if(lab.getRsFlagstaus().equalsIgnoreCase("O")){
                        		status = "Ok";
                        	}
                        
                        %>
                        	<tr>
								<td style="text-align: center; " ><%=lab.getObCodaluno().getRsNummatricula() + " - " + lab.getObCodaluno().getRsDescnome()%></td>
								<td style="text-align: center; " ><%=lab.getObCodprofessor().getRsDescnome()%></td>
								<td style="text-align: center; " ><%=lab.getObCodassunto().getRsDescassunto()%></td>
								<td style="text-align: center; " ><%=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(lab.getRsDataini())%></td>
								
							
							
							<td style="text-align: center; width: 15%">
							<table>
							<tr>
								<%if(status.equalsIgnoreCase("ok")){
									String texto = "";
									if(lab.getRsFlagpresenca()==null || lab.getRsFlagpresenca().equalsIgnoreCase("") || lab.getRsFlagpresenca().equalsIgnoreCase("A") ){
										texto = "Aberto";
									}else if(lab.getRsFlagpresenca().equalsIgnoreCase("S")){
										texto = "Presente";
									}else if(lab.getRsFlagpresenca().equalsIgnoreCase("N")){
										texto = "Ausente";
									}
									texto = texto + (lab.getRsDescmotivo()==null?"": (" - " +  lab.getRsDescmotivo()));
									
									%>
									
									<td  align="left" style="width: 95%">
									<%=texto%>
									</td>
									<td align="right">
									<div style="display: inline" align="right">
										<button   seqagend="<%=lab.getRsSeqagendametno()%>" type="button" class="sys_presenca btn-xs btn-primary"  >
										  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									</button>
									</td>
									
									</div> 
								<%}%>
								</tr>
								</table>
								</td>
								
								<td style="text-align: center; " ><%=status%></td>
								<td style="text-align: center; width: 15%">
							
							
							
								<%if(status.equalsIgnoreCase("ok") && (lab.getRsFlagpresenca()==null || lab.getRsFlagpresenca().equalsIgnoreCase("") || lab.getRsFlagpresenca().equalsIgnoreCase("A") )){ %> 
									<button style="font-size: 80%" seqagend="<%=lab.getRsSeqagendametno()%>" class="sys_cancela btn btn-primary"  >Cancelar</button> 
								<%}%>
								</td>
								
								
								
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
        
        
        
        
        	<div style="width: 75%" id="div_presenca">
					<div  class="container" style="align: center; width: 95%" id="parent">
						<input type="hidden" id="seq_agendamento" name="seq_agendamento">
							<div style="width: 90%" class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<strong> Presença:</strong> <br>
									<input type='radio'  name='opc_presen' value='S'>  <strong>Presente</strong>   
									<input type='radio'  name='opc_presen' value='N'>  <strong>Ausente</strong> 
									<input type='radio'  name='opc_presen' value='A'>  <strong>Em aberto</strong>
								</div>
								</div>
								<br>
								<div style="width: 90%" class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<strong>Observação/Motivo:</strong><br>
									<textarea id="desc_motivo" rows="5" style="width: 95%"></textarea>
								</div>
								
							
							</div>
					
					
					</div>

	</div>
        
</body>
</form>
        
</html>
<%}else{%>
	
	Você não está logado
	
	
<%} %>
