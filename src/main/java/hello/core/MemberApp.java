package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.AnnotatedArrayType;

public class MemberApp {
    public static void main(String[] args) {
        //---------------스프링 사용 하기 전 순수 자바 코드------------------------------------------
       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService(); //ocp dip 해결해주는 appconfig 사용
        //----------------------스프링 사용 하기 전 순수 자바 코드------------------------

        //--------------------------스프링 코드---------------------------------------------------

        //AppConfig에 있는 bean들을 스프링 컨테이너에 등록시킨다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        //메소드이름,타입 


        //--------------------------스프링 코드---------------------------------------------------
        //MemberService memberService = new MemberServiceImpl(); // ocp위배 why? 구현체가 바뀔 때마다 new 옆부분을 바꿔줘야한다.
        //순수 자바로 해결 못한다 => 뭔가가 필요하다 => 스프링!!!!!!!
        Member member = new Member(1L,"전영식", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findmember = " + findMember.getName());




    }
}
