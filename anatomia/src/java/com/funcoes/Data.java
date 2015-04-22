package com.funcoes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.Utilitario;


public class Data {

    public static Date getPrimeiroDiaMes(Date dtData) {
        try {
            java.util.GregorianCalendar oCal = new java.util.GregorianCalendar();
            oCal.setTime(dtData);
            oCal.set(Calendar.DAY_OF_MONTH, oCal.getActualMinimum(Calendar.DAY_OF_MONTH));
            return oCal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getUltimoDiaMes(Date dtData) throws Exception {
        try {
            java.util.GregorianCalendar oCal = new java.util.GregorianCalendar();
            oCal.setTime(dtData);
            oCal.set(Calendar.DAY_OF_MONTH, oCal.getActualMaximum(Calendar.DAY_OF_MONTH));
            return oCal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date somaDatas(Date dtData, int qtdDias) {
        try {
            java.util.GregorianCalendar oCal = new java.util.GregorianCalendar();
            oCal.setTime(dtData);
            oCal.add(java.util.GregorianCalendar.DATE, qtdDias);
            return oCal.getTime();
        } catch (Exception e) {
            System.out.print("Erro ao somar datas: Data " + dtData);
            e.printStackTrace();
            return null;
        }
    }

    public static Date criaData(int ano, int mes, int dia) throws Exception {
        java.util.GregorianCalendar oCal = new java.util.GregorianCalendar();
        oCal.set(Calendar.DAY_OF_MONTH, dia);
        oCal.set(Calendar.MONTH, mes);
        oCal.set(Calendar.YEAR, ano);
        return oCal.getTime();
    }

    /**
     * Retorna a zero hora da data passada no argumento
     */
    public static Date retornaData(Date dtData) {
        GregorianCalendar oGc = new GregorianCalendar();
        oGc.setTime(dtData);
        oGc.set(oGc.get(Calendar.YEAR), oGc.get(Calendar.MONTH), oGc.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        oGc.set(Calendar.MILLISECOND, 0);
        return oGc.getTime();
    }

    public static Date adicionaData(Date dataBase, int parte, int incremento) {

        if (dataBase != null) {
            Calendar oCal = new GregorianCalendar();

            oCal.setTime(dataBase);
            oCal.add(parte, incremento);

            return oCal.getTime();
        } else {
            return null;
        }
    }

    public static int retornaDiferencaAnos(Date dtInicial, Date dtFinal) {
        Calendar objCalendar = new GregorianCalendar();
        objCalendar.setTime(dtInicial);

        int iAnoIni = objCalendar.get(Calendar.YEAR);
        int iMesIni = objCalendar.get(Calendar.MONTH);
        int iDiaIni = objCalendar.get(Calendar.DATE);

        objCalendar.setTime(dtFinal);
        int iAnoFim = objCalendar.get(Calendar.YEAR);
        int iMesFim = objCalendar.get(Calendar.MONTH);
        int iDiaFim = objCalendar.get(Calendar.DATE);

        //int iMultiplicador = iAnoFim >= iAnoIni ? 1 : -1; 
        int iDiferencaAnos = Math.abs(iAnoFim - iAnoIni);

        if (iDiferencaAnos != 0) {
            if (iMesFim != iMesIni) {
                if (iMesFim < iMesIni) {
                    iDiferencaAnos--;
                }
            } else if (iDiaFim != iDiaIni) {
                if (iDiaFim < iDiaIni) {
                    iDiferencaAnos--;
                }
            }
        }

        return iDiferencaAnos;
    }

    public static Date somaPeriodo(Date data, String flag, int qnt) {
        int parte = 0;
        switch (flag.charAt(0)) {
        case 'D':
            parte = Calendar.DAY_OF_YEAR;
            break;
        case 'M':
            parte = Calendar.MONTH;
            break;
        case 'A':
            parte = Calendar.YEAR;
            break;
        }
        return Utilitario.adicionaData(data, parte, qnt);
    }

    /**
     * Retorna um array com a dada de inicio e fim de <i>qntMeses</i> a partir do mes de <i>dataIni</i>.
     */
    public static Date[][] dataInicioFimMeses(Date dataIni, int qntMeses) {

        Date[][] data = new Date[qntMeses][2];

        GregorianCalendar gcInicial = new GregorianCalendar();
        gcInicial.setTime(dataIni);

        for (int i = 0; i < qntMeses; i++) {
            gcInicial.set(gcInicial.get(Calendar.YEAR), gcInicial.get(Calendar.MONTH), 1, 0, 0, 0);
            Date dtIni = gcInicial.getTime();

            gcInicial.set(gcInicial.get(Calendar.YEAR), gcInicial.get(Calendar.MONTH), gcInicial.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
            Date dtFim = gcInicial.getTime();

            gcInicial.setTime(dtIni);
            gcInicial.add(Calendar.MONTH, 1);

            data[i][0] = dtIni;
            data[i][1] = dtFim;
        }

        return data;
    }
    
    public static Date[][] getSemanasDoPeriodo(Date dataIni, Date dataFim) {

        ArrayList<Date[]> semanas = new ArrayList<Date[]>();

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataIni);

        while (gc.getTime().before(dataFim) || gc.getTime().equals(dataFim)) {

            gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

            Date dtIni = gc.getTime();

            gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DAY_OF_MONTH), 23, 59, 59);

            while (gc.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && gc.getTime().before(dataFim)) {
                gc.add(Calendar.DAY_OF_YEAR, 1);
            }

            Date dtFim = gc.getTime();

            semanas.add(new Date[] { dtIni, dtFim });

            gc.add(Calendar.DAY_OF_YEAR, 1);
        }
            
        return semanas.toArray(new Date[semanas.size()][2]);
        }
    
    public static void main(String[] args) {
        
        Date[][] meses = dataInicioFimMeses(new Date("12/01/2010"), 1);
        
        Date[][] sem = getSemanasDoPeriodo(meses[0][0], meses[0][1]);
        
        System.out.println(sem);
    }

}
