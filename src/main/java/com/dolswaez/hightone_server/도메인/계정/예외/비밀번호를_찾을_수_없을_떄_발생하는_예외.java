package com.dolswaez.hightone_server.도메인.계정.예외;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class 비밀번호를_찾을_수_없을_떄_발생하는_예외 extends RuntimeException {
    private final String 비밀번호;
}
