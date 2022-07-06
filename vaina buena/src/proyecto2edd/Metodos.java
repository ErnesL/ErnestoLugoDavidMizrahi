/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 * Aqui implementamos la funcion hash que nos va a generar la clave para cada
 * articulo
 *
 * @author davidmizrahi
 */
public class Metodos {

    public static int contarPalabras(Articulo articulo) {
        String[] array = new String[400];
        Nodo aux = articulo.getPalabrasClave().getpFirst();
        String cantidadDeVeces = "";

        int i = 1;

        while (aux != null) {

            array = articulo.getCuerpo().split(aux.getInfo().toString());

            System.out.print("Numero de veces que aparece la palabra clave " + i + ": ");

            System.out.println(array.length - 1);
            cantidadDeVeces += "Frecuencia con la que aparece la palabra clave " + aux.getInfo().toString() + ": " + Integer.toString(array.length - 1) + "\n";

            aux = aux.getpNext();
            i++;

        }

        return array.length - 1;

    }

    public static String[] eliminarIguales(String a[], int n) {

        if (n == 0 || n == 1) {

        }

        String[] temp = new String[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                temp[j++] = a[i];
            }

        }

        temp[j++] = a[n - 1];

        for (int i = 0; i < j; i++) {
            a[i] = temp[i];

        }
        return temp;
    }

}
