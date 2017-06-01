package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Receita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idReceita;

	@Column
	private Double valor;

	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_modelo")
	private ModeloAr modeloAr;

	public Receita() {
		// TODO Auto-generated constructor stub
	}

	public Receita(Integer idReceita, Double valor, Date data) {
		super();
		this.idReceita = idReceita;
		this.valor = valor;
		this.data = data;
	}

	public Receita(Integer idReceita, Double valor, Date data, Cliente cliente, ModeloAr modeloAr) {
		super();
		this.idReceita = idReceita;
		this.valor = valor;
		this.data = data;
		this.cliente = cliente;
		this.modeloAr = modeloAr;
	}

	@Override
	public String toString() {
		return "Receita [idReceita=" + idReceita + ", valor=" + valor + ", data=" + data + ", cliente=" + cliente
				+ ", modeloAr=" + modeloAr + "]";
	}

	public Integer getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public ModeloAr getModeloAr() {
		return modeloAr;
	}

	public void setModeloAr(ModeloAr modeloAr) {
		this.modeloAr = modeloAr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
