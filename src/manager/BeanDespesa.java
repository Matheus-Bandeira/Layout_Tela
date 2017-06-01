package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Despesa;
import persistence.DespesaDao;

@ManagedBean
@RequestScoped
public class BeanDespesa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Despesa despesa;
	private Despesa despesaEdicao;
	private List<Despesa> todasDespesas;

	public BeanDespesa() {
		despesa = new Despesa();
		despesaEdicao = new Despesa();
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public List<Despesa> getTodasDespesas() {
		todasDespesas = new DespesaDao().findAll();
		return todasDespesas;
	}

	public void setTodasDespesas(List<Despesa> todasDespesas) {
		this.todasDespesas = todasDespesas;
	}
	
	public Despesa getDespesaEdicao() {
		return despesaEdicao;
	}

	public void setDespesaEdicao(Despesa despesaEdicao) {
		this.despesaEdicao = despesaEdicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		DespesaDao dd = new DespesaDao();

		try {
			dd.create(despesa);
			despesa = new Despesa();
			fc.addMessage("frmDespesas", new FacesMessage("Despesa Salva Com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("frmDespesas", new FacesMessage("Houve erro no processo..."));
		}
	}

	public void excluir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		DespesaDao dd = new DespesaDao();

		try {
			dd.delete(despesa);
			fc.addMessage("frmDespesas", new FacesMessage("Despesa Excluida Com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("frmDespesas", new FacesMessage("Houve erro no processo..."));
		}
	}
	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		DespesaDao dd = new DespesaDao();

		try {
			dd.update(despesaEdicao);
			fc.addMessage("frmDespesas", new FacesMessage("Despesa Salva Com Sucesso!!!"));
		} catch (Exception ex) {
			fc.addMessage("frmDespesas", new FacesMessage("Houve erro no processo..."));
		}
	}
}
