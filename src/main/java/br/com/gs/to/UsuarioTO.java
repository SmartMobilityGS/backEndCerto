package br.com.gs.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioTO {
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String cnh;
	private String dataNascimento;
	private String telefone;
	private String email;
	private String senha;
	private String tipo;
	private EnderecoTO enderecoTo;
	private PlanoTO planoTo;
	
	/**
	 * Construtor padrão
	 */
	public UsuarioTO() {}
	
	/**
	 * @param id
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 * @param cnh
	 * @param dataNascimento
	 * @param telefone
	 * @param email
	 * @param senha
	 * @param tipo
	 */
	public UsuarioTO(int id, String nome, String sobrenome, String cpf, String cnh, String dataNascimento, String telefone,
			String email, String senha, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
	


	/**
	 * @param id
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 * @param cnh
	 * @param dataNascimento
	 * @param telefone
	 * @param email
	 * @param senha
	 * @param tipo
	 * @param enderecoTo
	 * @param planoTo
	 */
	public UsuarioTO(int id, String nome, String sobrenome, String cpf, String cnh, String dataNascimento,
			String telefone, String email, String senha, String tipo, EnderecoTO enderecoTo, PlanoTO planoTo) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.enderecoTo = enderecoTo;
		this.planoTo = planoTo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the cnh
	 */
	public String getCnh() {
		return cnh;
	}

	/**
	 * @param cnh the cnh to set
	 */
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	/**
	 * @return the dataNascimento
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the enderecoTo
	 */
	public EnderecoTO getEnderecoTo() {
		return enderecoTo;
	}

	/**
	 * @param enderecoTo the enderecoTo to set
	 */
	public void setEnderecoTo(EnderecoTO enderecoTo) {
		this.enderecoTo = enderecoTo;
	}

	/**
	 * @return the planoTo
	 */
	public PlanoTO getPlanoTo() {
		return planoTo;
	}

	/**
	 * @param planoTo the planoTo to set
	 */
	public void setPlanoTo(PlanoTO planoTo) {
		this.planoTo = planoTo;
	}
	
	
}
