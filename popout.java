package filetraversal;

import java.io.IOException;

public class popout
{

	public void popoutput() throws IOException
	 {
		
		ProcessBuilder pop=new ProcessBuilder("notepad.exe" , Mainwindow.dir +"\\output.txt");
		pop.start();
		
	 }
	
}
