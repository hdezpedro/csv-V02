/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import views.Views;
/**
 *
 * @author HP
 */
public class Models {
    private String nombre = "";
    private String email = "";
    private String path = "C:\\Users\\HP\\Documents\\tic41\\DAII\\archivos\\datos.csv";
    boolean bandera = true;
    private int fila = 0;
    private int posicion = 0;
    ArrayList <String> agenda = new ArrayList <String>();
    
    Views viewC;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    agenda.add(row);
                }
                bufferedReader.close();
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewC,"No se econtró  archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewC,"Error en I/O operación" + ex.getMessage());
        }
    }
    public void primero(){
            String lista = agenda.get(fila);
            String datos [] = lista.split(",");
            posicion = fila;
            nombre = datos[0];
            email = datos[1];
    }
    public void anterior(){
        if (posicion > 0){
            posicion = posicion -1;
            String lista = agenda.get(posicion);
            String datos [] = lista.split(",");
            nombre = datos[0];
            email = datos[1];
        }
        else{
             JOptionPane.showMessageDialog(viewC, "A llegado al primero");
        }
        
        
        
    }
    public void siguiente(){
        if (posicion < (agenda.size()-1)){
            posicion = posicion + 1;
            String lista = agenda.get(posicion);
            String datos [] = lista.split(",");
            nombre = datos[0];
            email = datos[1];
        }
        else{
             JOptionPane.showMessageDialog(viewC, "Es su ultimo");
        }
    }
    public void ultimo(){
        int ultimo = (agenda.size()-1);
        String lista = agenda.get(ultimo);
        String datos [] = lista.split(",");
        posicion = ultimo;
        nombre = datos[0];
        email = datos[1];
        
        
    }
    
    public void writeFile(){
        try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.println(nombre + "," + email);
                        printWriter.close();
                        JOptionPane.showMessageDialog(viewC,"Se modificó ");
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewC,"Error en I/O operación" + ex.getMessage());
                }
            }
    }

