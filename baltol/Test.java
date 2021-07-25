package baltol;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.print("아이디를 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		
		String new_id = "";
		new_id = input.nextLine();
		
		Solution s = new Solution();
		String answer = s.solution(new_id);
		
		System.out.println(answer);
		
	}
}

class Solution{
	public String solution(String new_id) {
		String answer = "";
		
		while(true) {
			//1단계
			answer = (new_id.toLowerCase().trim());
			
			//2단계
			String match = "[^xfe0-9a-z\\s-_.]";
			answer = answer.replaceAll(match, "");
			
			//3단계
			while(true) {
				if(answer.contains("..")) {
					answer = answer.replace("..", ".");
		        }else {
		        	break;
		        }
			}
			
			//4단계
			if(answer.indexOf(".") == 0) {
				answer = answer.substring(1);
			}
			if(answer.length() != 0) {
				if(answer.lastIndexOf(".") == (answer.length() - 1)) {
					answer = answer.substring(0 ,answer.length() - 1);
				}
			}
			
			//5단계
			if(answer.length() == 0) {
				answer = "a";
				break;
			}
			
			//6단계
			if(answer.length() >= 16) {
				answer = answer.substring(0 , 15);
				if(answer.lastIndexOf(".") == (answer.length() - 1)) {
					answer = answer.substring(0 ,answer.length() - 1);
				}
			}
			
			//7단계
			if(answer.length() <= 2) {
				while(true) {
					String a = answer.substring(answer.length() - 1);
					answer = answer + a;
					if(answer.length() >= 3) {
						break;
					}
				}
			}
			break;
		}
		
		return answer;
	}
}