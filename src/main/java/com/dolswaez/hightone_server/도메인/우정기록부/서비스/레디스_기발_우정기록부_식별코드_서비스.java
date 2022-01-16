package com.dolswaez.hightone_server.도메인.우정기록부.서비스;

import com.dolswaez.hightone_server.도메인.우정기록부.레포지토리.우정기록부_식별코드_레포지토리;
import com.dolswaez.hightone_server.도메인.우정기록부.예외.식별코드를_찾을_수_없을_때_발생하는_예외;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티.우정기록부_식별코드_엔티티;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Getter
public class 레디스_기발_우정기록부_식별코드_서비스 implements 우정기록부_식별코드_서비스 {
    private final Random 난수 = new Random();
    private final 우정기록부_식별코드_레포지토리 우정기록부_식별코드_레포지토리;

    @Override
    public String 식별코드_생성하기(String 아이디) {
        String 식별코드 = 식별코드_생성하기();
        우정기록부_식별코드_엔티티 엔티티 = new 우정기록부_식별코드_엔티티(식별코드, 아이디);
        우정기록부_식별코드_레포지토리.save(엔티티);
        return 식별코드;
    }

    @Override
    public String 식별코드로_아이디_가져오기(String 식별코드) {
        Optional<우정기록부_식별코드_엔티티> 엔티티 = 우정기록부_식별코드_레포지토리.findById(식별코드);
        if(엔티티.isEmpty()) throw new 식별코드를_찾을_수_없을_때_발생하는_예외(식별코드);
        return 엔티티.get().get아이디();
    }

    private String 식별코드_생성하기() {
        Integer 인증코드_번호 = 난수.nextInt(999999);
        return String.format("%06d", 인증코드_번호);
    }
}
