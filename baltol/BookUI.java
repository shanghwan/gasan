package baltol;

import java.util.HashMap;
import java.util.Scanner;

public class BookUI {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		HashMap<String, QuestionVO> question = new HashMap<String, QuestionVO>();
		HashMap<String, UserVO> map = new HashMap<String, UserVO>();

		String user_id = "";
		String pwd = "";
		String userName = "";
		int error = 4;
		String q1 = "내가 사는 지역 이름은?";
		String q2 = "내가 다녔던 초등학교 이름은?";
		String q3 = "내가 제일 좋아하는 과일 이름은?";
		String answer = "";

		while (true) {

			System.out.println("*********************");
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			String join = scan.next();

			if (join.equals("1")) {
				System.out.println("********회원가입********");
				System.out.print("아이디를 입력하세요:");
				String id = scan.next();
				System.out.print("비밀번호를 입력하세요:");
				String pw = scan.next();
				System.out.print("이름을 입력하세요:");
				String name = scan.next();
				
				Solution1 s = new Solution1();
				String s_id = s.solution(id);
				
				if(id != s_id) {
					System.out.println("추천 아이디 : " + s_id);
					System.out.println("1. 그냥 쓸래요!  /  2. 추천 아이디 쓸래요!");
					String si = scan.next();
					if(si.equals("2")) {
						id = s_id;
					}
				}
				
				UserVO vo = new UserVO(id, pw, name);
				map.put(id, vo);

				System.out.println("비밀번호 재발급 질문을 번호로 선택해주세요.");
				System.out.println("1. " + q1);
				System.out.println("2. " + q2);
				System.out.println("3. " + q3);
				String choose = scan.next();

				if (choose.equals("1")) {
					System.out.print(q1 + " : ");
					answer = scan.next();
					QuestionVO qVo = new QuestionVO(id, q1, answer);
					question.put(id, qVo);
				} else if (choose.equals("2")) {
					System.out.print(q2 + " : ");
					answer = scan.next();
					QuestionVO qVo = new QuestionVO(id, q2, answer);
					question.put(id, qVo);
				} else if (choose.equals("3")) {
					System.out.print(q3 + " : ");
					answer = scan.next();
					QuestionVO qVo = new QuestionVO(id, q3, answer);
					question.put(id, qVo);
				}
			} else if (join.equals("2")) {

				System.out.println("********로그인********");
				System.out.print("로그인 아이디를 입력하세요:");
				user_id = scan.next();
				System.out.print("로그인 비밀번호를 입력하세요:");
				pwd = scan.next();
				UserVO vo = map.get(user_id);

				if ((!map.containsKey(user_id)) || (!vo.getPwd().equals(pwd))) {
					while (true) {
						if (error < 5) {
							System.out.println(error + "번째 로그인 실패");
							++error;
							break;
						} else if (error >= 5) {
							System.out.println(error + "회 실패로 로그인 할 수 없습니다.");

							System.out.println("*********************");
							System.out.println("1. 비밀번호 재발급 / 2. 비밀번호 초기화 / 3. 종료");
							String yn = scan.next();
							if (yn.equals("1")) {
								System.out.print("아이디를 입력해주세요:");
								String re_id = scan.next();
								System.out.println("비밀번호 재발급 질문을 번호로 선택해주세요.");
								System.out.println("1. " + q1);
								System.out.println("2. " + q2);
								System.out.println("3. " + q3);
								String choose = scan.next();
								QuestionVO a = question.get(re_id);
								vo = map.get(re_id);

								if (choose.equals("1")) {
									System.out.print(q1 + " : ");
									answer = scan.next();
									if (a.getAnswer().equals(answer)) {
										Random random = new Random();
										String newnum = random.random();
										vo.setPwd(newnum);
										System.out.println("고객님의 임시  비밀번호는 " + newnum + "입니다.");
										break;
									} else {
										System.out.println("틀렸습니다.");
										break;
									}
								} else if (choose.equals("2")) {
									System.out.print(q2 + " : ");
									answer = scan.next();
									if (a.getAnswer().equals(answer)) {
										Random random = new Random();
										String newnum = random.random();
										vo.setPwd(newnum);
										System.out.println("고객님의 임시 비밀번호는 " + newnum + "입니다.");
										break;
									} else {
										System.out.println("틀렸습니다.");
										break;
									}
								} else if (choose.equals("3")) {
									System.out.print(q3 + " : ");
									answer = scan.next();
									if (a.getAnswer().equals(answer)) {
										Random random = new Random();
										String newnum = random.random();
										vo.setPwd(newnum);
										System.out.println("고객님의 임시 비밀번호는 " + newnum + "입니다.");
										break;
									} else {
										System.out.println("틀렸습니다.");
										break;
									}
								}

							} else if (yn.equals("2")) {
								System.out.println("비밀번호 초기화를 진행하시겠습니까? Y : 1 / N : 2");
								String yn2 = scan.next();
								if (yn2.equals("1")) {
									System.out.print("아이디를 입력하세요:");
									String d_id = scan.next();
									if (!(map.get(d_id) == null)) {
										System.out.println("********비밀번호 변경********");
										System.out.print("새로운 비밀번호를 입력하세요:");
										vo.setPwd(pwd = scan.next());
									} else {
										System.out.println("올바르지 않은 비밀번호입니다.");
										break;
									}
								} else {
									break;
								}
							} else if (yn.equals("3")) {
								break;
							}
						}

					}
				} else {
					System.out.println("********로그인 성공********");
					System.out.println(vo.getUserName() + "님 환영합니다.");

					while (true) {
						System.out.println("********회원관리********");
						System.out.println("1.회원등록");
						System.out.println("2.회원검색");
						System.out.println("3.회원수정");
						System.out.println("4.회원삭제");
						System.out.println("5.로그아웃");

						String menu = scan.next();

						if (menu.equals("1")) {
							System.out.println("*********회원등록*********");
							System.out.print("아이디를 입력하세요:");
							String id = user_id = scan.next();
							System.out.print("비밀번호를 입력하세요:");
							String pw = pwd = scan.next();
							System.out.print("이름을 입력하세요:");
							String name = userName = scan.next();
							UserVO vo1 = new UserVO(id, pw, name);
							map.put(id, vo1);
						} else if (menu.equals("2")) {
							System.out.println("*********회원검색*********");
							System.out.println("1.아이디로 검색");
							System.out.println("2.전체 검색");
							String num = scan.next();

							if (num.equals("1")) {
								System.out.print("찾으시는 아이디를 입력하세요 : ");
								String search_id = scan.next();
								if (map.containsKey(search_id)) {
									UserVO vo2 = map.get(search_id);
									System.out.println("아이디 : " + vo2.getUser_id());
									System.out.println("이름 : " + vo2.getUserName());
								} else {
									System.out.println("존재하지 않는 아이디입니다.");
								}
							} else if (num.equals("2")) {
								for (String key : map.keySet()) {
									UserVO vo2 = map.get(key);
									System.out.println("**************************");
									System.out.println("아이디 : " + vo2.getUser_id());
									System.out.println("이름 : " + vo2.getUserName());
								}
							}
						} else if (menu.equals("3")) {
							System.out.println("*********회원수정*********");
							System.out.print("수정하실 고객의 아이디를 입력하세요 : ");
							String o_id = scan.next();

							if (map.containsKey(o_id)) {
								System.out.print("변경하실 아이디를 입력하세요 : ");
								String change_id = scan.next();
								UserVO vo2 = map.get(o_id);
								vo2.setUser_id(change_id);
							} else {
								System.out.println("존재하지 않는 아이디입니다.");
							}
						} else if (menu.equals("4")) {
							System.out.println("*********회원삭제*********");
							System.out.print("삭제하실 고객의 아이디를 입력하세요 : ");
							String delete_id = scan.next();

							if (map.containsKey(delete_id)) {
								map.remove(delete_id);
							} else {
								System.out.println("존재하지 않는 아이디입니다.");
							}
						} else if (menu.equals("5")) {
							break;
						}
					}
				}
			}
		}
	}
}

