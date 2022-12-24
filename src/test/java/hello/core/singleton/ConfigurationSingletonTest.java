package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 스프링컨테이너가 싱글톤으로 실제로 만들어주는지 확인하는 코드 이다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!실제로 똑같은 new코드가 2번 생성 되었는데
//이걸 스프링컨테이너가 어덯게 처리하는 지 알려고 이테스크코드를 작성했다.
public class ConfigurationSingletonTest {


    @Test
    @DisplayName("싱글톤이 실제로 스프링컨테이너가 해주는 지 안해주는 지 보여준다")
    void confifurationTest(){
      ApplicationContext ac =   new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService1 = ac.getBean("orderService", OrderServiceImpl.class);


        Assertions.assertThat(memberService1.getMemberRepository()).isSameAs(orderService1.getMemberRepository());
    }
}
