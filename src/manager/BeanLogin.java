package manager;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entity.Usuario;
import persistence.UsuarioDao;

@ManagedBean
@RequestScoped
public class BeanLogin implements Serializable {

	private Usuario usuario;
	private Usuario logado;

	public BeanLogin() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getLogin() {
		return logado;
	}

	public void setLogin(Usuario login) {
		this.logado = login;
	}

	public String logar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		UsuarioDao ud = new UsuarioDao();

		try {
			logado = ud.findByLogin(usuario);
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

			if (logado != null) {
				logado = new Usuario();
				usuario = new Usuario();

				fc.addMessage("form1", new FacesMessage("Logado Com Sucesso"));
				session.setAttribute("logado", logado);
				return "/pages/principal.jsf?faces-redirect=true";
			} else {
				usuario = new Usuario();
				fc.addMessage("form1", new FacesMessage("Usuario Invalido"));
				return null;
			}
		} catch (Exception ex) {
			fc.addMessage("form1", new FacesMessage("Error:" + ex.getMessage()));
			return null;
		}
	}

	public String logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

			session.setAttribute("logado", null);

			usuario = new Usuario();
			fc.addMessage("", new FacesMessage("Logout no Sistema"));
			return "../pages/login.jsf";
		} catch (Exception ex) {
			fc.addMessage("", new FacesMessage("Error:" + ex.getMessage()));
			return "../pages/login.jsf";
		}

	}
}
