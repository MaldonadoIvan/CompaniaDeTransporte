package comp.trans.clases;
import comp.trans.implementaciones.ColaNodos;
import comp.trans.interfaces.Cola;

public class CompaniaDeTransportes {
	private static int ultimoLegajo = 0;

	private ListaChoferes staff;
	private ListaVehiculos flota;
	private Cola<Vehiculo> viajesListos;

	// 1 - Crear las estructuras propuestas
	public CompaniaDeTransportes() {
		staff = new ListaChoferes();
		flota = new ListaVehiculos();
		viajesListos = new ColaNodos<Vehiculo>();
	}

	public void altaChofer(int dni, String nombre) {
		Chofer chofer = staff.search(dni);
		if (chofer != null) {
			throw new RuntimeException("Chofer existente!");
		}
		staff.add(new Chofer(dni, proximoLegajo(), nombre));
	}

	public Chofer bajaChofer(int dni) {
		Chofer chofer = staff.search(dni);
		if (chofer != null) {
			if (chofer.getVehiculo() == null)
				staff.remove(chofer);
			else
				throw new RuntimeException("No se puede despedir a un chofer en viaje!");
		}
		return chofer;
	}

	public void altaVehiculo(String patente, TipoVehiculo tipoVehiculo, double capacidadDeCarga) {
		Vehiculo vehiculo = flota.search(patente);
		if (vehiculo != null) {
			throw new RuntimeException("Vehiculo existente!");
		}
		flota.add(new Vehiculo(patente, tipoVehiculo, capacidadDeCarga));
	}

	private static int proximoLegajo() {
		return ++ultimoLegajo;
	}

	public void listarChoferes() {
		for (Chofer chofer : staff) {
			System.out.println(chofer);
		}
	}

	public void listarVehiculos() {
		for (Vehiculo vehiculo : flota) {
			System.out.println(vehiculo);
		}
	}

	// 2 - Asignar un vehiculo a un chofer (utilizando Excepciones)
	public void asignarVehiculo(String patenteVehiculo, int dniChofer) {
		
		// TODO implementar
		Vehiculo vehiculoAux = flota.search(patenteVehiculo);
	    Chofer choferAux = staff.search(dniChofer); 
	   
		if (vehiculoAux == null) {
			throw new RuntimeException("Vehiculo o Chofer inexistente!");
		}
		
		if (choferAux == null) {
			throw new RuntimeException("Chofer inexistente!");
		}
		
		vehiculoAux.asignarChofer(choferAux);
		choferAux.asignarVehiculo(vehiculoAux);
		
	}

	// 3 - Asignar una carga (utilizando Excepciones) al vehiculo que más se
	// adapte al peso de la carga.
	// a - Vehiculo con conductor asignado.
	// b - No debe tener carga asignada.
	// c - Su capacidad debe ser mayor o igual al peso de la carga.
	// De todos los vehículos posibles debe quedarse con el menor de todos
	// ellos.
	//
	// Si se logra asignar la carga el vehiculo debe agregarse a la cola de
	// vehiculos listos para partir.
	public void asignarCarga(Carga carga) {
		
		Vehiculo vehiculoAux = null;
		
		System.out.println("\n*** ASIGNACION DE CARGA ***");
		
		for (Vehiculo vehiculo : flota) {
	
			if(vehiculo.getChoferACargo() != null && vehiculo.getCargaAsignada() == null) {  //a y b
				
				if(vehiculo.getCapacidadDeCarga() >= carga.getPeso()) {
					
					if(vehiculoAux == null) {
						vehiculoAux = vehiculo;
					}
					else if(vehiculo.getCapacidadDeCarga() < vehiculoAux.getCapacidadDeCarga())
					{
						vehiculoAux = vehiculo;
					}
			
				}
				
			}
			
		}
		
		if (vehiculoAux == null) {
			throw new RuntimeException("Los vehiculos actuales no soportan la carga");
		}
		vehiculoAux.asignarCarga(carga);
		viajesListos.add(vehiculoAux);
		
		System.out.println("Carga a transportar: " + carga.getDescripcion() + " ("+ carga.getPeso() +") kg");
		
		// TODO implementar
	}

	
	// 4 - Listar choferes libres (que no estan de viaje)
	public void listarChoferesLibres() {
		System.out.println("\n--- Choferes Libres ---");
		// TODO implemetar
		
		for (Chofer chofer : staff) {
			
			if(chofer.ListoParaViajar() == false) {
				System.out.println(chofer.getDni() + " - " + chofer.getNombre());
			}
			
		}
		
		
	}

	// 5 - Listar los vehiculos listos para salir de viaje (la estructura debe
	// quedar en el orden inicial).
	public void listarVehiculosListosParaPartir() {
		// TODO implementar
		
		Vehiculo centinela = null;
		viajesListos.add(centinela);
		
	    while(viajesListos.get() != centinela) {
	    
	    	Vehiculo aux = viajesListos.remove();
	    	
	    	System.out.println("El Vehiculo con patente " + aux.getPatente() + " esta listo para salir");
	    	System.out.println("El conductor del vehiculo es " + aux.getChoferACargo().getNombre() 
	    			+ " y la carga asignada "+ aux.getCargaAsignada().getDescripcion() + " (" + aux.getCargaAsignada().getPeso()+ ")");
	    	
	    	viajesListos.add(aux);
	    	
	    }
		
	    viajesListos.remove();
	    
	}

}