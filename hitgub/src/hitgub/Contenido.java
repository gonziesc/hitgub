package hitgub;
import java.util.Date;

public abstract class Contenido {
		String nombre;
		Date fechaModificado;
		boolean sePuedeSubir(Biblioteca unaBiblioteca){
			return !unaBiblioteca.contiene(this)  &&
				    this.nombreCorto() &&
				    this.entraEnBiblioteca(unaBiblioteca);

		}
		public void nombre(String unNombre){
			nombre = unNombre;
		}
		public void fecha(Date unaFecha){
			fechaModificado = unaFecha;
		}
		 boolean entraEnBiblioteca(Biblioteca unaBiblioteca) {
			return !unaBiblioteca.rebalsa(this) &&
				    !unaBiblioteca.superaTamañoInidividual(this);
		}
		boolean nombreCorto(){
	    return nombre.length() < 200;
		}
		double tamano(){
			return 0;
		}
		public String nombre() {
			return nombre;
		}
		public Date fecha() {
			return fechaModificado;
		}
		void renombrar(String unNombre){
			nombre = unNombre;
			this.modificar();
		}
		void modificar(){
			fechaModificado = new Date();
		}
		 boolean esLiviano() {
			return true;
		}
		 boolean roto(Biblioteca unaBiblioteca) {
				return false;
			}
}
