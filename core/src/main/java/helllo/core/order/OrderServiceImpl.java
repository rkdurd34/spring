package helllo.core.order;

import helllo.core.discount.DiscountPolicy;
import helllo.core.discount.FixDiscountPolicy;
import helllo.core.discount.RateDiscountPolicy;
import helllo.core.member.Member;
import helllo.core.member.MemberRepository;
import helllo.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // DIP위반 discount policy interface에 의존해야대는데 구현체에도 지금 의존중..-> OCP위반
    // FixdiscountPolicy를 했는데 -> RateDiscountPolicy로 직접 바꿔주어야댐
    // 추상에만 의존해야댐!!!!!!!!!
    // 클라이언트(OrderServiceImpl)에 영향을 준다..
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
