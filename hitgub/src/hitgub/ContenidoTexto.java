package hitgub;
import java.util.List;

public class ContenidoTexto extends ContenidoSimple {
	List<String> Texto;
	public ContenidoTexto(List<String> unTexto){
		Texto = unTexto;
	}
	 double tamano(){
		return (Texto.stream().map(texto -> texto.length())).mapToInt(Integer::intValue).sum()*16;
	}
}
