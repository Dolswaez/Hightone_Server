package com.dolswaez.hightone_server.도메인.우정기록부.예외;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class 우정기록부를_찾을_수_없을_떄_발생하는_예외 extends RuntimeException {
    private final Long 인덱스;
}
