<%@ page pageEncoding="UTF-8" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@page import="com.HC_Lab_pessoa"%>

<%@ page import="com.*" errorPage="erro.jsp"%>
<%@page import="java.sql.Connection"%>

<jsp:include page="header.jsp"/>

<%
	/*int regCnt;
    int regIndex;
    String strComplemento = "";*/
   boolean blnErro = false;
    String strErro = "";
    /*long usuario;*/
    /*String tela_inicial = "";*/
    blnErro = false;
    
    Connection conn = null;
    boolean preencheuNome = false,
    		nomeCorreto = false,
    		preencheuMatricula = false,
    		matriculaCorreta = false,
    		preencheuEmail = false,
    		emailCorreto = false,
 			preencheuSenha = false,
 			senhaCorreta = false,
 			preencheuCurso = false,
 			cursoCorreto = false,
 			preencheuTelefone = false,
 			telefoneCorreto = false,
 			editando = false;
    
    /*long ultemplog = 0;*/
    
    try {
        
        conn = DBSettings.getConexao();
        
        HC_Lab_pessoa objSIS_USUARIO = new HC_Lab_pessoa();
        objSIS_USUARIO = new HC_Lab_pessoa();
        objSIS_USUARIO.setInTransaction(true);
        objSIS_USUARIO.setConnexao(conn);
        objSIS_USUARIO.limpaPropriedades();
    	
        if (request.getParameter("txtLG_NOME")!=null){
             if (preencheuNome = request.getParameter("txtLG_NOME").compareToIgnoreCase("")!=0){
            	  try {
                 	objSIS_USUARIO.setDescnome(request.getParameter("txtLG_NOME"));
                 	nomeCorreto = true;
            	  } catch(Exception e){
                     nomeCorreto = false;
              		 out.println("Digite o nome corretamente.");
                  }
             } else {
                 nomeCorreto = false;
          		 out.println("Digite o nome corretamente.");
             }
        }

         if (request.getParameter("txtLG_MATRICULA")!=null){
             if (preencheuMatricula = request.getParameter("txtLG_MATRICULA").compareToIgnoreCase("")!=0){
            	  try {
                 	  objSIS_USUARIO.setNummatricula(Integer.parseInt( request.getParameter("txtLG_MATRICULA")));
              		  matriculaCorreta = true;
            	  } catch(Exception e){
            		  matriculaCorreta = false;
            		  out.println("A matricula é somente númerica.");
                  }
             } else {
             	matriculaCorreta = false;
            	out.println("Digite a matrícula corretamente.");
             }
         }
	
         if (request.getParameter("txtLG_EMAIL")!=null){
              if (preencheuEmail = request.getParameter("txtLG_EMAIL").compareToIgnoreCase("")!=0){
             	  try {
                  	  objSIS_USUARIO.setDescemail(request.getParameter("txtLG_EMAIL"));
                 	  emailCorreto = true;
             	  } catch(Exception e){
             		 emailCorreto = false;
              		 out.println("Digite o e-mail corretamente.");
                   }
              } else {
               	emailCorreto = false;
              	out.println("Digite o e-mail corretamente.");
              }
         }
	
         if (request.getParameter("txtLG_SENHA")!=null){
              if (preencheuSenha = request.getParameter("txtLG_SENHA").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setDescsenha(request.getParameter("txtLG_SENHA"));
                    	  senhaCorreta = true;
             	  } catch(Exception e){
             		 senhaCorreta = false;
              		 out.println("Digite a senha corretamente.");
                   }
              } else {
               	senhaCorreta = false;
              	out.println("Digite a senha corretamente.");
              }
         }
	
         if (request.getParameter("txtLG_CURSO")!=null){
              if (preencheuCurso = request.getParameter("txtLG_CURSO").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setCodcurso(Integer.parseInt(request.getParameter("txtLG_CURSO")));
                    	  cursoCorreto = true;
             	  } catch(Exception e){
             		 cursoCorreto = false;
              		 out.println("Selecione o curso.");
                   }
              } else {
               	cursoCorreto = false;
              	out.println("Selecione o curso.");
              }
         }
	
         if (request.getParameter("txtLG_TELEFONE")!=null){
              if (preencheuTelefone = request.getParameter("txtLG_TELEFONE").compareToIgnoreCase("")!=0){
             	  try {
                  		 objSIS_USUARIO.setNumtelefone(request.getParameter("txtLG_TELEFONE"));
                    	  telefoneCorreto = true;
             	  } catch(Exception e){
             		 telefoneCorreto = false;
              		 out.println("Digite o telefone corretamente.");
                   }
              } else {
               	telefoneCorreto = false;
              	out.println("Digite o telefone corretamente.");
              }
         }
         
        String situacao = (request.getParameter("txtLG_SITUACAO") != null && request.getParameter("txtLG_SITUACAO").compareToIgnoreCase("B") == 0) ? "B" : "L";
         
        editando = (request.getParameter("editando")!=null && request.getParameter("editando").compareToIgnoreCase("sim") == 0); 
         
        String resposta = "";
        if (preencheuMatricula && preencheuNome && nomeCorreto && matriculaCorreta && preencheuEmail && emailCorreto && preencheuSenha && senhaCorreta && preencheuCurso && cursoCorreto && preencheuTelefone && telefoneCorreto) {
        	if (editando) {
        		resposta = objSIS_USUARIO.editaPessoa(Integer.parseInt(request.getParameter("txtLG_MATRICULA")), Integer.parseInt(request.getParameter("txtLG_CURSO")), request.getParameter("txtLG_TELEFONE"), request.getParameter("txtLG_EMAIL"), request.getParameter("txtLG_TIPO"), request.getParameter("txtLG_NOME"), request.getParameter("txtLG_SENHA"), situacao);
        	} else {
        		resposta = objSIS_USUARIO.inserePessoa(Integer.parseInt(request.getParameter("txtLG_MATRICULA")), Integer.parseInt(request.getParameter("txtLG_CURSO")), request.getParameter("txtLG_TELEFONE"), request.getParameter("txtLG_EMAIL"), request.getParameter("txtLG_TIPO"), request.getParameter("txtLG_NOME"), request.getParameter("txtLG_SENHA"), situacao);
        	}
        }

 		out.println(resposta);

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
   

  
if(conn != null)
    conn.close();
      %>
</body>
</html>