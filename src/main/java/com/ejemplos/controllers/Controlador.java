package com.ejemplos.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import com.ejemplos.models.service.*;
import com.ejemplos.models.auxiliares.Consultas;
import com.ejemplos.models.auxiliares.SaveImgs;
import com.ejemplos.models.entity.*;

@Controller
@SessionAttributes({"admin","newA","newC"})
public class Controlador {
	
	/*
	 * PROBLEMAS PENDIENTES DE SOLUCIONAR:
	 * 
	 * - Manejar limite de tamaño de subida de imagenes de artista
	 * - Mostrar nuevas imágenes sin tener que reiniciar el servidor
	 * 
	 * */
	
	@Autowired
	private ICancionService cancionService;
	
	@Autowired
	private IEnlaceService enlaceService;
	
	@Autowired
	private IArtistaService artistaService;
	
	@Autowired
	private IAdminService adminService;

	
	@RequestMapping(value="/")
	public String index(Model model) {
		List<Cancion> ultimasCanciones = cancionService.ultimasCanciones();
		model.addAttribute("ultimasCanciones", ultimasCanciones);
		return "index";
	}
	
	@RequestMapping(value="/artistas")
	public String artistas(Model model) {
		List<Artista> artistas = artistaService.findAll();
		model.addAttribute("artistas", artistas);
		return "artistas";
	}
	
	@RequestMapping(value="/artista/{nombre}")
	public String artista(@PathVariable("nombre") String nombre, Model model, SessionStatus session, Consultas consultas) {
		Artista a = artistaService.getArtistaByNombre(nombre);
		Descripcion d = consultas.getDescByArtista(a.getId());
		
		if (d.getTexto() == null) {
			d = null;
		}
		
		model.addAttribute("artista",a);
		model.addAttribute("desc",d);
		return "artista";
	}
	
	@RequestMapping(value="/cancion/{nombre}")
	public String cancion(@PathVariable("nombre") String nombre, Model model, SessionStatus session) {
		Cancion c = cancionService.getCancionFromNombre(nombre);
		Enlace ytEmbed = enlaceService.getYTEmbed(c.getId());
		Enlace spotifyEmbed = enlaceService.getSpotifyEmbed(c.getId());
		model.addAttribute("cancion",c);
		model.addAttribute("ytEmbed",ytEmbed);
		model.addAttribute("spotifyEmbed",spotifyEmbed);
		return "cancion";
	}
	
