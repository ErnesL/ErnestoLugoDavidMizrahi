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

//    public static int hashFunc(Articulo articulo){
//    
//        int ascii = 0;
//        
//        String str = articulo.getTitulo();
//  
//        // Creating array of string length
//        // using length() method
//        char[] ch = new char[str.length()];
//  
//        // Copying character by character into array
//        // using for each loop
//        for (int i = 0; i < str.length(); i++) {
//            ch[i] = str.charAt(i);
//        }
////        char character = 'a';   
//        for (int i = 0; i < ch.length; i++) {
//            
//             ascii += (int) ch[i];
//            
//        }
//    boolean flag = false;
//    for (int i = 2; i <= ascii / 2; ++i) {
//      // condition for nonprime number
//      if (ascii % i == 0) {
//        flag = true;
//        break;
//      }
//    }
//
//    if (!flag)
//      System.out.println(ascii + " is a prime number.");
//    else
//      System.out.println(ascii + " is not a prime number.");
//  
//        
//        
//        System.out.println(articulo.getTitulo());
//        int index = ascii % 13;
//        System.out.println(index);
//        return 0;
//    
//        
//    }
//    
//    public static int contarPalabras(Articulo articulo) {
//        String[] array = new String[400];
//        Nodo aux = articulo.getPalabrasClave().getpFirst();
//
//        int i = 1;
//
//        while (aux != null) {
//
//            array = articulo.getCuerpo().split(aux.getInfo().toString());
//
//            System.out.print("Numero de veces que aparece la palabra clave " + i + ": ");
//
//            System.out.println(array.length - 1);
//
//            aux = aux.getpNext();
//            i++;
//
//        }
//
//        return array.length - 1;
//
//    }
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

}
