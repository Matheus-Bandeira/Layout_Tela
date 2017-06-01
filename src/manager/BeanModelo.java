package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.ModeloAr;
import persistence.ModeloDao;

@ManagedBean
@RequestScoped
public class BeanModelo implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloAr modelo;
	private ModeloAr modeloedicao;
	private List<ModeloAr> modelos;

	public BeanModelo() {
		modelo = new ModeloAr();
		modeloedicao = new ModeloAr();
	}

	public ModeloAr getModelo() {
		return modelo;
	}

	public void setModelo(ModeloAr modelo) {
		this.modelo = modelo;
	}

	public List<ModeloAr> getModelos() {
		if (modelos == null) {
			modelos = new ArrayList<ModeloAr>();
		}
		modelos = new ModeloDao().findAll();
		return modelos;
	}

	public void setModelos(List<ModeloAr> modelos) {
		this.modelos = modelos;
	}

	public ModeloAr getModeloedicao() {
		return modeloedicao;
	}

	public void setModeloedicao(ModeloAr modeloedicao) {
		this.modeloedicao = modeloedicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ModeloDao md = new ModeloDao();

		try {
			md.create(modelo);
			fc.addMessage("", new FacesMessage("Modelo Gravado..."));
			modelo = new ModeloAr();
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Erro no Processo..."));
		}
	}

	public void excluir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ModeloDao md = new ModeloDao();

		try {
			md.delete(modelo);
			fc.addMessage("", new FacesMessage("Modelo Excluido..."));
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Erro no Processo..."));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ModeloDao md = new ModeloDao();

		try {
			md.update(modeloedicao);
			fc.addMessage("", new FacesMessage("Modelo Salvo..."));
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Erro no Processo..."));
		}
	}

}
