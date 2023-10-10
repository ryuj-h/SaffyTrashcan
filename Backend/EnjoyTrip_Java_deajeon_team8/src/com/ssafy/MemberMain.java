package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberMain {
	
	private BufferedReader in;

	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					login();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void registerMember() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.println("=== 회원 가입 ===");
		System.out.print("ID : ");
		memberDto.setUserId(in.readLine());
		System.out.print("PW : ");
		memberDto.setUserPass(in.readLine());
		System.out.print("Name : ");
		memberDto.setUserName(in.readLine());
		MemberDaoImpl.getBoardservice().registerMember(memberDto);
	}

	private void login() throws IOException {
		
	}

	private void modifyMember() throws IOException {
		
	}

	private void deleteMember() throws IOException {
		
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
