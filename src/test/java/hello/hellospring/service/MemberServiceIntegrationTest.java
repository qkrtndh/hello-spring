package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        /**try {
            memberService.join(member2);
            fail();
        }
        catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다1.");
        }*/

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");


    }


    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("soo");
        Member member2 = new Member();
        member2.setName("soo2");
        memberService.join(member1);
        memberService.join(member2);
        assertThat(memberService.findMembers().size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        Member member = new Member();
        member.setName("soo");
        Long id = memberService.join(member);
        assertThat(memberService.findOne(id).get()).isEqualTo(member);
    }
}