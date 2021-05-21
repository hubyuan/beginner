package cn.wfy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/26
 */
@Entity
@Table(name = "shares")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shares {

    //代号
    @Id
    private Integer code;

    //名字
    private String name;

    //bp 买入
    private double bp;

    //sp 卖出
    private double sp;

    //cp 前一成交价
    private double cp;

    //np 现在成交价
    private double np;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getNp() {
        return np;
    }

    public void setNp(double np) {
        this.np = np;
    }


}
