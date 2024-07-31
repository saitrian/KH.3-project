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

	public void createSampleData() {
		memberService.insertMember(new MemberVO("aaa", "111"));
		memberService.insertMember(new MemberVO("bbb", "222"));
		memberService.insertMember(new MemberVO("qqq", "333", "admin"));
	}
}
