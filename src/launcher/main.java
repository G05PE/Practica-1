package launcher;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import control.controller;
import model.manager;
 
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