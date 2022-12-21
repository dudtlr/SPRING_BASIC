package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

       // MemberService memberService = new MemberServiceImpl();  //기존의 코드 ocp dip위배
       // OrderService orderService = new OrderServiceImpl();   //기존의 코드 ocp dip위배
        //해결책코드 등장!!
        AppConfig appConfig = new AppConfig();
       MemberService memberService = appConfig.memberService();
       OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"전영식", Grade.VIP);
        memberService.join(member);

      Order order = orderService.createOrder(memberId,"itemA",30000);

      System.out.println("order = " + order.toString());



    }
}
