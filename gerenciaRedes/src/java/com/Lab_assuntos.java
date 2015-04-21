package com;

import java.sql.*;

//codeGenVersion 2.0.74

public class Lab_assuntos extends DAOBase {
    public Lab_assuntos(){
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
    
	private long pCodassunto;
	private boolean pNullDescassunto=false;
	private boolean pIgnoraNullDescassunto=false;
	private String pDescassunto;
    
    //flags de filtro:
	private boolean bFiltraCodassunto;
	private boolean bFiltraDescassunto;

	//Campos do recordset
	private Long prsCodassunto;
	private boolean prsNullCodassunto;
	private String prsDescassunto;
	private boolean prsNullDescassunto;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private long pCodassuntoMin;
	private String pDescassuntoMin;
    
    //flags de filtro:
	private boolean bFiltraCodassuntoMin;
	private boolean bFiltraDescassuntoMin;
	private long pCodassuntoMax;
	private String pDescassuntoMax;
    
    //flags de filtro:
	private boolean bFiltraCodassuntoMax;
	private boolean bFiltraDescassuntoMax;
    private boolean bFiltroIntervalo = false;
    private boolean bColunasSelect = false;


    //m�todos das propriedades
    public long getCodassunto(){
         return pCodassunto;
    }
 
    public void setCodassunto(long valor ) throws Exception {
	     pCodassunto = valor;
         bFiltraCodassunto = true;
    }
    public String getDescassunto(){
          return pDescassunto;
    }
 
    public void setNullDescassunto(boolean valor){
        pNullDescassunto = valor;
    }
    public boolean getNullDescassunto(){
        return pNullDescassunto;
    }
 
    public void setIgnoraDescassunto(boolean valor){
        pIgnoraNullDescassunto = valor;
    }
 
    public void setDescassunto(String valor ) throws Exception {
	     pDescassunto = valor;
         if (valor == null){
             bFiltraDescassunto = false;
         } else {
             bFiltraDescassunto = true;
         }
    }

    //m�todos do ResultSet
    public Long getRsCodassunto(){
          if (prsNullCodassunto) {
              return null;
          } else {
              return prsCodassunto;
          }
    }
 
    public String getRsDescassunto(){
          if (prsNullDescassunto) {
              return null;
          } else {
              return prsDescassunto;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento

    //m�todos das propriedades de filtro
    public long getCodassuntoMin(){
         return pCodassuntoMin;
    }
 
    public void setCodassuntoMin(long valor ){
	     pCodassuntoMin = valor;
         bFiltraCodassuntoMin = true;
    }
    public String getDescassuntoMin(){
          return pDescassuntoMin;
    }
 
    public void setDescassuntoMin(String valor ){
	     pDescassuntoMin = valor;
         bFiltraDescassuntoMin = true;
    }
    public long getCodassuntoMax(){
         return pCodassuntoMax;
    }
 
    public void setCodassuntoMax(long valor ){
	     pCodassuntoMax = valor;
         bFiltraCodassuntoMax = true;
    }
    public String getDescassuntoMax(){
          return pDescassuntoMax;
    }
 
    public void setDescassuntoMax(String valor ){
	     pDescassuntoMax = valor;
         bFiltraDescassuntoMax = true;
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
            if (bFiltraCodassunto){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pCodassunto + "";
                strgColunas = strgColunas + "cod_assunto";
            }
 
            if (pNullDescassunto){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_assunto";
            }else{
                if (bFiltraDescassunto){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDescassunto.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_assunto";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO lab_assuntos (" + strgColunas + ") VALUES (" + strSql + ")";
            
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
                System.out.println("[Lab_assuntos.java:Insert] Falha no SQL: \n" + strSql + "\n");
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
            if (pNullDescassunto && !pIgnoraNullDescassunto){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_assunto = NULL";
            }else{
                if (bFiltraDescassunto){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_assunto = '" + pDescassunto.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_assunto = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraCodassunto){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_assunto = " + pCodassunto + "";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE lab_assuntos set " + strSql + " WHERE " + strWhere;
                
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
                        System.out.println("[Lab_assuntos.java:Update] Falha no SQL: \n" + strSql + "\n");
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
            if (bFiltraCodassunto){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_assunto = " + pCodassunto + "";
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
            
            
            strSql = "DELETE FROM lab_assuntos WHERE " + strWhere + "";
            
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
                System.out.println("[Lab_assuntos.java:Delete] Falha no SQL: \n" + strSql + "\n");
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
 
        if (bFiltraCodassunto) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_assuntos.cod_assunto = " + pCodassunto + "";
        }
 
        if (bFiltraDescassunto) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_assuntos.desc_assunto = '" + pDescassunto.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM lab_assuntos \n" ;
                    } else {
                        strSQL = strSQL + "  FROM lab_assuntos \n" ;
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
            System.out.println("[Lab_assuntos.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraCodassuntoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_assuntos.cod_assunto >= " + pCodassuntoMin + "";
        }
 
        if (bFiltraCodassuntoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_assuntos.cod_assunto <= " + pCodassuntoMax + "";
        }
        if (bFiltraDescassuntoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_assuntos.desc_assunto >= '" + pDescassuntoMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescassuntoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_assuntos.desc_assunto <= '" + pDescassuntoMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Lab_assuntos origem, HC_Lab_assuntos destino) throws Exception{
        
        
        
         if (origem.getRsCodassunto()!=null){
               destino.setCodassunto(origem.getRsCodassunto().longValue());
             }
        
         if (origem.getRsDescassunto()!=null){
               destino.setDescassunto(origem.getRsDescassunto());
             }
    }
    public static void mapGetRsToSetDao(Lab_assuntos origem, Lab_assuntos destino) throws Exception{
        
        
        
         if (origem.getRsCodassunto()!=null){
               destino.setCodassunto(origem.getRsCodassunto().longValue());
             }
        
         if (origem.getRsDescassunto()!=null){
               destino.setDescassunto(origem.getRsDescassunto());
             }
    }

    public void limpaPropriedades() throws Exception {
        setCodassunto(0);
        bFiltraCodassunto = false;
	        pNullDescassunto=false;
	        pIgnoraNullDescassunto=false;
        setDescassunto(null);
        bFiltraDescassunto = false;
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
  
        setCodassuntoMin(0);
        bFiltraCodassuntoMin = false;
        setDescassuntoMin(null);
        bFiltraDescassuntoMin = false;
        setCodassuntoMax(0);
        bFiltraCodassuntoMax = false;
        setDescassuntoMax(null);
        bFiltraDescassuntoMax = false;
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
        prsCodassunto = null;
        prsDescassunto = null;
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
             prsCodassunto =  new Long(rs.getLong("cod_assunto"));
             prsNullCodassunto = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDescassunto = rs.getString("desc_assunto");
             prsNullDescassunto = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
    }
    
    public void geraProxID() throws Exception{
        HC_Msys_tabela oTabela = new HC_Msys_tabela();
        oTabela.setConnexao(getConnexao());
        oTabela.setInTransaction(getInTransaction());
        setCodassunto(oTabela.getProxId("lab_assuntos"));
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
                strSQL = strSQL + "lab_assuntos.cod_assunto, " ;
                strSQL = strSQL + "lab_assuntos.desc_assunto" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


