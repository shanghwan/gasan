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
		//String pwd2 = "";
		String userName = "";
		int error = 0;

		
		System.out.println("환영합니다 : ");
		System.out.println("회원이시면 1, 아니면 0 를 적어주세요.");
		int account=scan.nextInt();
		
		if(account ==0) {
			while (true) {

			if (list.isEmpty()) {
				System.out.println("********회원가입********");
				System.out.print("아이디를 입력하세요:");
				vo.setUser_id(user_id = scan.next());
				System.out.print("비밀번호를 입력하세요:");
				vo.setPwd(pwd = scan.next());
				System.out.print("이름을 입력하세요:");
				vo.setUserName(userName = scan.next());
				System.out.println("회원가입이 완료되었습니다.");
				list.add(vo);
			}
		while(true) {
			if(!list.isEmpty()) {
				System.out.println("********로그인********");
				System.out.print("로그인 아이디를 입력하세요:");
				String id_input = scan.next();
		
					//if(list.contains(id_input)){
						System.out.println("로그인 비밀번호를 입력하세요:");
						String pwd_input = scan.next();
						if(id_input.equals(vo.getUser_id()) && pwd.equals("pwd_input")) {
							System.out.println("일치합니다. 회원가입이 완료되었습니다.");
							break;
						}else {
							System.out.println("일치하지 않습니다. 다시 시도하여 주세요.");
							error++;
						}
						if(error >=5 ) {
							System.out.println("5회 오류로 비밀번호를 초기화 합니다.");
							pwd = "";
							
						}}}}}}}
				
//				
//			if(vo.getUser_id() ==null ) {
//				System.out.println("회원가입 먼저 해주세요.");
//			}
//			if(vo.getUser_id().equals(user_id)) {
//				if(vo.getPwd().equals(pwd)) {
//					System.out.println("로그인성공하였습니다.");
//					String name = vo.getUserName();
//					System.out.println("{" + name + "}" + "님 환영합니다 ");
//					break;
//				}else {
//					System.out.println("로그인에 실파였습니다. 에러1추가");
//					error++;
//				}
//			if(error >=5 ) {
//				pwd = "";
//			}
			
			/*
			 * BookStore\exam01\ex1.PNG 이지미 참고!! 1.로그인 2.아이디 , 비밀번호 실패 시 error카운트 1씩 증가
			 * 3.error 카운트 5이상일 경우 비밀번호 초기화 세팅 4. 변경 된 비밀번호로 로그인 성공 4-1 로그인 성공 시 {이름}님 환영합니다
			 * 후 break; 5.자유주제 선정하여 개발하기!
			 */



