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
@Table(name = "account_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    @Id
    private Long accountId;
    private int sellCode;
    private int number;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getSellCode() {
        return sellCode;
    }

    public void setSellCode(int sellCode) {
        this.sellCode = sellCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
