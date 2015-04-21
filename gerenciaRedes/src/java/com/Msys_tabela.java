package com;

import java.sql.*;

//codeGenVersion 2.0.74

public class Msys_tabela extends DAOBase {
    public Msys_tabela(){
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
    
	private int pCodtabela;
	private String pNometabela;
	private long pSeqlivre;
	private boolean pNullInftabela=false;
	private boolean pIgnoraNullInftabela=false;
	private String pInftabela;
	private int pValincremento;
	private boolean pNullDesctitulo=false;
	private boolean pIgnoraNullDesctitulo=false;
	private String pDesctitulo;
	private boolean pNullFlagtipochave=false;
	private boolean pIgnoraNullFlagtipochave=false;
	private String pFlagtipochave;
    
    //flags de filtro:
	private boolean bFiltraCodtabela;
	private boolean bFiltraNometabela;
	private boolean bFiltraSeqlivre;
	private boolean bFiltraInftabela;
	private boolean bFiltraValincremento;
	private boolean bFiltraDesctitulo;
	private boolean bFiltraFlagtipochave;

	//Campos do recordset
	private Integer prsCodtabela;
	private boolean prsNullCodtabela;
	private String prsNometabela;
	private boolean prsNullNometabela;
	private Long prsSeqlivre;
	private boolean prsNullSeqlivre;
	private String prsInftabela;
	private boolean prsNullInftabela;
	private Integer prsValincremento;
	private boolean prsNullValincremento;
	private String prsDesctitulo;
	private boolean prsNullDesctitulo;
	private String prsFlagtipochave;
	private boolean prsNullFlagtipochave;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private int pCodtabelaMin;
	private String pNometabelaMin;
	private long pSeqlivreMin;
	private String pInftabelaMin;
	private int pValincrementoMin;
	private String pDesctituloMin;
	private String pFlagtipochaveMin;
    
    //flags de filtro:
	private boolean bFiltraCodtabelaMin;
	private boolean bFiltraNometabelaMin;
	private boolean bFiltraSeqlivreMin;
	private boolean bFiltraInftabelaMin;
	private boolean bFiltraValincrementoMin;
	private boolean bFiltraDesctituloMin;
	private boolean bFiltraFlagtipochaveMin;
	private int pCodtabelaMax;
	private String pNometabelaMax;
	private long pSeqlivreMax;
	private String pInftabelaMax;
	private int pValincrementoMax;
	private String pDesctituloMax;
	private String pFlagtipochaveMax;
    
    //flags de filtro:
	private boolean bFiltraCodtabelaMax;
	private boolean bFiltraNometabelaMax;
	private boolean bFiltraSeqlivreMax;
	private boolean bFiltraInftabelaMax;
	private boolean bFiltraValincrementoMax;
	private boolean bFiltraDesctituloMax;
	private boolean bFiltraFlagtipochaveMax;
    private boolean bFiltroIntervalo = false;
    private boolean bColunasSelect = false;


    //m�todos das propriedades
    public int getCodtabela(){
         return pCodtabela;
    }
 
    public void setCodtabela(int valor ) throws Exception {
	     pCodtabela = valor;
         bFiltraCodtabela = true;
    }
    public String getNometabela(){
          return pNometabela;
    }
 
    public void setNometabela(String valor ) throws Exception {
	     pNometabela = valor;
         if (valor == null){
             bFiltraNometabela = false;
         } else {
             bFiltraNometabela = true;
         }
    }
    public long getSeqlivre(){
          return pSeqlivre;
    }
 
    public void setSeqlivre(long valor ) throws Exception {
	     pSeqlivre = valor;
         bFiltraSeqlivre = true;
    }
    public String getInftabela(){
          return pInftabela;
    }
 
    public void setNullInftabela(boolean valor){
        pNullInftabela = valor;
    }
    public boolean getNullInftabela(){
        return pNullInftabela;
    }
 
    public void setIgnoraInftabela(boolean valor){
        pIgnoraNullInftabela = valor;
    }
 
    public void setInftabela(String valor ) throws Exception {
	     pInftabela = valor;
         if (valor == null){
             bFiltraInftabela = false;
         } else {
             bFiltraInftabela = true;
         }
    }
    public int getValincremento(){
          return pValincremento;
    }
 
    public void setValincremento(int valor ) throws Exception {
	     pValincremento = valor;
         bFiltraValincremento = true;
    }
    public String getDesctitulo(){
          return pDesctitulo;
    }
 
    public void setNullDesctitulo(boolean valor){
        pNullDesctitulo = valor;
    }
    public boolean getNullDesctitulo(){
        return pNullDesctitulo;
    }
 
    public void setIgnoraDesctitulo(boolean valor){
        pIgnoraNullDesctitulo = valor;
    }
 
    public void setDesctitulo(String valor ) throws Exception {
	     pDesctitulo = valor;
         if (valor == null){
             bFiltraDesctitulo = false;
         } else {
             bFiltraDesctitulo = true;
         }
    }
    public String getFlagtipochave(){
          return pFlagtipochave;
    }
 
    public void setNullFlagtipochave(boolean valor){
        pNullFlagtipochave = valor;
    }
    public boolean getNullFlagtipochave(){
        return pNullFlagtipochave;
    }
 
    public void setIgnoraFlagtipochave(boolean valor){
        pIgnoraNullFlagtipochave = valor;
    }
 
    public void setFlagtipochave(String valor ) throws Exception {
	     pFlagtipochave = valor;
         if (valor == null){
             bFiltraFlagtipochave = false;
         } else {
             bFiltraFlagtipochave = true;
         }
    }

    //m�todos do ResultSet
    public Integer getRsCodtabela(){
          if (prsNullCodtabela) {
              return null;
          } else {
              return prsCodtabela;
          }
    }
 
    public String getRsNometabela(){
          if (prsNullNometabela) {
              return null;
          } else {
              return prsNometabela;
          }
    }
 
    public Long getRsSeqlivre(){
          if (prsNullSeqlivre) {
              return null;
          } else {
              return prsSeqlivre;
          }
    }
 
    public String getRsInftabela(){
          if (prsNullInftabela) {
              return null;
          } else {
              return prsInftabela;
          }
    }
 
    public Integer getRsValincremento(){
          if (prsNullValincremento) {
              return null;
          } else {
              return prsValincremento;
          }
    }
 
    public String getRsDesctitulo(){
          if (prsNullDesctitulo) {
              return null;
          } else {
              return prsDesctitulo;
          }
    }
 
    public String getRsFlagtipochave(){
          if (prsNullFlagtipochave) {
              return null;
          } else {
              return prsFlagtipochave;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento

    //m�todos das propriedades de filtro
    public int getCodtabelaMin(){
         return pCodtabelaMin;
    }
 
    public void setCodtabelaMin(int valor ){
	     pCodtabelaMin = valor;
         bFiltraCodtabelaMin = true;
    }
    public String getNometabelaMin(){
          return pNometabelaMin;
    }
 
    public void setNometabelaMin(String valor ){
	     pNometabelaMin = valor;
         bFiltraNometabelaMin = true;
    }
    public long getSeqlivreMin(){
          return pSeqlivreMin;
    }
 
    public void setSeqlivreMin(long valor ){
	     pSeqlivreMin = valor;
         bFiltraSeqlivreMin = true;
    }
    public String getInftabelaMin(){
          return pInftabelaMin;
    }
 
    public void setInftabelaMin(String valor ){
	     pInftabelaMin = valor;
         bFiltraInftabelaMin = true;
    }
    public int getValincrementoMin(){
          return pValincrementoMin;
    }
 
    public void setValincrementoMin(int valor ){
	     pValincrementoMin = valor;
         bFiltraValincrementoMin = true;
    }
    public String getDesctituloMin(){
          return pDesctituloMin;
    }
 
    public void setDesctituloMin(String valor ){
	     pDesctituloMin = valor;
         bFiltraDesctituloMin = true;
    }
    public String getFlagtipochaveMin(){
          return pFlagtipochaveMin;
    }
 
    public void setFlagtipochaveMin(String valor ){
	     pFlagtipochaveMin = valor;
         bFiltraFlagtipochaveMin = true;
    }
    public int getCodtabelaMax(){
         return pCodtabelaMax;
    }
 
    public void setCodtabelaMax(int valor ){
	     pCodtabelaMax = valor;
         bFiltraCodtabelaMax = true;
    }
    public String getNometabelaMax(){
          return pNometabelaMax;
    }
 
    public void setNometabelaMax(String valor ){
	     pNometabelaMax = valor;
         bFiltraNometabelaMax = true;
    }
    public long getSeqlivreMax(){
          return pSeqlivreMax;
    }
 
    public void setSeqlivreMax(long valor ){
	     pSeqlivreMax = valor;
         bFiltraSeqlivreMax = true;
    }
    public String getInftabelaMax(){
          return pInftabelaMax;
    }
 
    public void setInftabelaMax(String valor ){
	     pInftabelaMax = valor;
         bFiltraInftabelaMax = true;
    }
    public int getValincrementoMax(){
          return pValincrementoMax;
    }
 
    public void setValincrementoMax(int valor ){
	     pValincrementoMax = valor;
         bFiltraValincrementoMax = true;
    }
    public String getDesctituloMax(){
          return pDesctituloMax;
    }
 
    public void setDesctituloMax(String valor ){
	     pDesctituloMax = valor;
         bFiltraDesctituloMax = true;
    }
    public String getFlagtipochaveMax(){
          return pFlagtipochaveMax;
    }
 
    public void setFlagtipochaveMax(String valor ){
	     pFlagtipochaveMax = valor;
         bFiltraFlagtipochaveMax = true;
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
            if (bFiltraCodtabela){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pCodtabela + "";
                strgColunas = strgColunas + "cod_tabela";
            }
 
            if (bFiltraNometabela){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "'" + pNometabela.replaceAll("'", "''") + "'";
                strgColunas = strgColunas + "nome_tabela";
            }
 
            if (bFiltraSeqlivre){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pSeqlivre + "";
                strgColunas = strgColunas + "seq_livre";
            }
 
            if (pNullInftabela){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "inf_tabela";
            }else{
                if (bFiltraInftabela){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pInftabela.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "inf_tabela";
                }
     
            }
            if (bFiltraValincremento){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pValincremento + "";
                strgColunas = strgColunas + "val_incremento";
            }
 
            if (pNullDesctitulo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_titulo";
            }else{
                if (bFiltraDesctitulo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDesctitulo.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_titulo";
                }
     
            }
            if (pNullFlagtipochave){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "flag_tipochave";
            }else{
                if (bFiltraFlagtipochave){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pFlagtipochave.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "flag_tipochave";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO msys_tabela (" + strgColunas + ") VALUES (" + strSql + ")";
            
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
                System.out.println("[Msys_tabela.java:Insert] Falha no SQL: \n" + strSql + "\n");
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
                if (bFiltraNometabela){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "nome_tabela = '" + pNometabela.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "nome_tabela = NULL";
                }
 
                if (bFiltraSeqlivre){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "seq_livre = " + pSeqlivre + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "seq_livre = NULL";
                }
 
            if (pNullInftabela && !pIgnoraNullInftabela){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "inf_tabela = NULL";
            }else{
                if (bFiltraInftabela){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "inf_tabela = '" + pInftabela.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "inf_tabela = NULL";
                }
            }
 
                if (bFiltraValincremento){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "val_incremento = " + pValincremento + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "val_incremento = NULL";
                }
 
            if (pNullDesctitulo && !pIgnoraNullDesctitulo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_titulo = NULL";
            }else{
                if (bFiltraDesctitulo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_titulo = '" + pDesctitulo.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_titulo = NULL";
                }
            }
 
            if (pNullFlagtipochave && !pIgnoraNullFlagtipochave){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "flag_tipochave = NULL";
            }else{
                if (bFiltraFlagtipochave){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "flag_tipochave = '" + pFlagtipochave.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "flag_tipochave = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraCodtabela){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_tabela = " + pCodtabela + "";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE msys_tabela set " + strSql + " WHERE " + strWhere;
                
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
                        System.out.println("[Msys_tabela.java:Update] Falha no SQL: \n" + strSql + "\n");
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
            if (bFiltraCodtabela){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_tabela = " + pCodtabela + "";
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
            
            
            strSql = "DELETE FROM msys_tabela WHERE " + strWhere + "";
            
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
                System.out.println("[Msys_tabela.java:Delete] Falha no SQL: \n" + strSql + "\n");
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
 
        if (bFiltraCodtabela) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.cod_tabela = " + pCodtabela + "";
        }
 
        if (bFiltraNometabela) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.nome_tabela = '" + pNometabela.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraSeqlivre) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.seq_livre = " + pSeqlivre + "";
        }
 
        if (bFiltraInftabela) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.inf_tabela = '" + pInftabela.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraValincremento) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.val_incremento = " + pValincremento + "";
        }
 
        if (bFiltraDesctitulo) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.desc_titulo = '" + pDesctitulo.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraFlagtipochave) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.flag_tipochave = '" + pFlagtipochave.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM msys_tabela \n" ;
                    } else {
                        strSQL = strSQL + "  FROM msys_tabela \n" ;
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
            System.out.println("[Msys_tabela.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraCodtabelaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.cod_tabela >= " + pCodtabelaMin + "";
        }
 
        if (bFiltraCodtabelaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.cod_tabela <= " + pCodtabelaMax + "";
        }
        if (bFiltraNometabelaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.nome_tabela >= '" + pNometabelaMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraNometabelaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.nome_tabela <= '" + pNometabelaMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraSeqlivreMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.seq_livre >= " + pSeqlivreMin + "";
        }
 
        if (bFiltraSeqlivreMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.seq_livre <= " + pSeqlivreMax + "";
        }
        if (bFiltraInftabelaMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.inf_tabela >= '" + pInftabelaMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraInftabelaMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.inf_tabela <= '" + pInftabelaMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraValincrementoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.val_incremento >= " + pValincrementoMin + "";
        }
 
        if (bFiltraValincrementoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.val_incremento <= " + pValincrementoMax + "";
        }
        if (bFiltraDesctituloMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.desc_titulo >= '" + pDesctituloMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDesctituloMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_tabela.desc_titulo <= '" + pDesctituloMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Msys_tabela origem, HC_Msys_tabela destino) throws Exception{
        
        
        
         if (origem.getRsCodtabela()!=null){
               destino.setCodtabela(origem.getRsCodtabela().intValue());
             }
        
         if (origem.getRsNometabela()!=null){
               destino.setNometabela(origem.getRsNometabela());
             }
        
         if (origem.getRsDesctitulo()!=null){
               destino.setDesctitulo(origem.getRsDesctitulo());
             }
        
         if (origem.getRsInftabela()!=null){
               destino.setInftabela(origem.getRsInftabela());
             }
        
         if (origem.getRsSeqlivre()!=null){
               destino.setSeqlivre(origem.getRsSeqlivre().longValue());
             }
        
         if (origem.getRsValincremento()!=null){
               destino.setValincremento(origem.getRsValincremento().intValue());
             }
        
         if (origem.getRsFlagtipochave()!=null){
               destino.setFlagtipochave(origem.getRsFlagtipochave());
             }
    }
    public static void mapGetRsToSetDao(Msys_tabela origem, Msys_tabela destino) throws Exception{
        
        
        
         if (origem.getRsCodtabela()!=null){
               destino.setCodtabela(origem.getRsCodtabela().intValue());
             }
        
         if (origem.getRsNometabela()!=null){
               destino.setNometabela(origem.getRsNometabela());
             }
        
         if (origem.getRsDesctitulo()!=null){
               destino.setDesctitulo(origem.getRsDesctitulo());
             }
        
         if (origem.getRsInftabela()!=null){
               destino.setInftabela(origem.getRsInftabela());
             }
        
         if (origem.getRsSeqlivre()!=null){
               destino.setSeqlivre(origem.getRsSeqlivre().longValue());
             }
        
         if (origem.getRsValincremento()!=null){
               destino.setValincremento(origem.getRsValincremento().intValue());
             }
        
         if (origem.getRsFlagtipochave()!=null){
               destino.setFlagtipochave(origem.getRsFlagtipochave());
             }
    }

    public void limpaPropriedades() throws Exception {
        setCodtabela(0);
        bFiltraCodtabela = false;
        setNometabela(null);
        bFiltraNometabela = false;
        setSeqlivre(0);
        bFiltraSeqlivre = false;
	        pNullInftabela=false;
	        pIgnoraNullInftabela=false;
        setInftabela(null);
        bFiltraInftabela = false;
        setValincremento(0);
        bFiltraValincremento = false;
	        pNullDesctitulo=false;
	        pIgnoraNullDesctitulo=false;
        setDesctitulo(null);
        bFiltraDesctitulo = false;
	        pNullFlagtipochave=false;
	        pIgnoraNullFlagtipochave=false;
        setFlagtipochave(null);
        bFiltraFlagtipochave = false;
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
  
        setCodtabelaMin(0);
        bFiltraCodtabelaMin = false;
        setNometabelaMin(null);
        bFiltraNometabelaMin = false;
        setSeqlivreMin(0);
        bFiltraSeqlivreMin = false;
        setInftabelaMin(null);
        bFiltraInftabelaMin = false;
        setValincrementoMin(0);
        bFiltraValincrementoMin = false;
        setDesctituloMin(null);
        bFiltraDesctituloMin = false;
        setFlagtipochaveMin(null);
        bFiltraFlagtipochaveMin = false;
        setCodtabelaMax(0);
        bFiltraCodtabelaMax = false;
        setNometabelaMax(null);
        bFiltraNometabelaMax = false;
        setSeqlivreMax(0);
        bFiltraSeqlivreMax = false;
        setInftabelaMax(null);
        bFiltraInftabelaMax = false;
        setValincrementoMax(0);
        bFiltraValincrementoMax = false;
        setDesctituloMax(null);
        bFiltraDesctituloMax = false;
        setFlagtipochaveMax(null);
        bFiltraFlagtipochaveMax = false;
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
        prsCodtabela = null;
        prsNometabela = null;
        prsSeqlivre = null;
        prsInftabela = null;
        prsValincremento = null;
        prsDesctitulo = null;
        prsFlagtipochave = null;
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
             prsCodtabela =  new Integer(rs.getInt("cod_tabela"));
             prsNullCodtabela = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsNometabela = rs.getString("nome_tabela");
             prsNullNometabela = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsSeqlivre =  new Long(rs.getLong("seq_livre"));
             prsNullSeqlivre = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsInftabela = rs.getString("inf_tabela");
             prsNullInftabela = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsValincremento =  new Integer(rs.getInt("val_incremento"));
             prsNullValincremento = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDesctitulo = rs.getString("desc_titulo");
             prsNullDesctitulo = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsFlagtipochave = rs.getString("flag_tipochave");
             prsNullFlagtipochave = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
    }
    
    public void geraProxID() throws Exception{
        HC_Msys_tabela oTabela = new HC_Msys_tabela();
        oTabela.setConnexao(getConnexao());
        oTabela.setInTransaction(getInTransaction());
        setCodtabela((int)oTabela.getProxId("msys_tabela"));
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
                strSQL = strSQL + "msys_tabela.cod_tabela, " ;
                strSQL = strSQL + "msys_tabela.nome_tabela, " ;
                strSQL = strSQL + "msys_tabela.seq_livre, " ;
                strSQL = strSQL + "msys_tabela.inf_tabela, " ;
                strSQL = strSQL + "msys_tabela.val_incremento, " ;
                strSQL = strSQL + "msys_tabela.desc_titulo, " ;
                strSQL = strSQL + "msys_tabela.flag_tipochave" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


