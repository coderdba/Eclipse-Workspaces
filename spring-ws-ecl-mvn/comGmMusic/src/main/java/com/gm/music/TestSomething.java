package com.gm.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestSomething {
	
	public static void main(String[] args) throws Exception {
		
		RagaList ragaList= new RagaList();
		System.out.println(ragaList.getRagaNotes("mayamalavagaula")[1]);
		System.out.println(ragaList.getRagaNotes("shankarabharana")[1]);
	}

}
