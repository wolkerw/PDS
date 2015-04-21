

$(document).ready(function() {
    getlistainterfaces();
    $("#divTab").hide();
});

function scan(run_stop) {
    if ($("#lista_ips").val() !== "0") {
        if (run_stop === true) {
            $('.btn_comecar').modernBlink();
            $("#textoComecando").text("Scaneando...")
        } else {
            $('.btn_comecar').modernBlink('stop');
            $("#textoComecando").text("Começar")
        }
        $.ajax({
            type: "POST",
            url: "gerencia_redeajax.jsp",
            dataType: "json",
            async: false,
            data: {cmd: 'setscan', run_stop: run_stop},
            success: function(data) {
            },
            error: function(msg) {
                bootbox.alert("Erro: " + msg);
            }
        });
    } else {
        bootbox.alert("Escolha uma Interface");
    }
}

function setiplocal(ip) {
    if (ip !== "0") {
        $.ajax({
            type: "POST",
            url: "gerencia_redeajax.jsp",
            dataType: "json",
            async: false,
            data: {cmd: 'setinterfaces', ip: ip},
            success: function(data) {
            },
            error: function(msg) {
                bootbox.alert("Erro: " + msg);
            }
        });
    } else {
        bootbox.alert("Escolha uma Interface");
    }
}

function calculatempoip(ip, iteracoes) {
    if (ip !== "0" && iteracoes !== "0") {
        $.ajax({
            type: "POST",
            url: "gerencia_redeajax.jsp",
            dataType: "json",
            async: false,
            data: {cmd: 'calculatempoip', ip: ip, iteracoes: iteracoes},
            success: function(data) {
                data;
            },
            error: function(msg) {
                bootbox.alert("Erro: " + msg);
            }
        });
    } else {
        bootbox.alert("Escolha uma Interface");
    }
}

function getlistainterfaces() {
    var combo = $("#lista_ips");
    $.ajax({
        type: "POST",
        url: "gerencia_redeajax.jsp",
        dataType: "json",
        async: false,
        data: {cmd: 'getinterfaces'},
        success: function(data) {
            var option = '<option value="0">Escolha a Interface</option>';
            for (var x = 0; x < data.interfaces.length; x++) {
                option += '<option value="' + data.interfaces[x] + '">' + data.interfaces[x] + '</option>';
            }
            combo.append(option);
        },
        error: function(msg) {
            bootbox.alert("Erro: " + msg.erro);
        }
    });
}

function atualizadados() {
    if ($("#lista_ips").val() !== "0") {
        var tabela = $("#maquinasTab tbody");
        var count = 1;
        $.ajax({
            type: "POST",
            url: "gerencia_redeajax.jsp",
            dataType: "json",
            async: false,
            data: {cmd: 'listaips'},
            success: function(data) {
                tabela = "";
                for (var x = 0; x < data.maquinas.length; x++) {
                    tabela = tabela + ("<tr>");
                    tabela = tabela + ("<td>" + count + "</td>");
                    tabela = tabela + ("<td>" + data.maquinas[x].ip + "</td>");
                    tabela = tabela + ("<td>" + data.maquinas[x].nome + "</td>");
                    tabela = tabela + ("<td>");
                    tabela = tabela + ("<div class='btn-toolbar' role='toolbar'>");
                    tabela = tabela + ("<div class='btn-group btn-group'>");
                    for (var a = 0; a < data.maquinas[x].portas.length; a++) {
                        tabela = tabela + ("<button style='height: 30px; width: 100px;' type='button' class='btn btn-default'><span style'text-align: left' class='glyphicon glyphicon-home'> " + data.maquinas[x].portas[a] + "</span></button>");
                    }
                    tabela = tabela + ("</div>");
                    tabela = tabela + ("</div>");
                    tabela = tabela + ("</td>");
                    tabela = tabela + ("<td><a class='btn btn-info' onclick=''><i class='glyphicon glyphicon-flash'></i>&nbsp;Ação</a></td>");
                    tabela = tabela + ("</tr>");
                    count++;
                }
                $("#maquinasTab tbody").html(tabela);
                if (count > 1) {
                    $("#divTab").show();
                } else {
                }
            },
            error: function(msg) {
                bootbox.alert("Erro: " + msg.erro);
            }
        });
    } else {
        bootbox.alert("Escolha uma Interface");
    }
}