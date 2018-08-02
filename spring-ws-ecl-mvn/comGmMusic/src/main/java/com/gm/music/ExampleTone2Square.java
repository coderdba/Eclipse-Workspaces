package com.gm.music;

//http://digitalsoundandmusic.com/2-3-13-modeling-sound-in-java/
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;

public class ExampleTone2Square {

public static void main(String[] args){

 try {
 	
    //ExampleTone2Square.createTone(262, 100);
 	//ExampleTone2Square.createTone(300, 100);
 	//ExampleTone2Square.createTone(261, 100); // c4 
 	//ExampleTone2Square.createTone(523, 100); // c5
 	//ExampleTone2Square.createTone(1047, 100); // c6
 	
 	// mayamalavagaula
	 ExampleTone2Square.createTone(261, 100); // c4 
	 ExampleTone2Square.createTone(277, 100); // c#4
	 ExampleTone2Square.createTone(329, 100); // e
	 ExampleTone2Square.createTone(349, 100); // f
	 ExampleTone2Square.createTone(392, 100); // g
	 ExampleTone2Square.createTone(415, 100); // g#
	 ExampleTone2Square.createTone(494, 100); // b
	 ExampleTone2Square.createTone(523, 100); // c5
 	
 } catch (LineUnavailableException lue) {
     System.out.println(lue);
 }
}

/** parameters are frequency in Hertz and volume
**/
public static void createTone(int Hertz, int volume)
 throws LineUnavailableException {
 /** Exception is thrown when line cannot be opened */

 float rate = 44100;
 float ratehalf = 22050;
 byte[] buf;
 AudioFormat audioF;

 buf = new byte[1];
 audioF = new AudioFormat(rate,8,1,true,false);
 //sampleRate, sampleSizeInBits,channels,signed,bigEndian

 SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
 sourceDL = AudioSystem.getSourceDataLine(audioF);
 sourceDL.open(audioF);
 sourceDL.start();

 for(int i=0; i<rate; i++){
    
	double angle;
	
	if (i < ratehalf) {
		
		angle = Hertz*Math.PI/4 ;
	}
	else
	{
		angle = Hertz*3*Math.PI/4 ;
	}
	
	buf[0] = (byte)(angle*volume);
	
   // original code for sine wave
   //double angle = (i/rate)*Hertz*2.0*Math.PI;
   //buf[0]=(byte)(Math.sin(angle)*volume); // sine wave
   //buf[0]=(byte)(Math.sin(angle)*volume + i % 15); // sine wave+noise
   
   sourceDL.write(buf,0,1);
 }

 sourceDL.drain();
 sourceDL.stop();
 sourceDL.close();
}
}