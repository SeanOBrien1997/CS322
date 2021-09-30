package swingQuestion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import swingDemo.RotaryKnob;

public class thirdSwing {
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}

			private void createAndShowGUI() {
		    	JFrame frame = new JFrame();
		    	frame.setTitle("DreiNullDrei");
		        frame.setSize(800, 400);
		        frame.setLocation(50,50);
		        
		        JSlider VolumeSlider;
		    	final JTextField VolumeText;
		    	
		    	JRadioButton saw;
		    	JRadioButton pulse;
		    	
		    	final JTextField modKnobTextField;
		    	final JTextField decayKnobTextField;
		    	
		    	final JTextField cutOffKnobTextField;
		    	final JTextField resoKnobTextField;
		    	
		    	final JTextField accentKnobTextField;
		    	final JTextField glideKnobTextField;
		    	
		        saw = new JRadioButton("Saw", true);
		        pulse = new JRadioButton("Pulse", true);
		    	
		    	VolumeSlider = new JSlider(JSlider.VERTICAL, 1, 100, 1);
		        int vText=10;
		        String vTextS=Integer.toString(vText);
		        VolumeText= new JTextField(vTextS);
		        VolumeText.setEditable(false);

		        VolumeSlider.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		    	        Object o = e.getSource();
		    	        JSlider s = (JSlider)o;
		    	        System.out.println(s.getValue());
		    	        VolumeText.setText(Integer.toString(s.getValue()));
		    	    }
			    });
		        
		        JPanel VolumePanel = new JPanel();
		        VolumePanel.setBounds(61,11,81,140);
		        VolumePanel.setLayout(new BoxLayout(VolumePanel, BoxLayout.Y_AXIS));
		        VolumePanel.add(new JLabel("Volume"));
		        VolumePanel.add(VolumeSlider);
		        VolumePanel.add(VolumeText);
		        
		        JPanel AmpPanel = new JPanel();
		        AmpPanel.setBounds(61,11,81,140);
		        AmpPanel.setLayout(new BoxLayout(AmpPanel, BoxLayout.Y_AXIS));
		        AmpPanel.add(new JLabel("Amp"));
		        AmpPanel.add(VolumePanel);
		        
		        JPanel SawPulsePanel = new JPanel();
		        SawPulsePanel.setBounds(61,11,81,140);
		        SawPulsePanel.setLayout(new BoxLayout(SawPulsePanel, BoxLayout.Y_AXIS));
		        ButtonGroup sawPulseBtnGroup = new ButtonGroup();
		        sawPulseBtnGroup.add(saw);
		        sawPulseBtnGroup.add(pulse);
		        SawPulsePanel.add(saw);
		        SawPulsePanel.add(pulse);
		        
		        JPanel OscPanel = new JPanel();
		        OscPanel.setBounds(61,11,81,140);
		        OscPanel.setLayout(new BoxLayout(OscPanel, BoxLayout.Y_AXIS));
		        OscPanel.add(new JLabel("Osc"));
		        OscPanel.add(SawPulsePanel);
		        
		        JPanel EnvelopePanel = new JPanel();
		        EnvelopePanel.setBounds(61,11,81,140);
		        EnvelopePanel.setLayout(new BoxLayout(EnvelopePanel, BoxLayout.Y_AXIS));
		        EnvelopePanel.add(new JLabel("Envelope"));
		        EnvelopePanel.add(new JLabel("Mod"));
		        RotaryKnob modKnob = new RotaryKnob();
		        int modKnobText = 1;
		        modKnobTextField = new JTextField(Integer.toString(modKnobText));
		        modKnobTextField.setEditable(false);
		        EnvelopePanel.add(modKnob);
		        EnvelopePanel.add(modKnobTextField);
		        EnvelopePanel.add(new JLabel("Decay"));
		        RotaryKnob decayKnob = new RotaryKnob();
		        int decayKnobText = 1;
		        decayKnobTextField = new JTextField(Integer.toString(decayKnobText));
		        decayKnobTextField.setEditable(false);
		        EnvelopePanel.add(decayKnob);
		        EnvelopePanel.add(decayKnobTextField);
		        
		        JPanel FilterPanel = new JPanel();
		        FilterPanel.setBounds(61,11,81,140);
		        FilterPanel.setLayout(new BoxLayout(FilterPanel, BoxLayout.Y_AXIS));
		        FilterPanel.add(new JLabel("Filter"));
		        FilterPanel.add(new JLabel("Cutoff"));
		        RotaryKnob cutOffKnob = new RotaryKnob();
		        int cutOffKnobText = 1;
		        cutOffKnobTextField = new JTextField(Integer.toString(cutOffKnobText));
		        cutOffKnobTextField.setEditable(false);
		        FilterPanel.add(cutOffKnob);
		        FilterPanel.add(cutOffKnobTextField);
		        FilterPanel.add(new JLabel("Reso"));
		        RotaryKnob resoKnob = new RotaryKnob();
		        int resoKnobText = 1;
		        resoKnobTextField = new JTextField(Integer.toString(resoKnobText));
		        resoKnobTextField.setEditable(false);
		        FilterPanel.add(resoKnob);
		        FilterPanel.add(resoKnobTextField);
		        
		        JPanel AccentPanel = new JPanel();
		        AccentPanel.setBounds(61,11,81,140);
		        AccentPanel.setLayout(new BoxLayout(AccentPanel, BoxLayout.Y_AXIS));
		        AccentPanel.add(new JLabel("Accent"));
		        AccentPanel.add(new JLabel("Accent"));
		        RotaryKnob accentKnob = new RotaryKnob();
		        int accentKnobText = 1;
		        accentKnobTextField = new JTextField(Integer.toString(accentKnobText));
		        accentKnobTextField.setEditable(false);
		        AccentPanel.add(accentKnob);
		        AccentPanel.add(accentKnobTextField);
		        AccentPanel.add(new JLabel("Glide"));
		        RotaryKnob glideKnob = new RotaryKnob();
		        int glideKnobText = 1;
		        glideKnobTextField = new JTextField(Integer.toString(glideKnobText));
		        glideKnobTextField.setEditable(false);
		        AccentPanel.add(glideKnob);
		        AccentPanel.add(glideKnobTextField);
		        
		        
		        modKnob.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		            	RotaryKnob t = (RotaryKnob) e.getSource();
		            	modKnobTextField.setText("" + ((int)(10 * t.getValue())));
		    	                    }
			   });
		        
		        decayKnob.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		            	RotaryKnob t = (RotaryKnob) e.getSource();
		            	decayKnobTextField.setText("" + ((int)(10 * t.getValue())));
		    	                    }
			   });
		        
		        cutOffKnob.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		            	RotaryKnob t = (RotaryKnob) e.getSource();
		            	cutOffKnobTextField.setText("" + ((int)(10 * t.getValue())));
		    	   }
			   });
		        
		        resoKnob.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		            	RotaryKnob t = (RotaryKnob) e.getSource();
		            	resoKnobTextField.setText("" + ((int)(10 * t.getValue())));
		    	   }
			   });
		        
		        accentKnob.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		            	RotaryKnob t = (RotaryKnob) e.getSource();
		            	accentKnobTextField.setText("" + ((int)(10 * t.getValue())));
		    	   }
			   });
		        
		        glideKnob.addChangeListener(new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		            	RotaryKnob t = (RotaryKnob) e.getSource();
		            	glideKnobTextField.setText("" + ((int)(10 * t.getValue())));
		    	   }
			   });
		        
		        Box DreiNullDrei = new Box(BoxLayout.X_AXIS);
		        DreiNullDrei.add(Box.createVerticalStrut(15));
		        DreiNullDrei.add(AmpPanel);
		        DreiNullDrei.add(Box.createVerticalStrut(15));
		        DreiNullDrei.add(OscPanel);
		        DreiNullDrei.add(Box.createVerticalStrut(15));
		        DreiNullDrei.add(EnvelopePanel);
		        DreiNullDrei.add(Box.createVerticalStrut(15));
		        DreiNullDrei.add(FilterPanel);
		        DreiNullDrei.add(Box.createVerticalStrut(15));
		        DreiNullDrei.add(AccentPanel);
		        DreiNullDrei.setBorder(BorderFactory.createTitledBorder("DreiNullDrei"));
		        
		        frame.getContentPane().setLayout(new GridBagLayout());
		        GridBagConstraints c = new GridBagConstraints();
		        
		        c.fill = GridBagConstraints.BOTH;
		        c.weightx = 0.5;
		        c.gridx = 0;
		        c.gridy = 0;
		        
		        frame.getContentPane().add(DreiNullDrei,c);
		        frame.setVisible(true);
			}
		});
	}

}
