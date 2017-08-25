package com.phoebe.service.impl;

import com.phoebe.dao.ServerDao;
import com.phoebe.model.Server;
import com.phoebe.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phoebegl on 2017/8/23.
 */
@Service
public class ServerServiceImpl implements ServerService{

    @Autowired
    private ServerDao dao;

    public int insert(Server record) {
        return dao.insert(record);
    }

    public Server select(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    public int update(Server record) {
        return dao.update(record);
    }

    public List<Server> selectAll() {
        return dao.selectAll();
    }
}
