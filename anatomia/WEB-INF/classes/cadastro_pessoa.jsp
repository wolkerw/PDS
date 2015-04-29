<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_curso"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.DBSettings"%>
<%@page import="com.HC_Lab_pessoa"%>
<%@page import="java.sql.ResultSet"%>
<%@ page pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%//codeGenVersion 2.0.72

Connection conn = DBSettings.getConexao();
//if(session.getAttribute("usuario")!=null){
	
	boolean editando = false;
	int codPessoa;
	String editandoValue = "nao";
	if (request.getParameter("id") != null) {
		codPessoa = Integer.parseInt(request.getParameter("id"));
		editandoValue = "sim";
	} else codPessoa = 0/*Integer.parseInt(session.getAttribute("usuario").toString())*/;
	/*if (session.getAttribute("usuario")!=null /*&& session.getAttribute("tipo").toString().equalsIgnoreCase("AD")/* && request.getParameter("cod_pessoa")!=null*//*) {
		editando = true;
	}*/
	
	HC_Lab_pessoa objSIS_USUARIO = new HC_Lab_pessoa();
	objSIS_USUARIO = new HC_Lab_pessoa();
    objSIS_USUARIO.setInTransaction(true);
    objSIS_USUARIO.setConnexao(conn);
    objSIS_USUARIO.limpaPropriedades();
    
    // Pega os dados do usuário
    //if (editando) {
    
   	int matriculaOriginal = 0, cursoOriginal = 0;
   	long telefoneOriginal = 0;
   	String nomeOriginal = "", senhaOriginal = "", emailOriginal = "", tipoOriginal = "", situacaoOriginal = "";
    	
    if (codPessoa != 0) {
    	editando = true;
    	
    	ResultSet rs = null;
    	rs = objSIS_USUARIO.carregaDadosPessoa(codPessoa);
    	
    	while((rs!=null) && (rs.next())){
    		matriculaOriginal = Integer.parseInt(rs.getString("num_matricula"));
    		cursoOriginal = Integer.parseInt(rs.getString("cod_curso"));
    		telefoneOriginal = Long.parseLong(rs.getString("num_telefone"));
    		emailOriginal = rs.getString("desc_email").toString();
    		tipoOriginal = rs.getString("flag_tipo").toString();
    		nomeOriginal = rs.getString("desc_nome").toString();
    		senhaOriginal = rs.getString("desc_senha").toString();
    		situacaoOriginal = rs.getString("flag_situacao").toString();
    	}
    	
    	//String matricula = session.getAttribute("cod_matricula").toString();

    	/*System.out.println("codUsuario: " + codPessoa);
    	System.out.println("matriculaOriginal: " + matriculaOriginal);
    	System.out.println("cursoOriginal: " + cursoOriginal);*/
    }

	//System.out.println("teste1");
	
	/*if (request.getParameter("txtLG_NOME")!=null){
		String nome = request.getParameter("txtLG_NOME");
				
		System.out.println("not null nome");
       	if (nome.compareToIgnoreCase("")!=0){
       		System.out.println("not null nome 2");
       	  	try {
            	objSIS_USUARIO.setDescnome(nome);
       	  	} catch(Exception e){
           		throw new Exception("O nome deve ser preenchido corretamente.");
            }
       	}
   }*/
	
	/*HC_Lab_agendamento lab = new HC_Lab_agendamento();
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
	
	if(session.getAttribute("tipo").toString().equalsIgnoreCase("AL")){
		lab.setCodaluno(Long.parseLong(session.getAttribute("usuario").toString()));
	};
	
	lab.lista();*/
	
	
	
%>

<%@page import="java.sql.Connection"%>
<jsp:include page="header.jsp"/>

  <script type="text/javascript">
$(document).ready(function() {
	
	$("#filtrar").button().click(function(){
		var form = document.getElementById('forme');
		form.action="listapessoa.jsp.jsp";
		form.submit();
	});
	
	/*$( ".data" ).datepicker();
	$(".ui-datepicker-trigger").css('position', 'relative');
	$(".ui-datepicker-trigger").css('top', '3px');
	$(".ui-datepicker-trigger").css('left', '1px');
	$(".data").mask("99/99/9999");*/
    
	$(".sys_remove").button().click(function(){
		$.blockUI({ message: 'Cancelado cadastro...' });
			cancelaCadastroPessoa($(this).attr("seqagend"));
	 	$.unblockUI();
		return false;
		
	});
	
});


function cancelaCadastroPessoa(seqagend){


	
	/*$.ajax({
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
	   });*/ 
	
	
} 

