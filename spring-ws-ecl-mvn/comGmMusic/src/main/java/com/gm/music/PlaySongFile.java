package com.gm.music;

import java.util.List;

public class PlaySongFile {

	public static void main(String[] args) throws Exception {
		
		String fileName;
		//fileName = "devadeva.txt";
		fileName = "sarimagari.txt";
		//fileName = "devadevadeethijaliline.txt";
		
		SongFileReaderPlayer songFileReaderPlayer = new SongFileReaderPlayer(fileName, "mayamalavagaula");
		
		songFileReaderPlayer.playSong();
	}
	
}