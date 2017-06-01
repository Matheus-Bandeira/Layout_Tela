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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;

	@Column(length = 100)
	private String nome;

	@Column(length = 150)
	private String logradouro;

	@Column(length = 80)
	private String bairro;

	@Column(length = 30)
	private String cep;

	@Column(length = 50)
	private String email;

	@Column(length = 25)
	private String telefone;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Receita> receitas;

	public Cliente() {

	}

	public Cliente(Integer idCliente, String nome, String logradouro, String bairro, String cep, String email,
			String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.email = email;
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", logradouro=" + logradouro + ", bairro="
				+ bairro + ", cep=" + cep + ", email=" + email + ", telefone=" + telefone + "]";
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
