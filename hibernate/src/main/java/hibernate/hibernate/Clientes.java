package hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Entity;
// Generated 24 feb 2024 23:18:29 by Hibernate Tools 6.3.1.Final
import jakarta.persistence.Id;

/**
 * Clientes generated by hbm2java
 */
@Entity
public class Clientes implements java.io.Serializable {

    @Id
    private int id;
    private String nombre;
    private String pais;
    

	public Clientes() {
	}

	public Clientes(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
