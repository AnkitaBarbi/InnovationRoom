package filetraversal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;


public class FileOperation
{

	private static final String NULL = null;
	public static int copycounter = 0;
	public static int deletecounter = 0;
	public static int counter = 0;
	public static int movecounter = 0;
	public static int renamecounter = 0;
	public static int findcounter = 0;
	
	public boolean copy(File fin) throws IOException
	   {
		 outputfile o=new outputfile();
		  if (fin.canRead())
		   {
			 // Scanner scan = new Scanner(System.in);
	          //System.out.println("Enter the Directory in which output file is present" );
	          //String directory = scan.next();
	          //System.out.println("Enter the ofilename " );
	          //String ofilename = scan.next();
			  //Output file
			  FindFile a = new FindFile();
			 
		      String ofiledir= a.findFiletra((Mainwindow.s).toString(),new File(Mainwindow.dir));
		      if(ofiledir!=null) 
				{
					append ap=new append();
					ap.appending(fin,ofiledir);
				}
			  else
				{
			       if(ofiledir == NULL)
			        {
				       o.write("  Output file not found. Creating a new one in the same directory ");
				       File ofile = new File( Mainwindow.dir+"\\" + (Mainwindow.s).toString() );
				      ofile.createNewFile();
				      ofiledir= ofile.getAbsolutePath();
				      o.write(" Output file Dir: " + ofiledir);
			        }
			       File out=new File(ofiledir);
			  
				    FileChannel inChannel = new FileInputStream( fin ).getChannel();
		            FileChannel outChannel = new FileOutputStream( out ).getChannel();
		            // Try to change this but this is the number I tried.. for Windows, 64Mb - 32Kb)
		            try
		              {    
		        	     int maxCount = (64 * 1024 * 1024) - (32 * 1024*1024);
		        	    
		                 long size = inChannel.size();
		                 long position = 0;
		                 while ( position < size )
		                   {
		                    	position += inChannel.transferTo( position, maxCount, outChannel );
		                   }
		               
		                o.write("File Successfully Copied..");
		                counter=counter + 1;
			            copycounter=copycounter + 1;
				        return true;
			         }
			       catch(Exception e1)
			         {
				        System.out.println(e1.getMessage());
			         }
			       finally
		             {
		                if ( inChannel != null )
		                 {
		                   inChannel.close();
		                 }
		                if ( outChannel != null )
		                 {
		                   outChannel.close();
		                 }
		            }
		      }
		   }
		  else
		  {
			  o.write(" No read permission so cannot copy ");	 
		  }
			return false;
			
			
		
	}

	public  boolean move(File mfile)
	    {	
		 if (mfile.canExecute())
		 {	 
	    	try
	    	{
	    		outputfile o=new outputfile();
	    		//Scanner scan = new Scanner(System.in);
	    		//System.out.println(" enter the directory where you need to move ");
	    		//String movfileto = scan.next();
	    	   // File afile =new File();
	    		System.out.println(mfile.getName());
	    		File nfile= new File( Mainwindow.dir + mfile.getName());
	 
	    	    if(mfile.renameTo(nfile))
	    	      {
	    		    o.write("File moved ");
	    		    o.write(" New Location : " + nfile.getAbsolutePath() );
	    		    counter=counter + 1;
		            movecounter=movecounter + 1;
	    		    return true;
	    	      } 
	    	    else
	    	     {
	    		   o.write("File  failed to move!");
	    		   return false;
	    	     }
	 
	    	 }
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
		 }
		 else
		 {
			System.out.println("no execution permission so can't move it"); 
			return false;
		 }
		return false;
	    }
	
	public boolean rename(File oldname)
	{
		outputfile fop=new outputfile();
		try
		{
		 if (oldname.canExecute())
		 {	
			//Scanner scan = new Scanner(System.in);
			//System.out.println(" Enter new filename ");
			//String nname = scan.next();
			File newname = new File(oldname.getParent()+ "/" + (Mainwindow.s).toString());
			//if(file2.exists()) throw new java.io.IOException("file exists");
			 if(oldname.renameTo(newname))
			 {
				    counter= counter+1;
			        renamecounter= renamecounter+1;
		    		fop.write("File renamed");
		    		fop.write("Location : " + newname.getAbsolutePath() );
		    		 counter=counter + 1;
			         renamecounter=renamecounter + 1;
		    		return true;
		     }
			 else
			 {
		    		fop.write(" Failed");
		    		return false;
		     }
		   }
		 else
		 {
			 fop.write(" no execution permission so can't rename");
		 }
		}
		 catch(Exception e){
		    		e.printStackTrace();
		    	}
		return false;
		 
		}

	public boolean delete(File drop)
	{
		if (drop.canWrite()) 
		{
			if(drop.delete())
			{
			System.out.println("File Deleted ");
			counter= counter+1;
	        deletecounter= deletecounter+1;
			return true;
			}
			else
			{
			System.out.println("Failed to delete ");
			return false;
			}
		}
		else
		{
	    System.out.println("No acess permission so can't delete");
		return false;
		}
	}

	public boolean exit()
	{
	 System.exit(0);
	 return true;
	 
	}

	public boolean findpath(File fin)
	{
		String fpath=fin.getAbsolutePath();
		//	System.out.println("Path of the required file="+fpath);
		if(fpath!=null)
		{
		   counter=counter + 1;
	       findcounter=findcounter + 1;
		   return true;
		}
		else
			return false;
	}
	
}	





