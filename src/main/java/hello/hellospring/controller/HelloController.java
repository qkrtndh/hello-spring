package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")// /hello라는 호출이 들어오면 이하의 메소드 실행
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")//get방식으로 hello-mvc접속
    public String helloMvc(@RequestParam("name") String name, Model model){//입력된 파라미터를 name키에 name value로 저장
        model.addAttribute("name",name);//모델에 name키에 name 값으로 저장
        return "hello-template";//리턴
    }
}
