import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class AddressBook {

    private HashMap<String, String> contactos;

    public AddressBook() {
        contactos = new HashMap<>();
    }

    public void load() {
        try {
            File file = new File("contactos.csv");

            if (!file.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length == 2) {
                    String numero = partes[0];
                    String nombre = partes[1];
                    contactos.put(numero, nombre);
                }
            }

            reader.close();
            System.out.println("Contactos cargados correctamente.");

        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.csv"))) {

            for (String numero : contactos.keySet()) {
                String nombre = contactos.get(numero);
                writer.write(numero + "," + nombre);
                writer.newLine();
            }

            System.out.println("Contactos guardados correctamente.");

        } catch (Exception e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void list() {
        System.out.println("Contactos:");

        for (String numero : contactos.keySet()) {
            String nombre = contactos.get(numero);
            System.out.println(numero + " : " + nombre);
        }
    }

    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        System.out.println("Contacto agregado.");
    }

    public void delete(String numero) {
        if (contactos.containsKey(numero)) {
            contactos.remove(numero);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("El número no existe en la agenda.");
        }
    }
}