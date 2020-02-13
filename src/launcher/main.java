package launcher;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import control.controller;
import funciones.funcion;
import funciones.funcion1;
import funciones.funcion2;
import funciones.funcion3;
import model.manager;
 
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
               funcion f[]= {new funcion1(l1),
            		   new funcion2(l2), new funcion3(l3)};
               for(int i=0; i<3; i++)
               {
            	   f[i].test();
               }
 
        }
 
}