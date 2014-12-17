package filetraversal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class outputfile 
{

	
	public void write(String msg) throws IOException 
	{
		    String otdir=Mainwindow.dir +"\\output.txt";
			File ofile = new File(otdir );
			ofile.createNewFile();
			FileWriter fw = new FileWriter(ofile.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(msg+"\r\n");
			bw.close();
 
	} 

}
