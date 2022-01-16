package com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.종류.성격_종류;

import java.util.List;

public record 우정기록_정보(
        Long 인덱스,
        String 작성자_이름,
        List<성격_종류> 성격_리스트,
        String 친학수,
        String 내꼭해
) {}
