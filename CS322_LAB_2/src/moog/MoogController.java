package moog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MoogController {

	private MoogFilt filter;
	private double stagedFc = Double.MIN_VALUE;
	private int stagedMainOsc;
	private static int midiLowerBound = 30;
	private static int midiUpperBound = 80;

	public MoogController(MoogFilt filter) {
		this.filter = filter;
	}

	public void play() {
		double localFc = 0;
		if (stagedFc == Double.MIN_VALUE) {
			localFc = 30;
		} else {
			localFc = this.stagedFc;
		}
		this.filter.MoogFilterTest(localFc);
	}

	public void stop() {
		StdAudio.close();
	}

	public void setCutoff(double fc) {
		this.stagedFc = fc;
	}

	public void setEnvelopeDepth(double envDepth) {
		this.filter.EnvDepth = envDepth;
	}

	public void setMainOscVal(int noteValue) {
		if (noteValue > midiLowerBound && noteValue < midiUpperBound) {
			this.stagedMainOsc = noteValue;
		} else {
			System.out.println("Out of bounds for note value.");
		}
	}
}

class ControllerUserInterface extends JFrame {
	private MoogController controller;
	private JPanel controllerPanel;

	public ControllerUserInterface(MoogController controller) {
		this.controller = controller;
	}

	public void init() {

		setForeground(Color.WHITE);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		final JButton playBtn = new JButton("Play");
		final JButton stopBtn = new JButton("Stop");
		playBtn.setToolTipText("Play sound");
		stopBtn.setToolTipText("Stop sound");

		playBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.play();
			}
		});

		stopBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.stop();
			}
		});

		final JSlider cutoffSlider = new JSlider(JSlider.VERTICAL, 1, 100, 1);
		final JSlider envDepthSlider = new JSlider(JSlider.VERTICAL, 1, 100, 1);

		cutoffSlider.setToolTipText("Adjust cuttoff");
		envDepthSlider.setToolTipText("Adjust envelope depth");

		cutoffSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider) e.getSource();
				System.out.println("Updating cutoff to: " + s.getValue());
				controller.setCutoff((double) s.getValue());
			}
		});

		envDepthSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider) e.getSource();
				System.out.println("Updating envelope depth to: " + s.getValue());
				controller.setEnvelopeDepth((double) s.getValue());
			}
		});

		JTextField midiField = new JTextField("Enter a midi value between 30 and 80");

		midiField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}
			
			public void warn() {
				try {
					if(Integer.parseInt(midiField.getText()) < 30 || Integer.parseInt(midiField.getText()) > 80) {
						System.out.println("Invalid midi value");
					} else {
						System.out.println("Updating midi value to " + Integer.parseInt(midiField.getText()));
						controller.setMainOscVal(Integer.parseInt(midiField.getText()));
					}
				} catch( Exception e) {
					
				}

			}
		});

		controllerPanel = new JPanel();
		controllerPanel.setLayout(new FlowLayout());
		setTitle("Moog Controller");
		setSize(350, 70);

		controllerPanel.add(cutoffSlider);
		controllerPanel.add(envDepthSlider);
		controllerPanel.add(midiField);
		controllerPanel.add(playBtn);
		controllerPanel.add(stopBtn);

		setContentPane(controllerPanel);

	}

	public static void main(String[] args) {
		MoogFilt filter = new MoogFilt();
		MoogController controller = new MoogController(filter);
		ControllerUserInterface frame = new ControllerUserInterface(controller);
		frame.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
