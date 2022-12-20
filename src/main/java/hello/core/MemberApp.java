package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl(); // ocp위배 why? 구현체가 바뀔 때마다 new 옆부분을 바꿔줘야한다.
        //순수 자바로 해결 못한다 => 뭔가가 필요하다 => 스프링!!!!!!!
        Member member = new Member(1L,"전영식", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findmember = " + findMember.getName());




    }
}
