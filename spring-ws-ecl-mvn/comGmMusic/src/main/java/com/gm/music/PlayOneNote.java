package com.gm.music;

import javax.sound.midi.ShortMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Receiver;

public class PlayOneNote {

	public static void main(String[] args) throws Exception {

		// https://docs.oracle.com/javase/tutorial/sound/MIDI-synth.html
		
	    ShortMessage myMsg = new ShortMessage();
	    // Play the note Middle C (60) moderately loud
	    // (velocity = 93)on channel 4 (zero-based).
	    
	    myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 93); 
	    Synthesizer synth = MidiSystem.getSynthesizer();
	    synth.open();
	    Receiver synthRcvr = synth.getReceiver();
	    synthRcvr.send(myMsg, -1); // -1 means no time stamp

	}

}
