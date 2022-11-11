package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.to.EnderecoTO;

public class EnderecoDAO {
	private Connection conexao;

	public EnderecoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(EnderecoTO endereco) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"insert into t_charchan_endereco (id_endereco, ds_logradouro, nr_numero, ds_complemento +"
				+ "ds_bairro, ds_cidade, sg_uf, nr_cep, id_usuario) "
				+ "values (sq_t_charchan_endereco.nextval, ?,?,?,?,?,?,?,?)"); 
		
		stmt.setString(1, endereco.getLogradouro());
		stmt.setString(2, endereco.getNumero());
		stmt.setString(3, endereco.getComplemento());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getUf());
		stmt.setString(7, endereco.getCep());
		stmt.setInt(8, endereco.getUsuarioTo().getId());
		
		stmt.executeUpdate();
	}
	
	public void update(EnderecoTO endereco, int id) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"update t_charchan_endereco set ds_logradouro = ?, nr_endereco = ?, ds_complemento = ?, "
				+ "ds_bairro = ?, ds_cidade = ?, sg_uf = ?, nr_cep = ? where id_usuario = ?");
		
		stmt.setString(1, endereco.getLogradouro());
		stmt.setString(2, endereco.getNumero());
		stmt.setString(3, endereco.getComplemento());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getUf());
		stmt.setString(7, endereco.getCep());
		stmt.setInt(8, endereco.getUsuarioTo().getId());
		
		stmt.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"delete from t_charchan_endereco where id_usuario = ?");
		
		stmt.setInt(1, id);
	}
	
	public EnderecoTO getByIdUser(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("select* from t_charchan_endereco where id_usuario = ?");
		
		stmt.setInt(1, id);
		
		ResultSet result = stmt.executeQuery();
		
		if(!result.next())
			throw new IdNotFoundException("Endereço não encontrado");
		
		return parse(result);
	}
	
	
	public EnderecoTO getById(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_endereco where id_endereco = ?");

		stmt.setInt(1, id);

		ResultSet result = stmt.executeQuery();

		if (!result.next())
			throw new IdNotFoundException("Endereco nao encontrado");

		return parse(result);
	}
	
	private EnderecoTO parse(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_endereco");
		String logradouro = resultSet.getString("ds_logradouro");
		String numero = resultSet.getString("nr_endereco");
		String complemento = resultSet.getString("ds_complemento");
		String bairro = resultSet.getString("ds_bairro");
		String cidade = resultSet.getString("ds_cidade");
		String uf = resultSet.getString("sg_uf");
		String cep = resultSet.getString("nr_cep");
		
		return new EnderecoTO(id, logradouro, numero, complemento, bairro, cidade, uf, cep, null);
		
		
	}
}
