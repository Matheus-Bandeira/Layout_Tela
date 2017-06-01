package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import persistence.ClienteDao;

@ManagedBean
@RequestScoped
public class BeanCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Cliente clienteEdicao;
	private List<Cliente> clientes;

	public BeanCliente() {
		cliente = new Cliente();
		clienteEdicao = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
		clientes = new ClienteDao().findAll();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(Cliente clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void gravar() {
		ClienteDao cd = new ClienteDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			cd.create(cliente);
			cliente = new Cliente();
			fc.addMessage("", new FacesMessage("Gravado com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Erro no processo..."));
		}
	}

	public void excluir() {
		ClienteDao cd = new ClienteDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			cd.delete(cliente);
			fc.addMessage("", new FacesMessage("Excluido com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Erro no processo..."));
		}
	}

	public void editar() {
		ClienteDao cd = new ClienteDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			cd.update(clienteEdicao);
			fc.addMessage("", new FacesMessage("Salvo com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Erro no processo..."));
		}
	}
}
