package com.ejemplos.models.auxiliares;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

public class SaveImgs {

	public static BufferedImage cuadrarImagen(MultipartFile imagenEntrada) throws IOException {
        // Cargar la imagen de entrada desde el MultipartFile
        InputStream inputStream = imagenEntrada.getInputStream();
        BufferedImage imagen = ImageIO.read(inputStream);
        // Obtener las dimensiones de la imagen original
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        // Calcular el tamaño de la imagen cuadrada
        int lado = Math.min(ancho, alto);
        // Crear una nueva imagen cuadrada
        BufferedImage imagenCuadrada = new BufferedImage(lado, lado, BufferedImage.TYPE_INT_RGB);
        // Copiar la región cuadrada de la imagen original a la imagen cuadrada
        int x = (ancho - lado) / 2;
        int y = (alto - lado) / 2;
        imagenCuadrada.getGraphics().drawImage(imagen, 0, 0, lado, lado, x, y, x + lado, y + lado, null);
        return imagenCuadrada;
    }
	
	public static byte[] bufferedImageToBytes(BufferedImage image) throws IOException {
        // Crea un flujo de salida de bytes en un arreglo de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Escribe la imagen en formato PNG en el flujo de salida
        ImageIO.write(image, "png", baos);
        // Asegura que todos los datos se escriban en el arreglo de bytes
        baos.flush();
        // Convierte el contenido del flujo de salida en un arreglo de bytes
        byte[] imageBytes = baos.toByteArray();
        // Cierra el flujo de salida para liberar los recursos asociados
        baos.close();
        return imageBytes;
    }
	
}
