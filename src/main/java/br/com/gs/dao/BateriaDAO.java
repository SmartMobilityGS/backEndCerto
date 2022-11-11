package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.to.BateriaTO;

public class BateriaDAO {
	
	private Connection conexao;

	public BateriaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	private BateriaTO parse(ResultSet resultSet) throws SQLException {		

		int id = resultSet.getInt("id_bateria");
		String nome = resultSet.getString("nm_bateria");
		String densidadeEnergetica = resultSet.getString("ds_densidade_energetica");
		String densidadePotencia = resultSet.getString("ds_densidade_potencia");
		String cicloVida = resultSet.getString("ds_ciclo_vida");
		String eficienciaCarga = resultSet.getString("ds_eficiencia_carga");
		String taxaDescarga = resultSet.getString("ds_taxa_descarga_propria");
		String toleranciaSobrecarga = resultSet.getString("ds_tolerancia_sobrecarga");
		String tempoCarga = resultSet.getString("ds_tempo_carga_rapida");

		return new BateriaTO(id, nome, densidadeEnergetica, densidadePotencia, cicloVida, eficienciaCarga, taxaDescarga, toleranciaSobrecarga, tempoCarga);
		
//		return new BateriaTO(resultSet.getInt("id_bateria"),
//							 resultSet.getString("nm_bateria"), 
//							 resultSet.getString("ds_densidade_energetica"), 
//							 resultSet.getString("ds_densidade_potencia"), 
//							 resultSet.getString("ds_ciclo_vida"), 
//							 resultSet.getString("ds_eficiencia_carga"), 
//							 resultSet.getString("ds_ds_taxa_descarga_propria"), 
//							 resultSet.getString("ds_tolerancia_sobrecarga"), 
//							 resultSet.getString("ds_tempo_carga_rapida"));
	}
	
	private List<BateriaTO> parseList(ResultSet resultSet) throws SQLException {
		List<BateriaTO> lista = new ArrayList<BateriaTO>();
		while (resultSet.next()) {
			lista.add(parse(resultSet));
		}
		return lista;
	}
	
	public void register(BateriaTO bateria) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
		"insert into t_charchan_bateria values " 
		+ "(sq_t_charchan_bateria.nextval, ?, ?, ?, ?, ?, ?, ?, ?)",
				new String[] {"id_bateria"});

		stmt.setString(1, bateria.getNome()); 
		stmt.setString(2, bateria.getDensidadeEnergetica());
		stmt.setString(3, bateria.getDensidadePotencia());
		stmt.setString(4, bateria.getCicloDeVida());
		stmt.setString(5, bateria.getEficienciaDeCargaEDescarga());
		stmt.setString(6, bateria.getTaxaDeDescargaPropria());
		stmt.setString(7, bateria.getToleranciaASobrecarga());
		stmt.setString(8, bateria.getTempoDeCargaRapida());

		stmt.executeUpdate();

		if (stmt.getGeneratedKeys().next()) {
			bateria.setId(stmt.getGeneratedKeys().getInt(1));
		}
	}
	
	public List<BateriaTO> getAll() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_bateria");
		
		return parseList(stmt.executeQuery());
	}
	
	public List<BateriaTO> getByName(String nome) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_bateria where nm_bateria like ?");

		stmt.setString(1, "%" + nome + "%");
		return parseList(stmt.executeQuery());
	}
	
	public BateriaTO getById(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_bateria where id_bateria = ?");

		stmt.setInt(1, id);

		if (!stmt.executeQuery().next()) {
			throw new IdNotFoundException("Bateria nao encontrada");
		}
		return parse(stmt.executeQuery());
	}
	
	public void update(BateriaTO plano) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("update t_charchan_bateria set nm_bateria = ?, ds_densidade_energetica = ?,"
				+ " ds_densidade_potencia = ?, ds_ciclo_vida = ?, ds_eficiencia_carga = ?, ds_taxa_descarga_propria = ?,"
				+ " ds_tolerancia_sobrecarga = ?, ds_tempo_carga_rapida = ? where id_bateria = ?");

		stmt.setString(1, plano.getNome());
		stmt.setString(2, plano.getDensidadeEnergetica());
		stmt.setString(3, plano.getDensidadePotencia());
		stmt.setString(4, plano.getCicloDeVida());
		stmt.setString(5, plano.getEficienciaDeCargaEDescarga());
		stmt.setString(6, plano.getTaxaDeDescargaPropria());
		stmt.setString(7, plano.getToleranciaASobrecarga());
		stmt.setString(8, plano.getTempoDeCargaRapida());

		if (stmt.executeUpdate() == 0)
			throw new IdNotFoundException("Bateria nao encontrada para atualizacao");
	}
	
	public void deletar(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("delete from t_charchan_bateria where id_bateria = ?");

		stmt.setInt(1, id);

		if (stmt.executeUpdate() == 0)
			throw new IdNotFoundException("Id nao encontrado para remocao");
	}

}
