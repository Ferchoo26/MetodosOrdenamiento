package Modelo;

import java.util.Scanner;

public class RadixSort {

    private static long accesos;

    public static void sort(Integer[] a) {

        accesos = 0;

        if (a == null || a.length == 0) {
            return;
        }

        System.out.println("Arreglo inicial:");
        show(a);

        int max = getMax(a);

        for (int exp = 1; max / exp > 0; exp *= 10) {

            countingSort(a, exp);

            if (exp == 1) {
                System.out.println("Pasada por unidades:");
            } else if (exp == 10) {
                System.out.println("Pasada por decenas:");
            } else if (exp == 100) {
                System.out.println("Pasada por centenas:");
            } else {
                System.out.println("Pasada por posicion " + exp + ":");
            }

            show(a);
            System.out.println();
        }

        System.out.println("Arreglo ordenado:");
        show(a);

        System.out.println("Esta ordenado? " + isSorted(a));
        System.out.println("Accesos al arreglo: " + accesos);
    }

    private static void countingSort(Integer[] a, int exp) {

        int n = a.length;

        Integer[] output = new Integer[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {

            int valor = a[i];
            accesos++;

            int digito = (valor / exp) % 10;

            count[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {

            int valor = a[i];
            accesos++;

            int digito = (valor / exp) % 10;

            output[count[digito] - 1] = valor;
            accesos++;

            count[digito]--;
        }

        for (int i = 0; i < n; i++) {

            a[i] = output[i];
            accesos += 2;
        }
    }

    private static int getMax(Integer[] a) {

        int max = a[0];
        accesos++;

        for (int i = 1; i < a.length; i++) {

            int valor = a[i];
            accesos++;

            if (valor > max) {
                max = valor;
            }
        }

        return max;
    }

    private static void show(Integer[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    public static boolean isSorted(Integer[] a) {

        for (int i = 1; i < a.length; i++) {

            if (a[i] < a[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static long getAccesos() {
        return accesos;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros: ");
        int cantidad = teclado.nextInt();

        Integer[] numeros = new Integer[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el numero " + (i + 1) + ": ");
            numeros[i] = teclado.nextInt();
        }

        System.out.println();

        sort(numeros);

        teclado.close();
    }
}