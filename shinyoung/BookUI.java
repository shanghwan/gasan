package shinyoung;

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
			while (true) {
				System.out.println("********로그인********");
				System.out.print("로그인 아이디를 입력하세요:");
				String id_input = scan.next();

				// if(list ){
				System.out.println("로그인 비밀번호를 입력하세요:");
				String pwd_input = scan.next();

				if (id_input.equals(vo.getUser_id()) && pwd_input.equals(vo.getPwd())) {
					System.out.println("일치합니다. 로그인에 성공하였습니다.");
					System.out.println(vo.getUserName() + "님 환영합니다.");

					break;
				} else {
					System.out.println("일치하지 않습니다. 다시 시도하여 주세요.");
					error++;
					System.out.println(error + "번째 로그인 실패");
				}
				if (error >= 5) {
					System.out.println("5회 실패로 로그인을 할 수 없습니다. \n 비밀번호 초기화를 진행하시겠습니까? Y : 1 N : 2");
					String str = scan.nextLine();

					if (str.equals("1")) {
						System.out.println("********비밀번호변경********");
						System.out.print("변경할 비밀번호를 입력하세요:");
						vo.setPwd(pwd = scan.next());
					} else {
						break;
					}

				}
			}
			break;

		}
	}
}

/*
 * BookStore\exam01\ex1.PNG 이지미 참고!! 1.로그인 2.아이디 , 비밀번호 실패 시 error카운트 1씩 증가 3.
 * error 카운트 5이상일 경우 비밀번호 초기화 세팅 4. 변경 된 비밀번호로 로그인 성공 4-1 로그인 성공 시 {이름}님 환영합니다 후
 * break; 5.자유주제 선정하여 개발하기!
 */
