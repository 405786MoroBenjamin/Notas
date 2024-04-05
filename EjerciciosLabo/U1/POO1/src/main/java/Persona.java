public class Persona {
    String nombre;
    String apellido;
    int edad;

    public Persona(String nombre, String apellido, int edad){
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void ToString(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }


}
