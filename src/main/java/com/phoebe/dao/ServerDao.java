package com.phoebe.dao;

import com.phoebe.model.Server;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerDao {

    int delete(Integer id);

    int insert(Server record);

    Server selectByPrimaryKey(Integer id);

    int update(Server record);

    List<Server> selectAll();
}