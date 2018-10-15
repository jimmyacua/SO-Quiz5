/*
* Quiz 5: Problema del oso y las abejas
* Hecho por Jimmy Acuña Díaz - B50060
* Para compilar y correr: "javac AAbYOsoMonitor.java" seguido de:
* "java AbYOsoMonitor"
*/


import java.util.Scanner;

public class AbYOsoMonitor extends Thread{

    public static void main(String args[]) throws InterruptedException{
        System.out.println("Digite el tamaño o capacidad del tarro");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        int cantMax = Integer.parseInt(entradaTeclado);


        System.out.println("Digite la cantidad de abejas");
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        int N = Integer.parseInt(entradaTeclado);

        System.out.println("Digite el tamaño de la porcion de las abejas");
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        int porcion = Integer.parseInt(entradaTeclado);



        int canDep = 0;
        Monitor monitor = new Monitor(cantMax, porcion);
        Thread oso = new Thread();
        oso = new Oso(cantMax, canDep, monitor);
        oso.start();
        Thread[] abejas = new Thread[N];
        for(int i=0; i< N; i++){
           abejas[i] = new Abeja(cantMax, canDep, monitor, porcion);
           abejas[i].start();
        }

    }
}
