package concesionariaDeVehiculos;

public class Test {
	
	public static void main(String[] args) {
		Concesionaria onReady = new Concesionaria();
		agregarVehiculos(onReady);
		mostrarEnPantalla(onReady);		
	}
	
	static void agregarVehiculos(Concesionaria c){
		c.agregarVehiculo(new Auto("Peugeot","206",200000,4));
		c.agregarVehiculo(new Moto("Honda","Titan",60000,125));
		c.agregarVehiculo(new Auto("Peugeot","208",250000,5));
		c.agregarVehiculo(new Moto("Yamaha","YBR",80500.50,160));
	}

	static void mostrarEnPantalla(Concesionaria c){
		c.mostrarVehiculos();
		System.out.println("=============================");
		System.out.print("Vehiculo mas caro: ");
		c.buscarVehiculoMasCaro();
		System.out.print("Vehiculo mas barato: ");
		c.buscarVehiculoMasBarato();
		c.buscarModeloPorLetra("Y");
		System.out.println("=============================");
		System.out.println("Vehiculos ordenados por precio de mayor a menor:");
		c.ordenarMayorAMenor();	
	}
}
