package helllo.core.singleton;

import helllo.core.AppConfig;
import helllo.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();

        Assertions.assertThat(memberService).isNotSameAs(memberService1);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonService() {
        Singletonservice instance1 = Singletonservice.getInstance();
        Singletonservice instance2 = Singletonservice.getInstance();
        System.out.println("instance2 = " + instance2);
        System.out.println("instance1 = " + instance1);
    }
}
