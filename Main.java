import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AddressBook agenda = new AddressBook();
        agenda.load(); // Cargar contactos al iniciar

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n--- AGENDA TELEFÓNICA ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    agenda.list();
                    break;

                case 2:
                    System.out.print("Ingresa el número: ");
                    String numero = scanner.nextLine();

                    System.out.print("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();

                    agenda.create(numero, nombre);
                    break;

                case 3:
                    System.out.print("Ingresa el número a eliminar: ");
                    String numeroEliminar = scanner.nextLine();

                    agenda.delete(numeroEliminar);
                    break;

                case 4:
                    agenda.save();
                    System.out.println("Agenda guardada. Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}