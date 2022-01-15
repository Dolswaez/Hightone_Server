package com.dolswaez.hightone_server.도메인.계정.레포지토리;

import com.dolswaez.hightone_server.도메인.계정.정보.엔티티.인증코드_엔티티;
import org.springframework.data.repository.CrudRepository;

public interface 인증코드_레포지토리 extends CrudRepository<인증코드_엔티티, String> {
}
