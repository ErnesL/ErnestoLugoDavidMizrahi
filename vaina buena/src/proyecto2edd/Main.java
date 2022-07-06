/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2edd;

import static proyecto2edd.ManejoArchivo.*;

/**
 *
 * @author davidmizrahi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Articulo articulo = new Articulo();

        Interfaz ventana = new Interfaz();
        ventana.setVisible(true);
        leerBDD();

    }

}
