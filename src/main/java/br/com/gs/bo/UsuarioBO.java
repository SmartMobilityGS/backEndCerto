package br.com.gs.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gs.dao.UsuarioDAO;
import br.com.gs.factory.ConnectionFactory;
import br.com.gs.to.UsuarioTO;

public class UsuarioBO {
	private UsuarioDAO usuarioDao;
	private EnderecoBO enderecoBo;
	private Connection conexao;

	public UsuarioBO(Connection conexao) {
		this.conexao = conexao;
		this.usuarioDao = new UsuarioDAO(conexao);
		this.enderecoBo = new EnderecoBO(conexao);
	}

	public void register(UsuarioTO usuario) throws SQLException {
		conexao.setAutoCommit(false);
		usuarioDao.register(usuario);
		usuario.getEnderecoTo().setUsuarioTo(usuario);
		enderecoBo.register(usuario.getEnderecoTo());
		conexao.commit();
	}
	
//	public List<UsuarioTO> getAll(){
//		try {
//			//UsuarioDAO udao = new UsuarioDAO(ConnectionFactory.getConnection());
//			return usuarioDao.getAll();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
		
}
