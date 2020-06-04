package com.devin.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String driver_class_name;
    private String conn_url;
    private String username;
    private String password;

    // 用于书写获取复杂对象的代码

    public Connection getObject() throws Exception {
        Class.forName(driver_class_name);
        Connection conn = DriverManager.getConnection(conn_url, username, password);
        return conn;
    }
    // 返回所创建复杂对象的class

    public Class<?> getObjectType() {
        return Connection.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public String getDriver_class_name() {
        return driver_class_name;
    }

    public void setDriver_class_name(String driver_class_name) {
        this.driver_class_name = driver_class_name;
    }

    public String getConn_url() {
        return conn_url;
    }

    public void setConn_url(String conn_url) {
        this.conn_url = conn_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
