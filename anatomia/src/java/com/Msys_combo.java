package com;

import java.sql.*;

//codeGenVersion 2.0.72

public class Msys_combo extends DAOBase {
    public Msys_combo(){
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
	private String pNomecombo;
	private int pTiporetorno;
	private boolean pNullInfcombo=false;
	private boolean pIgnoraNullInfcombo=false;
	private String pInfcombo;
    
    //flags de filtro:
	private boolean bFiltraCodcombo;
	private boolean bFiltraNomecombo;
	private boolean bFiltraTiporetorno;
	private boolean bFiltraInfcombo;

	//Campos do recordset
	private Integer prsCodcombo;
	private boolean prsNullCodcombo;
	private String prsNomecombo;
	private boolean prsNullNomecombo;
	private Integer prsTiporetorno;
	private boolean prsNullTiporetorno;
	private String prsInfcombo;
	private boolean prsNullInfcombo;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private int pCodcomboMin;
	private String pNomecomboMin;
	private int pTiporetornoMin;
	private String pInfcomboMin;
    
    //flags de filtro:
	private boolean bFiltraCodcomboMin;
	private boolean bFiltraNomecomboMin;
	private boolean bFiltraTiporetornoMin;
	private boolean bFiltraInfcomboMin;
	private int pCodcomboMax;
	private String pNomecomboMax;
	private int pTiporetornoMax;
	private String pInfcomboMax;
    
    //flags de filtro:
	private boolean bFiltraCodcomboMax;
	private boolean bFiltraNomecomboMax;
	private boolean bFiltraTiporetornoMax;
	private boolean bFiltraInfcomboMax;
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
    public String getNomecombo(){
          return pNomecombo;
    }
 
    public void setNomecombo(String valor ) throws Exception {
	     pNomecombo = valor;
         if (valor == null){
             bFiltraNomecombo = false;
         } else {
             bFiltraNomecombo = true;
         }
    }
    public int getTiporetorno(){
          return pTiporetorno;
    }
 
    public void setTiporetorno(int valor ) throws Exception {
	     pTiporetorno = valor;
         bFiltraTiporetorno = true;
    }
    public String getInfcombo(){
          return pInfcombo;
    }
 
    public void setNullInfcombo(boolean valor){
        pNullInfcombo = valor;
    }
    public boolean getNullInfcombo(){
        return pNullInfcombo;
    }
 
    public void setIgnoraInfcombo(boolean valor){
        pIgnoraNullInfcombo = valor;
    }
 
    public void setInfcombo(String valor ) throws Exception {
	     pInfcombo = valor;
         if (valor == null){
             bFiltraInfcombo = false;
         } else {
             bFiltraInfcombo = true;
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
 
    public String getRsNomecombo(){
          if (prsNullNomecombo) {
              return null;
          } else {
              return prsNomecombo;
          }
    }
 
    public Integer getRsTiporetorno(){
          if (prsNullTiporetorno) {
              return null;
          } else {
              return prsTiporetorno;
          }
    }
 
    public String getRsInfcombo(){
          if (prsNullInfcombo) {
              return null;
          } else {
              return prsInfcombo;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento

    //m�todos das propriedades de filtro
    public int getCodcomboMin(){
         return pCodcomboMin;
    }
 
    public void setCodcomboMin(int valor ){
	     pCodcomboMin = valor;
         bFiltraCodcomboMin = true;
    }
    public String getNomecomboMin(){
          return pNomecomboMin;
    }
 
    public void setNomecomboMin(String valor ){
	     pNomecomboMin = valor;
         bFiltraNomecomboMin = true;
    }
    public int getTiporetornoMin(){
          return pTiporetornoMin;
    }
 
    public void setTiporetornoMin(int valor ){
	     pTiporetornoMin = valor;
         bFiltraTiporetornoMin = true;
    }
    public String getInfcomboMin(){
          return pInfcomboMin;
    }
 
    public void setInfcomboMin(String valor ){
	     pInfcomboMin = valor;
         bFiltraInfcomboMin = true;
    }
    public int getCodcomboMax(){
         return pCodcomboMax;
    }
 
    public void setCodcomboMax(int valor ){
	     pCodcomboMax = valor;
         bFiltraCodcomboMax = true;
    }
    public String getNomecomboMax(){
          return pNomecomboMax;
    }
 
    public void setNomecomboMax(String valor ){
	     pNomecomboMax = valor;
         bFiltraNomecomboMax = true;
    }
    public int getTiporetornoMax(){
          return pTiporetornoMax;
    }
 
    public void setTiporetornoMax(int valor ){
	     pTiporetornoMax = valor;
         bFiltraTiporetornoMax = true;
    }
    public String getInfcomboMax(){
          return pInfcomboMax;
    }
 
    public void setInfcomboMax(String valor ){
	     pInfcomboMax = valor;
         bFiltraInfcomboMax = true;
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
 
            if (bFiltraNomecombo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "'" + pNomecombo.replaceAll("'", "''") + "'";
                strgColunas = strgColunas + "nome_combo";
            }
 
            if (bFiltraTiporetorno){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pTiporetorno + "";
                strgColunas = strgColunas + "tipo_retorno";
            }
 
            if (pNullInfcombo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "inf_combo";
            }else{
                if (bFiltraInfcombo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pInfcombo.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "inf_combo";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO msys_combo (" + strgColunas + ") VALUES (" + strSql + ")";
            
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
                System.out.println("[Msys_combo.java:Insert] Falha no SQL: \n" + strSql + "\n");
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
                if (bFiltraNomecombo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "nome_combo = '" + pNomecombo.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "nome_combo = NULL";
                }
 
                if (bFiltraTiporetorno){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "tipo_retorno = " + pTiporetorno + "";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "tipo_retorno = NULL";
                }
 
            if (pNullInfcombo && !pIgnoraNullInfcombo){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "inf_combo = NULL";
            }else{
                if (bFiltraInfcombo){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "inf_combo = '" + pInfcombo.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "inf_combo = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraCodcombo){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_combo = " + pCodcombo + "";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE msys_combo set " + strSql + " WHERE " + strWhere;
                
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
                        System.out.println("[Msys_combo.java:Update] Falha no SQL: \n" + strSql + "\n");
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
            
            
            strSql = "DELETE FROM msys_combo WHERE " + strWhere + "";
            
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
                System.out.println("[Msys_combo.java:Delete] Falha no SQL: \n" + strSql + "\n");
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
            strWhere = strWhere + "msys_combo.cod_combo = " + pCodcombo + "";
        }
 
        if (bFiltraNomecombo) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.nome_combo = '" + pNomecombo.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraTiporetorno) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.tipo_retorno = " + pTiporetorno + "";
        }
 
        if (bFiltraInfcombo) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.inf_combo = '" + pInfcombo.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM msys_combo \n" ;
                    } else {
                        strSQL = strSQL + "  FROM msys_combo \n" ;
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
            System.out.println("[Msys_combo.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraCodcomboMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.cod_combo >= " + pCodcomboMin + "";
        }
 
        if (bFiltraCodcomboMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.cod_combo <= " + pCodcomboMax + "";
        }
        if (bFiltraNomecomboMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.nome_combo >= '" + pNomecomboMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraNomecomboMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.nome_combo <= '" + pNomecomboMax.replaceAll("'", "''") + "'";
        }
        if (bFiltraTiporetornoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.tipo_retorno >= " + pTiporetornoMin + "";
        }
 
        if (bFiltraTiporetornoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.tipo_retorno <= " + pTiporetornoMax + "";
        }
        if (bFiltraInfcomboMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.inf_combo >= '" + pInfcomboMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraInfcomboMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "msys_combo.inf_combo <= '" + pInfcomboMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Msys_combo origem, HC_Msys_combo destino) throws Exception{
        
        
        
         if (origem.getRsCodcombo()!=null){
               destino.setCodcombo(origem.getRsCodcombo().intValue());
             }
        
         if (origem.getRsNomecombo()!=null){
               destino.setNomecombo(origem.getRsNomecombo());
             }
        
         if (origem.getRsTiporetorno()!=null){
               destino.setTiporetorno(origem.getRsTiporetorno().intValue());
             }
        
         if (origem.getRsInfcombo()!=null){
               destino.setInfcombo(origem.getRsInfcombo());
             }
    }
    public static void mapGetRsToSetDao(Msys_combo origem, Msys_combo destino) throws Exception{
        
        
        
         if (origem.getRsCodcombo()!=null){
               destino.setCodcombo(origem.getRsCodcombo().intValue());
             }
        
         if (origem.getRsNomecombo()!=null){
               destino.setNomecombo(origem.getRsNomecombo());
             }
        
         if (origem.getRsTiporetorno()!=null){
               destino.setTiporetorno(origem.getRsTiporetorno().intValue());
             }
        
         if (origem.getRsInfcombo()!=null){
               destino.setInfcombo(origem.getRsInfcombo());
             }
    }

    public void limpaPropriedades() throws Exception {
        setCodcombo(0);
        bFiltraCodcombo = false;
        setNomecombo(null);
        bFiltraNomecombo = false;
        setTiporetorno(0);
        bFiltraTiporetorno = false;
	        pNullInfcombo=false;
	        pIgnoraNullInfcombo=false;
        setInfcombo(null);
        bFiltraInfcombo = false;
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
        setNomecomboMin(null);
        bFiltraNomecomboMin = false;
        setTiporetornoMin(0);
        bFiltraTiporetornoMin = false;
        setInfcomboMin(null);
        bFiltraInfcomboMin = false;
        setCodcomboMax(0);
        bFiltraCodcomboMax = false;
        setNomecomboMax(null);
        bFiltraNomecomboMax = false;
        setTiporetornoMax(0);
        bFiltraTiporetornoMax = false;
        setInfcomboMax(null);
        bFiltraInfcomboMax = false;
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
        prsNomecombo = null;
        prsTiporetorno = null;
        prsInfcombo = null;
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
             prsNomecombo = rs.getString("nome_combo");
             prsNullNomecombo = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsTiporetorno =  new Integer(rs.getInt("tipo_retorno"));
             prsNullTiporetorno = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsInfcombo = rs.getString("inf_combo");
             prsNullInfcombo = (rs.wasNull());
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
                strSQL = strSQL + "msys_combo.cod_combo, " ;
                strSQL = strSQL + "msys_combo.nome_combo, " ;
                strSQL = strSQL + "msys_combo.tipo_retorno, " ;
                strSQL = strSQL + "msys_combo.inf_combo" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


