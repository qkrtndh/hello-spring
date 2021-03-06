package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);//member를 insert 단 반환값 없음
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);//domain 맴버 클래스에서 해당 아이디를 이용하여 찾는다.
        return Optional.ofNullable(member);//optional로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        //특정값을 찾는 것은 jpql쿼리문을 작성해야 한다.
        //jpql은 테이블이 아닌 엔티티 객체를 대상으로 한다.
        //member 를 m 으로 alias하고, m에서 m의 이름이 변수 name인 것을 찾는다.
        //다음 인자로 엔티티 클래스를 준다.
        // 그 후 변수 name의 값을 setParameter로 실제 스트링 name과 연결하고, List 형식으로 반환한다.
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
