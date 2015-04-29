package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.funcoes.Email;


public class HC_Lab_agendamento extends Lab_agendamento{
    public HC_Lab_agendamento(){
    }
    
    private static final int qtdidadevagasmax = 7; 
    private static Connection connglob = null;
    private static long codaluno = -1;
    private static Date datainiglob = null;
    
    public static void main(String[] args) {

    	try {
//    		insereAgendamento(3, 8, 2, "13/03/2015", "13/03/2015", 10);

    		carregaTabelaHorarios("12/04/2015");
    		
    		
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
    //select ( EXTRACT(HOUR FROM data_ini) || '-' || EXTRACT(HOUR FROM data_ini)+1)  data_ini,count(cod_aluno),data_ini from lab_agendamento where EXTRACT(HOUR FROM data_ini) = 8 group by data_ini
    
    
    public static ResultSet carregaTabelaHorarios(String data) throws Exception{
    
    	ResultSet rs = null;
    	
      	Connection conn = null;
        try {
        	conn = DBSettings.getConexao();
        	conn.setAutoCommit(false);
        	
        	Date base = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        	GregorianCalendar baseini = new GregorianCalendar();
        	baseini.setTime(base);
        	baseini.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        	
        	GregorianCalendar basefim = new GregorianCalendar();
        	basefim.setTime(base);
        	basefim.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        	
        	String inisql = new SimpleDateFormat("yyyyMMdd").format(baseini.getTime());
        	String fimsql = new SimpleDateFormat("yyyyMMdd").format(basefim.getTime());
    	
    	
        	String sql = ""
        		+ "SELECT   hora, "
        		+ "         Sum(horarios2.segunda) AS segunda, "
        		+ "         Sum(horarios2.terca)   AS terca, "
        		+ "         Sum(horarios2.quarta)  AS quarta, "
        		+ "         Sum(horarios2.quinta)  AS quinta, "
        		+ "         Sum(horarios2.sexta)   AS sexta, "
        		+ "         Sum(horarios2.sabado)  AS sabado "
        		+ "FROM     ( "
        		+ "                  SELECT   horarios.hora, "
        		+ "                           CASE "
        		+ "                                    WHEN horarios.weekday = 1 THEN COALESCE(alunos,0) "
        		+ "                                    ELSE 0 "
        		+ "                           END AS segunda , "
        		+ "                           CASE "
        		+ "                                    WHEN horarios.weekday = 2 THEN COALESCE(alunos,0) "
        		+ "                                    ELSE 0 "
        		+ "                           END AS terca , "
        		+ "                           CASE "
        		+ "                                    WHEN horarios.weekday = 3 THEN COALESCE(alunos,0) "
        		+ "                                    ELSE 0 "
        		+ "                           END AS quarta , "
        		+ "                           CASE "
        		+ "                                    WHEN horarios.weekday = 4 THEN COALESCE(alunos,0) "
        		+ "                                    ELSE 0 "
        		+ "                           END AS quinta , "
        		+ "                           CASE "
        		+ "                                    WHEN horarios.weekday = 5 THEN COALESCE(alunos,0) "
        		+ "                                    ELSE 0 "
        		+ "                           END AS sexta , "
        		+ "                           CASE "
        		+ "                                    WHEN horarios.weekday = 6 THEN COALESCE(alunos,0) "
        		+ "                                    ELSE 0 "
        		+ "                           END AS sabado "
        		+ "                  FROM     ( "
        		+ "                                     SELECT    ( "
        		+ "                                               CASE "
        		+ "                                                         WHEN Extract(dow FROM start) = 0 THEN 'Domingo' "
        		+ "                                                         WHEN Extract(dow FROM start) = 1 THEN 'Segunda' "
        		+ "                                                         WHEN Extract(dow FROM start) = 2 THEN 'Terça' "
        		+ "                                                         WHEN Extract(dow FROM start) = 3 THEN 'Quarta' "
        		+ "                                                         WHEN Extract(dow FROM start) = 4 THEN 'Quinta' "
        		+ "                                                         WHEN Extract(dow FROM start) = 5 THEN 'Sexta' "
        		+ "                                                         WHEN Extract(dow FROM start) = 6 THEN 'Sábado' "
        		+ "                                               END) "
        		+ "                                                         ||' - ' "
        		+ "                                                         || Cast(Extract(day FROM start) AS TEXT) "
        		+ "                                                         ||'/' "
        		+ "                                                         || Cast(Extract(month FROM start) AS TEXT) AS diasemana, "
        		+ "                                               datas.hora, "
        		+ "                                               tab23.alunos, "
        		+ "                                               Extract(dow FROM start) AS weekday "
        		+ "                                     FROM      ( "
        		+ "                                                      SELECT extract(hour FROM generate_series( date '"+inisql+"  01:00' , date '"+fimsql+"  01:00' , '1 hour ' ))  AS hora, "
        		+ "                                                             date_trunc('day', generate_series( date '"+inisql+"  01:00' , date '"+fimsql+"  01:00' , '1 hour ' ) ) AS start ) AS datas "
        		+ "                                     LEFT JOIN "
        		+ "                                               ( "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 7 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 8 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 9 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 10 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 11 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 12 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 13 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 14 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 15 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 16 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 17 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 18 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 19 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 20 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 21 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini "
        		+ "                                                        UNION ALL "
        		+ "                                                        SELECT   ( extract(hour FROM data_ini)) AS hora, "
        		+ "                                                                 count(cod_aluno)               AS alunos, "
        		+ "                                                                 data_ini "
        		+ "                                                        FROM     lab_agendamento "
        		+ "                                                        WHERE    extract(hour FROM data_ini) = 22 "
        		+ "                                                          AND    (flag_staus is null OR flag_staus!='C') "
        		+ "                                                        GROUP BY data_ini ) AS tab23 "
        		+ "                                     ON        date_trunc('day',tab23.data_ini) = datas.start "
        		+ "                                     AND       datas.hora = tab23.hora ) AS horarios "
        		+ "                  WHERE    horarios.weekday !=0 "
        		+ "                  GROUP BY hora, "
        		+ "                           weekday, "
        		+ "                           horarios.alunos, "
        		+ "                           diasemana ) AS horarios2 "
        		+ "GROUP BY hora "
        		+ "ORDER BY hora;";



        System.out.println(sql);
    	
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
    
    
    
    public static String insereAgendamento(long codpessoa, long codprof, long codassunto, String dataini, String datafim, int horaini, String tipousuario) throws Exception{
    	Connection conn = null;
    try {
    	conn = DBSettings.getConexao();
    	conn.setAutoCommit(false);
    	
	   	if (tipousuario.equals("PF")){
	   		
	   	}
   	
		HC_Lab_agendamento agendamento = new HC_Lab_agendamento();
		agendamento.setConnexao(conn);
		agendamento.setInTransaction(true);
    	
    	Date dat_ini = new SimpleDateFormat("dd/MM/yyyy").parse(dataini.trim());
    	Date dat_fim = new SimpleDateFormat("dd/MM/yyyy").parse(datafim.trim());
    	Date dataaux = null;    	
    	DecimalFormat df = new DecimalFormat("00");
    	
    	ResultSet rs = null;
    	
    	while(dat_ini.compareTo(dat_fim)<=0){
    		
    		dataaux = dat_ini;
    		GregorianCalendar auxini = new GregorianCalendar();
    		auxini.setTime(dataaux);
    		auxini.add(Calendar.HOUR, horaini);

    		GregorianCalendar auxfim = new GregorianCalendar();
    		auxfim.setTime(dataaux);
    		auxfim.add(Calendar.HOUR, horaini+1);


    		if (tipousuario.equals("PF")){
    			HC_Lab_agendamento lab = new HC_Lab_agendamento();
    			lab.setInTransaction(true);
    			lab.setConnexao(conn);
    			lab.setOrderBy("data_ini desc");
    			
    			lab.setFiltroIntervalo("1=1");
    			Date dtIni = null;
    			Date dtFim = null;
    			boolean errodata = false;
    			try{
    					dtIni = auxini.getTime();
    			}catch(Exception e){
    				errodata = true;
    			}
    			try{
    					dtFim = auxfim.getTime();
    			}catch(Exception e){
    				errodata = true;
    			}
    			
   				lab.setFiltroIntervalo(lab.getFiltroIntervalo() + " and (flag_staus is null or flag_staus != 'C') ");

    			
    			if(!errodata)
    				lab.setFiltroIntervalo(lab.getFiltroIntervalo() + "  AND Lab_agendamento.data_ini = '"+ new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(dtIni) +"' ");
    			
    			System.out.println(lab.getFiltroIntervalo());
    			
    			lab.setTop("100000");
    			lab.lista();    			
    			
    			while (lab.next()){
    				
    				
    				
    				
    				lab.setSeqagendametno(lab.getRsSeqagendametno());
    				lab.setFlagstaus("C");
    				lab.update();
    
    				connglob = conn;
    			     codaluno = lab.getRsCodaluno();
    			    datainiglob = dtIni;
    			    
    				// ----
    				
    				new Thread(new Runnable() {
    				    public void run() {
    				
    				    	try {
						
    				    		HC_Lab_pessoa usuario = new HC_Lab_pessoa();
        	    				usuario.setConnexao(connglob);
        	    				usuario.setInTransaction(true);
        	    				usuario.setCodpessoa(codaluno);
        	    				usuario.lista();
        	    				usuario.next();
        	    		
        	    				Email email = new Email();
        	    				email.enviaEmail(usuario.getRsDescemail(), "", "Agendamento Cancelado!", "O Agendamento do horário "+new SimpleDateFormat("HH:mm").format(datainiglob)+ 
        	    																" do dia "+new SimpleDateFormat("dd/MM/yyyy").format(datainiglob)+" foi cancelado pois um professor reservou o laboratório!");
        	    		
    				    		
							} catch (Exception e) {
								
								e.printStackTrace();
								// TODO: handle exception
							}
    				    		
    				    	
    				    	//Do whatever
    				    }
    				}).start();
    				
    				
    				
    				
    			}
    			
    		}
    		
    		if (!tipousuario.equals("PF")){ 
	    		rs = conn.createStatement().executeQuery("select count(seq_agendametno) as reservas from lab_agendamento where data_ini = '"+new SimpleDateFormat("yyyyMMdd HH:00:00").format(auxini.getTime())+"'");
	    		if(rs.next()){
	    			if(rs.getInt("reservas")>=qtdidadevagasmax){
	    				throw new Exception("Erro. Horário  " + new SimpleDateFormat("dd/MM/yyyy HH:00:00").format(auxini.getTime() + " está com todas vagas ocupadas"));
	    			}
	    		}
	    		
	    		rs = conn.createStatement().executeQuery("select 1 from lab_agendamento where data_ini = '"+new SimpleDateFormat("yyyyMMdd HH:00:00").format(auxini.getTime())+"' and cod_aluno = " + codpessoa);
	    		
	    		if(rs.next()){
	    				throw new Exception("Erro. O aluno ja possui agendamento no horario  " + new SimpleDateFormat("dd/MM/yyyy HH:00:00").format(auxini.getTime()) + ".");
	    		}
	    		
	    		auxini.add(Calendar.HOUR, -1);
	    		rs = conn.createStatement().executeQuery("select 1 from lab_agendamento where data_ini = '"+new SimpleDateFormat("yyyyMMdd HH:00:00").format(auxini.getTime())+"' and cod_aluno = " + codpessoa);
	    		if(rs.next()){
	    				throw new Exception("Erro. O aluno já possui agendamento no horario anterior  " + new SimpleDateFormat("dd/MM/yyyy HH:00:00").format(auxini.getTime()) + ".");
	    		}
	    		auxini.add(Calendar.HOUR, 1);
    		}    		
    		
    		agendamento.limpaPropriedades();
    		agendamento.limpaPropriedadesRS();
    	
    		if(auxini.get(Calendar.DAY_OF_WEEK)!=1){
    			agendamento.setCodaluno(codpessoa);
	    		agendamento.setCodprofessor(codprof);
	    		agendamento.setCodassunto(codassunto);
	    		agendamento.setDataini(auxini.getTime());
	    		agendamento.setDatafim(auxfim.getTime());
    			if (!tipousuario.equals("PF")){			    		
			    		agendamento.insert();
    			} else {
    				for(int i=0;i<40;i++){
    					agendamento.insert();
    				}
    			}
    		}
    		
    		GregorianCalendar aumenta1dia = new GregorianCalendar();
    		aumenta1dia.setTime(dat_ini);
    		aumenta1dia.add(Calendar.DAY_OF_YEAR, 1);
    		dat_ini = aumenta1dia.getTime();
    		
    	}
    	
    	
    	
    	conn.commit();
	} catch (Exception e) {
		e.printStackTrace();
		conn.rollback();
		try {
			conn.close()	;
			return e.toString();
		} catch (Exception e2) {
			return e2.toString();
		}
		
		
	}
    	
    	return "";
    	
    	
    }
    
}
/*
select hora, 
sum(horarios2.segunda) as segunda,
sum(horarios2.terca) as terca,
sum(horarios2.quarta) as quarta,
sum(horarios2.quinta) as quinta,
sum(horarios2.sexta) as sexta,
sum(horarios2.sabado) as sabado


from (

												select horarios.hora,
													case when horarios.weekday = 1 then Coalesce(alunos,0) else 0 end as segunda ,
													case when horarios.weekday = 2 then Coalesce(alunos,0) else 0 end as terca ,
													case when horarios.weekday = 3 then Coalesce(alunos,0) else 0 end as quarta ,
													case when horarios.weekday = 4 then Coalesce(alunos,0) else 0 end as quinta ,
													case when horarios.weekday = 5 then Coalesce(alunos,0) else 0 end as sexta ,
													case when horarios.weekday = 6 then Coalesce(alunos,0) else 0 end as sabado 


										    		from (

																													 SELECT  (case when EXTRACT(DOW FROM  start) = 0 then 'Domingo'  
																																when EXTRACT(DOW FROM  start) = 1 then 'Segunda' 
																																when EXTRACT(DOW FROM  start) = 2 then 'Terça' 
																																when EXTRACT(DOW FROM  start) = 3 then 'Quarta' 
																																when EXTRACT(DOW FROM  start) = 4 then 'Quinta' 
																																when EXTRACT(DOW FROM  start) = 5 then 'Sexta' 
																																when EXTRACT(DOW FROM  start) = 6 then 'Sábado'	end)||' - ' || cast(EXTRACT(DAY FROM start) as text) ||'/'||   cast(EXTRACT(MONTH FROM start) as text)  as diasemana, datas.hora, tab23.alunos,
																																EXTRACT(DOW FROM  start) as weekday
			
																															 	from (  
			 	
																																										 SELECT  EXTRACT(HOUR FROM  generate_series(
																																										        date '2015-03-02  01:00'
																																										        , date '2015-03-08  01:00'
																																										        , '1 hour '
																																										    ))  as hora,
										

																																						date_trunc('day', 	generate_series(
																																										        current_date
																																										          , date '2015-03-08  01:00'
																																										        , '1 hour '
																																										    ) ) as start
																																      ) as datas

																													left join (
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 7 group by data_ini

																																		  union all
		
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 8 group by data_ini

																													   			 union all
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 9 group by data_ini

																															union all

			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 10 group by data_ini

																															union all


			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 11 group by data_ini

																													union all
   		
   
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 12 group by data_ini


																													   			union all


																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 13 group by data_ini

																													union all
   		
   			 
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 14 group by data_ini



																													   			 union all

			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 15 group by data_ini

																													union all
   			 
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 16 group by data_ini


																													   			 union all

			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 17 group by data_ini

																													union all
   		
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 18 group by data_ini


																													   		union all
   			 
 
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 19 group by data_ini


   		
																													   			    		union all
 
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 20 group by data_ini


																													   			   		union all
   			 
 
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 21 group by data_ini



																													   		union all
	  
			
																																		select ( EXTRACT(HOUR FROM data_ini))  as hora, count(cod_aluno) as alunos,data_ini
																																		 from lab_agendamento
																																		  where EXTRACT(HOUR FROM data_ini) = 22 group by data_ini


																													)  as tab23  on date_trunc('day',tab23.data_ini) = datas.start  	
																															 and datas.hora = tab23.hora


																			) as horarios
   		
																				where horarios.weekday !=0

																				 group by hora,weekday, horarios.alunos,diasemana
 

				) as horarios2

group by hora order by hora;

*/
