package br.com.gs.to;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.gs.enums.TiposPlanosEnum;

@XmlRootElement
public class PlanoTO {
	private int id;
	private String nome;
	private double valor;
	private int tempo;
	private UsuarioTO usuarioTo;
	private TiposPlanosEnum tiposPlanosEnum;
	private List<BateriaTO> bateriaTo;
	
	/**
	 * Construtor padrão
	 */
	public PlanoTO() {}

	/**
	 * @param id
	 * @param nome
	 * @param valor
	 * @param tempo
	 * @param usuarioTo
	 * @param tiposPlanosEnum
	 * @param bateriaTo
	 */
	public PlanoTO(int id, String nome, double valor, int tempo, UsuarioTO usuarioTo,
			TiposPlanosEnum tiposPlanosEnum, List<BateriaTO> bateriaTo) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.tempo = tempo;
		this.usuarioTo = usuarioTo;
		this.tiposPlanosEnum = tiposPlanosEnum;
		this.bateriaTo = bateriaTo;
	}
	
	

	public PlanoTO(int id, String nome, double valor, int tempo) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.tempo = tempo;
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
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * @return the usuarioTo
	 */
	public UsuarioTO getUsuarioTo() {
		return usuarioTo;
	}

	/**
	 * @param usuarioTo the usuarioTo to set
	 */
	public void setUsuarioTo(UsuarioTO usuarioTo) {
		this.usuarioTo = usuarioTo;
	}

	/**
	 * @return the tiposPlanosEnum
	 */
	public TiposPlanosEnum getTiposPlanosEnum() {
		return tiposPlanosEnum;
	}

	/**
	 * @param tiposPlanosEnum the tiposPlanosEnum to set
	 */
	public void setTiposPlanosEnum(TiposPlanosEnum tiposPlanosEnum) {
		this.tiposPlanosEnum = tiposPlanosEnum;
	}

	/**
	 * @return the bateriaTo
	 */
	public List<BateriaTO> getBateriaTo() {
		return bateriaTo;
	}

	/**
	 * @param bateriaTo the bateriaTo to set
	 */
	public void setBateriaTo(List<BateriaTO> bateriaTo) {
		this.bateriaTo = bateriaTo;
	}
	
	
}
