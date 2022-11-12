package br.com.gs.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gs.dao.UsuarioDAO;
import br.com.gs.exceptions.IdNotFoundException;
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
		enderecoBo.register(usuario.getEnderecoTo());
		usuarioDao.register(usuario);
		usuario.getEnderecoTo().setUsuarioTo(usuario);
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
	
	public List<UsuarioTO> getAll() throws SQLException {
		List<UsuarioTO> lista = usuarioDao.getAll(); 
		//Percorrer a lista de produtora
		for (UsuarioTO to : lista) {
			try {
				to.setEnderecoTo(enderecoBo.getByCodigoUsuario(to.getIdEndereco()));
			} catch (IdNotFoundException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
		
}
