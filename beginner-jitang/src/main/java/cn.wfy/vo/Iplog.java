package cn.wfy.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
@Entity
@Table(name = "iplog")
public class Iplog {
    @Id
    private Long id;
    @Column(length = 100)
    private String ip;
    private Date date;
    private String soulId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSoulId() {
        return soulId;
    }

    public void setSoulId(String soulId) {
        this.soulId = soulId;
    }

    public Iplog() {

    }

    public Iplog(Long id, String ip, Date date, String soulId) {
        this.id = id;
        this.ip = ip;
        this.date = date;
        this.soulId = soulId;
    }
}
