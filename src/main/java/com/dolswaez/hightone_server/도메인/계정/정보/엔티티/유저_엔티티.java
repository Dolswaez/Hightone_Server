package com.dolswaez.hightone_server.도메인.계정.정보.엔티티;

import com.dolswaez.hightone_server.도메인.계정.정보.종류.학교종류;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class 유저_엔티티 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long 인덱스;
    @Column(name = "name") @Length(max = 10)
    private String 이름;
    @Column(name = "id") @Length(max = 20)
    private String 아이디;
    @Column(name = "encrypted_password") @Length(max = 255)
    private String 암호화된_비밀번호;
    @Column(name = "email") @Length(max = 50)
    private String 이메일;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "school_type")
    private 학교종류 학교;
    @Column(name = "grade")
    private Integer 학년;
    @Column(name = "class")
    private Integer 반;
    @Column(name = "number")
    private Integer 번호;
}
