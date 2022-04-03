package com.ssafy.tnt.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Table(name="User", uniqueConstraints = {@UniqueConstraint(
        name = "USERID_UNIQUE",
        columnNames = {"userId"} ),
        @UniqueConstraint(name="EMAIL_UNIQUE", columnNames = {"email"})})
public class User extends BaseTimeEntity{
    private String name;
    private String userId;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private LocalDate birth;
    @Column(columnDefinition = "varchar(1) default 'U'")
    private String Role;
}
