package com.gm.music;

import com.gm.music.NotesList;

public class Tone1Play {
	
	static float s2  = NotesList.s2;
	static float r21 = NotesList.r12;
	static float g23 = NotesList.g32;
	static float m21 = NotesList.m12;
	static float p2  = NotesList.p2;
	static float d21 = NotesList.d12;
	static float n23 = NotesList.n32;
	static float s3  = NotesList.s3;
	
	public static void main(String[] args) throws Exception {
		
		Tone1 myTone = new Tone1();
		
		System.out.println(myTone.toString());
		
		//myTone.playOneNoteOneSecond(100, 150);
		
		int[] songLine1 = {261,277,329,349,392,415,494,523};
		//myTone.playNoteListOneSecond(songLine1, 100);
		//myTone.playNoteList(songLine1, 100, 0.5f);
		
		//float[][] songLine2 = { {261f, 0.5f}, {277f, 0.5f}, {329f, 0.5f}, {349f, 0.5f} };
		//myTone.playNoteList(songLine2, 100);
		
		//float[][] songLine3 = { {s2, 0.5f}, {r21, 0.5f}, {g23, 0.5f}, {m21, 0.5f}, {p2, 0.5f}, 
									//{d21, 0.5f}, {n23, 0.5f}, {s3, 0.5f}};
		
		//myTone.playNoteList(songLine3, 100);
		
		
		float[][] songLine4 = { 
				 {s2, 0.5f}, {r21, 0.5f}, {m21, 1.0f}, {g23, 0.5f}, {r21, 0.5f},
				{s2, 0.5f}, {r21, 0.5f}, {g23, 0.5f}, {r21, 0.5f}, {s2, 1.0f},
				{r21, 0.5f}, {m21, 0.5f}, {p2, 0.5f}, {d21, 0.5f}, {m21, 0.5f}, {p2, 0.5f},
				{d21, 0.5f}, {p2, 0.5f}, {m21, 0.5f}, {g23, 0.5f}, {r21, 0.5f}, {s2, 0.5f},
				{s2, 0.5f}, {r21, 0.5f}, {m21, 1.0f}, {g23, 0.5f}, {r21, 0.5f}
				,{s2, 0.5f}, {r21, 0.5f}, {g23, 0.5f}, {r21, 0.5f}, {s2, 1.0f}};
				
		
		//float[][] songLine4 = {{s2, 0.5f}};
		
		System.out.println(songLine4.toString());
        myTone.playNoteList(songLine4, 100);
		
	}


}