class Random {
	public String random() {
		char[] num = new char[8];

		for (int i = 0; i < 4; i++) {
			char y = (char) ((int) ((Math.random() * (122 - 97)) + 97));
			num[i] = y;
		}
		for (int i = 4; i < 8; i++) {
			char y = Character.forDigit(((int) (Math.random() * 9)), 10);
			num[i] = y;
		}

		String newnum = "";
		for (int i = 0; i < num.length; i++) {
			newnum = newnum + num[i];
		}

		return newnum;
	}
}

class Solution1 {
	public String solution(String new_id) {
		String answer = "";

		while (true) {
			// 1단계
			answer = (new_id.toLowerCase().trim());

			// 2단계
			String match = "[^xfe0-9a-z\\s-_.]";
			answer = answer.replaceAll(match, "");

			// 3단계
			while (true) {
				if (answer.contains("..")) {
					answer = answer.replace("..", ".");
				} else {
					break;
				}
			}

			// 4단계
			if (answer.indexOf(".") == 0) {
				answer = answer.substring(1);
			}
			if (answer.length() != 0) {
				if (answer.lastIndexOf(".") == (answer.length() - 1)) {
					answer = answer.substring(0, answer.length() - 1);
				}
			}

			// 5단계
			if (answer.length() == 0) {
				answer = "a";
			}

			// 6단계
			if (answer.length() >= 16) {
				answer = answer.substring(0, 15);
				if (answer.lastIndexOf(".") == (answer.length() - 1)) {
					answer = answer.substring(0, answer.length() - 1);
				}
			}

			// 7단계
			if (answer.length() <= 2) {
				while (true) {
					String a = answer.substring(answer.length() - 1);
					answer = answer + a;
					if (answer.length() >= 3) {
						break;
					}
				}
			}
			break;
		}

		return answer;
	}
}
