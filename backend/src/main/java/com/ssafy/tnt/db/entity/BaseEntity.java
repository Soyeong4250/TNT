package com.ssafy.tnt.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class BaseEntity {
    /**
     * 공통적으로 사용하는 id 정의
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

}
