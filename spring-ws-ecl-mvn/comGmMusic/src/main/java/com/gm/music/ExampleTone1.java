package com.gm.music;

// http://digitalsoundandmusic.com/2-3-13-modeling-sound-in-java/
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;
 
public class ExampleTone1{
 
  public static void main(String[] args){
 
    try {
    	
        //ExampleTone1.createTone(262, 100);
    	//ExampleTone1.createTone(300, 100);
    	//ExampleTone1.createTone(261, 100); // c4 
    	//ExampleTone1.createTone(523, 100); // c5
    	//ExampleTone1.createTone(1047, 100); // c6
    	
    	// mayamalavagaula
    	ExampleTone1.createTone(261, 100); // c4 
    	ExampleTone1.createTone(277, 100); // c#4
    	ExampleTone1.createTone(329, 100); // e
    	ExampleTone1.createTone(349, 100); // f
    	ExampleTone1.createTone(392, 100); // g
    	ExampleTone1.createTone(415, 100); // g#
    	ExampleTone1.createTone(494, 100); // b
    	ExampleTone1.createTone(523, 100); // c5
    	
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
    	
      double angle = (i/rate)*Hertz*2.0*Math.PI;
      buf[0]=(byte)(Math.sin(angle)*volume); // sine wave
      //buf[0]=(byte)(Math.sin(angle)*volume + i % 15); // sine wave+noise
      
      sourceDL.write(buf,0,1);
    }
 
    sourceDL.drain();
    sourceDL.stop();
    sourceDL.close();
  }
}