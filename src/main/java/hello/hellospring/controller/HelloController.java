package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")// /hello라는 호출이 들어오면 이하의 메소드 실행
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }
}
