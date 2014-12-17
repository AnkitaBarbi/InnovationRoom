package filetraversal;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class FindFileall 
{

	public String Filepath=null;
	outputfile o = new outputfile();
	 Reflection r =new Reflection();
	public void traverse(File file ,Object Operation) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException 
    {   
		File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
            	
            	traverse(fil,Operation);
            }
            else 
            {
            	Filepath = fil.getAbsolutePath();
            	o.write(Filepath+" : "+Operation);
                r.reflect(Filepath, Operation);
                	
            }
                      
        }
      
			
    }
            
}
    

