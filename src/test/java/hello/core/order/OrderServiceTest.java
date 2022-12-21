package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl(); 기존 코드
//    OrderService orderService = new OrderServiceImpl();  기존코드

    MemberService memberService ;
    OrderService orderService ;
@BeforeEach //테스트 되기 전에 무조건 실행 하는 거

public void beforeEach(){
    AppConfig appConfig = new AppConfig();
    memberService =  appConfig.memberService();
    orderService = appConfig.orderService();
}

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);


        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
