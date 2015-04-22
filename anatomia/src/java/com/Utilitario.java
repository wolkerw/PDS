package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.text.MaskFormatter;

import com.funcoes.Conversao;
import com.funcoes.Data;
import com.funcoes.Formatacao;


public final class Utilitario{
	private static String strFormatoDecimal  = "#,##0.00";
	private static String strFormatoData     = "dd/MM/yyyy";
	private static String strFormatoDataHora = "dd/MM/yyyy hh:mm:ss";  
	private static char   chrCasePadrao        = 'U';
	
	public static final String[] MESES = new String[] {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
	public static final String[] DIASSEMANA = new String[] {"", "Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado"};
	
	public static final int ALINHA_ESQUERDA = 0;
	public static final int ALINHA_CENTRO = 1;
	public static final int ALINHA_DIREITA = 2;
	  

	public  Utilitario(){
	    super();
	}
	
	
	public static String formataNumero(Object valor,int decimais, int inteiros){
		return Formatacao.formataNumero(valor, decimais, inteiros);
	}
	
	public static String formataNumero(Object valor,int decimais, int inteiros, String alternativa){
		return Formatacao.formataNumero(valor, decimais, inteiros, alternativa);
	}
	
	public static String formataNumero(double valor,int decimais, int inteiros){
		return Formatacao.formataNumero(new Double(valor), decimais, inteiros);
	}
	
	public static String formataNumero(double valor,int decimais, int inteiros, String alternativa){
		return Formatacao.formataNumero(new Double(valor), decimais, inteiros, alternativa);
	}

	public static String urlDecode(String inStr){
		int i;
		String outStr;
		String aChar;
		outStr=" "; 
		
		for (i=0;(i<inStr.length());i++){
			
			if (inStr.length()>=(i+3)){
				aChar=inStr.substring(i, i+3);    
			}else{
				if (inStr.length()>=(i+2)){
					aChar=inStr.substring(i, i+2);    
				}else{
					aChar=inStr.substring(i, i+1);    
				}
			}
			
			if(aChar.substring(0,1).compareTo("+")==0){
				aChar="+";
			}else{
				if(aChar.substring(0,1).compareTo("%")!=0){
					aChar=aChar.substring(0,1);
				}	    		
			}
			
			if (aChar.compareTo("%25")==0){
				outStr += "%";
				i+=2;
			} else if (aChar.compareTo("%2C")==0){
				outStr += ",";
				i+=2;
			} else if (aChar.compareTo("%2E")==0){
				outStr += ".";
				i+=2;
			} else if (aChar.compareTo("%2F")==0){
				outStr += "/";
				i+=2;
			} else if (aChar.compareTo("%3A")==0){
				outStr += ":";
				i+=2;
			} else if (aChar.compareTo("%7E")==0){
				outStr += "~";
				i+=2;
			} else if (aChar.compareTo("%21")==0){
				outStr += "!";
				i+=2;
			} else if (aChar.compareTo("%22")==0){
				outStr += "\"";
				i+=2;
			} else if (aChar.compareTo("%23")==0){
				outStr += "#";
				i+=2;
			} else if (aChar.compareTo("%24")==0){
				outStr += "$";
				i+=2;
			} else if (aChar.compareTo("%27")==0){
				outStr += "'";
				i+=2;
			} else if (aChar.compareTo("%60")==0){
				outStr += "`";
				i+=2;
			} else if (aChar.compareTo("%5E")==0){
				outStr += "^";
				i+=2;
			} else if (aChar.compareTo("%5F")==0){
				outStr += "_";
				i+=2;
			} else if (aChar.compareTo("%26")==0){
				outStr += "&amp;";
				i+=2;
			} else if (aChar.compareTo("%28")==0){
				outStr += "(";
				i+=2;
			} else if (aChar.compareTo("%29")==0){
				outStr += ")";
				i+=2;
			} else if (aChar.compareTo("%2B")==0){
				outStr += "+";
				i+=2;
			} else if (aChar.compareTo("%7B")==0){
				outStr += "{";
				i+=2;
			} else if (aChar.compareTo("%7C")==0){
				outStr += "|";
				i+=2;
			} else if (aChar.compareTo("%7D")==0){
				outStr += "}";
				i+=2;
			} else if (aChar.compareTo("%3B")==0){
				outStr += ";";
				i+=2;
			} else if (aChar.compareTo("%3C")==0){
				outStr += "&lt;";
				i+=2;
			} else if (aChar.compareTo("%3D")==0){
				outStr += "=";
				i+=2;
			} else if (aChar.compareTo("%3E")==0){
				outStr += "&gt;";
				i+=2;
			} else if (aChar.compareTo("%3F")==0){
				outStr += "?";
				i+=2;
			} else if (aChar.compareTo("%5B")==0){
				outStr += "[";
				i+=2;
			} else if (aChar.compareTo("%5C")==0){
				outStr += "\\";
				i+=2;
			} else if (aChar.compareTo("%5D")==0){
				outStr += "]";
				i+=2;
			} else if (aChar.compareTo("+")==0){
				outStr += " ";
			} else {
				outStr += aChar;
			}
		}
		return outStr.substring(1, outStr.length());
	}
	
	public static String urlEncode(String inStr){
		int i;
		String outStr;
		String aChar;
		outStr=" "; 
		inStr = ( inStr == null ? "" : inStr );
		
		for (i=0;(i<inStr.length());i++){
			aChar=inStr.substring(i, i+1);    
			if (aChar.compareTo("%")==0){
				outStr += "%25";
			} else if (aChar.compareTo(",")==0){
				outStr += "%2C";
			} else if (aChar.compareTo(".")==0){
				outStr += "%2E";
			} else if (aChar.compareTo("/")==0){
				outStr += "%2F";
			} else if (aChar.compareTo(":")==0){
				outStr += "%3A";
			} else if (aChar.compareTo("~")==0){
				outStr += "%7E";
			} else if (aChar.compareTo("!")==0){
				outStr += "%21";
			} else if (aChar.compareTo("\"")==0){
				outStr += "%22";
			} else if (aChar.compareTo("#")==0){
				outStr += "%23";
			} else if (aChar.compareTo("$")==0){
				outStr += "%24";
			} else if (aChar.compareTo("'")==0){
				outStr += "%27";
			} else if (aChar.compareTo("`")==0){
				outStr += "%60";
			} else if (aChar.compareTo("^")==0){
				outStr += "%5E";
			} else if (aChar.compareTo("_")==0){
				outStr += "%5F";
			} else if (aChar.compareTo("&amp;")==0){
				outStr += "%26";
			} else if (aChar.compareTo("(")==0){
				outStr += "%28";
			} else if (aChar.compareTo(")")==0){
				outStr += "%29";
			} else if (aChar.compareTo("+")==0){
				outStr += "%2B";
			} else if (aChar.compareTo("{")==0){
				outStr += "%7B";
			} else if (aChar.compareTo("|")==0){
				outStr += "%7C";
			} else if (aChar.compareTo("}")==0){
				outStr += "%7D";
			} else if (aChar.compareTo(";")==0){
				outStr += "%3B";
			} else if (aChar.compareTo("&lt;")==0){
				outStr += "%3C";
			} else if (aChar.compareTo("=")==0){
				outStr += "%3D";
			} else if (aChar.compareTo("&gt;")==0){
				outStr += "%3E";
			} else if (aChar.compareTo("?")==0){
				outStr += "%3F";
			} else if (aChar.compareTo("[")==0){
				outStr += "%5B";
			} else if (aChar.compareTo("\\")==0){
				outStr += "%5C";
			} else if (aChar.compareTo("]")==0){
				outStr += "%5D";
			} else if (aChar.compareTo(" ")==0){
				outStr += "+";
			} else if (aChar.compareTo("&")==0) {
			    outStr += "%26";
			} else {
				outStr += aChar;
			}
		}
		return outStr.substring(1, outStr.length());
	}
	
	public static String format(String mascara, char placeHolder, Object value) throws Exception {
        MaskFormatter formatter = new MaskFormatter(mascara);
        formatter.setPlaceholderCharacter(placeHolder);
        formatter.setValueContainsLiteralCharacters(false);
        return formatter.valueToString(value);
    }

    public static String dateToStrSQL(java.util.Date data) {
        return Conversao.dateToStrSQL(data);
    }

    public static String dateToStrSQLDataSimples(java.util.Date data) {
        return Conversao.dateToStrSQLDataSimples(data);
    }

    public String dateToStrOut(java.util.Date data) {
        try{
            return (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data));
        } catch (NullPointerException npe){
            return ("");
        } catch (Exception a){
            System.out.println("ERRO CONVERTENDO DATA");
            a.printStackTrace();
            return ("ERRO");
        }
        
    }

    public java.util.Date strToDate(String valor){
        return Conversao.strToDate(valor);
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
        return isNull(valor,"");
    }  

    public static Object isNullSt(Object valor, Object alternativo){
        if (valor!=null){
            return valor;
        } else {
            return alternativo;
        }
    }     
    
    public Object isNull(Object valor, Object alternativo){
        if (valor!=null){
            return valor;
        } else {
            return alternativo;
        }
    }      
    
    public String getSubString(String texto, 
    						   int beginIndex,
                               int endIndex){
    	if (texto.length()<beginIndex){
    		return "";
    	} else {
    		if (texto.length()<endIndex){
    			endIndex=texto.length();
    		}
    		return texto.substring(beginIndex,endIndex);
    	}
    }
    public String breakLineHTML(String texto){
    	
        return texto.replaceAll("\n","<br>");
    }

