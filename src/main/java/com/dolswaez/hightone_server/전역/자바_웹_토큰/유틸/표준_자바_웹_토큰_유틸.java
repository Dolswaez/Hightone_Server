package com.dolswaez.hightone_server.전역.자바_웹_토큰.유틸;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@RequiredArgsConstructor
public abstract class 표준_자바_웹_토큰_유틸<T> implements 자바_웹_토큰_유틸<T> {

    @Override
    public String 토큰_인코딩(T 정보) {
        LocalDateTime 현재시각 = LocalDateTime.now();
        return Jwts.builder()
                .setClaims(클레임_가져오기(정보))
                .signWith(HS256, 비밀키_가져오기())
                .setIssuedAt(Timestamp.valueOf(현재시각))
                .setExpiration(Timestamp.valueOf(만료기간_가져오기(현재시각)))
                .compact();
    }

    @Override
    public T 토큰_디코딩(String 토큰) {
        Claims 클레임 = Jwts.parser()
                .setSigningKey(비밀키_가져오기())
                .parseClaimsJws(토큰)
                .getBody();
        return 클레임을_통해_정보_가져오기(클레임);
    }


    protected abstract LocalDateTime 만료기간_가져오기(LocalDateTime 현재시각);
    protected abstract Map<String, Object> 클레임_가져오기(T 정보);
    protected abstract String 비밀키_가져오기();

    protected abstract T 클레임을_통해_정보_가져오기(Claims 클레임);
}
