/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.Views;
import models.Models;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import datos.Datos;
/**
 *
 * @author HP
 */
public class Controllers {
    Views viewCvs;
    Models modelCvs;
    Datos dataValidation;
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCvs.jb_nuevo)
                    limpiar();
            else if(e.getSource() == viewCvs.jb_guardar)
                guardar();
            else if(e.getSource() == viewCvs.jb_primero)
                primero();
            else if (e.getSource() == viewCvs.jb_anterior)
                anterior();
            else if (e.getSource() == viewCvs.jb_siguiente)
                siguiente();
            else if (e.getSource() == viewCvs.jb_ultimo)
                ultimo();
        }
    };
    public Controllers(Views viewCvs, Models modelCvs, Datos dataValidation) {
        this.viewCvs = viewCvs;
        this.modelCvs = modelCvs;
        this.viewCvs.jb_guardar.addActionListener(ac);
        this.viewCvs.jb_nuevo.addActionListener(ac);
        this.viewCvs.jb_primero.addActionListener(ac);
        this.viewCvs.jb_siguiente.addActionListener(ac);
        this.viewCvs.jb_anterior.addActionListener(ac);
        this.viewCvs.jb_ultimo.addActionListener(ac);
        dataValidation.Sletras(this.viewCvs.jtf_nombre);
        initComponents();
    }
    public void obtener(){
        modelCvs.setNombre(viewCvs.jtf_nombre.getText());
        modelCvs.setEmail(viewCvs.jtf_email.getText());
    }
    
    public void mostrar(){
        viewCvs.jtf_nombre.setText(modelCvs.getNombre());
        viewCvs.jtf_email.setText(modelCvs.getEmail());
    }
    public void limpiar(){
        viewCvs.jtf_nombre.setText("");
        viewCvs.jtf_email.setText("");
    }
    
    public void guardar(){
        obtener();
        modelCvs.writeFile();
    }
    
    public void primero(){
        modelCvs.primero();
        mostrar();
        
    }
    
    public void ultimo(){
        modelCvs.ultimo();
        mostrar();
    }
    
    public void siguiente(){
        modelCvs.siguiente();
        mostrar();
    }
    public void anterior(){
        modelCvs.anterior();
        mostrar();
    }
    
    private void initComponents(){
        viewCvs.setVisible(true);
        modelCvs.readFile();
        modelCvs.primero();
        mostrar();
    }
    
}
