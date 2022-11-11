//package br.com.gs.view;
//
//import br.com.gs.dao.UsuarioDAO;
//import br.com.gs.factory.ConnectionFactory;
//import br.com.gs.to.EnderecoTO;
//import br.com.gs.to.PlanoTO;
//import br.com.gs.to.UsuarioTO;
//
//public class UsuarioTest {
//
//	public static void main(String[] args) {
//		String nome = "Isa Mary";
//		String sobrenome = "Kusuki Yabiku";
//		String cpf = "356.374.158-02";
//		String cnh = "1122334455";
//		String dtNascimento = "10/06/1986";
//		String telefone = "(11)96876-9192";
//		String email = "isa@fiap.com.br";
//		String senha = "12345";
//		String tipo = "cliente";
//		int fkEndereco = 1;
//		int fkPlano = 1;
//		String logradouro = "Rua tal";
//		String numero = "Numero 45613";
//		String complemento = "tem não";
//		String bairro = "Da carochinha";
//		String cidade = "Rolândia";
//		String uf = "TC";
//		String cep = "01234-567";
//				
//		
//		UsuarioTO usuario = new UsuarioTO(0, nome, sobrenome, cpf, cnh, dtNascimento, telefone, email, senha, tipo);
//		
//		
//		
//		PlanoTO plano = new PlanoTO();
//		plano.setId(fkPlano);
//		usuario.setPlanoTo(plano);
//		
//		EnderecoTO endereco = new EnderecoTO();
//		endereco.setId(fkEndereco);
//		usuario.setEnderecoTo(endereco);
//		
//		try {
//			
//			UsuarioDAO dao = new UsuarioDAO(ConnectionFactory.getConnection());
//			
//			dao.register(usuario);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Usuario cadastrado!");
//	}
//
//}
