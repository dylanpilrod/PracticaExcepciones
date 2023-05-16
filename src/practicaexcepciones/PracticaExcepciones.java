/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
import practicaexcepciones.Parking;
/**
 *
 * @author dylanpilrod
 */
public class PracticaExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Parking parking = new Parking("Parking Centro", 10);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menu de opciones -----");
            System.out.println("(1) Entrada de coche");
            System.out.println("(2) Salida de coche");
            System.out.println("(3) Mostrar parking");
            System.out.println("(4) Salir del programa");
            System.out.print("Ingrese la opcion que desee: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Porfavor, ingrese la matrícula del coche: ");
                        String matricula = scanner.nextLine();
                        System.out.print("Ingrese el numero de plaza: ");
                        int plaza = Integer.parseInt(scanner.nextLine());
                        parking.entrada(matricula, plaza);
                        System.out.println("El coche a entrado sin problema.");
                        System.out.println("Plazas totales: " + parking.getPlazasTotales());
                        System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                        System.out.println("Plazas libres: " + parking.getPlazasLibres());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Ingrese la matrícula del coche: ");
                        String matricula = scanner.nextLine();
                        int plazaLibre = parking.salida(matricula);
                        System.out.println("Salida de coche realizada con éxito.");
                        System.out.println("Plaza liberada: " + plazaLibre);
                        System.out.println("Plazas totales: " + parking.getPlazasTotales());
                        System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                        System.out.println("Plazas libres: " + parking.getPlazasLibres());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println(parking.toString());
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intentalo de nuevo.");
                    break;
            }
            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }
    }
    
