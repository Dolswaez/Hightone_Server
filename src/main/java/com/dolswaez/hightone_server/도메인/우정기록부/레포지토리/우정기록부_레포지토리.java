package com.dolswaez.hightone_server.도메인.우정기록부.레포지토리;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티.우정기록부_엔티티;
import org.springframework.data.jpa.repository.JpaRepository;

public interface 우정기록부_레포지토리 extends JpaRepository<우정기록부_엔티티, Long> {
    boolean existsBy게시자인덱스(Long 게시자_인덱스);

    우정기록부_엔티티 getBy게시자인덱스(Long 게시자_인덱스);
}
