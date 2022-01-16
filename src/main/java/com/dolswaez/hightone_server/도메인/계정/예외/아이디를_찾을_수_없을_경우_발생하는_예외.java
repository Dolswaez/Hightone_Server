package com.dolswaez.hightone_server.도메인.계정.예외;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class 아이디를_찾을_수_없을_경우_발생하는_예외 extends RuntimeException {
    private final String 아이디;
}
