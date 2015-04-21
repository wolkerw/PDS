<%@ page pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%//codeGenVersion 2.0.72%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerência de Redes (Trab.)</title>

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
    </head>
    <body>
        <div id="main_navbar" class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main_navbar_items">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" title="Alunos">Alunos</a>
                </div>
                <div id="main_navbar_items" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a title="Charles">Charles Augusto Goettert</a></li>
                        <li class="active"><a title="Charles">Fernando Schmitt</a></li>
                        <li class="active"><a title="Charles">Gabriel Dalcin Kothe</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="page-header">
                <div class="clearfix">
                    <div class="col-md-8 col-sm-6 col-xs-12">
                        <h1>Gerencia de Redes <small>Trabalho.</small></h1>
                    </div>
                </div>
            </div>
        </div>
        <br>     
        <div class="clearfix">
            <div class="container">
                <div class="row">
                    <form name="form" id="form" class="form-horizontal" role="form" onsubmit="return false;"> 
                        <div id="tab">
                            <div class="form-group">
                                <label for="lista_ips" class="col-sm-2 control-label">Ips</label>
                                <div class="col-sm-4">
                                    <select class="form-control" onchange="setiplocal(this.options[this.selectedIndex].value)" id="lista_ips"></select>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-4">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h4 class="text-center">Atualizar Dados</h4>
                                </div>
                                <div class="panel-footer">
                                    <a onclick="atualizadados();" class="btn btn-lg btn-block btn-primary btn_dados"><i class="glyphicon glyphicon-refresh"></i>&nbsp;Atualizar</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h4 class="text-center">Varredura de Máquinas.</h4>
                                </div>
                                <div class="panel-footer">
                                    <a class="btn btn-lg btn-block btn-success btn_comecar" onclick="scan(true);"><i class="glyphicon glyphicon-play"></i>&nbsp;<span id="textoComecando">Começar</span></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h4 class="text-center">Varredura de Máquinas.</h4>
                                </div>
                                <div class="panel-footer">
                                    <a class="btn btn-lg btn-block btn-danger btn_parar" onclick="scan(false);"><i class="glyphicon glyphicon-stop"></i>&nbsp;Parar</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container bs-docs-container">
            <div class="row">
                <div id="divTab" class="bs-example"  style="height: 400px;  overflow-y: scroll;">
                    <table id="maquinasTab" class="table table-bordered table-hover table-condensed">
                        <thead>
                            <tr>
                                <th style="text-align: center; width: 5%">#</th>
                                <th style="text-align: center; width: 20%">Ip</th>
                                <th style="text-align: center; width: 20%">Nome</th>
                                <th style="text-align: center; width: 45%">Porta</th>
                                <th style="text-align: center; width: 10%">Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="active">
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            jQuery(function($) {
                $("#code").html("&lt;div class=&quot;container&quot;&gt;\r\n    &lt;div class=&quot;row&quot;&gt;\r\n        &lt;div class=&quot;col-xs-12&quot;&gt;\r\n            &lt;div class=&quot;text-center&quot;&gt;\r\n                &lt;i class=&quot;fa fa-search-plus pull-left icon&quot;&gt;&lt;/i&gt;\r\n                &lt;h2&gt;Invoice for purchase #33221&lt;/h2&gt;\r\n            &lt;/div&gt;\r\n            &lt;hr&gt;\r\n            &lt;div class=&quot;row&quot;&gt;\r\n                &lt;div class=&quot;col-xs-12 col-md-3 col-lg-3 pull-left&quot;&gt;\r\n                    &lt;div class=&quot;panel panel-default height&quot;&gt;\r\n                        &lt;div class=&quot;panel-heading&quot;&gt;Billing Details&lt;/div&gt;\r\n                        &lt;div class=&quot;panel-body&quot;&gt;\r\n                            &lt;strong&gt;David Peere:&lt;/strong&gt;&lt;br&gt;\r\n                            1111 Army Navy Drive&lt;br&gt;\r\n                            Arlington&lt;br&gt;\r\n                            VA&lt;br&gt;\r\n                            &lt;strong&gt;22 203&lt;/strong&gt;&lt;br&gt;\r\n                        &lt;/div&gt;\r\n                    &lt;/div&gt;\r\n                &lt;/div&gt;\r\n                &lt;div class=&quot;col-xs-12 col-md-3 col-lg-3&quot;&gt;\r\n                    &lt;div class=&quot;panel panel-default height&quot;&gt;\r\n                        &lt;div class=&quot;panel-heading&quot;&gt;Payment Information&lt;/div&gt;\r\n                        &lt;div class=&quot;panel-body&quot;&gt;\r\n                            &lt;strong&gt;Card Name:&lt;/strong&gt; Visa&lt;br&gt;\r\n                            &lt;strong&gt;Card Number:&lt;/strong&gt; ***** 332&lt;br&gt;\r\n                            &lt;strong&gt;Exp Date:&lt;/strong&gt; 09/2020&lt;br&gt;\r\n                        &lt;/div&gt;\r\n                    &lt;/div&gt;\r\n                &lt;/div&gt;\r\n                &lt;div class=&quot;col-xs-12 col-md-3 col-lg-3&quot;&gt;\r\n                    &lt;div class=&quot;panel panel-default height&quot;&gt;\r\n                        &lt;div class=&quot;panel-heading&quot;&gt;Order Preferences&lt;/div&gt;\r\n                        &lt;div class=&quot;panel-body&quot;&gt;\r\n                            &lt;strong&gt;Gift:&lt;/strong&gt; No&lt;br&gt;\r\n                            &lt;strong&gt;Express Delivery:&lt;/strong&gt; Yes&lt;br&gt;\r\n                            &lt;strong&gt;Insurance:&lt;/strong&gt; No&lt;br&gt;\r\n                            &lt;strong&gt;Coupon:&lt;/strong&gt; No&lt;br&gt;\r\n                        &lt;/div&gt;\r\n                    &lt;/div&gt;\r\n                &lt;/div&gt;\r\n                &lt;div class=&quot;col-xs-12 col-md-3 col-lg-3 pull-right&quot;&gt;\r\n                    &lt;div class=&quot;panel panel-default height&quot;&gt;\r\n                        &lt;div class=&quot;panel-heading&quot;&gt;Shipping Address&lt;/div&gt;\r\n                        &lt;div class=&quot;panel-body&quot;&gt;\r\n                            &lt;strong&gt;David Peere:&lt;/strong&gt;&lt;br&gt;\r\n                            1111 Army Navy Drive&lt;br&gt;\r\n                            Arlington&lt;br&gt;\r\n                            VA&lt;br&gt;\r\n                            &lt;strong&gt;22 203&lt;/strong&gt;&lt;br&gt;\r\n                        &lt;/div&gt;\r\n                    &lt;/div&gt;\r\n                &lt;/div&gt;\r\n            &lt;/div&gt;\r\n        &lt;/div&gt;\r\n    &lt;/div&gt;\r\n    &lt;div class=&quot;row&quot;&gt;\r\n        &lt;div class=&quot;col-md-12&quot;&gt;\r\n            &lt;div class=&quot;panel panel-default&quot;&gt;\r\n                &lt;div class=&quot;panel-heading&quot;&gt;\r\n                    &lt;h3 class=&quot;text-center&quot;&gt;&lt;strong&gt;Order summary&lt;/strong&gt;&lt;/h3&gt;\r\n                &lt;/div&gt;\r\n                &lt;div class=&quot;panel-body&quot;&gt;\r\n                    &lt;div class=&quot;table-responsive&quot;&gt;\r\n                        &lt;table class=&quot;table table-condensed&quot;&gt;\r\n                            &lt;thead&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td&gt;&lt;strong&gt;Item Name&lt;/strong&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;&lt;strong&gt;Item Price&lt;/strong&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;&lt;strong&gt;Item Quantity&lt;/strong&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-right&quot;&gt;&lt;strong&gt;Total&lt;/strong&gt;&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                            &lt;/thead&gt;\r\n                            &lt;tbody&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td&gt;Samsung Galaxy S5&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;$900&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;1&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-right&quot;&gt;$900&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td&gt;Samsung Galaxy S5 Extra Battery&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;$30.00&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;1&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-right&quot;&gt;$30.00&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td&gt;Screen protector&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;$7&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-center&quot;&gt;4&lt;/td&gt;\r\n                                    &lt;td class=&quot;text-right&quot;&gt;$28&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td class=&quot;highrow&quot;&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;highrow&quot;&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;highrow text-center&quot;&gt;&lt;strong&gt;Subtotal&lt;/strong&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;highrow text-right&quot;&gt;$958.00&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td class=&quot;emptyrow&quot;&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;emptyrow&quot;&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;emptyrow text-center&quot;&gt;&lt;strong&gt;Shipping&lt;/strong&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;emptyrow text-right&quot;&gt;$20&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                                &lt;tr&gt;\r\n                                    &lt;td class=&quot;emptyrow&quot;&gt;&lt;i class=&quot;fa fa-barcode iconbig&quot;&gt;&lt;/i&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;emptyrow&quot;&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;emptyrow text-center&quot;&gt;&lt;strong&gt;Total&lt;/strong&gt;&lt;/td&gt;\r\n                                    &lt;td class=&quot;emptyrow text-right&quot;&gt;$978.00&lt;/td&gt;\r\n                                &lt;/tr&gt;\r\n                            &lt;/tbody&gt;\r\n                        &lt;/table&gt;\r\n                    &lt;/div&gt;\r\n                &lt;/div&gt;\r\n            &lt;/div&gt;\r\n        &lt;/div&gt;\r\n    &lt;/div&gt;\r\n&lt;/div&gt;\r\n\r\n&lt;style&gt;\r\n.height {\r\n    min-height: 200px;\r\n}\r\n\r\n.icon {\r\n    font-size: 47px;\r\n    color: #5CB85C;\r\n}\r\n\r\n.iconbig {\r\n    font-size: 77px;\r\n    color: #5CB85C;\r\n}\r\n\r\n.table &gt; tbody &gt; tr &gt; .emptyrow {\r\n    border-top: none;\r\n}\r\n\r\n.table &gt; thead &gt; tr &gt; .emptyrow {\r\n    border-bottom: none;\r\n}\r\n\r\n.table &gt; tbody &gt; tr &gt; .highrow {\r\n    border-top: 3px solid;\r\n}\r\n&lt;/style&gt;\r\n");
            });
        </script>


        <div id="footer" style="margin-top:50px; padding-top:20px; padding-bottom:30px;">
            <div class="container">
                <div class="col-md-6">
                    <span class="pull-right">Copyright © 2014</span>
                </div>
            </div>
        </div>
        <div class="sharing-container hidden-xs"><div class="sharing-item sharing-fb"><div class="sharing-img"></div></div><div class="sharing-item sharing-gp"><div class="sharing-img"></div></div><div class="sharing-item sharing-tw"><div class="sharing-img"></div></div><div class="sharing-item sharing-li"><div class="sharing-img"></div></div></div><span><span style="display: none;"></span><ul class="sui-listbox sui-autocomplete" tabindex="0" style="width: 198px; display: none; top: 36px; left: 1026.5px;"></ul></span></body>
    <script type="text/javascript" src="JavaScript/gerenciaRedes.js"></script>
</html>
