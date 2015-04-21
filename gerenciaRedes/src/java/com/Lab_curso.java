package com;

import java.sql.*;

//codeGenVersion 2.0.74

public class Lab_curso extends DAOBase {
    public Lab_curso(){
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
    
	private long pCodcurso;
	private boolean pNullDesccurso=false;
	private boolean pIgnoraNullDesccurso=false;
	private String pDesccurso;
    
    //flags de filtro:
	private boolean bFiltraCodcurso;
	private boolean bFiltraDesccurso;

	//Campos do recordset
	private Long prsCodcurso;
	private boolean prsNullCodcurso;
	private String prsDesccurso;
	private boolean prsNullDesccurso;



    //propriedades para filtros refinados:
    
    private String strFiltroIntervalo;
    private String strColunasSelect = "";
	private long pCodcursoMin;
	private String pDesccursoMin;
    
    //flags de filtro:
	private boolean bFiltraCodcursoMin;
	private boolean bFiltraDesccursoMin;
	private long pCodcursoMax;
	private String pDesccursoMax;
    
    //flags de filtro:
	private boolean bFiltraCodcursoMax;
	private boolean bFiltraDesccursoMax;
    private boolean bFiltroIntervalo = false;
    private boolean bColunasSelect = false;


    //m�todos das propriedades
    public long getCodcurso(){
         return pCodcurso;
    }
 
    public void setCodcurso(long valor ) throws Exception {
	     pCodcurso = valor;
         bFiltraCodcurso = true;
    }
    public String getDesccurso(){
          return pDesccurso;
    }
 
    public void setNullDesccurso(boolean valor){
        pNullDesccurso = valor;
    }
    public boolean getNullDesccurso(){
        return pNullDesccurso;
    }
 
    public void setIgnoraDesccurso(boolean valor){
        pIgnoraNullDesccurso = valor;
    }
 
    public void setDesccurso(String valor ) throws Exception {
	     pDesccurso = valor;
         if (valor == null){
             bFiltraDesccurso = false;
         } else {
             bFiltraDesccurso = true;
         }
    }

    //m�todos do ResultSet
    public Long getRsCodcurso(){
          if (prsNullCodcurso) {
              return null;
          } else {
              return prsCodcurso;
          }
    }
 
    public String getRsDesccurso(){
          if (prsNullDesccurso) {
              return null;
          } else {
              return prsDesccurso;
          }
    }
 
 //m�todos das chaves estrangeiras, mapeamento

    //m�todos das propriedades de filtro
    public long getCodcursoMin(){
         return pCodcursoMin;
    }
 
    public void setCodcursoMin(long valor ){
	     pCodcursoMin = valor;
         bFiltraCodcursoMin = true;
    }
    public String getDesccursoMin(){
          return pDesccursoMin;
    }
 
    public void setDesccursoMin(String valor ){
	     pDesccursoMin = valor;
         bFiltraDesccursoMin = true;
    }
    public long getCodcursoMax(){
         return pCodcursoMax;
    }
 
    public void setCodcursoMax(long valor ){
	     pCodcursoMax = valor;
         bFiltraCodcursoMax = true;
    }
    public String getDesccursoMax(){
          return pDesccursoMax;
    }
 
    public void setDesccursoMax(String valor ){
	     pDesccursoMax = valor;
         bFiltraDesccursoMax = true;
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
            if (bFiltraCodcurso){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + "" + pCodcurso + "";
                strgColunas = strgColunas + "cod_curso";
            }
 
            if (pNullDesccurso){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                    strgColunas = strgColunas + ", ";
                }
                strSql = strSql + " NULL ";
                strgColunas = strgColunas + "desc_curso";
            }else{
                if (bFiltraDesccurso){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                        strgColunas = strgColunas + ", ";
                }
                    strSql = strSql + "'" + pDesccurso.replaceAll("'", "''")     + "'";
                    strgColunas = strgColunas + "desc_curso";
                }
     
            }
            
            conecta();
            
            
            strSql = "INSERT INTO lab_curso (" + strgColunas + ") VALUES (" + strSql + ")";
            
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
                System.out.println("[Lab_curso.java:Insert] Falha no SQL: \n" + strSql + "\n");
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
            if (pNullDesccurso && !pIgnoraNullDesccurso){
                if (strSql.compareTo("")!=0){
                    strSql = strSql + ", ";
                }
                strSql = strSql + "desc_curso = NULL";
            }else{
                if (bFiltraDesccurso){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                     strSql = strSql + "desc_curso = '" + pDesccurso.replaceAll("'", "''") + "'";
                } else if (bUpdateNull){
                    if (strSql.compareTo("")!=0){
                        strSql = strSql + ", ";
                    }
                    strSql = strSql + "desc_curso = NULL";
                }
            }
 
            
            //Monta chave para o update
            if (bFiltraCodcurso){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_curso = " + pCodcurso + "";
            }
 
