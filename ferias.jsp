<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>RhWeb</title>
	<link rel="stylesheet" href="<s:url value="/css/rhweb.css" />" type="text/css">
	<link rel="stylesheet" type="text/css" href="<s:url value="/css/jquery-calendar.css" />" />
	
	<script type="text/javascript" src="<s:url value="/js/jquery.js" />"></script>
    <script type="text/javascript" src="<s:url value="/js/jquery-calendar.js" />"></script>	
	<script src="<s:url value="/js/util.js"/>" type="text/javascript"></script>
	<script src="/includes/js/ajax.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(document).ready(function () {
				$('.calendarBoth').calendar({autoPopUp: 'both', buttonImageOnly: true, 
					buttonImage: '/rhweb2/imagens/calendar.gif', buttonText: 'Calendario'});
		
		});
		    
		function carregarNomeServidor(){
			var	mat = document.getElementById("servidor.matricula").value;
			Ajax.carregar("nomeservidor","<s:url action="carregarnomeservidor" />?servidor.matricula="+mat);
		}
		function carregarFerias(){
			var	mat = document.getElementById("servidor.matricula").value;
			Ajax.carregar("listaFerias","<s:url namespace="/ferias" action="carregarFerias" />?servidor.matricula="+mat);
		}
		function buscar(){
			var mat = document.getElementById("servidor.matricula");
			var cod = document.getElementById("servidor.codigo");
			if(mat.value==""){
				alert("O campo 'Matricula' deve ser preenchido!");
				mat.focus();
			}else if(isNaN(mat.value)==true){
				alert("O campo 'Matrícula' deve conter apenas números!");
				mat.focus();
			}else{
				Ajax.carregar("listaFerias","<s:url namespace="/ferias" action="buscarferias" />?servidor.codigo="+cod.value);
			}
		}
		function novo(){
			var mat = document.getElementById("servidor.matricula");
			var cod = document.getElementById("servidor.codigo");
			if(cod == null){
				alert("Você deve buscar o servidor antes de cadastrar novas férias!");
			}else if(mat.value==""){
				alert("O campo 'Matricula' deve ser preenchido!");
				mat.focus();
			}else{
				window.location="<s:url namespace="/ferias" action="novo" />?servidor.matricula="+mat.value+"&servidor.codigo="+cod.value;				
			}
		}
		function exibirLink(cod){
			window.location="<s:url namespace="/ferias" action="exibir" />?ferias.codigo="+cod;
		}
		function excluir(cod,codservidor,dataInicio,competencia){
			if(confirm("Deseja realmente excluir essas férias? Data Inicio:"+dataInicio+"; Competência: "+competencia)){
				Ajax.carregar("listaFerias","<s:url namespace="/ferias" action="excluir" />?ferias.codigo="+cod+"&ferias.servidor.codigo="+codservidor);
			}
		}
		function imprimir(cod){
			window.open("<s:url namespace="/ferias" action="printcomunicacaoferias" />?ferias.codigo="+cod);
		}
		function limpaMatricula(){
			document.getElementById("servidor.matricula").value = "";	
		}
		function atualizaListaLicencas(cod){
			Ajax.carregar("listaFerias","<s:url namespace="/ferias" action="buscarferias" />?servidor.codigo="+cod);	
		}
	</script>
</head>
<body onload="limpaMatricula();">
	<div style="color: blue"><s:actionmessage /></div>
	<div style="color: red"><s:actionerror /></div>
	<form method="get" action="">
		<table class="tbform">
			<caption>Controle de Ferias</caption>
			<tr>
				<td class="inputLabel">Matrícula:</td>
				<td><input type="text" id="servidor.matricula" name="servidor.matricula" onkeypress="mascara(this,soNumeros)" onblur="carregarNomeServidor()"/>sem o dígito
				<br /><div id="nomeservidor"></div></td>
			</tr>
			<tr>
				<td colspan="3" align="right"><input class="botao" type="button" value="Buscar" onclick="buscar();"/></td>
			</tr>
		</table>
	</form>	
	<div style="font-size: 10pt;">Clique <a class="link" href="javascript:void(0)" onclick="novo()">aqui</a> para cadastrar novas férias.</div>	
	<br />
	<div id="listaFerias"></div>
</body>
</html>