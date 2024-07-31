package sjk.sample_2.teamProject.controller;

import java.util.Scanner;

import sjk.sample_2.teamProject.model.vo.MemberVO;
import sjk.sample_2.teamProject.service.MemberService;
import sjk.sample_2.teamProject.service.MemberServiceImp;

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
}
