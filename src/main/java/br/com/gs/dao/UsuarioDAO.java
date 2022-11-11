package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.to.UsuarioTO;

public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(UsuarioTO usuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"insert into t_charchan_usuario values "
				+ "(sq_t_charchan_usuario.nextval, ?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?)",
				new String[] {"id_usuario"});
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSobrenome());
		stmt.setString(3, usuario.getCpf());
		stmt.setString(4, usuario.getCnh());
		stmt.setString(5, usuario.getDataNascimento());
		stmt.setString(6, usuario.getTelefone());
		stmt.setString(7, usuario.getEmail());
		stmt.setString(8, usuario.getSenha());
		stmt.setString(9, usuario.getTipo());

		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int id = result.getInt(1);
			usuario.setId(id);
		}

	}

	public void update(UsuarioTO usuario) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement(
				"update t_charchan_usuario set nm_usuario = ?, ds_sobrenome = ?, nr_cpf = ?, nr_cnh = ?, "
				+ "dt_nascimento = to_date(?,'dd/mm/yyyy'), nr_telefone = ?, ds_email = ?, ds_senha = ?, "
				+ "ds_tipo = ? where id_usuario = ?");
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSobrenome());
		stmt.setString(3, usuario.getCpf());
		stmt.setString(4, usuario.getCnh());
		stmt.setString(5, usuario.getDataNascimento());
		stmt.setString(6, usuario.getTelefone());
		stmt.setString(7, usuario.getEmail());
		stmt.setString(8, usuario.getSenha());
		stmt.setString(9, usuario.getTipo());
		
		int qtd = stmt.executeUpdate();
		
		if(qtd == 0)
			throw new IdNotFoundException("Usuario não encontrado para atualização");
	}
	
	public void delete(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement(
				"delete from t_charchan_usuario where id_usuario = ?");
		
		stmt.setInt(1, id);
		int qtd = stmt.executeUpdate();
		
		if (qtd == 0)
			throw new IdNotFoundException("Id não encontrado para remoção");
	}
	
	private UsuarioTO parse(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_usuario");
		String nome = resultSet.getString("nm_nome");
		String sobrenome = resultSet.getString("ds_sobrenome");
		String cpf = resultSet.getString("nr_cpf");
		String cnh = resultSet.getString("nr_cnh");
		String dtNascimento = resultSet.getString("dt_nascimento");
		String telefone = resultSet.getString("nr_telefone");
		String email = resultSet.getString("ds_email");
		String senha = resultSet.getString("ds_senha");
		String tipo = resultSet.getString("ds_tipo");
		
		UsuarioTO usuario = new UsuarioTO(id, nome, sobrenome, cpf, cnh, dtNascimento, telefone, email, senha, tipo);
		return usuario;
	}
	
	/**
	 * Pesquisa um usuário pela PK
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public UsuarioTO getById(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement(
				"select * from t_charchan_usuario where id_usuario = ?");
		
		stmt.setInt(1, id);
		
		ResultSet result = stmt.executeQuery();
		
		if (!result.next()) {
			throw new IdNotFoundException("Usuário não encontrado");
		}
		
		return parse(result);
	}
	
	private List<UsuarioTO> parseList(ResultSet resultSet) throws SQLException{
		List<UsuarioTO> lista = new ArrayList<UsuarioTO>();
		
		while (resultSet.next()) {
			UsuarioTO usuario = parse(resultSet);
			lista.add(usuario);
		}
		return lista;
	}
	
	/**
	 * Retorna todos os usuários cadastrados
	 * @return
	 * @throws SQLException
	 */
	public List<UsuarioTO> getAll() throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_usuario");
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
	
	/**
	 * Retorna todos os usuários por ds_tipo
	 * @param tipo
	 * @return
	 * @throws SQLException
	 */
	public List<UsuarioTO> getByTipo(String tipo) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from t_charchan_usuario where ds_tipo = ?");
		
		stmt.setString(1, tipo);
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
}
