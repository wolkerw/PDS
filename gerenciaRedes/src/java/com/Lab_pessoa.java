package com;

import java.sql.*;

//codeGenVersion 2.0.74

public class Lab_pessoa extends DAOBase {
    public Lab_pessoa(){
    }

    //variaveis de conexao com banco
    private ResultSet recordset;
    private ResultSet rs;
    private String gJoin = "";
    private String strOrderBy = "";
    private String strTop = "";
    private boolean bFiltraOrderBy = false;
    private boolean bFiltraTop = false;
    private String strGroupBy = "";
    private boolean bFiltraGroupBy = false;
    private boolean bUpdateNull = false;
    private boolean pBlnSetaPK = false;

    //propriedades:
    
	private long pCodpessoa;
	private boolean pNullNummatricula=false;
	private boolean pIgnoraNullNummatricula=false;
	private long pNummatricula;
	private boolean pNullCodcurso=false;
	private boolean pIgnoraNullCodcurso=false;
	private long pCodcurso;
	private boolean pNullNumtelefone=false;
	private boolean pIgnoraNullNumtelefone=false;
	private String pNumtelefone;
	private boolean pNullDescemail=false;
	private boolean pIgnoraNullDescemail=false;
	private String pDescemail;
	private boolean pNullFlagtipo=false;
	private boolean pIgnoraNullFlagtipo=false;
	private String pFlagtipo;
	private boolean pNullDescnome=false;
	private boolean pIgnoraNullDescnome=false;
	private String pDescnome;
	private boolean pNullFlagsituacao=false;
	private boolean pIgnoraNullFlagsituacao=false;
	private String pFlagsituacao;
	private boolean pNullDescsenha=false;
	private boolean pIgnoraNullDescsenha=false;
	private String pDescsenha;
    
    //flags de filtro:
	private boolean bFiltraCodpessoa;
	private boolean bFiltraNummatricula;
	private boolean bFiltraCodcurso;
	private boolean bFiltraNumtelefone;
	private boolean bFiltraDescemail;
	private boolean bFiltraFlagtipo;
	private boolean bFiltraDescnome;
	private boolean bFiltraFlagsituacao;
	private boolean bFiltraDescsenha;

	//Campos do recordset
	private Long prsCodpessoa;
	private boolean prsNullCodpessoa;
	private Long prsNummatricula;
	private boolean prsNullNummatricula;
	private Long prsCodcurso;
	private boolean prsNullCodcurso;
	private String prsNumtelefone;
	private boolean prsNullNumtelefone;
	private String prsDescemail;
	private boolean prsNullDescemail;
	private String prsFlagtipo;
	private boolean prsNullFlagtipo;
	private String prsDescnome;
	private boolean prsNullDescnome;
	private String prsFlagsituacao;
	private boolean prsNullFlagsituacao;
	private String prsDescsenha;
	private boolean prsNullDescsenha;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private long pCodpessoaMin;
	private long pNummatriculaMin;
	private long pCodcursoMin;
	private String pNumtelefoneMin;
	private String pDescemailMin;
	private String pFlagtipoMin;
	private String pDescnomeMin;
	private String pFlagsituacaoMin;
	private String pDescsenhaMin;
    
    //flags de filtro:
	private boolean bFiltraCodpessoaMin;
	private boolean bFiltraNummatriculaMin;
	private boolean bFiltraCodcursoMin;
	private boolean bFiltraNumtelefoneMin;
	private boolean bFiltraDescemailMin;
	private boolean bFiltraFlagtipoMin;
	private boolean bFiltraDescnomeMin;
	private boolean bFiltraFlagsituacaoMin;
	private boolean bFiltraDescsenhaMin;
	private long pCodpessoaMax;
	private long pNummatriculaMax;
	private long pCodcursoMax;
	private String pNumtelefoneMax;
	private String pDescemailMax;
	private String pFlagtipoMax;
	private String pDescnomeMax;
	private String pFlagsituacaoMax;
	private String pDescsenhaMax;
    
    //flags de filtro:
	private boolean bFiltraCodpessoaMax;
	private boolean bFiltraNummatriculaMax;
	private boolean bFiltraCodcursoMax;
	private boolean bFiltraNumtelefoneMax;
	private boolean bFiltraDescemailMax;
	private boolean bFiltraFlagtipoMax;
	private boolean bFiltraDescnomeMax;
	private boolean bFiltraFlagsituacaoMax;
	private boolean bFiltraDescsenhaMax;
    private boolean bFiltroIntervalo = false;
    private boolean bColunasSelect = false;


    //m�todos das propriedades
    public long getCodpessoa(){
         return pCodpessoa;
    }
 
