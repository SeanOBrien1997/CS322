package swingDemo;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class ChangeListener {
	public void stateChanged(
    		ChangeEvent e) {
    		System.out.println("Changing.");
    			//int value = this.getValue();
    			//System.out.println(+value);
    		}
    		}


//OutputVolume.addChangeListener(new ChangeListener() {
//public void stateChanged(ChangeEvent evt) {
//JSlider slider = (JSlider) evt.getSource();
//if (!slider.getValueIsAdjusting()) {
//  int value = slider.getValue();
//  System.out.println(value);
//  String vTextS=Integer.toString(value);
//  //JSlider.setParameter(vTextS, (float)((float)value));
//  //JTextField TextField = new JTextField(vTextS+"%");
//}
//}
//});

//public void stateChanged(ChangeEvent e) {
// Object o = e.getSource();
//System.out.println(o);
//  	  if (o.equals(frame.VolumeBox.OutputVolume)) {
//	      JSlider s = (JSlider)o;
//	      frame.setParameter(vText, (float)((float)s.getValue()));
//	      this.VolumeText.setText((int)(.getParameter(JoeFMSynthProgram.PARAM_ID_VOLUME) * 100F) + "%");
//	    } 		
//   }

