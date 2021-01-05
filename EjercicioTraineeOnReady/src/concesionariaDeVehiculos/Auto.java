package concesionariaDeVehiculos;

public class Auto extends Vehiculo implements Comparable<Vehiculo>{
	private int puertas;
	
	public Auto(String marca, String modelo, double precio, int puertas){
		super(marca, modelo, precio);
		setPuertas(puertas);
	}
	
	private void setPuertas(int puertas){
		this.puertas = puertas;
	}
	
	public double getPuertas(){
		return puertas;
	}

	@Override
	public String toString() {
	 	return "Marca: " + super.getMarca() + " // Modelo: " + super.getModelo() + " // Puertas: " + this.puertas + " // Precio: $" + super.getPrecioFormat();
		/*Otra posible solucion podria haber sido esta, pero use la anterior para que la impresion por pantalla 
		 quede identico al ejercicio*/
	 	/*return super.toString() + " // Puertas: " + puertas;*/
		}
		
	}
