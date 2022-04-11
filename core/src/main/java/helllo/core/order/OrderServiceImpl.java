package helllo.core.order;

import helllo.core.discount.DiscountPolicy;
import helllo.core.member.Member;
import helllo.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // DIP위반 discount policy interface에 의존해야대는데 구현체에도 지금 의존중..-> OCP위반
    // FixdiscountPolicy를 했는데 -> RateDiscountPolicy로 직접 바꿔주어야댐
    // 추상에만 의존해야댐!!!!!!!!!
    // 클라이언트(OrderServiceImpl)에 영향을 준다..
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    // 생성자를 통해서 필요한 인터페이스들을 호출하지만 "어떤 구현 객체"들이 주입될지 전혀 모름!!!!!!
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }
    // final은 항상 할당이 되어야함 -> 바뀌면 안되기떄문
    // 이 상태로는 당연히 할당을 안했기 떄문....
    // OrderserviceImpl에 DiscountPolicy "구현체"를 대신 생성하고 주입해주어야함@!@!@! <- 이 부분이 결국엔 핵심-


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
