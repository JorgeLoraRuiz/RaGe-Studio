package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enlaces database table.
 * 
 */
@Entity
@Table(name="enlaces")
@NamedQuery(name="Enlace.findAll", query="SELECT e FROM Enlace e")
public class Enlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String url;

	//bi-directional many-to-one association to Cancion
	@ManyToOne
	@JoinColumn(name="id_cancion")
	private Cancion cancion;

	//bi-directional many-to-one association to Tienda
	@ManyToOne
	@JoinColumn(name="id_tienda")
	private Tienda tienda;

	public Enlace() {
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

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}