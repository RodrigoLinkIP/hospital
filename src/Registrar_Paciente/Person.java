
package Registrar_Paciente;
import java.util.Scanner;
public class Person {
    public static void main(String[] args) {
        String nombre;
        String apellido;
        String nacimiento;
        String telefono;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        apellido = scanner.nextLine();
        System.out.print("Ingrese su fecha de nacimiento: ");
        nacimiento = scanner.nextLine();
        System.out.print("Ingresa su numero de telefono: ");
        telefono = scanner.nextLine();

        System.out.println("Nombre: " + nombre +"\nApellido: "+ apellido + "\nFecha de Nacimiento: " + nacimiento+ telefono);

    }
}