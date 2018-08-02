package com.gm.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Tone2a {

	String toneName;

	public Tone2a() {
		toneName = "piano";
	}

	public String toString() {
		return "this is a " + toneName;
	}

	public void playOneNote (int Hertz, int volume, float lengthSeconds) {
		
	}
	
	public void playOneNoteOneSecond (int Hertz, int volume) throws Exception {
		playOneSecond (Hertz, volume);
	}
	
	public void playNoteListOneSecond (int[] notesHertz, int volume) throws Exception {
		
		int i = 0;
		
		System.out.println("There are " + notesHertz.length + " notes to play.");
		
		while (i < notesHertz.length) {
			
	    System.out.println("Playing " + notesHertz[i]);
		
		play (notesHertz[i], volume, 1.0f);
		
		i++;
		
		}
	}
	
	public void playNoteList (int[] notesHertz, int volume, float lengthSeconds) throws Exception {
		
		int i = 0;
		
		System.out.println("There are " + notesHertz.length + " notes to play.");
		
		while (i < notesHertz.length) {
			
	    System.out.println("Playing " + notesHertz[i]);
		play (notesHertz[i], volume, lengthSeconds);
		
		i++;
		
		}
	}
	
	public void playNoteList (float[][] notes, int volume) throws Exception {
		
		// notes[][] has note hertz and seconds to play
		
		int i = 0;
		
		System.out.println("There are " + notes.length + " notes to play.");
		
		while (i < notes.length) {
			
	    System.out.println("Playing " + notes[i][0] + " for " + notes[i][1] + " seconds.");
		play ((int)notes[i][0], volume, notes[i][1]);
		
		i++;
		
		}
	}
	
	private void playOneSecond (int Hertz, int volume) throws LineUnavailableException {
		/** Exception is thrown when line cannot be opened */
		
		play (Hertz, volume, 1.0f);
				  
	 }
	
	private void play (int Hertz, int volume, float lengthSeconds) throws LineUnavailableException {
		/** Exception is thrown when line cannot be opened */
				
	    float rate = 44100;
	    double f1 = 261.626;    
	    double f2 = 329.628;
	    double a = .5;
	    double twoPiF1 = 2*Math.PI*f1;
	    double twoPiF2 = 2*Math.PI*f2;
		
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
			
			double time = i / rate;
			// http://archive.oreilly.com/oreillyschool/courses/data-structures-algorithms/soundFiles.html
			buf[0] = (byte)(volume * (Math.sin(twoPiF1*time) + Math.sin(twoPiF2*time))/2);	      
			sourceDL.write(buf,0,1);
				     
			}
				 
			sourceDL.drain();
			sourceDL.stop();
			sourceDL.close();	  
	 }	
	
	private void playOld (int Hertz, int volume, float lengthSeconds) throws LineUnavailableException {
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