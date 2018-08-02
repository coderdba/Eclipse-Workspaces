package com.gm.music;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;

public class Ragas {
										
	// Ragas
	private String[] mayamalavagaula = { "s", "r1", "g3", "m1", "p", "d1", "n3" };
	private String[] shankarabharana = { "s", "r2", "g3", "m1", "p", "d1", "n3" };
	private String[] mrugendramadhyama = { "s", "r3", "x", "m1", "x", "d1", "n2" };

	HashMap<String, String[]> ragaNoteList = new HashMap<String, String[]>();
	HashMap<String, float[]> noteFreqList = new HashMap<String, float[]>();

	public Ragas() {

		setRagaList();
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

}
