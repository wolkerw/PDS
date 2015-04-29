<%@ page pageEncoding="UTF-8" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_pessoa"%>

<%@ page import="com.*" errorPage="erro.jsp"%>
<%@page import="java.sql.Connection"%>

<jsp:include page="header.jsp"/>

<%!
	/*int regCnt;
    int regIndex;
    String strComplemento = "";*/
   boolean blnErro = false;
    String strErro = "";
    /*long usuario;*/%>
<%
    /*String tela_inicial = "";*/
    blnErro = false;
    
    Connection conn = null;
    boolean preencheuNome = false,
    		preencheuMatricula = false,
    		preencheuEmail = false,
 			preencheuSenha = false,
 			preencheuCurso = false,
 			preencheuTelefone = false;
    /*long ultemplog = 0;*/
    try {
        
        conn = DBSettings.getConexao();
        
        
        HC_Lab_pessoa objSIS_USUARIO = new HC_Lab_pessoa();
        objSIS_USUARIO = new HC_Lab_pessoa();
        objSIS_USUARIO.setInTransaction(true);
        objSIS_USUARIO.setConnexao(conn);
        objSIS_USUARIO.limpaPropriedades();
 		
        /*session = request.getSession(true);*/
    	
        if (request.getParameter("txtLG_NOME")!=null){
             if (preencheuNome = request.getParameter("txtLG_NOME").compareToIgnoreCase("")!=0){
            	  try {
                 		 objSIS_USUARIO.setDescnome(request.getParameter("txtLG_NOME"));
            	  } catch(Exception e){
                	  throw new Exception("Digite o nome.");
                  }
             } else {
             	throw new Exception("Digite o nome.");
             }
        }
     
         if (request.getParameter("txtLG_MATRICULA")!=null){
             if (preencheuMatricula = request.getParameter("txtLG_MATRICULA").compareToIgnoreCase("")!=0){
            	  try {
                 		 objSIS_USUARIO.setNummatricula(Integer.parseInt( request.getParameter("txtLG_MATRICULA")));
            	  } catch(Exception e){
                	  throw new Exception("A atricula é somente númerica.");
                  }
             } else {
               	throw new Exception("Digite a matrícula.");
             }
        }
	
         if (request.getParameter("txtLG_EMAIL")!=null){
              if (preencheuEmail = request.getParameter("txtLG_EMAIL").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setDescemail(request.getParameter("txtLG_EMAIL"));
             	  } catch(Exception e){
                 	  throw new Exception("Digite o e-mail.");
                   }
              } else {
              	throw new Exception("Digite o e-mail.");
              }
         }
	
         if (request.getParameter("txtLG_SENHA")!=null){
              if (preencheuSenha = request.getParameter("txtLG_SENHA").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setDescsenha(request.getParameter("txtLG_SENHA"));
             	  } catch(Exception e){
                 	  throw new Exception("Digite a senha.");
                   }
              } else {
              	throw new Exception("Digite a senha.");
              }
         }
	
         if (request.getParameter("txtLG_CURSO")!=null){
              if (preencheuCurso = request.getParameter("txtLG_CURSO").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setCodcurso(Integer.parseInt(request.getParameter("txtLG_CURSO")));
             	  } catch(Exception e){
                 	  throw new Exception("Selecione o curso.");
                   }
              } else {
              	throw new Exception("Selecione o curso.");
              }
         }
	
         if (request.getParameter("txtLG_TELEFONE")!=null){
              if (preencheuTelefone = request.getParameter("txtLG_TELEFONE").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setNumtelefone(request.getParameter("txtLG_TELEFONE"));
             	  } catch(Exception e){
                 	  throw new Exception("Digite o telefone.");
                   }
              } else {
              	throw new Exception("Digite o telefone.");
              }
         }
	
         /*if (request.getParameter("txtLG_SITUACAO")!=null){
              if (preencheuSituacao = request.getParameter("txtLG_SITUACAO").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setFlagsituacao(request.getParameter("txtLG_SITUACAO"));
             	  } catch(Exception e){
                 	  throw new Exception("Digite o telefone.");
                   }
              } else {
              	throw new Exception("Digite o telefone.");
              }
         }*/
	
         /*if (request.getParameter("txtLG_NOME")!=null){
              if (preencheuNome = request.getParameter("txtLG_NOME").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setDescnome(request.getParameter("txtLG_NOME"));
             	  } catch(Exception e){
                 	  throw new Exception("Digite o nome.");
                   }
              } else {
              	throw new Exception("Digite o nome.");
              }
         }*/
        
        if (preencheuMatricula && preencheuNome) {
        	objSIS_USUARIO.inserePessoa(Integer.parseInt(request.getParameter("txtLG_MATRICULA")), Integer.parseInt(request.getParameter("txtLG_CURSO")), request.getParameter("txtLG_TELEFONE"), request.getParameter("txtLG_EMAIL"), request.getParameter("txtLG_TIPO"), request.getParameter("txtLG_NOME"), request.getParameter("txtLG_SENHA"), request.getParameter("txtLG_SITUACAO"));
        }

        /*objSIS_USUARIO.setTop("1");
        objSIS_USUARIO.lista();
        
        if(objSIS_USUARIO.next()){
        	objSIS_USUARIO.mapGetRsToSet(objSIS_USUARIO,objSIS_USUARIO);
          session.setAttribute("tipo",objSIS_USUARIO.getFlagtipo());
      	  session.setAttribute("usuario",new Long(objSIS_USUARIO.getCodpessoa()));
          session.setMaxInactiveInterval(1800);
          
        }else{
        	throw new Exception("Senha/Matricula Incorreta");
        }*/            
       } catch (Exception e){
         	 e.printStackTrace();
             blnErro = true;
             strErro = e.getMessage();
    }
   

    if (!blnErro) {
	              %>
	              <meta http-equiv="refresh" content="0;URL=cadastro_pessoa.jsp">
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