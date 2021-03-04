package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//컨트롤러임 명시
public class HomeControlloer {

    @GetMapping("/")// 기본페이지 접속시
    public String home(){
        return "home"; //home글자 반환. 반환된 home은 templates에서 home이라는 파일을 수행한다.
        //정확히는 home이라는 템플릿 페이지를 생성?
    }
}
