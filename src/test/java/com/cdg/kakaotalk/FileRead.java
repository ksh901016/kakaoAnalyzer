package com.cdg.kakaotalk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class FileRead {
	
	//문자기반 스트림
	private BufferedReader bis;
	private StringTokenizer st;
	private String[] content;
	private String[] name;
	
	@Before
	public void setup() throws FileNotFoundException{
		bis = new BufferedReader(new FileReader("./resources/KaKaoTalkChats.txt"));
	}
	
	@Test
	public void testRead() throws IOException{
	}
	
	@Test
	public void testToken() throws IOException{
		content = bis.readLine().split(",");
		for(int i=0; i<content.length; i++){
			System.out.println(i);
			System.out.println(content[i]);
		}
		content = bis.readLine().split(",");
		for(int i=0; i<content.length; i++){
			System.out.println(i);
			System.out.println(content[i]);
		}
		name = content[1].split(":");
		for(String a : name)
			System.out.println(a);
		name[0]=name[0].trim();
		System.out.println(name[0]);
		name[1]=name[1].trim();
		System.out.println(name[1]);
		System.out.println(content[0].substring(13, 17));
	}

}
