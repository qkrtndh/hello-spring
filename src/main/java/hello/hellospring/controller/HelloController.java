package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")//get방식으로 hello-string접속
    @ResponseBody //html이 아닌 http의 body에 직접 내용 주입
    public String helloString(@RequestParam("name") String name){//입력된 파라미터를 name키에 name value로 저장
        return "hello" + name;//리턴
    }

    @GetMapping("hello-api")//get방식으로 hello-api접속
    @ResponseBody //html이 아닌 http의 body에 직접 내용 주입
    public  Hello helloApi(@RequestParam("name") String name){//입력된 파라미터를 name키에 name value로 저장
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{//클래스 내부에서 사용할 수 있는 클래스 객체
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
