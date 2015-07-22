package com.cdg.kakaotalk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Analyzer {
	
	private BufferedReader bis;
	private String[] line1; //line[0] 시간정보, line[1] 이름 , 대화내역
	private String line;
	
	private String name;
	private String content;
	private String time;
	private String[] split; //임시저장
	
	
	public Analyzer(String file) throws IOException{
		
		//파일 열기
		try {
			bis = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일의 경로를 확인해주세요.");
		}
		
		bis.readLine(); //초대메시지 1줄 미리읽기
		
		//파일 한줄씩 읽기
		try {
			while((line=bis.readLine())!=null){
			line1 = line.split(",");	
			getInform(line1);
				
			System.out.println("hihi");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일이 안 읽혀지는 이유");
		}
	}

	//user 이름과 내용, 시간 저장
	private void getInform(String[] line1) {
		
		split = line1[1].split(":");
		name = split[0].trim();	//여백제거 이름 저장
		content = split[1].trim(); //여백제거 내용 저장
		time = line1[0].substring(13, 17); //시간 저장 오후 6, 오전 7 이런식으로
				
		
	}


}
