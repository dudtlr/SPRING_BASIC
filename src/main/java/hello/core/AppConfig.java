package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration  //구성정보
public class AppConfig {
    //리팩토링 :: 역할과 구현을 명확히 appconfig를 봤을 때 나타나도록한다.

    //@Bean -> memberService -> MemoryMemberRepository
    //@Bean -> orderService -> MemoryMemberRepository,
    //벌써 2번 호출된다. 이러면 싱글톤이 깨지는거아니야??? 생각 한다(당연)!!  스프링컨테이너는 이결을 어덯게 해결할까?

    @Bean //각 메서드에 적는다 이렇게 적으면 스프링컨테이너에 등록이 된다.
    //바깥에서 주입하므로써 impl은 new MemoryMemberRepository()를 알지 못한다. 추상화에만 의존 한다 . dip 잘 지킨다!!!!
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
       //  return new FixDiscountPolicy(); //고정 할인 정책
        return new RateDiscountPolicy(); // 비율 할인 정책으로 바꿀려면 여기만 바꾸면 된다.
    }


}
