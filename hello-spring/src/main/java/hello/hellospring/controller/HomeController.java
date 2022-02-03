package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 스프링 컨테이너 -> 정적 컨텐츠
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
