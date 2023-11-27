package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the descripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Descripcion.findAll", query="SELECT d FROM Descripcion d")
public class Descripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private String texto;

	//bi-directional one-to-one association to Artista
	@OneToOne(mappedBy="descripcion")
	private Artista artista;

	public Descripcion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Descripcion [id=" + id + ", texto=" + texto + ", artista=" + artista + "]";
	}

}