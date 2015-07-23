package com.cdg.kakaotalk;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String name;
	private Map<String, Integer> contentList = new HashMap<String, Integer>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void saveInform(String content) {
		if (contentList.containsKey(content)) {
			contentList.put(content, (contentList.get(content) + 1));
		} else {
			contentList.put(content, 0);
		}
	}

}
