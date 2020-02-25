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