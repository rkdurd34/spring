package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


// MemberService를 통해서 회원가입,조회가 가능해야댐
// 스프링 컨테이너에서 스프링 빈이 작동 되고 있다!
// 의존관계를 주입 -> DI
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 이걸 사용하면 컨테이너에 올라와있는거를 자동으로 가져옴! 이전에 new repository() 이런식으로 하면 객체가 계속 생성 되지만 이런식으로 하면 공유!
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
