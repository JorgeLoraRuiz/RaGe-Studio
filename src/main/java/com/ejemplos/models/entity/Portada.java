package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the portadas database table.
 * 
 */
@Entity
@Table(name="portadas")
@NamedQuery(name="Portada.findAll", query="SELECT p FROM Portada p")
public class Portada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String url;

	//bi-directional one-to-one association to Cancion
	@OneToOne(mappedBy="portada")
	private Cancion cancion;

	public Portada() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Cancion getCancion() {
		return this.cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

}