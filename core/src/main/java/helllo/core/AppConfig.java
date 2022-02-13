package helllo.core;

import helllo.core.discount.RateDiscountPolicy;
import helllo.core.member.MemberService;
import helllo.core.member.MemberServiceImpl;
import helllo.core.member.MemoryMemberRepository;
import helllo.core.order.OrderService;
import helllo.core.order.OrderServiceImpl;
// 공연 기획자 ->"어떤" 배우들끼리 연기를 하게 될지 정하느 "기획서"
public class AppConfig {

    // MemberService 객체는 MemoryMemberreposiroy "구현체"랑 연기를 하렴
    // MemberService 구현체에서는 오로지 memberRepository "인터페이스"와 의존
    // 주입은 "공연기획자"인 Appconfig에서 하기
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){

        return new OrderServiceImpl(new RateDiscountPolicy(), new MemoryMemberRepository());
    }

}
