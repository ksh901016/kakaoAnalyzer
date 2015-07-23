package com.cdg.kakaotalk;

import java.util.List;

import org.junit.Test;

public class UserTest {

	private static User user = new User();
	private String name;
	private List<String> lists;
	
	
	@Test
	public void saveInform(String name, String content) {
		this.name = name;
		lists.add(content);
		
	}

}
