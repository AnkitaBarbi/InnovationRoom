package filetraversal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;





import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Mainwindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static String dir;
	public static String s;
	public static String rootdir;
	public static Object cmboitem;
	public static Object cmboitem_1 ;
	public static Object radioselect;
	public static Object text;
	JRadioButton rr ;
	outputfile fop=new outputfile();
	public static String str1;
	public static int yy;
	public static int mnd; 
	public static int mn; 
	public static Date d;
	
    final JComboBox comboBox_2 = new JComboBox();
    private JTextField textField_2;
    private JTextField textField_3;

	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try {
					Mainwindow frame = new Mainwindow();
					frame.setVisible(true);
				    } 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainwindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BROWSE");
		btnNewButton.setBounds(284, 44, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	                JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	                fileChooser.setAcceptAllFileFilterUsed(false);
	         
	                int rVal = fileChooser.showOpenDialog(null);
	                if (rVal == JFileChooser.APPROVE_OPTION) 
	                {
	                	textField.setText(fileChooser.getSelectedFile().toString());
	                	rootdir=textField.getText();
	                	
	                }
	                
	            }
		  });
	
		textField = new JTextField();
		textField.setBounds(26, 45, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Browse the directory to be traversed");
		lblNewLabel.setBounds(26, 11, 218, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Browse the directory to create log File");
		lblNewLabel_1.setBounds(26, 76, 218, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("BROWSE");
		btnNewButton_1.setBounds(284, 100, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 101, 175, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Use of Filters");
		rdbtnNewRadioButton.setBounds(26, 153, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
	    rdbtnNewRadioButton.setEnabled(false);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("All Files");
		rdbtnNewRadioButton_1.setBounds(26, 179, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setEnabled(false);
		
		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Each File separately");
		rdbtnNewRadioButton_2.setBounds(26, 205, 152, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setEnabled(false);
		
		final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Filter using last modified date");
		rdbtnNewRadioButton_3.setBounds(26, 231, 196, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setEnabled(false);
		
		
		
		 final ButtonGroup bG = new ButtonGroup();
		 bG.add(rdbtnNewRadioButton);
	     bG.add(rdbtnNewRadioButton_1);
	     bG.add(rdbtnNewRadioButton_2);
	     bG.add(rdbtnNewRadioButton_3);
	     
	     
	     
	     
		final JLabel lblNewLabel_2 = new JLabel("File Traversal");
		lblNewLabel_2.setBounds(26, 132, 123, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setEnabled(false);
			
	     
	     btnNewButton_1.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	                JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	                fileChooser.setAcceptAllFileFilterUsed(false);
	         
	                int rVal = fileChooser.showOpenDialog(null);
	                if (rVal == JFileChooser.APPROVE_OPTION) 
	                {
	                	textField_1 .setText(fileChooser.getSelectedFile().toString());
	                	dir=textField_1 .getText();
	                	//System.out.println(dir);
	                }
	                lblNewLabel_2.setEnabled(true);
	                rdbtnNewRadioButton.setEnabled(true);
	                rdbtnNewRadioButton_1.setEnabled(true);
	                rdbtnNewRadioButton_2.setEnabled(true);
	                rdbtnNewRadioButton_3.setEnabled(true);
	                
	            }
		  });
	     
	     
	    
	     
	     
	   
		
		final JComboBox comboBox = new JComboBox();
	
		comboBox.setBounds(284, 154, 89, 20);
		contentPane.add(comboBox);
		
		//comboBox.addItem("findpath");
		//comboBox.addItem("copy");
		//comboBox.addItem("rename");
		//comboBox.addItem("move");
		comboBox.setEnabled(false);
	   
		
		final JLabel lblNewLabel_3 = new JLabel("Operation to be performed");
		lblNewLabel_3.setBounds(284, 132, 174, 14);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setEnabled(false);
		
		
		final JLabel lblNewLabel_4 = new JLabel("Select one of the extensions");
		lblNewLabel_4.setBounds(284, 183, 161, 14);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setEnabled(false);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(284, 206, 89, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("txt");
		comboBox_1.addItem("java");
		comboBox_1.addItem("bin");
		comboBox_1.addItem("exe");
		comboBox_1.addItem("jar");
		comboBox_1.addItem("html");
		comboBox_1.setEnabled(false);
		
		JButton btnNewButton_2 = new JButton("RESTART");
		btnNewButton_2.setBounds(375, 404, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		final JButton btnNewButton_4 = new JButton("ENTER");
		btnNewButton_4.setBounds(276, 404, 89, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		
	   
		comboBox_2.setBounds(284, 274, 175, 20);
		contentPane.add(comboBox_2);
		comboBox_2.setEnabled(false);
		
		final JLabel lblNewLabel_5 = new JLabel("Choose the file to operate on");
		lblNewLabel_5.setBounds(284, 249, 258, 14);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setEnabled(false);
		
		final JLabel lblNewLabel_6 = new JLabel("Browse the directory to move/copy the file");
		lblNewLabel_6.setBounds(26, 324, 240, 14);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(26, 349, 175, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		final JButton btnNewButton_3 = new JButton("BROWSE");
		btnNewButton_3.setBounds(284, 348, 89, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setEnabled(false);
		
		
		 btnNewButton_3.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	                JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	                fileChooser.setAcceptAllFileFilterUsed(false);
	         
	                int rVal = fileChooser.showOpenDialog(null);
	                if (rVal == JFileChooser.APPROVE_OPTION) 
	                {
	                	textField_2 .setText(fileChooser.getSelectedFile().toString());
	                	dir=textField_2 .getText();
	                	//System.out.println(dir);
	                }
	                
	                btnNewButton_4.setEnabled(true);
	               
	                
	            }
		  });
	     
		
		
		final JLabel lblNewLabel_7 = new JLabel("Enter the file name to rename/copy");
		lblNewLabel_7.setBounds(26, 380, 218, 14);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setEnabled(false);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				
				btnNewButton_4.setEnabled(true);
				
			}
		});
		textField_3.setBounds(26, 405, 123, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		
		
		
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(44, 261, 91, 20);
		contentPane.add(dateChooser);
		dateChooser.setEnabled(false);
		
		btnNewButton_4.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	        	 
	        	  if( rr== rdbtnNewRadioButton_1)
        	      {
        	    	 
	        		  try
	        		  {
        	    	     FindFileall obj = new FindFileall();
        	    	     obj.traverse(new File(rootdir), Mainwindow.cmboitem);
        	    	     outputfile o= new outputfile();
						  
						  o.write("Total number of files traversed : "+FileOperation.counter);
					      o.write("Total number of files deleted : "+FileOperation.deletecounter);
					      o.write("Total number of files whose path was traced : "+FileOperation.findcounter);
					      o.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");  
					      popout pp=new  popout();
				          pp.popoutput();
						  
					   } 
     	    	      catch (NoSuchMethodException | SecurityException| IllegalAccessException| IllegalArgumentException| InvocationTargetException | IOException e)
     	    	       {
						
						  e.printStackTrace();
						
					   }
        	      }
     	    	
	        	  
	        	  
	         if( rr== rdbtnNewRadioButton_2)
	          {
	        	 try
	        	 {
	        	 outputfile ob = new outputfile();
    	    	 Reflection r =new Reflection();
    	    	 
    	    	  if( (Mainwindow.cmboitem).toString()=="rename")
				   {
    	    	       text=textField_3.getText();
    	    	       s=text.toString();
				   }
    	    	  
    	    	  
    	    	  if( (Mainwindow.cmboitem).toString()=="move")
					   {
					   }
    	    	  
    	    		 
					 if( (Mainwindow.cmboitem).toString()=="copy")
					   {
						 
						   text=textField_3.getText();
	    	    	       s=text.toString();
						 
					   }
    	    	  
    	    	  
    	    	 
    	    	  r.reflect(str1, Mainwindow.cmboitem);
				  ob.write(str1);
				  ob.write("Total number of files traversed : "+FileOperation.counter);
		          ob.write("Total number of files deleted : "+FileOperation.deletecounter);
		          ob.write("Total number of files whose path was traced : "+FileOperation.findcounter);
		          ob.write("Total number of files renamed : "+FileOperation.renamecounter);
		          ob.write("Total number of files moved : "+FileOperation.movecounter);
		          ob.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");   
			      popout pp=new  popout();
			      pp.popoutput();
					   
	    	   }
	    	   catch (SecurityException | IllegalArgumentException |IOException | IllegalAccessException | InvocationTargetException e)
    	       {
					
					e.printStackTrace();
					
			   } 
	         }		
				
	        	 
	         
	         if( rr== rdbtnNewRadioButton_3)
    	     { 
	         
	        	try
	        	{
	        		
	        		 d=dateChooser.getDate();
	        		 int yy=dateChooser.getCalendar().get(Calendar.YEAR);
	        		 int mnd=dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
	        		 int mn=dateChooser.getCalendar().get(Calendar.MONTH);
	        		 System.out.println(mn);
	        		 filterlastdate obj = new filterlastdate();
	        		 outputfile ob = new outputfile();
	        	     obj.filterdate(new File(rootdir), Mainwindow.cmboitem); 
					 ob.write("Total number of files traversed : "+FileOperation.counter);
		             ob.write("Total number of files deleted : "+FileOperation.deletecounter);
		             ob.write("Total number of files whose path was traced : "+FileOperation.findcounter);
		             ob.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");   
			         popout pp=new  popout();
			         pp.popoutput();
					   
	    	   }
	    	 catch (SecurityException | IllegalArgumentException |IOException |IllegalAccessException | InvocationTargetException e)
    	       {
					
					e.printStackTrace();
					
			   } 
	        	 
	        	 
    	     }
	         
	         
	         

       	  
       	  if( rr== rdbtnNewRadioButton)
       	     {
       		    outputfile o = new outputfile();
         	    cmboitem_1 = comboBox_1.getSelectedItem();
       	    	 usefilters obj=new  usefilters();
       	    	 try
       	    	 { 
       	    		 
       	    	        
       	    	        
						 obj.usefilter(new File(rootdir),Mainwindow.cmboitem_1,Mainwindow.cmboitem);
						 
						 o.write("Total number of files traversed : "+FileOperation.counter);
				         o.write("Total number of files deleted : "+FileOperation.deletecounter);
				         o.write("Total number of files whose path was traced : "+FileOperation.findcounter);
				         o.write("Total number of files renamed : "+FileOperation.renamecounter);
				         o.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");   
					     popout pp=new  popout();
					     pp.popoutput();

						 
					  }  
       	    	 catch (SecurityException | IllegalAccessException| IllegalArgumentException| InvocationTargetException | IOException e)
       	    	 {
						
						e.printStackTrace();
				 }
       	    	 
       	     }
       	 
	         
	         
	         
	   }
		  });
	            
		
	  
		btnNewButton_2.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	            
	        	     FileOperation.counter=0;
	        	     FileOperation.findcounter=0;
	        	     FileOperation.deletecounter=0;
	        	     FileOperation.copycounter=0;
	        	     FileOperation.movecounter=0;
	        	     FileOperation.renamecounter=0;
	        	     comboBox.removeAllItems();
	        	     comboBox.setEnabled(false);
	        	     comboBox_1.setEnabled(false);
	        	     comboBox_2.setEnabled(false);
	        	     btnNewButton_4.setEnabled(false);
	        	     rdbtnNewRadioButton.setEnabled(false);
		             rdbtnNewRadioButton_1.setEnabled(false);
		             rdbtnNewRadioButton_2.setEnabled(false);
		             rdbtnNewRadioButton_3.setEnabled(false);
		             dateChooser.setEnabled(false);
		             bG.clearSelection();
	        	 
	            }
		  });
		
	    
	    rdbtnNewRadioButton.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
		         
	        	  lblNewLabel_3.setEnabled(true);
	        	  dateChooser.setEnabled(false);
	        	  lblNewLabel_4.setEnabled(true);
	        	  lblNewLabel_5.setEnabled(false);
	        	  comboBox.removeAllItems();
	        	  comboBox.addItem("delete");
	        	  comboBox.addItem("findpath");
	        	  btnNewButton_4.setEnabled(false);
	        	  comboBox_1.setEnabled(true);
	        	  comboBox.setEnabled(true);
	        	  comboBox_2.setEnabled(false); 
	        	  
	            }
		  });
	    
	    
	    rdbtnNewRadioButton_1.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
		
	        	   lblNewLabel_3.setEnabled(true);
	        	   dateChooser.setEnabled(false);
	        	   lblNewLabel_4.setEnabled(false);
	        	   lblNewLabel_5.setEnabled(false);
	        	   comboBox.removeAllItems();
	               comboBox.addItem("delete");
	        	   comboBox.addItem("findpath");
	        	   btnNewButton_4.setEnabled(false);
	        	   comboBox.setEnabled(true);
	        	   comboBox_1.setEnabled(false);
	        	   comboBox_2.setEnabled(false); 
	        	 
	            }
		  });
	     
	     
	     rdbtnNewRadioButton_2.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
		
	        	   lblNewLabel_3.setEnabled(true);
	        	   lblNewLabel_4.setEnabled(false);
	        	   lblNewLabel_5.setEnabled(true);
	        	   dateChooser.setEnabled(false);
	        	   btnNewButton_4.setEnabled(false);
	        	  // comboBox.removeAllItems();
	        	   comboBox.addItem("delete");
	     		   comboBox.addItem("findpath");
	     		   comboBox.addItem("copy");
	     		   comboBox.addItem("rename");
	     		   comboBox.addItem("move");
	        	   comboBox.setEnabled(true);
	        	   comboBox_1.setEnabled(false);
	        	   comboBox_2.setEnabled(true); 
      	    	   File root=new File(rootdir);
      	    	   String str=null;
      	    	  
      	    	   try
      	    	    {
      	    		   
 							//System.out.println("Getting all files in " + dir.getCanonicalPath() + " including those in subdirectories");
 							List<File> files = (List<File>) FileUtils.listFiles(root, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
 							for (File file : files)
 							{
 								
 								
 					        	str=file.getCanonicalPath();
 					        	comboBox_2.addItem(str);
 					        	
 							}
 						
 						   
      	    	   }
      	    	   catch (SecurityException | IllegalArgumentException |IOException e)
	        	       {
							
							e.printStackTrace();
							
					   } 
      	    	
					
	        	    	 
	        	 
	            }
		  });
	     
	     
	     rdbtnNewRadioButton_3.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
		
	        	  lblNewLabel_3.setEnabled(true);
	        	  lblNewLabel_5.setEnabled(false);
	        	  lblNewLabel_4.setEnabled(false);
	        	  dateChooser.setEnabled(true);
	        	  comboBox.removeAllItems();
	        	  comboBox.addItem("delete");
	     		  comboBox.addItem("findpath");
	     		  btnNewButton_4.setEnabled(false);
	        	  comboBox_1.setEnabled(false);
	        	  comboBox.setEnabled(true);
	        	  comboBox_2.setEnabled(false); 
	        	 
	            }
		  });
	     
	     
	     comboBox.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
			        
	            	outputfile o = new outputfile();
	        	    RADIOBTN rb=new RADIOBTN();
	        	    rr =rb. getSelectedRadio(bG);
	        	   
	        	    cmboitem = comboBox.getSelectedItem();
	        	   
	        	     if( rr== rdbtnNewRadioButton_1)
	        	      {
	        	    	 
	        	    	   FindFileall obj = new FindFileall();
	        	    	   //try
	        	    	   //{
	        	    		   
	        	    		   Date date= new Date();
	   						   long timestamp = date.getTime();
	   						   Timestamp ts = new Timestamp(timestamp);
	   						
	   						   try 
	   						   {
	   						     	fop.write(" Current Session "+ ts );
	   						   } 
	   						   catch (IOException e1)
	   						   {
	   							
	   							e1.printStackTrace();
	   						   }
	   						   
	   						btnNewButton_4.setEnabled(true);
	        	    		   
							 /* obj.traverse(new File(rootdir), Mainwindow.cmboitem);
							  
							  o.write("Total number of files traversed : "+FileOperation.counter);
						      o.write("Total number of files deleted : "+FileOperation.deletecounter);
						      o.write("Total number of files whose path was traced : "+FileOperation.findcounter);
						      o.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");  
						      popout pp=new  popout();
					          pp.popoutput();
							  
						   } 
	        	    	   catch (NoSuchMethodException | SecurityException| IllegalAccessException| IllegalArgumentException| InvocationTargetException | IOException e)
	        	    	   {
							
							  e.printStackTrace();
							
						   }*/
	        	    	
	        	      }
	        	     
	        	   
	        	     
	        	   if( rr== rdbtnNewRadioButton_2)
	        	     {
	        	    	 outputfile ob = new outputfile();
	        	    	 Reflection r =new Reflection();
	        	    	   try
	        	    	   {
	        	    		   
	        	    		   Date date= new Date();
	   						   long timestamp = date.getTime();
	   						   Timestamp ts = new Timestamp(timestamp);
	   						
	   						   try 
	   						   {
	   						     	fop.write(" Current Session "+ ts );
	   						   } 
	   						   catch (IOException e1)
	   						   {
	   							
	   							e1.printStackTrace();
	   						   }
	   						 
	   						   if( (Mainwindow.cmboitem).toString()=="rename")
	   						   {
	   							   
	   							lblNewLabel_7.setEnabled(true);
	   							textField_3.setEnabled(true);
	   							btnNewButton_4.setEnabled(false);
	   							
	   						   }
	   						
	   						   
	   						 if( (Mainwindow.cmboitem).toString()=="move")
	   						   {
	   							   
	   							lblNewLabel_6.setEnabled(true);
	   							textField_2.setEnabled(true);
	   							btnNewButton_3.setEnabled(true);
	   							btnNewButton_4.setEnabled(false);
	   							
	   						   }
	   						   
	   						 
	   						 if( (Mainwindow.cmboitem).toString()=="copy")
	   						   {
	   							 
	   							lblNewLabel_6.setEnabled(true);
	   							textField_2.setEnabled(true);
	   							btnNewButton_3.setEnabled(true);
	   							lblNewLabel_7.setEnabled(true);
	   							textField_3.setEnabled(true);
	   							btnNewButton_4.setEnabled(false);
	   							
	   						   }
	   						 
	   						 
	   					    if( (Mainwindow.cmboitem).toString()=="delete")
  						      {
  						   
	   					    	  btnNewButton_4.setEnabled(true);
	   					    	
  						      }
	   					  
	   					  
	   					   if( (Mainwindow.cmboitem).toString()=="findpath")
  						     {
	   						  
	   					     	btnNewButton_4.setEnabled(true);
	   						   
  						     }
	   					     //btnNewButton_4.setEnabled(true);
	   						/* r.reflect(str1, Mainwindow.cmboitem);
	   						 ob.write(str1);
	   						 ob.write("Total number of files traversed : "+FileOperation.counter);
					         ob.write("Total number of files deleted : "+FileOperation.deletecounter);
					         ob.write("Total number of files whose path was traced : "+FileOperation.findcounter);
					         ob.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");   
						     popout pp=new  popout();
						     pp.popoutput();*/
	   						   
	        	    	   }
	        	    	   catch (SecurityException | IllegalArgumentException /*|IOException | IllegalAccessException | InvocationTargetException*/ e)
		        	       {
								
								e.printStackTrace();
								
						   } 
						
		        	    	 
	        	    	 
	        	     }
	        	 
	        	     
	        	     if( rr== rdbtnNewRadioButton_3)
	        	     { 
	        	    	 
	        	    	 outputfile ob = new outputfile();
	        	    	 filterlastdate obj = new filterlastdate();
	        	    	// try
	        	    	  // {
	        	    		   
	        	    		   Date date= new Date();
	   						   long timestamp = date.getTime();
	   						   Timestamp ts = new Timestamp(timestamp);
	   						
	   						   try 
	   						   {
	   						     	fop.write(" Current Session "+ ts );
	   						   } 
	   						   catch (IOException e1)
	   						   {
	   							
	   							e1.printStackTrace();
	   						   }
	   						   
	   						btnNewButton_4.setEnabled(true);
	   						  
	   						/* obj.filterdate(new File(rootdir), Mainwindow.cmboitem); 
	   						 ob.write("Total number of files traversed : "+FileOperation.counter);
					         ob.write("Total number of files deleted : "+FileOperation.deletecounter);
					         ob.write("Total number of files whose path was traced : "+FileOperation.findcounter);
					         ob.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");   
						     popout pp=new  popout();
						     pp.popoutput();
	   						   
	        	    	   }
	        	    	 catch (SecurityException | IllegalArgumentException |IOException |IllegalAccessException | InvocationTargetException e)
		        	       {
								
								e.printStackTrace();
								
						   } */
	        	    	 
	        	     }
	        	     
	        	     
	            }
		  });
	    
	     
	     comboBox_1.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	        	 
	        	  outputfile o = new outputfile();
	        	  cmboitem_1 = comboBox_1.getSelectedItem();
	        	  if( rr== rdbtnNewRadioButton)
	        	     {
	        	    	 
	        	    	 usefilters obj=new  usefilters();
	        	    	 //try
	        	    	 // {
	        	    		 
	        	    		  Date date= new Date();
	   						   long timestamp = date.getTime();
	   						   Timestamp ts = new Timestamp(timestamp);
	   						
	   						   try 
	   						   {
	   						     	fop.write(" Current Session "+ ts );
	   						   } 
	   						   catch (IOException e1)
	   						   {
	   							
	   							e1.printStackTrace();
	   						   }
	   						
	   						  btnNewButton_4.setEnabled(true);
	        	    		 
							/* obj.usefilter(new File(rootdir),Mainwindow.cmboitem_1,Mainwindow.cmboitem);
							 o.write("Total number of files traversed : "+FileOperation.counter);
					         o.write("Total number of files deleted : "+FileOperation.deletecounter);
					         o.write("Total number of files whose path was traced : "+FileOperation.findcounter);
					         o.write("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");   
						     popout pp=new  popout();
						     pp.popoutput();

							 
						  }  
	        	    	 catch (SecurityException | IllegalAccessException| IllegalArgumentException| InvocationTargetException | IOException e)
	        	    	 {
							
							e.printStackTrace();
						 }*/
	        	    	 
	        	     }
	        	 
	            }
		  });
	     
	     
	     comboBox_2.addActionListener(new ActionListener()
		  {
	         public void actionPerformed(ActionEvent arg0)
	            {
	        	 
	        	 cmboitem = comboBox_2.getSelectedItem();
	        	 str1=(Mainwindow.cmboitem).toString();
	        	 comboBox.setEnabled(true);
	        	 
	            }
		  });
	     
	    
	     
	 }
}
