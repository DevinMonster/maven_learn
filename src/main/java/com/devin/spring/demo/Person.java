package com.devin.spring.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    private Integer id;
    private String name;
    private String[] emails;
    private List<String> phone_nums;
    private Set<Integer> codes;
    private Map<Integer,String> qqs;
    private Properties p;

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public Map<Integer, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<Integer, String> qqs) {
        this.qqs = qqs;
    }

    public Set<Integer> getCodes() {
        return codes;
    }

    public void setCodes(Set<Integer> codes) {
        this.codes = codes;
    }

    public List<String> getPhone_nums() {
        return phone_nums;
    }

    public void setPhone_nums(List<String> phone_nums) {
        this.phone_nums = phone_nums;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
