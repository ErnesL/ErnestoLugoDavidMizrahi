/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import proyecto2edd.Metodos.*;

/**
 *
 * @author davidmizrahi
 */
public class Articulo<T> {

    private String titulo;
    private Lista<String> autores;
    private String cuerpo;
    private Lista<String> palabrasClave;

    public Articulo() {

        this.titulo = "";
        this.cuerpo = "";
        this.palabrasClave = new Lista<>();
        this.autores = new Lista<>();
    }

    public void mostrarInfo() {

        String autoresconcatenados = this.autores.concatenarValores(this.autores);
        String palabrasconcatenadas = this.palabrasClave.concatenarValores(this.palabrasClave);
        String aux = "Titulo: " + this.titulo + "\n" + "\n" + "Autores: " + autoresconcatenados + "\n" + "\n" + "Resumen: " + this.cuerpo + "\n" + "\n" + "Palabras Claves: " + palabrasconcatenadas + "\n";

        //Interfaz
        JFrame frame = new JFrame(this.titulo);
        frame.setSize(500, 500);
        frame.setResizable(false);
        JTextArea textArea = new JTextArea(aux);
        textArea.setSize(400, 400);

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.setVisible(true);

    }

    public void mostrarInfoTuneado(Articulo articulo) {
        String palabras = "";
        String autoresconcatenados = this.autores.concatenarValores(this.autores);
        int cantPalabras = 0;

        Nodo aux1 = articulo.getPalabrasClave().getpFirst();

        while (aux1 != null) {
            String[] array = articulo.getCuerpo().split(aux1.getInfo().toString());
            cantPalabras = array.length -1;

            palabras += "Frecuencia con la que aparece la palabra clave " + aux1.getInfo().toString() + ": " + cantPalabras+ "\n";
            
            aux1 = aux1.getpNext();
        }
//        System.out.println(Metodos.contarPalabras(articulo));
        String aux = "Titulo: " + this.titulo + "\n" + "Autores: " + autoresconcatenados + "\n" + palabras;

        //Interfaz
        JFrame frame = new JFrame(this.titulo);
        frame.setSize(500, 500);
        frame.setResizable(false);
        JTextArea textArea = new JTextArea(aux);
        textArea.setSize(400, 400);

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.setVisible(true);

    }

    public void agregarABaseDeDatos() {

        //Funcion para escribir el articulo creado en el archivo "basededatos.txt"
        String autoresconcatenados = this.autores.concatenarValores(this.autores);
        String palabrasconcatenadas = this.palabrasClave.concatenarValores(this.palabrasClave);
        String aux = this.titulo + "//" + autoresconcatenados + "//" + this.cuerpo + "//" + palabrasconcatenadas + "\n";
        try {

            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("test\\basededatos.txt"), true /* append = true */));
            pw.append(aux);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
        } catch (HeadlessException | FileNotFoundException err) {
            JOptionPane.showMessageDialog(null, err);

        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Lista<String> getAutores() {
        return autores;
    }

    public void setAutores(Lista<String> autores) {
        this.autores = autores;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Lista<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(Lista<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

}