    public void setCodpessoa(long valor ) throws Exception {
	     pCodpessoa = valor;
         bFiltraCodpessoa = true;
    }
    public long getNummatricula(){
          return pNummatricula;
    }
 
    public void setNullNummatricula(boolean valor){
        pNullNummatricula = valor;
    }
    public boolean getNullNummatricula(){
        return pNullNummatricula;
    }
 
    public void setIgnoraNummatricula(boolean valor){
        pIgnoraNullNummatricula = valor;
    }
 
    public void setNummatricula(long valor ) throws Exception {
	     pNummatricula = valor;
         bFiltraNummatricula = true;
    }
    public long getCodcurso(){
          return pCodcurso;
    }
 
    public void setNullCodcurso(boolean valor){
        pNullCodcurso = valor;
    }
    public boolean getNullCodcurso(){
        return pNullCodcurso;
    }
 
    public void setIgnoraCodcurso(boolean valor){
        pIgnoraNullCodcurso = valor;
    }
 
    public void setCodcurso(long valor ) throws Exception {
	     pCodcurso = valor;
         bFiltraCodcurso = true;
    }
    public String getNumtelefone(){
          return pNumtelefone;
    }
 
    public void setNullNumtelefone(boolean valor){
        pNullNumtelefone = valor;
    }
    public boolean getNullNumtelefone(){
        return pNullNumtelefone;
    }
 
    public void setIgnoraNumtelefone(boolean valor){
        pIgnoraNullNumtelefone = valor;
    }
 
    public void setNumtelefone(String valor ) throws Exception {
	     pNumtelefone = valor;
         if (valor == null){
             bFiltraNumtelefone = false;
         } else {
             bFiltraNumtelefone = true;
         }
    }
    public String getDescemail(){
          return pDescemail;
    }
 
    public void setNullDescemail(boolean valor){
        pNullDescemail = valor;
    }
    public boolean getNullDescemail(){
        return pNullDescemail;
    }
 
    public void setIgnoraDescemail(boolean valor){
        pIgnoraNullDescemail = valor;
    }
 
    public void setDescemail(String valor ) throws Exception {
	     pDescemail = valor;
         if (valor == null){
             bFiltraDescemail = false;
         } else {
             bFiltraDescemail = true;
         }
    }
    public String getFlagtipo(){
          return pFlagtipo;
    }
 
    public void setNullFlagtipo(boolean valor){
        pNullFlagtipo = valor;
    }
    public boolean getNullFlagtipo(){
        return pNullFlagtipo;
    }
 
    public void setIgnoraFlagtipo(boolean valor){
        pIgnoraNullFlagtipo = valor;
    }
 
    public void setFlagtipo(String valor ) throws Exception {
	     pFlagtipo = valor;
         if (valor == null){
             bFiltraFlagtipo = false;
         } else {
             bFiltraFlagtipo = true;
         }
    }
    public String getDescnome(){
          return pDescnome;
    }
 
    public void setNullDescnome(boolean valor){
        pNullDescnome = valor;
    }
    public boolean getNullDescnome(){
        return pNullDescnome;
    }
 
    public void setIgnoraDescnome(boolean valor){
        pIgnoraNullDescnome = valor;
    }
 
    public void setDescnome(String valor ) throws Exception {
	     pDescnome = valor;
         if (valor == null){
             bFiltraDescnome = false;
         } else {
             bFiltraDescnome = true;
         }
    }
    public String getFlagsituacao(){
          return pFlagsituacao;
    }
 
    public void setNullFlagsituacao(boolean valor){
        pNullFlagsituacao = valor;
    }
    public boolean getNullFlagsituacao(){
        return pNullFlagsituacao;
    }
 
    public void setIgnoraFlagsituacao(boolean valor){
        pIgnoraNullFlagsituacao = valor;
    }
 
    public void setFlagsituacao(String valor ) throws Exception {
	     pFlagsituacao = valor;
         if (valor == null){
             bFiltraFlagsituacao = false;
         } else {
             bFiltraFlagsituacao = true;
         }
    }
    public String getDescsenha(){
          return pDescsenha;
    }
 
    public void setNullDescsenha(boolean valor){
        pNullDescsenha = valor;
    }
    public boolean getNullDescsenha(){
        return pNullDescsenha;
    }
 
    public void setIgnoraDescsenha(boolean valor){
        pIgnoraNullDescsenha = valor;
    }
 
    public void setDescsenha(String valor ) throws Exception {
	     pDescsenha = valor;
         if (valor == null){
             bFiltraDescsenha = false;
         } else {
             bFiltraDescsenha = true;
         }
    }

    //m�todos do ResultSet
    public Long getRsCodpessoa(){
          if (prsNullCodpessoa) {
              return null;
          } else {
              return prsCodpessoa;
          }
    }
 
