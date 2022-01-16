package com.dolswaez.hightone_server.도메인.계정.레포지토리;

import com.dolswaez.hightone_server.도메인.계정.정보.엔티티.유저_엔티티;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;

public interface 유저_레포지토리 extends JpaRepository<유저_엔티티, Long> {
    boolean existsBy아이디(@Length(max = 20) String 아이디);
    유저_엔티티 getBy아이디(@Length(max = 20) String 아이디);

    boolean existsBy이메일(String 이메일);
}
