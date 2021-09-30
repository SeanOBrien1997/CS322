package swingQuestion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class secondSwing {
	
	public static void createAndShowGUI() {
    	JFrame frame = new JFrame();
    	frame.setTitle("JayDLay v0.8");
        frame.setSize(800, 400);
        frame.setLocation(50,50);
        
        JSlider DelaySlider;
    	final JTextField DelayText;
    	
    	JSlider FeedbackSlider;
    	final JTextField FeedbackText;
    	
    	JSlider VolumeSlider;
    	final JTextField VolumeText;
    	
        DelaySlider = new JSlider(JSlider.VERTICAL, 1, 100, 1);
        int dText=10;
        String dTextS=Integer.toString(dText);
        DelayText= new JTextField(dTextS);
        DelayText.setEditable(false);
        
        FeedbackSlider = new JSlider(JSlider.VERTICAL, 1, 100, 1);
        int fText=10;
        String fTextS=Integer.toString(fText);
        FeedbackText= new JTextField(fTextS);
        FeedbackText.setEditable(false);
        
        VolumeSlider = new JSlider(JSlider.VERTICAL, 1, 100, 1);
        int vText=10;
        String vTextS=Integer.toString(vText);
        VolumeText= new JTextField(vTextS+"dB");
        VolumeText.setEditable(false);
                
        DelaySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
    	        Object o = e.getSource();
    	        JSlider s = (JSlider)o;
    	        System.out.println(s.getValue());
    	        DelayText.setText(Integer.toString(s.getValue()));
    	   }
	    });
        
        VolumeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
    	        Object o = e.getSource();
    	        JSlider s = (JSlider)o;
    	        System.out.println(s.getValue());
    	        VolumeText.setText(Integer.toString(s.getValue())+"dB");
    	    }
	    });
        
        FeedbackSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
    	        Object o = e.getSource();
    	        JSlider s = (JSlider)o;
    	        System.out.println(s.getValue());
    	        FeedbackText.setText(Integer.toString(s.getValue()));
    	    }
	    });
        
        frame.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        
        
        
        
        JPanel DelayPanel = new JPanel();
        DelayPanel.setBounds(61,11,81,140);
        DelayPanel.setLayout(new BoxLayout(DelayPanel, BoxLayout.Y_AXIS));
        DelayPanel.add(new JLabel("Delay"));
        DelayPanel.add(DelaySlider);
        DelayPanel.add(DelayText);
        
        JPanel FeedbackPanel = new JPanel();
        FeedbackPanel.setBounds(61,11,81,140);
        FeedbackPanel.setLayout(new BoxLayout(FeedbackPanel, BoxLayout.Y_AXIS));
        FeedbackPanel.add(new JLabel("Feedback"));
        FeedbackPanel.add(FeedbackSlider);
        FeedbackPanel.add(FeedbackText);
        
        JPanel VolumePanel = new JPanel();
        VolumePanel.setBounds(61,11,81,140);
        VolumePanel.setLayout(new BoxLayout(VolumePanel, BoxLayout.Y_AXIS));
        VolumePanel.add(new JLabel("Volume"));
        VolumePanel.add(VolumeSlider);
        VolumePanel.add(VolumeText);
        
        
        Box JayDLay = new Box(BoxLayout.X_AXIS);
        JayDLay.add(Box.createVerticalStrut(15));
        JayDLay.add(DelayPanel);
        JayDLay.add(Box.createVerticalStrut(15));
        JayDLay.add(FeedbackPanel);
        JayDLay.add(Box.createVerticalStrut(15));
        JayDLay.add(VolumePanel);
        JayDLay.setBorder(BorderFactory.createTitledBorder("JayDLay"));
        
        frame.getContentPane().add(JayDLay,c);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
