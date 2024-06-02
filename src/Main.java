import punto3.Juego;
import punto4.Alumno;
import punto4.Colegio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        menu(scanner);
    }
    public static void menu(Scanner scanner){
        do{
            try{
                mostrarConsignas();
                System.out.println("ingrese el ejercicio");
                switch (scanner.nextInt()) {
                    case 1 -> punto1();
                    case 2 -> punto2();
                    case 3 -> punto3();
                    case 4 -> punto4();
                    default -> System.out.println("wachin");
                }
                System.out.println("n parar cortar");
            }catch (InputMismatchException e){
                System.out.println("Un numero pajero");
                scanner.nextLine();
            }

        }while(!scanner.next().equalsIgnoreCase("n"));
    }
    public static void mostrarConsignas(){
        //VER COMO HACER TEXT BLOCK
        System.out.println("Punto 1: ");
        System.out.println("""
                ¿Qué está mal en el siguiente bloque de código?
                 try { Persona p = baseDeDatos.buscar(datos);\s
                System.out.println(“Los datos pertenecen a: ” + p);}
                catch(Exception e) {// Maneja cualquiera de las excepciones comprobadas}
                catch(RuntimeException e) {// Maneja cualquiera de las excepciones no comprobadas }

                """);
        System.out.println("Punto 2: ");
        System.out.println("""
                public static class EjemploExcepciones{ public
                static int devuelveNumero(int num) { try {
                if (num % 2 == 0) {
                throw new Exception("Lanzando excepcion");
                }
                return 1;
                } catch (Exception ex) { ex.getMessage().concat("Rompi
                todo y pase por Catch"); return 2;
                } finally {
                return 3;
                }
                }
                }

                """);
        System.out.println("Punto 3: ");
        System.out.println("""
                Escribe un programa que juegue con el usuario a adivinar un número.
                 El ordenador debe generar un número entre 1 y 500, y el usuario tiene que intentar adivinarlo.
                Para ello, cada vez que el usuario introduce un valor, el ordenador debe decirle al usuario si el número que tiene que adivinar es mayor o menor que el que ha introducido el usuario.
                Cuando consiga adivinarlo, debe indicarlo e imprimir en pantalla el número de veces que el usuario ha intentado adivinar el número.
                Si el usuario introduce algo que no es un número, debe indicarlo en pantalla, lanzar una excepción y contarlo como un intento. Investigar qué excepción controla el tipo de datos ingresados.

                """);
        System.out.println("Punto 4: ");
        System.out.println("""
                Crea una clase colegio que almacene el listado de los alumnos (compuestos por su nombre y nacionalidad). La clase tendrá los siguientes métodos:
                agregarAlumno(Alumno alumno): añade la nacionalidad de un nuevo alumno
                verNacionalidad(String nacionalidad): Muestra la nacionalidad y el número de alumnos de esa nacionalidad.
                cuantos(): Muestra cuántas nacionalidades diferentes existen en el colegio.
                borrar(Alumno alumno): Elimina los datos insertados.
                VerTodos(): Muestra las distintas nacionalidades y el número de alumnos que existen por nacionalidad.
                Para todos estos métodos se deben generar distintas validaciones para prevenir errores en la ejecución. Por ej: Que todos los alumnos tengan una nacionalidad, que exista el alumno que se quiere borrar, etc.

                """);
    }
    public static void punto1(){
        System.out.println("Lo que esta mal en el punto es que el primer catch es de cualquier excepcion, por lo que el segundo catch es redundante, jabria que cambiar el orden de los catch");
    }
    public static void punto2(){
        System.out.println("Lo que pase en este punto es que el metodo arroja una excepcion, pero esta se trata de caorturar en el mismo metodo lo cual esta mal, lo que habira que hacer es llamar a este metodo en un try y catchear la excepcion");
    }
    public static void punto3(){
        Juego juego=new Juego();
        juego.jugar();
    }
    public static void punto4(){
        //VER QUE ES UN RECORD
        Colegio colegio=new Colegio();
        Alumno alumno=new Alumno("ivi","arg");
        Alumno alumno1=new Alumno("pablo","arg");
        colegio.agregarAlumno(alumno);colegio.agregarAlumno(alumno1);colegio.agregarAlumno(new Alumno("Marcos","Turco"));colegio.agregarAlumno(new Alumno("Lucchi","Vasca"));colegio.agregarAlumno(new Alumno("peke","arg"));
        colegio.borrarAlumno(new Alumno("elGordo","arg"));
        colegio.mostrar();
    }
}