package com.phoebe.model;

import java.util.Date;

public class Template {
    private Integer id;

    private Integer controller_server_id;

    private String subscribe_staff_id;

    private Date update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getController_server_id() {
        return controller_server_id;
    }

    public void setController_server_id(Integer controller_server_id) {
        this.controller_server_id = controller_server_id;
    }

    public String getSubscribe_staff_id() {
        return subscribe_staff_id;
    }

    public void setSubscribe_staff_id(String subscribe_staff_id) {
        this.subscribe_staff_id = subscribe_staff_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}