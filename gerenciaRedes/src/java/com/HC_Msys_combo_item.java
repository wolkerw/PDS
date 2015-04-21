package com;

import java.sql.Connection;

public class HC_Msys_combo_item extends Msys_combo_item{
    public HC_Msys_combo_item(){
    }
    
    public static String getDescItemCombo(Connection cn, int combo, String valorItem) throws Exception{
    	String retorno = "";
    	
    	HC_Msys_combo_item oItem = new HC_Msys_combo_item();
    	oItem.setConnexao(cn);
    	oItem.setInTransaction(cn!=null);
    	oItem.setCodcombo(combo);
    	oItem.setValitem(valorItem);
    	oItem.setTop("1");
    	oItem.lista();
    	if (oItem.next()){
    		retorno = oItem.getRsDescitem();
    	}
    	
    	return retorno;
    }
}

