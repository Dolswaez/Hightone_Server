package com.dolswaez.hightone_server.도메인.우정기록부.레포지토리;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티.우정기록부_식별코드_엔티티;
import org.springframework.data.repository.CrudRepository;

public interface 우정기록부_식별코드_레포지토리 extends CrudRepository<우정기록부_식별코드_엔티티, String> {
}
