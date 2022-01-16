package com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체;

import java.util.List;

public record 우정기록부_정보(
        Long 인덱스,
        Long 게시자_인덱스,
        List<우정기록_정보> 우정기록_리스트
) {}
