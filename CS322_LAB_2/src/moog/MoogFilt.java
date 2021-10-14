package moog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MoogFilt { //extends JFrame {
private static double Jprev, Fprev, Zprev, Hprev, Iprev;
private static double FilterEnvIndex=0;
private static double FilterEnvValuePrev=0;
private static double SR=44100;
private double Fc=5; 
public double EnvDepth=14000;
public double Res=0.2;
private boolean status=true;  //note on off
private boolean onoff=true;  


	public void FilterInit() {
	Jprev=0; Fprev=0;
	Zprev=0; Hprev=0;
	Iprev=0;
}

public void setParams(double evd) {
	EnvDepth=evd;
}

public void toggleStatus(boolean st) {
	onoff=st;
}

public void setRes(double res){
	Res=res;
}

public void MoogFilterTest(double Fc) {
//public static void MoogFilterTest(double Fc) {
	
	System.out.println("Hello i'n in MFTest!!!!!" + Fc);
	//double Fc=50; 
	  //how much the filter opens
	int sampleIndex;

	double Env;
	
	double FcADSREnv;
	//double Res=0.99; //can vary from 0.0 to 1
	double input1, input2,input3,input4, input5,input6, input;
	int TotalTime=30*(int) SR;
	double[] outputA=new double [TotalTime];
	double Tail=3; //in seconds envelope tail release key
	int TailSamps=(int) Math.round(SR*Tail);
	double FiltOutput,output;
	
	//3 oscillators saws constructors
	
	DPWosc DO1=new DPWosc();
	DPWosc DO2=new DPWosc();
	DPWosc DO3=new DPWosc();
	// (i) Added 3 more sawtooth oscillators for a total of 6
	DPWosc DO4=new DPWosc();
	DPWosc DO5=new DPWosc();
	DPWosc DO6=new DPWosc();
	DO1.init();DO2.init();DO3.init();DO4.init();DO5.init();DO6.init();
	FilterInit();
	
	for (sampleIndex=0;sampleIndex<TotalTime;sampleIndex++) {
	//	if (sampleIndex<=(TotalTime-TailSamps)) status=true;  
	//	else {
	//		status=false;
	//	}
		if(onoff) status = true;
		else status = false;

		         //Attack,   Decay, Sustain, Release
		//Attack = no. milliseconds to reach amp=1.0
		//
		Env=FilterADSR(2000, 3700, 0.1, 3000, sampleIndex,SR, status); //ADSR 0-1
		FcADSREnv=Fc+(EnvDepth-Fc)*Env;  //scaling envelope
		
		input1=DO1.GenOsc(40, sampleIndex, SR, "sawtooth"); 
		input2=DO2.GenOsc(40.2, sampleIndex, SR, "sawtooth"); //40.2
		input3=DO3.GenOsc(39.6, sampleIndex, SR, "sawtooth");  //39.8
		/*
		 * (ii) modified to have different octave pitches by supplying different 
		 */
		input4=DO4.GenOsc(39.4, sampleIndex, SR, "sawtooth");  //39.8
		input5=DO5.GenOsc(39.2, sampleIndex, SR, "sawtooth");  //39.8
		input6=DO6.GenOsc(39, sampleIndex, SR, "sawtooth");  //39.8
		
		input=input1+input2+input3+input4+input5+input6;
				

		FiltOutput=MoogfilterEqn (input, FcADSREnv, Res, SR);
		output=FiltOutput;
		output=output/5;
		StdAudio.play(output);
	}

		//outputA[sampleIndex]=output; //write output to an array for saving as a wav file			}
	    //StdAudio.save("MoogOutput.wav",outputA);
}


public double FilterADSR(double FilterAttack, double FilterDecay, double FilterSustain, double FilterRelease, double SampleIndex,double Fs, boolean status) {
//public static double FilterADSR(double FilterAttack, double FilterDecay, double FilterSustain, double FilterRelease, double SampleIndex,double Fs, boolean status) {
	double FilterEnv=0;
	double zeta=Math.pow(10, -2/((Fs*(FilterDecay-FilterAttack)*0.001)));  //attack
	double zetaR=Math.pow(10, -2/((Fs*FilterRelease)*0.001));  //release
	double attackSamples=Fs*FilterAttack*0.001;
	//System.out.println("at="+FilterEnvValuePrev);
	//note_on=true
	FilterEnvIndex=SampleIndex;
	if (status) {
		if (FilterEnvIndex<attackSamples) {
			//FilterEnv=1;
			FilterEnv=FilterEnvValuePrev+1/attackSamples;
			FilterEnvValuePrev=FilterEnv;
           // System.out.println("at="+FilterEnvValuePrev+" "+SampleIndex);
		}
		else { 
		//	FilterEnv=1;
			FilterEnv=zeta*FilterEnvValuePrev+(1-zeta)*FilterSustain;
			FilterEnvValuePrev=FilterEnv;
			////if(SampleIndex<5.7*Fs)
			 // System.out.println("sus="+FilterEnvValuePrev+" "+SampleIndex);	
		}
	}
	//note_off=true;
	else {
		//FilterEnv=1;
		FilterEnv=zetaR*FilterEnvValuePrev;
		FilterEnvValuePrev=FilterEnv;
		//System.out.println("decay="+FilterEnvValuePrev+" "+SampleIndex/Fs);
	}
	
	
	return FilterEnv;

}

public double MoogfilterEqn(double input, double cutoff, double res, double SR){
//public static double MoogfilterEqn(double input, double fc, double res, double SR){
	double Gcomp=0.5;
	double Rad=2*Math.PI;
	double Wc=Rad*cutoff/SR;
	double g;
	double Gres;
	double w, v, Z, F, H, I, J;
	double A=0, B=0,C=0,D=0,E=1;
	double a=1/1.3, b=0.3/1.3;
	double output;
	
    //g determines the cutoff≠≠
	g=0.9892*Wc-0.4342*Math.pow(Wc,2)+0.1381*Math.pow(Wc,3)-0.0202*Math.pow(Wc,4);
	Gres=res*(1.0029+0.052*Wc-0.0926*Math.pow(Wc,2)+0.0218*Math.pow(Wc,3));
	
	w=4.*Gres*(Jprev-Gcomp*input);  //see Valimaki paper
	v=input-w;
	Z=Math.tanh(v);
	F=(1-g)*Fprev+g*(a*Z+b*Zprev);
	H=(1-g)*Hprev+g*(a*F+b*Fprev);
	I=(1-g)*Iprev+g*(a*H+b*Hprev);
	J=(1-g)*Jprev+g*(a*I+b*Iprev);
	output=E*J+A*Z+B*F+C*H+D*I;
	Jprev=J;
	Fprev=F;
	Zprev=Z;
	Hprev=H;
	Iprev=I;

	return output;

}

//public static void startFilt() {
public void startFilt() {
	MoogFilterTest(Fc);
}

//public static void main(String args[]) throws Exception{

	//MoogFilterTest();
	
//}
}