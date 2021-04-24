package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class Categoria {
	private int idCategoria;
	private String descricao;
	
	private String 	tableName = "";
	private String 	fieldsName = "";
	private String 	keyField = "";
	private DBQuery dbQuery = null;
	
	public Categoria() {
		this.tableName = "categorias";
		this.fieldsName = "idCategoria,descricao";
		this.keyField = "idCategoria";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	
	public Categoria(int idCategoria, String descricao) {
		
		this.tableName = "categorias";
		this.fieldsName = "idCategoria,descricao";
		this.keyField = "idCategoria";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdCategoria(idCategoria);
		this.setDescricao(descricao);
	}
	
	
	public String[] toArray() {
		return(new String[] {
			""+this.getIdCategoria(),
			""+this.getDescricao(),
			});
	}
	
	public void save() {
		if(this.getIdCategoria() == 0) {
			this.dbQuery.insert(this.toArray());
		}else {
			this.dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if(this.getIdCategoria() > 0) {
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
				saida += "<td>" + rs.getString("idCategoria") + "</td>";
				saida += "<td>" + rs.getString("descricao") + "</td>";
		
				saida += "</tr> <br>";
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		saida += "</table>";
		return (saida);
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
