
package practica2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GestorLogistico {
    
    // Coleccion para almacenar la flota
    private List<Vehiculo> vehiculos = new ArrayList<>();

    // ejercicio 1: IMPLEMENTACION DE CRUD

    // Metodo para agregar un nuevo vehiculo a la lista
    public void crearVehiculo(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("Vehiculo creado exitosamente");
    }

    // Ejercicio 2: Uso de Expresiones Lambda / Metodo para mostrar todos los vehiculos
    public void listarVehiculos() {
        // Recorrer la coleccion utilizando forEach y mostrar informacion
        vehiculos.forEach(v -> System.out.println(v.toString()));
    }

    // Metodo para encontrar un vehiculo especifico por su identificador
    public Vehiculo buscarVehiculo(String id) {
        return vehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Metodo para actualizar los datos de un vehiculo existente
    public void modificarVehiculo(String id, String nuevoTipo, boolean nuevoConectable) {
        Vehiculo v = buscarVehiculo(id);
        if (v != null) {
            v.setTipo(nuevoTipo);
            v.setConectable(nuevoConectable);
            System.out.println("Vehiculo modificado correctamente");
        } else {
            System.out.println("No se encontro el vehiculo con ID: " + id);
        }
    }

    // Metodo para remover un vehiculo de la coleccion usando lambda
    public void eliminarVehiculo(String id) {
        boolean eliminado = vehiculos.removeIf(v -> v.getId().equals(id));
        if (eliminado) {
            System.out.println("Vehiculo eliminado");
        }
    }

    // Ejercicio 3: PROCESAMIENTO CON STREAMS 

    // Filtrar vehiculos que tienen la propiedad conectable en true
    public List<Vehiculo> filtrarConectables() {
        return vehiculos.stream()
                .filter(Vehiculo::isConectable)
                .collect(Collectors.toList());
    }

    // Extraer unicamente los identificadores de todos los vehiculos
    public List<String> obtenerListaIds() {
        return vehiculos.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }

    // Obtener la cantidad total de vehiculos en el sistema
    public long contarVehiculos() {
        return vehiculos.stream().count();
    }

    // Buscar todos los vehiculos que coincidan con un tipo especifico
    public List<Vehiculo> buscarPorTipo(String tipo) {
        return vehiculos.stream()
                .filter(v -> v.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    // Ejercicio 4: ORDENAMIENTO

    // Ordenar la lista principal alfabeticamente por ID
    public void ordenarPorId() {
        vehiculos.sort(Comparator.comparing(Vehiculo::getId));
        System.out.println("Flota ordenada por ID");
    }

    // Ordenar la lista principal alfabeticamente por tipo
    public void ordenarPorTipo() {
        vehiculos.sort(Comparator.comparing(Vehiculo::getTipo));
        System.out.println("Flota ordenada por Tipo");
    }

    // Ejercicio 6: Estadisticas basicas
    
    // Generar un pequeño reporte de la flota actual
    public void generarReporteEstadistico() {
        System.out.println("--- REPORTE DE FLOTA ---");
        System.out.println("Total de vehiculos registrados: " + contarVehiculos());
        System.out.println("Total de vehiculos conectables: " + filtrarConectables().size());
        System.out.println("------------------------");
    }
}
