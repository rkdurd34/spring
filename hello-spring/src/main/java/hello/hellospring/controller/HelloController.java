package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello~!~!!!");
        return "hello";

    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value= "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";

    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value= "name",required = false) String name){
        // StringConverter <- responseBody를 사용했기에
        return "hello" + name;

    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value= "name",required = false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        // 객체일경우 JsonConverter(MappingJackson2HttpMessageConverter)가 발동 되어서 파싱해서 보내버림
        return hello;

    }
    static class Hello{
        // getter setter(프로퍼티 접근방식) -> ctrl+enter
        // private 인스턴스 변수 설정하여서 맘대로 변수에 접근 못하게 한후 getter,setter를 설정해서
        // 직접적으로 접근 막고 일정한 규칙을 집어 넣을 수 있음 -> 객체의 무결성을 해치지 않고 변수 변경 가능
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