	@RequestMapping(value="/buscar", method = RequestMethod.GET)
	public String buscar(@RequestParam String input, Model model, SessionStatus session) {
		int cont = 0;
		List<Artista> artistas = artistaService.busqueda(input);
		if (artistas.size() == 0) {
			artistas = null;
			cont++;
		}
		List<Cancion> canciones = cancionService.busqueda(input);
		if (canciones.size() == 0) {
			canciones = null;
			cont++;
		}
		if (cont == 2) {
			model.addAttribute("vacio", "No se encontraron resutados.");
		}
		model.addAttribute("input", input);
		model.addAttribute("artistas", artistas);
		model.addAttribute("canciones", canciones);
		return "resultados";
	}
	
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		model.addAttribute("admin",new Admin());
		return "loginAdmin";
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.POST)
	public String adminLogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "loginAdmin";
		}
		if (adminService.findOne(admin.getNombre())==null) {
			model.addAttribute("notFound","El usuario introducido no existe");
			return "loginAdmin";			
		}
		Admin adminCheck = adminService.findOne(admin.getNombre());
		if (!admin.getContra().equals(adminCheck.getContra())) {
			model.addAttribute("incorrecto","Contraseña incorrecta. Inténtelo de nuevo");
			return "loginAdmin";
		}
		model.addAttribute("admin",admin);
		return "redirect:/menuAdmins";
	}
	
	@RequestMapping(value="/menuAdmins")
	public String menuAdmins(Admin admin) {
		if (admin.getContra().equals(adminService.findOne(admin.getNombre()).getContra())) {
			return "menuAdmins";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/newArtista")
	public String newArtista(Admin admin, Model model) {
		if (admin.getContra().equals(adminService.findOne(admin.getNombre()).getContra())) {
			model.addAttribute("newA",new Artista());
			return "newArtista";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/saveArtista", method = RequestMethod.POST)
	public String saveArtista(@ModelAttribute Artista newA, Model model) {
		if (artistaService.getArtistaByNombre(newA.getNombre()) == null) {
			artistaService.save(newA);
			model.addAttribute("newA", artistaService.getArtistaByNombre(newA.getNombre()));
			return "redirect:/newDescripcion";
		} else {
			model.addAttribute("falloDuplicado","Ya existe un artista con este nombre.");
			return "newArtista";
		}
	}
	
	@RequestMapping(value="/newDescripcion")
	public String newDescripcion(Admin admin, Model model) {
		if (admin.getContra().equals(adminService.findOne(admin.getNombre()).getContra())) {
			model.addAttribute("newD",new Descripcion());
			return "newDesc";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/saveDescripcion", method = RequestMethod.POST)
	public String saveDescripcion(HttpSession session, @ModelAttribute Descripcion newD, Model model, Consultas consultas) {
			
		if (newD.getTexto().equals("")) {
			return "redirect:/newImgArtista";
		}
		
		Artista newA = (Artista) session.getAttribute("newA");
		consultas.guardarDescArtista(newA, newD);
		return "redirect:/newImgArtista";
	}
	
	@RequestMapping(value="/newImgArtista")
	public String newImgArtista(Admin admin) {
		if (admin.getContra().equals(adminService.findOne(admin.getNombre()).getContra())) {
			return "newImgArtista";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/saveImgArtista", method = RequestMethod.POST)
	public String saveImgArtista(@RequestParam("upload_img") MultipartFile imagen, Model model, HttpSession session, Consultas consultas) {			
		Artista newA = (Artista) session.getAttribute("newA");
		String urlImagen = "/img_artistas/"+newA.getNombre().toLowerCase()+".png";
		
		try {
			BufferedImage imagen1 = SaveImgs.cuadrarImagen(imagen);
			FileUtils.writeByteArrayToFile(new File("src/main/resources/static"+urlImagen), SaveImgs.bufferedImageToBytes(imagen1));
			consultas.guardarImgArtista(newA, urlImagen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/menuAdmins";
	}
	
	@RequestMapping(value="/newCancion")
	public String newCancion(Admin admin, Model model) {
		if (admin.getContra().equals(adminService.findOne(admin.getNombre()).getContra())) {
			List<Artista> artistas = artistaService.findAllSort();
			model.addAttribute("artistas",artistas);
			return "newCancion";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/saveCancion", method = RequestMethod.POST)
	public String saveCancion(@RequestParam String nombre, @RequestParam String fecha, @RequestParam Integer artista, Model model, Consultas consultas, HttpSession session) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaParse = null;
		try {
			fechaParse = dateFormat.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaParse);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date nuevaFecha = calendar.getTime();
		
		Artista artistaIn = artistaService.findOne(artista);
		
		Cancion newC = new Cancion();
		newC.setNombre(nombre);
		newC.setArtista(artistaIn);
		newC.setFechaSalida(nuevaFecha);
		System.out.println(newC.getNombre());
		model.addAttribute("newC", cancionService.getCancionFromNombre(newC.getNombre()));
		if (cancionService.esaCancionDeEseArtista(newC.getNombre(),artistaIn.getNombre()) != null) {
			List<Artista> artistas = artistaService.findAllSort();
			model.addAttribute("artistas", artistas);
			model.addAttribute("notNull", "Este artista ya tiene una cancion con ese nombre.");
			return "newCancion/"+newC.getNombre();
		}
		cancionService.save(newC);
		
		return "redirect:/newImgCancion/"+newC.getNombre();
	}
	
	@RequestMapping(value="/newImgCancion/{nombre}")
	public String newImgCancion(@PathVariable("nombre") String nombre, Model model) {
		Cancion newC = cancionService.getCancionFromNombre(nombre);
		model.addAttribute("newC", newC);
		return "newImgCancion";
	}
	
	@RequestMapping(value="/saveImgCancion/{nombre}", method = RequestMethod.POST)
	public String saveImgCancion(@PathVariable("nombre") String nombre, @RequestParam("upload_img") MultipartFile imagen, Model model, HttpSession session, Consultas consultas) {
		Cancion newC = cancionService.getCancionFromNombre(nombre);
		String nombreListo = newC.getNombre().replaceAll("[^a-zA-Z0-9áéíóúñÁÉÍÓÚÑ]", "").trim();
		String urlImagen = "/portadas/"+nombreListo+".png";
		
		try {
			BufferedImage imagen1 = SaveImgs.cuadrarImagen(imagen);
			FileUtils.writeByteArrayToFile(new File("src/main/resources/static"+urlImagen), SaveImgs.bufferedImageToBytes(imagen1));
			consultas.guardarImgCancion(newC, urlImagen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
//	@RequestMapping(value="/prueba/{nombre}")
//	public String prueba(@PathVariable("nombre") String nombre, Model model, SessionStatus session) {
//		System.out.println(nombre.replaceAll("[^a-zA-Z0-9áéíóúñÁÉÍÓÚÑ]", "").trim());
//		return "redirect:/";
//	}
	
}