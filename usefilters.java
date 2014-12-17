package filetraversal;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class usefilters
{
	
	public String Filepath=null;
	outputfile o = new outputfile();
    Reflection r =new Reflection();
  
   

	public  void usefilter(File dir,Object extension,Object operation) throws IOException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{

		
		String []extensions = new String[] {extension .toString() };
		o.write("Getting all " +extension.toString()+" files in " + dir.getCanonicalPath()+ " including those in subdirectories");
		
		List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
		for (File file : files)
		{
			Filepath = file.getAbsolutePath();
			
        	o.write(Filepath+" : "+operation);
        	
                 r.reflect(Filepath, operation);
        	
			//System.out.println("file: " + file.getCanonicalPath());
		}

		
	}
	
	

}