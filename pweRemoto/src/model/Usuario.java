package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class Usuario {
	
	private int 	idUsuario;
	private String 	email;
	private String 	senha;
	private int 	idNivelUsuario;
	private String 	nome;
	private String 	cpf;
	private String 	endereco;
	private String 	bairro;
	private String 	cidade;
	private String 	uf;
	private String 	cep;
	private String 	telefone;
	private String 	foto;
	private String 	ativo;
	
	private String tableName = "usuarios";
	private String fieldsName = "idUsuario, email, senha, idNivelUsuario, nome, cpf, endereco, bairro, cidade, uf, cep, telefone,foto, ativo";
	private String keyField = "idUsuario";
	
	private DBQuery dbQuery = null;
	
	public Usuario() {
		
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
	}
	
	public Usuario(String idUsuario, String email, String senha, String idNivelUsuario, String nome, String cpf,
			String endereco, String bairro, String cidade, String uf, String cep, String telefone, String foto,
			String ativo) {
		
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdUsuario((idUsuario==null)?0:Integer.valueOf(idUsuario));
		this.setEmail(email);
		this.setSenha(senha);
		this.setIdNivelUsuario((idNivelUsuario==null)?1:Integer.valueOf(idNivelUsuario));
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setCep(cep);
		this.setTelefone(telefone);
		this.setFoto(foto);
		this.setAtivo(ativo);
	}

	public Usuario(int idUsuario, String email, String senha, int idNivelUsuario, String nome, String cpf,
			String endereco, String bairro, String cidade, String uf, String cep, String telefone, String foto,
			String ativo) {
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdUsuario(idUsuario);
		this.setEmail(email);
		this.setSenha(senha);
		this.setIdNivelUsuario(idNivelUsuario);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setCep(cep);
		this.setTelefone(telefone);
		this.setFoto(foto);
		this.setAtivo(ativo);
	}
	
	
	public String[] toArray() {
		return (
			new String[] {
					""+this.getIdUsuario(),
					""+this.getEmail(),
					""+this.getSenha(),
					""+this.getIdNivelUsuario(),
					""+this.getNome(),
					""+this.getCpf(),
					""+this.getEndereco(),
					""+this.getBairro(),
					""+this.getCidade(),
					""+this.getUf(),
					""+this.getCep(),
					""+this.getTelefone(),
					""+this.getFoto(),
					""+this.getAtivo()
			}
		);
	}
	
	public void save() {
		if((this.getIdUsuario() == 0)) {
			this.dbQuery.insert(this.toArray());
		}else {
			this.dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if(this.getIdUsuario() > 0) {
			this.dbQuery.delete(this.toArray());
		}
	}
	
	public String listAll() {
		ResultSet rs = this.dbQuery.select("");
		String saida = "<br>";
		saida += "<table class='table table-bordered'>"	;
		
		try {
			
			while(rs.next()) {
				saida += "<thead class='thead'>";
				saida += "<tr>";
				saida += "<th scope=\"col\">id</th>";
				saida += "<th scope=\"col\">email</th>";
				saida += "<th scope=\"col\">senha</th>";
				saida += "<th scope=\"col\">idNivelUser</th>";
				saida += "<th scope=\"col\">nome</th>";
				saida += "<th scope=\"col\">cpf</th>";
				saida += "<th scope=\"col\">endereço</th>";
				saida += "<th scope=\"col\">bairro</th>";
				saida += "<th scope=\"col\">cidade</th>";
				saida += "<th scope=\"col\">UF</th>";
				saida += "<th scope=\"col\">CEP</th>";
				saida += "<th scope=\"col\">telefone</th>";
				saida += "<th scope=\"col\">foto</th>";
				saida += "<th scope=\"col\">ativo</th>";
				saida += "</tr>";
				saida += "</thead>";
				saida += "<tr>";
				saida += "<td>" + rs.getString("idUsuario") + "</td>";
				saida += "<td>" + rs.getString("email") + "</td>";
				saida += "<td>" + rs.getString("senha") + "</td>";
				saida += "<td>" + rs.getString("idNivelUsuario") + "</td>";
				saida += "<td>" + rs.getString("nome") + "</td>";
				saida += "<td>" + rs.getString("cpf") + "</td>";
				saida += "<td>" + rs.getString("endereco") + "</td>";
				saida += "<td>" + rs.getString("bairro") + "</td>";
				saida += "<td>" + rs.getString("cidade") + "</td>";
				saida += "<td>" + rs.getString("uf") + "</td>";
				saida += "<td>" + rs.getString("cep") + "</td>";
				saida += "<td>" + rs.getString("telefone") + "</td>";
				saida += "<td>" + rs.getString("foto") + "</td>";
				saida += "<td>" + rs.getString("ativo") + "</td>";
				saida += "</tr> <br>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		saida += "</table>";
		return (saida);
	}
		

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}

	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
	
}
