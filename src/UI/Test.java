package UI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.time.temporal.JulianFields;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner entrada = null;
        //Se crea el JFileChooser, se le indica que la ventana se abrira en el directiorio acutal
        JFileChooser fileChooser = new JFileChooser(".");
        // Se carga el filtro. El primer parametro es el mensaje que muestra
        // El segundo es la extension de los ficheros que se van a mostrar
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
        // Se le asigna al JFileChooser el filtro
        fileChooser.setFileFilter(filtro);
        // se muestra la ventana
        int valor = fileChooser.showOpenDialog(fileChooser);
        if(valor == JFileChooser.APPROVE_OPTION){
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try{
                File f = new File(ruta);
                entrada = new Scanner(f);
                while(entrada.hasNext()){
                    System.out.println(entrada.nextLine());
                }
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }finally {
                if(entrada != null);
                entrada.close();
            }
        }else{
            System.out.println("No se ha seleccionado ningun archivo");
        }
    }
}
