package filetraversal;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.filefilter.AgeFileFilter;

public class filterlastdate
{

	    String Filepath=null;
		outputfile o = new outputfile();
	    Reflection r =new Reflection();
		public  void filterdate(File directory,Object operation) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException 
		 {

			

			GregorianCalendar cal = new GregorianCalendar();
			//cal.set( Mainwindow .yy,Mainwindow .mn ,  Mainwindow .mnd, 0, 0, 0); 
			//Date cutoffDate = cal.getTime();

		/*	System.out.println("All Files");
			displayFiles(directory,operation, null);*/
			
			o.write("\nBefore " +  Mainwindow .d/*cutoffDate*/);
			//System.out.println("\nBefore " + cutoffDate);
			displayFiles(directory,operation, new AgeFileFilter(Mainwindow .d/*cutoffDate*/));
			
			o.write("\nAfter " + Mainwindow .d/*cutoffDate*/);
			//System.out.println("\nAfter " + cutoffDate);
			displayFiles(directory,operation, new AgeFileFilter(Mainwindow .d/*cutoffDate*/, false));

		 }

		public  void displayFiles(File directory,Object operation, FileFilter fileFilter) throws IOException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
		{
			File[] files = directory.listFiles(fileFilter);
			for (File file : files) 
			{
				
				Date lastMod = new Date(file.lastModified());
				Filepath = file.getAbsolutePath();
				o.write(Filepath+" : "+operation+" :  Date : "+ lastMod+" ");
                r.reflect(Filepath, operation);
				
			}
		}

	}
	
