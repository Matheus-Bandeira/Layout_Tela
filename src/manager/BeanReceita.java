package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import entity.ModeloAr;
import entity.Receita;
import persistence.ReceitaDao;

@ManagedBean
@RequestScoped
public class BeanReceita implements Serializable {

	private Receita receita;
	private Cliente cliente;
	private ModeloAr modelo;

	private List<Receita> listaReceita;

	public BeanReceita() {
		receita = new Receita();
		cliente = new Cliente();
		modelo = new ModeloAr();
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Receita> getListaReceita() {
		if (listaReceita == null) {
			listaReceita = new ArrayList<Receita>();
		}
		listaReceita = new ReceitaDao().findAll();
		return listaReceita;
	}

	public void setListaReceita(List<Receita> listaReceita) {
		this.listaReceita = listaReceita;
	}

	public ModeloAr getModelo() {
		return modelo;
	}

	public void setModelo(ModeloAr modelo) {
		this.modelo = modelo;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ReceitaDao rd = new ReceitaDao();

		try {
			rd.create(receita, cliente, modelo);
			receita = new Receita();
			cliente = new Cliente();
			modelo = new ModeloAr();
			fc.addMessage("", new FacesMessage("Receita Gravada com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Houve erro no processo..."));
		}
	}
}
