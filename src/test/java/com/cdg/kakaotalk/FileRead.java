package com.cdg.kakaotalk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileRead {
	
	//문자기반 스트림
	private BufferedReader bis;
	
	@Before
	public void setup() throws FileNotFoundException{
		bis = new BufferedReader(new FileReader("./resources/KaKaoTalkChats.txt"));
	}
	
	@Test
	public void testRead() throws IOException{
		System.out.println(bis.readLine());
		System.out.println(bis.readLine());
	}

}
