package hello.hellospring.domain;


import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//회원이 저장하는 아이디가 아닌 시스템에서 저장하는 아이디

    //@Column(name="username")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
