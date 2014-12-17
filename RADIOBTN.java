package filetraversal;

import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class RADIOBTN
{

	public static JRadioButton getSelectedRadio(ButtonGroup group) {
	    for (Enumeration eRadio=group.getElements(); eRadio.hasMoreElements(); ) {
	        //Iterating over the Radio Buttons
	        JRadioButton radioButton = (JRadioButton)eRadio.nextElement();
	        //Comparing radioButtons model with groups selection
	        if (radioButton.getModel() == group.getSelection()) {
	            return radioButton;
	        }
	    }
	    return null;
	}
	
}
