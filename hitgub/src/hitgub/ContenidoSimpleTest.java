package hitgub;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ContenidoSimpleTest {


	@Test
	public void testEsLiviano() {
		Binary unBinario = new Binary("8888888888");
		Compresores compresores = new Compresores();
		Compresion unCompresor = compresores.Reflate();
		ContenidoBinario unArchivo = new ContenidoBinario(unBinario, unCompresor);
		assertTrue(unArchivo.esLiviano());
	}

	@Test
	public void testSePuedeSubir() {
		List<String> textos = Arrays.asList("hola");
		List<String> textos2 = Arrays.asList("h");
		ContenidoTexto texto = new ContenidoTexto(textos);
		ContenidoTexto texto2 = new ContenidoTexto(textos2);
		texto.nombre("te");
		List<Contenido> contenidos = Arrays.asList(texto2);
		Biblioteca unaBiblioteca = new Biblioteca(contenidos, 100000000);
		assertTrue(texto.sePuedeSubir(unaBiblioteca));	
	}

	@Test
	public void testTamanoTexto() {
		List<String> textos = Arrays.asList("hola", "que", "tal");
		ContenidoTexto texto = new ContenidoTexto(textos);
		assertEquals(160, texto.tamano(), 0);
	}
	@Test
	public void testTamanoBinario() {
		Binary unBinario = new Binary("8888888888");
		Compresores compresores = new Compresores();
		Compresion unCompresor = compresores.Reflate();
		ContenidoBinario unArchivo = new ContenidoBinario(unBinario, unCompresor);
		assertEquals(2, unArchivo.tamano(), 0);
	}

}
