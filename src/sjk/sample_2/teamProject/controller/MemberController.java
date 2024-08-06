package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import lombok.Data;
import sjk.sample_2.teamProject.model.vo.MemberVO;
import sjk.sample_2.teamProject.service.MemberService;
import sjk.sample_2.teamProject.service.MemberServiceImp;

@Data
public class MemberController extends BaseController {

	private MemberService memberService = new MemberServiceImp();

	public MemberController(Scanner scan) {
		super(scan);
	}

	public boolean insertMember() {

		String id = "aaa"; 
		String pw = "111";
		String authority = "user";
		int point = 0;
		memberService.insertMember(id, pw, authority, point);
		id = "bbb";
		pw = "222";
		memberService.insertMember(id, pw, authority, point);
		id = "ccc";
		pw = "333";
		memberService.insertMember(id, pw, authority, point);
		id = "ddd";
		pw = "444";
		memberService.insertMember(id, pw, authority, point);
		id = "eee";
		pw = "555";
		return memberService.insertMember(id, pw, authority, point);
	}
	
	public String login() {
		String id = checkLogin();
		
		if(id == null) {
			System.out.println("로그인 실패");
			return null;
		}
		
		return id;
	}
	
	private String checkLogin() {		
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		
		System.out.print("비번 입력 : ");
		String pw = scan.next();
		
		System.out.println("--------------------");
		
		if(!memberService.login(id, pw)) {
			System.out.println("회원 정보가 일치하지 않습니다.");
			return null;
		}
		return id;
	}

	public void upPoint(String id) {
		memberService.updateUpPoint(id);
	}

	public void usePoint(String id) {
		memberService.updateUsePoint(id);
	}

	public void searchPoint() {
		String id = login();
		if(id == null) {
			return;
		}
		
		memberService.searchPoint(id);
		
	}
}
