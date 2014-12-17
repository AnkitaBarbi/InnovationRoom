package filetraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class append
{
      public boolean appending(File fin,String str) throws IOException
      {
    	 outputfile o=new outputfile();
    	FileInputStream fis = new FileInputStream(fin);
  		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
  		File dir = new File(str);
  		if(dir.canWrite())
  		{	
  		  FileWriter fstream = new FileWriter(str, true);
		  BufferedWriter out = new BufferedWriter(fstream);
		  String aLine = null;
		  try
		    {
		      while ((aLine = in.readLine()) != null)
		       {
			
			       out.write(aLine);
			       out.newLine();
		       }
            }
		  finally
		    {
	          in.close();
		      out.close();
		    }
		 o.write("copied");
		 return true; 
  		}
  		else
  		{
  			System.out.println("no write permission . so cant append it .");
  			return false;
  		}
      }
}
