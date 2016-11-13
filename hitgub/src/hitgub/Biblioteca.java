package hitgub;


import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
	List<Contenido> contenidos;
	int limite;
	public Biblioteca(List<Contenido> unosContenidos, int unLimite) {
		contenidos = unosContenidos;
		limite = unLimite;
	}
	boolean contiene(Contenido contenido) {
		return contenidos.contains(contenido);
	}
	void eliminar(Contenido contenido){
		contenidos.remove(contenido);
	}
	boolean rebalsa(Contenido contenido) {
		return (this.tamano() + contenido.tamano()) < (500 * limite);
	}
	boolean superaTamañoInidividual(Contenido contenido) {
		// TODO Auto-generated method stub
		return contenido.tamano() > limite;
	}
	double tamano(){
			return (contenidos.stream().map(contenido -> contenido.tamano())).mapToDouble(Double::doubleValue).sum();
	}
	void subir(Contenido contenido){
    if (!contenido.sePuedeSubir(this)){
    	throw new Error("no se puede subir");
    }
    else{
    	contenidos.add(contenido);
    	contenido.modificar();
    	} 
	}
	List<Contenido> buscarPorNombre(String nombre){
		return contenidos.stream()
			     .filter(unContenido -> unContenido.nombre().contains(nombre))
			     .collect(Collectors.toList());
	}
	List<String> actividadReciente(){
		return contenidos.stream()
			     .sorted((unContenido, otroContenido) -> unContenido.fecha().compareTo(otroContenido.fecha()))
			     .collect(Collectors.toList()).stream().map(unContenido -> unContenido.nombre()).collect(Collectors.toList()).subList(0, 4);
	}
	void removerRotos(){
		contenidos.removeIf(it -> it.roto(this));
	}
    


	
// https://docs.google.com/document/d/1xB7fDLtjUsSJs-1SEGzconsXQOTtiAMVP3x4M-XQvTc/edit#  https://docs.google.com/document/d/1QG6KbtQfxKpkTWGNojsmwgAVNa5LJBv1wM9kcuvYJCM/edit#heading=h.7012o0x65ztx
}
