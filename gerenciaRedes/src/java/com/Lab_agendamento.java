package com;

import java.sql.*;

//codeGenVersion 2.0.74

public class Lab_agendamento extends DAOBase {
    public Lab_agendamento(){
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
    
	private long pSeqagendametno;
	private boolean pNullCodaluno=false;
	private boolean pIgnoraNullCodaluno=false;
	private long pCodaluno;
	private boolean pNullCodprofessor=false;
	private boolean pIgnoraNullCodprofessor=false;
	private long pCodprofessor;
	private boolean pNullCodassunto=false;
	private boolean pIgnoraNullCodassunto=false;
	private long pCodassunto;
	private boolean pNullDataini=false;
	private boolean pIgnoraNullDataini=false;
	private java.util.Date pDataini;
	private boolean pNullDatafim=false;
	private boolean pIgnoraNullDatafim=false;
	private java.util.Date pDatafim;
	private boolean pNullFlagstaus=false;
	private boolean pIgnoraNullFlagstaus=false;
	private String pFlagstaus;
	private boolean pNullFlagpresenca=false;
	private boolean pIgnoraNullFlagpresenca=false;
	private String pFlagpresenca;
	private boolean pNullDescmotivo=false;
	private boolean pIgnoraNullDescmotivo=false;
	private String pDescmotivo;
    
    //flags de filtro:
	private boolean bFiltraSeqagendametno;
	private boolean bFiltraCodaluno;
	private boolean bFiltraCodprofessor;
	private boolean bFiltraCodassunto;
	private boolean bFiltraDataini;
	private boolean bFiltraDatafim;
	private boolean bFiltraFlagstaus;
	private boolean bFiltraFlagpresenca;
	private boolean bFiltraDescmotivo;

	//Campos do recordset
	private Long prsSeqagendametno;
	private boolean prsNullSeqagendametno;
	private Long prsCodaluno;
	private boolean prsNullCodaluno;
	private Long prsCodprofessor;
	private boolean prsNullCodprofessor;
	private Long prsCodassunto;
	private boolean prsNullCodassunto;
	private java.util.Date prsDataini;
	private boolean prsNullDataini;
	private java.util.Date prsDatafim;
	private boolean prsNullDatafim;
	private String prsFlagstaus;
	private boolean prsNullFlagstaus;
	private String prsFlagpresenca;
	private boolean prsNullFlagpresenca;
	private String prsDescmotivo;
	private boolean prsNullDescmotivo;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private long pSeqagendametnoMin;
	private long pCodalunoMin;
	private long pCodprofessorMin;
	private long pCodassuntoMin;
	private java.util.Date pDatainiMin;
	private java.util.Date pDatafimMin;
	private String pFlagstausMin;
	private String pFlagpresencaMin;
	private String pDescmotivoMin;
    
    //flags de filtro:
	private boolean bFiltraSeqagendametnoMin;
	private boolean bFiltraCodalunoMin;
	private boolean bFiltraCodprofessorMin;
	private boolean bFiltraCodassuntoMin;
	private boolean bFiltraDatainiMin;
	private boolean bFiltraDatafimMin;
	private boolean bFiltraFlagstausMin;
	private boolean bFiltraFlagpresencaMin;
	private boolean bFiltraDescmotivoMin;
	private long pSeqagendametnoMax;
	private long pCodalunoMax;
	private long pCodprofessorMax;
	private long pCodassuntoMax;
	private java.util.Date pDatainiMax;
	private java.util.Date pDatafimMax;
	private String pFlagstausMax;
	private String pFlagpresencaMax;
	private String pDescmotivoMax;
    
    //flags de filtro:
	private boolean bFiltraSeqagendametnoMax;
	private boolean bFiltraCodalunoMax;
	private boolean bFiltraCodprofessorMax;
	private boolean bFiltraCodassuntoMax;
	private boolean bFiltraDatainiMax;
	private boolean bFiltraDatafimMax;
	private boolean bFiltraFlagstausMax;
	private boolean bFiltraFlagpresencaMax;
	private boolean bFiltraDescmotivoMax;
    private boolean bFiltroIntervalo = false;
    private boolean bColunasSelect = false;


    //m�todos das propriedades
    public long getSeqagendametno(){
         return pSeqagendametno;
    }
 
    public void setSeqagendametno(long valor ) throws Exception {
	     pSeqagendametno = valor;
         bFiltraSeqagendametno = true;
    }
    public long getCodaluno(){
          return pCodaluno;
    }
 
    public void setNullCodaluno(boolean valor){
        pNullCodaluno = valor;
    }
    public boolean getNullCodaluno(){
        return pNullCodaluno;
    }
 
    public void setIgnoraCodaluno(boolean valor){
        pIgnoraNullCodaluno = valor;
    }
 
    public void setCodaluno(long valor ) throws Exception {
	     pCodaluno = valor;
         bFiltraCodaluno = true;
    }
    public long getCodprofessor(){
          return pCodprofessor;
    }
 
    public void setNullCodprofessor(boolean valor){
        pNullCodprofessor = valor;
    }
    public boolean getNullCodprofessor(){
        return pNullCodprofessor;
    }
 
    public void setIgnoraCodprofessor(boolean valor){
        pIgnoraNullCodprofessor = valor;
    }
 
    public void setCodprofessor(long valor ) throws Exception {
	     pCodprofessor = valor;
         bFiltraCodprofessor = true;
    }
    public long getCodassunto(){
          return pCodassunto;
    }
 
    public void setNullCodassunto(boolean valor){
        pNullCodassunto = valor;
    }
    public boolean getNullCodassunto(){
        return pNullCodassunto;
    }
 
    public void setIgnoraCodassunto(boolean valor){
        pIgnoraNullCodassunto = valor;
    }
 
    public void setCodassunto(long valor ) throws Exception {
	     pCodassunto = valor;
         bFiltraCodassunto = true;
    }
    public java.util.Date getDataini(){
          return pDataini;
    }
 
    public void setNullDataini(boolean valor){
        pNullDataini = valor;
    }
    public boolean getNullDataini(){
        return pNullDataini;
    }
 
    public void setIgnoraDataini(boolean valor){
        pIgnoraNullDataini = valor;
    }
 
    public void setDataini(java.util.Date valor ) throws Exception {
	     pDataini = valor;
         bFiltraDataini = true;
    }
    public java.util.Date getDatafim(){
          return pDatafim;
    }
 
    public void setNullDatafim(boolean valor){
        pNullDatafim = valor;
    }
    public boolean getNullDatafim(){
        return pNullDatafim;
    }
 
    public void setIgnoraDatafim(boolean valor){
        pIgnoraNullDatafim = valor;
    }
 
    public void setDatafim(java.util.Date valor ) throws Exception {
	     pDatafim = valor;
         bFiltraDatafim = true;
    }
    public String getFlagstaus(){
          return pFlagstaus;
    }
 
    public void setNullFlagstaus(boolean valor){
        pNullFlagstaus = valor;
    }
    public boolean getNullFlagstaus(){
        return pNullFlagstaus;
    }
 
    public void setIgnoraFlagstaus(boolean valor){
        pIgnoraNullFlagstaus = valor;
    }
 
    public void setFlagstaus(String valor ) throws Exception {
	     pFlagstaus = valor;
         if (valor == null){
             bFiltraFlagstaus = false;
         } else {
             bFiltraFlagstaus = true;
         }
    }
    public String getFlagpresenca(){
          return pFlagpresenca;
    }
 
    public void setNullFlagpresenca(boolean valor){
        pNullFlagpresenca = valor;
    }
    public boolean getNullFlagpresenca(){
        return pNullFlagpresenca;
    }
 
    public void setIgnoraFlagpresenca(boolean valor){
        pIgnoraNullFlagpresenca = valor;
    }
 
    public void setFlagpresenca(String valor ) throws Exception {
	     pFlagpresenca = valor;
         if (valor == null){
             bFiltraFlagpresenca = false;
         } else {
             bFiltraFlagpresenca = true;
         }
    }
    public String getDescmotivo(){
          return pDescmotivo;
    }
 
    public void setNullDescmotivo(boolean valor){
        pNullDescmotivo = valor;
    }
    public boolean getNullDescmotivo(){
        return pNullDescmotivo;
    }
 
    public void setIgnoraDescmotivo(boolean valor){
        pIgnoraNullDescmotivo = valor;
    }
 
    public void setDescmotivo(String valor ) throws Exception {
	     pDescmotivo = valor;
         if (valor == null){
             bFiltraDescmotivo = false;
         } else {
             bFiltraDescmotivo = true;
         }
    }

    //m�todos do ResultSet
    public Long getRsSeqagendametno(){
          if (prsNullSeqagendametno) {
              return null;
          } else {
              return prsSeqagendametno;
          }
    }
 
    public Long getRsCodaluno(){
          if (prsNullCodaluno) {
              return null;
          } else {
              return prsCodaluno;
          }
    }
 
    public Long getRsCodprofessor(){
          if (prsNullCodprofessor) {
              return null;
          } else {
              return prsCodprofessor;
          }
    }
 
    public Long getRsCodassunto(){
          if (prsNullCodassunto) {
              return null;
          } else {
              return prsCodassunto;
          }
    }
 
    public java.util.Date getRsDataini(){
          if (prsNullDataini) {
              return null;
          } else {
              return prsDataini;
          }
    }
 
    public java.util.Date getRsDatafim(){
          if (prsNullDatafim) {
              return null;
          } else {
              return prsDatafim;
          }
    }
 
    public String getRsFlagstaus(){
          if (prsNullFlagstaus) {
              return null;
          } else {
              return prsFlagstaus;
          }
    }
 
    public String getRsFlagpresenca(){
          if (prsNullFlagpresenca) {
              return null;
          } else {
              return prsFlagpresenca;
          }
    }
 
    public String getRsDescmotivo(){
          if (prsNullDescmotivo) {
              return null;
          } else {
              return prsDescmotivo;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento
    public Lab_pessoa getObCodaluno() throws Exception{
      boolean blnPassouConexao = false;
        Lab_pessoa oFK = new Lab_pessoa();
      if (DBSettings.passaConexao()){
        if(getRsCodaluno()!=null){
             oFK.setCodpessoa(getRsCodaluno().longValue());
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
        if(getRsCodaluno()!=null){
             oFK.setCodpessoa(getRsCodaluno().longValue());
        }else{
             oFK.setFiltroIntervalo(" 1=0 ");
        }
        oFK.lista();
        oFK.next();
      }
        return oFK;
    }
 
    public Lab_pessoa getObCodprofessor() throws Exception{
      boolean blnPassouConexao = false;
        Lab_pessoa oFK = new Lab_pessoa();
      if (DBSettings.passaConexao()){
        if(getRsCodprofessor()!=null){
             oFK.setCodpessoa(getRsCodprofessor().longValue());
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
        if(getRsCodprofessor()!=null){
             oFK.setCodpessoa(getRsCodprofessor().longValue());
        }else{
             oFK.setFiltroIntervalo(" 1=0 ");
        }
        oFK.lista();
        oFK.next();
      }
        return oFK;
    }
 
    public Lab_assuntos getObCodassunto() throws Exception{
      boolean blnPassouConexao = false;
        Lab_assuntos oFK = new Lab_assuntos();
      if (DBSettings.passaConexao()){
        if(getRsCodassunto()!=null){
             oFK.setCodassunto(getRsCodassunto().longValue());
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
        if(getRsCodassunto()!=null){
             oFK.setCodassunto(getRsCodassunto().longValue());
        }else{
             oFK.setFiltroIntervalo(" 1=0 ");
        }
        oFK.lista();
        oFK.next();
      }
        return oFK;
    }
 

    //m�todos das propriedades de filtro
    public long getSeqagendametnoMin(){
         return pSeqagendametnoMin;
    }
 
    public void setSeqagendametnoMin(long valor ){
	     pSeqagendametnoMin = valor;
         bFiltraSeqagendametnoMin = true;
    }
    public long getCodalunoMin(){
          return pCodalunoMin;
    }
 
    public void setCodalunoMin(long valor ){
	     pCodalunoMin = valor;
         bFiltraCodalunoMin = true;
    }
    public long getCodprofessorMin(){
          return pCodprofessorMin;
    }
 
    public void setCodprofessorMin(long valor ){
	     pCodprofessorMin = valor;
         bFiltraCodprofessorMin = true;
    }
    public long getCodassuntoMin(){
          return pCodassuntoMin;
    }
 
    public void setCodassuntoMin(long valor ){
	     pCodassuntoMin = valor;
         bFiltraCodassuntoMin = true;
    }
    public java.util.Date getDatainiMin(){
          return pDatainiMin;
    }
 
    public void setDatainiMin(java.util.Date valor ){
	     pDatainiMin = valor;
         bFiltraDatainiMin = true;
    }
    public java.util.Date getDatafimMin(){
          return pDatafimMin;
    }
 
    public void setDatafimMin(java.util.Date valor ){
	     pDatafimMin = valor;
         bFiltraDatafimMin = true;
    }
    public String getFlagstausMin(){
          return pFlagstausMin;
    }
 
    public void setFlagstausMin(String valor ){
	     pFlagstausMin = valor;
         bFiltraFlagstausMin = true;
    }
    public String getFlagpresencaMin(){
          return pFlagpresencaMin;
    }
 
    public void setFlagpresencaMin(String valor ){
	     pFlagpresencaMin = valor;
         bFiltraFlagpresencaMin = true;
    }
    public String getDescmotivoMin(){
          return pDescmotivoMin;
    }
 
    public void setDescmotivoMin(String valor ){
	     pDescmotivoMin = valor;
         bFiltraDescmotivoMin = true;
    }
    public long getSeqagendametnoMax(){
         return pSeqagendametnoMax;
    }
 
    public void setSeqagendametnoMax(long valor ){
	     pSeqagendametnoMax = valor;
         bFiltraSeqagendametnoMax = true;
    }
    public long getCodalunoMax(){
          return pCodalunoMax;
    }
 
    public void setCodalunoMax(long valor ){
	     pCodalunoMax = valor;
         bFiltraCodalunoMax = true;
    }
    public long getCodprofessorMax(){
          return pCodprofessorMax;
    }
 
    public void setCodprofessorMax(long valor ){
	     pCodprofessorMax = valor;
         bFiltraCodprofessorMax = true;
    }
    public long getCodassuntoMax(){
          return pCodassuntoMax;
    }
 
    public void setCodassuntoMax(long valor ){
	     pCodassuntoMax = valor;
         bFiltraCodassuntoMax = true;
    }
    public java.util.Date getDatainiMax(){
          return pDatainiMax;
    }
 
    public void setDatainiMax(java.util.Date valor ){
	     pDatainiMax = valor;
         bFiltraDatainiMax = true;
    }
    public java.util.Date getDatafimMax(){
          return pDatafimMax;
    }
 
    public void setDatafimMax(java.util.Date valor ){
	     pDatafimMax = valor;
         bFiltraDatafimMax = true;
    }
    public String getFlagstausMax(){
          return pFlagstausMax;
    }
 
    public void setFlagstausMax(String valor ){
	     pFlagstausMax = valor;
         bFiltraFlagstausMax = true;
    }
    public String getFlagpresencaMax(){
          return pFlagpresencaMax;
    }
 
    public void setFlagpresencaMax(String valor ){
	     pFlagpresencaMax = valor;
         bFiltraFlagpresencaMax = true;
    }
    public String getDescmotivoMax(){
          return pDescmotivoMax;
    }
 
    public void setDescmotivoMax(String valor ){
	     pDescmotivoMax = valor;
         bFiltraDescmotivoMax = true;
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
            if (bFiltraSeqagendametno){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pSeqagendametno + "";
                strgColunas = strgColunas + "seq_agendametno";
            }
 
            if (pNullCodaluno){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "cod_aluno";
            }else{
                if (bFiltraCodaluno){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "" + pCodaluno     + "";
                    strgColunas = strgColunas + "cod_aluno";
                }
     
            }
            if (pNullCodprofessor){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "cod_professor";
            }else{
                if (bFiltraCodprofessor){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "" + pCodprofessor     + "";
                    strgColunas = strgColunas + "cod_professor";
                }
     
            }
            if (pNullCodassunto){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "cod_assunto";
            }else{
                if (bFiltraCodassunto){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "" + pCodassunto     + "";
                    strgColunas = strgColunas + "cod_assunto";
                }
     
            }
            if (pNullDataini){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "data_ini";
            }else{
                if (bFiltraDataini){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + Utilitario.dateToStrSQL(pDataini) + "'";
                    strgColunas = strgColunas + "data_ini";
                }
     
            }
            if (pNullDatafim){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "data_fim";
            }else{
                if (bFiltraDatafim){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + Utilitario.dateToStrSQL(pDatafim) + "'";
                    strgColunas = strgColunas + "data_fim";
                }
     
            }
            if (pNullFlagstaus){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "flag_staus";
            }else{
                if (bFiltraFlagstaus){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pFlagstaus.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "flag_staus";
                }
     
            }
            if (pNullFlagpresenca){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "flag_presenca";
            }else{
                if (bFiltraFlagpresenca){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pFlagpresenca.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "flag_presenca";
                }
     
            }
            if (pNullDescmotivo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_motivo";
            }else{
                if (bFiltraDescmotivo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDescmotivo.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_motivo";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO lab_agendamento (" + strgColunas + ") VALUES (" + strSql + ")";
            
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
                System.out.println("[Lab_agendamento.java:Insert] Falha no SQL: \n" + strSql + "\n");
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
            if (pNullCodaluno && !pIgnoraNullCodaluno){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "cod_aluno = NULL";
            }else{
                if (bFiltraCodaluno){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "cod_aluno = " + pCodaluno + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "cod_aluno = NULL";
                }
            }
 
            if (pNullCodprofessor && !pIgnoraNullCodprofessor){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "cod_professor = NULL";
            }else{
                if (bFiltraCodprofessor){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "cod_professor = " + pCodprofessor + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "cod_professor = NULL";
                }
            }
 
            if (pNullCodassunto && !pIgnoraNullCodassunto){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "cod_assunto = NULL";
            }else{
                if (bFiltraCodassunto){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "cod_assunto = " + pCodassunto + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "cod_assunto = NULL";
                }
            }
 
            if (pNullDataini && !pIgnoraNullDataini){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "data_ini = NULL";
            }else{
                if (bFiltraDataini){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "data_ini = '" + Utilitario.dateToStrSQL(pDataini) + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "data_ini = NULL";
                }
            }
 
            if (pNullDatafim && !pIgnoraNullDatafim){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "data_fim = NULL";
            }else{
                if (bFiltraDatafim){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "data_fim = '" + Utilitario.dateToStrSQL(pDatafim) + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "data_fim = NULL";
                }
            }
 
            if (pNullFlagstaus && !pIgnoraNullFlagstaus){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "flag_staus = NULL";
            }else{
                if (bFiltraFlagstaus){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "flag_staus = '" + pFlagstaus.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "flag_staus = NULL";
                }
            }
 
            if (pNullFlagpresenca && !pIgnoraNullFlagpresenca){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "flag_presenca = NULL";
            }else{
                if (bFiltraFlagpresenca){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "flag_presenca = '" + pFlagpresenca.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "flag_presenca = NULL";
                }
            }
 
            if (pNullDescmotivo && !pIgnoraNullDescmotivo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_motivo = NULL";
            }else{
                if (bFiltraDescmotivo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_motivo = '" + pDescmotivo.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_motivo = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraSeqagendametno){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "seq_agendametno = " + pSeqagendametno + "";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE lab_agendamento set " + strSql + " WHERE " + strWhere;
                
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
                        System.out.println("[Lab_agendamento.java:Update] Falha no SQL: \n" + strSql + "\n");
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
            if (bFiltraSeqagendametno){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "seq_agendametno = " + pSeqagendametno + "";
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
            
            
            strSql = "DELETE FROM lab_agendamento WHERE " + strWhere + "";
            
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
                System.out.println("[Lab_agendamento.java:Delete] Falha no SQL: \n" + strSql + "\n");
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
 
        if (bFiltraSeqagendametno) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.seq_agendametno = " + pSeqagendametno + "";
        }
 
        if (bFiltraCodaluno) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.cod_aluno = " + pCodaluno + "";
        }
 
        if (bFiltraCodprofessor) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.cod_professor = " + pCodprofessor + "";
        }
 
        if (bFiltraCodassunto) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.cod_assunto = " + pCodassunto + "";
        }
 
        if (bFiltraDataini) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.data_ini = '" + Utilitario.dateToStrSQL(pDataini) + "'";
        }
 
        if (bFiltraDatafim) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.data_fim = '" + Utilitario.dateToStrSQL(pDatafim) + "'";
        }
 
        if (bFiltraFlagstaus) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.flag_staus = '" + pFlagstaus.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraFlagpresenca) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.flag_presenca = '" + pFlagpresenca.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescmotivo) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.desc_motivo = '" + pDescmotivo.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM lab_agendamento \n" ;
                     strSQL = strSQL + "    	LEFT join lab_pessoa  \n" ;
                     strSQL = strSQL + "    	  ON lab_agendamento.cod_aluno = lab_pessoa.cod_pessoa \n" ;
                     strSQL = strSQL + "    	  AND lab_agendamento.cod_professor = lab_pessoa.cod_pessoa \n" ;
                     strSQL = strSQL + "    	LEFT join lab_assuntos  \n" ;
                     strSQL = strSQL + "    	  ON lab_agendamento.cod_assunto = lab_assuntos.cod_assunto \n" ;
                    } else {
                        strSQL = strSQL + "  FROM lab_agendamento \n" ;
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
            System.out.println("[Lab_agendamento.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraSeqagendametnoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.seq_agendametno >= " + pSeqagendametnoMin + "";
        }
 
        if (bFiltraSeqagendametnoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.seq_agendametno <= " + pSeqagendametnoMax + "";
        }
        if (bFiltraDatainiMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.data_ini >= '" + Utilitario.dateToStrSQL(pDatainiMin) + "'";
        }
 
        if (bFiltraDatainiMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.data_ini <= '" + Utilitario.dateToStrSQL(pDatainiMax) + "'";
        }
        if (bFiltraDatafimMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.data_fim >= '" + Utilitario.dateToStrSQL(pDatafimMin) + "'";
        }
 
        if (bFiltraDatafimMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.data_fim <= '" + Utilitario.dateToStrSQL(pDatafimMax) + "'";
        }
        if (bFiltraFlagpresencaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.flag_presenca >= '" + pFlagpresencaMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraFlagpresencaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.flag_presenca <= '" + pFlagpresencaMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraDescmotivoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.desc_motivo >= '" + pDescmotivoMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescmotivoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_agendamento.desc_motivo <= '" + pDescmotivoMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Lab_agendamento origem, HC_Lab_agendamento destino) throws Exception{
        
        
        
         if (origem.getRsSeqagendametno()!=null){
               destino.setSeqagendametno(origem.getRsSeqagendametno().longValue());
             }
        
         if (origem.getRsCodaluno()!=null){
               destino.setCodaluno(origem.getRsCodaluno().longValue());
             }
        
         if (origem.getRsCodprofessor()!=null){
               destino.setCodprofessor(origem.getRsCodprofessor().longValue());
             }
        
         if (origem.getRsCodassunto()!=null){
               destino.setCodassunto(origem.getRsCodassunto().longValue());
             }
        
         if (origem.getRsDataini()!=null){
               destino.setDataini(origem.getRsDataini());
             }
        
         if (origem.getRsDatafim()!=null){
               destino.setDatafim(origem.getRsDatafim());
             }
        
         if (origem.getRsFlagstaus()!=null){
               destino.setFlagstaus(origem.getRsFlagstaus());
             }
        
         if (origem.getRsFlagpresenca()!=null){
               destino.setFlagpresenca(origem.getRsFlagpresenca());
             }
        
         if (origem.getRsDescmotivo()!=null){
               destino.setDescmotivo(origem.getRsDescmotivo());
             }
    }
    public static void mapGetRsToSetDao(Lab_agendamento origem, Lab_agendamento destino) throws Exception{
        
        
        
         if (origem.getRsSeqagendametno()!=null){
               destino.setSeqagendametno(origem.getRsSeqagendametno().longValue());
             }
        
         if (origem.getRsCodaluno()!=null){
               destino.setCodaluno(origem.getRsCodaluno().longValue());
             }
        
         if (origem.getRsCodprofessor()!=null){
               destino.setCodprofessor(origem.getRsCodprofessor().longValue());
             }
        
         if (origem.getRsCodassunto()!=null){
               destino.setCodassunto(origem.getRsCodassunto().longValue());
             }
        
         if (origem.getRsDataini()!=null){
               destino.setDataini(origem.getRsDataini());
             }
        
         if (origem.getRsDatafim()!=null){
               destino.setDatafim(origem.getRsDatafim());
             }
        
         if (origem.getRsFlagstaus()!=null){
               destino.setFlagstaus(origem.getRsFlagstaus());
             }
        
         if (origem.getRsFlagpresenca()!=null){
               destino.setFlagpresenca(origem.getRsFlagpresenca());
             }
        
         if (origem.getRsDescmotivo()!=null){
               destino.setDescmotivo(origem.getRsDescmotivo());
             }
    }

    public void limpaPropriedades() throws Exception {
        setSeqagendametno(0);
        bFiltraSeqagendametno = false;
	        pNullCodaluno=false;
	        pIgnoraNullCodaluno=false;
        setCodaluno(0);
        bFiltraCodaluno = false;
	        pNullCodprofessor=false;
	        pIgnoraNullCodprofessor=false;
        setCodprofessor(0);
        bFiltraCodprofessor = false;
	        pNullCodassunto=false;
	        pIgnoraNullCodassunto=false;
        setCodassunto(0);
        bFiltraCodassunto = false;
	        pNullDataini=false;
	        pIgnoraNullDataini=false;
        setDataini(null);
        bFiltraDataini = false;
	        pNullDatafim=false;
	        pIgnoraNullDatafim=false;
        setDatafim(null);
        bFiltraDatafim = false;
	        pNullFlagstaus=false;
	        pIgnoraNullFlagstaus=false;
        setFlagstaus(null);
        bFiltraFlagstaus = false;
	        pNullFlagpresenca=false;
	        pIgnoraNullFlagpresenca=false;
        setFlagpresenca(null);
        bFiltraFlagpresenca = false;
	        pNullDescmotivo=false;
	        pIgnoraNullDescmotivo=false;
        setDescmotivo(null);
        bFiltraDescmotivo = false;
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
  
        setSeqagendametnoMin(0);
        bFiltraSeqagendametnoMin = false;
        setCodalunoMin(0);
        bFiltraCodalunoMin = false;
        setCodprofessorMin(0);
        bFiltraCodprofessorMin = false;
        setCodassuntoMin(0);
        bFiltraCodassuntoMin = false;
        setDatainiMin(null);
        bFiltraDatainiMin = false;
        setDatafimMin(null);
        bFiltraDatafimMin = false;
        setFlagstausMin(null);
        bFiltraFlagstausMin = false;
        setFlagpresencaMin(null);
        bFiltraFlagpresencaMin = false;
        setDescmotivoMin(null);
        bFiltraDescmotivoMin = false;
        setSeqagendametnoMax(0);
        bFiltraSeqagendametnoMax = false;
        setCodalunoMax(0);
        bFiltraCodalunoMax = false;
        setCodprofessorMax(0);
        bFiltraCodprofessorMax = false;
        setCodassuntoMax(0);
        bFiltraCodassuntoMax = false;
        setDatainiMax(null);
        bFiltraDatainiMax = false;
        setDatafimMax(null);
        bFiltraDatafimMax = false;
        setFlagstausMax(null);
        bFiltraFlagstausMax = false;
        setFlagpresencaMax(null);
        bFiltraFlagpresencaMax = false;
        setDescmotivoMax(null);
        bFiltraDescmotivoMax = false;
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
        prsSeqagendametno = null;
        prsCodaluno = null;
        prsCodprofessor = null;
        prsCodassunto = null;
        prsDataini = null;
        prsDatafim = null;
        prsFlagstaus = null;
        prsFlagpresenca = null;
        prsDescmotivo = null;
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
             prsSeqagendametno =  new Long(rs.getLong("seq_agendametno"));
             prsNullSeqagendametno = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsCodaluno =  new Long(rs.getLong("cod_aluno"));
             prsNullCodaluno = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsCodprofessor =  new Long(rs.getLong("cod_professor"));
             prsNullCodprofessor = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsCodassunto =  new Long(rs.getLong("cod_assunto"));
             prsNullCodassunto = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDataini = rs.getTimestamp("data_ini");
             prsNullDataini = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDatafim = rs.getTimestamp("data_fim");
             prsNullDatafim = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsFlagstaus = rs.getString("flag_staus");
             prsNullFlagstaus = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsFlagpresenca = rs.getString("flag_presenca");
             prsNullFlagpresenca = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDescmotivo = rs.getString("desc_motivo");
             prsNullDescmotivo = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
    }
    
    public void geraProxID() throws Exception{
        HC_Msys_tabela oTabela = new HC_Msys_tabela();
        oTabela.setConnexao(getConnexao());
        oTabela.setInTransaction(getInTransaction());
        setSeqagendametno(oTabela.getProxId("lab_agendamento"));
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
                strSQL = strSQL + "lab_agendamento.seq_agendametno, " ;
                strSQL = strSQL + "lab_agendamento.cod_aluno, " ;
                strSQL = strSQL + "lab_agendamento.cod_professor, " ;
                strSQL = strSQL + "lab_agendamento.cod_assunto, " ;
                strSQL = strSQL + "lab_agendamento.data_ini, " ;
                strSQL = strSQL + "lab_agendamento.data_fim, " ;
                strSQL = strSQL + "lab_agendamento.flag_staus, " ;
                strSQL = strSQL + "lab_agendamento.flag_presenca, " ;
                strSQL = strSQL + "lab_agendamento.desc_motivo" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


