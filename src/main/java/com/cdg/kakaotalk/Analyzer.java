package com.cdg.kakaotalk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {

	private List<User> Users = new ArrayList();
	private BufferedReader bis;
	private String[] line1; // line[0] 시간정보, line[1] 이름 , 대화내역
	private String line;
	private String name;
	private String content;
	private String fulltime;
	private String[] split; // 임시저장
	private Map<Integer, Integer> AM = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> PM = new HashMap<Integer, Integer>();

	public Analyzer(String file) throws IOException {

		// 파일 열기
		bis = new BufferedReader(new FileReader(file));
		bis.readLine(); // 초대메시지 1줄 미리읽기
		int number = 0;
		// 해쉬맵 초기화
		initTimeMap();

		// 파일 한줄씩 읽기
		while ((line = bis.readLine()) != null) {
			
			line1 = line.split(",");
			getInform(line1); // user 이름과 내용 ,시간 저장
			User user = checkUser(name); // user 객체 존재시 그 user객체 반환, 없으면 생성
			Users.add(user);
			user.saveInform(content); // 내용 저장
			getTime(fulltime); // 시간 저장
			number++;
			System.out.println(number);
		}
		getPeektime(AM, PM);

	}

	// user 이름과 내용, 시간 저장
	private void getInform(String[] line1) {
		
			split = line1[1].split(":");
			name = split[0].trim(); // 여백제거 이름 저장
			content = split[1].trim(); // 여백제거 내용 저장
			fulltime = line1[0].substring(13, 17); // 시간 저장 오후 6, 오전 7 이런식으로
	}

	private User checkUser(String name) {
		if (!Users.equals(null)) {
			for (User user : Users) {
				if (user.getName().equals(name)) {
					return user;
				}
			}
		}
		User user = new User();
		user.setName(name);
		return user;

	}

	private void getTime(String fulltime) {

		String[] time = fulltime.split(" ");
		int hour = Integer.parseInt(time[1]);
		if (time[0].equals("오후")) {
			PM.put(hour, (PM.get(hour)) + 1);
		} else if (time[0].equals("오전")) {
			AM.put(hour, (PM.get(hour)) + 1);
		}

	}

	private void initTimeMap() {
		for (int i = 1; i < 13; i++) {
			AM.put(i, 0);
			PM.put(i, 0);
		}
	}

	private String getPeektime(Map<Integer, Integer> AM, Map<Integer, Integer> PM) {
		int best = 0;
		String time="";
		int hour = 0;
		for (int i = 1; i < 13; i++) {
			if (AM.get(i) > best) {
				best = AM.get(i);
				hour =i;
				time = "오전";
			}
		}
		for (int j = 1; j < 13; j++) {
			if(PM.get(j)>best){
				best = PM.get(j);
				hour = j;
				time = "오후";
			}
			
		}
		return time +hour;
	}
}
