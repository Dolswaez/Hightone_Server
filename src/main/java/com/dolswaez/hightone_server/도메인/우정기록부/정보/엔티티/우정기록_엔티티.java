package com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.종류.성격_종류;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "friendly_record")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class 우정기록_엔티티 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long 인덱스;
    @Column(name = "writer_name")
    private String 작성자_이름;
    @ManyToOne
    @JoinColumn(name = "friendly_records_idx")
    private 우정기록부_엔티티 우정기록부;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Size(min = 1, max = 3)
    private List<성격_종류> 성격_리스트;
    @Column(name = "chs")
    @Length(max = 300)
    private String 친학수;
    @Column(name = "ngh")
    @Length(max = 300)
    private String 내꼭해;
}
