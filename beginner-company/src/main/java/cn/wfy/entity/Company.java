package cn.wfy.entity;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 64)
    private String name;
    @Column(length = 64)
    private String remark;

}
