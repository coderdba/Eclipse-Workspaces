package com.gm.music;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import java.util.ArrayList;

public class SongFileReaderPlayer {
	
	private File infile;
	private RagaList ragaList;
	private String[] ragaNotes;
	private HashMap<String, Integer> notesIndex;

	public SongFileReaderPlayer(String filePath, String raga) {
		
		this.ragaList = new RagaList();
		this.infile = new File (filePath);
		this.ragaNotes = ragaList.getRagaNotes(raga);
		this.notesIndex = new HashMap<String, Integer>();
		
		setNotesIndex();
		
	}
	
	private void setNotesIndex() {
		
		notesIndex.put("s", 0);
		notesIndex.put("r", 1);
		notesIndex.put("g", 2);
		notesIndex.put("m", 3);
		notesIndex.put("p", 4);
		notesIndex.put("d", 5);
		notesIndex.put("n", 6);
	}

	// https://stackoverflow.com/questions/19844649/java-read-file-and-store-text-in-an-array
	public List<String> getElements()  throws Exception {

		Scanner infileScanner = new Scanner(infile);
		List<String> elements = new ArrayList<String>();
		
		// comma delimiter
		infileScanner.useDelimiter(",\\s*");
		
	    while (infileScanner.hasNext()) {
	    	
	        // find next line
	        String token = infileScanner.next();
	        elements.add(token);
	      }
	    
	    infileScanner.close();
	    
	    return elements; 
	}
	
	// Creates a map-stream of note-octave-length elements from the input file
		public List<String[]> getSongStreamArray() throws Exception {

			Scanner infileScanner = new Scanner(infile);
			List<String> elements = new ArrayList<String>();
			RagaList ragaList = new RagaList();

			// this will be returned
			List<String[]> songStreamArray = new ArrayList<String[]>();
			
			// comma delimiter
			infileScanner.useDelimiter(",\\s*");
					
		    while (infileScanner.hasNext()) {
		    	
		        // find next line
		        String token = infileScanner.next();
		        elements.add(token);
		      }
		    
		    infileScanner.close();
		    
		    // Now, place the elements into note-octave-speed elements		
			//System.out.println("List of elements " + elements.toString());
		    int elementsCount = elements.size();

			for (int i=0; i<elementsCount; i++) {
				
			    String noteAndOctave;
				String note;
				String octave;
				String length;
				
				// note-octave, length
				
				String element = elements.get(i);
				
				//System.out.println("Element " + element);
				
				String[] splitString = element.split("\\.");
				
				noteAndOctave = splitString[0]; // note and octave composite string - like s0 is s and 0
				String[] splitNoteAndOctave = noteAndOctave.split("");
				
				note = splitNoteAndOctave[0];
				
				if (splitNoteAndOctave.length > 1) {
					octave = splitNoteAndOctave[1];
				}
				else {
					octave = "1";
				}
				
				if (splitString.length > 1) {
					
				    length = splitString[1];
				}
				else {
					length = "1"; 
				}
				
				// get the real note specific for the raga
				String realNote = ragaNotes[notesIndex.get(note)];
				
				// add the real-note, octave and length to array
				String[] arrayElement = {realNote,octave,length};	
				songStreamArray.add(arrayElement);	
			}
			
			return songStreamArray;
		}
	
	
	// return song of individual letters in the file
	public List<String> getSongStream() throws Exception {

			Scanner infileScanner = new Scanner(infile);
			List<String> elements = new ArrayList<String>();
			List<String> songStream = new ArrayList<String>();
			
			// comma delimiter
			infileScanner.useDelimiter(",\\s*");
					
		    while (infileScanner.hasNext()) {
		    	
		        // find next line
		        String token = infileScanner.next();
		        elements.add(token);
		      }
		    
		    infileScanner.close();
		    
		    // Now, place the elements into note-octave-speed elements		
			//System.out.println("List of elements " + elements.toString());
		    int elementsCount = elements.size();

			for (int i=0; i<elementsCount; i++) {
				
			    String noteAndOctave;
				String note;
				String octave;
				String length;
				
				// note-octave, length
				
				String element = elements.get(i);
				
				//System.out.println("Element " + element);
				
				String[] splitString = element.split("\\.");
				
				noteAndOctave = splitString[0]; // note and octave composite string - like s0 is s and 0
				String[] splitNoteAndOctave = noteAndOctave.split("");
				
				note = splitNoteAndOctave[0];
				
				if (splitNoteAndOctave.length > 1) {
					octave = splitNoteAndOctave[1];
				}
				else {
					octave = "1";
				}
				
				if (splitString.length > 1) {
					
				    length = splitString[1];
				}
				else {
					length = "1"; 
				}
				
						
				//songStream.add(note);
				
				// get the real note specific for the raga
				String realNote = ragaNotes[notesIndex.get(note)];
				songStream.add(realNote);
				
				songStream.add(octave);				
				songStream.add(length);

				//System.out.println("Note: " + note + " Length: " + length);
				
			}
			
			return songStream;
		}
		
		public void playSong() throws Exception {
			
			List<String[]> songStreamArray;
			songStreamArray = this.getSongStreamArray();
			
			Tone2 toneToPlay = new Tone2();
			
			for (int i=0; i < songStreamArray.size(); i++) {
				
				String[] arrayElement = songStreamArray.get(i);
				float freq =  ragaList.getNoteFreq(arrayElement[0], Integer.parseInt(arrayElement[1]));
				
				Integer lengthInt = Integer.parseInt(arrayElement[2]);
				float lengthSeconds = 0f;
				
				System.out.println(lengthInt);
				
				if (lengthInt < 0) {
					
					lengthSeconds = (float)((lengthInt * 0.4) * (lengthInt * 0.5));
				}
				else {
					lengthSeconds = (float)(lengthInt * 0.4);
				}
				
				//float lengthSeconds = (float) (Integer.parseInt(arrayElement[2]) * 0.4);
				
				System.out.println("freq: " + freq + "length Sec: " + lengthSeconds);
				toneToPlay.play(freq, 100, lengthSeconds);
			}
		}

}
