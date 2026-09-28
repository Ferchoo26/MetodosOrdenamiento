package Interfaz;

import Modelo.RadixSort;
import java.util.Scanner;

public class InterfazApp {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros: ");
        int cantidad = teclado.nextInt();

        Integer[] numeros = new Integer[cantidad];

        System.out.println("Ingrese los numeros:");

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = teclado.nextInt();
        }

        System.out.println();

        RadixSort.sort(numeros);

        teclado.close();
    }
}