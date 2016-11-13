package hitgub;

public class ContenidoBinario extends ContenidoSimple {
	Binary binario;
	Compresion compresor;
	public ContenidoBinario(Binary unBinario, Compresion unCompresor){
		binario = unBinario;
		compresor = unCompresor;
	}
	double tamano(){
		return compresor.reducir(binario.size()) * binario.size();
	}
}
