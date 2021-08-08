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

			if (list.isEmpty()) {

				System.out.println("********회원가입********");
				System.out.print("아이디를 입력하세요:");
				String Id = scan.next();
				vo.setUser_id(Id);
				System.out.print("비밀번호를 입력하세요:");
				String Pw = scan.next();
				vo.setPwd(Pw);
				System.out.print("이름을 입력하세요:");
				String Name = scan.next();
				vo.setUserName(Name);
				list.add(vo);
				System.out.println(Name + "님 가입을 축하드립니다.");

			} else {

				System.out.println("********로그인********");
				System.out.print("아이디 : ");
				user_id = scan.next();
				System.out.print("비밀번호 : ");
				pwd = scan.next();

				if (!pwd.equals(vo.getPwd()) || !user_id.equals(vo.getUser_id())) {
					if (error < 5) {
						error++;
						System.out.println("아이디 혹은 비밀번호 불일치. 다시 로그인 하세요.");
						System.out.println("********로그인 " + error + "회 재시도********");
					} else if (error >= 5) {
						System.out.println("비밀번호를 5회이상 틀리셨습니다.");
						System.out.println("비밀번호 초기화를 진행하시겠습니까? Y:1 N:2");

						int choice = scan.nextInt();

						if (choice == 1) {
							System.out.print("새로운 비밀번호를 입력하세요 : ");
							String Pw = scan.next();
							vo.setPwd(Pw);
							System.out.println("비밀번호 변경이 완료되었습니다.");
							error = 0;
						} else {
							return;
						}
					}
				} else {
					System.out.println(vo.getUserName() + "님 환영합니다.");

					if ("admin".equals(vo.getUser_id())) {

						System.out.println("1.회원등록");
						System.out.println("2.회원목록");
						System.out.println("3.회원검색");
						System.out.println("4.회원삭제");
						System.out.println("5.로그아웃");
						System.out.println("0.종     료");

						int menu2 = scan.nextInt();

						switch (menu2) {

						case 1:
							System.out.println("********회원등록********");

							UserVO vo2 = new UserVO();

							System.out.print("등록할 회원 아이디 : ");
							String Id = scan.next();
							vo2.setUser_id(Id);
							System.out.print("등록할 회원 비밀번호 : ");
							String Pw = scan.next();
							vo2.setPwd(Pw);
							System.out.print("등록할 회원 이름 : ");
							String Name = scan.next();
							vo2.setUserName(Name);
							list.add(vo2);
							System.out.println("새로운 회원을 등록하였습니다.");

							break;

						case 2:
							System.out.println("********회원목록********");
							System.out.println("현재 가입한 회원 수는 " + list.size() + "명 입니다.");

							for (int i = 0; i < list.size(); i++) {

								System.out.println(
										"아이디 : " + list.get(i).getUser_id() + "\n이름 : " + list.get(i).getUserName());

							}
							break;

						case 3:
							System.out.println("********회원검색********");
							System.out.println("      1.이     름");
							System.out.println("      2.아 이 디");
							System.out.println("      0.돌아가기");

							int search = scan.nextInt();

							if (search == 1) {
								System.out.println("검색할 이름 : ");
								String searchName = scan.next();

								for (int i = 0; i < list.size(); i++) {
									if (searchName.equals(list.get(i).getUserName())) {
										System.out.println("아이디 : " + list.get(i).getUser_id() + "\n이름 : "
												+ list.get(i).getUserName());
										break;
									} else {
										System.out.println("존재하지 않는 이름입니다.");
										continue;
									}
								}
								break;
							} else if (search == 2) {
								System.out.println("검색할 아이디 : ");
								String searchId = scan.next();

								for (int i = 0; i < list.size(); i++) {
									if (searchId.equals(list.get(i).getUser_id())) {
										System.out.println("아이디 : " + list.get(i).getUser_id() + "\n이름 : "
												+ list.get(i).getUserName());
										break;
									} else {
										System.out.println("존재하지 않는 아이디입니다.");
										continue;
									}
								}
							} else if (search == 0) {
								break;
							} else {
								System.out.println("해당 메뉴는 존재하지 않습니다.");
								continue;
							}
							break;

						case 4:
							System.out.println("********회원삭제********");

							System.out.println("삭제할 회원의 아이디 : ");
							String DeleteId = scan.next();

							for (int i = 0; i < list.size(); i++) {
								if (DeleteId.equals(list.get(i).getUser_id())) {
									System.out.println("회원의 정보를 확인해주세요.");
									System.out.println("아이디 : " + list.get(i).getUser_id() + "\n이름 : "
											+ list.get(i).getUserName());
									System.out.println("삭제를 진행하시겠습니까? Y:1 N:2");

									int delete = scan.nextInt();

									if (delete == 1) {
										list.remove(i);
										System.out.println("삭제가 완료되었습니다.");
									} else if (delete == 2) {
										break;
									}
								}
								System.out.println("존재하지 않는 회원입니다.");
								continue;
							}
							break;

						case 5:
							System.out.println("로그아웃되셨습니다.");
							break;

						case 0:
							System.out.println("종료하겠습니다.");
							return;

						default:
							System.out.println("해당 메뉴는 존재하지 않습니다.");
							break;
						}
					} else {

						System.out.println("*****Welcome BookStore*****");
						System.out.println("	 1.회원가입");
						System.out.println("	 2.회원수정");
						System.out.println("	 3.로그아웃");
						System.out.println("	 4.회원탈퇴");
						System.out.println("	 0.종     료");

						int menu = scan.nextInt();

						switch (menu) {

						case 1:
							System.out.println("********회원가입********");
							System.out.print("아이디를 입력하세요:");
							String Id = scan.next();
							vo.setUser_id(Id);
							System.out.print("비밀번호를 입력하세요:");
							String Pw = scan.next();
							vo.setPwd(Pw);
							System.out.print("이름을 입력하세요:");
							String Name = scan.next();
							vo.setUserName(Name);
							list.add(vo);
							System.out.println(Name + "님 가입을 축하드립니다.");

							break;

						case 2:
							System.out.println("********회원수정********");
							System.out.println("수정할 회원의 아이디 : ");
							String searchId = scan.next();

							for (int i = 0; i < list.size(); i++) {
								if (searchId.equals(list.get(i).getUser_id())) {

									System.out.println("1.아이디 수정");
									System.out.println("2.이름 수정");

									int update = scan.nextInt();

									if (update == 1) {
										System.out.println("기존 아이디 : " + list.get(i).getUser_id());
										System.out.println("변경할 아이디 : ");
										String updateId = scan.next();
										vo.setUser_id(updateId);

										System.out.println("수정 완료");
										System.out.println("아이디 : " + list.get(i).getUser_id() + "\n이름 : "
												+ list.get(i).getUserName());

									} else if (update == 2) {
										System.out.println("기존 이름 : " + list.get(i).getUserName());
										System.out.println("변경할 이름 : ");
										String updateName = scan.next();
										vo.setUserName(updateName);

										System.out.println("수정 완료");
										System.out.println("아이디 : " + list.get(i).getUser_id() + "\n이름 : "
												+ list.get(i).getUserName());
									} else {
										break;
									}
								} else {
									System.out.println("존재하지 않는 회원입니다.");
									break;
								}
							}
							break;

						case 3:
							System.out.println("로그아웃되셨습니다.");
							break;

						case 4:
							System.out.println("********회원탈퇴********");

							System.out.println("탈퇴할 회원의 아이디 : ");
							String deleteId = scan.next();

							for (int i = 0; i < list.size(); i++) {
								if (deleteId.equals(list.get(i).getUser_id())) {
									System.out.println("회원의 정보를 확인해주세요.");
									System.out.println("아이디 : " + list.get(i).getUser_id() + "\n이름 : "
											+ list.get(i).getUserName());
									System.out.println("탈퇴를 진행하시겠습니까? Y:1 N:2");

									int delete = scan.nextInt();
									if (delete == 1) {
										list.remove(i);
										System.out.println("탈퇴가 완료되었습니다.");

										if (deleteId.equals(user_id)) {
											break;
										}

										break;
									} else if (delete == 2) {
										break;
									}
								}
								System.out.println("존재하지 않는 회원입니다.");
								continue;
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
		}
	}
}