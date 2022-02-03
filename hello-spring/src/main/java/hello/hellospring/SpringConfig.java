package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.sevice.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//스프링이 올라올때 스프링 컨테이너 스프링빈들을 자동으로 올려줌 Controller는 어노테이션+autowired쓰기
// setter 주입, 생성자주입, 필드주입 중 생성자 주입이 제일 좋음
// 상황에 따라 구현 클래스를 변경할 필요가 없어지는 장점이 있음
// 어쩄든 autowired는 스프링 컨테이너에 올라온 스프링 빈들만 사용 가능~
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
