package cn.wfy.optionalTest;

import java.util.Date;

/***
 *
 * @Description Person
 * @Author wfy
 * @Date 2021/6/3 18:04
 */
public class Person {
    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
