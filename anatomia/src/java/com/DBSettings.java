package com;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public final class DBSettings implements Serializable{ 
	
	//private static final String ARQUIVO_XML = "DBSettingsSrvAugusta.xml";
   //private static final String ARQUIVO_XML = "DBSettings_Local_botucarai.xml";
	
	private static final String PASTA_APLICACAO = "";
	private static final String ARQUIVO_XML = "DBSettings.xml";
	
	public final static int TIPO_POSTGRES = 0;
	public final static int TIPO_MYSQL = 1;
	public final static int TIPO_MSDE = 2;
	
	public final static int TOP_CIMA = 1;
	public final static int TOP_BAIXO = 2;

	public final static int SQLEXCEPTIONDesconhecido = 0;
	public final static int SQLEXCEPTIONViolacaoPK = 1;
	public final static int SQLEXCEPTIONViolacaoFK = 2;
	public final static int SQLEXCEPTIONOverflow = 3;
	public final static int SQLEXCEPTIONDataInvalida = 4;
	
	private static boolean blnCarregado = false;
	private static long lModificacao = -1;
	
	private static String strDBGConnectionID = "";
	
	private static String strStaticConnectionString = "";
	private static String strStaticHostName = "";
	private static String strStaticDBName = "";
	private static String strStaticUserName = "";
	private static String strStaticPassword = "";
	private static String strStaticJDBCClass = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private static int iStaticTipoBanco = TIPO_POSTGRES;
	private static String strStaticDBBackupPath = System.getProperty("user.home");
	private static String strStaticPathPGDump = System.getProperty("user.home");
	private static boolean blnStaticPassaConexao = true;
	private static boolean blnStaticForcaNovaConexao =  false;
	
	private String xmlConnectionString = "";
	private String xmlHostName = "";
	private String xmlDBName = "";
	private String xmlUserName = "";
	private String xmlPassword = "";
	private String xmlJDBCClass = "";	
	private int xmlTipoBanco = TIPO_MSDE;
	private String xmlDBBackupPath = "";
	private String xmlPathPGDump = "";
	private boolean xmlPassaConexao = true;
	private boolean xmlForcaNovaConexao =  true;
	
	
	//o que importa
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/trab", "postgres", "sti");
    }

	
	
	
    public static String getHostName() {
        return strStaticHostName;
    }

    public static void setHostName(String strStaticHostName) {
        DBSettings.strStaticHostName = strStaticHostName;
    }
    
	public String getXmlConnectionString(){
		return xmlConnectionString;
	}
	
	public void setXmlConnectionString(String valor)
	{ 
		xmlConnectionString = valor;
	}
	
	
	public String getXmlHostName(){
		return xmlHostName;
	}
	
	public void setXmlHostName(String valor)
	{ 
		xmlHostName = valor;
	}
	
	public String getXmlDBName(){
		return xmlDBName;
	}
	
	public void setXmlDBName(String valor)
	{ 
		xmlDBName = valor;
	}
	
	
	public String getXmlUserName(){
		return xmlUserName;
	}
	
	public void setXmlUserName(String valor)
	{
		xmlUserName = valor;
	}
	
	public String getXmlPassword(){
		return xmlPassword;
	}
	
	public void setXmlPassword(String valor)
	{
		xmlPassword = valor;
	}
	
	public String getXmlJDBCClass(){
		return xmlJDBCClass;
	}
	
	public void setXmlJDBCClass(String valor)
	{
		xmlJDBCClass = valor;
	}
	
	public int getXmlTipoBanco(){
		return xmlTipoBanco;
	}
	
	public void setXmlTipoBanco(int valor)
	{
		xmlTipoBanco = valor;
	}
	
	public String getXmlDBBackupPath(){
		return xmlDBBackupPath;
	}
	
	public void setXmlDBBackupPath(String valor)
	{
		xmlDBBackupPath = valor;
	}
	
    public String getXmlPathPGDump() {
        return xmlPathPGDump;
    }

    public void setXmlPathPGDump(String valor) {
        xmlPathPGDump = valor;
    }

	public boolean getXmlPassaConexao(){
		return xmlPassaConexao;
	}
	
	public void setXmlPassaConexao(boolean valor)
	{
		xmlPassaConexao = valor;
	}
	
	public boolean getXmlForcaNovaConexao(){
		return xmlForcaNovaConexao;
	}
	
	public void setXmlForcaNovaConexao(boolean valor)
	{
		xmlForcaNovaConexao = valor;
	}
	
	public void serializa() throws Exception
	{
		
		XMLEncoder xe = new XMLEncoder( new FileOutputStream( ARQUIVO_XML ) );
		xe.writeObject( this );
		xe.close();
	}
	
	public static void carregaXml()
	{
		try {
            // System.out.println("DBS Carregando "+Utilitario.getPastaConfiguracao()+File.separator+ARQUIVO_XML);
			//String strLocalConf = "C:/Program Files/Apache Software Foundation/Tomcat 5.5/webapps/erp/WEB-INF/";
			
            File flXml = new File ( PASTA_APLICACAO+File.separator+ARQUIVO_XML );			
			if ( flXml.lastModified() > lModificacao ){
				lModificacao = flXml.lastModified();
				blnCarregado = false;
				System.out.println("mudou  xml"+flXml.getAbsolutePath());
			}
			
			if (!blnCarregado){
				System.out.println("carregando xml");
				try{       	       		 	
					XMLDecoder xdec = new XMLDecoder( new FileInputStream(flXml) );
					DBSettings blp = (DBSettings) xdec.readObject();
					
					strStaticConnectionString = blp.getXmlConnectionString();
					strStaticHostName = blp.getXmlHostName();
					strStaticDBName = blp.getXmlDBName();
					strStaticUserName = blp.getXmlUserName();
					strStaticPassword = blp.getXmlPassword();
					strStaticJDBCClass = blp.getXmlJDBCClass();
					iStaticTipoBanco = blp.getXmlTipoBanco();
					strStaticDBBackupPath = blp.getXmlDBBackupPath();
					strStaticPathPGDump = blp.getXmlPathPGDump();
					blnStaticPassaConexao = blp.getXmlPassaConexao();
					blnStaticForcaNovaConexao =  blp.getXmlForcaNovaConexao();
					
					blnCarregado = true;
				}catch (Exception e) {
					e.printStackTrace();
				}	
			}        
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	public static String getConnectionString()
	{ 
		return strStaticConnectionString;
		/*MSSQL*/ 	 // return  "jdbc:microsoft:sqlserver://localhost;DatabaseName=dev;SelectMethod=cursor"; 
		/*mysql*/ 	 // return  "jdbc:mysql://localhost/erp";
		/*postgres*/ // return  "jdbc:postgresql://localhost/botucarai?charSet=LATIN1";
		/*ODBC*/ 	 // return  "jdbc:odbc:botucarai";
		/*JTDS*/ 	 // return  "jdbc:jtds:sqlserver://192.168.0.15/erp;useCursors=true;namedPipe=false";
	}
	
	public static String getUserName()
	{
		return strStaticUserName;
		// return  "postgres";
		// return "virtuallis";
		// return "sa";
	}
	
	public static String getPassword()
	{
		return strStaticPassword;
		// return "abs_msde@15";
		// return "";
		//return "affsd";
	}
	public static String getJDBCClass()
	{
		return strStaticJDBCClass;
		
		/*mysql*/     // return "com.mysql.jdbc.Driver";
		/*postgres*/  // return "org.postgresql.Driver";
		/*ODBC*/      // return "sun.jdbc.odbc.JdbcOdbcDriver";
		/*MSSQL*/     //  return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		/*JTDS*/       // return  "net.sourceforge.jtds.jdbc.Driver";
	}
	
	public static String getDBName(){
		return strStaticDBName;    	
		// return "botucarai";
	}
	
	public static String getDBBackupPath(){
		return strStaticDBBackupPath;
		//        return "c:\\temp\\";
	}
	
    public static String getPathPGDump() {
        return strStaticPathPGDump;
        //        return "c:\\temp\\";
    }

	public static boolean passaConexao(){
		return blnStaticPassaConexao;
		//  	return true;
	}
	
	public static boolean forcaNovaConexao(){
		return false;
		//    	return false;
	}
	
	public static int getTipoBanco()
	{
		return iStaticTipoBanco;
		// return TIPO_MSDE;
		// return TIPO_POSTGRES;
	}
	
	
	public static String getDelimitadorTipo(String tipo, String delimitadorChar, String escapeChar )
	{ 
		if (	tipo.equalsIgnoreCase("java.lang.Character") ||
				tipo.equalsIgnoreCase("java.lang.String")    ||
				tipo.equalsIgnoreCase("java.util.Date")      ){
			if ( delimitadorChar.equals("'") ){
				return escapeChar+"'";
			}else{
				return "'";        	
			}
		}
		return "";
		
	}
	
	public static String getDelimitadorTipo(int tipo){
	
		String delimitador="";
	    if (tipo==Types.CHAR || 
	    		tipo==Types.VARCHAR || 
				tipo==Types.DATE || 
				tipo==Types.TIMESTAMP || 
				tipo==Types.TIME || 
				tipo==Types.OTHER ||
				tipo==-9 ||
				tipo==-8 ||
				tipo==-9){
	        	
	        	delimitador="'";
	        }else{
	        	delimitador="";
	        }
	    return delimitador;
	}
	
	public static String getDelimitadorTipo(String tipo,  String delimitadorChar )
	{
		return getDelimitadorTipo( tipo, delimitadorChar, "" );
	}
	
	public static String getDelimitadorTipo(String tipo )
	{
		return getDelimitadorTipo( tipo, "'" );
	}
	
	
	public static String getStringConcat()
	{
		if ( getTipoBanco() == TIPO_MSDE ){
			return "+";	
		}else {
			return "||";	
		}
	}
	
	public static String getFormatoData()
	{
		switch (getTipoBanco()) {
		case TIPO_MSDE:     return "yyyyMMdd HH:mm:ss";	
		case TIPO_POSTGRES: return "yyyy-MM-dd HH:mm:ss";	
		case TIPO_MYSQL:    return "yyyyMMddHHmmss";	
		default: return "dd/MM/yyyy hh:mm:ss";
		}
	}
	
	public static String getFormatoDataSimples()
	{
		switch (getTipoBanco()) {
		case TIPO_MSDE:     return "yyyyMMdd";	
		case TIPO_POSTGRES: return "yyyy-MM-dd";	
		case TIPO_MYSQL:    return "yyyyMMdd";	
		default: return "dd/MM/yyyy";
		}
	}
	
	
	
	public static String getLike()
	{
		switch (getTipoBanco()) {
		case TIPO_MSDE:     return "like"; 
		case TIPO_POSTGRES: return "ilike"; 
		case TIPO_MYSQL:    return "like"; 
		default: return "like";
		}
	}
	
	public static String trataLike(String sql){
		sql +=" ";
		String retorno="";
		String tokens[];
		String auxToken="";
		
		tokens = sql.split("'");
		
		for (int i=0;i<tokens.length;i++){
			auxToken=tokens[i];
			if (i%2==0){    			
				auxToken=auxToken.replaceAll(" like ", " " + getLike() + " ");
				auxToken=auxToken.replaceAll(" like\n", " " + getLike() + " ");
				auxToken=auxToken.replaceAll("\nlike ", " " + getLike() + " ");
				auxToken=auxToken.replaceAll(" LIKE ", " " + getLike() + " ");
				auxToken=auxToken.replaceAll(" LIKE\n", " " + getLike() + " ");
				auxToken=auxToken.replaceAll("\nLIKE ", " " + getLike() + " ");				
			}
			retorno += auxToken;
			
			if (i<tokens.length-1){
				retorno += "'";
			}
		}
		
		return retorno;
	}

	private static HashMap poolConexoes;
	public static void closeConexao(String id) {
		HashMap poolConexoesPropriedades = (HashMap) poolConexoes.get(id);
		Connection conexao = (Connection) poolConexoesPropriedades.get("conexao");
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%iniciou   conexao.close()...");
			

			conexao.close();
			
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%terminou   conexao.close()...");
			poolConexoes.remove(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static HashMap getPoolConexoes() {
		for (Iterator iterator = poolConexoes.keySet().iterator();iterator.hasNext(); ) {
			String id = (String) iterator.next();
			HashMap poolConexoesPropriedades = (HashMap) poolConexoes.get(id);
			Connection conexao = (Connection) poolConexoesPropriedades.get("conexao");
			try {
				if (conexao.isClosed()) {
					poolConexoes.remove(id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poolConexoes;
	}
	
	public static void controlConexao( Connection conexao, long seq_relatorio, String titulo_relatorio, long cod_usuario, String nome_usuario ){
        if (poolConexoes == null) {
        	poolConexoes = new HashMap();
        }
        
		HashMap poolConexoesPropriedades = new HashMap();
		poolConexoesPropriedades.put("conexao", conexao);
		poolConexoesPropriedades.put("seq_relatorio", seq_relatorio+"");
		poolConexoesPropriedades.put("titulo_relatorio", titulo_relatorio+"");
		poolConexoesPropriedades.put("cod_usuario", cod_usuario+"");
		poolConexoesPropriedades.put("nome_usuario", nome_usuario);
			
		poolConexoes.put(conexao.toString(), poolConexoesPropriedades);
        
        
        /*if ( fecharConexao ) {
        	Connection conexaoImpertinente = (Connection) poolConexoes.get( conexao.toString() );
        	poolConexoes.remove( conexao.toString() );
        	try {
				conexaoImpertinente.close();
			} catch (SQLException e) {
				poolConexoes.put(conexao.toString(), conexaoImpertinente);
				e.printStackTrace();
			}
        }
        */
	}

    
 

	
	public static String getDBGConnectionID() {
		return strDBGConnectionID;
	}
	public static void setDBGConnectionID(String strDBGConnectionID) {
		DBSettings.strDBGConnectionID = strDBGConnectionID;
	}
	
	/**
	 *Metodo que testa o tipo de exception do banco de dados para tentar segmentar as mensagens em
	 *categorias distintas, por exemplo, definir se a mensagem é de Violação de PK ou de Violação de FK
	 *pois todas retornam SQLException 
	 *
	 *Usa o grupo de Constantes declaradas iniciando com SQLEXCEPTION
	 */
	public static int testaSQLException(Exception e){
		int retorno = SQLEXCEPTIONDesconhecido;
		
		if (getTipoBanco()==TIPO_MSDE){
			if (e.getMessage().matches(".*Violation of PRIMARY KEY constraint .* Cannot insert duplicate key in object .*")){
				retorno=SQLEXCEPTIONViolacaoPK;
				
			}
		}else if (getTipoBanco()==TIPO_POSTGRES){
			
		}
			
		System.out.println("Ex Tipo = " + retorno);
		
		return retorno;
	}
	
	/**
	 * 
	 * @return retorna o trecho SQL para formatar uma coluna 
	 */
	public static String sqlTiraHora(String campo){
		String retorno="";
		System.out.println("\n\ngetTipoBanco() "+getTipoBanco());
		
		if (getTipoBanco()==TIPO_MSDE){
			retorno="cast(convert(varchar(10), " + campo + ", 120) as datetime)";
		}else{
			retorno="cast(cast(" + campo + " as varchar(10)) as timestamp)";
		}
		
		return retorno;
	}
	
	public static String getTopSQL(long tamanho, byte posicao){
		if (tamanho > 0){
			if ( posicao == TOP_BAIXO && (getTipoBanco() == DBSettings.TIPO_MYSQL || getTipoBanco() == DBSettings.TIPO_POSTGRES)){
				return " LIMIT " + tamanho;
			}else{
				if ( posicao == TOP_CIMA && (getTipoBanco() == DBSettings.TIPO_MSDE)){
					return " TOP  " + tamanho;
				}else{
					return "";
				}
			}		
		}else{
			return "";
		}

	}
	
}
