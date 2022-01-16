package com.dolswaez.hightone_server.도메인.계정.서비스;

import com.dolswaez.hightone_server.도메인.계정.레포지토리.인증코드_레포지토리;
import com.dolswaez.hightone_server.도메인.계정.예외.인증코드를_찾을_수_없을_떄_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.정보.엔티티.인증코드_엔티티;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class 레디스_기반_인증코드_관리_서비스 implements 인증코드_관리_서비스{
    private final Random 난수 = new Random();
    private final 인증코드_레포지토리 레디스_기반_인증코드_레포지토리;
    @Override
    public String 인증코드_생성하기(String 이메일) {
        String 인증코드 = 인증코드_생성하기();
        인증코드_엔티티 엔티티 = new 인증코드_엔티티(인증코드, 이메일);
        레디스_기반_인증코드_레포지토리.save(엔티티);
        return 인증코드;
    }
    
    private String 인증코드_생성하기() {
        Integer 인증코드_번호 = 난수.nextInt(999999);
        return String.format("%06d", 인증코드_번호);
    }

    @Override
    public String 인증코드로_이메일_가져오기(String 인증코드) {
        Optional<인증코드_엔티티> 엔티티 = 레디스_기반_인증코드_레포지토리.findById(인증코드);
        if(엔티티.isEmpty()) throw new 인증코드를_찾을_수_없을_떄_발생하는_예외(인증코드);
        return 엔티티.get().get이메일();
    }
}
