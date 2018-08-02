package com.gm.music;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;

public class Notes {
	
	// Base Reference Frequency
	//private float baseFreqC4S = 261.6f; // s, c4
	//private float factor = 1.059463f; // 12 scale factor for every half step
	
	// Map of frequency power for other notes
	//private HashMap<String, float[]> noteFreqPower = new HashMap<String, float[]>();
	
	// Index to note order
	private HashMap<String, Integer> notesIndex = new HashMap<String, Integer>();
	
	// Notes map
	private HashMap<String, float[]> noteFreqMap1 = new HashMap<String, float[]>();
	private HashMap<String, float[][]> noteFreqMap2 = new HashMap<String, float[][]>();
	
	// Notes and their frequencies
	
	//private float[] xFreqs = { 1000f, 1000f, 1000f }; // dummy when raga's have gaps in their notes
	private float[] xFreqs = { 0f, 0f, 0f }; // dummy when raga's have gaps in their notes
	private float[][] xFreqsAll = {xFreqs, xFreqs, xFreqs};
	
	private float[] sFreqs = { 130.8f, 261.6f, 523.3f }; // c4
	private float[][] sFreqsAll = {sFreqs, xFreqs, xFreqs};

	private float[] r1Freqs = { 138.6f, 277.2f, 554.4f }; // c#
	private float[] r2Freqs = { 146.8f, 293.7f, 587.3f }; // d
	private float[] r3Freqs = { 155.6f, 311.1f, 622.3f }; // eb
	private float[][] rFreqsAll = {r1Freqs, r2Freqs, r3Freqs};

	private float[] g1Freqs = { 146.8f, 293.7f, 587.3f }; // d
	private float[] g2Freqs = { 155.6f, 311.1f, 622.3f }; // eb
	private float[] g3Freqs = { 164.8f, 329.6f, 659.3f }; // e
	private float[][] gFreqsAll = {g1Freqs, g2Freqs, g3Freqs};

	private float[] m1Freqs = { 174.6f, 349.2f, 698.5f }; // f
	private float[] m2Freqs = { 185.0f, 370.0f, 740.0f }; // f#
	private float[][] mFreqsAll = {m1Freqs, m2Freqs, xFreqs};

	private float[] pFreqs = { 196.0f, 392f, 784f }; // g
	private float[][] pFreqsAll = {pFreqs, xFreqs, xFreqs};

	private float[] d1Freqs = { 207.7f, 415.3f, 830.6f }; // g#
	private float[] d2Freqs = { 220.0f, 440.0f, 880.0f }; // a
	private float[][] dFreqsAll = {d1Freqs, d2Freqs, xFreqs};

	private float[] n1Freqs = { 220.0f, 440.0f, 880.0f }; // a
	private float[] n2Freqs = { 233.1f, 466.2f, 932.3f }; // bb
	private float[] n3Freqs = { 246.9f, 493.9f, 987.8f }; // b
	private float[][] nFreqsAll = {n1Freqs, n2Freqs, n3Freqs};

	// constructor
	public Notes() {
		
		setNoteMap();

	}
	
	private void setNoteMap() {
		
		// Index of order of notes
        notesIndex.put("s", 0);
        notesIndex.put("r", 1);
        notesIndex.put("g", 2);
        notesIndex.put("m", 3);
        notesIndex.put("p", 4);
        notesIndex.put("d", 5);
        notesIndex.put("n", 6);
        notesIndex.put("x", 7);
		
		// Map1
		noteFreqMap1.put("s", sFreqs);
		noteFreqMap1.put("r1", r1Freqs);
		noteFreqMap1.put("r2", r2Freqs);
		noteFreqMap1.put("r3", r3Freqs);
		noteFreqMap1.put("g1", g1Freqs);
		noteFreqMap1.put("g2", g2Freqs);
		noteFreqMap1.put("g3", g3Freqs);
		noteFreqMap1.put("m1", m1Freqs);
		noteFreqMap1.put("m2", m2Freqs);
		noteFreqMap1.put("p", pFreqs);
		noteFreqMap1.put("d1", d1Freqs);
		noteFreqMap1.put("d2", d2Freqs);
		noteFreqMap1.put("n1", n1Freqs);
		noteFreqMap1.put("n2", n2Freqs);
		noteFreqMap1.put("n3", n3Freqs);
		noteFreqMap1.put("x", xFreqs);
		
		// Map2
		noteFreqMap2.put("s", sFreqsAll);
		noteFreqMap2.put("r", rFreqsAll);
		noteFreqMap2.put("g", gFreqsAll);
		noteFreqMap2.put("m", mFreqsAll);
		noteFreqMap2.put("p", pFreqsAll);
		noteFreqMap2.put("d", dFreqsAll);
		noteFreqMap2.put("n", nFreqsAll);
		noteFreqMap2.put("x", xFreqsAll);

	}

	public HashMap getNotesIndex() {
		
		return notesIndex;
		
	}
	
	public float getNoteFreq(String noteName, int octave) {

		return noteFreqMap1.get(noteName)[octave];
				
	}

}
