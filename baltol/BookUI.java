package baltol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookUI {
	
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		UserVO vo = new UserVO();
		List<UserVO> list = new ArrayList<UserVO>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		String user_id = "";
		String pwd = "";
		String userName = "";
		int error = 0;
		String q1 = "내가 사는 지역 이름은?";
		String q2 = "내가 다녔던 초등학교 이름은?";
		String q3 = "내가 제일 좋아하는 과일 이름은?";
		String answer = "";
		
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
				
				System.out.println("비밀번호 찾기 질문을 번호로 선택해주세요.");
				System.out.println("1. " + q1);
				System.out.println("2. " + q2);
				System.out.println("3. " + q3);
				String choose = scan.next();
				
				if(choose.equals("1")) {
					System.out.print(q1 + " : ");
					answer = scan.next();
					map.put(q1, answer);
				}else if(choose.equals("2")) {
					System.out.print(q2 + " : ");
					answer = scan.next();
					map.put(q2, answer);
				}else if(choose.equals("3")) {
					System.out.print(q3 + " : ");
					answer = scan.next();
					map.put(q3, answer);
				}
			}else{
				System.out.println("********로그인********");
				System.out.print("로그인 아이디를 입력하세요:");
				user_id= scan.next();
				System.out.print("로그인 비밀번호를 입력하세요:");
				pwd = scan.next();
				if((!user_id.equals(vo.getUser_id())) || (!pwd.equals(vo.getPwd()))) {
					if(error < 5) {
						System.out.println(error+"번째 로그인 실패");
						++error;
					}else if(error >= 5) {
						System.out.println(error+"회 실패로 로그인 할 수 없습니다.");
						
						System.out.println("비밀번호 찾기를 진행하시겠습니까? Y : 1 / N : 2");
						String yn = scan.next();
						if(yn.equals("1")) {
							System.out.println("비밀번호 찾기 질문을 번호로 선택해주세요.");
							System.out.println("1. " + q1);
							System.out.println("2. " + q2);
							System.out.println("3. " + q3);
							String choose = scan.next();
							
							if(choose.equals("1")) {
								System.out.print(q1 + " : ");
								answer = scan.next();
								String a = map.get(q1);
								if(a.equals(answer)) {
									System.out.println("고객님의 비밀번호는 " + vo.getPwd() + "입니다.");
								}else {
									System.out.println("틀렸습니다.");
								}
							}else if(choose.equals("2")) {
								System.out.print(q2 + " : ");
								answer = scan.next();
								String a = map.get(q2);
								if(a.equals(answer)) {
									System.out.println("고객님의 비밀번호는 " + vo.getPwd() + "입니다.");
								}else {
									System.out.println("틀렸습니다.");
								}
							}else if(choose.equals("3")) {
								System.out.print(q3 + " : ");
								answer = scan.next();
								String a = map.get(q3);
								if(a.equals(answer)) {
									System.out.println("고객님의 비밀번호는 " + vo.getPwd() + "입니다.");
								}else {
									System.out.println("틀렸습니다.");
								}
							}
							
						}else {
							System.out.println("비밀번호 초기화를 진행하시겠습니까? Y : 1 / N : 2");
							String yn2 = scan.next();
							if(yn2.equals("1")) {
								System.out.println("********비밀번호 변경********");
								System.out.print("새로운 비밀번호를 입력하세요:");
								vo.setPwd(pwd = scan.next());
							}else {
								break;
							}
						}
					}
				}else {
					System.out.println("********로그인 성공********");
					System.out.println(vo.getUserName() + "님 환영합니다.");
					break;
				}
				
			}
		}
	}
}
