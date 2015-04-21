
<%@page import="com.HC_Lab_agendamento"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.sql.ResultSet"%> 
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Locale"%>  
<%@page import="java.text.DecimalFormatSymbols"%>
<%@ page pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.Utilitario"%>
<%@page import="java.text.SimpleDateFormat"%><%@page import="com.DBSettings"%><%@page import="java.util.Date"%><%@page import="java.util.Calendar"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/x-json; charset=UTF-8"%>
<%
	response.setContentType("text/x-json; charset=UTF-8");
	response.setDateHeader("Expires", 0);
	response.setDateHeader("Last-Modified", new java.util.Date()
			.getTime());
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
	NumberFormat df = new DecimalFormat("###,##0.00", dfs);
	Connection conn = null;
	JSONObject objRetorno = new JSONObject();
	try {
		conn = DBSettings.getConexao();
		conn.setAutoCommit(false);
		
		
		
		String cmd = request.getParameter("cmd");
		
	if (cmd.equalsIgnoreCase("cancelar")) {

			String agend = request.getParameter("seqagend") == null ? "" : request.getParameter("seqagend").trim() ;
			
			
			
			HC_Lab_agendamento agendamento = new HC_Lab_agendamento();
			agendamento.setConnexao(conn);
			agendamento.setInTransaction(true);
			agendamento.setSeqagendametno(Integer.parseInt(agend));
			agendamento.lista();
			if(agendamento.next()){
				agendamento.mapGetRsToSet(agendamento,agendamento);
				agendamento.setFlagstaus("C");
				agendamento.update();
			};
		
			objRetorno.put("ok", "ok");
			out.print(objRetorno.toJSONString());
	} else	if (cmd.equalsIgnoreCase("carregapresenca")) { 

		String agend = request.getParameter("seqagend") == null ? "" : request.getParameter("seqagend").trim() ;

		HC_Lab_agendamento agendamento = new HC_Lab_agendamento();
		agendamento.setConnexao(conn);
		agendamento.setInTransaction(true);
		agendamento.setSeqagendametno(Integer.parseInt(agend));
		agendamento.lista();
		if(agendamento.next()){
			objRetorno.put("seq_agendamento", agendamento.getRsSeqagendametno());
			objRetorno.put("flag_presenca",agendamento.getRsFlagpresenca()==null?"A": agendamento.getRsFlagpresenca());
			objRetorno.put("motivo", agendamento.getRsDescmotivo()==null?"":agendamento.getRsDescmotivo());
		};
	
		objRetorno.put("ok", "ok");
		out.print(objRetorno.toJSONString());
	}		
	
	else	if (cmd.equalsIgnoreCase("salvar")) {  

		String agend = request.getParameter("seqagend") == null ? "" : request.getParameter("seqagend").trim() ;
		String desc_motivo = request.getParameter("desc_motivo") == null ? "" : request.getParameter("desc_motivo").trim() ;
		String presen = request.getParameter("presen") == null ? "" : request.getParameter("presen").trim() ;

		HC_Lab_agendamento agendamento = new HC_Lab_agendamento();
		agendamento.setConnexao(conn);
		agendamento.setInTransaction(true);
		agendamento.setSeqagendametno(Integer.parseInt(agend));
		agendamento.lista();
		if(agendamento.next()){
	
			agendamento.mapGetRsToSet(agendamento,agendamento);
			agendamento.setFlagpresenca(presen);
			agendamento.setDescmotivo(desc_motivo);
			agendamento.update();
		};
	
		objRetorno.put("ok", "ok");
		out.print(objRetorno.toJSONString());
	}
	
	
		conn.commit();
		
		
	} catch (Exception ex) {
		objRetorno.put("situacao", "erro");
		if (ex.getMessage() == null || ex.getMessage().equalsIgnoreCase("")) {
			objRetorno.put("msg", "Erro, por favor entrar em contato com suporte.");
		} else {
			objRetorno.put("msg", ex.getMessage());
		}
		ex.printStackTrace();
		out.print(objRetorno.toJSONString());
		try {
			conn.rollback();
		} catch (Exception exr) {}
	} finally {
		try {
			conn.close();
		} catch (Exception ex) {}
	}
%>