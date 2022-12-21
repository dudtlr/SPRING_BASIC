package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //리팩토링 :: 역할과 구현을 명확히 appconfig를 봤을 때 나타나도록한다.


    //바깥에서 주입하므로써 impl은 new MemoryMemberRepository()를 알지 못한다. 추상화에만 의존 한다 . dip 잘 지킨다!!!!
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
       //  return new FixDiscountPolicy(); //고정 할인 정책
        return new RateDiscountPolicy(); // 비율 할인 정책으로 바꿀려면 여기만 바꾸면 된다.
    }


}
