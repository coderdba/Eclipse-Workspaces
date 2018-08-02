package com.gm.music;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;

public class RagaAndNotes {

	// Notes
	private HashMap<String, float[]> noteFreqList = new HashMap<String, float[]>();
	
	private float[] sFreqs = { 130.8f, 261.6f, 523.3f }; // c4

	private float[] r1Freqs = { 138.6f, 277.2f, 554.4f }; // c#
	private float[] r2Freqs = { 146.8f, 293.7f, 587.3f }; // d
	private float[] r3Freqs = { 155.6f, 311.1f, 622.3f }; // eb

	private float[] g1Freqs = { 146.8f, 293.7f, 587.3f }; // d
	private float[] g2Freqs = { 155.6f, 311.1f, 622.3f }; // eb
	private float[] g3Freqs = { 164.8f, 329.6f, 659.3f }; // e

	private float[] m1Freqs = { 174.6f, 349.2f, 698.5f }; // f
	private float[] m2Freqs = { 185.0f, 370.0f, 740.0f }; // f#

	private float[] pFreqs = { 196.0f, 392f, 784f }; // g

	private float[] d1Freqs = { 207.7f, 415.3f, 830.6f }; // g#
	private float[] d2Freqs = { 220.0f, 440.0f, 880.0f }; // a

	private float[] n1Freqs = { 220.0f, 440.0f, 880.0f }; // a
	private float[] n2Freqs = { 233.1f, 466.2f, 932.3f }; // bb
	private float[] n3Freqs = { 246.9f, 493.9f, 987.8f }; // b

	private float[] xFreqs = { 0f, 0f, 0f }; // dummy when raga's have gaps in their notes
										
	// Ragas
	private HashMap<String, String[]> ragaNoteList = new HashMap<String, String[]>();

	private String[] mayamalavagaula = { "s", "r1", "g3", "m1", "p", "d1", "n3" };
	private String[] shankarabharana = { "s", "r2", "g3", "m1", "p", "d1", "n3" };
	private String[] mrugendramadhyama = { "s", "r3", "x", "m1", "x", "d1", "n2" };

	public void RagaAndNotes() {

		setRagaList();
		setNoteList();

	}

	public String[] getRagaNotes(String ragaName) {

		return ragaNoteList.get(ragaName);

	}

	public float getNoteFreq(String noteName, int octave) {

		return noteFreqList.get(noteName)[octave];

	}

	private void setRagaList() {
		ragaNoteList.put("mayamalavagaula", mayamalavagaula);
		ragaNoteList.put("shankarabharana", shankarabharana);
		ragaNoteList.put("mrugendramadhyama", mrugendramadhyama);
	}

	private void setNoteList() {
		noteFreqList.put("s", sFreqs);
		noteFreqList.put("r1", r1Freqs);
		noteFreqList.put("r2", r2Freqs);
		noteFreqList.put("r3", r3Freqs);
		noteFreqList.put("g1", g1Freqs);
		noteFreqList.put("g2", g2Freqs);
		noteFreqList.put("g3", g3Freqs);
		noteFreqList.put("m1", m1Freqs);
		noteFreqList.put("m2", m2Freqs);
		noteFreqList.put("p", pFreqs);
		noteFreqList.put("d1", d1Freqs);
		noteFreqList.put("d2", d2Freqs);
		noteFreqList.put("n1", n1Freqs);
		noteFreqList.put("n2", n2Freqs);
		noteFreqList.put("n3", n3Freqs);
		noteFreqList.put("x", xFreqs);
	}


}