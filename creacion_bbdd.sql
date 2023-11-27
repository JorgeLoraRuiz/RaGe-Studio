DROP DATABASE IF EXISTS rage_studio;
CREATE DATABASE IF NOT EXISTS rage_studio;
USE rage_studio;

CREATE TABLE admins (
    nombre varchar(100) NOT NULL UNIQUE,
    contra varchar(100),
    primary key (nombre)
);

CREATE TABLE artista (
	id int NOT NULL auto_increment UNIQUE,
    nombre varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE img_artista (
	id int NOT NULL auto_increment UNIQUE,
    url_imagen varchar(70),
    id_artista int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_artista) REFERENCES artista(id)
);

CREATE TABLE descripcion (
	id int NOT NULL auto_increment UNIQUE,
    texto longtext,
    id_artista int NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_artista) REFERENCES artista(id)
);

CREATE TABLE cancion (
  id int NOT NULL auto_increment UNIQUE,
  nombre varchar(200),
  id_artista int NOT NULL,
  fecha_salida date,
  PRIMARY KEY (id),
  FOREIGN KEY (id_artista) REFERENCES artista(id)
);

CREATE TABLE portadas (
	id int NOT NULL auto_increment UNIQUE,
    url varchar(150),
    id_cancion int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cancion) REFERENCES cancion(id)
);

CREATE TABLE tiendas (
	id int NOT NULL auto_increment UNIQUE,
    nombre varchar(20),
    url_icono varchar(70),
    PRIMARY KEY (id)
);

CREATE TABLE enlaces (
	id int NOT NULL auto_increment UNIQUE,
    url varchar(160),
    id_tienda int NOT NULL,
    id_cancion int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cancion) REFERENCES cancion(id),
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id)
);