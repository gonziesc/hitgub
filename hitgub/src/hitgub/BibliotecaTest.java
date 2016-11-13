package hitgub;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void testSubir() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		texto.nombre("te");
		List<Contenido> contenidos = Arrays.asList(texto, texto2);
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		assertTrue(unaBiblioteca.contiene(texto));
	}
	@Test(expected = Exception.class)  
	public void testSubirContenidoEspecial() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		Link unlink = new Link(texto, "chau");
		List<Contenido> unaLista = Arrays.asList(texto, texto2, unlink);
		Carpeta unaCarpeta = new Carpeta(unaLista, "carpeta");
		texto.nombre("te");
		List<Contenido> contenidos = Arrays.asList(texto, texto2, unaCarpeta);
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		unaBiblioteca.eliminar(texto);
		unaBiblioteca.subir(unlink);
	}
	@Test
	public void testEliminar() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		Link unlink = new Link(texto, "chau");
		List<Contenido> unaLista = Arrays.asList(texto, texto2, unlink);
		Carpeta unaCarpeta = new Carpeta(unaLista, "carpeta");
		texto.nombre("te");
		List<Contenido> contenidos = new ArrayList<Contenido>(Arrays.asList(texto, texto2, unaCarpeta, unlink));
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		unaBiblioteca.eliminar(unlink);
		assertTrue(!(unaBiblioteca.contiene(unlink)));
	}
	@Test
	public void testSacarRotos() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		Link unlink = new Link(texto, "chau");
		List<Contenido> unaLista = Arrays.asList(texto, texto2, unlink);
		Carpeta unaCarpeta = new Carpeta(unaLista, "carpeta");
		texto.nombre("te");
		List<Contenido> contenidos = new ArrayList<Contenido>(Arrays.asList(texto, texto2, unaCarpeta, unlink));
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		unaBiblioteca.eliminar(texto);
		unaBiblioteca.removerRotos();
		assertTrue(!(unaBiblioteca.contiene(unlink)));
	}
	@Test
	public void testBuscarPorNombre() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		texto.nombre("te");
		texto2.nombre("hola");
		List<Contenido> contenidos = Arrays.asList(texto, texto2);
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		assertEquals(unaBiblioteca.buscarPorNombre("te").get(0), texto);
	}

	@Test
	public void testActividadReciente() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		List<String> textos3 = Arrays.asList("hasdasd");
		List<String> textos4 = Arrays.asList("holadddd");
		List<String> textos5 = Arrays.asList("hasdasdasd");
		List<String> textos6 = Arrays.asList("hasdasdasdasdasd");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		ContenidoTexto texto3 = new ContenidoTexto(textos3);
		ContenidoTexto texto4 = new ContenidoTexto(textos4);
		ContenidoTexto texto5 = new ContenidoTexto(textos5);
		ContenidoTexto texto6 = new ContenidoTexto(textos6);
		Date fecha = new Date();
		texto.nombre("te");
		texto2.nombre("teasd");
		texto3.nombre("tedd");
		texto4.nombre("teaa");
		texto5.nombre("tess");
		texto6.nombre("te22");
		texto.fecha(fecha);
		texto2.fecha(fecha);
		texto3.fecha(fecha);
		texto4.fecha(fecha);
		texto5.fecha(fecha);
		texto6.fecha(fecha);
		List<Contenido> contenidos = Arrays.asList(texto, texto2, texto3, texto4, texto5, texto6);
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		texto.nombre("hola");
		assertEquals(unaBiblioteca.actividadReciente().get(0), "hola");
	}

}
