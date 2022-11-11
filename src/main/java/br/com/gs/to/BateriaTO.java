package br.com.gs.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BateriaTO {
	private int id;
	private String nome;
	private String densidadeEnergetica;
	private String densidadePotencia;
	private String cicloDeVida;
	private String eficienciaDeCargaEDescarga;
	private String taxaDeDescargaPropria;
	private String toleranciaASobrecarga;
	private String tempoDeCargaRapida;
	private PlanoTO planoTo;
	
	/**
	 * Construtor padrão
	 */
	public BateriaTO() {}

	/**
	 * @param id
	 * @param name
	 * @param densidadeEnergetica
	 * @param densidadePotencia
	 * @param cicloDeVida
	 * @param eficienciaDeCargaEDescarga
	 * @param taxaDeDescargaPropria
	 * @param toleranciaASobrecarga
	 * @param tempoDeCargaRapida
	 * @param planoTo
	 */
	public BateriaTO(int id, String nome, String densidadeEnergetica, String densidadePotencia, String cicloDeVida,
			String eficienciaDeCargaEDescarga, String taxaDeDescargaPropria, String toleranciaASobrecarga,
			String tempoDeCargaRapida, PlanoTO planoTo) {
		this.id = id;
		this.nome = nome;
		this.densidadeEnergetica = densidadeEnergetica;
		this.densidadePotencia = densidadePotencia;
		this.cicloDeVida = cicloDeVida;
		this.eficienciaDeCargaEDescarga = eficienciaDeCargaEDescarga;
		this.taxaDeDescargaPropria = taxaDeDescargaPropria;
		this.toleranciaASobrecarga = toleranciaASobrecarga;
		this.tempoDeCargaRapida = tempoDeCargaRapida;
		this.planoTo = planoTo;
	}	

	public BateriaTO(int id, String nome, String densidadeEnergetica, String densidadePotencia, String cicloDeVida,
			String eficienciaDeCargaEDescarga, String taxaDeDescargaPropria, String toleranciaASobrecarga,
			String tempoDeCargaRapida) {
		this.id = id;
		this.nome = nome;
		this.densidadeEnergetica = densidadeEnergetica;
		this.densidadePotencia = densidadePotencia;
		this.cicloDeVida = cicloDeVida;
		this.eficienciaDeCargaEDescarga = eficienciaDeCargaEDescarga;
		this.taxaDeDescargaPropria = taxaDeDescargaPropria;
		this.toleranciaASobrecarga = toleranciaASobrecarga;
		this.tempoDeCargaRapida = tempoDeCargaRapida;
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
	 * @return the name
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the densidadeEnergetica
	 */
	public String getDensidadeEnergetica() {
		return densidadeEnergetica;
	}

	/**
	 * @param densidadeEnergetica the densidadeEnergetica to set
	 */
	public void setDensidadeEnergetica(String densidadeEnergetica) {
		this.densidadeEnergetica = densidadeEnergetica;
	}

	/**
	 * @return the densidadePotencia
	 */
	public String getDensidadePotencia() {
		return densidadePotencia;
	}

	/**
	 * @param densidadePotencia the densidadePotencia to set
	 */
	public void setDensidadePotencia(String densidadePotencia) {
		this.densidadePotencia = densidadePotencia;
	}

	/**
	 * @return the cicloDeVida
	 */
	public String getCicloDeVida() {
		return cicloDeVida;
	}

	/**
	 * @param cicloDeVida the cicloDeVida to set
	 */
	public void setCicloDeVida(String cicloDeVida) {
		this.cicloDeVida = cicloDeVida;
	}

	/**
	 * @return the eficienciaDeCargaEDescarga
	 */
	public String getEficienciaDeCargaEDescarga() {
		return eficienciaDeCargaEDescarga;
	}

	/**
	 * @param eficienciaDeCargaEDescarga the eficienciaDeCargaEDescarga to set
	 */
	public void setEficienciaDeCargaEDescarga(String eficienciaDeCargaEDescarga) {
		this.eficienciaDeCargaEDescarga = eficienciaDeCargaEDescarga;
	}

	/**
	 * @return the taxaDeDescargaPropria
	 */
	public String getTaxaDeDescargaPropria() {
		return taxaDeDescargaPropria;
	}

	/**
	 * @param taxaDeDescargaPropria the taxaDeDescargaPropria to set
	 */
	public void setTaxaDeDescargaPropria(String taxaDeDescargaPropria) {
		this.taxaDeDescargaPropria = taxaDeDescargaPropria;
	}

	/**
	 * @return the toleranciaASobrecarga
	 */
	public String getToleranciaASobrecarga() {
		return toleranciaASobrecarga;
	}

	/**
	 * @param toleranciaASobrecarga the toleranciaASobrecarga to set
	 */
	public void setToleranciaASobrecarga(String toleranciaASobrecarga) {
		this.toleranciaASobrecarga = toleranciaASobrecarga;
	}

	/**
	 * @return the tempoDeCargaRapida
	 */
	public String getTempoDeCargaRapida() {
		return tempoDeCargaRapida;
	}

	/**
	 * @param tempoDeCargaRapida the tempoDeCargaRapida to set
	 */
	public void setTempoDeCargaRapida(String tempoDeCargaRapida) {
		this.tempoDeCargaRapida = tempoDeCargaRapida;
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
