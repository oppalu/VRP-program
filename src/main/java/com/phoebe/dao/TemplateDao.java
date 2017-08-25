package com.phoebe.dao;

import com.phoebe.model.Template;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Template record);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Template record);
}