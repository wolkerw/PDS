<%@ page pageEncoding="UTF-8" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_agendamento"%>
<html>
<head>
<title></title>
<%@ page import="com.*" errorPage="erro.jsp"%>

<meta HTTP-EQUIV=Expires CONTENT="Thu, 01 Jan 1970 00:00:00 GMT">
<meta HTTP-EQUIV=Cache-Control content=no-store>
<meta HTTP-EQUIV=Pragma content=no-cache>
<script type="text/javascript">

function alerta(var mensagem){
	alert(mensagem);
}


</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<%!int regCnt;
    int regIndex;
    String strComplemento = "";
    boolean blnErro = false;
    String strErro = "";
    long usuario;%>
<%
    String tela_inicial = "";
    blnErro = false;
    
    Connection conn = null;
    long ultemplog = 0;
    String cod_usuario = null;
    String matricula = null; 
    String data_ini = null;
    String data_fim = null; 
    String hora_ini = null; 
    String cod_assunto = null; 
    String cod_professor = null;
    try {
        
        conn = DBSettings.getConexao();
        
        cod_usuario = request.getParameter("cod_usuario") == null?"":request.getParameter("cod_usuario").trim();
        matricula = request.getParameter("num_matricula") == null?"":request.getParameter("num_matricula").trim();
    	data_ini = request.getParameter("data_ini") == null?"":request.getParameter("data_ini").trim();
    	data_fim = request.getParameter("data_fim") == null?"":request.getParameter("data_fim").trim();
    	hora_ini = request.getParameter("hora_ini") == null?"":request.getParameter("hora_ini").trim();
    	cod_assunto = request.getParameter("cod_assunto") == null?"":request.getParameter("cod_assunto").trim();
    	cod_professor = request.getParameter("cod_professor") == null?"":request.getParameter("cod_professor").trim();
        
        HC_Lab_agendamento objAgendamento = new HC_Lab_agendamento();
        String resultado = objAgendamento.insereAgendamento(Long.parseLong(cod_usuario), 
        							     Long.parseLong(cod_professor), 
        							     Long.parseLong(cod_assunto), 
        							     data_ini, data_fim, Integer.parseInt(hora_ini));
        
        if (!resultado.equals("")){
        	blnErro = true;
        	strErro = resultado;
        }
                    
       } catch (Exception e){
         	 e.printStackTrace();
             blnErro = true;
             strErro = e.getMessage();
    }
   
    String mensUsuario = "";
    
    if (!blnErro) {
   		mensUsuario = "Agendamento realizado!";
    }else{
    	mensUsuario = "Falha no Agendamento: " +strErro;
    }
if(conn != null)
    conn.close();

String destino = "cad_agendamento.jsp?mensUsuario="+mensUsuario+"&data_ini="+data_ini+"&data_fim="+data_fim+"&hora_ini="+hora_ini+"&cod_assunto="+cod_assunto+"&cod_professor="+cod_professor;
response.sendRedirect(destino);

      %>
      
</body>
</html>


