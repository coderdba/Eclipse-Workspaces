package com.gm.music;

//http://digitalsoundandmusic.com/2-3-13-modeling-sound-in-java/
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;

public class ExampleTone3Piano {

public static void main(String[] args){

try {
	
    //createTone(262, 100);
	//createTone(300, 100);
	//createTone(261, 100); // c4 
	//createTone(523, 100); // c5
	//createTone(1047, 100); // c6
	
	/*
	// mayamalavagaula
	 createTone(261, 100); // c4 sa 
	 createTone(277, 100); // c#4 ri1
	 createTone(329, 100); // e g3
	 createTone(349, 100); // f m1
	 createTone(392, 100); // g p
	 createTone(415, 100); // g# d1
	 createTone(494, 100); // b n3
	 createTone(523, 100); // c5 s
	 */
	
	 // sa ri ma ga ri sa ri ga ri sa
	 createTone(261, 100); // c4 sa 
	 createTone(277, 100); // c#4 ri1
	 createTone(349, 100); // f m1
	 createTone(329, 100); // e g3
	 createTone(277, 100); // c#4 ri1
	 createTone(261, 100); // c4 sa 
	 createTone(277, 100); // c#4 ri1
	 createTone(329, 100); // e g3
	 createTone(277, 100); // c#4 ri1
	 createTone(261, 100); // c4 sa 
	 
	 
} catch (LineUnavailableException lue) {
   System.out.println(lue);
}
}

/** parameters are frequency in Hertz and volume
**/
private static void createTone(int Hertz, int volume)
	    throws LineUnavailableException {
	    /** Exception is thrown when line cannot be opened */
	 
	    float rate=44100;
	    byte[] buf;
	    AudioFormat audioF;
	 
	    buf = new byte[1];
	    audioF = new AudioFormat(rate,8,1,true,false);  //sampleRate, sampleSizeInBits,channels,signed,bigEndian
	    
	    SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
	    sourceDL = AudioSystem.getSourceDataLine(audioF);
	    sourceDL.open(audioF); //orig
	    //sourceDL.open(audioF,44100/16);
	    sourceDL.start();
	 
	    float length=22050;
	    
	    for(int i=0; i<length; i++){
	    	
	      double angle = (i/rate)*Hertz*2.0*Math.PI;
	      
	      // original sine wave
	      //buf[0]=(byte)(Math.sin(angle)*volume); // sine wave
	      //buf[0]=(byte)(Math.sin(angle)*volume + i % 15); // sine wave+noise

	      // NEW1
	      // https://dsp.stackexchange.com/questions/46598/mathematical-equation-for-the-sound-wave-that-a-piano-makes?rq=1
	      // https://www.desmos.com/calculator/v5wrctppk1
	      double angle1 = (i/rate)*Hertz*2.0*Math.PI; //new orig
	      double angle2 = (((i/rate))*Hertz*2.0 + 2/3)*Math.PI; //new orig
	      
	      // additional
	     // double angle3 = (((i/rate))*Hertz)*Math.PI;
	      
	      //double angle2 = ((i/rate))*Hertz*2.0*Math.PI;
	      //double angle2 = 0;
	     
	      // sin(pi*x)**3 + sin (pi(x+(2/3)))
	      double sinAngle1 = Math.sin(angle1);
	      double cosAngle1 = Math.cos(angle1);
	      double tanAngle1 = Math.tan(angle1);
	      //buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
	      //buf[0] = (byte)((Math.pow(cosAngle1, 3) + Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
	      //buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2) + Math.sin(angle3)) * volume);
	      buf[0] = (byte)((Math.pow(cosAngle1,106) + Math.sin(angle2)) * volume); //good
	      
	      // NEW1 - alternative
	      //double angle1 = (i/rate)*Hertz*1*Math.PI;
	      //double angle2 = (i/rate)*Hertz*2*Math.PI;
	      
	      // alternative formula
          //buf[0] = (byte)((0.25 * Math.sin(angle2) + 0.85*Math.cos(angle2) - 0.25*Math.sin(angle1) ) * volume);
	      
	      //sourceDL.write(buf,0,1); // orig
	      sourceDL.write(buf,0,1);
	     
	    }
	 
	    sourceDL.drain();
	    sourceDL.stop();
	    sourceDL.close();
	  }
}