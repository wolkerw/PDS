package com.funcoes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.Utilitario;

public class Formatacao {

    public static final int ALINHA_ESQUERDA = 0;
    public static final int ALINHA_CENTRO = 1;
    public static final int ALINHA_DIREITA = 2;

    public static String formataNumero(Object valor, int decimais, int inteiros) {

        String retorno = "";

        if (valor != null) {
            // NumberFormat nf = NumberFormat.getInstance(new Locale("pt","BR",""));
            NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR", ""));
            nf.setMinimumFractionDigits(decimais);
            nf.setMaximumFractionDigits(decimais);
            nf.setMinimumIntegerDigits(inteiros);
            retorno = nf.format(valor);
        } else {
            retorno = "";
        }

        return retorno;
    }

    public static String formataNumero(Object valor, int decimais, int inteiros, String alternativa) {

        String retorno = "";

        if (valor != null) {
            // NumberFormat nf = NumberFormat.getInstance(new Locale("pt","BR",""));
            NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR", ""));
            nf.setMinimumFractionDigits(decimais);
            nf.setMaximumFractionDigits(decimais);
            nf.setMinimumIntegerDigits(inteiros);
            retorno = nf.format(valor);
        } else {
            retorno = alternativa;
        }

        return retorno;
    }

    public static String formataNumero(double valor, int decimais, int inteiros) {
        return formataNumero(new Double(valor), decimais, inteiros);
    }

    public static String formataNumero(double valor, int decimais, int inteiros, String alternativa) {
        return formataNumero(new Double(valor), decimais, inteiros, alternativa);
    }

    public static String tiraAcentos(String valor) {
        String retorno = valor;
        String[] min = { "á", "a", "é", "e", "í", "i", "ó", "o", "ú", "u", "à", "a", "è", "e", "ì", "i", "ò", "o", "ù", "u", "â", "a", "ê", "e", "î", "i", "ô",
                "o", "û", "u", "ã", "a", "õ", "o", "ä", "a", "ë", "e", "ï", "i", "ö", "o", "ü", "u", "ç", "c" };

        for (int i = 0; i < min.length; i += 2)
            retorno = retorno.replaceAll(min[i], min[i + 1]).replaceAll(min[i].toUpperCase(), min[i + 1].toUpperCase());

        return retorno;
    }

    /**
     * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num',
     * se for menor que 'num' trunca
     * 
     * @param String
     *            str - string a formatar
     * @param int
     *            num - tamanho deseja da str
     */
    public static String fmtStringNumerica(String str, int num) {
        str = str.replaceAll("\\.", "").replaceAll(",", "");

        while (str.length() < num)
            str = "0" + str;

        str = str.substring(str.length() - num);

        return str;
    }

    public static String fmtStringNumerica(double d, int tam, int dec) {
        return new DecimalFormat(sequencia("0", tam - dec) + "." + sequencia("0", dec)).format(d).replaceAll("\\" + Utilitario.getSeparadorDecimal(), "");
    }

    /**
     * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num'
     * 
     * @param int
     *            i - numero a formatar
     * @param int
     *            num - tamanho deseja da str
     */
    public static String fmtStringNumerica(int i, int num) {
        return fmtStringNumerica(i + "", num);
    }

    public static String fmtStringNumerica(double i, int num) {
        return fmtStringNumerica(i + "", num);
    }
    /**
     * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num'
     * 
     * @param int
     *            i - numero a formatar
     * @param int
     *            num - tamanho deseja da str
     */
    public static String fmtStringNumerica(Integer i, int num) {
        return fmtStringNumerica(i + "", num);
    }

    /**
     * Preenche com zeros a esquerda ate o tamanho da string for igual a 'num'
     * 
     * @param long
     *            l - numero a formatar
     * @param int
     *            num - tamanho deseja da str
     */
    public static String fmtStringNumerica(long l, int num) {
        return fmtStringNumerica(l + "", num);
    }

    /**
     * Preenche com espaços a direita ate o tamanho da string for igual a 'num'.
     * Se for maior que 'num' retorna os 'num' primeiros caracteres.
     * 
     * @param String
     *            str - string a formatar
     * @param int
     *            num - tamanho deseja da str
     */
    public static String fmtStringTexto(String str, int num) {
        while (str.length() < num)
            str += " ";

        str = str.substring(0, num);
        str = tiraAcentos(str);

        return str;
    }

