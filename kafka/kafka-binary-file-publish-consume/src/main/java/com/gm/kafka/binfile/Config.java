package com.gm.kafka.binfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Config {

	// read configuration from config file
	HashMap<String, String> conf;

	public Config(String filePath) throws FileNotFoundException, IOException {
		conf = new HashMap();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String[] vals;
		String line = br.readLine();

		while (line != null) {
			if (!line.startsWith("#")) {
				vals = line.toLowerCase().split("=");
				conf.put(vals[0], vals[1]);
			}
			line = br.readLine();
		}

	}

	public String get(String key) {
		return conf.get(key.toLowerCase());
	}
}
