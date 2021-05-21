package cn.wfy.entity;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author Devil
 * @create 2018-09-28 15:24
 */
public class User {
    @ApiModelProperty(value="用户名")
    private String name;
    @ApiModelProperty(value="密码")
    private String password;
    @ApiModelProperty(value="性别")
    private String gender;
    @ApiModelProperty(value="年龄")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}