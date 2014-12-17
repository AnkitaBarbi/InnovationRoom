package filetraversal;

//package fileop;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Reflection {
	  
	       public boolean reflect(String infilepath,Object operation) throws  SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	       { 
	    	    Method method;
	    	    String soperation = operation.toString();
	    	    
			    FileOperation inputFile=new FileOperation();
			    
	 	        File fin=new File(infilepath);
	 	        
	 	        try
	 	        {
			       method = inputFile.getClass().getMethod(soperation, new Class<?>[]{File.class});
			       method.invoke(inputFile,fin);
			       return true;
	 	        }
	 	        catch(Exception e){
	 	        	
	 	        	return false;
	 	        }
			}
	       
	      /* public boolean reflectall(String infilepath,Object operation) throws  SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	       { 
	    	    Method method;
	    	    String soperation = operation.toString();
			    FileOperation inputFile=new FileOperation();
	        	File fin=new File(infilepath);
	        	try
	        	{
			       method = inputFile.getClass().getMethod(soperation, new Class<?>[]{File.class});
			       method.invoke(inputFile,fin);
			       return true;
	        	}
				catch(Exception e)
				{
					return false;
				}
	       }*/
}