    public String strJSEncode(String texto){
          //codifica texto para output
          String retorno;
          if (texto==null){
               retorno = null;
          }else{
               retorno = texto.replaceAll("\'","\\\\'");
               retorno = retorno.replaceAll("\"","\\\\\"") ;
               retorno = retorno.replaceAll(""+(char)13,"") ;
               retorno = retorno.replaceAll(""+(char)10,"\\\\n") ;
               
               //System.out.println(retorno);
          }
          
          return retorno;
    }
    
    public static String tiraAcentos(String valor){
    	return Formatacao.tiraAcentos(valor);
    }

    
    /**
     * @param preenhimento E - espacos  Z - Zeros 
     * @param tipo A - Alfanumerico N - Numerico D - Data
     * @param mascara Mascara de formatacao (0.00, dd/MM/yyyyy, etc)
     * @param exibeFormatacao S - Sim N - Não
     * @param tamanho Tamanho do campo
     * @param alinhamento E - Esquerda D- Direita
     * @param valor String a formatar
     */
    public static String getStringFormatada( 	char preenhimento, 
			char tipo, 
			String mascara,
			char exibeFormatacao, 
			int tamanho, 
			char alinhamento, 
			String valor
	) throws Exception{
		return getStringFormatada( 	preenhimento, 
				tipo, 
				mascara,
				exibeFormatacao, 
				tamanho, 
				alinhamento, 
				valor,
				true
		);
	}
	
	
    /**
     * @param preenhimento E - espacos  Z - Zeros 
     * @param tipo A - Alfanumerico N - Numerico D - Data
     * @param mascara Mascara de formatacao (0.00, dd/MM/yyyyy, etc) 
     * @param exibeFormatacao S - Sim N - Não
     * @param tamanho Tamanho do campo
     * @param alinhamento E - Esquerda D- Direita
     * @param valor String a formatar
     * @param verificarValores true ou false Exception se o formato nao for valido   
     */
	public static String getStringFormatada( 	char preenhimento, 
			char tipo, 
			String mascara,
			char exibeFormatacao, 
			int tamanho, 
			char alinhamento, 
			String valor,
			boolean verificarValores ) throws Exception{
		char charPreenchimento;
		String pRetorno = valor; 
		
		if (preenhimento == 'E')			
			charPreenchimento = ' '; 
		else
			charPreenchimento = '0';
		
		if (tipo == 'N'){
			// Verifica se eh numerico
			try{
				pRetorno=(pRetorno.trim().equals("")?"0":pRetorno);
				(new DecimalFormat()).parse(pRetorno.replaceAll("\\D",""));											
			}catch (Exception e) {
				if (verificarValores){
					throw e;
				}else{
					// Muda o tipo para ALFA e tira a mascara
					tipo = 'A';
					mascara = "";
				}
			}	
		}else
			if(tipo == 'D'){
				// Verifica se eh tipo date/time
				
				Utilitario util = new Utilitario();
				if (util.strToDate((String) pRetorno)==null){	
					if (verificarValores){
						throw (new Exception("Data/hora inválida")); 
					}else{
						// Muda o tipo para ALFA e tira a mascara
						tipo = 'A';
						mascara = "";
					}
				}
			}
			
			
		if(		(mascara != null    ) 
				&& (!mascara.trim().equals(""))){
			switch (tipo) {
			case 'D': Utilitario util = new Utilitario();								
			pRetorno = new SimpleDateFormat(mascara).format(util.strToDate((String) pRetorno));				
			break;
			case 'N': pRetorno = new DecimalFormat(mascara).format(new Double(pRetorno).doubleValue());			          
			break;
			default:  pRetorno = Utilitario.format( mascara,
					charPreenchimento,
					pRetorno );
			break;
			}
		}
		
		if ((exibeFormatacao == 'N')&&(tipo!='A')){
			pRetorno = pRetorno.replaceAll("\\D","");								
		}	
		
		if (tamanho < pRetorno.length()){
			// Truncar string
			pRetorno = pRetorno.substring(0,tamanho);
		}
		else{
			for(int i=pRetorno.length(); tamanho>i;i++){
				if(alinhamento == 'E') 
					pRetorno = pRetorno + charPreenchimento;
				else
					pRetorno = charPreenchimento + pRetorno;
			}
		}												
		
		return pRetorno;
	}

	public static String ordinalExtenso(int n, String genero) {
		
		String[] unidades_ordinalGM = { "", "primeiro", "segundo", "terceiro", "quarto", "quinto", "sexto", "sétimo", "oitavo", "nono" };
		String[] dezenas_ordinalGM = { "", "décimo", "vigésimo", "trigésimo", "quadragésimo", "quintuagésimo", "sexagésimo", "septuagésimo", "octogésimo", "nonagésimo" };
		String[] centenas_ordinalGM = { "", "centésimo", "ducentésimo", "trecentésimo", "quadringentésimo", "qüingencentésimo", "sexcentésimo", "septingentésimo", "octingentésimo", "noningentésimo" };

		String[] unidades_ordinalGF = { "", "primeira", "segunda", "terceira", "quarta", "quinta", "sexta", "sétima", "aitava", "nona" };
		String[] dezenas_ordinalGF = { "", "décima", "vigésima", "trigésima", "quadragésima", "quinquagésima", "sexagésima", "septuagésima", "octogésima", "nonagésima" };
		String[] centenas_ordinalGF = { "", "centésima", "ducentésima", "trecentésima", "quadringentésima", "qüingencentésima", "sexcentésima", "septingentésima", "octingentésima", "noningentésima" };
		
		String ord = "";
		String[] unidades_ordinal = { "" };
		String[] dezenas_ordinal = { "" };
		String[] centenas_ordinal = { "" };

		if (genero.equalsIgnoreCase("M")){
			unidades_ordinal = unidades_ordinalGM;
			dezenas_ordinal = dezenas_ordinalGM;
			centenas_ordinal = centenas_ordinalGM;
		} else if(genero.equalsIgnoreCase("F")) {
			unidades_ordinal = unidades_ordinalGF;
			dezenas_ordinal = dezenas_ordinalGF;
			centenas_ordinal = centenas_ordinalGF;
		}
		
		int u, d, c;
	
		// x E [0,9] ?
		if(n < 10) {
			u = n;
			ord = unidades_ordinal[u];
		}
		// x E [10,99] ?
		else if(n < 100) {
			d = (int) Math.floor(n / 10);
			u = n - (d * 10);
			if(u == 0) {
				ord = dezenas_ordinal[d];
			}
			else {
				ord = dezenas_ordinal[d] + " " + unidades_ordinal[u];
			}
		} else {
			c = (int) Math.floor(n / 100);
			d = (int) Math.floor((n - c * 100) / 10);
			u = n - (c * 100) - (d * 10);
			if(u == 0) {
				if(d == 0) {
					ord = centenas_ordinal[c];
				} else {
					ord = centenas_ordinal[c] + " " + dezenas_ordinal[d];
				}
			}
			else if(d == 0) {
				ord = centenas_ordinal[c] + " " + unidades_ordinal[u];
			} else {
				ord = centenas_ordinal[c] + " " + dezenas_ordinal[d] + " " + unidades_ordinal[u];
			}
		}
	
		return ord;
	}

	
	public static String getNumeroExtenso(double valor) {
	    return getNumeroExtenso(valor, false);
	}
	
