package br.com.gs.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.gs.dao.EnderecoDAO;
import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.to.EnderecoTO;

public class EnderecoBO {
	
	private EnderecoDAO enderecoDao;
	private Connection conexao;
	
	public EnderecoBO(Connection conexao) {
		this.conexao = conexao;
		this.enderecoDao = new EnderecoDAO(conexao);
	}
	
	public void register(EnderecoTO endereco) throws SQLException {
		enderecoDao.register(endereco);
	}
	
	public EnderecoTO getByCodigoUsuario(int id) throws SQLException, IdNotFoundException {
		return enderecoDao.getById(id);
	}

}
