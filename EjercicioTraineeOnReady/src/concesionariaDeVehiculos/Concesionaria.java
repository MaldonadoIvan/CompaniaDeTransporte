package concesionariaDeVehiculos;

import java.util.ArrayList;
import java.util.Collections;


public class Concesionaria {
	private ArrayList<Vehiculo> vehiculos;
	
	public Concesionaria(){
		this.vehiculos = new ArrayList<>();
	}
	
	public void agregarVehiculo(Vehiculo vehiculo){
		vehiculos.add(vehiculo);
	}
	
	public void mostrarVehiculos(){
		for (Vehiculo vehiculo : vehiculos) {
			if(vehiculo instanceof Auto){
				Auto a =(Auto)vehiculo;
				System.out.println(a.toString());
			}
			else{
				Moto m = (Moto)vehiculo;
				System.out.println(m.toString());
			}
		}
	}
	
	public void buscarVehiculoMasCaro(){
		double precioVehiculoMasCaro = 0;
		double precioVehiculoActual;
		Vehiculo vehiculoMasCaro = null;
		for (Vehiculo vehiculo : vehiculos) {
			precioVehiculoActual = vehiculo.getPrecio();
			if(precioVehiculoActual > precioVehiculoMasCaro){
				precioVehiculoMasCaro = precioVehiculoActual;
				vehiculoMasCaro = vehiculo;
			}
		}
		System.out.println(vehiculoMasCaro.getMarca()+" "+ vehiculoMasCaro.getModelo());
	}
	
	public void buscarVehiculoMasBarato(){
		double precioVehiculoMasBarato = Integer.MAX_VALUE;
		double precioVehiculoActual;
		Vehiculo vehiculoMasBarato = null;
		for (Vehiculo vehiculo : vehiculos) {
			precioVehiculoActual = vehiculo.getPrecio();
			if(precioVehiculoActual < precioVehiculoMasBarato){
				precioVehiculoMasBarato = precioVehiculoActual;
				vehiculoMasBarato = vehiculo;
			}
		}
		System.out.println(vehiculoMasBarato.getMarca()+" "+ vehiculoMasBarato.getModelo());
	}
	
	public void buscarModeloPorLetra(String letra){
		int i = 0;
		Vehiculo modeloBuscado = null;
		Vehiculo vehiculoActual;
		while(i < vehiculos.size() && modeloBuscado == null){
			vehiculoActual = vehiculos.get(i);
			if(buscarLetra(vehiculoActual.getModelo(),letra)){
				modeloBuscado = vehiculoActual;
				System.out.println("Vehículo que contiene en el modelo la letra "+'"'+ letra+ '"'+": "
				+ vehiculoActual.getMarca() +" "+ vehiculoActual.getModelo() +" $"+ vehiculoActual.getPrecioFormat()); 
				}
			i++;
		}
	}
	
	private boolean buscarLetra(String modelo, String letra){
		boolean existe = false;
		char[] vector = modelo.toCharArray();
		int i = 0;
		while (i < vector.length && !existe ) {
			String letraActual = String.valueOf(vector[i]);
			if(letra.equals(letraActual)){
				existe = true;
			}
			i++;
		}
		return existe;
	}
	
	public void ordenarMayorAMenor(){
		Collections.sort(vehiculos);
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo());
		}
	}
}
