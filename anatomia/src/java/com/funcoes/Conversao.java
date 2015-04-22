/*
 * Created on 20/04/2007
 */
package com.funcoes;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * @author Martin Jackisch
 */
public class Conversao {

    public static String byteArray2String(byte[] bArray) {
        String str = "";
        for (int i = 0; i < bArray.length; i++) {
            str += (char) (((int) bArray[i]) & 255);
        }
        return str;
    }
    
/**
 * @author Fernando Worst
 * 
     * @param mSeg
     *            (double)
 * 
 * @return str (HH:mm:ss)
 */
    public static String formataTempo(double mSeg){
    	return formataTempo((long)mSeg);
    }

    public static String formataTempo(long mSeg){
    	String str = "";
    	double horas = 0;
    	double minutos = 0;
    	double segundos = 0;
    	double ms = mSeg;
    	
    	horas = Math.floor(ms/(60*60*1000));
    	ms = Math.floor(ms%(60*60*1000));
    	minutos = Math.floor(ms/(60*1000));
    	ms = Math.floor(ms%(60*1000));
    	segundos = Math.floor(ms/1000);
    	
    	str = new DecimalFormat("00").format(horas) + ":" + new DecimalFormat("00").format(minutos) + ":" + new DecimalFormat("00").format(segundos);		
    	return str;
    }

    public static long hour2int(String tempo) throws Exception {
        long retorno = 0;
        try {
            retorno = Long.parseLong(tempo.split(":")[0]) * 60 * 60 * 1000;
            retorno += Long.parseLong(tempo.split(":")[1]) * 60 * 1000;
            if (tempo.split(":").length == 3) {
                if (!tempo.split(":")[2].equals("")) {
                    retorno += Long.parseLong(tempo.split(":")[2]) * 1000;
                }
            }
        } catch (Exception e) {
            throw new Exception("Quatidade de Horas Inválida (" + tempo + ").");
        }
        return retorno;
    }



    public static java.util.Date sqlStringToDate(String data) {
        Calendar calendar = new GregorianCalendar();
        calendar.clear();

        String aux = "" + data.trim().replaceAll(" ", "");
        aux = aux.replaceAll(":", "");
        aux = aux.replaceAll("-", "");
        aux = aux.replaceAll("/", "");

        if (aux.length() < 14) {
            aux += "000000000000000000";
        }

        //System.out.println("DATA: " + aux);

        calendar.set(Calendar.YEAR, Integer.parseInt(aux.substring(0, 4)));
        calendar.set(Calendar.MONTH, Integer.parseInt(aux.substring(4, 6)) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(aux.substring(6, 8)));
        //System.out.println("DATA: " + calendar.getTime() + " MES:" + aux.substring(4,6));
        return calendar.getTime();
    }

    public static String dateToStrSQL(java.util.Date data) {
        try {
            return (new SimpleDateFormat(com.DBSettings.getFormatoData()).format(data));
        } catch (Exception a) {
            System.out.println("ERRO CONVERTENDO DATA " + data);
            a.printStackTrace();
            return ("NULL");
        }
    }

    public static String dateToStrSQLDataSimples(java.util.Date data) {
        try {
            return (new SimpleDateFormat(com.DBSettings.getFormatoDataSimples()).format(data));
        } catch (Exception a) {
            System.out.println("ERRO CONVERTENDO DATA " + data);
            a.printStackTrace();
            return ("NULL");
        }
    }

    public static java.util.Date strToDate(String valor) {
        java.util.Date data;

        try {
            //System.out.println(valor);
            if (valor.indexOf(":") >= 0) {
                // data = java.text.DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM , new Locale("br","","")).parse(valor);
                data = java.text.DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, new Locale("pt", "BR", "")).parse(valor);
            } else {

                //data = java.text.DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt","BR","")).parse(valor);
                data = java.text.DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR", "")).parse(valor);

            }
            //System.out.println(data);
        } catch (ParseException e) {
            data = null;
            System.out.print(e.toString());
        }

        return (data);
    }

    public static String str2hex(String str) {
        String hex = "";
        for (int i = 0; i < str.length(); i++) {
            hex += Integer.toHexString(str.charAt(i)) + (i < str.length() ? " " : "");
        }
        return hex;
    }
}