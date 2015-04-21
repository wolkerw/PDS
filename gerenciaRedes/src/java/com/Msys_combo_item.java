package com;

import java.sql.*;

//codeGenVersion 2.0.72

public class Msys_combo_item extends DAOBase {
    public Msys_combo_item(){
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
    
	private int pCodcombo;
	private String pValitem;
	private int pSeqitem;
	private String pDescitem;
	private boolean pNullInfcomboitem=false;
	private boolean pIgnoraNullInfcomboitem=false;
	private String pInfcomboitem;
    
    //flags de filtro:
	private boolean bFiltraCodcombo;
	private boolean bFiltraValitem;
	private boolean bFiltraSeqitem;
	private boolean bFiltraDescitem;
	private boolean bFiltraInfcomboitem;

	//Campos do recordset
	private Integer prsCodcombo;
	private boolean prsNullCodcombo;
	private String prsValitem;
	private boolean prsNullValitem;
	private Integer prsSeqitem;
	private boolean prsNullSeqitem;
	private String prsDescitem;
	private boolean prsNullDescitem;
	private String prsInfcomboitem;
	private boolean prsNullInfcomboitem;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private int pCodcomboMin;
	private String pValitemMin;
	private int pSeqitemMin;
	private String pDescitemMin;
	private String pInfcomboitemMin;
    
    //flags de filtro:
	private boolean bFiltraCodcomboMin;
	private boolean bFiltraValitemMin;
	private boolean bFiltraSeqitemMin;
	private boolean bFiltraDescitemMin;
	private boolean bFiltraInfcomboitemMin;
	private int pCodcomboMax;
	private String pValitemMax;
	private int pSeqitemMax;
	private String pDescitemMax;
	private String pInfcomboitemMax;
    
    //flags de filtro:
	private boolean bFiltraCodcomboMax;
	private boolean bFiltraValitemMax;
	private boolean bFiltraSeqitemMax;
	private boolean bFiltraDescitemMax;
	private boolean bFiltraInfcomboitemMax;
    private boolean bFiltroIntervalo = false;
    private boolean bColunasSelect = false;


    //m�todos das propriedades
    public int getCodcombo(){
         return pCodcombo;
    }
 
    public void setCodcombo(int valor ) throws Exception {
	     pCodcombo = valor;
         bFiltraCodcombo = true;
    }
    public String getValitem(){
         return pValitem;
    }
 
    public void setValitem(String valor ) throws Exception {
		if (valor!=null)
		     if (valor.length()>20)
		          throw new Exception("O campo [val_item] permite no m�ximo [20] caracteres.");
	     pValitem = valor;
         if (valor == null){
             bFiltraValitem = false;
         } else {
             bFiltraValitem = true;
         }
    }
    public int getSeqitem(){
          return pSeqitem;
    }
 
    public void setSeqitem(int valor ) throws Exception {
	     pSeqitem = valor;
         bFiltraSeqitem = true;
    }
    public String getDescitem(){
          return pDescitem;
    }
 
    public void setDescitem(String valor ) throws Exception {
	     pDescitem = valor;
         if (valor == null){
             bFiltraDescitem = false;
         } else {
             bFiltraDescitem = true;
         }
    }
    public String getInfcomboitem(){
          return pInfcomboitem;
    }
 
    public void setNullInfcomboitem(boolean valor){
        pNullInfcomboitem = valor;
    }
    public boolean getNullInfcomboitem(){
        return pNullInfcomboitem;
    }
 
    public void setIgnoraInfcomboitem(boolean valor){
        pIgnoraNullInfcomboitem = valor;
    }
 
    public void setInfcomboitem(String valor ) throws Exception {
	     pInfcomboitem = valor;
         if (valor == null){
             bFiltraInfcomboitem = false;
         } else {
             bFiltraInfcomboitem = true;
         }
    }

    //m�todos do ResultSet
    public Integer getRsCodcombo(){
          if (prsNullCodcombo) {
              return null;
          } else {
              return prsCodcombo;
          }
    }
 
    public String getRsValitem(){
          if (prsNullValitem) {
              return null;
          } else {
              return prsValitem;
          }
    }
 
    public Integer getRsSeqitem(){
          if (prsNullSeqitem) {
              return null;
          } else {
              return prsSeqitem;
          }
    }
 
    public String getRsDescitem(){
          if (prsNullDescitem) {
              return null;
          } else {
              return prsDescitem;
          }
    }
 
    public String getRsInfcomboitem(){
          if (prsNullInfcomboitem) {
              return null;
          } else {
              return prsInfcomboitem;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento
    public Msys_combo getObCodcombo() throws Exception{
      boolean blnPassouConexao = false;
        Msys_combo oFK = new Msys_combo();
      if (DBSettings.passaConexao()){
        if(getRsCodcombo()!=null){
             oFK.setCodcombo(getRsCodcombo().intValue());
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
        if(getRsCodcombo()!=null){
             oFK.setCodcombo(getRsCodcombo().intValue());
        }else{
             oFK.setFiltroIntervalo(" 1=0 ");
        }
        oFK.lista();
        oFK.next();
      }
        return oFK;
    }
 

    //m�todos das propriedades de filtro
    public int getCodcomboMin(){
         return pCodcomboMin;
    }
 
    public void setCodcomboMin(int valor ){
	     pCodcomboMin = valor;
         bFiltraCodcomboMin = true;
    }
    public String getValitemMin(){
         return pValitemMin;
    }
 
    public void setValitemMin(String valor ){
	     pValitemMin = valor;
         bFiltraValitemMin = true;
    }
    public int getSeqitemMin(){
          return pSeqitemMin;
    }
 
    public void setSeqitemMin(int valor ){
	     pSeqitemMin = valor;
         bFiltraSeqitemMin = true;
    }
    public String getDescitemMin(){
          return pDescitemMin;
    }
 
    public void setDescitemMin(String valor ){
	     pDescitemMin = valor;
         bFiltraDescitemMin = true;
    }
    public String getInfcomboitemMin(){
          return pInfcomboitemMin;
    }
 
    public void setInfcomboitemMin(String valor ){
	     pInfcomboitemMin = valor;
         bFiltraInfcomboitemMin = true;
    }
    public int getCodcomboMax(){
         return pCodcomboMax;
    }
 
    public void setCodcomboMax(int valor ){
	     pCodcomboMax = valor;
         bFiltraCodcomboMax = true;
    }
    public String getValitemMax(){
         return pValitemMax;
    }
 
    public void setValitemMax(String valor ){
	     pValitemMax = valor;
         bFiltraValitemMax = true;
    }
    public int getSeqitemMax(){
          return pSeqitemMax;
    }
 
    public void setSeqitemMax(int valor ){
	     pSeqitemMax = valor;
         bFiltraSeqitemMax = true;
    }
    public String getDescitemMax(){
          return pDescitemMax;
    }
 
    public void setDescitemMax(String valor ){
	     pDescitemMax = valor;
         bFiltraDescitemMax = true;
    }
    public String getInfcomboitemMax(){
          return pInfcomboitemMax;
    }
 
    public void setInfcomboitemMax(String valor ){
	     pInfcomboitemMax = valor;
         bFiltraInfcomboitemMax = true;
    }

    public String insert() throws Exception {
        String strSql = new String("");
        String strgColunas = new String("");
        String strErro = new String("");
        boolean blnOk;
        //validacao da chave
        strErro = validaParametros("U");
        
        if (strErro.compareTo("")!=0){
            return(strErro);
        } else {
                     //Monta string de insert
            if (bFiltraCodcombo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pCodcombo + "";
                strgColunas = strgColunas + "cod_combo";
            }
 
            if (bFiltraValitem){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "'" + pValitem.replaceAll("'", "''") + "'";
                strgColunas = strgColunas + "val_item";
            }
 
            if (bFiltraSeqitem){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pSeqitem + "";
                strgColunas = strgColunas + "seq_item";
            }
 
            if (bFiltraDescitem){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "'" + pDescitem.replaceAll("'", "''") + "'";
                strgColunas = strgColunas + "desc_item";
            }
 
            if (pNullInfcomboitem){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "inf_comboitem";
            }else{
                if (bFiltraInfcomboitem){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pInfcomboitem.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "inf_comboitem";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO msys_combo_item (" + strgColunas + ") VALUES (" + strSql + ")";
            
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
                System.out.println("[Msys_combo_item.java:Insert] Falha no SQL: \n" + strSql + "\n");
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
                if (bFiltraSeqitem){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "seq_item = " + pSeqitem + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "seq_item = NULL";
                }
 
                if (bFiltraDescitem){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_item = '" + pDescitem.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_item = NULL";
                }
 
            if (pNullInfcomboitem && !pIgnoraNullInfcomboitem){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "inf_comboitem = NULL";
            }else{
                if (bFiltraInfcomboitem){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "inf_comboitem = '" + pInfcomboitem.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "inf_comboitem = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraCodcombo){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_combo = " + pCodcombo + "";
            }
 
            if (bFiltraValitem){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "val_item = '" + pValitem.replaceAll("'", "''") + "'";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE msys_combo_item set " + strSql + " WHERE " + strWhere;
                
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
                        System.out.println("[Msys_combo_item.java:Update] Falha no SQL: \n" + strSql + "\n");
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
            if (bFiltraCodcombo){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_combo = " + pCodcombo + "";
            bTemChave = true;
            }
 
            if (bFiltraValitem){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "val_item = '" + pValitem.replaceAll("'", "''") + "'";
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
            
            
            strSql = "DELETE FROM msys_combo_item WHERE " + strWhere + "";
            
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
                System.out.println("[Msys_combo_item.java:Delete] Falha no SQL: \n" + strSql + "\n");
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
 
        if (bFiltraCodcombo) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.cod_combo = " + pCodcombo + "";
        }
 
        if (bFiltraValitem) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.val_item = '" + pValitem.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraSeqitem) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.seq_item = " + pSeqitem + "";
        }
 
        if (bFiltraDescitem) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.desc_item = '" + pDescitem.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraInfcomboitem) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.inf_comboitem = '" + pInfcomboitem.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM msys_combo_item \n" ;
                     strSQL = strSQL + "    INNER JOIN msys_combo cod_combo_msys_combo \n" ;
                     strSQL = strSQL + "    ON msys_combo_item.cod_combo = cod_combo_msys_combo.cod_combo \n" ;
                    } else {
                        strSQL = strSQL + "  FROM msys_combo_item \n" ;
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
            System.out.println("[Msys_combo_item.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraCodcomboMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.cod_combo >= " + pCodcomboMin + "";
        }
 
        if (bFiltraCodcomboMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.cod_combo <= " + pCodcomboMax + "";
        }
        if (bFiltraValitemMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.val_item >= '" + pValitemMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraValitemMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.val_item <= '" + pValitemMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraSeqitemMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.seq_item >= " + pSeqitemMin + "";
        }
 
        if (bFiltraSeqitemMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.seq_item <= " + pSeqitemMax + "";
        }
        if (bFiltraDescitemMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.desc_item >= '" + pDescitemMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDescitemMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.desc_item <= '" + pDescitemMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraInfcomboitemMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.inf_comboitem >= '" + pInfcomboitemMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraInfcomboitemMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo_item.inf_comboitem <= '" + pInfcomboitemMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Msys_combo_item origem, HC_Msys_combo_item destino) throws Exception{
        
        
        
         if (origem.getRsCodcombo()!=null){
               destino.setCodcombo(origem.getRsCodcombo().intValue());
             }
        
         if (origem.getRsValitem()!=null){
               destino.setValitem(origem.getRsValitem());
             }
        
         if (origem.getRsSeqitem()!=null){
               destino.setSeqitem(origem.getRsSeqitem().intValue());
             }
        
         if (origem.getRsDescitem()!=null){
               destino.setDescitem(origem.getRsDescitem());
             }
        
         if (origem.getRsInfcomboitem()!=null){
               destino.setInfcomboitem(origem.getRsInfcomboitem());
             }
    }
    public static void mapGetRsToSetDao(Msys_combo_item origem, Msys_combo_item destino) throws Exception{
        
        
        
         if (origem.getRsCodcombo()!=null){
               destino.setCodcombo(origem.getRsCodcombo().intValue());
             }
        
         if (origem.getRsValitem()!=null){
               destino.setValitem(origem.getRsValitem());
             }
        
         if (origem.getRsSeqitem()!=null){
               destino.setSeqitem(origem.getRsSeqitem().intValue());
             }
        
         if (origem.getRsDescitem()!=null){
               destino.setDescitem(origem.getRsDescitem());
             }
        
         if (origem.getRsInfcomboitem()!=null){
               destino.setInfcomboitem(origem.getRsInfcomboitem());
             }
    }

    public void limpaPropriedades() throws Exception {
        setCodcombo(0);
        bFiltraCodcombo = false;
        setValitem(null);
        bFiltraValitem = false;
        setSeqitem(0);
        bFiltraSeqitem = false;
        setDescitem(null);
        bFiltraDescitem = false;
	        pNullInfcomboitem=false;
	        pIgnoraNullInfcomboitem=false;
        setInfcomboitem(null);
        bFiltraInfcomboitem = false;
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
  
        setCodcomboMin(0);
        bFiltraCodcomboMin = false;
        setValitemMin(null);
        bFiltraValitemMin = false;
        setSeqitemMin(0);
        bFiltraSeqitemMin = false;
        setDescitemMin(null);
        bFiltraDescitemMin = false;
        setInfcomboitemMin(null);
        bFiltraInfcomboitemMin = false;
        setCodcomboMax(0);
        bFiltraCodcomboMax = false;
        setValitemMax(null);
        bFiltraValitemMax = false;
        setSeqitemMax(0);
        bFiltraSeqitemMax = false;
        setDescitemMax(null);
        bFiltraDescitemMax = false;
        setInfcomboitemMax(null);
        bFiltraInfcomboitemMax = false;
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
        prsCodcombo = null;
        prsValitem = null;
        prsSeqitem = null;
        prsDescitem = null;
        prsInfcomboitem = null;
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
             prsCodcombo =  new Integer(rs.getInt("cod_combo"));
             prsNullCodcombo = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsValitem = rs.getString("val_item");
             prsNullValitem = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsSeqitem =  new Integer(rs.getInt("seq_item"));
             prsNullSeqitem = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDescitem = rs.getString("desc_item");
             prsNullDescitem = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsInfcomboitem = rs.getString("inf_comboitem");
             prsNullInfcomboitem = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
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
                strSQL = strSQL + "msys_combo_item.cod_combo, " ;
                strSQL = strSQL + "msys_combo_item.val_item, " ;
                strSQL = strSQL + "msys_combo_item.seq_item, " ;
                strSQL = strSQL + "msys_combo_item.desc_item, " ;
                strSQL = strSQL + "msys_combo_item.inf_comboitem" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


