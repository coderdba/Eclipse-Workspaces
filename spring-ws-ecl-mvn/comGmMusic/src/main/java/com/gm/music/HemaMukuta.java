package com.gm.music;

public class HemaMukuta {
	
	static String raga = "mrugendramadhyama";

	public static void main(String[] args) throws Exception {
		
		RagaList ragaList= new RagaList();
		
		String[] ragaNoteList = ragaList.getRagaNotes(raga);
		
		String S = ragaNoteList[0];
		String R = ragaNoteList[1];
		String G = ragaNoteList[2];
		String M = ragaNoteList[3];
		String P = ragaNoteList[4];
		String D = ragaNoteList[5];
		String N = ragaNoteList[6];
		
		float s = ragaList.getNoteFreq(S, 1);
		float r = ragaList.getNoteFreq(R, 1);
		float g = ragaList.getNoteFreq(G, 1);
		float m = ragaList.getNoteFreq(M, 1);
		float p = ragaList.getNoteFreq(P, 1);
		float d = ragaList.getNoteFreq(D, 1);
		float n = ragaList.getNoteFreq(N, 1);
		float n0 = ragaList.getNoteFreq(N, 0);
		
		Tones myTone = new Tones();
		
		System.out.println ("The class is " + myTone.getClass().getName());
		System.out.println (myTone.toString());
		
		//myTone.playOneNoteOneSecond(100, 150);    
		
        System.out.println("Playing now");
        
        /*
		float[][] songLine2 = { 
				 {s, 0.5f}, {r, 0.5f}, {m, 1.0f}, {g, 0.5f}, {r, 0.5f},
				{s, 0.5f}, {r, 0.5f}, {g, 0.5f}, {r, 0.5f}, {s, 1.0f},
				{r, 0.5f}, {m, 0.5f}, {p, 0.5f}, {d, 0.5f}, {m, 0.5f}, {p, 0.5f},
				{d, 0.5f}, {p, 0.5f}, {m, 0.5f}, {g, 0.5f}, {r, 0.5f}, {s, 0.5f},
				{s, 0.5f}, {r, 0.5f}, {m, 1.0f}, {g, 0.5f}, {r, 0.5f}
				,{s, 0.5f}, {r, 0.5f}, {g, 0.5f}, {r, 0.5f}, {s, 1.0f}};
		*/

       float[][] songLine1 = {
    		   {d, 0.7f}, {d, 0.35f}, {m, 0.35f}, {r, 0.35f}, {s, 0.35f}, 
    		   {s, 0.35f}, {r, 0.35f}, {m, 0.7f}, {m, 0.35f}, {r, 0.35f}, {s, 0.7f},
    		   {s, 0.35f}, {n0, 0.35f}, {s, 0.7f}	   
       };
       
       myTone.playNoteList(songLine1, 70);
		
	}


}