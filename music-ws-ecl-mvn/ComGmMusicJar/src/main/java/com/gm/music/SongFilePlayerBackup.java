package com.gm.music;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;

public class SongFilePlayerBackup {
	
	private File      infile;
	private Player    player;
	private String    raga;
	
	// these three can be derived from player above
    //private Ragas     ragas;
	//private Notes     notes;
	//private String[]  ragaNotes;

    // constructors
	public SongFilePlayerBackup(String filePath, String raga) {
		
		this.infile = new File(filePath);
		this.player = new Player();
		this.raga   = raga;	
	}
	
	// methods
	public void playSong() throws Exception {
		
		List<String[]> songStreamArray;
		songStreamArray = this.getSongStreamArray();
				
		// is it better to make this a class-attribute?
		//Tone toneToPlay = new Tone();
		
		for (int i=0; i < songStreamArray.size(); i++) {
			
			String[] arrayElement = songStreamArray.get(i);
			
			float freq =  player.getNotes().getNoteFreq(arrayElement[0], Integer.parseInt(arrayElement[1]));
			
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
		
			player.playOneNote(freq, 100, lengthSeconds);
							
		}
	}
	
	// Creates a map-stream of note-octave-length elements from the input file
		public List<String[]> getSongStreamArray() throws Exception {

			Scanner infileScanner = new Scanner(infile);
			List<String> elements = new ArrayList<String>();

			// this will be returned
			List<String[]> songStreamArray = new ArrayList<String[]>();
			
			// comma delimiter to scan the file
			infileScanner.useDelimiter(",\\s*");
			
			// other stuff required for this method
			HashMap<String, Integer> notesIndex = player.getNotes().getNotesIndex();
					
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
				
				// each element is note-octave pair and length (like s or s.2 or s0.1 etc)
				String element = elements.get(i);
				
				//System.out.println("Element " + element);
				
				String[] splitString = element.split("\\.");
				
				noteAndOctave = splitString[0]; // note and octave composite string - like s0 is s and 0
				String[] splitNoteAndOctave = noteAndOctave.split("");
				
				note = splitNoteAndOctave[0];
				
				// octave is optional, so set default if not set
				if (splitNoteAndOctave.length > 1) {
					octave = splitNoteAndOctave[1];
				}
				else {
					octave = "1";
				}
				
				// length is optional, so set default if not set
				if (splitString.length > 1) {
					
				    length = splitString[1];
				}
				else {
					length = "1"; 
				}
				
				// get the real note specific for the raga
				//HashMap notesIndex = notes.getNotesIndex();
				
				////HashMap notesIndex = player.getNotes().getNotesIndex();
				
				//System.out.println("Notes Index size in SongPlayer is " + notesIndex.size());
				//System.out.println("Current note in SongPlayer is " + note);
				//System.out.println("Its index is " + notesIndex.get(note).toString());
				//System.out.println("Class of the index is " + notesIndex.get(note).getClass());
				
				int index = notesIndex.get(note);
				
				//String realNote = ragaNotes[index];
				String realNote = player.getRagas().getRagaNotes(raga)[index];
				System.out.println("Current note in SongPlayer is " + note + ", real note: " + realNote);

				// add the real-note, octave and length to array
				String[] arrayElement = {realNote,octave,length};	
				songStreamArray.add(arrayElement);	
			}
			
			return songStreamArray;
		}
	
	
	// return 'List' object of individual letters in the file
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
				
				/* old code
				//String realNote = ragaNotes[notesIndex.get(note)];
				//songStream.add(realNote);
				 */
				
				// get the real note specific for the raga
				//HashMap notesIndex = notes.getNotesIndex();
				HashMap notesIndex = player.getNotes().getNotesIndex();
				
				int index = Integer.getInteger(notesIndex.get(note).toString());
				
				//String realNote = ragaNotes[index];
				String realNote = player.getRagas().getRagaNotes(raga)[index];
				
				
				songStream.add(realNote);
				songStream.add(octave);				
				songStream.add(length);

				//System.out.println("Note: " + note + " Length: " + length);
				
			}
			
			return songStream;
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
}