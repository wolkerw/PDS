<%@page  contentType="text/html; charset=UTF-8"%>
<%@ page
	import="com.*,java.text.*,java.util.*,java.sql.*,java.io.*,java.lang.*"
	errorPage="erro.jsp"%>
<jsp:useBean id="oUt" scope="session" class="com.Utilitario" />


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