package com.dolswaez.hightone_server.인프라.메일.서비스;

import com.dolswaez.hightone_server.인프라.메일.예외.메일_송신에_실패했을_때_발생하는_예외;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class 구글_메일_송신_서비스 implements 메일_송신_서비스 {
    private final JavaMailSender 자바_메일_송신기;
    private final TemplateEngine 템플릿_엔진;

    @Override
    public void 메일_보내기(String 이메일, String 메일_제목, String 메일_내용_위치, Map<String, String> 이메일_모델값) {
        String 내용 = 내용_가져오기(메일_내용_위치, 이메일_모델값);
        MimeMessage 메세지 = 메세지_가져오기(이메일, 메일_제목, 내용);
        
        자바_메일_송신기.send(메세지);
    }

    private MimeMessage 메세지_가져오기(String 이메일, String 메일_제목, String 내용) {
        MimeMessage 메세지 = 자바_메일_송신기.createMimeMessage();
        MimeMessageHelper 메세지_생성기;
        try {
            메세지_생성기 = new MimeMessageHelper(메세지, true);
            메세지_생성기.setSubject(메일_제목);
            메세지_생성기.setTo(이메일);
            메세지_생성기.setText(내용, true);
        } catch (MessagingException e) { throw new 메일_송신에_실패했을_때_발생하는_예외(e); }
        return 메세지;
    }

    private String 내용_가져오기(String 메일_내용_위치, Map<String, String> 이메일_모델값) {
        Context 컨텍스트 = new Context();
        이메일_모델값.forEach(컨텍스트::setVariable);
        return 템플릿_엔진.process(메일_내용_위치, 컨텍스트);
    }
}
