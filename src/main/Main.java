
package main;
import practica2.GestorLogistico;
import practica2.Vehiculo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // gestor y el scanner para lectura de datos
        GestorLogistico gestor = new GestorLogistico();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=--= SISTEMA DE GESTION LOGISTICA UNI =--=");

        while (opcion != 9) {
            System.out.println("\n_-_- MENU PRINCIPAL -_-_");
            System.out.println("1. Crear Vehiculo");
            System.out.println("2. Listar todos los Vehiculos");
            System.out.println("3. Modificar Vehiculo");
            System.out.println("4. Eliminar Vehiculo");
            System.out.println("5. Filtrar Conectables (Streams)");
            System.out.println("6. Buscar por Tipo (Streams)");
            System.out.println("7. Ordenar Flota (ID / Tipo)");
            System.out.println("8. Ver Reporte Estadistico");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: por favor ingrese un numero valido");
                continue;
            }

            switch (opcion) {
                case 1: // Crear
                    System.out.print("Ingrese ID del vehiculo : ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese Tipo : ");
                    String tipo = scanner.nextLine();
                    System.out.print("Es conectable? (true/false): ");
                    boolean con = Boolean.parseBoolean(scanner.nextLine());
                    
                    gestor.crearVehiculo(new Vehiculo(id, tipo, con));
                    break;

                case 2: // leer o Listar
                    System.out.println("\n_-_- LISTA DE VEHICULOS -_-_");
                    gestor.listarVehiculos();
                    break;

                case 3: // actualizar o modificar
                    System.out.print("Ingrese el ID del vehiculo a modificar: ");
                    String idMod = scanner.nextLine();
                    System.out.print("Nuevo Tipo: ");
                    String nTipo = scanner.nextLine();
                    System.out.print("Nuevo estado conectable? (true/false): ");
                    boolean nCon = Boolean.parseBoolean(scanner.nextLine());
                    
                    gestor.modificarVehiculo(idMod, nTipo, nCon);
                    break;

                case 4: // Borrar
                    System.out.print("Ingrese el ID del vehiculo a eliminar: ");
                    String idDel = scanner.nextLine();
                    gestor.eliminarVehiculo(idDel);
                    break;

                case 5: // STREAMS - Filtrar
                    System.out.println("\nVehiculos Conectables detectados:");
                    gestor.filtrarConectables().forEach(System.out::println);
                    break;

                case 6: // STREAMS - Buscar por tipo
                    System.out.print("Ingrese el tipo a buscar: ");
                    String tipoBusq = scanner.nextLine();
                    gestor.buscarPorTipo(tipoBusq).forEach(System.out::println);
                    break;

                case 7: // ORDENAMIENTO
                    System.out.println("1. Ordenar por ID | 2. Ordenar por Tipo");
                    int subOp = Integer.parseInt(scanner.nextLine());
                    if (subOp == 1) gestor.ordenarPorId();
                    else gestor.ordenarPorTipo();
                    break;

                case 8: // MEJORA - Estadisticas
                    gestor.generarReporteEstadistico();
                    break;

                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
        scanner.close();
    }
}