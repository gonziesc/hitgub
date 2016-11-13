package hitgub;

public class Compresores {
	public Compresion sinCompresor(){
		Compresion sinCompresor = new Compresion(){
			public double reducir(int unTamano){
				return 1;
			}
		};
		return sinCompresor;
	}
	public Compresion Reflate(){
		Compresion Reflate = new Compresion(){
			public double reducir(int unTamano){
				return 0.2;
			}
		};
		return Reflate;
	}
	public Compresion Bsip2 (){
		Compresion Bsip2  = new Compresion(){
			public double reducir(int unTamano){
				if (unTamano > 100)
			      return 0.4;
			    else 
			     return 0.1;

			}
		};
		return Bsip2 ;
	}
}
