package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	private String name;
	private List<String> contents = new ArrayList<String>();
	private List<Integer> count = new ArrayList<Integer>();
	private String[] frequentWord = new String[5];
	private Analyzer ana = new Analyzer();
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public String getName() {
		return name;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public void setName(String name) {
		this.name = name;
	}



	public void saveInform(String content) {
		String[] word = content.split(" ");

		for (int i = 0; i < word.length; i++) {
			if (map.containsKey(word[i])) {
				int num = map.get(word[i]);
				map.replace(word[i], num + 1);
			} else {
				map.put(word[i], 1);
			}
		}
	}

	


	@Override
	public String toString() {
		return "User :"+name;
	}

}
