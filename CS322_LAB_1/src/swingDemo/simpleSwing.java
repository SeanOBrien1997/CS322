package swingDemo;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;






public class simpleSwing {
        
//private JTextField VolumeText;
//private JTextField Osc1DetuneText;
//private JTextField Osc2DetuneText;
//private JTextField Osc2OctaveText;
//private JTextField OscMixText;

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    public static void createAndShowGUI() {
	    		    	
	    	JSlider Osc1Detune;
	    	JRadioButton Osc1Saw;
	    	JRadioButton Osc1Square;
	    	JRadioButton Osc1Triangle;
	    	JSlider Osc2Detune;
	    	JRadioButton Osc2Saw;
	    	JRadioButton Osc2Square;
	    	JRadioButton Osc2Triangle;

	    	
	    	
	    		    	
	    	final JTextField Osc1DetuneText;
	    	final JTextField Osc2DetuneText;
	    	final JTextField Osc2OctaveText;
	    	JTextField OscMixText;
	    	//JTextField Saw;
	    	//JTextField Sqr;
	    	//JTextField Tri;
	    	
	    	
	    	JSlider FilterA;
	    	JSlider FilterD;
	    	JSlider FilterS;
	    	JSlider FilterR;
	    	
	    	JTextField FilterAText;
	    	JTextField FilterDText;
	    	JTextField FilterSText;
	    	JTextField FilterRText;
	    	
	    	JSlider AmpA;
	    	JSlider AmpD;
	    	JSlider AmpS;
	    	JSlider AmpR;
	    	
	    	JTextField AmplifierAText;
	    	JTextField AmplifierDText;
	    	JTextField AmplifierSText;
	    	JTextField AmplifierRText;
	    	
	    	
	    	JSlider OutputVolume;
	    	final JTextField VolumeText;
	    	
	    	
	    	//JComponent DKnob;
	    	//JComponent RotaryKnobPlusText;
	    	//Create and set up the window.
	    	JFrame frame = new JFrame();
	    	frame.setTitle("JoeSynthExampleGUI");
	        frame.setSize(800, 400);
	        frame.setLocation(50,50);
	    	//frame.setResizable(false);
	    	
	        OutputVolume = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        int vText=10;
	        String vTextS=Integer.toString(vText);
            VolumeText= new JTextField("Volume "+vTextS+"%");
            VolumeText.setEditable(false);
        
	        
	        //oscillators
	        Osc1Saw = new JRadioButton("Saw", true);
	        Osc1Square = new JRadioButton("Sqr", true);
	        Osc1Triangle = new JRadioButton("Tri", true);
	        ButtonGroup Osc1Group = new ButtonGroup();
	        Osc1Group.add(Osc1Saw);
	        Osc1Group.add(Osc1Square);
	        Osc1Group.add(Osc1Triangle);
	        Osc1Detune = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
	        int DetuneText1=10;
	        Osc1DetuneText = new JTextField("Detune " + DetuneText1 +"Hz");
	        Osc1DetuneText.setEditable(false);
	        
	        Osc2Saw = new JRadioButton("Saw", true);
	        Osc2Square = new JRadioButton("Sqr", true);
	        Osc2Triangle = new JRadioButton("Tri", true);
	        ButtonGroup Osc2Group = new ButtonGroup();
	        Osc2Group.add(Osc2Saw);
	        Osc2Group.add(Osc2Square);
	        Osc2Group.add(Osc2Triangle);
	        Osc2Detune = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
	        int DetuneText2=10;
	        Osc2DetuneText = new JTextField("Detune " + DetuneText2 +"Hz");
	        Osc2DetuneText.setEditable(false);
	        
	        RotaryKnob Osc2Octave = new RotaryKnob();
	        int OctaveText=5;
	        Osc2OctaveText= new JTextField("octave " + OctaveText);
	        Osc2OctaveText.setEditable(false);
	    	
	        
	        RotaryKnob OscillatorMix = new RotaryKnob();
	        OscMixText= new JTextField("%");
	    	OscMixText.setEditable(false);
	        
	        FilterA = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        FilterAText = new JTextField("Sec");
	        FilterAText.setEditable(false);
	        
	        FilterD = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        FilterDText = new JTextField("Sec");
	        FilterDText.setEditable(false);
	        
	        FilterS = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        FilterSText = new JTextField("level");
	        FilterSText.setEditable(false);
	        
	        FilterR = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        FilterRText = new JTextField("Sec");
	        FilterRText.setEditable(false);
	        
	        AmpA = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        AmplifierAText = new JTextField("Sec");
	        AmplifierAText.setEditable(false);
	        
	        AmpD = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        AmplifierDText = new JTextField("Sec");
	        AmplifierDText.setEditable(false);
	        
	        AmpS = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        AmplifierSText = new JTextField("level");
	        AmplifierSText.setEditable(false);
	        
	        AmpR = new JSlider(JSlider.VERTICAL, 1, 100, 1);
	        AmplifierRText = new JTextField("Sec");
	        AmplifierRText.setEditable(false);
	        
	        	        
	        Container contentPane = frame.getContentPane();
	        frame.getContentPane().setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();
 	
	        
	        Box Osc1box = new Box(BoxLayout.Y_AXIS);
	        Osc1box.add(Box.createVerticalStrut(15));
	        Osc1box.add(Osc1Saw);
	        Osc1box.add(Osc1Square);
	        Osc1box.add(Osc1Triangle);
	        Osc1box.add(Osc1Detune);
	        Osc1box.add(Osc1DetuneText);
	        Osc1box.setBorder(BorderFactory.createTitledBorder("Oscilator 1"));

	        
	        Box Mixer = new Box(BoxLayout.Y_AXIS);
	        Mixer.add(Box.createVerticalStrut(15));
	        Mixer.add(OscillatorMix);
	        Dimension minSize = new Dimension(0, 200);
	        Dimension prefSize = new Dimension(0, 200);
	        Dimension maxSize = new Dimension(Short.MAX_VALUE, 200);
	        Mixer.add(new Box.Filler(minSize, prefSize, maxSize));
	        Mixer.add(OscMixText);
	        Mixer.setBorder(BorderFactory.createTitledBorder("Oscilator Mix"));
	        
	        Box Filter = new Box(BoxLayout.X_AXIS);
	        Filter.add(Box.createVerticalStrut(5));
	        Filter.add(FilterA);
	        Filter.add(FilterAText);
	        Filter.add(Box.createVerticalStrut(5));
	        Filter.add(FilterD);
	        Filter.add(FilterDText);
	        Filter.add(Box.createVerticalStrut(5));
	        Filter.add(FilterS);
	        Filter.add(FilterSText);
	        Filter.add(Box.createVerticalStrut(5));
	        Filter.add(FilterR);
	        Filter.add(FilterRText);
	        Filter.setBorder(BorderFactory.createTitledBorder("Filter Envelope"));
	        
	        Box Osc2box = new Box(BoxLayout.Y_AXIS);
	        Osc2box.add(Box.createVerticalStrut(15));
	        Osc2box.add(Osc2Saw);
	        Osc2box.add(Osc2Square);
	        Osc2box.add(Osc2Triangle);
	        Osc2box.add(Osc2Detune);
	        Osc2box.add(Osc2DetuneText);
	        Osc2box.add(Osc2Octave);
	        Osc2box.add(Osc2OctaveText);
	        Osc2box.setBorder(BorderFactory.createTitledBorder("Oscilator 2"));
	        
	        Box Amp = new Box(BoxLayout.X_AXIS);
	        Amp.add(Box.createVerticalStrut(5));
	        Amp.add(AmpA);
	        Amp.add(AmplifierAText);
	        Amp.add(Box.createVerticalStrut(5));
	        Amp.add(AmpD);
	        Amp.add(AmplifierDText);
	        Amp.add(Box.createVerticalStrut(5));
	        Amp.add(AmpS);
	        Amp.add(AmplifierSText);
	        Amp.add(Box.createVerticalStrut(5));
	        Amp.add(AmpR);
	        Amp.add(AmplifierRText);
	        Amp.setBorder(BorderFactory.createTitledBorder("Amplifier Envelope"));
	        
	        Box VolumeBox = new Box(BoxLayout.Y_AXIS);
	        VolumeBox.add(OutputVolume);
	        VolumeBox.add(new Box.Filler(minSize, prefSize, maxSize));
	        VolumeBox.add(VolumeText);
	        VolumeBox.setBorder(BorderFactory.createTitledBorder("Volume"));
	        
	        
	                
	        c.fill = GridBagConstraints.BOTH;
	        c.weightx = 0.5;
	        c.gridx = 0;
	        c.gridy = 0;
	        frame.getContentPane().add(Osc1box,c);
	        
	        GridBagConstraints c1 = new GridBagConstraints();
	        c1.fill = GridBagConstraints.BOTH;
	        c1.weightx = 0.5;
	        c1.weighty = 1;
	        c1.gridx = 0;
	        c1.gridy = 1;
	        frame.getContentPane().add(Osc2box,c1);
	        
	        GridBagConstraints c2 = new GridBagConstraints();
	        c2.fill = GridBagConstraints.BOTH;
	        c2.gridx = 1;
	        c2.gridy = 0;
	        c2.gridheight=2;
	        //frame.getContentPane().add(Mixer,c2);
	        
	        GridBagConstraints c3 = new GridBagConstraints();
	        c3.fill = GridBagConstraints.BOTH;
	        c3.weightx = 0.5;
	        c3.weighty = 1;
	        c3.gridx = 2;
	        c3.gridy = 0;
	        c3.gridheight=1;
	        frame.getContentPane().add(Filter,c3);
	        
	        GridBagConstraints c4 = new GridBagConstraints();
	        c4.fill = GridBagConstraints.BOTH;
	        c4.weightx = 0.5;
	        c4.weighty = 1;
	        c4.gridx = 2;
	        c4.gridy = 1;
	        c4.gridheight=1;
	        frame.getContentPane().add(Amp,c4);
	        
	        GridBagConstraints c5 = new GridBagConstraints();
	        c5.fill = GridBagConstraints.BOTH;
	        c5.weightx = 0.5;
	        c5.weighty = 1;
	        c5.gridx = 3;
	        c5.gridy = 0;
	        c5.gridheight=2;
	        frame.getContentPane().add(VolumeBox,c5);

	        OutputVolume.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
    	        Object o = e.getSource();
    	        JSlider s = (JSlider)o;
    	        System.out.println(s.getValue());
    	        VolumeText.setText("Volume " + s.getValue()+"%");
    	                    }
	        });
	        
	        Osc1Detune.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	    	        Object o = e.getSource();
	    	        JSlider s = (JSlider)o;
	    	        System.out.println(s.getValue());
	    	        Osc1DetuneText.setText("Detune " + s.getValue()+"Hz");
	    	                    }
		        });

	        Osc2Detune.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	    	        Object o = e.getSource();
	    	        JSlider s = (JSlider)o;
	    	        System.out.println(s.getValue());
	    	        Osc2DetuneText.setText("Detune " + s.getValue()+"Hz");
	    	                    }
		        });

	        Osc2Octave.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
//	    	        Object o = e.getSource();
//	    	        RotaryKnob s = (RotaryKnob)o;
//	    	        System.out.println(s.getValue());
//	    	        Osc2OctaveText.setText("Octave " + s.getValue());
	            	RotaryKnob t = (RotaryKnob) e.getSource();
	            	Osc2OctaveText.setText("octave: " + ((int)(10 * t.getValue())));
	    	                    }
		        });

	          frame.setVisible(true);
	        
	    }
	    
	    public static void main(String[] args) {
	    
	    	
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}



