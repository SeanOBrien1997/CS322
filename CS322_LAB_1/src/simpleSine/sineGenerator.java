package simpleSine;

import swingDemo.stdAudio;

public class sineGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double Fs=44100; //sampling Frequency
		double freq=440; //frequency of the sinewave
		int durSamps=(int) (1*Fs); //generate one second of the sinewave
		double[] sine=new double[durSamps];

		sine=genSine(Fs, freq, durSamps);

		stdAudio.play(sine);
		String filename="ExampleSine.wav";
		stdAudio.save(filename, sine);
	}
	
	public static double[] genSine(double Fs, double freq, int durSamps) {	
		int sampleIndex;
		double[] sinewave=new double[durSamps];

		for (sampleIndex=0;sampleIndex<durSamps;sampleIndex++){
			sinewave[sampleIndex]=Math.sin(2*Math.PI*sampleIndex*freq/Fs);
			
		}
		return sinewave;
		}

}
