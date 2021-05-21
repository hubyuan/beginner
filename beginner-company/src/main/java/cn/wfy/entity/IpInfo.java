package cn.wfy.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ip_info")
public class IpInfo {

    @Id
    private Long id;

    @Column(length = 64)
    private String ip;

    private Date onlineTime;

    @Column(length = 64)
    private String ttl;

    @Column(length = 64)
    private String responseTime;

    private Long companyId;

}
