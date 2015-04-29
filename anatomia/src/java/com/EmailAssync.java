package com;

import java.sql.Connection;

import com.funcoes.Email;

public class EmailAssync {
	
	private Connection conn;
	private String destino;
	private String titulo;
	private String mensagem;
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	
	
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void enviaEmailAssync(){
		new Thread(new Runnable() {
		    public void run() {
		
		    	try {
			
		   			
		   			Email email = new Email();
		   			email.enviaEmail(destino, "", titulo, mensagem);
		   			
		    		
				} catch (Exception e) {
					
					e.printStackTrace();
					// TODO: handle exception
				}
		    		
		    	
		    	//Do whatever
		    }
		}).start();
	}

}
