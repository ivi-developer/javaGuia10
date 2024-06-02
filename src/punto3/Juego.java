package punto3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    Integer cantIntentos;
    Integer num;
    public Juego(){
        num=numRand();
        cantIntentos=0;
    }
    private Integer numRand(){return new Random().nextInt(1,500);}
    public void jugar(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            try {
                System.out.println("Adivina");
                int n=scanner.nextInt();
                cantIntentos++;
                if(n>num) System.out.println("El num es menor");
                else if (n<num) System.out.println("El num es mayor");
                else{
                    System.out.println("FELICIDADES WACHIN, cant intentos="+cantIntentos);
                    return;
                }
            }catch (InputMismatchException e){
                System.out.println("Pelotudo eso no es un numero");
                cantIntentos++;
                if(scanner.hasNextLine()) scanner.next();
            }
        }
    }
}
