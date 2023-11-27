package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cancion database table.
 * 
 */
@Entity
@NamedQuery(name="Cancion.findAll", query="SELECT c FROM Cancion c")
public class Cancion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	private String nombre;

	//bi-directional many-to-one association to Artista
	@ManyToOne
	@JoinColumn(name="id_artista")
	private Artista artista;

	//bi-directional many-to-one association to Enlace
	@OneToMany(mappedBy="cancion")
	private List<Enlace> enlaces;

	//bi-directional one-to-one association to Portada
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_cancion")
	private Portada portada;

	public Cancion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public List<Enlace> getEnlaces() {
		return this.enlaces;
	}

	public void setEnlaces(List<Enlace> enlaces) {
		this.enlaces = enlaces;
	}

	public Enlace addEnlace(Enlace enlace) {
		getEnlaces().add(enlace);
		enlace.setCancion(this);

		return enlace;
	}

	public Enlace removeEnlace(Enlace enlace) {
		getEnlaces().remove(enlace);
		enlace.setCancion(null);

		return enlace;
	}

	public Portada getPortada() {
		return this.portada;
	}

	public void setPortada(Portada portada) {
		this.portada = portada;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", fechaSalida=" + fechaSalida + ", nombre=" + nombre + ", artista=" + artista
				+ ", enlaces=" + enlaces + ", portada=" + portada + "]";
	}

}