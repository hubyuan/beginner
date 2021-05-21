package cn.wfy.netty.test;

import cn.wfy.annontation.ValidateAge;

public class User {
    @ValidateAge
    private Integer age;
    private String name;
    private Integer id;

    public User() {
    }

    public User(Integer age, String name, Integer id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