	public static String getNumeroExtenso(double valor, boolean blnAcentos) {
		ArrayList nro = new ArrayList();
		StringBuffer buf = new StringBuffer();
		BigDecimal dec = new BigDecimal(valor);
		
		int ct;
		
		String Qualificadores[][] = {
				{"centavo", "centavos"},
				{"", ""},
				{"mil", "mil"},
				{"milhão", "milhões"},
				{"bilhão", "bilhões"},
				{"trilhão", "trilhões"},
				{"quatrilhão", "quatrilhões"},
				{"quintilhão", "quintilhões"},
				{"sextilhão", "sextilhões"},
				{"septilhão", "septilhões"}
		};
		String Numeros[][] = {
				{"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez",
					"onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"},
					{"vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"},
					{"cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos",
						"setecentos", "oitocentos", "novecentos"}
		};
		
		//******************************* Set number ******************************
		// Converte para inteiro arredondando os centavos
		BigInteger num = dec.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)).toBigInteger();
		
		// Adiciona valores
		nro.clear();
		if (num.equals(BigInteger.ZERO)) {
			// Centavos
			nro.add(new Integer(0));
			// Valor
			nro.add(new Integer(0));
		}else {
			BigInteger[] newNum;
			// Adiciona centavos
			//addRemainder(100);
			// Encontra newNum[0] = num modulo divisor, newNum[1] = num dividido divisor
			newNum = num.divideAndRemainder(BigInteger.valueOf(100));
			
			// Adiciona modulo
			nro.add(new Integer(newNum[1].intValue()));
			
			// Altera numero
			num = newNum[0];
			
			// Adiciona grupos de 1000
			while (!num.equals(BigInteger.ZERO)) {
				newNum = num.divideAndRemainder(BigInteger.valueOf(1000));
				nro.add(new Integer(newNum[1].intValue()));
				num = newNum[0];
			}
		}
		
		
		int numero = ((Integer) nro.get(0)).intValue();
		
		for (ct = nro.size() - 1; ct > 0; ct--) {
			// Se ja existe texto e o atual não é zero
			
			boolean  ehGrupoZero = false;       //ct
			if (ct <= 0 || ct >= nro.size())
				ehGrupoZero = true;
			else
				ehGrupoZero =  ((Integer)nro.get(ct)).intValue() == 0;
			
			if (buf.length() > 0 && ! ehGrupoZero) {
				buf.append(" e ");
			}
			
			// Num to string			
			StringBuffer numtostrbuf = new StringBuffer();
			{
				int ntsnumero  = ((Integer) nro.get(ct)).intValue();
				int escala  = ct;
				int unidade = (ntsnumero % 10);
				int dezena = (ntsnumero % 100); //* nao pode dividir por 10 pois verifica de 0..19
				int centena = (ntsnumero / 100);
				
				
				if (ntsnumero != 0) {
					if (centena != 0) {
						if (dezena == 0 && centena == 1) {
							numtostrbuf.append(Numeros[2][0]);
						}else{
							numtostrbuf.append(Numeros[2][centena]);
						}
					}
					
					if ((numtostrbuf.length() > 0) && (dezena != 0)) {
						numtostrbuf.append(" e ");
					}
					if (dezena > 19) {
						dezena /= 10;
						numtostrbuf.append(Numeros[1][dezena - 2]);
						if (unidade != 0) {
							numtostrbuf.append(" e ");
							numtostrbuf.append(Numeros[0][unidade]);
						}
					}
					else if (centena == 0 || dezena != 0) {
						numtostrbuf.append(Numeros[0][dezena]);
					}
					
					numtostrbuf.append(" ");
					if (ntsnumero == 1) {
						numtostrbuf.append(Qualificadores[escala][0]);
					}
					else {
						numtostrbuf.append(Qualificadores[escala][1]);
					}
				}
			}
			
			buf.append(numtostrbuf);
		}
		
		if (buf.length() > 0) {
			boolean ehUnicoGrupo = true;
			{
				if (nro.size() <= 3){
					ehUnicoGrupo = false;
				}else{
					boolean ehGrupoZero1 = false;
					if (1 >= nro.size())
						ehGrupoZero1 =  true;
					else
						ehGrupoZero1 =  ((Integer)nro.get(1)).intValue() == 0;
					
					boolean ehGrupoZero2 = false;
					if (2 >= nro.size())
						ehGrupoZero2 =  true;
					else
						ehGrupoZero2 =  ((Integer)nro.get(2)).intValue() == 0;
					
					if (!ehGrupoZero1 && !ehGrupoZero2){
						ehUnicoGrupo = false;
					}else{
						boolean hasOne = false;
						for(int i=3; i < nro.size(); i++) {
							if (((Integer)nro.get(i)).intValue() != 0) {
								if (hasOne){
									ehUnicoGrupo = false;
									break;
								}
								hasOne = true;
							}
						}
					}
				}
			}
			
			if (ehUnicoGrupo)
				buf.append(" de ");
			while (buf.toString().endsWith(" "))
				buf.setLength(buf.length()-1);
			if (((Integer)nro.get(nro.size()-1)).intValue() == 1)
				buf.insert(0, "h");
			if (nro.size() == 2 && ((Integer)nro.get(1)).intValue() == 1) {
				buf.append(" real");
			} else {
				buf.append(" reais");
			}
			if (((Integer) nro.get(0)).intValue() != 0) {
				buf.append(" e ");
			}
		}
		
		if (((Integer) nro.get(0)).intValue() != 0) {
			// Num to string		
			StringBuffer numtostrbuf = new StringBuffer();
			{
				int ntsnumero  = ((Integer) nro.get(0)).intValue();
				int escala  = 0;
				int unidade = (ntsnumero % 10);
				int dezena = (ntsnumero % 100); //* nao pode dividir por 10 pois verifica de 0..19
				int centena = (ntsnumero / 100);
				
				
				if (ntsnumero != 0) {
					if (centena != 0) {
						if (dezena == 0 && centena == 1) {
							numtostrbuf.append(Numeros[2][0]);
						}else{
							numtostrbuf.append(Numeros[2][centena]);
						}
					}
					
					if ((numtostrbuf.length() > 0) && (dezena != 0)) {
						numtostrbuf.append(" e ");
					}
					if (dezena > 19) {
						dezena /= 10;
						numtostrbuf.append(Numeros[1][dezena - 2]);
						if (unidade != 0) {
							numtostrbuf.append(" e ");
							numtostrbuf.append(Numeros[0][unidade]);
						}
					}
					else if (centena == 0 || dezena != 0) {
						numtostrbuf.append(Numeros[0][dezena]);
					}
					
					numtostrbuf.append(" ");
					if (ntsnumero == 1) {
						numtostrbuf.append(Qualificadores[escala][0]);
					}
					else {
						numtostrbuf.append(Qualificadores[escala][1]);
					}
				}
			}
			
			buf.append(numtostrbuf);
		}
		if (blnAcentos){
			return buf.toString();		
		}else{		    
			return Utilitario.tiraAcentos( buf.toString().toLowerCase() );
		}
	}
	
	
	public static String getNumeroInteiroExtenso(int valor, boolean blnAcentos) {
		ArrayList nro = new ArrayList();
		StringBuffer buf = new StringBuffer();
	
		int ct;
		
		String Qualificadores[][] = {
				{"", ""},
				{"", ""},
				{"mil", "mil"},
				{"milhão", "milhões"},
				{"bilhão", "bilhões"},
				{"trilhão", "trilhões"},
				{"quatrilhão", "quatrilhões"},
				{"quintilhão", "quintilhões"},
				{"sextilhão", "sextilhões"},
				{"septilhão", "septilhões"}
		};
		String Numeros[][] = {
				{"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez",
					"onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"},
					{"vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"},
					{"cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos",
						"setecentos", "oitocentos", "novecentos"}
		};
				
		
		if (valor == 0) {
			nro.add(new Integer(0));

			nro.add(new Integer(0));
		}else {
			nro.add(new Integer(0));

			// Divide em grupos de mil
			while (valor != 0 ) {
				int valInt = new BigDecimal(valor / 1000).setScale(0,BigDecimal.ROUND_DOWN).intValue();
				int valDec = valor - (valInt  * 1000);
				
				nro.add(new Integer(valDec));
				valor = valInt;
			}
		}
		
		for (ct = nro.size() - 1; ct > 0; ct--) {
			// Se ja existe texto e o atual não é zero
			
			boolean  ehGrupoZero = false;       //ct
			if (ct <= 0 || ct >= nro.size())
				ehGrupoZero = true;
			else
				ehGrupoZero =  ((Integer)nro.get(ct)).intValue() == 0;
			
			if (buf.length() > 0 && ! ehGrupoZero) {
				buf.append(" e ");
			}
			
			// Num to string			
			StringBuffer numtostrbuf = new StringBuffer();
			{
				int ntsnumero  = ((Integer) nro.get(ct)).intValue();
				int escala  = ct;
				int unidade = (ntsnumero % 10);
				int dezena = (ntsnumero % 100); //* nao pode dividir por 10 pois verifica de 0..19
				int centena = (ntsnumero / 100);
				
				
				if (ntsnumero != 0) {
					if (centena != 0) {
						if (dezena == 0 && centena == 1) {
							numtostrbuf.append(Numeros[2][0]);
						}else{
							numtostrbuf.append(Numeros[2][centena]);
						}
					}
					
					if ((numtostrbuf.length() > 0) && (dezena != 0)) {
						numtostrbuf.append(" e ");
					}
					if (dezena > 19) {
						dezena /= 10;
						numtostrbuf.append(Numeros[1][dezena - 2]);
						if (unidade != 0) {
							numtostrbuf.append(" e ");
							numtostrbuf.append(Numeros[0][unidade]);
						}
					}
					else if (centena == 0 || dezena != 0) {
						numtostrbuf.append(Numeros[0][dezena]);
					}
					
					numtostrbuf.append(" ");
					if (ntsnumero == 1) {
						numtostrbuf.append(Qualificadores[escala][0]);
					}
					else {
						numtostrbuf.append(Qualificadores[escala][1]);
					}
				}
			}
			
			buf.append(numtostrbuf);
		}
		
		if (buf.length() > 0) {
			boolean ehUnicoGrupo = true;
			{
				if (nro.size() <= 3){
					ehUnicoGrupo = false;
				}else{
					boolean ehGrupoZero1 = false;
					if (1 >= nro.size())
						ehGrupoZero1 =  true;
					else
						ehGrupoZero1 =  ((Integer)nro.get(1)).intValue() == 0;
					
					boolean ehGrupoZero2 = false;
					if (2 >= nro.size())
						ehGrupoZero2 =  true;
					else
						ehGrupoZero2 =  ((Integer)nro.get(2)).intValue() == 0;
					
					if (!ehGrupoZero1 && !ehGrupoZero2){
						ehUnicoGrupo = false;
					}else{
						boolean hasOne = false;
						for(int i=3; i < nro.size(); i++) {
							if (((Integer)nro.get(i)).intValue() != 0) {
								if (hasOne){
									ehUnicoGrupo = false;
									break;
								}
								hasOne = true;
							}
						}
					}
				}
			}
			
			if (ehUnicoGrupo)
				buf.append(" de ");
			while (buf.toString().endsWith(" "))
				buf.setLength(buf.length()-1);
			if (((Integer) nro.get(0)).intValue() != 0) {
				buf.append(" e ");
			}
		}
		
		if (((Integer) nro.get(0)).intValue() != 0) {
			// Num to string		
			StringBuffer numtostrbuf = new StringBuffer();
			{
				int ntsnumero  = ((Integer) nro.get(0)).intValue();
				int escala  = 0;
				int unidade = (ntsnumero % 10);
				int dezena = (ntsnumero % 100); //* nao pode dividir por 10 pois verifica de 0..19
				int centena = (ntsnumero / 100);
				
				
				if (ntsnumero != 0) {
					if (centena != 0) {
						if (dezena == 0 && centena == 1) {
							numtostrbuf.append(Numeros[2][0]);
						}else{
							numtostrbuf.append(Numeros[2][centena]);
						}
					}
					
					if ((numtostrbuf.length() > 0) && (dezena != 0)) {
						numtostrbuf.append(" e ");
					}
					if (dezena > 19) {
						dezena /= 10;
						numtostrbuf.append(Numeros[1][dezena - 2]);
						if (unidade != 0) {
							numtostrbuf.append(" e ");
							numtostrbuf.append(Numeros[0][unidade]);
						}
					}
					else if (centena == 0 || dezena != 0) {
						numtostrbuf.append(Numeros[0][dezena]);
					}
					
					numtostrbuf.append(" ");
					if (ntsnumero == 1) {
						numtostrbuf.append(Qualificadores[escala][0]);
					}
					else {
						numtostrbuf.append(Qualificadores[escala][1]);
					}
				}
			}
			
			buf.append(numtostrbuf);
		}
		if (blnAcentos){
			return buf.toString();		
		}else{		    
			return Utilitario.tiraAcentos( buf.toString().toLowerCase() );
		}
	}

	public static String divideString(String valor, String tamMaximo, String manterPalavras ){
		String[] arrValor = valor.replaceAll("\\r\\n","\n").split("\\n");
		String strRetorno = "";
		
		for (int indice = 0; indice < arrValor.length; indice++) {
			valor = arrValor[indice];
			
			int tMax = new Integer(tamMaximo).intValue();
			if (manterPalavras.trim().equalsIgnoreCase("true")){
				while ( valor != ""){
					String strLinha = "";
					
					if ( valor.length()>=tMax ){
						int tamanho = tMax;
						if ( valor.charAt(tamanho - 1)== ' ' ){
							strLinha = valor.substring(0, tamanho - 1);
						}else{
							boolean bAchou =  false;
							for (int i = tamanho - 1; i > 0; i-- ){
								if ( valor.charAt(i)== ' ' ){
									strLinha = valor.substring(0, i);
									tamanho = i;
									bAchou = true;
									break;
								}
							}
							if (!bAchou){
								strLinha = valor.substring(0, tamanho - 1);
							}
						}
						valor = valor.substring(tamanho).trim();
						strRetorno = strRetorno + strLinha + "\n";
					}  else {
						strLinha = valor.substring(0, valor.length());				
						valor = "";
						strRetorno = strRetorno + strLinha;			
					}
				}					
			}else{
				while ( valor != ""){
					String strLinha;
					
					if ( valor.length()>=tMax ){
						strLinha = valor.substring(0, tMax - 1);
						valor = valor.substring(tMax);
						strRetorno = strRetorno + strLinha + "\n";
					}  else {
						strLinha = valor.substring(0, valor.length());				
						valor = "";
						strRetorno = strRetorno + strLinha;			
					}							
				}		
			}
			if ( indice < ( arrValor.length - 1 ) ){
				strRetorno = strRetorno + "\n";			
			}
		}
		
		return strRetorno;
	}
	
	public static String getSeparadorLinha48(){
		return (((char)27)+"") + (((char)48)+"") ;
	}
	
	public static String getSeparadorLinha49(){
		return (((char)27)+"") + (((char)49)+"") ;
	}
	
	public static String getSeparadorLinha50(){
		return (((char)27)+"") + (((char)50)+"") ;
	}

	/**
	 * Nao funciona quando o separador decimal padrao nao for ',' e o separador de milhar '.' 
	 * @param valor
	 * @param decimais
	 * @return
	 */
	public static double arredondaNumero(Object valor,int decimais){
		
		double retorno = 0;
		
		if (valor!=null){
			NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
			nf.setMinimumFractionDigits(decimais);
			nf.setMaximumFractionDigits(decimais);
			retorno = new Double(nf.format(valor).replaceAll("[.]","").replaceAll("[,]",".")).doubleValue();
		} else {
			retorno = 0;
		}		
		
		return retorno;
	}
	
	public static java.util.Date adicionaData(java.util.Date dataBase,int parte, int incremento){
	    return Data.adicionaData(dataBase, parte, incremento);
	}
	
	public static void copiaStream(InputStream in, OutputStream out, boolean blnFecharIn, boolean blnFecharOut ) throws IOException {
		synchronized (in) {
			synchronized (out) {
				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1) break;
					out.write(buffer, 0, bytesRead);
				}
			}
		}
		if ( blnFecharIn ){
		    in.close();
		}
		if ( blnFecharOut ){
		    out.close();
		}
	}
	
	public static void copiaStream(InputStream in, OutputStream out) throws IOException {
	    copiaStream(in, out, false, false );
	}
	
	public static Double getPercentual(Double valor, Double parcial) {
	    
	    if (valor!=null && parcial!=null && valor.doubleValue()>0 && parcial.doubleValue()>0) {
	        return new Double((parcial.doubleValue()*100)/valor.doubleValue());
	    }
	    return new Double(0);
	}
	
	public static java.util.Date sqlStringToDate(String data){
		return Conversao.sqlStringToDate(data);
	}
	
	
	
	public static java.util.Date somaDatas(java.util.Date dtData, int qtdDias) {
        return Data.somaDatas(dtData, qtdDias);
    }

    public static java.util.Date getUltimoDiaMes(java.util.Date dtData) throws Exception {
        return Data.getUltimoDiaMes(dtData);
    }

    public static java.util.Date criaData(int ano, int mes, int dia) throws Exception {
        return Data.criaData(ano, mes, dia);
    }
	
	public static void imprimeArquivo( String strArquivo, String strImpressora, String strComandoImpressao ) throws Exception{
		imprimeArquivo( new File(strArquivo), strImpressora, strComandoImpressao );
	}
	
	public static void imprimeArquivo( File flArquivo, String strImpressora, String strComandoImpressao ) throws Exception{
		DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE ;
		PrintService[] pss = PrintServiceLookup.lookupPrintServices(df, null);
		
		boolean imprimiu = false;
		String strImpressoras="";
		
		System.out.println("Imprimindo em " + strImpressora + " comando " + strComandoImpressao);
		
		if (pss.length==0){
		    //System.out.println(" IMPRIMINDO A");
			Runtime.getRuntime().exec( strComandoImpressao +" "+ strImpressora +" "+flArquivo.getAbsolutePath() );
		}else{
		    //System.out.println(" IMPRIMINDO B");
			for(int i=0; i<pss.length; i++){
			    //System.out.println(" IMPRIMINDO B0 " + pss[i].getName());
			    strImpressoras+=";\n " + pss[i].getName();
				if(pss[i].getName().equalsIgnoreCase(strImpressora) ){
				    //System.out.println(" IMPRIMINDO B1 " + pss[i].getName());
					DocPrintJob dpj = pss[i].createPrintJob	();
					DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
					Doc doc = new SimpleDoc(new FileInputStream(flArquivo), flavor, null);
					
					try {
					    //System.out.println(" IMPRIMINDO B2 " + pss[i].getName());
						dpj.print(doc, null);
						imprimiu=true;
						//System.out.println(" IMPRIMINDO B3 " + pss[i].getName());
					} catch (Exception e) {
					    //System.out.println(" IMPRIMINDO B4 " + pss[i].getName());
						e.printStackTrace();
						throw e;
					}
				}
			}
			if (!imprimiu){
			    throw new Exception("Impressora [" + strImpressora + "] não encontrada. A lista de impressoras é: [" + strImpressoras + "]");
			}
		}    
	}
	
	/**
	 * Retorna a zero hora da data passada no argumento 
	 */
	public static java.util.Date retornaData( java.util.Date dtData ){
		return Data.retornaData(dtData);
	}

	

	
	public static String castHTML(Object origem){
		String retorno=""+origem; 
		
		retorno=retorno.replaceAll("\"","&quot;");
		retorno=retorno.replaceAll("<","&lt;");
		retorno=retorno.replaceAll(">","&gt;");
		retorno=retorno.replaceAll("ç","&ccedil;");
		retorno=retorno.replaceAll("\\r\\n","<br>");
		retorno=retorno.replaceAll("\\r\\r","<br>");
		retorno=retorno.replaceAll("\\n","<br>");
		return retorno;
	}

	
	public static String getSeparadorDecimal(){
		return new DecimalFormat("0.0").format(0).replaceAll("0", "");
	}

	public static Date somaPeriodo(Date data, String flag, int qnt){
		return Data.somaPeriodo(data, flag, qnt);
	}
	
	/**
	 * Preenche com espaços a direita ate o tamanho da string for igual a 'num'. Se for maior que 'num' retorna os 'num' primeiros caracteres.
	 * @param String str - string a formatar
	 * @param int num - tamanho deseja da str
	 */
	public static String fmtStringTexto(String str, int num){
		return Formatacao.fmtStringTexto(str, num);
	}
	
	public static String fmtStringTexto(String str, int num, int alinhamento){
		return Formatacao.fmtStringTexto(str, num, alinhamento);
	}
	
	/**
	 * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num', se for menor que 'num' trunca
	 * @param String str - string a formatar
	 * @param int num - tamanho deseja da str 
	 */
	public static String fmtStringNumerica(String str, int num){
		return Formatacao.fmtStringNumerica(str, num);
	}
	
	/**
	 * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num'
	 * @param int i - numero a formatar
	 * @param int num - tamanho deseja da str 
	 */
	public static String fmtStringNumerica(int i, int num){
		return Formatacao.fmtStringNumerica(i+"", num);
	}
	
	/**
	 * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num'
	 * @param int i - numero a formatar
	 * @param int num - tamanho deseja da str 
	 */
	public static String fmtStringNumerica(Integer i, int num){
		return Formatacao.fmtStringNumerica(i+"", num);
	}
	
	/**
	 * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num'
	 * @param long l - numero a formatar
	 * @param int num - tamanho deseja da str 
	 */
	public static String fmtStringNumerica(long l, int num){
		return Formatacao.fmtStringNumerica(l+"", num);
	}
	
 	/**
	 * Formata com 2 casas decimais e com zeros a esquerda ate o tamanho da string for igual a 'num'
	 * @param double str - string a formatar
	 * @param int num - tamanho deseja da str 
	 */
	public static String fmtStringNumerica(double d, int num){
		return Formatacao.fmtStringNumerica(num2strFmt(d), num);
	}
	
	/**
	 * Retorna uma string representando o double passando, com 2 casas decimais, sem separador
	 * @param d
	 * @return
	 */
	public static String num2strFmt(double d){
	    if (Utilitario.getSeparadorDecimal().equals(".")){
	        return new DecimalFormat("0.00").format(d).replaceAll("\\" + Utilitario.getSeparadorDecimal(), "");   
	    }else{
	        return new DecimalFormat("0.00").format(d).replaceAll(Utilitario.getSeparadorDecimal(), "");    
	   }
	}
	
	/**
	 * Retorna a string 'str' repetida 'num' vezes.
	 * @param str - String
	 * @param num - Int
	 */
	public static String sequencia(String str, int num){
		return Formatacao.sequencia(str, num);
	}

	/**
	 * Retorna uma string com o caracter 'ch' repetido 'num' vezes.
	 * @param str - String
	 * @param num - Int
	 */
	public static String sequencia(char ch, int num){
		return Formatacao.sequencia(ch+"", num);
	}

	/**
	 * Retorna o valor representado pela string "str".
	 * @param str
	 * @return
	 */
	public static int str2int(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Retorna o valor representado pela string "str".
	 * @param str
	 * @return
	 */
	public static double str2double(String str){
		//System.out.print("getSeparadorMilhar: "+getSeparadorMilhar() );
		//System.out.print("getSeparadorDecimal: "+getSeparadorDecimal() );
		
		//str = str.replaceAll("\\.", "");
		//str = str.replaceAll("\\,", ".");
		
		str = str.replaceAll("\\" + getSeparadorMilhar(), "");
		str = str.replaceAll("\\" + getSeparadorDecimal(), ".");
		return Double.parseDouble(str);
	}
	
	/**
	 * Retorna o valor representado pela string "str", com "n" casas decimais.
	 * @param str
	 * @param n
	 * @return
	 */
	public static double str2double(String str, int n) {
		double d = str2double(str);
		d = new BigDecimal(d).setScale(n, BigDecimal.ROUND_DOWN).doubleValue(); 
		return d;
	}
	
	public static String getSeparadorMilhar(){
		return new DecimalFormat("0,000").format(9999).replaceAll("9", "");
	}

	/**
	 * Trunca o double "d" em "n" casas decimais.
	 * @param d
	 * @param n
	 * @return
	 */
	public static double trunca(double d, int n) {
		return new BigDecimal(d).setScale(n, BigDecimal.ROUND_DOWN).doubleValue();
	}

	/**
	 * Aredonda o double "d" em "n" casas decimais.
	 * @param d
	 * @param n
	 * @return
	 */
	public static double round(double d, int n) {
		return new BigDecimal(d).setScale(n, BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}

	public static double round(Double dObj, int n) {
        double d = 0;

        if (dObj != null)
            d = dObj.doubleValue();

        return round(d, n);
    }

	public static ResultSet populaResultSet(String sql,Connection conexao) throws Exception{
		
		ResultSet rs=null;
		Statement statement;
		boolean conexaoNova = false;
		if (DBSettings.forcaNovaConexao()){
			try {
				Class.forName(DBSettings.getJDBCClass());
				conexao = DriverManager.getConnection(DBSettings.getConnectionString(), DBSettings.getUserName(), DBSettings.getPassword());
			} catch ( ClassNotFoundException cnfex ) {
				System.out.println("Falha ao carregar driver JDBC-ODBC.");
				throw cnfex;
			} catch ( SQLException sqlex ) {
				System.out.println("Impossivel conectar.\nVeja mensagens de erro no console.");
				throw sqlex;
			}
			conexaoNova = true;
		}else{
			if (conexao==null){
				try {
					Class.forName(DBSettings.getJDBCClass());
					conexao = DriverManager.getConnection(DBSettings.getConnectionString(), DBSettings.getUserName(), DBSettings.getPassword());
				} catch ( ClassNotFoundException cnfex ) {
					System.out.println("Falha ao carregar driver JDBC-ODBC.");
					throw cnfex;
				} catch ( SQLException sqlex ) {
					System.out.println("Impossivel conectar.\nVeja mensagens de erro no console.");
					throw sqlex;
				}
				conexaoNova = true;
			}		
		}
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery( sql );
        } catch (Exception e) {
        	if(conexaoNova){
            	conexao.close();
            }
            throw e;
        }
        if(conexaoNova){
        	conexao.close();
        }
		return rs;
	}
	

	public static  String  dataExtenso( java.util.Date dt, boolean bAno, boolean bMes, boolean bDia) {
		
		Calendar oCal = new GregorianCalendar();				 
		oCal.setTime( dt );
		
		String mes = MESES[oCal.get(Calendar.MONTH)];
				
		String dia = new DecimalFormat("00").format(oCal.get(Calendar.DAY_OF_MONTH));			          
		String ano = new DecimalFormat("0000").format(oCal.get(Calendar.YEAR));			          
		
		String strRetorno = "";
		if (bDia){
		    strRetorno = dia+"";
		}
		if (bMes){
		    if (!strRetorno.equals("")){
		        strRetorno += " DE ";
		    }
		    strRetorno += mes;
		}

		if (bAno){
		    if (!strRetorno.equals("")){
		        strRetorno += " DE ";
		    }
		    strRetorno += ano;
		}
		
		return strRetorno;
    }

/*	public static String dataExtenso(Date data){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		
		String strData = gc.get(Calendar.DAY_OF_MONTH) + " ";
		strData += "de " + MESES[gc.get(Calendar.MONTH)];
		strData += " de " + gc.get(Calendar.YEAR);
		return strData;
	} */

	public static  String  dataExtenso( java.util.Date dt ) {
	    return dataExtenso(dt, true, true, true);
	}
	
	public static  String  dataExtenso( java.util.Date dt, boolean bAno) {
	    return dataExtenso(dt, bAno, true, true);
    }

	public static String dataExtensoDiaSemana (java.util.Date idata){
        Calendar oCal = Calendar.getInstance();
        oCal.setTime(idata);
        return DIASSEMANA[oCal.get(Calendar.DAY_OF_WEEK)];
	}
	
	public static String fmtCNPJ(String cnpj, String dv){
		if ((cnpj != null) && (dv != null)){
		    return fmtCNPJ(cnpj+ dv);
		}
		return (cnpj == null ? "" : cnpj.trim()) + (dv == null ? "" : dv);
	}

	public static String fmtCNPJ(String cnpj){
	    try{
			if ( cnpj != null ){
				cnpj = cnpj.replaceAll("\\D", "");
				if ( cnpj.length() > 13 ){
					return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
				}
			}
	    }catch (Exception e) {
	        e.printStackTrace();
        }
		return cnpj;
	}
	
	public static String fmtCpf( String strCpf ) {
	    try{
			if(strCpf != null){
			    strCpf = strCpf.replaceAll("\\D","");
			    if (strCpf.length()>10){
			        strCpf = strCpf.substring(0,3) + "." + strCpf.substring(3,6)+ "." + strCpf.substring(6,9)+ "-" + strCpf.substring(9,11);
			    }
			}
	    }catch (Exception e) {
	        e.printStackTrace();
		}
		return strCpf;
	}

	public static String fmtCpfCNPJ( String strCNPJCpf ) {
	    try{
	    	if (strCNPJCpf == null){
	    		return "";
	    	}
		    strCNPJCpf = strCNPJCpf.replaceAll("\\D","");
		    if (strCNPJCpf.length() > 13 ){
		        return fmtCNPJ(strCNPJCpf);
		    }else if (strCNPJCpf.length() > 10 ){
		        return fmtCpf(strCNPJCpf);
		    }
	    }catch (Exception e) {
	        e.printStackTrace();
	        return "";
        }
	    return strCNPJCpf;
	}
	
	public static String fmtCEP(String cep){
		return cep.substring(0, 5) + "-" + cep.substring(5);
	}
	
	
	public static String getCaminhoExecutavelLinux(String executavel){
		try {
		    String strErro = "";
		    String strSaida = "";

		    File arqExec = File.createTempFile("bkp","sh");
		    FileWriter fw = new FileWriter(arqExec);            
            fw.write("#!/bin/sh\n");
            fw.write("if which "+executavel+" 1> /dev/null 2>/dev/null; then\n");
            fw.write("  echo \"OK|\"`which "+executavel+"`;\n");            
            fw.write("else\n");
            fw.write("  echo \"ERRO|ERRO\";\n");
            fw.write("fi;\n");
		    fw.close();

		    Process processo = null;
		    int exitVlue;
		    
		    processo = Runtime.getRuntime().exec("chmod a+x "+arqExec.getAbsolutePath());
			processo.waitFor();
			exitVlue = processo.exitValue();
			
		    processo = Runtime.getRuntime().exec(arqExec.getAbsolutePath());
			processo.waitFor();
			exitVlue = processo.exitValue();

		   			
            byte[]  arrB = new byte [512];
		    int qtdlido;
		    
		    qtdlido = 1;
		    while( qtdlido > 0 ){
				qtdlido =  processo.getErrorStream().read(arrB);
				if ( qtdlido > 0 )
				strErro += new String(arrB,0,qtdlido);
			}

		    qtdlido = 1;
			while( qtdlido > 0 ){
				qtdlido =  processo.getInputStream().read(arrB);
				if ( qtdlido > 0 )
				strSaida += new String(arrB,0,qtdlido);
			}
			System.out.println("strSaida: "+ strSaida);
			arqExec.delete();
			
			if ( strErro != null ){
				if (!strErro.equals("")){
				    return null;
				}
			}	
			
			if ( strSaida == null ){
			    return null;			
			}
			
			String[] arrRetorno = strSaida.split("[\\|]");
			if (arrRetorno[0].equalsIgnoreCase("ERRO")){
			    return null;						
			}
			
			return arrRetorno[1];
		} catch (Exception e2) {
			e2.printStackTrace();
			return null;
		}
    }

	/**
	 * Executa um comando e retorna um array de objeto.
	 * @param 
	 * @param comando - Coamando a ser executado
	 * @return 1 posicao - (Integer) codigo retorno  2 posicao - (String) Saida normal do comando     3 posicao - (String) Saida de errol do comando
	 */
	public static Object[] executaComandoShell(String comando ) throws Exception{
		try {
		    File arqExec = null;
		    Process processo = null;
		    int exitVlue;
		    String strErro = "";
		    String strSaida = "";
		    
		    if ( comando == null ){
			    throw new Exception(" Erro. Comando nulo" );
		    }
		    comando = comando.trim();
		    
		    if (System.getProperty("os.name").toLowerCase().indexOf("linux") > -1){
		        arqExec = File.createTempFile("exc","sh");
			    FileWriter fw = new FileWriter(arqExec);
			    fw.write("#!/bin/bash\n");
	            fw.write(comando+"\n");
			    fw.close();

		    } else if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
		        arqExec = File.createTempFile("exc",".bat");
			    FileWriter fw = new FileWriter(arqExec);
			    fw.write("@echo off\r\n");
	            fw.write(comando+"\r\n");
			    fw.close();				
		    } else { 
		        throw new Exception("Sistema Operacional não suportado!");
		    }

		    Object[] objRetorno = Utilitario.executaArquivoShell(arqExec);
		    
			arqExec.delete();
			
			return objRetorno;
		} catch (Exception e2) {
			e2.printStackTrace();
			return null;
		}
    }

	public static Object[] executaArquivoShell( File arqExec ) throws Exception{
	    Process processo = null;
	    int exitVlue;
	    String strErro = "";
	    String strSaida = "";

	    if (System.getProperty("os.name").toLowerCase().indexOf("linux") > -1 || System.getProperty("os.name").toLowerCase().indexOf("freebsd") > -1){
		    processo = Runtime.getRuntime().exec("chmod a+x "+arqExec.getAbsolutePath());
			processo.waitFor();
			exitVlue = processo.exitValue();

			strSaida = Utilitario.copiaStreamParaString( processo.getInputStream() );
			strErro = Utilitario.copiaStreamParaString( processo.getErrorStream() );
	
			if ( strErro != null ){
				if (!strErro.equals("")){
				    throw new Exception(" Erro ao executar comando: [chmod a+x "+arqExec.getAbsolutePath()+"]. Mensagem "+strErro);
				}
			}
	    }
	    
	    processo = Runtime.getRuntime().exec(arqExec.getAbsolutePath());
		processo.waitFor();
		exitVlue = processo.exitValue();

		strSaida = copiaStreamParaString( processo.getInputStream() );
		strErro = copiaStreamParaString( processo.getErrorStream() );

		Object[] objRetorno = new Object[3];
		objRetorno[0] = new Integer(exitVlue);
		objRetorno[1] = strSaida;
		objRetorno[2] = strErro;			

		return objRetorno;
	}
	
	public static String copiaStreamParaString(InputStream in) 
	throws IOException {
		StringBuffer sbRetorno = new StringBuffer();
		
		synchronized (in) {
				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1) break;
					sbRetorno.append( new String(buffer, 0, bytesRead) );
				}
		}
		return sbRetorno.toString();
	}
	
	//tira o ponto e completa os decimais com 0
	public static String tiraVirgula(double valor, int numDecimais){		
		String[] parte = (""+valor).split("\\.");		
		for(int x=parte[1].length(); x<numDecimais; x++){
			parte[1]+="0";
		}
		return parte[0]+parte[1];
	}
	
	
	public static String str2hex(String str){
		return Conversao.str2hex(str);
	}

    public static void descompactaArquivosZip( File flZip, String strPastaDestino, boolean isSobrescrever ) throws Exception{
/*        System.out.println("----------------------------------");
        System.out.println("descompactaArquivosZip - strPastaDestino: "+strPastaDestino);
        System.out.println("----------------------------------");*/
        
        Utilitario.criaPasta(strPastaDestino);
                
        ZipFile zflZip = new ZipFile( flZip );
        
        for ( Enumeration objEnumeration = zflZip.entries(); objEnumeration.hasMoreElements();) {
            
            ZipEntry zpe = (ZipEntry) objEnumeration.nextElement();

//			com.virtuallis.LogVirtuallis.executaLog(Utilitario.class,"descompactaArquivosZip",0,"zpe.getName: "+zpe.getName(),"Utilitario" );

            strPastaDestino = strPastaDestino.replaceAll("[\\\\]+","/");
            strPastaDestino = strPastaDestino.replaceAll("[/]+","/");
            
            String strArquivoDescompactado = strPastaDestino+"/"+zpe.getName();
//			com.virtuallis.LogVirtuallis.executaLog(Utilitario.class,"descompactaArquivosZip",0,"strArquivoDescompactado: "+strArquivoDescompactado,"Utilitario" );

            strArquivoDescompactado = strArquivoDescompactado.replaceAll("[\\\\]+","/");
            strArquivoDescompactado = strArquivoDescompactado.replaceAll("[/]+","/");

//			com.virtuallis.LogVirtuallis.executaLog(Utilitario.class,"descompactaArquivosZip",0,"strArquivoDescompactado: "+strArquivoDescompactado,"Utilitario" );

            java.io.File arqNovo = new java.io.File( strArquivoDescompactado );
//			com.virtuallis.LogVirtuallis.executaLog(Utilitario.class,"descompactaArquivosZip",0,"arqNovo: "+arqNovo.getAbsolutePath(),"Utilitario" );
            
            if ( zpe.isDirectory() ){
                arqNovo.mkdirs();
            }else{
                Utilitario.copiaStream(zflZip.getInputStream( zpe ), new FileOutputStream(arqNovo,!isSobrescrever), true, true );
            }
            
        }
        
    }

    public static void criaPasta(String strDir) {
        strDir = strDir.replaceAll("[\\\\]+","/");
        strDir = strDir.replaceAll("[/]+","/");

        File dir = new File(strDir);
        if (!dir.exists()){
             dir.mkdirs();
        }
         
    }

    public static void apagaDiretorio(String strDir) {
        strDir = strDir.replaceAll("[\\\\]+","/");
        strDir = strDir.replaceAll("[/]+","/");

        File dir = new File(strDir);
        if (!dir.exists()){
            return;        
        }
        File[] arrArquivos = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return !( name.equals(".") || name.equals("..") );
            }
        } );
        for (int i = 0; i < arrArquivos.length; i++) {
            File file = arrArquivos[i];
            if ( file.isDirectory() ){
                apagaDiretorio(file.getAbsolutePath());
            }else{
                file.delete();
            }
        }         
        dir.delete();
     }

	public static void compactaArquivo( String strArquivoZip, String strArquivo ) throws Exception{
	    compactaArquivo( strArquivoZip, strArquivo, new File(strArquivo).getName() );
	}
	
	private static void compactaArquivo( String strArquivoZip, String strArquivo,  String strDescricaoArquivo) throws Exception{
	    compactaArquivo( strArquivoZip, strArquivo,  strDescricaoArquivo, null);
	}
	
	private static void compactaArquivo( String strArquivoZip, String strArquivo,  String strDescricaoArquivo, ZipOutputStream zipOutStream) throws Exception{
	    compactaArquivo( strArquivoZip, strArquivo,  strDescricaoArquivo, zipOutStream, true);	
	}
	
	private static void compactaArquivo( String strArquivoZip, String strArquivo,  String strDescricaoArquivo, ZipOutputStream zipOutStream, boolean blnFecharArquivo ) throws Exception{
	    		
		try{
		    if (zipOutStream==null){
		        zipOutStream = new ZipOutputStream( new FileOutputStream( new File(strArquivoZip) ) );
		    }

			File flEntrada = new File(strArquivo);
			
			if ( flEntrada.isDirectory() ){
			    Utilitario.compactaPasta( strArquivoZip, strArquivo, strDescricaoArquivo, true, zipOutStream, false, null);
			}else{
			    zipOutStream.putNextEntry( new ZipEntry( strDescricaoArquivo ) );

				Utilitario.copiaStream(
			            new FileInputStream(  flEntrada ),
			            zipOutStream,
			            true,
			            false
			    );
				zipOutStream.closeEntry();			
				if (blnFecharArquivo){				
				    zipOutStream.close();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}

	public static void compactaPasta( String strArquivoZip, String strArquivo ) throws Exception{	
		compactaPasta( strArquivoZip, strArquivo,  "", null );	
	}
	
	public static void compactaPasta( String strArquivoZip, String strArquivo, FilenameFilter fnfFiltro ) throws Exception{	
		compactaPasta( strArquivoZip, strArquivo,  "", fnfFiltro );
	}	   	    
	
	private static void compactaPasta( String strArquivoZip, String strArquivo,  String strPastaPai, FilenameFilter fnfFiltro ) throws Exception{
		compactaPasta( strArquivoZip, strArquivo,  strPastaPai, false, fnfFiltro );	
	}
	
	private static void compactaPasta( String strArquivoZip, String strArquivo,  String strPastaPai, boolean blnAdicionaPasta, FilenameFilter fnfFiltro ) throws Exception{
	    compactaPasta( strArquivoZip, strArquivo,  strPastaPai, blnAdicionaPasta, null, fnfFiltro );
	}
	
	private static void compactaPasta( String strArquivoZip, String strArquivo,  String strPastaPai, boolean blnAdicionaPasta, ZipOutputStream zipOutStream, FilenameFilter fnfFiltro ) throws Exception{
		compactaPasta( strArquivoZip, strArquivo,  strPastaPai, blnAdicionaPasta, zipOutStream, true, fnfFiltro );
	}
	
	private static void compactaPasta( String strArquivoZip, String strArquivo,  String strPastaPai, boolean blnAdicionaPasta, ZipOutputStream zipOutStream, boolean blnFecharArquivo, FilenameFilter fnfFiltro ) throws Exception{
		try{
		    if (zipOutStream==null){
		        zipOutStream = new ZipOutputStream( new FileOutputStream( new File(strArquivoZip) ) );
		    }
		    
			File flEntrada = new File(strArquivo);
			
			if ( flEntrada.isDirectory() ){
				String strNomePasta = flEntrada.getName(); 
				strPastaPai += ( strPastaPai.equals("")?"":"/");

				if ( fnfFiltro == null ){
					fnfFiltro = new FilenameFilter() {
	                    public boolean accept(File dir, String name) {
	                        return !( name.equals(".") || name.equals("..") );
	                    }
	                }; 
				}
				
				File[] flArquivos = flEntrada.listFiles( fnfFiltro );
				
				for (int i = 0; i< flArquivos.length; i++){
					String strNomeArquivoPasta = flArquivos[i].getName();
					
					if ( ! blnAdicionaPasta ){
					    strNomePasta = "";
					}else{
					    strNomePasta += "/";
					}
					
				    compactaArquivo( strArquivoZip, flArquivos[i].getAbsolutePath(), strPastaPai+strNomePasta+strNomeArquivoPasta, zipOutStream, false );
				}
				
				if( blnFecharArquivo ){
				    zipOutStream.close();
				}
				
			}else{
			    compactaArquivo( strArquivoZip, strArquivo);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}

	public static void copiaArquivos( String strOrigem, String strDestino ) throws Exception{
		File flOrigem = new File(strOrigem);
		File flDestino = new File(strDestino);

		if ( flOrigem.isDirectory() ){
			File[] arqs = flOrigem.listFiles(new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	                return !( name.equals(".") || name.equals("..") );
	            }
	        } );
			
			for (int i = 0; i< arqs.length; i++){
				copiaArquivos( arqs[i].getAbsolutePath(), flDestino.getAbsolutePath()+File.separator+arqs[i].getName() );
			}
		}else{
		    if (!flDestino.getParentFile().exists()){
				flDestino.getParentFile().mkdirs();		    
		    }
		    
			Utilitario.copiaStream( new FileInputStream(flOrigem),new FileOutputStream(flDestino), true, true );
		}
	}	
		

    /**
	 * 
	 * @param mascara contendo 0 pra valor numerico e X para valor em caractere
	 * @param valor a ser formatado 
	 * @return retorna o valor aplicando uma mascara ex 00.00-000 em 1234567 = 12.34-567
	 */
	public static String aplicaMaskFormat(String mascara, String valor){
 
 		if ((valor == null || valor.trim().equals("")))
 			return "";
 
 		/* 
 		 * Substituir as mascaras passadas como  0, 9, X, * por # para efetuar a formatcao
 		 */
 		mascara = mascara.replaceAll("9", "#");
 		mascara = mascara.replaceAll("0", "#");
 		mascara = mascara.toUpperCase().replaceAll("X", "#");
 

 		for(int digito = 0; digito < valor.length(); digito++){
 			mascara = mascara.replaceFirst("#", valor.substring(digito, digito + 1));
 		}
 
 		//tira residuo
 		
 		if (mascara.indexOf("#")>0){
 			return mascara.substring(0,mascara.indexOf("#"));
 		}else{
 			return mascara;
 		}
 	}
	
	public static String quebraLinhas(String texto, int altura, int largura, boolean cortapalavra) {

        return Formatacao.quebraLinhas(texto, altura, largura, cortapalavra);
    }
	
    public static String escape(String string) { //TODO: diminuir ou eliminar o vetor

    	String[] esc = new String[] { "%00", "%01", "%02", "%03", "%04", "%05", "%06", "%07", "%08", "%09", "%0A", "%0B", "%0C", "%0D", "%0E", "%0F", "%10",
                "%11", "%12", "%13", "%14", "%15", "%16", "%17", "%18", "%19", "%1A", "%1B", "%1C", "%1D", "%1E", "%1F", "%20", "%21", "%22", "%23", "%24",
                "%25", "%26", "%27", "%28", "%29", "*", "+", "%2C", "-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "%3A", "%3B", "%3C",
                "%3D", "%3E", "%3F", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z", "%5B", "%5C", "%5D", "%5E", "_", "%60", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z", "%7B", "%7C", "%7D", "%7E", "%7F", "%80", "%81", "%82", "%83", "%84", "%85", "%86", "%87", "%88",
                "%89", "%8A", "%8B", "%8C", "%8D", "%8E", "%8F", "%90", "%91", "%92", "%93", "%94", "%95", "%96", "%97", "%98", "%99", "%9A", "%9B", "%9C",
                "%9D", "%9E", "%9F", "%A0", "%A1", "%A2", "%A3", "%A4", "%A5", "%A6", "%A7", "%A8", "%A9", "%AA", "%AB", "%AC", "%AD", "%AE", "%AF", "%B0",
                "%B1", "%B2", "%B3", "%B4", "%B5", "%B6", "%B7", "%B8", "%B9", "%BA", "%BB", "%BC", "%BD", "%BE", "%BF", "%C0", "%C1", "%C2", "%C3", "%C4",
                "%C5", "%C6", "%C7", "%C8", "%C9", "%CA", "%CB", "%CC", "%CD", "%CE", "%CF", "%D0", "%D1", "%D2", "%D3", "%D4", "%D5", "%D6", "%D7", "%D8",
                "%D9", "%DA", "%DB", "%DC", "%DD", "%DE", "%DF", "%E0", "%E1", "%E2", "%E3", "%E4", "%E5", "%E6", "%E7", "%E8", "%E9", "%EA", "%EB", "%EC",
                "%ED", "%EE", "%EF", "%F0", "%F1", "%F2", "%F3", "%F4", "%F5", "%F6", "%F7", "%F8", "%F9", "%FA", "%FB", "%FC", "%FD", "%FE", "%FF" };
        
        String ret = "";

        if (string != null)
            for (int i = 0; i < string.length(); i++) {
                ret += esc[string.charAt(i)];
            }

        return ret;
    }
    
    public static String unescape(String string) {

        String ret = "";

        if (string != null) {

            String[] str = string.split("%");

            for (int i = 0; i < str.length; i++) {

                boolean codificado = false;

                if (str[i].length() >= 2) {
                    try {
                        ret += (char) Byte.parseByte(str[i].substring(0, 2), 16);
                        codificado = true;
                    } catch (NumberFormatException e) {
                    }
                }

                if (codificado)
                    ret += str[i].substring(2);
                else
                    ret += str[i];
            }
        }

        return ret;
    }
	
	public static int retornaDiferencaAnos( java.util.Date dtInicial, java.util.Date dtFinal ){
		return Data.retornaDiferencaAnos(dtInicial, dtFinal);
	}	
		

	
	public static String getUltimoDiaMes( String stringMes, String stringAno ) throws ParseException {
    	GregorianCalendar gc = new java.util.GregorianCalendar( new java.util.Locale("pt","BR","" ));
    	gc.setTime(new SimpleDateFormat("yyyyMMdd").parse(stringAno+stringMes+"01"));
    	return (gc.getActualMaximum( GregorianCalendar.DAY_OF_MONTH )+"").length()<2?("0"+gc.getActualMaximum( GregorianCalendar.DAY_OF_MONTH )+""):(gc.getActualMaximum( GregorianCalendar.DAY_OF_MONTH )+"");
    }
	public static String getPrimeiroDiaMes( String stringMes, String stringAno ) throws ParseException {
    	GregorianCalendar gc = new java.util.GregorianCalendar( new java.util.Locale("pt","BR","" ));
    	gc.setTime(new SimpleDateFormat("yyyyMMdd").parse(stringAno+stringMes+"01"));
    	return (gc.getActualMinimum( GregorianCalendar.DAY_OF_MONTH )+"").length()<2?("0"+gc.getActualMinimum( GregorianCalendar.DAY_OF_MONTH )+""):(gc.getActualMinimum( GregorianCalendar.DAY_OF_MONTH )+"");
    }
    
    
	
    public static String getJdbcTypeClass(java.sql.ResultSetMetaData rsmd, int t ) {
    	String cls = "java.lang.Object";

    	try {
    		cls = rsmd.getColumnClassName(t);
    		cls =  getJRFieldType(cls);	
    	} catch (Exception ex)
    	{
    		// if getColumnClassName is not supported...
    		try {
    			int type = rsmd.getColumnType(t);
    			switch( type ) {
    			case java.sql.Types.TINYINT:
    			case java.sql.Types.BIT:
    				cls = "java.lang.Byte";
    				break;
    			case java.sql.Types.SMALLINT:
    				cls = "java.lang.Short";
    				break;
    			case java.sql.Types.INTEGER:
    				cls = "java.lang.Integer";
    				break;
    			case java.sql.Types.FLOAT:
    			case java.sql.Types.REAL:
    			case java.sql.Types.DOUBLE:
    			case java.sql.Types.NUMERIC:
    			case java.sql.Types.DECIMAL:
    				cls = "java.lang.BigDecimal";
    				break;
    			case java.sql.Types.CHAR:
    			case java.sql.Types.VARCHAR:
    				cls = "java.lang.String";
    				break;

    			case java.sql.Types.BIGINT:
    				cls = "java.lang.Long";
    				break;
    			case java.sql.Types.DATE:
    				cls = "java.util.Date";
    				break;
    			case java.sql.Types.TIME:
    				cls = "java.sql.Time";
    				break;
    			case java.sql.Types.TIMESTAMP:
    				cls = "java.sql.Timestamp";
    				break;
    			}
    		} catch (Exception ex2){
    			ex2.printStackTrace();
    		}
    	}
    	return cls;
    }

    public static String string_fup(String entrada) {
    	entrada = entrada.toLowerCase();
    	
    	String[] entradaSplitado = entrada.split(" ");
    	String saida = "";
    	for (int x = 0; x < entradaSplitado.length; x++){
    		if (entradaSplitado[x].trim().equalsIgnoreCase("")){
    			continue;
    		} else {
    			entradaSplitado[x] = fup(entradaSplitado[x].trim());
    		}
    	}
    	
    	for (int x = 0; x < entradaSplitado.length; x++){
    		if (entradaSplitado[x].trim().equalsIgnoreCase("")){
    			continue;
    		} else {
    			saida += entradaSplitado[x].trim()+" ";
    		}
    	}
    	if (saida.length()>0){
    		saida = saida.substring(0, saida.length()-1);//remove ultimo espaço
    	}
    	return saida;
    }
    
	public static String fup(String txtEntrada){ //firstUP Primeira Letra UpperCase
		String txtSaida = (txtEntrada.charAt(0)+"").toUpperCase();
		txtSaida += txtEntrada.substring(1, txtEntrada.length());
		return txtSaida;
	}
    
    public static String getJRFieldType(String type)
    {
    	if (type == null) return "java.lang.Object";
    	if (type.equals("java.lang.Boolean") || type.equals("boolean")) return "java.lang.Boolean";
    	if (type.equals("java.lang.Byte") || type.equals("byte")) return "java.lang.Byte";
    	if (type.equals("java.lang.Integer") || type.equals("int")) return "java.lang.Integer";
    	if (type.equals("java.lang.Long") || type.equals("long")) return "java.lang.Long";
    	if (type.equals("java.lang.Double") || type.equals("double")) return "java.math.BigDecimal";
    	if (type.equals("java.lang.Float") || type.equals("float")) return "java.math.BigDecimal";
    	if (type.equals("java.lang.Short") || type.equals("short")) return "java.lang.Short";
    	if (type.startsWith("[")) return "java.lang.Object";
    	return type;
    }

    public static void addJsonArray( org.json.simple.JSONArray objJsonArray, Object objParam ){
		if ( objParam == null ){
			objParam = "";
		}else{
			if ( objParam instanceof Double || objParam instanceof Float || objParam instanceof BigDecimal ){
			//	objParam = new DecimalFormat(strFormatoDecimal).format( ((Number) objParam).doubleValue() );
			}else if ( objParam instanceof Date  ){
				objParam = new SimpleDateFormat(strFormatoData).format( ((Date) objParam) );
			}else if ( objParam instanceof String  ){
				if ( chrCasePadrao == 'U' ){
					objParam = objParam.toString().toUpperCase();
				}else if ( chrCasePadrao == 'L' ){
					objParam = objParam.toString().toLowerCase();
				}
			}
		}
		objJsonArray.add( objParam );
	}
	
	public static void putJsonObj( org.json.simple.JSONObject objJsonObj, String id, Object objParam ){
		if ( objParam == null ){
			objParam = "";
		}else{
			if ( objParam instanceof Double || objParam instanceof Float || objParam instanceof BigDecimal ){
	//			objParam = new DecimalFormat(strFormatoDecimal).format( ((Number) objParam).doubleValue() );
			}else if ( objParam instanceof Date  ){
				objParam = new SimpleDateFormat(strFormatoData).format( ((Date) objParam) );
			}else if ( objParam instanceof String  ){
				if ( chrCasePadrao == 'U' ){
					objParam = objParam.toString().toUpperCase();
				}else if ( chrCasePadrao == 'L' ){
					objParam = objParam.toString().toLowerCase();
				}
			}
		}
		objJsonObj.put( id, objParam );
	}
	

	 public static char modulo11(String cod) {
	      char mod = modulo11X(cod);

	      if (mod == 'X')
	          mod = 10;
	      else
	          mod -= 48;

	      int resto = 11 - mod;

	      int dv = 0;

	      if (resto == 10 || resto == 11)
	          dv = 0;
	      else
	          dv = resto;

	      return (char) (dv + 48);
	  }

	  /**
	   * @param cod
	   * @return
	   */
	  public static char modulo11X(String cod) {
	      int soma = 0;

	      for (int i = 0; i < cod.length(); i++)
	          soma += (cod.charAt(cod.length() - 1 - i) - 48) * ((i % 8) + 2);

	      char dv = (char) (soma % 11);

	      if (dv == 10)
	          dv = 'X';
	      else
	          dv += 48;

	      return dv;
	  }
	  
	  public static char modulo11(String cod, int base) {
	      char dv;
	      
	      int soma = 0;

	      for (int i = 0; i < cod.length(); i++){
	          
	          int num = cod.charAt(cod.length() - 1 - i) - 48;
	          int peso = (i % (base - 1)) + 2;
	          
	          soma += num * peso;
	      }
	      
	      int resto = soma % 11;

	      switch (resto) {
	      case 1:
	          dv = 'P';
	          break;
	      case 0:
	          dv = '0';
	          break;
	      default:
	          dv = (char) (11 - resto + 48);
	          break;
	      }

	      return dv;
	  }

	  public static int modulo10(String numero) {
		  int soma = 0;
		  int dgv = 0;
		  int multiplicador = 2;
		  for (int i = numero.length(); i > 0; i--) {
			  soma += ( Integer.parseInt(numero.substring(i-1, i)) * multiplicador  );
			  multiplicador = multiplicador == 2 ? 1 : 2;
		  }
		  dgv = 10 - (soma % 10);

		  if (dgv == 10){
			  dgv = 0;
		  }
		  return dgv;
	  }
	  
    public static int getDigitoGTIN14(String data) throws Exception{
    	int factor = 3;
    	int sum = 0;
    	if (data.length() !=13 ){
    		throw new Exception( "Erro. O código de barras deve ter 13 digitos" );
    	}
		for (int index = 13; index > 0; --index) {
			sum = sum + Integer.parseInt(data.substring (index-1, index)) * factor;
			factor = 4 - factor;
		}
		int cc = ((1000 - sum) % 10);
		return cc; 
    }
    
    

    public static HashSet<String> extraiParametros(String texto) {

        HashSet<String> lst = new HashSet<String>();

        Pattern pattern = Pattern.compile("\\$P!?\\{.*?\\}");

        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {

            String param = texto.substring(matcher.start(), matcher.end());

            param = param.replaceFirst("\\$P\\!?\\{", "").replaceAll("}", "");

            lst.add(param);
        }

        return lst;
    }
    
	public static ArrayList<HashMap<String,Object>> diferencaObjetos(Class<?> classe, Object ant, Object dps) throws Exception{

		ArrayList<HashMap<String,Object>> arrRet = new ArrayList<HashMap<String,Object>>();        
		for( int i = 0; i < classe.getMethods().length; i++){
			Method objMethodRs = classe.getMethods()[i];
//			System.out.println(objMethodRs.getName());
			if ( objMethodRs.getName().startsWith("getRs") ){
				String nomeMetodo = objMethodRs.getName().replaceFirst("getRs", "get");
				Method objMethod = classe.getMethod(nomeMetodo, null);
				
				Object objRet1 = null;
				if (  ant != null)
					objRet1 = objMethod.invoke( ant, null);
				Object objRet2 =null;
				if (  dps != null)
					objRet2 = objMethod.invoke( dps, null);
				if ( objRet1 == null && objRet2 == null){
					//faz nada
				} else if ( (objRet1 == null && objRet2 != null) || (objRet1 != null && objRet2 == null) ){
					String campo = objMethod.getName().substring(3);
					HashMap<String,Object> oHashMap = new HashMap<String,Object>();
					oHashMap.put("CAMPO", campo);
					oHashMap.put("ANTES", objRet1);
					oHashMap.put("DEPOIS", objRet2);
					arrRet.add(oHashMap);
				} else if ( !objRet1.equals(objRet2) ){
					String campo = objMethod.getName().substring(3);
					HashMap<String,Object> oHashMap = new HashMap<String,Object>();
					oHashMap.put("CAMPO", campo);
					oHashMap.put("ANTES", objRet1);
					oHashMap.put("DEPOIS", objRet2);
					arrRet.add(oHashMap);
				}
			}
		}
		
		return arrRet;
	}
}
