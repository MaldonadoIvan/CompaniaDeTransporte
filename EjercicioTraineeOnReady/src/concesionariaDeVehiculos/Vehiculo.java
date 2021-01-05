package concesionariaDeVehiculos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class Vehiculo implements Comparable<Vehiculo>{
	private String marca;
	private String modelo;
	private double precio;
	
	public Vehiculo(String marca, String modelo,double precio){
		setMarca(marca);
		setModelo(modelo);
		setPrecio(precio);
	}

	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}
	
	public String getPrecioFormat(){
		return formatearValor(precio);
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}

	private String formatearValor(double valor){
		DecimalFormatSymbols simbolo = new DecimalFormatSymbols(); 
		 simbolo.setDecimalSeparator(',');
		 simbolo.setGroupingSeparator('.');
		DecimalFormat formatea = new DecimalFormat("###,###.00",simbolo);
		return formatea.format(valor);
	}

	
	@Override
	public String toString() {
		return "Marca: " + this.getMarca() + " // Modelo: " + this.getModelo() + " // Precio: $" + this.getPrecioFormat();
	}
	
	@Override
	public int compareTo(Vehiculo e){
		if(e.getPrecio() < precio){
			return -1;
		}else if(e.getPrecio() < precio){
			return 0;
		}else{
			return 1;
		}
	}
}
