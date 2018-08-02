package com.gm.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Tone {

	String toneName;

	public Tone() {
		toneName = "default tone";
	}

	public Tone(String toneName) {
		this.toneName = toneName;
	}
	
	public String toString() {
		return "this is a " + toneName;
	}

	
	public void play (float Hertz, int volume, float lengthSeconds) throws LineUnavailableException {
		/** Exception is thrown when line cannot be opened */
				
		float rate=44100;
		float lengthAsRate = Math.round(rate * lengthSeconds);
	    	    
	    byte[] buf;
	    AudioFormat audioF;
				 
		buf = new byte[1];
		audioF = new AudioFormat(rate,8,1,true,false);  //sampleRate, sampleSizeInBits,channels,signed,bigEndian
				    
		SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL.open(audioF); //orig
		sourceDL.start();
				 
		for(int i=0; i<lengthAsRate; i++){

			// https://dsp.stackexchange.com/questions/46598/mathematical-equation-for-the-sound-wave-that-a-piano-makes?rq=1
			// https://www.desmos.com/calculator/v5wrctppk1
			double angle1 = (i/rate)*Hertz*2.0*Math.PI; //new orig
			double angle2 = (((i/rate))*Hertz*2.0 + 2/3)*Math.PI; //new orig

			double sinAngle1 = Math.sin(angle1);
			double cosAngle1 = Math.cos(angle1);
			double sinAngle2 = Math.sin(angle2);
			double cosAngle2 = Math.cos(angle2);
				      
			//buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
			//buf[0] = (byte)((Math.pow(cosAngle1, 3) + Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
			//buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2) + Math.sin(angle3)) * volume);
			//buf[0] = (byte)((Math.pow(cosAngle1,106) + Math.sin(angle2)) * volume); //good
			buf[0] = (byte)((Math.pow(cosAngle1,6) + Math.sin(angle2)) * volume); //good	      
			sourceDL.write(buf,0,1);
				     
			}
				 
			sourceDL.drain();
			sourceDL.stop();
			sourceDL.close();	  
	 }
}