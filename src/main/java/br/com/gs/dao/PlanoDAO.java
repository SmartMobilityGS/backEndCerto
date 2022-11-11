package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.to.PlanoTO;

public class PlanoDAO {
	
	private Connection conexao;
	
	public PlanoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	private PlanoTO parse(ResultSet resultSet) throws SQLException {
		
		int id = resultSet.getInt("id_plano");
		String nome = resultSet.getString("nm_plano");
		double valor = resultSet.getDouble("ds_valor");
		int tempo = resultSet.getInt("nr_tempo");

		return new PlanoTO(id, nome, valor, tempo);
	}
	
	private List<PlanoTO> parseList(ResultSet resultSet) throws SQLException {
		List<PlanoTO> lista = new ArrayList<PlanoTO>();
		while (resultSet.next()) {
			lista.add(parse(resultSet));
		}
		return lista;
	}
	
	public void register(PlanoTO plano) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("insert into t_charchan_plano (id_plano, nm_plano, ds_valor, nr_tempo) "
				+ "values (sq_t_charchan_plano.nextval, ?, ?, ?)",
				new String[] {"id_plano"});

		stmt.setString(1, plano.getNome()); 
		stmt.setDouble(2, plano.getValor());
		stmt.setInt(3, plano.getTempo());

		stmt.executeUpdate();

		if (stmt.getGeneratedKeys().next()) {
			plano.setId(stmt.getGeneratedKeys().getInt(1));
		}
	}
	
	public List<PlanoTO> getAll() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_plano");
		
		return parseList(stmt.executeQuery());
	}
	
	public List<PlanoTO> getByName(String nome) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_plano where nm_plano like ?");

		stmt.setString(1, "%" + nome + "%");
		return parseList(stmt.executeQuery());
	}
	
	public PlanoTO getById(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_plano where id_plano = ?");

		stmt.setInt(1, id);

		if (!stmt.executeQuery().next()) {
			throw new IdNotFoundException("Plano nao encontrado");
		}
		return parse(stmt.executeQuery());
	}
	
	public void update(PlanoTO plano) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("update t_charchan_plano set nm_plano = ?, ds_valor = ?,"
				+ " nr_tempo = ? where id_plano = ?");

		stmt.setString(1, plano.getNome()); 
		stmt.setDouble(2, plano.getValor());
		stmt.setInt(3, plano.getTempo());

		if (stmt.executeUpdate() == 0)
			throw new IdNotFoundException("Plano nao encontrado para atualizacao");
	}
	
	public void deletar(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("delete from t_charchan_plano where id_plano = ?");

		stmt.setInt(1, id);

		if (stmt.executeUpdate() == 0)
			throw new IdNotFoundException("Id nao encontrado para remocao");
	}

}
