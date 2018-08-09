package com.gm.music;

public class PlaySong {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Notes notesLocal = new Notes();
		//System.out.println("Printing note: " + notesLocal.getNotesIndex().get("s"));
		
		//SongFilePlayer songFilePlayer = new SongFilePlayer("sarimagari.txt", "mayamalavagaula");
		//SongFilePlayer songFilePlayer = new SongFilePlayer("sarimagari.txt");
		SongFilePlayer songFilePlayer = new SongFilePlayer("jaibharatajananiya.txt");
		
		songFilePlayer.playSong();

	}

}
