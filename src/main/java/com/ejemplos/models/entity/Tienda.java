package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tiendas database table.
 * 
 */
@Entity
@Table(name="tiendas")
@NamedQuery(name="Tienda.findAll", query="SELECT t FROM Tienda t")
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	@Column(name="url_icono")
	private String urlIcono;

	//bi-directional many-to-one association to Enlace
	@OneToMany(mappedBy="tienda")
	private List<Enlace> enlaces;

	public Tienda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlIcono() {
		return this.urlIcono;
	}

	public void setUrlIcono(String urlIcono) {
		this.urlIcono = urlIcono;
	}

	public List<Enlace> getEnlaces() {
		return this.enlaces;
	}

	public void setEnlaces(List<Enlace> enlaces) {
		this.enlaces = enlaces;
	}

	public Enlace addEnlace(Enlace enlace) {
		getEnlaces().add(enlace);
		enlace.setTienda(this);

		return enlace;
	}

	public Enlace removeEnlace(Enlace enlace) {
		getEnlaces().remove(enlace);
		enlace.setTienda(null);

		return enlace;
	}

}