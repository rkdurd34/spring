package helllo.core;

import helllo.core.discount.DiscountPolicy;
import helllo.core.discount.FixDiscountPolicy;
import helllo.core.discount.RateDiscountPolicy;
import helllo.core.member.MemberRepository;
import helllo.core.member.MemberService;
import helllo.core.member.MemberServiceImpl;
import helllo.core.member.MemoryMemberRepository;
import helllo.core.order.OrderService;
import helllo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 공연 기획자 ->"어떤" 배우들끼리 연기를 하게 될지 정하느 "기획서"

// IoC 컨테이너, DI 컨테이너 -> 동적인 객체 인스턴스 의존관계 를 변경
// Ioc(제어의 역전) -> 객체에 대한 제어권이 컨테이너(스프링)로 역전 되는 상황 (생명주기 관리 등등)
// 어셈블러라고도 불림 -> 어떤 객체들을 의존 관계로 둘지 설정해주면서 <조립> 하기 떄문에
@Configuration
public class AppConfig {

    // MemberService 객체는 MemoryMemberreposiroy "구현체"랑 연기를 하렴
    // MemberService 구현체에서는 오로지 memberRepository "인터페이스"와 의존
    // 주입은 "공연기획자"인 Appconfig에서 하기

    //이렇게 분리하게 되면 discountPolicy 변경시 한곳만 변경하여 다른 곳에 자동으로 주입 할    있다.
    // 역할(선언)과 구현(리턴) 클래스가 구분되어 한눈에 보임
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