    public Long getRsNummatricula(){
          if (prsNullNummatricula) {
              return null;
          } else {
              return prsNummatricula;
          }
    }
 
    public Long getRsCodcurso(){
          if (prsNullCodcurso) {
              return null;
          } else {
              return prsCodcurso;
          }
    }
 
    public String getRsNumtelefone(){
          if (prsNullNumtelefone) {
              return null;
          } else {
              return prsNumtelefone;
          }
    }
 
    public String getRsDescemail(){
          if (prsNullDescemail) {
              return null;
          } else {
              return prsDescemail;
          }
    }
 
    public String getRsFlagtipo(){
          if (prsNullFlagtipo) {
              return null;
          } else {
              return prsFlagtipo;
          }
    }
 
    public String getRsDescnome(){
          if (prsNullDescnome) {
              return null;
          } else {
              return prsDescnome;
          }
    }
 
    public String getRsFlagsituacao(){
          if (prsNullFlagsituacao) {
              return null;
          } else {
              return prsFlagsituacao;
          }
    }
 
    public String getRsDescsenha(){
          if (prsNullDescsenha) {
              return null;
          } else {
              return prsDescsenha;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento
    public Lab_curso getObCodcurso() throws Exception{
      boolean blnPassouConexao = false;
        Lab_curso oFK = new Lab_curso();
      if (DBSettings.passaConexao()){
        if(getRsCodcurso()!=null){
             oFK.setCodcurso(getRsCodcurso().longValue());
        }else{
             oFK.setFiltroIntervalo(" 1=0 ");
        }
        if (getConnexao()!=null){
             oFK.setConnexao(getConnexao());
             blnPassouConexao = true;
        }
        oFK.lista();
        oFK.next();
        if (!blnPassouConexao){
            oFK.desconecta();
        }
      }else{
        if(getRsCodcurso()!=null){
             oFK.setCodcurso(getRsCodcurso().longValue());
        }else{
             oFK.setFiltroIntervalo(" 1=0 ");
        }
        oFK.lista();
        oFK.next();
      }
        return oFK;
    }
 

    //m�todos das propriedades de filtro
    public long getCodpessoaMin(){
         return pCodpessoaMin;
    }
 
    public void setCodpessoaMin(long valor ){
	     pCodpessoaMin = valor;
         bFiltraCodpessoaMin = true;
    }
    public long getNummatriculaMin(){
          return pNummatriculaMin;
    }
 
    public void setNummatriculaMin(long valor ){
	     pNummatriculaMin = valor;
         bFiltraNummatriculaMin = true;
    }
    public long getCodcursoMin(){
          return pCodcursoMin;
    }
 
    public void setCodcursoMin(long valor ){
	     pCodcursoMin = valor;
         bFiltraCodcursoMin = true;
    }
    public String getNumtelefoneMin(){
          return pNumtelefoneMin;
    }
 
    public void setNumtelefoneMin(String valor ){
	     pNumtelefoneMin = valor;
         bFiltraNumtelefoneMin = true;
    }
    public String getDescemailMin(){
          return pDescemailMin;
    }
 
    public void setDescemailMin(String valor ){
	     pDescemailMin = valor;
         bFiltraDescemailMin = true;
    }
    public String getFlagtipoMin(){
          return pFlagtipoMin;
    }
 
    public void setFlagtipoMin(String valor ){
	     pFlagtipoMin = valor;
         bFiltraFlagtipoMin = true;
    }
    public String getDescnomeMin(){
          return pDescnomeMin;
    }
 
    public void setDescnomeMin(String valor ){
	     pDescnomeMin = valor;
         bFiltraDescnomeMin = true;
    }
    public String getFlagsituacaoMin(){
          return pFlagsituacaoMin;
    }
 
    public void setFlagsituacaoMin(String valor ){
	     pFlagsituacaoMin = valor;
         bFiltraFlagsituacaoMin = true;
    }
    public String getDescsenhaMin(){
          return pDescsenhaMin;
    }
 
    public void setDescsenhaMin(String valor ){
	     pDescsenhaMin = valor;
         bFiltraDescsenhaMin = true;
    }
    public long getCodpessoaMax(){
         return pCodpessoaMax;
    }
 
    public void setCodpessoaMax(long valor ){
	     pCodpessoaMax = valor;
         bFiltraCodpessoaMax = true;
    }
    public long getNummatriculaMax(){
          return pNummatriculaMax;
    }
 
    public void setNummatriculaMax(long valor ){
	     pNummatriculaMax = valor;
         bFiltraNummatriculaMax = true;
    }
    public long getCodcursoMax(){
          return pCodcursoMax;
    }
 
    public void setCodcursoMax(long valor ){
	     pCodcursoMax = valor;
         bFiltraCodcursoMax = true;
    }
    public String getNumtelefoneMax(){
          return pNumtelefoneMax;
    }
 
    public void setNumtelefoneMax(String valor ){
	     pNumtelefoneMax = valor;
         bFiltraNumtelefoneMax = true;
    }
    public String getDescemailMax(){
          return pDescemailMax;
    }
 
    public void setDescemailMax(String valor ){
	     pDescemailMax = valor;
         bFiltraDescemailMax = true;
    }
    public String getFlagtipoMax(){
          return pFlagtipoMax;
    }
 
    public void setFlagtipoMax(String valor ){
	     pFlagtipoMax = valor;
         bFiltraFlagtipoMax = true;
    }
    public String getDescnomeMax(){
          return pDescnomeMax;
    }
 
    public void setDescnomeMax(String valor ){
	     pDescnomeMax = valor;
         bFiltraDescnomeMax = true;
    }
    public String getFlagsituacaoMax(){
          return pFlagsituacaoMax;
    }
 
    public void setFlagsituacaoMax(String valor ){
	     pFlagsituacaoMax = valor;
         bFiltraFlagsituacaoMax = true;
    }
    public String getDescsenhaMax(){
          return pDescsenhaMax;
    }
 
    public void setDescsenhaMax(String valor ){
	     pDescsenhaMax = valor;
         bFiltraDescsenhaMax = true;
    }

    public String insert() throws Exception {
        String strSql = new String("");
        String strgColunas = new String("");
        String strErro = new String("");
        boolean blnOk;
 
        conecta();
 
        boolean isAutoCommit = false;
 
        //gera��o da chave
        if (!pBlnSetaPK){
            geraProxID();
        }

        //validacao da chave
        strErro = validaParametros("U");
        
        if (strErro.compareTo("")!=0){
            return(strErro);
        } else {
                     //Monta string de insert
            if (bFiltraCodpessoa){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pCodpessoa + "";
                strgColunas = strgColunas + "cod_pessoa";
            }
 
            if (pNullNummatricula){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "num_matricula";
            }else{
                if (bFiltraNummatricula){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "" + pNummatricula     + "";
                    strgColunas = strgColunas + "num_matricula";
                }
     
            }
            if (pNullCodcurso){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "cod_curso";
            }else{
                if (bFiltraCodcurso){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "" + pCodcurso     + "";
                    strgColunas = strgColunas + "cod_curso";
                }
     
            }
            if (pNullNumtelefone){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "num_telefone";
            }else{
                if (bFiltraNumtelefone){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pNumtelefone.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "num_telefone";
                }
     
            }
            if (pNullDescemail){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_email";
            }else{
                if (bFiltraDescemail){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDescemail.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_email";
                }
     
            }
            if (pNullFlagtipo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "flag_tipo";
            }else{
                if (bFiltraFlagtipo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pFlagtipo.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "flag_tipo";
                }
     
            }
            if (pNullDescnome){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_nome";
            }else{
                if (bFiltraDescnome){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDescnome.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_nome";
                }
     
            }
            if (pNullFlagsituacao){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "flag_situacao";
            }else{
                if (bFiltraFlagsituacao){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pFlagsituacao.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "flag_situacao";
                }
     
            }
            if (pNullDescsenha){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_senha";
            }else{
                if (bFiltraDescsenha){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDescsenha.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_senha";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO lab_pessoa (" + strgColunas + ") VALUES (" + strSql + ")";
            
            if (DBSettings.getTipoBanco() == DBSettings.TIPO_POSTGRES)
                strSql = strSql.replaceAll("\\\\", "\\\\\\\\");
            try{
                statement = conexao.createStatement();
                blnOk = statement.execute(strSql);
                
                
                statement.close();
                desconecta();
                return String.valueOf(blnOk);
            }
            catch(SQLException e){
                System.out.println("[Lab_pessoa.java:Insert] Falha no SQL: \n" + strSql + "\n");
                throw e;
            }
        }
        
    }


    public String update() throws Exception{
        String strSql = new String("");
        String strWhere = new String("");
        String strErro = new String("");
        boolean blnOk;
        
        
        //validacao da chave
        strErro = validaParametros("U");
        
        if (strErro.compareTo("")!=0){
            return(strErro);
        } else {
            
            //Monta string de update
            if (pNullNummatricula && !pIgnoraNullNummatricula){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "num_matricula = NULL";
            }else{
                if (bFiltraNummatricula){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "num_matricula = " + pNummatricula + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "num_matricula = NULL";
                }
            }
 
            if (pNullCodcurso && !pIgnoraNullCodcurso){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "cod_curso = NULL";
            }else{
                if (bFiltraCodcurso){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "cod_curso = " + pCodcurso + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "cod_curso = NULL";
                }
            }
 
            if (pNullNumtelefone && !pIgnoraNullNumtelefone){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "num_telefone = NULL";
            }else{
                if (bFiltraNumtelefone){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "num_telefone = '" + pNumtelefone.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "num_telefone = NULL";
                }
            }
 
            if (pNullDescemail && !pIgnoraNullDescemail){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_email = NULL";
            }else{
                if (bFiltraDescemail){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_email = '" + pDescemail.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_email = NULL";
                }
            }
 
            if (pNullFlagtipo && !pIgnoraNullFlagtipo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "flag_tipo = NULL";
            }else{
                if (bFiltraFlagtipo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "flag_tipo = '" + pFlagtipo.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "flag_tipo = NULL";
                }
            }
 
            if (pNullDescnome && !pIgnoraNullDescnome){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_nome = NULL";
            }else{
                if (bFiltraDescnome){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_nome = '" + pDescnome.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_nome = NULL";
                }
            }
 
            if (pNullFlagsituacao && !pIgnoraNullFlagsituacao){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "flag_situacao = NULL";
            }else{
                if (bFiltraFlagsituacao){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "flag_situacao = '" + pFlagsituacao.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "flag_situacao = NULL";
                }
            }
 
            if (pNullDescsenha && !pIgnoraNullDescsenha){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_senha = NULL";
            }else{
                if (bFiltraDescsenha){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_senha = '" + pDescsenha.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_senha = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraCodpessoa){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_pessoa = " + pCodpessoa + "";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE lab_pessoa set " + strSql + " WHERE " + strWhere;
                
                if (strSql.compareTo("")!=0){
                    
                    if (DBSettings.getTipoBanco() == DBSettings.TIPO_POSTGRES)
                        strSql = strSql.replaceAll("\\\\", "\\\\\\\\");
                
                    conecta();
                
                    try{
                        statement = conexao.createStatement();
                        blnOk = statement.execute(strSql);
                        statement.close();
                        desconecta();
                        return String.valueOf(blnOk);
                    }
                    catch(SQLException e){
                        System.out.println("[Lab_pessoa.java:Update] Falha no SQL: \n" + strSql + "\n");
                        throw e;
                    }
               } else {
                   return ("Update nao executado");
               }
           } else {
               return ("Update nao executado");
           }
            
        }
            
    }
    

    public String delete() throws Exception{
        String strSql = new String("");
        String strWhere = new String("");
        boolean blnOk;
        String strErro = new String("");
        Connection delCon = null;

        //validacao da chave
        strErro = validaParametros("U");
        
        boolean bTemChave = false;
            //Monta chave para o delete
            if (bFiltraCodpessoa){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_pessoa = " + pCodpessoa + "";
            bTemChave = true;
            }
 
            if (!bTemChave){
                throw new Exception("Chave nao setada para a exclusao");
            }
            if (bFiltroIntervalo) {
                if (strWhere.trim().compareTo("")!= 0){
                    strWhere = strWhere + " AND ";
                }
               strWhere = strWhere + strFiltroIntervalo;
            }
 
            delCon = makeConexao();
            
            
            strSql = "DELETE FROM lab_pessoa WHERE " + strWhere + "";
            
            try{
                statement = delCon.createStatement();
                blnOk = statement.execute(strSql);
                
                
                if (!inTransaction){
                    delCon.close();
                }
                statement.close();
                return String.valueOf(blnOk);
            }
            catch(SQLException e){
                System.out.println("[Lab_pessoa.java:Delete] Falha no SQL: \n" + strSql + "\n");
                throw e;
            }
            
    }


    public void lista() throws Exception{
        select(SELECT_LISTA);
    }
    
    public void select(byte tipo) throws Exception{
        Statement statement;
        String strWhere = new String();
 
        if (bFiltroIntervalo) {
            if (strFiltroIntervalo.trim().length()>0){
                if (strWhere.trim().compareTo("")!= 0){
                    strWhere = strWhere + " AND ";
                }
                strWhere = strWhere + strFiltroIntervalo;
            }
        }
 
        if (bFiltraCodpessoa) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.cod_pessoa = " + pCodpessoa + "";
        }
 
        if (bFiltraNummatricula) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.num_matricula = " + pNummatricula + "";
        }
 
        if (bFiltraCodcurso) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.cod_curso = " + pCodcurso + "";
        }
 
        if (bFiltraNumtelefone) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.num_telefone = '" + pNumtelefone.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescemail) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_email = '" + pDescemail.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraFlagtipo) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.flag_tipo = '" + pFlagtipo.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescnome) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_nome = '" + pDescnome.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraFlagsituacao) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.flag_situacao = '" + pFlagsituacao.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescsenha) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_senha = '" + pDescsenha.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM lab_pessoa \n" ;
                     strSQL = strSQL + "    	LEFT join lab_curso  \n" ;
                     strSQL = strSQL + "    	  ON lab_pessoa.cod_curso = lab_curso.cod_curso \n" ;
                    } else {
                        strSQL = strSQL + "  FROM lab_pessoa \n" ;
                    }
                } else {
                    strSQL = strSQL + gJoin;
                }
        if (strWhere.trim().compareTo("")!=0){
            strSQL = strSQL + " WHERE " + strWhere;
        }
        if (bFiltraGroupBy){
            strSQL = strSQL + " GROUP BY " + strGroupBy;
        }
        if (tipo == SELECT_LISTA){
            if (bFiltraOrderBy && strOrderBy.compareTo("")!=0){
                strSQL = strSQL + " ORDER BY " + strOrderBy;
            }
            if (bFiltraTop && (strTop.compareTo("")!=0 && DBSettings.getTipoBanco() == DBSettings.TIPO_MYSQL || strTop.compareTo("")!=0 && DBSettings.getTipoBanco() == DBSettings.TIPO_POSTGRES)){
                strSQL = strSQL + " LIMIT " + strTop;
            }
        } else {
        }
 
