<%@ page import="model.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<title>Teste Produtos</title>
</head>
<body>
	<div class="container-md">
	<%
		String idProduto = request.getParameter("idPoduto");
		String fabricante = request.getParameter("fabricante");
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String idCategoria = request.getParameter("idCategoria");
		String descricao = request.getParameter("descricao");
		String unidadeMedida = request.getParameter("unidadeMedida");
		String largura = request.getParameter("largura");
		String altura = request.getParameter("altura");
		String profundidade = request.getParameter("profundidade");
		String peso = request.getParameter("peso");
		String cor = request.getParameter("cor");
		
		String acao = request.getParameter("acao");
		
		if((acao != null) && (idProduto != null)){
			Produto prod = new Produto(idProduto,fabricante,nome,marca,modelo,idCategoria,descricao,unidadeMedida,largura,altura,profundidade,peso,cor);
			
		if(Integer.valueOf(acao) == 1){
			prod.save();
		}else if(Integer.valueOf(acao) == 2){
			prod.delete();	
			}
		}
		
		String saida = new Produto().listAll();
		response.getWriter().write(saida);
	%>
	</div>
	<br><br>
	<div class="container pl-8 pt-5 mt-4 bg-primary">  
		<div class="col-md-auto">
		<div class="row-md-auto">
		<form action="testeProdutos.jsp" method="POST" class="form-horizontal" id="formProdutos">
			<h3 class="text-align">Cadastro de Produtos</h3>
  			<div class="form-group ma-3">
  				<label for="idProduto">Identificação do Produto </label>
  			 	<input type="text" id="idProduto" name="idProduto" placeholder="Enter idProduto" class="form-control">  		
 			</div>
	 		<div class="form-group ma-3">
	 			<label for="fabricante">Fabricante</label> 
	 			<input type="text" id="fabricante" name="fabricante" placeholder="Enter fabricante" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="nome">Nome</label>
				<input type="text" id="nome" name="nome" placeholder="Enter nome" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="marca">Marca</label>
				<input type="text" id="marca" name="marca" placeholder="Enter marca" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="modelo">Modelo</label>
				<input type="text" id="modelo" name="modelo" placeholder="Enter modelo" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="idCategoria">Identificação Categoria</label>
					<select  id="idCategoria" name="idCategoria" size="1" class="form-control">
						<option value="1">Smartphone</option>
						<option value="2">Eletrônicos</option>
						<option value="3">Notebooks</option>
						<option value="4">Video Games</option>
						<option value="5">Escritório</option>
						<option value="6">Livros</option>
						<option value="7">Acessórios</option>
						<option value="8">Televisores</option>
					</select>
			</div>
			<div class="form-group ma-3">
				<label for="descricao">Descrição</label>
				<input type="text" id="descricao" name="descricao" placeholder="Enter descricao" class="form-control">
			</div> 
			<div class="form-group ma-3">
				<label for="unidadeMedida">Unidade de Medida</label>
					<select  id="unidadeMedida" name="unidadeMedida" size="1" class="form-control">
						<option value="centimetro">centímetros</option>
						<option value="metros">metros</option>
						<option value="polegadas">polegadas</option>
						<option value="milimetros">milimetros</option>
					</select>
			</div>
				<div class="form-group ma-3">
					<label for="largura">Largura</label>
					<input type="number" id="largura" name="largura" placeholder="Enter largura" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="altura">Altura</label>
				<input type="number" id="altura" name="altura" placeholder="Enter altura" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="profundidade">Profundidade</label>
				<input type="number" id="profundidade" name="profundidade" placeholder="Enter profundidade" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="peso">Peso</label>
				<input type="number" id="peso" name="peso" placeholder="Enter peso" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="cor">Cor</label>
				<input type="text" id="cor" name="cor" placeholder="Enter cor" class="form-control">
			</div>
			<input type="hidden" id="acao" name="acao" value="0">
			
			<button type="button" id="btnProduto" class="btn btn-success" onclick="acao.value='1'; this.form.submit();">Salvar</button>
			<button type="button" id="btnProduto" class="btn btn-danger" onclick="acao.value='2'; this.form.submit();">Excluir</button>
		</form>
		</div>
		</div>
	</div>

</body>
</html>