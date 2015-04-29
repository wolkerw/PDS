package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


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
    
    public static String inserePessoa(int num_matricula, int cod_curso, String num_telefone, String desc_email, String flag_tipo, String desc_nome, String desc_senha, String flag_situacao) throws Exception{

		Connection conn = null;
	    try {
			conn = DBSettings.getConexao();
	    	conn.setAutoCommit(false);
	    	
	    	
			HC_Lab_pessoa pessoa = new HC_Lab_pessoa();
			pessoa.setConnexao(conn);
			pessoa.setInTransaction(true);
	    	
	    	ResultSet rs = null;
			
			// Testa se pessoa já está cadastrada
			rs = conn.createStatement().executeQuery("select 1 from lab_pessoa where num_matricula = '"+ num_matricula +"'");
			if(rs.next()){
				//if(rs.getInt("reservas")>=qtdidadevagasmax){
					return "A matrícula já está cadastrada no sistema";
					/*System.out.println("A matrícula já está cadastrada no sistema");
					throw new Exception("Erro. Matrícula já está cadastrada no sistema");*/
				//}
			}
			
			num_telefone = num_telefone.replaceAll("-", "");
			
			// Adiciona no BD
			pessoa.limpaPropriedades();
			pessoa.limpaPropriedadesRS();
			
			pessoa.setNummatricula(num_matricula);
			pessoa.setCodcurso(cod_curso);
			pessoa.setNumtelefone(num_telefone);
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
	    
	    return "Cadastro realizado com sucesso!";
    }
    
    public static String editaPessoa(int num_matricula, int cod_curso, String num_telefone, String desc_email, String flag_tipo, String desc_nome, String desc_senha, String flag_situacao) throws Exception{
    	
    	Connection conn = null;
	    try {
			conn = DBSettings.getConexao();
	    	conn.setAutoCommit(false);
	    	
	    	
			/*HC_Lab_pessoa pessoa = new HC_Lab_pessoa();
			pessoa.setConnexao(conn);
			pessoa.setInTransaction(true);*/
	    	
	    	ResultSet rs = null;
			
			// Edita no BD
			/*pessoa.limpaPropriedades();
			pessoa.limpaPropriedadesRS();
			
			pessoa.setNummatricula(num_matricula);
			pessoa.setCodcurso(cod_curso);
			pessoa.setNumtelefone(num_telefone);
			pessoa.setDescemail(desc_email);
			pessoa.setFlagtipo(flag_tipo);
			pessoa.setDescnome(desc_nome);
			pessoa.setDescsenha(desc_senha);
			pessoa.setFlagsituacao(flag_situacao);
			pessoa.insert();*/
	    	
	    	//System.out.println("UPDATE lab_pessoa SET cod_curso = '" + cod_curso + "', num_telefone = '" + num_telefone + "', desc_email = '" + desc_email + "', flag_tipo = '" + flag_tipo + "', desc_nome = '" + desc_nome + "', desc_senha = '" + desc_senha + "', flag_situacao = '" + flag_situacao + "' WHERE num_matricula = '" + num_matricula + "'");
			
			conn.createStatement().executeUpdate("UPDATE lab_pessoa SET cod_curso = '" + cod_curso + "', num_telefone = '" + num_telefone + "', desc_email = '" + desc_email + "', flag_tipo = '" + flag_tipo + "', desc_nome = '" + desc_nome + "', desc_senha = '" + desc_senha + "', flag_situacao = '" + flag_situacao + "' WHERE num_matricula = '" + num_matricula + "'");
	    	
	    	conn.commit();
			
	    } catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			try {
				conn.close()	;
				} catch (Exception e2) {
			}
		}
	    
	    return "Edição realizada com sucesso!";
    }
    
    public static ResultSet carregaDadosPessoa(int codPessoa) throws Exception{
        
    	ResultSet rs = null;
    	
      	Connection conn = null;
        try {
        	conn = DBSettings.getConexao();
        	conn.setAutoCommit(false);
        	
        	/*Date base = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        	GregorianCalendar baseini = new GregorianCalendar();
        	baseini.setTime(base);
        	baseini.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        	
        	GregorianCalendar basefim = new GregorianCalendar();
        	basefim.setTime(base);
        	basefim.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        	
        	String inisql = new SimpleDateFormat("yyyyMMdd").format(baseini.getTime());
        	String fimsql = new SimpleDateFormat("yyyyMMdd").format(basefim.getTime());*/
    	
    	
        	String sql = "SELECT num_matricula, cod_curso, num_telefone, desc_email, flag_tipo, desc_nome, desc_senha, flag_situacao FROM lab_pessoa WHERE cod_pessoa = " + codPessoa;

        //System.out.println(sql);
    	
    	rs = conn.createStatement().executeQuery(sql);
    	
    	return rs;
    	
    	
        } catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    		try {
    			conn.close()	;
    		} catch (Exception e2) {
    		}
    		
    		
    	}
    	return rs;
    	
    	
    }
}

