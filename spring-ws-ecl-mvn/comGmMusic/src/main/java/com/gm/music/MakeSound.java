package com.gm.music;

// https://stackoverflow.com/questions/1932490/java-generating-sound

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MakeSound {
  public static void main(String[] args) throws LineUnavailableException {
    System.out.println("Make sound");
    
    byte[] buf = new byte[2];
    int frequency = 44100; //44100 sample points per 1 second
    //int frequency = 88200; //44100 sample points per 1 second
    //int frequency = 176400; //44100 sample points per 1 second
    
    AudioFormat af = new AudioFormat((float) frequency, 16, 1, true, false);
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open();
    sdl.start();
    
    int durationMs = 500;
    int numberOfTimesFullSinFuncPerSec = 441; //number of times in 1sec sin function repeats
    
    for (int i = 0; i < durationMs * (float) 44100 / 1000; i++) { //1000 ms in 1 second
    	
      float numberOfSamplesToRepresentFullSin= (float) frequency / numberOfTimesFullSinFuncPerSec;
      
      // /divide with 2 since sin goes 0PI to 2PI
      double angle = i / (numberOfSamplesToRepresentFullSin/ 2.0) * Math.PI;  
      
      //32767 - max value for sample to take (-32767 to 32767)
      short a = (short) (Math.sin(angle) * 32767);  
      
      buf[0] = (byte) (a & 0xFF); //write 8bits ________WWWWWWWW out of 16
      buf[1] = (byte) (a >> 8); //write 8bits WWWWWWWW________ out of 16
      
      sdl.write(buf, 0, 2);
      
    }
    sdl.drain();
    sdl.stop();
  }
}
