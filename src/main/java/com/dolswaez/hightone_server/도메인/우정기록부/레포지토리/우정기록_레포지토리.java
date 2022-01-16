package com.dolswaez.hightone_server.도메인.우정기록부.레포지토리;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티.우정기록_엔티티;
import org.springframework.data.jpa.repository.JpaRepository;

public interface 우정기록_레포지토리 extends JpaRepository<우정기록_엔티티, Long> {
}
