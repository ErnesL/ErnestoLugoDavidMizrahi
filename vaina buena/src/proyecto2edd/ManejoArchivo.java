/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static proyecto2edd.Interfaz.hashAutores;
import static proyecto2edd.Interfaz.hashPalabras;
import static proyecto2edd.Interfaz.hashTitulo;
import static proyecto2edd.Interfaz.listaArticulos;

/**
 *
 * @author davidmizrahi
 */
public class ManejoArchivo {

    //Esta funcionalidad permite la creacion y escritura del archivo.
    public static void crearArchivo(String resumenes) {

        try {
            PrintWriter pw = new PrintWriter("test//resumenes.txt");
            pw.print(resumenes);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void lecturaArchivo(String resumen, Articulo articulo, Lista listaArticulos, HashTable hashTitulo, HashTable hashAutores, HashTable hashPalabras) {

        Scanner scanner = new Scanner(resumen);
        int i = 0;
        String[] arrayCampos = new String[15];
        String linea = "";
        Lista<String> autores = new Lista<>();
        Lista<String> palabrasClave = new Lista<>();
        String concatenado = "";

        while (scanner.hasNext()) {
            linea = scanner.nextLine();
            arrayCampos[i] = linea;
            i++;
        }

//Verificacion de si existe el articulo en la base de datos.
        String titulo = arrayCampos[0];

        boolean encontrado = false;

        if (!listaArticulos.esVacio()) {

            Nodo aux = listaArticulos.getpFirst();

            //TODO regresar aca a tratar de optimizar la funcion Buscar() de la clase Lista
            for (int k = 0; k < listaArticulos.Size(); k++) {

                Articulo aux1 = (Articulo) aux.getInfo();

                if (titulo.toLowerCase().equals(aux1.getTitulo().toLowerCase())) {

                    encontrado = true;

                } else {
                    aux = aux.getpNext();

                }

            }

            //Afuera del for
            if (encontrado == true) {
                JOptionPane.showMessageDialog(null, "Error. El archivo que se intenta cargar ya se encuentra en la base de datos.");

            } else {

                articulo.setTitulo(titulo);
                int j = 0;
                while (j < arrayCampos.length) {

                    if (arrayCampos[j] != null) {

                        if (arrayCampos[j].contains("Autores")) {

                            while (!arrayCampos[j + 1].contains("Resumen")) {

                                autores.agregarElemento(arrayCampos[j + 1]);
                                j++;
                            }
                        } else if (arrayCampos[j].contains("Resumen")) {

                            articulo.setCuerpo(arrayCampos[j + 1]);

                        } else if (arrayCampos[j].contains("Palabras")) {

                            break;
                        }
                    }
                    j++;
                }

                articulo.setAutores(autores);
                String keyWords = arrayCampos[j].substring(17).replace(", ", "/");

                String[] keyWordsArr = keyWords.split("/");

                for (int k = 0;
                        k < keyWordsArr.length;
                        k++) {

                    palabrasClave.agregarElemento(keyWordsArr[k]);

                }

                articulo.setPalabrasClave(palabrasClave);

                articulo.agregarABaseDeDatos();

                articulo.mostrarInfo();

                listaArticulos.agregarElemento(articulo);

                //hash
                hashTitulo.put(articulo, articulo);
                Nodo aux1 = articulo.getAutores().getpFirst();
                for (int k = 0; k < articulo.getAutores().Size(); k++) {
                    hashAutores.put_listas(aux1, articulo);

                    aux1 = aux1.getpNext();

                }

                Nodo aux2 = articulo.getPalabrasClave().getpFirst();
                for (int k = 0; k < articulo.getPalabrasClave().Size(); k++) {
                    hashPalabras.put_listas(aux2, articulo);

                    aux2 = aux2.getpNext();

                }

            }
        } else { //Si esta vacia la lista
//proceso de agregar articulo

            articulo.setTitulo(titulo);
            int j = 0;
            while (j < arrayCampos.length) {

                if (arrayCampos[j] != null) {

                    if (arrayCampos[j].contains("Autores")) {

                        while (!arrayCampos[j + 1].contains("Resumen")) {

                            autores.agregarElemento(arrayCampos[j + 1]);
                            j++;
                        }
                    } else if (arrayCampos[j].contains("Resumen")) {

                        articulo.setCuerpo(arrayCampos[j + 1]);

                    } else if (arrayCampos[j].contains("Palabras")) {

                        break;
                    }
                }
                j++;
            }

            articulo.setAutores(autores);
            String keyWords = arrayCampos[j].substring(17).replace(", ", "/");

            String[] keyWordsArr = keyWords.split("/");

            for (int k = 0;
                    k < keyWordsArr.length;
                    k++) {

                palabrasClave.agregarElemento(keyWordsArr[k]);

            }

            //Articulos
            articulo.setPalabrasClave(palabrasClave);

            articulo.agregarABaseDeDatos();

            articulo.mostrarInfo();

            listaArticulos.agregarElemento(articulo);

            //Hash
            hashTitulo.put(articulo, articulo);
            Nodo aux1 = articulo.getAutores().getpFirst();
            for (int k = 0; k < articulo.getAutores().Size(); k++) {
                hashAutores.put_listas(aux1, articulo);

                aux1 = aux1.getpNext();

            }

            Nodo aux2 = articulo.getPalabrasClave().getpFirst();
            for (int k = 0; k < articulo.getPalabrasClave().Size(); k++) {
                hashPalabras.put_listas(aux2, articulo);

                aux2 = aux2.getpNext();

            }

        }
    }

    public static void eliminarArchivo() {
        File f0 = new File("test//resumenes.txt");
        if (f0.delete()) {
            System.out.println(f0.getName() + " file is deleted successfully.");
        } else {
            System.out.println("Unexpected error found in deletion of the file.");
        }

    }

    public static void leerBDD() {
        String articulos = "";
        String path = "test\\basededatos.txt";
        String line;
        File file = new File(path);
        String autoresconcatenados = "";

        try {
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo 'basededatos.txt' fue borrado. Se esta creando de nuevo ...");
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        articulos += line + "\n";
                    }
                }
                if (!"".equals(articulos)) {
                    //Si el super string no esta vacio
                    String[] articulos_split = articulos.split("\n");
                    for (int i = 0; i < articulos_split.length; i++) {

                        Lista listaAutores = new Lista();
                        Lista listaPalabras = new Lista();
                        Articulo articulo = new Articulo();

                        //Separa la informacion por "//". titulo -> 0; autores -> 1; cuerpo -> 2; palabrasclaves -> 3.
                        String[] articulo_objeto = articulos_split[i].split("//");

                        //Separa la informacion de los autores refiriendose al indice 1 y separando por ","
                        String[] articulo_objeto_autores = articulo_objeto[1].split(",");

                        //Separa la informacion de las palabras claves refiriendose al indice 3 y separando por ","
                        String[] articulo_objeto_palabrasClave = articulo_objeto[3].split(",");

                        //Agrega la informacion del array articulo_objeto_autores en una listaAutores.
                        for (int j = 0; j < articulo_objeto_autores.length; j++) {
                            listaAutores.agregarElemento(articulo_objeto_autores[j]);
                        }

                        //Agrega la informacion del array articulo_objeto_palabrasclave en una listaPalabras
                        for (int k = 0; k < articulo_objeto_palabrasClave.length; k++) {
                            listaPalabras.agregarElemento(articulo_objeto_palabrasClave[k]);
                        }

                        //Setters
                        articulo.setTitulo(articulo_objeto[0]);
                        articulo.setAutores(listaAutores);
                        articulo.setCuerpo(articulo_objeto[2]);
                        articulo.setPalabrasClave(listaPalabras);

                        //Agregar al Hash
                        hashTitulo.put(articulo, articulo);
//Agregar a listaArticulos
                        listaArticulos.agregarElemento(articulo);
                        //Para autores
                        Nodo aux2 = listaArticulos.getpFirst();

                        while (aux2 != null) {

                            Articulo aux3 = (Articulo) aux2.getInfo();
                            Nodo aux4 = aux3.getAutores().getpFirst();

                            //Adentro de lista autores para cada nodo
                            for (int c = 0; c < aux3.getAutores().Size(); c++) {

                                hashAutores.put_listas(aux4, aux2.getInfo());

                                aux4 = aux4.getpNext();
                            }
                            aux2 = aux2.getpNext();
                        }

                        Nodo aux10 = listaArticulos.getpFirst();

                        while (aux10 != null) {

                            Articulo aux11 = (Articulo) aux10.getInfo();
                            Nodo aux12 = aux11.getPalabrasClave().getpFirst();

                            //Adentro de lista autores para cada nodo
                            for (int c = 0; c < aux11.getPalabrasClave().Size(); c++) {

                                hashPalabras.put_listas(aux12, aux10.getInfo());

                                aux12 = aux12.getpNext();
                            }
                            aux10 = aux10.getpNext();
                        }

                    }
                }
                br.close();

            }

        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al tratar de leer la base de datos clientes.");
        }
    }
}
