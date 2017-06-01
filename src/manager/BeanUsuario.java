package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Usuario;
import persistence.UsuarioDao;

@ManagedBean
@RequestScoped
public class BeanUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Usuario usuarioEdicao;
	private List<Usuario> todosUsuarios; // traz todos os usuarios do banco

	public BeanUsuario() {
		usuario = new Usuario();
		usuarioEdicao = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public List<Usuario> getTodosUsuarios() {
		todosUsuarios = new UsuarioDao().findAll();
		return todosUsuarios;
	}

	public void setTodosUsuarios(List<Usuario> todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void cadastrar() {
		UsuarioDao ud = new UsuarioDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			ud.create(usuario);
			usuario = new Usuario();
			fc.addMessage("frmUsu", new FacesMessage("Usuario gravado com sucesso!!"));
		} catch (Exception ex) {
			fc.addMessage("frmUsu", new FacesMessage("Houve erro no processo..."));
		}
	}

	public void excluir() {
		UsuarioDao ud = new UsuarioDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		
		if (usuario.getCodigo().equals("9999") || todosUsuarios.size() == 1) {
			fc.addMessage("frmUsu", new FacesMessage("Super Usuario não pode ser excluido"));
		}else{
			try {
				ud.delete(usuario);
				fc.addMessage("frmUsu", new FacesMessage("Usuario excluido "));
			} catch (Exception ex) {
				fc.addMessage("frmUsu", new FacesMessage("Houve erro no processo..."));
			}
		}
		
	}

	public void editar() {
		UsuarioDao ud = new UsuarioDao();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			ud.update(usuarioEdicao);
			fc.addMessage("frmUsu", new FacesMessage("Usuario Salvo"));
		} catch (Exception ex) {
			fc.addMessage("frmUsu", new FacesMessage("Houve erro no processo..."));
		}
	}
}