       if (conexao!=null){
            if (conexao.isClosed()){
                conexao = null;
            }
        }
 
        if (DBSettings.forcaNovaConexao()){
            conectaODBC();
        }else{
            conecta();
        }
 
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery( DBSettings.trataLike(strSQL+" ") );
        } catch (Exception e) {
            System.out.println("[Lab_pessoa.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraCodpessoaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.cod_pessoa >= " + pCodpessoaMin + "";
        }
 
        if (bFiltraCodpessoaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.cod_pessoa <= " + pCodpessoaMax + "";
        }
        if (bFiltraNummatriculaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.num_matricula >= " + pNummatriculaMin + "";
        }
 
        if (bFiltraNummatriculaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.num_matricula <= " + pNummatriculaMax + "";
        }
        if (bFiltraNumtelefoneMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.num_telefone >= '" + pNumtelefoneMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraNumtelefoneMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.num_telefone <= '" + pNumtelefoneMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraDescemailMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_email >= '" + pDescemailMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescemailMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_email <= '" + pDescemailMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraDescnomeMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_nome >= '" + pDescnomeMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescnomeMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_nome <= '" + pDescnomeMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraFlagsituacaoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.flag_situacao >= '" + pFlagsituacaoMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraFlagsituacaoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.flag_situacao <= '" + pFlagsituacaoMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraDescsenhaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_senha >= '" + pDescsenhaMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescsenhaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_pessoa.desc_senha <= '" + pDescsenhaMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Lab_pessoa origem, HC_Lab_pessoa destino) throws Exception{
        
        
        
         if (origem.getRsCodpessoa()!=null){
               destino.setCodpessoa(origem.getRsCodpessoa().longValue());
             }
        
         if (origem.getRsNummatricula()!=null){
               destino.setNummatricula(origem.getRsNummatricula().longValue());
             }
        
         if (origem.getRsCodcurso()!=null){
               destino.setCodcurso(origem.getRsCodcurso().longValue());
             }
        
         if (origem.getRsNumtelefone()!=null){
               destino.setNumtelefone(origem.getRsNumtelefone());
             }
        
         if (origem.getRsDescemail()!=null){
               destino.setDescemail(origem.getRsDescemail());
             }
        
         if (origem.getRsFlagtipo()!=null){
               destino.setFlagtipo(origem.getRsFlagtipo());
             }
        
         if (origem.getRsDescnome()!=null){
               destino.setDescnome(origem.getRsDescnome());
             }
        
         if (origem.getRsFlagsituacao()!=null){
               destino.setFlagsituacao(origem.getRsFlagsituacao());
             }
        
         if (origem.getRsDescsenha()!=null){
               destino.setDescsenha(origem.getRsDescsenha());
             }
    }
    public static void mapGetRsToSetDao(Lab_pessoa origem, Lab_pessoa destino) throws Exception{
        
        
        
         if (origem.getRsCodpessoa()!=null){
               destino.setCodpessoa(origem.getRsCodpessoa().longValue());
             }
        
         if (origem.getRsNummatricula()!=null){
               destino.setNummatricula(origem.getRsNummatricula().longValue());
             }
        
         if (origem.getRsCodcurso()!=null){
               destino.setCodcurso(origem.getRsCodcurso().longValue());
             }
        
         if (origem.getRsNumtelefone()!=null){
               destino.setNumtelefone(origem.getRsNumtelefone());
             }
        
         if (origem.getRsDescemail()!=null){
               destino.setDescemail(origem.getRsDescemail());
             }
        
         if (origem.getRsFlagtipo()!=null){
               destino.setFlagtipo(origem.getRsFlagtipo());
             }
        
         if (origem.getRsDescnome()!=null){
               destino.setDescnome(origem.getRsDescnome());
             }
        
         if (origem.getRsFlagsituacao()!=null){
               destino.setFlagsituacao(origem.getRsFlagsituacao());
             }
        
         if (origem.getRsDescsenha()!=null){
               destino.setDescsenha(origem.getRsDescsenha());
             }
    }

    public void limpaPropriedades() throws Exception {
        setCodpessoa(0);
        bFiltraCodpessoa = false;
	        pNullNummatricula=false;
	        pIgnoraNullNummatricula=false;
        setNummatricula(0);
        bFiltraNummatricula = false;
	        pNullCodcurso=false;
	        pIgnoraNullCodcurso=false;
        setCodcurso(0);
        bFiltraCodcurso = false;
	        pNullNumtelefone=false;
	        pIgnoraNullNumtelefone=false;
        setNumtelefone(null);
        bFiltraNumtelefone = false;
	        pNullDescemail=false;
	        pIgnoraNullDescemail=false;
        setDescemail(null);
        bFiltraDescemail = false;
	        pNullFlagtipo=false;
	        pIgnoraNullFlagtipo=false;
        setFlagtipo(null);
        bFiltraFlagtipo = false;
	        pNullDescnome=false;
	        pIgnoraNullDescnome=false;
        setDescnome(null);
        bFiltraDescnome = false;
	        pNullFlagsituacao=false;
	        pIgnoraNullFlagsituacao=false;
        setFlagsituacao(null);
        bFiltraFlagsituacao = false;
	        pNullDescsenha=false;
	        pIgnoraNullDescsenha=false;
        setDescsenha(null);
        bFiltraDescsenha = false;
        strFiltroIntervalo = "";
        bFiltroIntervalo = false;
        strColunasSelect = "";
        bColunasSelect = false;
        strOrderBy = "";
        strTop = "";
        gJoin = "";
        bFiltraOrderBy = false;
        bFiltraTop = false;
        bFiltraGroupBy = false;
        bUpdateNull = false;
        gEmpresaLogada = 0;
        gMensagemConfirmacao = null;
  
        setCodpessoaMin(0);
        bFiltraCodpessoaMin = false;
        setNummatriculaMin(0);
        bFiltraNummatriculaMin = false;
        setCodcursoMin(0);
        bFiltraCodcursoMin = false;
        setNumtelefoneMin(null);
        bFiltraNumtelefoneMin = false;
        setDescemailMin(null);
        bFiltraDescemailMin = false;
        setFlagtipoMin(null);
        bFiltraFlagtipoMin = false;
        setDescnomeMin(null);
        bFiltraDescnomeMin = false;
        setFlagsituacaoMin(null);
        bFiltraFlagsituacaoMin = false;
        setDescsenhaMin(null);
        bFiltraDescsenhaMin = false;
        setCodpessoaMax(0);
        bFiltraCodpessoaMax = false;
        setNummatriculaMax(0);
        bFiltraNummatriculaMax = false;
        setCodcursoMax(0);
        bFiltraCodcursoMax = false;
        setNumtelefoneMax(null);
        bFiltraNumtelefoneMax = false;
        setDescemailMax(null);
        bFiltraDescemailMax = false;
        setFlagtipoMax(null);
        bFiltraFlagtipoMax = false;
        setDescnomeMax(null);
        bFiltraDescnomeMax = false;
        setFlagsituacaoMax(null);
        bFiltraFlagsituacaoMax = false;
        setDescsenhaMax(null);
        bFiltraDescsenhaMax = false;
    }

     public void setInTransaction(boolean valor)
     {
          inTransaction = valor;
     }
    

     public boolean getInTransaction()
     {
          return inTransaction;
     }

    public long getGEmpresaLogada(){
         return (gEmpresaLogada);
    }


    public void setGEmpresaLogada(long valor){
         gEmpresaLogada = valor;
    }


    public long getGUsuarioLogado(){
         return (gUsuarioLogado);
    }


    public void setGUsuarioLogado(long valor){
         gUsuarioLogado = valor;
    }


    public String getGPaginaConfirmacao(){
         return (gPaginaConfirmacao);
    }


    public void setGPaginaConfirmacao(String valor){
         gPaginaConfirmacao = valor;
    }


    public String getGMensagemConfirmacao(){
         return (gMensagemConfirmacao);
    }


    public void setGMensagemConfirmacao(String valor){
         gMensagemConfirmacao = valor;
    }


    public byte getGMensagemBotao(){
         return (gMensagemBotao);
    }


    public void setGMensagemBotao(byte valor){
         gMensagemBotao = valor;
    }


    public int getGResposta(){
         return (gResposta);
    }


    public void setGResposta(int valor){
         gResposta = valor;
    }


    public String getFiltroIntervalo(){
         return (strFiltroIntervalo);
    }


    public void setFiltroIntervalo(String valor){
         strFiltroIntervalo = valor;
         bFiltroIntervalo = true;
    }


    public String getColunasSelect(){
         return (strColunasSelect);
    }


    public void setColunasSelect(String valor){
         strColunasSelect = valor;
         bColunasSelect = true;
    }


    public String getOrderBy(){
         return (strOrderBy);
    }


    public void setOrderBy(String valor){
         strOrderBy = valor;
         bFiltraOrderBy = true;
    }


    public String getTop(){
         return (strTop);
    }


    public void setTop(String valor){
         strTop = valor;
         bFiltraTop = true;
    }


    public String getGroupBy(){
         return (strGroupBy);
    }


    public void setGroupBy(String valor){
         strGroupBy = valor;
         bFiltraGroupBy = true;
    }

    public void setUpdateNull(boolean valor){
         bUpdateNull = valor;
    }


    public ResultSet rSet(){
         return (rs);
    }

    public String validaParametros(String tipo){
         return ("");
    }

    public boolean getSetaPK() {
        return pBlnSetaPK;
    }
    public void setSetaPK(boolean blnSetaPK) {
        pBlnSetaPK = blnSetaPK;
    }

    public void limpaPropriedadesRS(){
        prsCodpessoa = null;
        prsNummatricula = null;
        prsCodcurso = null;
        prsNumtelefone = null;
        prsDescemail = null;
        prsFlagtipo = null;
        prsDescnome = null;
        prsFlagsituacao = null;
        prsDescsenha = null;
    }

    public boolean next(){
        boolean resultado;
        resultado = false;
        try{
        limpaPropriedadesRS();
            resultado = rs.next();
            if (resultado){
                posicionaRs();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    public void posicionaRs() throws Exception{
        //Cuidado para manter a ordem do select
        try {
             prsCodpessoa =  new Long(rs.getLong("cod_pessoa"));
             prsNullCodpessoa = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsNummatricula =  new Long(rs.getLong("num_matricula"));
             prsNullNummatricula = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsCodcurso =  new Long(rs.getLong("cod_curso"));
             prsNullCodcurso = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsNumtelefone = rs.getString("num_telefone");
             prsNullNumtelefone = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDescemail = rs.getString("desc_email");
             prsNullDescemail = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsFlagtipo = rs.getString("flag_tipo");
             prsNullFlagtipo = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDescnome = rs.getString("desc_nome");
             prsNullDescnome = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsFlagsituacao = rs.getString("flag_situacao");
             prsNullFlagsituacao = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDescsenha = rs.getString("desc_senha");
             prsNullDescsenha = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
    }
    
    public void geraProxID() throws Exception{
        HC_Msys_tabela oTabela = new HC_Msys_tabela();
        oTabela.setConnexao(getConnexao());
        oTabela.setInTransaction(getInTransaction());
        setCodpessoa(oTabela.getProxId("lab_pessoa"));
    }

    public void setJoin(String valor){
        gJoin = valor;
    }

    public void desconecta() throws Exception{
        if (!inTransaction){
             if (conexao!=null){
                 conexao.close();
             }
             conexao=null;
        }
    }

    public void setRsPos(long posicao) throws Exception{
        long curPos = 0;
        
        try{
            while (curPos < posicao){
                  if (rs.next()){
                       curPos++;
                  } else {
                       break;
                  }
            }
        } catch (Exception e){
            throw e;
        }
    }
    
    public long conta() throws Exception{
       select(SELECT_CONTA);
       if (rs.next()){
           return rs.getLong(1);
       } else {
           return 0;
       }
    }
    
    public String colunasConsulta(byte tipoConsulta){
       String strSQL = "";
        
       if (tipoConsulta == SELECT_LISTA){
           if (bFiltraTop && DBSettings.getTipoBanco() == DBSettings.TIPO_MSDE) {
               strSQL += " TOP " + strTop + " ";
           }
           if (bColunasSelect) {
               strSQL += strColunasSelect;
           } else {
                strSQL = strSQL + "lab_pessoa.cod_pessoa, " ;
                strSQL = strSQL + "lab_pessoa.num_matricula, " ;
                strSQL = strSQL + "lab_pessoa.cod_curso, " ;
                strSQL = strSQL + "lab_pessoa.num_telefone, " ;
                strSQL = strSQL + "lab_pessoa.desc_email, " ;
                strSQL = strSQL + "lab_pessoa.flag_tipo, " ;
                strSQL = strSQL + "lab_pessoa.desc_nome, " ;
                strSQL = strSQL + "lab_pessoa.flag_situacao, " ;
                strSQL = strSQL + "lab_pessoa.desc_senha" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


