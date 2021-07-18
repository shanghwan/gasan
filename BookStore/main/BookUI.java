package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.domin.UserVO;

public class BookUI {
	
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		UserVO vo = new UserVO();
		List<UserVO> list = new ArrayList<UserVO>();
		
		String user_id = "";
		String pwd = "";
		String userName = "";
		int error = 0;
				
		while (true) {
			
			if(list.isEmpty()) {
				System.out.println("********회원가입********");
				System.out.print("아이디를 입력하세요:");
				vo.setUser_id(user_id= scan.next());
				System.out.print("비밀번호를 입력하세요:");
				vo.setPwd(pwd = scan.next());
				System.out.print("이름을 입력하세요:");
				vo.setUserName(userName = scan.next());
				list.add(vo);
			}
		
			
			/* BookStore\exam01\ex1.PNG 이지미 참고!! 
			 * 1.로그인
			 * 2.아이디 , 비밀번호 실패 시 error카운트 1씩 증가
			 * 3. error 카운트 5이상일 경우 비밀번호 초기화 세팅
			 * 4. 변경 된 비밀번호로 로그인 성공
			 * 4-1 로그인 성공 시 {이름}님 환영합니다 후 break;
			 * 5.자유주제 선정하여 개발하기!
			 * */
			
			
			
			
			
		}
	}

}
