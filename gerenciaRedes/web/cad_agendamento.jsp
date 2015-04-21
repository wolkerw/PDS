<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_assuntos"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.HC_Lab_agendamento"%>
<%@page import="com.DBSettings"%>
<%@page import="com.HC_Lab_pessoa"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>

<%@ page pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%//codeGenVersion 2.0.72


Connection conn = DBSettings.getConexao();
if(session.getAttribute("usuario")!=null){
	
	
	HC_Lab_agendamento lab = new HC_Lab_agendamento();
	lab.setInTransaction(true);
	lab.setConnexao(conn);
	
	String mensUsuario = request.getParameter("mensUsuario") == null?"":request.getParameter("mensUsuario").trim();
	String matricula = request.getParameter("num_matricula") == null?"":request.getParameter("num_matricula").trim();
	String data_ini = request.getParameter("data_ini") == null?"":request.getParameter("data_ini").trim();
	String data_grid = request.getParameter("data_grid") == null?"":request.getParameter("data_grid").trim();
	String data_fim = request.getParameter("data_fim") == null?"":request.getParameter("data_fim").trim();
	String hora_ini = request.getParameter("hora_ini") == null?"":request.getParameter("hora_ini").trim();
	String cod_assunto = request.getParameter("cod_assunto") == null?"":request.getParameter("cod_assunto").trim();
	String cod_professor = request.getParameter("cod_professor") == null?"":request.getParameter("cod_professor").trim();
	String okcancelado = request.getParameter("okcancelado") == null?"":request.getParameter("okcancelado").trim();
	
	if ((data_grid==null) || (data_grid.equals(""))) {
		data_grid = data_ini;
	}
	
	if(!cod_assunto.equalsIgnoreCase("")){
		lab.setCodassunto(Integer.parseInt(cod_assunto));
	}
	
	String data_antes = "";
	String data_depois = "";
	
	lab.setFiltroIntervalo("1=1");
	Date dtGrid = null;
	boolean errodata = false;
	try{
			dtGrid = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data_grid+" 00:00:00");
			Date dtIni = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data_ini+" 00:00:00");
			Date dtFim = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data_fim+" 00:00:00");
			Date dtAntes = dtGrid;
			Date dtDepois = dtGrid;
			
			GregorianCalendar gc1 = new GregorianCalendar();
			gc1.setTime(dtGrid);
			gc1.add(GregorianCalendar.DAY_OF_MONTH, -7);
			dtAntes = gc1.getTime();
			/*
			if (dtAntes.before(dtIni)){
				dtAntes = dtIni;
			}*/
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			data_antes = formatter.format(dtAntes); 
			
			GregorianCalendar gc2 = new GregorianCalendar();
			gc2.setTime(dtGrid);
			gc2.add(GregorianCalendar.DAY_OF_MONTH, 7);
			dtDepois = gc2.getTime();
			/*
			if (dtDepois.after(dtFim)){
				dtDepois = dtFim;
			}*/
			data_depois =  formatter.format(dtDepois);
			
	}catch(Exception e){
		errodata = true;
	}
	
	

	
	if(session.getAttribute("tipo").toString().equalsIgnoreCase("AL")){
		lab.setCodaluno(Long.parseLong(session.getAttribute("usuario").toString()));
	};
	
	
	ResultSet rs = null;
	//lab.lista();
	if ((data_grid!=null) && (!data_grid.equals(""))){
		rs = lab.carregaTabelaHorarios(data_grid);
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
		
	    // Captura o evento para o IE ou outros navegadores
	    var evento = evento ? evento : window.event;
	    
	    // Obtém o elemento que está sendo tratado no evento (o formulário)
	    var formulario = document.getElementById('forme');
	    
	    // Obtém o campo de select através de seu nome
	    var opcoes = formulario.opcoes;
	    var data_ini = formulario.data_ini.value;
	    var data_fim = formulario.data_fim.value;
	    var hora_ini = formulario.hora_ini.value;
	    var cod_assunto = formulario.cod_assunto.value;
	    var cod_professor = formulario.cod_professor.value;
	    var cancela = false; 
	    
		if (data_ini == ""){
			alert('Informe a data inicial!');
			formulario.data_ini.focus();
			cancela_evento(evento);
			
		} else if (data_fim == ""){
			alert('Informe a data final!');
			formulario.data_fim.focus();
			cancela_evento(evento);
			
		} else if (hora_ini == ""){
			alert('Informe a hora!');
			formulario.hora_ini.focus();
			cancela_evento(evento);
			
		} else if (cod_assunto == ""){
			alert('Escolha o assunto!');
			formulario.cod_assunto.focus();
			cancela_evento(evento);
			
		} else if (cod_professor == ""){
			alert('Escolha o professor!');
			formulario.cod_professor.focus();
			cancela_evento(evento);
			
		} else {
		
			var forme = document.getElementById('forme');
   			forme.action="frmCad_agendamento.jsp";
			forme.submit();
		}
	});	
	
	$("#voltar").button().click(function(){
		var form = document.getElementById('forme');
		form.data_grid.value = form.data_antes.value;
		form.action="cad_agendamento.jsp";
		form.submit();
	});
	
	$("#avancar").button().click(function(){
		var form = document.getElementById('forme');
		form.data_grid.value = form.data_depois.value;
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

function montaGrid(){
	var form = document.getElementById('forme');
	form.action="cad_agendamento.jsp";
	form.submit();
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

// Função para cancelar os eventos
function cancela_evento(evento) {
    // Testa se o navegador suporta stopPropagation
    if (evento.stopPropagation) {
        // Adiciona stopPropagation
        evento.stopPropagation();
        // Adiciona preventDefault
        evento.preventDefault();
    } else {
        // Configura returnValue como false para o IE
        evento.returnValue = false;
        // Cancela a propagação para o IE
        evento.cancelBubble = true;
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
		           		   	  <strong>Data Inicial:</strong><br> &nbsp;<input class="data glowing-border" style="WIDTH: 80%" id="data_ini" name="data_ini" type="text" maxlength="100" value="<%=data_ini %>" onchange="return montaGrid()">
		           </div>
            
            	   <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">                
		           		   	  <strong>Data Final:</strong><br> &nbsp;<input class="data glowing-border" style="WIDTH: 80%" id="data_fim" name="data_fim" type="text" maxlength="100" value="<%=data_fim %>">
		           </div>
            		<input name="cod_usuario" type="hidden" value="<%=session.getAttribute("usuario").toString()%>">
             		<input name="data_grid" type="hidden" value="<%=data_grid%>"></input>
             		<input name="data_antes" type="hidden" value="<%=data_antes%>"></input>
             		<input name="data_depois" type="hidden" value="<%=data_depois%>"></input>
           
		     </div> 
		   <div class="row">  
            
	               <div class="col-xs-3col-sm-3 col-md-3 col-lg-3">  
	           
	       				   <strong>Hora:</strong><br>
	       				    <select style="width: 80%" id="hora_ini" name="hora_ini"" class="glowing-border" >
	       				    <option value="">Escolha a Hora</option>
	       				    <option value="7" <%="7".equals(hora_ini)?"selected='selected'":"" %>>07:00</option>
	       				    <option value="8" <%="8".equals(hora_ini)?"selected='selected'":"" %>>08:00</option>
	       				    <option value="9" <%="9".equals(hora_ini)?"selected='selected'":"" %>>09:00</option>
	       				    <option value="10" <%="10".equals(hora_ini)?"selected='selected'":"" %>>10:00</option>
	       				    <option value="11" <%="11".equals(hora_ini)?"selected='selected'":"" %>>11:00</option>
	       				    <option value="13" <%="13".equals(hora_ini)?"selected='selected'":"" %>>13:00</option>
	       				    <option value="14" <%="14".equals(hora_ini)?"selected='selected'":"" %>>14:00</option>
	       				    <option value="15" <%="15".equals(hora_ini)?"selected='selected'":"" %>>15:00</option>
	       				    <option value="16" <%="16".equals(hora_ini)?"selected='selected'":"" %>>16:00</option>
	       				    <option value="17" <%="17".equals(hora_ini)?"selected='selected'":"" %>>17:00</option>
	       				    <option value="19" <%="19".equals(hora_ini)?"selected='selected'":"" %>>19:00</option>
	       				    <option value="20" <%="20".equals(hora_ini)?"selected='selected'":"" %>>20:00</option>
	       				    <option value="21" <%="21".equals(hora_ini)?"selected='selected'":"" %>>21:00</option>
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
            
                    <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
		                     
		           		   	  <strong>Professor:</strong><br> &nbsp;
		           		   	  <%HC_Lab_pessoa professor = new HC_Lab_pessoa();
		           		   	   professor.setConnexao(conn);
		           		   	   professor.setInTransaction(true);
		           		   	   professor.setFlagtipo("PF");
		           		   	   professor.setOrderBy("desc_nome");		           		   	   
		           		   	   professor.lista();
		           		   	  %>
		           		   	  
		           		   	  <select class="glowing-border" style="WIDTH: 80%" id="cod_professor" name="cod_professor" type="text" maxlength="100">  
		           		   	  <option value="">Escolha o professor:</option>
		           		   	  <%while(professor.next()){%>
		           		   		  <option value="<%=professor.getRsCodpessoa() %>" <%=cod_professor.equals(Long.toString(professor.getRsCodpessoa()))?"selected='selected'":"" %>>  <%=professor.getRsDescnome() %></option>
		           		   	  <% }%>
		           		   	  </select>
		           		   	  
		           </div>
		           	
	           	
            </div>
            
             <div class="row">
               
              		<div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">       
              			<br>         
		           			<button class="btn btn-primary" id="incluir">Incluir Agendamento</button>
		           	</div>
		         
				<%if (!mensUsuario.equals("")){ %>
					<strong><h4><%=mensUsuario %></h4></strong>
				<%} %>            
            </div>
            
            <br>
            <div class="row">
                <div id="divTab" class="bs-example"  style="height: 750px;  overflow-y: scroll;">                	
                    <table id="maquinasTab" class="table  header-fixed  table-striped table-bordered table-hover ">
                       <thead class="header">
                       <% if (rs!=null) { 
                                                
                           Date base = new SimpleDateFormat("dd/MM/yyyy").parse(data_grid);
                       	   GregorianCalendar diaSemana = new GregorianCalendar();
                       	   diaSemana.setTime(base);
                       	   diaSemana.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                       	   String segunda = new SimpleDateFormat("dd/MM/yyyy").format(diaSemana.getTime());
                       	   diaSemana.setTime(base);
                       	   diaSemana.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    	   String terca = new SimpleDateFormat("dd/MM/yyyy").format(diaSemana.getTime());
                    	   diaSemana.setTime(base);
                       	   diaSemana.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    	   String quarta = new SimpleDateFormat("dd/MM/yyyy").format(diaSemana.getTime());
                    	   diaSemana.setTime(base);
                       	   diaSemana.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    	   String quinta = new SimpleDateFormat("dd/MM/yyyy").format(diaSemana.getTime());
                    	   diaSemana.setTime(base);
                       	   diaSemana.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    	   String sexta = new SimpleDateFormat("dd/MM/yyyy").format(diaSemana.getTime());
                    	   diaSemana.setTime(base);
                       	   diaSemana.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                    	   String sabado = new SimpleDateFormat("dd/MM/yyyy").format(diaSemana.getTime());
                       %>
                            <tr>
		        				<th style="text-align: center; width: 5%"><button class="btn btn-primary" id="voltar" onclick=""><</button></th>
                                <th style="text-align: center; width: 8%">Hora:</th>
                                <th style="text-align: center; width: 15%">Segunda <br><%=segunda %></th>
                                <th style="text-align: center; width: 14%">Terça <br><%=terca %></th>
                                <th style="text-align: center; width: 15%">Quarta <br><%=quarta %></th>
                                <th style="text-align: center; width: 15%">Quinta <br><%=quinta %></th>
                                <th style="text-align: center; width: 14%">Sexta <br><%=sexta %></th>
                                <th style="text-align: center; width: 15%">Sábado <br> <%=sabado %></th>
		        				<th style="text-align: center; width: 5%"><button class="btn btn-primary" id="avancar" onclick="">></button></th>                            </tr>
                        <% } %>
                        </thead>
                        <tbody>
                        <%
                        while((rs!=null) && (rs.next())){
                        	if ((Integer.parseInt(rs.getString("hora")) > 6) && ((Integer.parseInt(rs.getString("hora")) < 12)) 
                        			|| (Integer.parseInt(rs.getString("hora")) > 12) && ((Integer.parseInt(rs.getString("hora")) < 18)) 
                            		|| (Integer.parseInt(rs.getString("hora")) > 18) && ((Integer.parseInt(rs.getString("hora")) < 22))                            	 
                        			){
                        %>
                        	<tr>
                        	    <td style="text-align: center; width: 5%" ></td>
                        	    <td style="text-align: center; width: 8%" ><%=rs.getString("hora")+":00" %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("segunda") %></td>
								<td style="text-align: center; width: 14%" ><%=rs.getInt("terca") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("quarta") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("quinta") %></td>
								<td style="text-align: center; width: 14%" ><%=rs.getInt("sexta") %></td>
								<td style="text-align: center; width: 15%" ><%=rs.getInt("sabado") %></td>
								<td style="text-align: center; width: 5%" ></td>
                        	</tr>

                        <%}}
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
