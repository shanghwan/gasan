package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.utils.SuballocatedByteVector;

import main.domin.UserVO;

public class BookUI2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		UserVO vo = new UserVO();
		List<UserVO> list = new ArrayList<UserVO>();

		String user_id = "";
		String pwd = "";
		String userName = "";
		String resetPwd = "0000";
		int error = 0;

		//비밀번호 찾기 랜덤함수로 돌려서 난수로 표출해서 로그인하세요.
		//어레이리스트
		
		while (true) {

			if (list.isEmpty()) {
				System.out.println("1.회원등록");
				System.out.print("아이디를 입력하세요:");
				vo.setUser_id(user_id = scan.next());
				System.out.print("비밀번호를 입력하세요:");
				vo.setPwd(pwd = scan.next());
				System.out.print("이름을 입력하세요:");
				vo.setUserName(userName = scan.next());
				System.out.println("회원가입이 완료되었습니다.");
				list.add(vo);
			}
			if (!list.isEmpty()) {
				System.out.println("2.회원검색");
				System.out.println("아이디로 검색하시려면 1을, 전체리스트를 보시려면 2를 입력해주세요.");
				String search = scan.next();
				if (search.equals("1")) {
					System.out.println("검색할 회원의 ID를 입력하세요.");
					vo.setUser_id(user_id = scan.next());
					System.out.println("회원 이름 : " + vo.getUserName() + "회원 아이디 : " + vo.getUser_id());
					System.out.println("2-1. 회원이름을 수정하시려면 1을 입력하세요");
					String edit = scan.next();
					if (edit.equals("1")) {
						System.out.println("수정할 이름을 입력하세요.");
						vo.setUserName(userName = scan.next());
						System.out.println("회원이름 수정 완료하였습니다.");
					}
				}
				if (search.equals("2")) {
					System.out.println("회원 전체 리스트");
					for (UserVO vo2 : list) {
						System.out.println("회원 이름 : " + vo2.getUserName() + "회원 아이디 : " + vo2.getUser_id());
					}
					System.out.println("회원삭제를 하시려면 1을 눌러주세요");
					String delete = scan.next();
					if (delete.equals("1")) {
						vo.setUserName("");
						vo.setUser_id("");
						vo.setPwd("");
						System.out.println("회원삭제를 완료하였습니다.");
						System.out.println("회원 전체 리스트");
						for (UserVO vo2 : list) {
							System.out.println("회원 이름 : " + vo2.getUserName() + "회원 아이디 : " + vo2.getUser_id());
						}
						// System.out.println("회원삭제하시겠습니까?");

//				System.out.print("로그인 비밀번호를 입력하세요:");
//				pwd = scan.next();
//				if((user_id==null||(!user_id.equals(vo.getUser_id()))) || (pwd==null||(!pwd.equals(vo.getPwd())))) {
//					if(error < 5) {
//						System.out.println(error+"번째 로그인 실패");
//						++error;
//					}else if(error >= 5) {
//						System.out.println(error+"회 실패로 로그인 할 수 없습니다.");
//						System.out.println("비밀번호 초기화를 진행하시겠습니까? Y : 1 / N : 2");
//						String yn = scan.next();
//						if(yn.equals("1")) {
//							System.out.println("********비밀번호 변경********");
//							System.out.print("새로운 비밀번호를 입력하세요:");
//							vo.setPwd(pwd = scan.next());
//						}else {
//							break;
//						}
//					}
//				}else {
//					System.out.println("********로그인 성공********");
//					System.out.println(vo.getUserName() + "님 환영합니다.");
//					break;
//				}

					}

				}
			}

		}
	}
}