/*
 * Created on 20/07/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author virtuallis
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class DAOBase {
    //variaveis de conexao com banco
	protected ResultSet rs;
	protected ResultSetMetaData rsM;
    protected Connection conexao;
    protected Statement statement;
    
    protected String connString = DBSettings.getConnectionString();
    protected String username   = DBSettings.getUserName();
    protected String password   = DBSettings.getPassword();
    
    protected boolean gForcaJoinCompleto = false;
    protected int gResposta = 0;
    protected long gEmpresaLogada=0;
    protected boolean inTransaction = false;
    protected long gUsuarioLogado=0;
    protected String gPaginaConfirmacao="";
    protected String gMensagemConfirmacao=null;
    protected byte gMensagemBotao=MENSAGEM_OK;
    
    protected boolean bColunasSelect = false;
    protected String strColunasSelect = "";
    protected String gJoin = "";
    protected boolean bFiltroIntervalo = false;
    protected String strFiltroIntervalo;
    protected boolean bFiltraGroupBy = false;
    protected String strGroupBy = "";
    protected String strOrderBy = "";
    protected boolean bFiltraOrderBy = false;
    

    protected String strTop = "";
    protected boolean bFiltraTop = false;
    protected boolean bUpdateNull = false;
    protected boolean pBlnSetaPK = false;
    
    public final static byte SELECT_LISTA = 0;
    public final static byte SELECT_CONTA = 1;
    
    public final static byte MENSAGEM_OK = 1;
    public final static byte MENSAGEM_SIMNAO = 2;
    public final static byte MENSAGEM_OKCANCELAR = 3;
    public final static byte MENSAGEM_AVISO = 4;
    
    public final static byte RESPOSTA_NENHUMA = 0;
    public final static byte RESPOSTA_SIM = 1;
    public final static byte RESPOSTA_NAO = 2;
    public final static byte RESPOSTA_OK = 3;
    public final static byte RESPOSTA_CALCELAR = 4;
    
    public void conecta() throws Exception {
        if (conexao == null){
        	throw new Exception("Ponto Fora de Transção (conexão em outra transação)");
        }
    }

    public void conectaODBC() throws Exception {
		if (conexao == null){
			throw new Exception("Ponto Fora de Transção (conexão em outra transação)");
		}
    }

    public Connection makeConexao() throws Exception{
        conecta();
        return conexao;
    }

    public String dateToStrOut(java.util.Date data){
        try{
            return (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data));
        } catch (NullPointerException npe){
            return ("");
        } catch (Exception a){
            System.out.println("ERRO CONVERTENDO DATA");
            a.printStackTrace();
            return ("NULL");
        }
        
    }

    public java.util.Date strToDate(String valor){
            java.util.Date data;

            try {
                //System.out.println(valor);
                if (valor.indexOf(":") >= 0) {
                    data = java.text.DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM , new Locale("pt", "BR", "")).parse(valor);
                } else {
                    data = java.text.DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt","BR", "")).parse(valor);
                }
                //System.out.println(data);
            } catch (ParseException e) {
                data = null;
                System.out.print(e.toString());
            }

            return(data);
    }

    public String strOf(Object valor){
        String ret;
        try {
            ret = String.valueOf(valor);
        } catch (NullPointerException npe) {
            ret = new String("");
        } catch (Exception e){
            ret = e.toString();
        }
        if (ret.compareTo("null")==0){
            ret="";
        }
        return(ret);
    }
     
    public Object isNull(Object valor){
        if (valor!=null){
            return valor;
        } else {
            return new String("");
        }
    }
    public void setConnexao(Connection valor){
        conexao = valor;
    }

    public Connection getConnexao() throws Exception{
    		if (conexao==null){
    				throw new Exception("Ponto Fora de Transção (conexão nula)");
    		}
        return conexao;
    }
    
	public boolean getForcaJoinCompleto() {
		return gForcaJoinCompleto;
	}
	
	public void setForcaJoinCompleto(boolean joinCompleto) {
		gForcaJoinCompleto = joinCompleto;
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

   public ResultSetMetaData getResultSetMetaData(){
       return (rsM);
  }

   public boolean getSetaPK() {
       return pBlnSetaPK;
   }
   
   public void setSetaPK(boolean blnSetaPK) {
       pBlnSetaPK = blnSetaPK;
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
   

    public void lista() throws Exception{
        select(SELECT_LISTA);
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

    public String getColunasPadrao(){
    	return "";
	}
    


    public abstract String validaParametros(String tipo);
    public abstract void limpaPropriedades() throws Exception;
    public abstract void limpaPropriedadesRS() throws Exception;
    public abstract void posicionaRs() throws Exception;
    public abstract String insert() throws Exception;
    public abstract String update() throws Exception;
    public abstract String delete() throws Exception;
    public abstract void select(byte tipo) throws Exception;
}