    public static String fmtStringTexto(String str, int num, int alinhamento) {
        switch (alinhamento) {
        case ALINHA_ESQUERDA:
            str = (str + sequencia(" ", num)).substring(0, num);
            break;

        case ALINHA_CENTRO:
            int spc = num - str.length();
            if (spc > 0) {
                int spcEsq = spc / 2;
                int spcDir = spc - spcEsq;
                str = sequencia(" ", spcEsq) + str + sequencia(" ", spcDir);
            } else
                str = str.substring(0, num);
            break;

        case ALINHA_DIREITA:
            str = sequencia(" ", num) + str;
            str = str.substring(str.length() - num);
            break;
        }

        return str;
    }

    /**
     * Retorna a string 'str' repetida 'num' vezes.
     * 
     * @param str -
     *            String
     * @param num -
     *            Int
     */
    public static String sequencia(String str, int num) {
        String ret = "";

        for (int i = 0; i < num; i++)
            ret += str;

        return ret;
    }
    
    public static String quebraLinhas(String texto, int altura, int largura, boolean cortapalavra) {
        
        String retorno = "";
        
        String[] linhas = quebraLinhasArray(texto, altura, largura, cortapalavra);
        
        for (int i = 0; i < linhas.length; i++) {
            retorno += linhas[i] + "\n"; 
        }
        
        return retorno;
    }
    
    public static String quebraLinhas(String texto, int altura, int largura, boolean cortapalavra, boolean pontoNasLinhasVazias) {

        String chr;
        
        if (pontoNasLinhasVazias)
            chr = ".";
        else
            chr = "";

        texto = "";
        
        String linha[] = quebraLinhasArray(texto, altura, largura, cortapalavra);
        
        for (int i = 0; i < linha.length; i++) {
            if (linha[i].trim().equals(""))
                texto += chr;
            else
                texto += linha[i];

            texto += "\r\n";
        }

        for (int i = linha.length; i < altura; i++) {
            texto += chr + "\r\n";
        }

        return texto;
    }
    
    public static String[] quebraLinhasArray(String texto, int altura, int largura, boolean cortapalavra, boolean pontoNasLinhasVazias) {

        String chr;
        
        if (pontoNasLinhasVazias)
            chr = ".";
        else
            chr = "";

        ArrayList linhas = new ArrayList();
        
        String linha[] = quebraLinhasArray(texto, altura, largura, cortapalavra);
        
        for (int i = 0; i < linha.length; i++) {
            if (linha[i].trim().equals(""))
                linhas.add(chr);
            else
                linhas.add(linha[i]);
        }

        for (int i = linha.length; i < altura; i++) {
            linhas.add(chr);
        }

        return (String[]) linhas.toArray(new String[linhas.size()]);
    }

    public static String[] quebraLinhasArray(String texto, int altura, int largura, boolean cortapalavra) {

        ArrayList linhas = new ArrayList();

        String linha = "";
        String palavra = "";

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == (char) 10) {
                linha += palavra;
                linhas.add(linha);
                linha = "";
                palavra = "";
            } else {
                palavra += texto.charAt(i);
            }

            if (linha.length() + palavra.length() > largura) {
                if (cortapalavra) {
                    linha += palavra;
                    linhas.add(linha);
                    linha = "";
                    palavra = "";
                } else {
                    palavra = palavra.trim();
                    linhas.add(linha);
                    linha = "";
                }
            } else {
                if (texto.charAt(i) == ' ') {
                    linha += palavra;
                    palavra = "";
                }
            }

            if (linhas.size() + 1 >= altura && altura > 0) {
                break;
            }
        }

        linha += palavra;

        if (linha.trim().length() > 0)
            linhas.add(linha);

        return (String[]) linhas.toArray(new String[linhas.size()]);
    }
    
    
    private static final char[] FIRST_CHAR =  ("                0123456789       ABCDEFGHIJKLMNOPQRSTUVWXYZ      abcdefghijklmnopqrstuvwxyz{|}~ E ,f'.++^%S<O Z  ''''.--~Ts>o ZY !C#$Y|$'(a<--(_o+23'u .,1o>113?AAAAAAACEEEEIIIIDNOOOOOXOUUUUyTsaaaaaaaceeeeiiiidnooooo/ouuuuyty").toCharArray();  

}
