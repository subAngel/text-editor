package UI;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    JMenuBar menuBar;
    JMenu menuArchivo, menuEditar;
    JMenuItem itemCargar, itemGuardar, itemSalir, itemCopiar, itemPegar, itemBuscar;
    JTextArea textArea;
    Font font;
    JScrollPane scroll;

    public TextEditor(){
        initMenu();
    }

    public void initFrame(){
        this.setTitle("Editor de texto todo feo ._ .");
        this.setResizable(false);
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Iniciar metodo para mostrar el menu
    public void initMenu(){
        /* Creamos el JMenuBar y los asociamos con el frame */
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        /* Creo el menu para las opciones del archivo */
        menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        /* menu para editar el archivo de texto */
        menuEditar = new JMenu("Editar");
        menuBar.add(menuEditar);

        // items para el munu de archivo
        itemGuardar = new JMenuItem("Guardar Archivo");
        itemCargar = new JMenuItem("Cargar Archivo");
        itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemCargar);
        menuArchivo.add(itemSalir);

        // items para el menu de Editar
        itemCopiar = new JMenuItem("Copiar");
        itemPegar = new JMenuItem("Pegar");
        itemBuscar = new JMenuItem("Buscar");
        menuEditar.add(itemCopiar);
        menuEditar.add(itemPegar);
        menuEditar.add(itemBuscar);

        // Cuadro de texto donde se editara el texto
        textArea = new JTextArea();
        font = new Font("Segoi UI", Font.BOLD, 15);
        scroll = new JScrollPane();
        textArea.setLineWrap(true);
        textArea.setFont(font);
        textArea.setWrapStyleWord(true);
        scroll.setViewportView(textArea);
        this.add(scroll);

        initFrame();
    }

    public static void main(String[] args) {
        new TextEditor();
    }

}
