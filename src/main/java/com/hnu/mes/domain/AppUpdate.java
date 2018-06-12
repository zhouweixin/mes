package com.hnu.mes.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:09 2018/6/7
 * @Modified By:
 */
@Entity
@Table(name = "app_update")
public class AppUpdate {
    @Id
    private Integer id;
    private String version;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
