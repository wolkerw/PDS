<%@page  contentType="text/html; charset=UTF-8"%>
<%@ page
	import="com.*,java.text.*,java.util.*,java.sql.*,java.io.*,java.lang.*"
	errorPage="erro.jsp"%>
<jsp:useBean id="oUt" scope="session" class="com.Utilitario" />
<HTML>
<HEAD>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="stl_padrao.css" rel="stylesheet" type="text/css">
<meta http-equiv="Pragma" content="no-cache">

<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/autoNumeric.1.9.22.js" charset="utf-8"></script>
<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.mask.min.js"></script>
<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.blockUI.js"></script>  
<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquerydatepicker-ptbr.js"></script>
<script type="text/javascript" src="JavaScript/jquery-ui-1.10.4.custom/js/jquery.dataTables.js" charset="utf-8" language="javascript"></script>
<link rel="stylesheet" type="text/css" href="JavaScript/jquery-ui-1.10.4.custom/css/ui-blitz/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="JavaScript/jquery-ui-1.10.4.custom/css/jquery.dataTables.css" />
<script type="text/javascript" src="JavaScript/bootbox.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="JavaScript/bootstrap-3.2.0-dist/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="JavaScript/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="JavaScript/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script src="JavaScript/jquery.modern-blink.js"></script>

<style type="text/css">
<!--
.style1 {
	color: #FFFFFF
}

.campo {
	width: 300px;
}
-->
</style>
<%
	session.invalidate();
	String strLogo = "logo.png";
	if (new File(application.getRealPath("/img/logo_teste.jpg"))
			.exists()) {
		strLogo = "logo_teste.jpg";
		// teste commit
	}
%>
</head>
</HEAD>
<BODY>
	<form name="form" method="post" action="">
		<TABLE align="center" cellSpacing=0 cellPadding=0 width="35%" border=0>
			<TR>
				<TD align="center">
					<br/>
					<P>
						<img width="300" src="imagens/<%=strLogo%>"></img>
					</P>
					<br/>
					<!-- <P class="clsFontes">
						<font size="4" color="#003399"><strong></strong>
						</font>
					</P> -->
					</TD>
			</TR>
			<TR>
				<TD align="middle" class="clsFontes">
					<h1>Login</h1>
					<form action="frmUsuario_login.jsp">
						<table border="0" cellpadding="0" cellspacing="0" width="310">
							<tr>
								<td>
									<div class="form-group">
										<label for="txtLG_USUARIO">Usuário:</label>
										<input id="txtLG_USUARIO" type="text" class="form-control campo" placeholder="Digite o usuário" name="txtLG_USUARIO">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="form-group">
										<label for="txtVL_SENHA">Senha:</label>
										<input id="txtVL_SENHA" type="password" class="form-control campo" placeholder="Digite a senha" name="txtVL_SENHA" onKeypress="if (event.keyCode==13) {  form.action='frmUsuario_login.jsp'; form.submit();}">
									</div>
								</td>
							</tr>
	
							<tr>
								<td colspan="100%" align="center">
									<button type="submit" class="btn btn-default" OnClick="form.action='frmUsuario_login.jsp'; form.submit();">Logar</button>
								</td>
							</tr>
						</table>
					</form>
				</TD>
			</TR>
			<TR>
				<TD></TD>
			</TR>
		</TABLE>
	</form>
</BODY>
<script language="JScript">
	document.form['txtLG_USUARIO'].focus();
</script>
</HTML>