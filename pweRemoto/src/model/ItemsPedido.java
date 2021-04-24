package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class ItemsPedido {
	
	private int idItemPedido;
	private int ordem;
	private int idPedido;
	private int idEstoque;
	private int qtdItem;
	private String dtDevolucao;
	private String motivo;
	
	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private DBQuery dbQuery = null;
	
	public ItemsPedido() {
		this.tableName = "itemsPedido";
		this.fieldsName = "idItemPedido,ordem,idPedido,idEstoque,qtdItem,dtDevolucao,motivoDevolucao";
		this.keyField = "idItemPedido";
		this.dbQuery = new DBQuery(tableName, fieldsName, keyField);
	}
	

	public ItemsPedido(int idItemPedido, int ordem, int idPedido, int idEstoque, int qtdItem, String dtDevolucao,
			String motivo) {
		
		this.setIdItemPedido(idItemPedido);
		this.setOrdem(ordem);
		this.setIdPedido(idPedido);
		this.setIdEstoque(idEstoque);
		this.setQtdItem(qtdItem);
		this.setDtDevolucao(dtDevolucao);
		this.setMotivo(motivo);
	}

	public String[] toArray() {
		return(new String[] {
				""+this.idItemPedido,
				""+this.ordem,
				""+this.idPedido,
				""+this.idEstoque,
				""+this.qtdItem,
				""+this.dtDevolucao,
				""+this.motivo
		});
	}
	
	public void save() {
		if((this.getIdItemPedido() == 0)) {
			this.dbQuery.insert(this.toArray());
		}else {
			this.dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if(this.getIdItemPedido() > 0) {
			this.dbQuery.delete(this.toArray());
		}
	}
	
	public String listAll() {
		ResultSet rs = this.dbQuery.select("");
		String saida = "<br>";
		saida += "<table border=1>"	;
		
		try {
			
			while(rs.next()) {
				saida += "<tr>";
				saida += "<td>" + rs.getString("idItemPedido") + "</td>";
				saida += "<td>" + rs.getString("ordem") + "</td>";
				saida += "<td>" + rs.getString("idPedido") + "</td>";
				saida += "<td>" + rs.getString("idEstoque") + "</td>";
				saida += "<td>" + rs.getString("qtdItem") + "</td>";
				saida += "<td>" + rs.getString("dtDevolucao") + "</td>";
				saida += "<td>" + rs.getString("motivoDevolucao") + "</td>";
				saida += "</tr> <br>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		saida += "</table>";
		return (saida);
	}
	
	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	public String getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(String dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

}
	
	
