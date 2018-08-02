package com.gm.music;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;

public class RagaList {

	// Notes
	private float[] s = { 130.8f, 261.6f, 523.3f }; // c4

	private float[] r1 = { 138.6f, 277.2f, 554.4f }; // c#
	private float[] r2 = { 146.8f, 293.7f, 587.3f }; // d
	private float[] r3 = { 155.6f, 311.1f, 622.3f }; // eb

	private float[] g1 = { 146.8f, 293.7f, 587.3f }; // d
	private float[] g2 = { 155.6f, 311.1f, 622.3f }; // eb
	private float[] g3 = { 164.8f, 329.6f, 659.3f }; // e

	private float[] m1 = { 174.6f, 349.2f, 698.5f }; // f
	private float[] m2 = { 185.0f, 370.0f, 740.0f }; // f#

	private float[] p = { 196.0f, 392f, 784f }; // g

	private float[] d1 = { 207.7f, 415.3f, 830.6f }; // g#
	private float[] d2 = { 220.0f, 440.0f, 880.0f }; // a

	private float[] n1 = { 220.0f, 440.0f, 880.0f }; // a
	private float[] n2 = { 233.1f, 466.2f, 932.3f }; // bb
	private float[] n3 = { 246.9f, 493.9f, 987.8f }; // b

	private float[] x = { 0f, 0f, 0f }; // dummy when raga's have gaps in their notes
										
	// Ragas
	private String[] mayamalavagaula = { "s", "r1", "g3", "m1", "p", "d1", "n3" };
	private String[] shankarabharana = { "s", "r2", "g3", "m1", "p", "d1", "n3" };
	private String[] mrugendramadhyama = { "s", "r3", "x", "m1", "x", "d1", "n2" };

	HashMap<String, String[]> ragaNoteList = new HashMap<String, String[]>();
	HashMap<String, float[]> noteFreqList = new HashMap<String, float[]>();

	public RagaList() {

		setRagaList();
		setNoteList();

	}

	public String[] getRagaNotes(String ragaName) {

		return ragaNoteList.get(ragaName);

	}

	public float getNoteFreq (String noteName, int octave) {

		return noteFreqList.get(noteName)[octave];

	}

	private void setRagaList() {
		ragaNoteList.put("mayamalavagaula", mayamalavagaula);
		ragaNoteList.put("shankarabharana", shankarabharana);
		ragaNoteList.put("mrugendramadhyama", mrugendramadhyama);
	}

	private void setNoteList() {
		noteFreqList.put("s", s);
		noteFreqList.put("r1", r1);
		noteFreqList.put("r2", r2);
		noteFreqList.put("r3", r3);
		noteFreqList.put("g1", g1);
		noteFreqList.put("g2", g2);
		noteFreqList.put("g3", g3);
		noteFreqList.put("m1", m1);
		noteFreqList.put("m2", m2);
		noteFreqList.put("p", p);
		noteFreqList.put("d1", d1);
		noteFreqList.put("d2", d2);
		noteFreqList.put("n1", n1);
		noteFreqList.put("n2", n2);
		noteFreqList.put("n3", n3);
		noteFreqList.put("x", x);
	}

}
