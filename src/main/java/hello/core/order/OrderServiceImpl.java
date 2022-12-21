package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

   // private final MemberRepository memberRepository = new MemoryMemberRepository();
   // private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //(기존 순수 자바 코드)여기서 할인 정책을 만약 바꾸고싶으면 오른쪽 코드만
    //바꿔주면된다.

    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //또 다른 할인 정책
    //기존의 코드는 문제가 있다. 1.dip 위배 => 추상화에도 의존 중이지만 구체적인 것에도 의존 중이다. 2.ocp 위배 => 정책을 바꾸려면 13번째 줄 오른쪽 코드를
    //어쩔 수 없이 바꿔줘야 한다.  => 순수 자바로 잘 짠 코드다!! 하지만 순수 자바코드로는 한계가 있다!! => 뭔가가 필요하다!! => Spring
    //private DiscountPolicy discountPolicy;  //dip 위배 중이여서 위배 하지 않게 추상화에만 의존하도록 만듬 (해결책 코드)
    //but 구현체가 없어서 실행이 되지 않는다 당연하게!!!! 그러면 도대체 dip를 어덯게 지킬 수 있는 거야???
    //이 문제를 해결하려면 누군가가 orderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해야한다.
    // 누군가 => 공연기획자!!(배우는 배우의 역할에만 집중해야한다. 지금 코드는 배우가 상대 배우 역할 할 사람을 정하는 꼴.//관심사를 나누자!!!)
    // 공연기획자 //appconfig
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memberId);
      int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
