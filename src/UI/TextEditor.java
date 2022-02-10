package UI;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

public class TextEditor extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menuArchivo, menuEditar;
    JMenuItem itemCargar, itemGuardar, itemSalir, itemCopiar, itemPegar, itemCortar, itemBuscar;
    JSeparator separator;
    JTextArea textArea;
    Font font1 = new Font("Segoi UI", Font.PLAIN, 15);
    Font font2 = new Font("Segoi UI", Font.BOLD, 16);
    JScrollPane scroll;
    String cargar="Cargar Archivo", guardar="Guardar Archivo", salir="Salir", copiar="Copiar", pegar="Pegar", buscar="Buscar";

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
        //this.setJMenuBar(menuBar);
        this.getContentPane().add(menuBar, BorderLayout.NORTH);

        /* Creo el menu para las opciones del archivo */
        menuArchivo = new JMenu("Archivo");
        menuArchivo.setFont(font2);
        menuBar.add(menuArchivo);

        /* menu para editar el archivo de texto */
        menuEditar = new JMenu("Editar");
        menuEditar.setFont(font2);
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
        itemCortar = new JMenuItem("Cortar");
        itemBuscar = new JMenuItem("Buscar");
        menuEditar.add(itemCopiar);
        menuEditar.add(itemPegar);
        menuEditar.add(itemCortar);
        menuEditar.add(new JSeparator());
        menuEditar.add(itemBuscar);

        // Cuadro de texto donde se editara el texto
        textArea = new JTextArea();
        scroll = new JScrollPane();
        // para que se partan automaticamente las lineas al llegar al final
        textArea.setLineWrap(true);
        textArea.setFont(font1);
        //para que el partido se haga respetando las palabras. solo parte la linea
        // en los espacios entre palabras
        textArea.setWrapStyleWord(true);
        scroll.setViewportView(textArea);
        this.getContentPane().add(scroll, BorderLayout.CENTER);

        // agregar los escuchadores de eventos
        itemGuardar.addActionListener(this);

        initFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==itemGuardar){
//            System.out.println("Guardar texto");
            guardarFichero();
        }
    }

    // metodo para lectura y escritura de un fichero de texto
    public void guardarFichero(){
        try{
            PrintWriter fichero = new PrintWriter("Documento de texto.txt");
            String aux = textArea.getText();
            fichero.println(aux);
            System.out.println(aux);
            fichero.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }



    public static void main(String[] args) {
        new TextEditor();
    }

}
