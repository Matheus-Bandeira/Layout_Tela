package manager;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;
import persistence.HibernateUtil;

@ManagedBean
@RequestScoped
public class BeanRelatorio implements Serializable {

	public void relatorioClientes() {

		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			InputStream arquivo = fc.getExternalContext().getResourceAsStream("/Clientes2.jasper");
			// Relat�rio n�o Conflita quando Gera ...
			// juntando a tela com os daos do Banco
			byte report[] = JasperRunManager.runReportToPdf(arquivo, null,
					HibernateUtil.getSessionFactory().openSession().connection());
			HttpServletResponse response = (HttpServletResponse) fc.getCurrentInstance().getExternalContext()
					.getResponse();
			ServletOutputStream out = response.getOutputStream();
			out.write(report); // gero a tela no JSF de relatorio ..
			out.flush();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void relatorioDespesa() {

		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			InputStream arquivo = fc.getExternalContext().getResourceAsStream("/despesas.jasper");
			// Relat�rio n�o Conflita quando Gera ...
			// juntando a tela com os daos do Banco
			byte report[] = JasperRunManager.runReportToPdf(arquivo, null,
					HibernateUtil.getSessionFactory().openSession().connection());
			HttpServletResponse response = (HttpServletResponse) fc.getCurrentInstance().getExternalContext()
					.getResponse();
			ServletOutputStream out = response.getOutputStream();
			out.write(report); // gero a tela no JSF de relatorio ..
			out.flush();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
