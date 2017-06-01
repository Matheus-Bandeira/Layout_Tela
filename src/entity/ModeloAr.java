package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ModeloAr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer idModelo;

	@Column(length = 50)
	private String tipo;

	@Column(length = 50)
	private String marca;

	@Column(length = 50)
	private String modelo;

	@Column(length = 50)
	private String serie;

	@OneToMany(mappedBy = "modeloAr", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Receita> receitas;

	public ModeloAr() {

	}

	public ModeloAr(Integer idModelo, String tipo, String marca, String modelo, String serie) {
		super();
		this.idModelo = idModelo;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.serie = serie;
	}

	public ModeloAr(Integer idModelo, String tipo, String marca, String modelo, String serie, List<Receita> receitas) {
		super();
		this.idModelo = idModelo;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.serie = serie;
		this.receitas = receitas;
	}

	@Override
	public String toString() {
		return "ModeloAr [idModelo=" + idModelo + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo
				+ ", serie=" + serie + ", receitas=" + receitas + "]";
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
