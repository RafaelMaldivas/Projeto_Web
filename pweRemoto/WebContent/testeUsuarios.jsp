<%@ page import="model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<title>Teste Usuários</title>
</head>	
<body>	
	<div class="container-md">
	
	<%
		
		String idUsuario = request.getParameter("idUsuario");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String idNivelUsuario = "1";
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		String telefone = request.getParameter("telefone");
		String foto = request.getParameter("foto");
		String ativo = "N";
		
		String acao = request.getParameter("acao");
		
		if((acao != null) && (idUsuario != null)){
			Usuario user = new Usuario(idUsuario,email,senha,idNivelUsuario,nome,cpf,endereco,bairro,cidade,uf,cep,telefone,foto,ativo);
			
		if(Integer.valueOf(acao) == 1){
			user.save();
		}else if(Integer.valueOf(acao) == 2){
			user.delete();	
			}
		}
		
		String saida = new Usuario().listAll();
		response.getWriter().write(saida);
	%>
	
	</div>
	
	<div class="container pl-8 pt-5 mt-4 bg-primary">  
		<div class="col-md-auto">
		<div class="row-md-auto">
		<form action="testeUsuarios.jsp" method="POST" class="form-horizontal" id="formUsuarios">
			<h3>Cadastro de Usuário</h3>
  			<div class="form-group ma-3">
  				<label for="idUsuario">Identificação do Usuário </label>
  			 	<input type="text" id="idUsuario" name="idUsuario" placeholder="Enter idUsuario" class="form-control">  		
 			</div>
	 		<div class="form-group ma-3">
	 			<label for="email">E-mail</label> 
	 			<input type="email" id="email" name="email" placeholder="Enter email" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="senha">Senha</label>
				<input type="password" id="senha" name="senha" placeholder="Enter Senha" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="nome">Nome</label>
				<input type="text" id="nome" name="nome" placeholder="Enter nome" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="cpf">CPF</label>
				<input type="text" id="cpf" name="cpf" placeholder="Enter CPF" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="endereco">Endereço</label>
				<input type="text" id="endereco" name="endereco" placeholder="Enter Endereço" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="bairro">Bairro</label>
				<input type="text" id="bairro" name="bairro" placeholder="Enter Bairro" class="form-control">
			</div> 
			<div class="form-group ma-3">
				<label for="cidade">Cidade</label>
				<input type="text" id="cidade" name="cidade" placeholder="Enter Cidade" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="uf">UF</label>
				<select  id="uf" name="uf" size="1" class="form-control">
					<option value="AC">Acre</option>
					<option value="AL">Alagoas</option>
					<option value="AP">Amapá</option>
					<option value="AM">Amazonas</option>
					<option value="BA">Bahia</option>
					<option value="CE">Ceará</option>
					<option value="DF">Distrito Federal</option>
					<option value="ES">Espírito Santa</option>
					<option value="GO">Goiás</option>
					<option value="MA">Maranhão</option>
					<option value="MT">Mato Grosso</option>
					<option value="MS">Mato Grosso do Sul</option>
					<option value="MG">Minas Gerais</option>
					<option value="PA">Pará</option>
					<option value="PR">Paraná</option>
					<option value="PE">Pernambuco</option>
					<option value="PI">Piauí</option>
					<option value="RJ">Rio de Janeiro</option>
					<option value="RN">Rio Grande do Norte</option>
					<option value="RS">Rio Grande do Sul</option>
					<option value="RO">Rondonia</option>
					<option value="RR">Roraima</option>
					<option value="SC">Santa Catarina</option>
					<option value="SP">São Paulo</option>
					<option value="SE">Sergipe</option>
					<option value="TO">Tocantins</option>	 
				</select> 
			</div>
			<div class="form-group ma-3">
					<label for="cep">CEP</label>
					<input type="text" id="cep" name="cep" placeholder="Enter CEP" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="telefone">Telefone</label>
				<input type="text" id="telefone" name="telefone" placeholder="Enter Telefone" class="form-control">
			</div>
			<div class="form-group ma-3">
				<label for="foto">Foto</label>
				<input type="text" id="foto" name="foto" placeholder="Enter Foto" class="form-control">
			</div>
			<input type="hidden" id="acao" name="acao" value="0">
			
			<button type="button" id="btnUsuario" class="btn btn-success" onclick="acao.value='1'; this.form.submit();">Salvar</button>
			<button type="button" id="btnUsuario" class="btn btn-danger" onclick="acao.value='2'; this.form.submit();">Excluir</button>
		</form>
		</div>
		</div>
	</div>
</body>



</html>