            if (!strSql.equals("")){
                strSql = "UPDATE lab_curso set " + strSql + " WHERE " + strWhere;
                
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
                        System.out.println("[Lab_curso.java:Update] Falha no SQL: \n" + strSql + "\n");
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
            if (bFiltraCodcurso){
                if (strWhere.trim().compareTo("")!=0){
                    strWhere = strWhere + " AND ";
                }
                 strWhere = strWhere + "cod_curso = " + pCodcurso + "";
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
            
            
            strSql = "DELETE FROM lab_curso WHERE " + strWhere + "";
            
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
                System.out.println("[Lab_curso.java:Delete] Falha no SQL: \n" + strSql + "\n");
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
 
        if (bFiltraCodcurso) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_curso.cod_curso = " + pCodcurso + "";
        }
 
        if (bFiltraDesccurso) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_curso.desc_curso = '" + pDesccurso.replaceAll("'", "''") + "'";
        }
 
        String strSQL = "SELECT ";
        strSQL = strSQL + colunasConsulta(tipo);
                if (gJoin.compareTo("")==0){
                    if (getForcaJoinCompleto()){
                     strSQL = strSQL + "     FROM lab_curso \n" ;
                    } else {
                        strSQL = strSQL + "  FROM lab_curso \n" ;
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
            System.out.println("[Lab_curso.java:Lista] Falha no SQL: \n" + strSQL + "\n");
            throw e;
        }
    }
 

    public String montaFiltro() {
        String strWhere = new String();
 
        if (bFiltraCodcursoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_curso.cod_curso >= " + pCodcursoMin + "";
        }
 
        if (bFiltraCodcursoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_curso.cod_curso <= " + pCodcursoMax + "";
        }
        if (bFiltraDesccursoMin) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_curso.desc_curso >= '" + pDesccursoMin.replaceAll("'", "''") + "'";
        }
 
        if (bFiltraDesccursoMax) {
            if (strWhere.trim().compareTo("")!= 0){
                strWhere = strWhere + " AND ";
            }
            strWhere = strWhere + "lab_curso.desc_curso <= '" + pDesccursoMax.replaceAll("'", "''") + "'";
        }
        
        return strWhere;
        
    }
 

    public static void mapGetRsToSet(HC_Lab_curso origem, HC_Lab_curso destino) throws Exception{
        
        
        
         if (origem.getRsCodcurso()!=null){
               destino.setCodcurso(origem.getRsCodcurso().longValue());
             }
        
         if (origem.getRsDesccurso()!=null){
               destino.setDesccurso(origem.getRsDesccurso());
             }
    }
    public static void mapGetRsToSetDao(Lab_curso origem, Lab_curso destino) throws Exception{
        
        
        
         if (origem.getRsCodcurso()!=null){
               destino.setCodcurso(origem.getRsCodcurso().longValue());
             }
        
         if (origem.getRsDesccurso()!=null){
               destino.setDesccurso(origem.getRsDesccurso());
             }
    }

    public void limpaPropriedades() throws Exception {
        setCodcurso(0);
        bFiltraCodcurso = false;
	        pNullDesccurso=false;
	        pIgnoraNullDesccurso=false;
        setDesccurso(null);
        bFiltraDesccurso = false;
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
  
        setCodcursoMin(0);
        bFiltraCodcursoMin = false;
        setDesccursoMin(null);
        bFiltraDesccursoMin = false;
        setCodcursoMax(0);
        bFiltraCodcursoMax = false;
        setDesccursoMax(null);
        bFiltraDesccursoMax = false;
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
        prsCodcurso = null;
        prsDesccurso = null;
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
             prsCodcurso =  new Long(rs.getLong("cod_curso"));
             prsNullCodcurso = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
        try {
             prsDesccurso = rs.getString("desc_curso");
             prsNullDesccurso = (rs.wasNull());
        } catch (Exception e) {
         
        } 
         
    }
    
    public void geraProxID() throws Exception{
        HC_Msys_tabela oTabela = new HC_Msys_tabela();
        oTabela.setConnexao(getConnexao());
        oTabela.setInTransaction(getInTransaction());
        setCodcurso(oTabela.getProxId("lab_curso"));
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
                strSQL = strSQL + "lab_curso.cod_curso, " ;
                strSQL = strSQL + "lab_curso.desc_curso" ;
           }
       } else {
           strSQL = strSQL + "COUNT(*) as numReg " ;
       }
        
       return strSQL;
    }
    


}


