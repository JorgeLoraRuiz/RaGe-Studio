USE rage_studio;

/*INSERTS DE ADMINS*/
INSERT INTO admins(nombre, contra) VALUE ("admin","admin");
INSERT INTO admins(nombre, contra) VALUE ("gestion","gestion");

/*INSERTS DE ARTISTAS*/
INSERT INTO artista(nombre) VALUE ("Lora");
INSERT INTO artista(nombre) VALUE ("Peta");
INSERT INTO artista(nombre) VALUE ("ManuMH");
INSERT INTO artista(nombre) VALUE ("Ellolo");

/*INSERTS DE IMAGENES DE ARTISTAS*/
INSERT INTO img_artista(url_imagen, id_artista) VALUE ("/img_artistas/lora.png", 1);
INSERT INTO img_artista(url_imagen, id_artista) VALUE ("/img_artistas/peta.png", 2);
INSERT INTO img_artista(url_imagen, id_artista) VALUE ("/img_artistas/manumh.png", 3);
INSERT INTO img_artista(url_imagen, id_artista) VALUE ("/img_artistas/ellolo.png", 4);

/*INSERTS DE DESCRIPCIONES*/
INSERT INTO descripcion(texto, id_artista) VALUE ("Lora (Jorge Lora Ruiz, Arcos de la Frontera, Cádiz) es un amante de la música desde temprana edad,
													y desde diciembre de 2021 se lanzó a crear sus propias canciones, siendo la primera de ellas Let Me, que creó junto a su amigo y compañero ManuMH."
, 1);

/*INSERTS DE CANCIONES*/
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("Ballin'",1,'2023-03-17');
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("On My Grind",1,'2022-10-14');
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("3 Days Song",1,'2022-02-25');
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("Let Me",1,'2021-12-03');
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("Zamba Del Trasnochador",2,'2022-12-28');
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("Quién lo diría (Acústico)",2,'2021-02-19');
INSERT INTO cancion(nombre,id_artista,fecha_salida) VALUES ("Toska (Instrumental)",3,'2021-11-25');

/*INSERTS DE img_artistaimg_artistaportadasIMAGENES*/
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/Ballin.png",1);
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/OnMyGrind.png",2);
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/3DaysSong.png",3);
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/LetMe.png",4);
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/ZambaDelTrasnochador.png",5);
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/QuiénLoDiréaAcústico.png",6);
INSERT INTO portadas(url,id_cancion) VALUES ("/portadas/ToskaInstrumental.png",7);

/*INSERTS DE TIENDAS*/
INSERT INTO tiendas(nombre,url_icono) VALUES ("Spotify","/socials_icons/spotify.png");
INSERT INTO tiendas(nombre,url_icono) VALUES ("Apple Music","/socials_icons/apple_music.png");
INSERT INTO tiendas(nombre,url_icono) VALUES ("Amazon Music","/socials_icons/amazon_music.png");
INSERT INTO tiendas(nombre,url_icono) VALUES ("SoundCloud","/socials_icons/soundcloud.png");
INSERT INTO tiendas(nombre,url_icono) VALUES ("YouTube Embed",NULL);
INSERT INTO tiendas(nombre,url_icono) VALUES ("Spotify Embed",NULL);

/*INSERTS DE ENLACES*/
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/0fddywrIYsip8gyQHUI1Eo?si=c1cfe13820684f0b",1,1);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/us/album/ballin/1675690081?i=1675690082",2,1);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B0BXGYCSWH?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_yG2iIeq9U2CGsQ4M0n7jt68Rt&trackAsin=B0BXGYXLKC",3,1);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://soundcloud.com/jlr_1711/ballin",4,1);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/fKo2LtTOI-4",5,1);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/0fddywrIYsip8gyQHUI1Eo?utm_source=generator",6,1);

INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/6kHOlkD1K7WZWnBAd8AmEi?si=1a56934935074e77",1,2);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/us/album/on-my-grind/1647608624?i=1647608625",2,2);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B0BGY5B4BH?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_hI4CGcvn5hIOJWTqevnDRNnmV&trackAsin=B0BGY4W7K5",3,2);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://soundcloud.com/jlr_1711/on-my-grind",4,2);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/zShMJEP-dH0",5,2);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/6kHOlkD1K7WZWnBAd8AmEi?utm_source=generator",6,2);

INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/7uRJUwZ518mDxbBBFx5x7w?si=42d100e03cc5407d",1,3);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/us/album/3-days-song/1607173405?i=1607173406",2,3);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B09RXSF18H?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_yNqVbpin3ds1DOo2AQ4EUZS4B&trackAsin=B09RY847DQ",3,3);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://soundcloud.com/jlr_1711/3-days-song",4,3);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/hnrN1RVdtm0",5,3);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/7uRJUwZ518mDxbBBFx5x7w?utm_source=generator",6,3);

INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/2LW9T0qlp2jsMfdlo1EPO2?si=d27a8c5953724132",1,4);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/us/album/let-me/1597656475?i=1597656477",2,4);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B09MPRQQJG?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_WV0NGD9iGLv7uSOwCVTE3GKDF&trackAsin=B09MPSBS66",3,4);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://soundcloud.com/jlr_1711/let-me-feat-manu",4,4);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/cdT5wAgqZ_M",5,4);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/2LW9T0qlp2jsMfdlo1EPO2?utm_source=generator",6,4);

INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/1OnliDOqradQM8HQFrjD9L?si=73f47d242d154bfb",1,5);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/es/album/zamba-del-trasnochador/1660123771?i=1660123772",2,5);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B0BQ867RX4?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_TKPvTGbs0v47Gc6wSIcKoyht5&trackAsin=B0BQ8J7WDD",3,5);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/B2RrN1hzAfY",5,5);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/1OnliDOqradQM8HQFrjD9L?utm_source=generator",6,5);

INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/3cpeinNbq5SVUDf8VtEH3n?si=2a1d7ee63e1e4c35",1,6);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/es/album/qui%C3%A9n-lo-dir%C3%ADa-ac%C3%BAstico/1553552520?i=1553552522",2,6);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B08WJVGR3V?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_mIWuQDqkqt3rjKCd5AtNZBaWX&trackAsin=B08WJXKX9T",3,6);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/tDBHETz__P0",5,6);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/3cpeinNbq5SVUDf8VtEH3n?utm_source=generator",6,6);

INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/track/7mbY2vGOX4pIA8ZslypZL2?si=edbececb91e64163",1,7);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://music.apple.com/us/album/toska-instrumental/1597664674?i=1597664675",2,7);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://amazon.com/music/player/albums/B09MPTF1MF?marketplaceId=ATVPDKIKX0DER&musicTerritory=US&ref=dm_sh_a3z1raJximgeAbe0TSgeI9vqI&trackAsin=B09MPTDZXQ",3,7);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://www.youtube.com/embed/xHaU8b9Q5nQ",5,7);
INSERT INTO enlaces(url,id_tienda,id_cancion) VALUES ("https://open.spotify.com/embed/track/7mbY2vGOX4pIA8ZslypZL2?utm_source=generator",6,7);