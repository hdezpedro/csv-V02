/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.Views;
import models.Models;
import controllers.Controllers;
import datos.Datos;
/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Views viewC = new Views();
        Models modelC = new Models();
        Datos dataValidation = new Datos();
        Controllers controllerCvs = new Controllers(viewC,modelC,dataValidation);
    }
    
}
