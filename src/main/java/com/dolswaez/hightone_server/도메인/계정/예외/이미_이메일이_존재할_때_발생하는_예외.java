package com.dolswaez.hightone_server.도메인.계정.예외;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class 이미_이메일이_존재할_때_발생하는_예외 extends RuntimeException {
    private final String 이메일;
}
