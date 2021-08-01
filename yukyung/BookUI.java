package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookUI {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<UserVO> list = new ArrayList<UserVO>();
		
		String user_id = "";
		String pwd = "";
		String userName = "";
		
		while(true) {
		System.out.println("********로그인********");
		System.out.print("로그인 아이디를 입력하세요:");
		user_id = scan.next();
		System.out.print("로그인 비밀번호를 입력하세요:");
		pwd = scan.next();
		
		if(user_id.equals("admin") && (pwd.equals("1234"))) {

			System.out.println("********로그인 성공********");
			System.out.println(user_id + "님 환영합니다.");
			
			while(true) {	
		System.out.println("********회원관리********");
		System.out.println("      1.회원등록");
		System.out.println("      2.회원검색");
		System.out.println("      3.회원수정");
		System.out.println("      4.회원삭제");
		System.out.println("      5.로그아웃");
		System.out.println("***********************");
		
		
	
		int input = scan.nextInt();
			switch(input) {

				
				
			case 1:
				
				
				System.out.println("<1.회원등록>");
				
				UserVO member = new UserVO(userName, user_id, pwd);
				
				
				System.out.print("이름을 입력하세요:");
				member.setUserName(userName = scan.next());
				
				/*System.out.print("아이디를 입력하세요:");
				user_id = scan.next();
				for(int k=0; k<list.size(); k++){
				if(list.equals(user_id)) {
					System.out.println(list.equals(user_id));
					System.out.println("이미 사용중인 아이디입니다.");
					System.out.println("아이디를 입력하세요:");
					continue;
					}
					else{member.setUser_id(user_id = scan.next());}}
			*/
				System.out.print("이름을 입력하세요:");
				member.setUser_id(user_id = scan.next());
				
				System.out.print("비밀번호를 입력하세요:");
				member.setPwd(pwd = scan.next());
				
				
				list.add(member);
				System.out.println(member);
				System.out.println("등록이 완료되었습니다.");
					 
				break;
			
			case 2:
				System.out.println("<2.회원검색>");
				System.out.println("1.전체 검색  2.아이디로 검색  3.이름으로 검색");
				int search = scan.nextInt();
				
				if (search == 1) {
					if(list.size() == 0) {
						System.out.println("존재하지 않습니다.");
						break;
					} else {
					for(int k=0; k<list.size(); k++){
						member = list.get(k);
					System.out.println("이름" + member.getUserName());
					System.out.println("아이디"+ member.getUser_id());
					System.out.println("비밀번호" + member.getPwd());
					} 
					
					break;
				}}
				else if (search == 2) {
					
					System.out.print("아이디를 입력하세요:");
					user_id = scan.next();
					if(list.size() == 0) {
						System.out.println("존재하지 않습니다.");
						
					} else {
					for(int k=0; k<list.size(); k++){
						member = list.get(k);
						 if(user_id.equals(member.getUser_id())) {
						System.out.println("이름" + member.getUserName());
						System.out.println("아이디"+ member.getUser_id());
						System.out.println("비밀번호" + member.getPwd());
					}}}
					break;}
				else if (search == 3) {
					System.out.print("이름을 입력하세요:");
					userName = scan.next();
					if(list.size() == 0) {
						System.out.println("존재하지 않습니다.");
						
					} else {
					for(int k=0; k<list.size(); k++){
						member = list.get(k);
						 if(userName.equals(member.getUserName())) {
						System.out.println("이름" + member.getUserName());
						System.out.println("아이디"+ member.getUser_id());
						System.out.println("비밀번호" + member.getPwd());
					}}}break;}
				
			case 3:
				System.out.println("<3.회원수정>");
				System.out.println("1.아이디로 검색  2.이름으로 검색");
				int modify = scan.nextInt();
				if (modify == 1) {
					
					System.out.print("아이디를 입력하세요:");
					user_id = scan.next();
					for(int k=0; k<list.size(); k++){
						member = list.get(k);
						 if(user_id.equals(member.getUser_id())) {
						System.out.println("이름" + member.getUserName());
						System.out.println("아이디"+ member.getUser_id());
						System.out.println("비밀번호" + member.getPwd());
						System.out.println("수정 할 비밀번호를 입력하세요");
						member.setPwd(scan.next());
						System.out.println("수정이 완료되었습니다.");
						System.out.println("이름" + member.getUserName());
						System.out.println("아이디"+ member.getUser_id());
						System.out.println("비밀번호" + member.getPwd());
						
					}else{System.out.println("일치하는 정보가 없습니다.");}}break;}
					
					if (modify == 2) {
						
						System.out.print("이름을 입력하세요:");
						userName = scan.next();
						for(int k=0; k<list.size(); k++){
							member = list.get(k);
							 if(userName.equals(member.getUserName())) {
							System.out.println("이름" + member.getUserName());
							System.out.println("아이디"+ member.getUser_id());
							System.out.println("비밀번호" + member.getPwd());
							System.out.println("수정 할 비밀번호를 입력하세요");
							member.setPwd(scan.next());
							System.out.println("수정이 완료되었습니다.");
							System.out.println("이름" + member.getUserName());
							System.out.println("아이디"+ member.getUser_id());
							System.out.println("비밀번호" + member.getPwd());
							
						}else{System.out.println("일치하는 정보가 없습니다.");}}break;}
				
			case 4:
				System.out.println("<4.회원삭제>");
				System.out.println("1.아이디로 검색  2.이름으로 검색");
				int delete = scan.nextInt();
				
				if (delete == 1) {
					System.out.print("아이디를 입력하세요:");
					user_id = scan.next();
					for(int k=0; k<list.size(); k++){
						member = list.get(k);
						 if(user_id.equals(member.getUser_id())) {
						System.out.println("이름" + member.getUserName());
						System.out.println("아이디"+ member.getUser_id());
						System.out.println("비밀번호" + member.getPwd());
						System.out.println("정말 삭제하시겠습니까? 1.Y 2.N");
						int answer = scan.nextInt();
						if(answer == 1) {
							list.remove(k);
						System.out.println("삭제가 완료되었습니다.");}
						else if(answer == 2) {return;}}
						 else {System.out.println("일치하는 회원 정보가 없습니다.");}}}
						 
						 
						 else if (delete == 2) {
								System.out.print("이름 입력하세요:");
								userName = scan.next();
								for(int k=0; k<list.size(); k++){
									member = list.get(k);
									 if(userName.equals(member.getUserName())) {
									System.out.println("이름" + member.getUserName());
									System.out.println("아이디"+ member.getUser_id());
									System.out.println("비밀번호" + member.getPwd());
									System.out.println("정말 삭제하시겠습니까? 1.Y 2.N");
									int answer = scan.nextInt();
									if(answer == 1) {
										list.remove(k);
									System.out.println("삭제가 완료되었습니다.");}
									else if(answer == 2) {return;}}
									 else {System.out.println("일치하는 회원 정보가 없습니다.");
									 }}break;}
									 
	}if(input == 5) {
		System.out.println("<5.로그아웃>");
	user_id = null;
	pwd = null;
		System.out.println("로그아웃이 완료되었습니다.");
	
	break;}}	} else { System.out.println("로그인에 실패하였습니다.");}
		
		}}}
