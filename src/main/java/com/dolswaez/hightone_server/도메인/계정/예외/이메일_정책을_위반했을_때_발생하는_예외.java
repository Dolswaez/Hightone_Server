package com.dolswaez.hightone_server.도메인.계정.예외;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class 이메일_정책을_위반했을_때_발생하는_예외 extends RuntimeException {
    private final String 이메일;
}
