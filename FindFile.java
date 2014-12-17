package filetraversal;

//package fileop;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
//import javax.swing.JOptionPane;
class FindFile 
{
	String Filepath = null;
	String T=null;
	outputfile o = new outputfile();
    Reflection r =new Reflection();
    String str=null;
    Mainwindow oo=new Mainwindow();
	//String Operation = null;
	
	
	public String findFiletra(String name,File file)
  {   
  	
  	
      File[] list = file.listFiles();
      if(list!=null)
      for (File fil : list)
      {
          if (fil.isDirectory())
          {
          	//System.out.println(fil.getAbsolutePath());
          	findFiletra(name,fil);
              
              
          }
          else if (name.equalsIgnoreCase(fil.getName()))
          {
          	Filepath = fil.getAbsolutePath();
          	//System.out.println(Filepath);
          	
              
          }
      }
		return Filepath;
  }
	
	
}


