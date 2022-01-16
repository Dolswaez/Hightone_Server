package com.dolswaez.hightone_server.전역.자바_웹_토큰.유틸;

public interface 자바_웹_토큰_유틸<T> {
    String 토큰_인코딩(T data);
    T 토큰_디코딩(String token);
}