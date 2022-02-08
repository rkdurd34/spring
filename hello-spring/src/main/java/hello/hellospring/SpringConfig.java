package hello.hellospring;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;

import hello.hellospring.sevice.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


//스프링이 올라올때 스프링 컨테이너 스프링빈들을 자동으로 올려줌 Controller는 어노테이션+autowired쓰기
// setter 주입, 생성자주입, 필드주입 중 생성자 주입이 제일 좋음
// 상황에 따라 구현 클래스를 변경할 필요가 없어지는 장점이 있음
// 어쩄든 autowired는 스프링 컨테이너에 올라온 스프링 빈들만 사용 가능~
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

        // 객체지향설계의 장점을 보여줌(다형성) -> assembly code(조립하느코드) 이것만 바꾸면 다른 구현체를 끼워넣기만 하면 사용가능
        // 개방 폐쇄원칙(OCP, open-closed principle) 확장에느 ㄴ열려있고 수정/변경에는 닫혀있다.
        // interface 에서 구현체를 바꾸면서 기존 코드는 건들지 않으면서 기능 확장/추가가 가능하다는것이 객체지향의 꽃

}
