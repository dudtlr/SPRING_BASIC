package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
//import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

       // MemberService memberService = new MemberServiceImpl();  //기존의 코드 ocp dip 위배
       // OrderService orderService = new OrderServiceImpl();   //기존의 코드 ocp dip 위배
        //해결책코드 등장!!
        //--------------스프링 쓰기 전 순수 자바 코드 --------------------
//        AppConfig appConfig = new AppConfig();
//       MemberService memberService = appConfig.memberService();
//       OrderService orderService = appConfig.orderService();
        //--------------스프링 쓰기 전 순수 자바 코드 --------------------

        //---------------------스프링 코드-------------------------
        //ApplicationContext 를 스프링 컨테이너라 한다
       // 기존에는 개발자가 AppConfig 를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다
//        기존에는 개발자가 AppConfig 를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링
//        컨테이너를 통해서 사용한다.
//                스프링 컨테이너는 @Configuration 이 붙은 AppConfig 를 설정(구성) 정보로 사용한다. 여기서 @Bean
//        이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다. 이렇게 스프링 컨테이너에
//        등록된 객체를 스프링 빈이라 한다.
//                스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. ( memberService ,
//                orderService )
//        이전에는 개발자가 필요한 객체를 AppConfig 를 사용해서 직접 조회했지만, 이제부터는 스프링
//        컨테이너를 통해서 필요한 스프링 빈(객체)를 찾아야 한다. 스프링 빈은
//        applicationContext.getBean() 메서드를 사용해서 찾을 수 있다.
//                기존에는 개발자가 직접 자바코드로 모든 것을 했다면 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로
//        등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =  applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService =  applicationContext.getBean("orderService",OrderService.class);
        //메소드 이름 , 타입
        //---------------------스프링 코드-------------------------


        Long memberId = 1L;
        Member member = new Member(memberId,"전영식", Grade.VIP);
        memberService.join(member);

      Order order = orderService.createOrder(memberId,"itemA",30000);

      System.out.println("order = " + order.toString());



    }
}
