<%@ page pageEncoding="UTF-8" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<html>
<head>
<title></title>
<%@ page import="com.*" errorPage="erro.jsp"%>

<meta HTTP-EQUIV=Expires CONTENT="Thu, 01 Jan 1970 00:00:00 GMT">
<meta HTTP-EQUIV=Cache-Control content=no-store>
<meta HTTP-EQUIV=Pragma content=no-cache>
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
    try {
        
        conn = DBSettings.getConexao();
        
        
        HC_Lab_pessoa objSIS_USUARIO = new HC_Lab_pessoa();
        objSIS_USUARIO = new HC_Lab_pessoa();
        objSIS_USUARIO.setInTransaction(true);
        objSIS_USUARIO.setConnexao(conn);
            objSIS_USUARIO.limpaPropriedades();
 		
		session = request.getSession(true);
	
            if (request.getParameter("txtLG_USUARIO" + strComplemento)!=null){
                 if (request.getParameter("txtLG_USUARIO" + strComplemento).compareToIgnoreCase("")!=0){
                	  try {
                     		 objSIS_USUARIO.setNummatricula(Integer.parseInt( request.getParameter("txtLG_USUARIO" + strComplemento)));
                	  } catch(Exception e){
                    	  throw new Exception("A Matricula é somente númerica.");
                      }
                 }
            }
        
            if (request.getParameter("txtVL_SENHA" + strComplemento)!=null){
                if (request.getParameter("txtVL_SENHA" + strComplemento).compareToIgnoreCase("")!=0){
                     objSIS_USUARIO.setDescsenha(request.getParameter("txtVL_SENHA" + strComplemento));
                }
            }
            	
        objSIS_USUARIO.setTop("1");
        objSIS_USUARIO.lista();
        
        if(objSIS_USUARIO.next()){
        	objSIS_USUARIO.mapGetRsToSet(objSIS_USUARIO,objSIS_USUARIO);
          session.setAttribute("tipo",objSIS_USUARIO.getRsFlagtipo());
      	  session.setAttribute("usuario",new Long(objSIS_USUARIO.getRsCodpessoa()));
          session.setMaxInactiveInterval(1800);
          
        }else{
        	throw new Exception("Senha/Matricula Incorreta");
        }            
       } catch (Exception e){
         	 e.printStackTrace();
             blnErro = true;
             strErro = e.getMessage();
    }
   

    if (!blnErro) {
	              %>
	              <meta http-equiv="refresh" content="0;URL=listapessoa.jsp">
<%
    }else{%>
         		 <%=strErro%>
<%
    }
if(conn != null)
    conn.close();
      %>
</body>
</html>


