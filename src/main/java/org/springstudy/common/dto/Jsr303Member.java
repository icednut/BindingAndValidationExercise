package org.springstudy.common.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springstudy.common.annotation.NotEmail;

import javax.validation.constraints.Min;

/**
 * @author wangeun.lee@sk.com
 */
public class Jsr303Member {
    private int id;

    @Min(0)
    private int age;

    @NotEmpty
    private String name;

    @NotEmail(groups = {HelloImpl.class})
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Jsr303Member{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
