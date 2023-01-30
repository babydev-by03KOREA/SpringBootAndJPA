package com.start.mavenbook.Repository;

import com.start.mavenbook.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /* Member 엔티티를 DB에 저장하기 위한 Repository 생성 */
    Member findByEmail(String email);
}