/*function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}*/
</script>
    <form id="forme" action="frmPessoa_cadastro.jsp">
    	<br/>     
        <div style="width: 85%" class="container bs-docs-container">
            <div class="row">
                <div id="divTab" class="bs-example"  style="height: 750px;  overflow-y: scroll;">
                	<h3>Cadastro de pessoa</h3><br/>
                    <table border="0" cellpadding="0" cellspacing="0" width="310">
                      	<tr>
                      		<td>
                      			<input id="editando" value="<%= editandoValue %>" type="hidden" class="form-control campo" name="editando">
                      			<div class="form-group">
									<label for="txtLG_TIPO">Tipo de cadastro:</label>
									<select  class="glowing-border form-control campo" id="txtLG_TIPO" name="txtLG_TIPO" type="text" maxlength="100" >
										<option value="AL" <%=tipoOriginal == "AL" ? "selected=\"selected\"" : "" %>>Aluno</option>
										<%if(session.getAttribute("usuario")!=null && !session.getAttribute("tipo").toString().equalsIgnoreCase("AL")){%>
											<option value="PF" <%=tipoOriginal == "PF" ? "selected=\"selected\"" : "" %>>Professor</option>
										<%}%>
										<%if(session.getAttribute("usuario")!=null && session.getAttribute("tipo").toString().equalsIgnoreCase("AD")){%>
											<option value="AD" <%=tipoOriginal == "AD" ? "selected=\"selected\"" : "" %>>Administrador</option>
										<%}%>
									</select>
								</div>
                      			<div class="form-group">
									<label for="txtLG_NOME">Nome:</label>
									<input id="txtLG_NOME" value="<%= nomeOriginal %>" type="text" class="form-control campo" placeholder="Digite o nome" name="txtLG_NOME">
								</div>
								<%if (!editando) {
									%><div class="form-group">
										<label for="txtLG_MATRICULA">Matrícula:</label>
										<input id="txtLG_MATRICULA" value="" type="text" class="form-control campo" placeholder="Digite a matrícula" name="txtLG_MATRICULA">
									</div><%
								} else {
									%><input id="txtLG_MATRICULA" value="<%= matriculaOriginal %>" type="hidden" class="form-control campo" name="txtLG_MATRICULA"><%
								} %>
								
								<%if (session.getAttribute("usuario")!=null && session.getAttribute("tipo").toString().equalsIgnoreCase("AD")) {
									%><div class="form-group">
										<label for="txtLG_SITUACAO">Situação:</label>
										<select  class="glowing-border form-control campo" id="txtLG_SITUACAO" name="txtLG_SITUACAO" type="text" maxlength="100" >
											<option value="L" <%=situacaoOriginal == "L" ? "selected=\"selected\"" : "" %>>Liberado</option>
											<option value="B" <%=situacaoOriginal == "B" ? "selected=\"selected\"" : "" %>>Bloqueado</option>
										</select>
									</div><%
								}%>
								
                      			<div class="form-group">
									<label for="txtLG_EMAIL">E-mail:</label>
									<input id="txtLG_EMAIL" value="<%= emailOriginal %>" type="text" class="form-control campo" placeholder="Digite o e-mail" name="txtLG_EMAIL">
								</div>
                      			<div class="form-group">
									<label for="txtLG_SENHA">Senha:</label>
									<input id="txtLG_SENHA" value="<%= senhaOriginal %>" value="" type="password" class="form-control campo" placeholder="" name="txtLG_SENHA">
								</div>
                      			<div class="form-group">
									<label for="txtLG_CURSO">Curso:</label>
									<select  class="glowing-border form-control campo" id="txtLG_CURSO" name="txtLG_CURSO" type="text" maxlength="100" >  
				           		   	  	<option value="">Todos</option>
				           		   	  	<%HC_Lab_curso curso = new HC_Lab_curso();
						           		 curso.setConnexao(conn);
						           		curso.setInTransaction(true);
						           		curso.setOrderBy("desc_curso");
						           		curso.lista();
						           		
				           		   	  	while(curso.next()){%>
				           		   		  	<option value="<%=curso.getRsCodcurso()%>" <%=cursoOriginal == curso.getRsCodcurso() ? "selected=\"selected\"" : "" %>>  <%=curso.getRsDesccurso() %></option>
				           		   	  	<% }%>
				           		   	</select>
								</div>
                      			<div class="form-group">
									<label for="txtLG_TELEFONE">Telefone:</label>
									<input id="txtLG_TELEFONE" value="<%= telefoneOriginal %>" type="text" class="form-control campo" placeholder="Digite o telefone" name="txtLG_TELEFONE">
								</div>
                      			<!-- <div class="form-group">
									<label for="txtLG_SITUACAO">Situação:</label>
									<input id="txtLG_SITUACAO" type="text" class="form-control campo" placeholder="Digite a situação" name="txtLG_SITUACAO">
								</div> -->
								
								<button type="submit" class="btn btn-default" OnClick="form.action='frmPessoa_cadastro.jsp'; form.submit();">Cadastrar</button>
							</td>
                       	</tr>
                            <!-- <tr>
                                <th style="text-align: center; width: 25%">Aluno</th>
                                <th style="text-align: center; width: 25%">Professor</th>
                                <th style="text-align: center; width: 35%">Assunto</th>
                                <th style="text-align: center; width: 15%">Data</th>
                                <th style="text-align: center; width: 15%">Status</th>
                                <th style="text-align: center; width: 15%"></th>
                            </tr>
                        <tbody> -->
                        <%
                        /*while(lab.next()){
                        	String status ="";
                        	if(lab.getRsFlagstaus()==null){
                        		status = "Ok";
                        	}
                        	else if(lab.getRsFlagstaus().equalsIgnoreCase("C")){
                        		status = "Cancelado";
                        	}else if(lab.getRsFlagstaus().equalsIgnoreCase("O")){
                        		status = "Ok";
                        	}*/
                        
                        %>
                        	<tr>
								<td style="text-align: center; width: 25%" ></td>
								<td style="text-align: center; width: 25%" ></td>
								<td style="text-align: center; width: 25%" ></td>
								<td style="text-align: center; width: 25%" ></td>
								<td style="text-align: center; width: 25%" ></td>
								<th style="text-align: center; width: 15%">
								
								</th>
                        	</tr>

                        <%/*}
                        conn.close();*/
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

<%//}else{
//	Você não está logado	
//} %>
