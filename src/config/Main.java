package config;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import entity.Usuario;
import persistence.UsuarioDao;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().
		              configure("config/mysql_hibernate.cfg.xml");
		new SchemaExport(cfg).create(true,true);
		
		geradados();
	}
	
	public static void geradados(){
		Usuario u1 = new Usuario(null, "9999", "9999");	
		Usuario u2 = new Usuario(null, "2000", "2000");	
		
		UsuarioDao ud = new UsuarioDao();
		ud.create(u1);
		ud.create(u2);
	}
}
