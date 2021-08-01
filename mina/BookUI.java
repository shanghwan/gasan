package mina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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

			System.out.println("*****Welcome BookStore*****");
			System.out.println("1.회원가입 2.로그인 3.회원탈퇴 0.종료");

			int menu = scan.nextInt();

			switch (menu) {

			case 1:

				System.out.println("********회원가입********");
				System.out.print("아이디를 입력하세요:");
				vo.setUser_id(user_id = scan.next());
				System.out.print("비밀번호를 입력하세요:");
				vo.setPwd(pwd = scan.next());
				System.out.print("이름을 입력하세요:");
				vo.setUserName(userName = scan.next());
				list.add(vo);
				System.out.println(userName + "님 가입을 축하드립니다.");

				break;

			case 2:

				System.out.println("********로그인********");
				System.out.print("아이디 : ");
				user_id = scan.next();
				System.out.print("비밀번호 : ");
				pwd = scan.next();

				if (!pwd.equals(vo.getPwd()) || !user_id.equals(vo.getUser_id())) {

					error++;
					System.out.println("아이디 혹은 비밀번호 불일치. 다시 로그인 하세요.");

					System.out.println("********로그인 " + error + "회 재시도********");
					System.out.print("아이디 : ");
					user_id = scan.next();
					System.out.print("비밀번호 : ");
					pwd = scan.next();

					if (error == 5) {
						System.out.println("비밀번호를 5회이상 틀리셨습니다.");
						System.out.println("비밀번호 초기화를 진행하시겠습니까? Y:1 N:2");

						int choice = scan.nextInt();
						if (choice == 1) {
							System.out.println("새로운 비밀번호를 입력하세요");
							vo.setPwd(scan.next());
						}else {
							return;
						}
					}

				} else if ("admin".equals(vo.getUser_id())) {
					System.out.println(vo.getUserName() + "님 환영합니다.");
					System.out.print("1.회원목록 2.회원검색 0.종료");

					int menu2 = scan.nextInt();

					switch (menu2) {

					case 1:
						System.out.println("********회원목록********");
						System.out.println("현재 가입한 회원 수는 " + list.size() + "명 입니다.");

						for (int i = 0; i < list.size(); i++) {
							System.out.println(
									"이름 : " + list.get(i).getUserName() + "\n아이디 : " + list.get(i).getUser_id());
						}
						break;

					case 2:
						System.out.println("********회원검색********");
						System.out.println("1. 이름 2. 아이디 0. 돌아가기");

						int search = scan.nextInt();

						if (search == 1) {
							System.out.print("이름 : ");
							userName = scan.next();

							if (userName.equals(vo.getUserName())) {
								System.out.println("이름 : " + vo.getUserName() + "\n아이디 : " + vo.getUser_id());
							}
							continue;

						} else if (search == 2) {
							System.out.print("아이디 : ");
							user_id = scan.next();

							if (user_id.equals(vo.getUser_id())) {
								System.out.println("이름 : " + vo.getUserName() + "\n아이디 : " + vo.getUser_id());
							}
							continue;

						} else if (search == 0) {
							continue;
						} else {
							System.out.println("해당 메뉴는 존재하지 않습니다.");
						}
						break;

					case 0:
						System.out.println("종료하겠습니다.");

						return;

					default:
						System.out.println("해당 메뉴는 존재하지 않습니다.");
						break;
					}
					break;

				} else {
					System.out.println(vo.getUserName() + "님 환영합니다.");
					continue;
				}
				break;

			case 3:

				System.out.println("********회원탈퇴********");

				System.out.print("아이디 : ");
				user_id = scan.next();
				System.out.print("비밀번호 : ");
				pwd = scan.next();

				for (int i = 0; i < list.size(); i++) {

					if (user_id.equals(vo.getUser_id()) && pwd.equals(vo.getPwd())) {

						list.remove(i);

						System.out.println("탈퇴가 완료되었습니다.");
						return;
					} else {
						System.out.println("존재하지 않는 회원입니다.");
					}
				}

				break;

			case 0:
				System.out.println("종료하겠습니다.");

				return;

			default:
				System.out.println("해당 메뉴는 존재하지 않습니다.");

				break;

			}
		}
	}
}