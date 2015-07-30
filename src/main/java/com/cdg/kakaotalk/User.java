package com.cdg.kakaotalk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
	private String name;
	private List<String> contents = new ArrayList<String>();
	private List<Integer> count = new ArrayList<Integer>();
	private String[] frequentWord = new String[5];
	private Analyzer ana = new Analyzer();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void saveInform(String content) {
		if (contents.size() > 200)
			ana.modifyList(contents, count);

		if (contents.contains(content)) {
			int index = contents.indexOf(content);
			count.add(index, count.get(index) + 1);
		} else {
			contents.add(content);
			count.add(1);
		}

	}

	public void getFrequentWord() {
		int index = 0;
		for (int i = 0; i < 5; i++) {
			int max = 0;
			for (int j = 0; j < count.size(); j++) {
				if (count.get(j) > max) {
					index = j;
					max = count.get(j);
					frequentWord[i] = contents.get(j);
				}
			}
			count.remove(index);
			contents.remove(index);
		}
	}

	public void printWord() {
		getFrequentWord();
		System.out.println("가장 많이 사용한 단어");
		for (String word : frequentWord) {
			System.out.println(word);
		}
	}

	@Override
	public String toString() {
		return name;
	}

}
