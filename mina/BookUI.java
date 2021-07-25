package mina;

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
				list.add(vo);

				System.out.println("********로그인********");
				System.out.print("아이디 : ");
				user_id = scan.next();
				System.out.print("비밀번호 : ");
				pwd = scan.next();

			} else if (!pwd.equals(vo.getPwd()) || !user_id.equals(vo.getUser_id())) {

				error++;
				System.out.println("아이디 혹은 비밀번호 불일치. 다시 로그인 하세요.");

				System.out.println("********로그인 " + error + "회 재시도********");
				System.out.print("아이디 : ");
				user_id = scan.next();
				System.out.print("비밀번호 : ");
				pwd = scan.next();

				continue;

			} else if (error == 5) {
				System.out.println("비밀번호를 5회이상 틀리셨습니다.");
				System.out.println("비밀번호 초기화를 진행하시겠습니까? Y:1 N:2");

				int choice = scan.nextInt();
				if (choice == 1) {
					System.out.println("새로운 비밀번호를 입력하세요");
					vo.setPwd(scan.next());
				} else {
					break;
				}

			} else {
				System.out.println(userName + "님 환영합니다.");
				break;
			}
		}
	}
}