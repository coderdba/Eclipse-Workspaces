package com.gm.music;

import javax.sound.sampled.LineUnavailableException;

public class Player {
	
	Tone   tone;
	Notes  notes;
	Ragas  ragas;
	
	// constructors
	public Player () {
		
		tone = new Tone();
		notes = new Notes();
		ragas = new Ragas();
		
	}
	
	public Player (String toneName) {
		
		tone  = new Tone(toneName);
		notes = new Notes();
		ragas = new Ragas();
		
	}
	
	// Methods
	public Ragas getRagas() {
		return this.ragas;
	}
	
	public Notes getNotes() {
		return this.notes;
	}
	
	public Tone getTone() {
		return this.tone;
	}
	
	public void playOneNote (float Hertz, int volume, float lengthSeconds) throws Exception {
		
		tone.play (Hertz, volume, lengthSeconds);
				  
	}
	
	public void playOneNoteOneSecond (float Hertz, int volume) throws Exception {
		
		playOneNote (Hertz, volume, 1.0f);
				  
	}
	
	
	public void playNoteList (int[] notesHertz, int volume, float lengthSeconds) throws Exception {
		
		int i = 0;
		
		System.out.println("There are " + notesHertz.length + " notes to play.");
		
		while (i < notesHertz.length) {
			
	    System.out.println("Playing " + notesHertz[i]);
		tone.play (notesHertz[i], volume, lengthSeconds);
		
		i++;
		
		}
	}
	
	public void playNoteListOneSecond (int[] notesHertz, int volume) throws Exception {
		
		playNoteList (notesHertz, volume, 1.0f);
		
	}

	public void playNoteList (float[][] notes, int volume) throws Exception {
		
		// notes[][] has note hertz and seconds to play
		
		int i = 0;
		
		System.out.println("There are " + notes.length + " notes to play.");
		
		while (i < notes.length) {
			
	    System.out.println("Playing " + notes[i][0] + " for " + notes[i][1] + " seconds.");
		tone.play ((int)notes[i][0], volume, notes[i][1]);
		
		i++;
		
		}
	}
	
}
