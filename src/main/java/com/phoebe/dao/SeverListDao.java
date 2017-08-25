package com.phoebe.dao;

import com.phoebe.model.SeverList;
import org.springframework.stereotype.Repository;

@Repository
public interface SeverListDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SeverList record);

    SeverList selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SeverList record);
}