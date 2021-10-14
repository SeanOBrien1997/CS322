package moog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWin1 extends JFrame {

	private JPanel moogPanel;


	/**
	 * Launch the application.
	 */
	


	
	public static void setLAF(String laf){
		try {
			UIManager.setLookAndFeel(laf);
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	
	public MyWin1() {
		setForeground(Color.WHITE);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		final JButton playBtn = new JButton("Play");
		final JButton stopBtn = new JButton("Stop");
		playBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("You have clicked the play button");
				StdAudio.play("truax_basilica.wav");
			}
		});
		playBtn.setToolTipText("play filtered sound");
		playBtn.setEnabled(true);
		
		
		stopBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("You have clicked the stop button");
				StdAudio.stop();
			}
		});
		stopBtn.setToolTipText("play filtered sound");
		stopBtn.setEnabled(true);
		
		moogPanel = new JPanel();		
		moogPanel.setLayout(new FlowLayout());
	   setTitle("Capture/Playback Demo");
	   setDefaultCloseOperation(
	               EXIT_ON_CLOSE);
	   setSize(350,70);
		
		JLabel lblNewLabel = new JLabel("Play Sound");
		lblNewLabel.setToolTipText("play filtered sound");
		moogPanel.add(lblNewLabel);
		
		moogPanel.add(playBtn);
		moogPanel.add(stopBtn);
		setContentPane(moogPanel);
		
	}
	
	public static void main(String[] args) {
		for(LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
			System.out.println(lafInfo.getClassName());
		}
		setLAF("javax.swing.plaf.metal.MetalLookAndFeel");
		MoogFilt filt = new MoogFilt();
		filt.EnvDepth = 20;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWin1 frame = new MyWin1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}