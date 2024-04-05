import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static ArrayList<Persona> lPersonas;
    static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
        lPersonas = new ArrayList<Persona>();
        cargarPersonas();
    }

    private static void cargarPersonas() {
        int num = 0;
        while(num == 0){

            System.out.println("Ingrese el nombre");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese la edad");
            int edad = scanner.nextInt();
            
            Persona p = new Persona(nombre, apellido, edad);
            lPersonas.add(p);

            System.out.println("Ingrese 0 para cargar, 1 para salir");
            num = scanner.nextInt();
            scanner.nextLine();

        }

        mostrarPersonas();
    }

    private static void mostrarPersonas() {
        System.out.println("LISTA DE PERSONAS:");
        for(Persona p : lPersonas){
            System.out.println("--------");
            p.ToString();
        }
    }
}
