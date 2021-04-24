package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class Institucional {
	
	private int 	idInstituicao;
	private String 	nome;
	private String 	cpf_cnpj;
	private char 	tipoPessoa;
	private String 	endereco;
	private String 	bairro;
	private String 	cidade;
	private String 	uf;
	private String 	cep;
	private String 	telefone;
	private String 	email;
	private String 	logo;
	
	private String 	tableName = "";
	private String 	fieldsName = "";
	private String 	keyField = "";
	private DBQuery dbQuery = null;
	
	public Institucional() {
		
		this.tableName = "institucional";
		this.fieldsName = "idInstituicao, nome, cpf_cnpj, tipoPessoa, endereco, bairro, cidade, uf, cep, telefone, email, logo";
		this.keyField = "idInstituicao";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	

	public Institucional(int idInstituicao, String nome, String cpf_cnpj, char tipoPessoa, String endereco,
			String bairro, String cidade, String uf, String cep, String telefone, String email, String logo) {
		

		this.tableName = "institucional";
		this.fieldsName = "idInstituicao, nome, cpf_cnpj, tipoPessoa, endereco, bairro, cidade, uf, cep, telefone, email, logo";
		this.keyField = "idInstituicao";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.idInstituicao = idInstituicao;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.tipoPessoa = tipoPessoa;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.logo = logo;
	}

	public String[] toArray() {
		return(new String[] {
			""+this.getIdInstituicao(),
			""+this.getNome(),
			""+this.getCpf_cnpj(),
			""+this.getTipoPessoa(),
			""+this.getEndereco(),
			""+this.getBairro(),
			""+this.getCidade(),
			""+this.getUf(),
			""+this.getCep(),
			""+this.getTelefone(),
			""+this.getEmail(),
			""+this.getLogo()
			});
	}
	
	public void save() {
		if(this.getIdInstituicao() == 0) {
			this.dbQuery.insert(this.toArray());
		}else {
			this.dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if(this.getIdInstituicao() > 0) {
			this.dbQuery.delete(this.toArray());
		}
	}
	
	public String listAll() {
		ResultSet rs = this.dbQuery.select("");
		String saida = "<br>";
		saida += "<table border=1>";
		try {
			while(rs.next()) {
				saida += "<tr>";
				saida += "<td>" + rs.getString("idInstituicao") + "</td>";
				saida += "<td>" + rs.getString("nome") + "</td>";
				saida += "<td>" + rs.getString("cpf_cnpj") + "</td>";
				saida += "<td>" + rs.getString("tipoPessoa") + "</td>";
				saida += "<td>" + rs.getString("endereco") + "</td>";
				saida += "<td>" + rs.getString("bairro") + "</td>";
				saida += "<td>" + rs.getString("cidade") + "</td>";
				saida += "<td>" + rs.getString("uf") + "</td>";
				saida += "<td>" + rs.getString("cep") + "</td>";
				saida += "<td>" + rs.getString("telefone") + "</td>";
				saida += "<td>" + rs.getString("email") + "</td>";
				saida += "<td>" + rs.getString("logo") + "</td>";
				saida += "</tr> <br>";
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		saida += "</table>";
		return (saida);
	}
	
	public int getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(int idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
