package helllo.core.order;

import helllo.core.member.Grade;
import helllo.core.member.Member;
import helllo.core.member.MemberService;
import helllo.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        // long 으로 해두 되긴 하는데 Long을 사용한 이유는 null이 들어갈 수 있기 떄문!!!!
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
