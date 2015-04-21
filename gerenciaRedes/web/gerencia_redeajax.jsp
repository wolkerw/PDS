<%@page import="com.Dispositivo"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.Teste"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Iterator"%>
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
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/x-json; charset=UTF-8"%>
<%
    response.setContentType("text/x-json; charset=UTF-8");
    response.setDateHeader("Expires", 0);
    response.setDateHeader("Last-Modified", new java.util.Date().getTime());
    response.setHeader("Cache-Control", "no-cache, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
    NumberFormat df = new DecimalFormat("###,##0.00", dfs);
    Connection conn = null;
    JSONObject objRetorno = new JSONObject();
    try {
        String cmd = request.getParameter("cmd");
        if (cmd.equalsIgnoreCase("listaips")) {
            JSONArray maquinas = new JSONArray();
            for (String key : Teste.Maquinas.keySet()) {
                Dispositivo maquina = (Dispositivo) Teste.Maquinas.get(key);
                JSONObject maq = new JSONObject();

                maq.put("ip", maquina.getIp());
                maq.put("nome", maquina.getNome());

                JSONArray portas = new JSONArray();
                for (String porta : maquina.getPortasabertas().keySet()) {
                    portas.add(porta);
                }
                maq.put("portas", portas);
                maquinas.add(maq);
            }

            objRetorno.put("maquinas", maquinas);
            out.print(objRetorno.toJSONString());
        } else if (cmd.equalsIgnoreCase("getinterfaces")) {

            ArrayList interfaces = Teste.getInterfaces();
            objRetorno.put("interfaces", interfaces);
            out.print(objRetorno.toJSONString());

        } else if (cmd.equalsIgnoreCase("setinterfaces")) {
            String ip = request.getParameter("ip") != null ? request.getParameter("ip") : "";

            if (!ip.equalsIgnoreCase("")) {
                Teste.setHost(ip);
            }

            objRetorno.put("ok", "Host definido.");
            out.print(objRetorno.toJSONString());
        } else if (cmd.equalsIgnoreCase("calculatempoip")) {

            String ip = request.getParameter("ip") != null ? request.getParameter("ip") : "";
            String iteracoes = request.getParameter("iteracoes") != null ? request.getParameter("iteracoes") : "";

            if (!ip.equalsIgnoreCase("") && !(iteracoes.equalsIgnoreCase(""))) {
                objRetorno = Teste.calculaTempomedio(ip, Long.parseLong(iteracoes));
            } else {
                objRetorno.put("erro", "Defina todos os campos");
            }

            out.print(objRetorno.toJSONString());
        } else if (cmd.equalsIgnoreCase("setpingarede")) {

            String ip = request.getParameter("ip") != null ? request.getParameter("ip") : "";
            String iteracoes = request.getParameter("iteracoes") != null ? request.getParameter("iteracoes") : "";

            if (!ip.equalsIgnoreCase("") && !(iteracoes.equalsIgnoreCase(""))) {
                objRetorno = Teste.calculaTempomedio(ip, Long.parseLong(iteracoes));
            } else {
                objRetorno.put("erro", "Defina todos os campos");
            }

            out.print(objRetorno.toJSONString());
        } else if (cmd.equalsIgnoreCase("setscan")) {



            out.print(objRetorno.toJSONString());
        }

    } catch (Exception ex) {
        objRetorno.put("SITUACAO", "ERRO");
        objRetorno.put("msg", ex.getMessage());
        ex.printStackTrace();
        out.print(objRetorno.toJSONString());

    }

%>