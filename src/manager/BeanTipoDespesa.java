package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.TipoDespesa;
import persistence.TipoDespesaDao;

@ManagedBean
@RequestScoped
public class BeanTipoDespesa implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoDespesa despesa;
	private TipoDespesa tipoDespesaEdicao;
	private List<TipoDespesa> despesas;// lista de todas as depesas - vou
										// cadastrar as despesas para manter o
										// banco padrão

	// construtor
	public BeanTipoDespesa() {
		despesa = new TipoDespesa();
		tipoDespesaEdicao = new TipoDespesa();
	}

	// getters e setters

	public List<TipoDespesa> getDespesas() {
		despesas = new TipoDespesaDao().findAll();
		return despesas;
	}

	public TipoDespesa getDespesa() {
		return despesa;
	}

	public void setDespesa(TipoDespesa despesa) {
		this.despesa = despesa;
	}

	public void setDespesas(List<TipoDespesa> despesas) {
		this.despesas = despesas;
	}

	public TipoDespesa getTipoDespesaEdicao() {
		return tipoDespesaEdicao;
	}

	public void setTipoDespesaEdicao(TipoDespesa tipoDespesaEdicao) {
		this.tipoDespesaEdicao = tipoDespesaEdicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void gravar() {
		TipoDespesaDao dd = new TipoDespesaDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dd.create(despesa);
			despesa = new TipoDespesa();
			fc.addMessage("frmDespesas", new FacesMessage("Despesa Cadastrada com sucesso!"));
		} catch (Exception ex) {
			fc.addMessage("frmDespesas", new FacesMessage("Houve erro no processa..."));
		}
	}

	public void excluir() {
		TipoDespesaDao dd = new TipoDespesaDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dd.delete(despesa);
			fc.addMessage("frmListaDespesa", new FacesMessage("Despesa Excluida com sucesso!"));
		} catch (Exception ex) {
			fc.addMessage("frmListaDespesa", new FacesMessage("Houve erro no processa..."));
		}
	}
	
	public void editar() {
		TipoDespesaDao dd = new TipoDespesaDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dd.update(tipoDespesaEdicao);
			fc.addMessage("frmListaDespesa", new FacesMessage("Despesa Salva com sucesso!"));
		} catch (Exception ex) {
			fc.addMessage("frmListaDespesa", new FacesMessage("Houve erro no processa..."));
		}
	}
}
