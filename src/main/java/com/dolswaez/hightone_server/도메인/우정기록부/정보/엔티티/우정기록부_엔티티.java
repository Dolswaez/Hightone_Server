package com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "friendly_records")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class 우정기록부_엔티티 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long 인덱스;
    @Column(name = "owner_idx")
    private Long 게시자인덱스;
    @OneToMany(mappedBy = "우정기록부")
    List<우정기록_엔티티> 우정기록;
}
