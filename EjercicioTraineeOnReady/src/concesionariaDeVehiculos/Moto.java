package concesionariaDeVehiculos;

public class Moto extends Vehiculo implements Comparable<Vehiculo>{
	private int cilindrada;
	
	public Moto(String marca, String modelo, double precio, int cilindrada){
		super(marca, modelo, precio);
		setCilindrada(cilindrada);
	}
	
	private void setCilindrada(int cilindrada){
		this.cilindrada = cilindrada;
	}

	public int getCilindrada(){
		return cilindrada;
	}

	@Override
	public String toString() {
	 	return "Marca: " + super.getMarca() + " // Modelo: " + super.getModelo() + " // Cilindrada: " + this.getCilindrada()+"cc" 
	+" // Precio: $" + super.getPrecioFormat();
		/*Otra posible solucion podria haber sido esta, pero use la anterior para que la impresion por pantalla 
		 quede identico al ejercicio*/
	 	/*return super.toString() + " // Cilindrada: " + cilindrada+"cc";*/
	}
	
}
