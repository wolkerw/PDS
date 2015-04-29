<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista pessoas</title>

        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/autoNumeric.1.9.22.js" charset="utf-8"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.blockUI.js"></script>  
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquerydatepicker-ptbr.js"></script>
        <script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.dataTables.js" charset="utf-8" language="javascript"></script>
        
        <link rel="stylesheet" type="text/css" href="JavaScript/jquery-ui-1.10.4.custom/css/jquery.dataTables.css" />
        <link rel="stylesheet" type="text/css" href="JavaScript/jquery-ui-1.10.4.custom/css/ui-blitz/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="css/styles.css" />
        
        <script type="text/javascript" src="JavaScript/bootbox.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="JavaScript/bootstrap-3.2.0-dist/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="JavaScript/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="JavaScript/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
        <script src="JavaScript/jquery.modern-blink.js"></script>
    </head>
    <body>
    
    <div class="container">
    <%if (session.getAttribute("usuario")!=null){%>
    	<div class="btn-group" role="group" aria-label="...">
		  <button type="button" class="btn btn-default" onclick="document.location.href='cad_agendamento.jsp';"><a href="cad_agendamento.jsp" title="Início">Agendar</a></button>
		  <button type="button" class="btn btn-default" onclick="document.location.href='lista_agendamentos.jsp';"><a href="lista_agendamentos.jsp" title="Agendamentos">Meus Agendamentos</a></button>
		  	<%if(session.getAttribute("usuario")!=null && session.getAttribute("tipo").toString().equalsIgnoreCase("AD")){%>
		  		<button type="button" class="btn btn-default" onclick="document.location.href='listapessoa.jsp';"><a href="listapessoa.jsp" title="Listar Usuários">Listar Usuários</a></button>
		  	<%}%>
		  	<%if(session.getAttribute("usuario")!=null && session.getAttribute("tipo").toString().equalsIgnoreCase("AD")){%>
		  		<button type="button" class="btn btn-default" onclick="document.location.href='cadastro_pessoa.jsp';"><a href="cadastro_pessoa.jsp" title="Cadastrar usuário">Cadastrar usuario</a></button>
		  	<%}else if (session.getAttribute("usuario")!=null){%>
		  		<button type="button" class="btn btn-default" onclick="document.location.href='cadastro_pessoa.jsp';"><a href="cadastro_pessoa.jsp?id=<%=session.getAttribute("usuario")%>" title="Cadastrar usuário">Meus dados</a></button>
		  	<%}%>

		  
		  <button type="button" class="btn btn-default" onclick="document.location.href='index.jsp';"><a href="index.jsp" title="Sair">Sair</a></button>
		  <!-- <div class="btn-group" role="group">
		    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
		      Dropdown
		      <span class="caret"></span>
		    </button>
		    <ul class="dropdown-menu" role="menu">
		      <li><a href="#">Dropdown link</a></li>
		      <li><a href="#">Dropdown link</a></li>
		    </ul>
		  </div>
		</div> -->
	<% } else { %>
		<button type="button" class="btn btn-default" onclick="document.location.href='index.jsp';"><a href="index.jsp" title="Login">Login</a></button>
	<% } %>
	</div> 
	<div style="clear: both"></div><br/>