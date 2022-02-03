package hello.hellospring.sevice;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    // @beforeEach, @afterEach 이거를 할필요가 없음 bootTest를 쓰면 ! -> @Transactional 사용하면 rollback 해버림
    // 통합테스트보다 단위테스트가 좋음 (스프링 컨테이너를 사용하지않은!)
    @Test
    // 한글로도 많이 적
    void 회원가() {
        //given 어떤 상황에서
        Member member = new Member();
        member.setName("hello");

        //when 이걸 실행했을때
        Long saveId = memberService.join(member);

        //then 이게 나와야함
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원예외() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // 1번째 방법
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");



    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}