package com.phoebe.service;

import com.phoebe.model.Server;

import java.util.List;

/**
 * Created by phoebegl on 2017/8/23.
 */
public interface ServerService {

    int insert(Server record);

    Server select(Integer id);

    int update(Server record);

    List<Server> selectAll();
}
