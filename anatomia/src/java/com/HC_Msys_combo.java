package com;

import java.text.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;

public class HC_Msys_combo extends Msys_combo{
    public void HC_Msys_combo(){
    }
    public String getStringCombo(int codCombo, String caracter, Connection conn) throws Exception {
    	String retorno = "";
    	HC_Msys_combo_item oMCI = new HC_Msys_combo_item();
    	oMCI.setConnexao(conn);
    	oMCI.setInTransaction(conn!=null);
    	oMCI.setCodcombo(codCombo);
    	oMCI.setValitem(caracter);
    	oMCI.lista();
    	if (oMCI.next()) {
    		retorno = ""+oMCI.getRsDescitem();
    	}
    	return retorno;
    }
}

