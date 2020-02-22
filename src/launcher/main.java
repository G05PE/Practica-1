package launcher;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import control.controller;
import funciones.funcion;
import funciones.funcion1;
import funciones.funcion2;
import funciones.funcion3;
import funciones.funcion4;
import model.manager;
import poblacion.individuo;
 
public class main
{
 
        public static void main(String[] args)
        {              
        		manager m=new manager();
             controller c=new controller(m);
             
             //TEST FUNCIONES
             List<Double> l1=new ArrayList<Double>();
             //11.625 y 5.726
             l1.add(11.625);
             l1.add(5.726);
             List<Double> l2=new ArrayList<Double>();
           
             l2.add(8.05502);
             l2.add(9.66459);
             List<Double> l3=new ArrayList<Double>();
       
             l3.add(-10.0);
             l3.add(10.0);
             
             List<Double> l4=new ArrayList<Double>();
             
             l4.add(1.0);
             l4.add(2.0);
             l4.add(3.0);
             
             funcion f[]= {new funcion1(),
          		   new funcion2(), new funcion3(2), new funcion4(3)};
            //TEST ALGORITMOS SELECCION:  
             c.establecerFuncion(1, 0);
             c.iniciarPoblacion(10, 0.1);
             c.establecerMetodoSeleccion(3, 3);
             
             //TEST MUTACION
             
             
             try {
 				SwingUtilities.invokeAndWait(new Runnable() {
 					public void run() {
 						view.mainWindow window = new view.mainWindow(c);
 						c.nextGen();
 						window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 						window.addWindowListener(new WindowAdapter() {
 							 public void windowClosing(WindowEvent e) {
 					                window.exit();
 							 }
 						});
 						
 					}
 				});


      manager m=new manager();
      controller c=new controller(m);
      try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					view.mainWindow window = new view.mainWindow(c);
					window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					window.addWindowListener(new WindowAdapter() {
						 public void windowClosing(WindowEvent e) {
				                window.exit();
						 }
					});
					
				}
			});


   		} catch (InvocationTargetException | InterruptedException e) {
   			System.out.println("Error al iniciar el GUI");
   			e.printStackTrace();
   		}
            	   
 
        }
 
}