package com.dolswaez.hightone_server.도메인.우정기록부.서비스;

import com.dolswaez.hightone_server.도메인.계정.레포지토리.유저_레포지토리;
import com.dolswaez.hightone_server.도메인.계정.예외.아이디를_찾을_수_없을_경우_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.정보.엔티티.유저_엔티티;
import com.dolswaez.hightone_server.도메인.우정기록부.레포지토리.우정기록_레포지토리;
import com.dolswaez.hightone_server.도메인.우정기록부.레포지토리.우정기록부_레포지토리;
import com.dolswaez.hightone_server.도메인.우정기록부.예외.우정기록부를_찾을_수_없을_떄_발생하는_예외;
import com.dolswaez.hightone_server.도메인.우정기록부.예외.유저를_찾을_수_없을_떄_발생하는_예외;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티.우정기록_엔티티;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티.우정기록부_엔티티;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록_정보;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록부_정보;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class 우정기록부_서비스_구현 implements 우정기록부_서비스 {
    private final 유저_레포지토리 유저_레포지토리;
    private final 우정기록부_레포지토리 우정기록부_레포지토리;
    private final 우정기록_레포지토리 우정기록_레포지토리;

    @Override
    public 우정기록부_정보 우정기록부_게시하기(String 아이디) {
        유저_엔티티 유저 = 유저_가져오기(아이디);
        우정기록부_엔티티 우정기록부 = 우정기록부_저장하기(유저.get인덱스());
        return 우정기록부_엔티티를_정보_전달_객체로_바꾸기(우정기록부);
    }

    @Override
    public 우정기록_정보 우정기록부_작성하기(Long 우정기록부_인덱스, 우정기록_정보 정보) {
        우정기록부_엔티티 우정기록부 = 우정기록부_가져오기(우정기록부_인덱스);
        우정기록_엔티티 우정기록 = 우정기록_정보를_엔티티로_바꾸기(정보, 우정기록부);
        우정기록부.get우정기록().add(우정기록);
        우정기록_레포지토리.save(우정기록);
        우정기록부_레포지토리.save(우정기록부);
        return 우정기록_엔티티를_정보_전달_객체로_바꾸기(우정기록);
    }

    @Override
    public 우정기록부_정보 우정기록부_가져오기(String 아이디) {
        없으면_만들기(아이디);
        Long 게시자_인덱스 = 유저_아이디로_인덱스_가져오기(아이디);
        우정기록부_엔티티 우정기록부 = 우정기록부_레포지토리.getBy게시자인덱스(게시자_인덱스);
        System.out.println(Arrays.toString(우정기록부.get우정기록().toArray()));
        return 우정기록부_엔티티를_정보_전달_객체로_바꾸기(우정기록부);
    }

    @Override
    public void 없으면_만들기(String 아이디) {
        if(!유저_레포지토리.existsBy아이디(아이디)) throw new 유저를_찾을_수_없을_떄_발생하는_예외(아이디);
        Long 게시자_인덱스 = 유저_아이디로_인덱스_가져오기(아이디);
        if(!우정기록부_레포지토리.existsBy게시자인덱스(게시자_인덱스)) 우정기록부_게시하기(아이디);
    }

    private 우정기록부_엔티티 우정기록부_가져오기(Long 우정기록부_인덱스) {
        if(!우정기록부_레포지토리.existsById(우정기록부_인덱스)) throw new 우정기록부를_찾을_수_없을_떄_발생하는_예외(우정기록부_인덱스);
        return 우정기록부_레포지토리.getById(우정기록부_인덱스);
    }

    private 유저_엔티티 유저_가져오기(String 아이디) {
        if(!유저_레포지토리.existsBy아이디(아이디)) throw new 아이디를_찾을_수_없을_경우_발생하는_예외(아이디);
        return 유저_레포지토리.getBy아이디(아이디);
    }

    private Long 유저_아이디로_인덱스_가져오기(String 아이디) {
        return 유저_레포지토리.getBy아이디(아이디).get인덱스();
    }

    private 우정기록부_엔티티 우정기록부_저장하기(Long 인덱스) {
        우정기록부_엔티티 우정기록부 = new 우정기록부_엔티티(0L, 인덱스, new ArrayList<>());
        return 우정기록부_레포지토리.save(우정기록부);
    }

    private 우정기록부_정보 우정기록부_엔티티를_정보_전달_객체로_바꾸기(우정기록부_엔티티 우정기록부) {
        List<우정기록_정보> 우정기록_리스트 = 우정기록부로_우정기록_리스트_가져오기(우정기록부);
        return new 우정기록부_정보(우정기록부.get인덱스(), 우정기록부.get게시자인덱스(), 우정기록_리스트);
    }

    private 우정기록_정보 우정기록_엔티티를_정보_전달_객체로_바꾸기(우정기록_엔티티 우정기록) {
        return new 우정기록_정보(
                우정기록.get인덱스(),
                우정기록.get작성자_이름(),
                우정기록.get성격_리스트(),
                우정기록.get친학수(),
                우정기록.get내꼭해()
        );
    }

    private 우정기록_엔티티 우정기록_정보를_엔티티로_바꾸기(우정기록_정보 정보, 우정기록부_엔티티 우정기록부) {
        return new 우정기록_엔티티(
                정보.인덱스(),
                정보.작성자_이름(),
                우정기록부,
                정보.성격_리스트(),
                정보.친학수(),
                정보.내꼭해()
        );
    }

    private List<우정기록_정보> 우정기록부로_우정기록_리스트_가져오기(우정기록부_엔티티 우정기록부) {
        return 우정기록부.get우정기록().stream().map(엔티티 -> new 우정기록_정보(
                엔티티.get인덱스(),
                엔티티.get작성자_이름(),
                엔티티.get성격_리스트(),
                엔티티.get친학수(),
                엔티티.get내꼭해()
        )).collect(Collectors.toList());
    }
}
