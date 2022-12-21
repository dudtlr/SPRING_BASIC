package hello.core.Member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

   // MemberService memberService = new MemberServiceImpl(); 기존의 코드
    MemberService memberService;

    @BeforeEach //테스트 되기 전에 무조건 실행 하는 거
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
      memberService =  appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"전영식", Grade.VIP);



        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
