package com;

import java.sql.Connection;
import java.sql.ResultSet;


public class HC_Lab_pessoa extends Lab_pessoa{
    public HC_Lab_pessoa(){
    }
    
    public static void main(String[] args) {

    	try {
    		//inserePessoa(55000, 1, "37150000", "email@email.com", "1", "José", "senha", "1");
    		
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
    
    public static void inserePessoa(int num_matricula, int cod_curso, String nume_telefone, String desc_email, String flag_tipo, String desc_nome, String desc_senha, String flag_situacao) throws Exception{
    	Connection conn = null;
    try {
    	conn = DBSettings.getConexao();
    	conn.setAutoCommit(false);
    	
    	
		HC_Lab_pessoa pessoa = new HC_Lab_pessoa();
		pessoa.setConnexao(conn);
		pessoa.setInTransaction(true);
    	
		/*Date dat_ini = new SimpleDateFormat("dd/MM/yyyy").parse(dataini.trim());
    	Date dat_fim = new SimpleDateFormat("dd/MM/yyyy").parse(datafim.trim());
    	Date dataaux = null;*/

    	ResultSet rs = null;
		
		// Testa se pessoa já está cadastrada
		rs = conn.createStatement().executeQuery("select 1 from lab_pessoa where num_matricula = '"+ num_matricula +"'");
		if(rs.next()){
			//if(rs.getInt("reservas")>=qtdidadevagasmax){
				throw new Exception("Erro. Matrícula já está cadastrada no sistema");
			//}
		}
		
		// Adiciona no BD
		pessoa.limpaPropriedades();
		pessoa.limpaPropriedadesRS();
		
		pessoa.setNummatricula(num_matricula);
		pessoa.setCodcurso(cod_curso);
		pessoa.setNumtelefone(nume_telefone);
		pessoa.setDescemail(desc_email);
		pessoa.setFlagtipo(flag_tipo);
		pessoa.setDescnome(desc_nome);
		pessoa.setDescsenha(desc_senha);
		pessoa.setFlagsituacao(flag_situacao);
		pessoa.insert();
    	
    	conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			try {
				conn.close()	;
			} catch (Exception e2) {
			}
		}	
    }
}

