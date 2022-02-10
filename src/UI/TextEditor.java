package UI;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menuArchivo, menuEditar;
    JMenuItem itemAbrir, itemGuardar, itemSalir, itemCopiar, itemPegar, itemCortar, itemBuscar;
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
        itemAbrir = new JMenuItem("Abrir Archivo");
        itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemAbrir);
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
        itemAbrir.addActionListener(this);
        initFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==itemGuardar){
//            System.out.println("Guardar texto");
            guardarFichero();
        }else if(e.getSource()==itemAbrir){
            abrirFichero();
        }
    }

    // metodo para lectura y escritura de un fichero de texto
    public void guardarFichero(){
        try{
            JFileChooser fileChooser = new JFileChooser();

            String filename = JOptionPane.showInputDialog(null, "Como quiere guardar su archivo?","Guardar Fichero",JOptionPane.QUESTION_MESSAGE);
//            filename.replace(" ", "-");
            String ruta = System.getProperty("user.dir")+"\\"+filename+".txt";
            String content = textArea.getText();

            System.out.println(ruta);
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println(content);
            writer.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void abrirFichero(){
        try {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(textArea);

            if(seleccion == JFileChooser.APPROVE_OPTION){
                File fichero = fileChooser.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(fichero));
                // BufferedReader va leyendo de linea por linea
                String lineatotal="";
                String linea = reader.readLine();
                while(linea != null){
                    lineatotal = lineatotal + linea + System.getProperty("line.separator");
                    linea = reader.readLine();
                }
                textArea.setText(lineatotal);
                reader.close();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public String getNameFile(){

    }


    public static void main(String[] args) {
        new TextEditor();
    }

}
