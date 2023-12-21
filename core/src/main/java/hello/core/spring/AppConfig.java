package hello.core.spring;

import hello.core.spring.discount.DiscountPolicy;
import hello.core.spring.discount.RateDiscountPolicy;
import hello.core.spring.member.MemberRepository;
import hello.core.spring.member.MemberService;
import hello.core.spring.member.MemberServiceImpl;
import hello.core.spring.member.MemoryMemberRepository;
import hello.core.spring.order.OrderService;
import hello.core.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 컨테이너
 * ApplicationContext를 스프링 컨테이너라 한다.
 * 기존 개발자가 AppConfig를 사용해서 직접 객체를 구성하고 DI를 했지만,
 * 스프링 컨테이너를 통해 사용한다.
 * 스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정(구성)정보로 사용한다.
 * @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
 * 이렇게 스프링 컨테이터에 등록된 객체를 스프링빈이라 한다.
 */
@Configuration
public class AppConfig {

    @Bean // 스프링 컨테이너에 자동 등록됨
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}