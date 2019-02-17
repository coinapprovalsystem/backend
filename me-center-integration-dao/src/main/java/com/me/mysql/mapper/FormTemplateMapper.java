package com.me.mysql.mapper;

import com.me.mysql.domain.FormTemplate;
import com.me.mysql.domain.FormTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FormTemplateMapper {
    long countByExample(FormTemplateExample example);

    int deleteByExample(FormTemplateExample example);

    int deleteByPrimaryKey(Integer templateID);

    int insert(FormTemplate record);

    int insertSelective(FormTemplate record);

    List<FormTemplate> selectByExample(FormTemplateExample example);

    FormTemplate selectByPrimaryKey(Integer templateID);

    int updateByExampleSelective(@Param("record") FormTemplate record, @Param("example") FormTemplateExample example);

    int updateByExample(@Param("record") FormTemplate record, @Param("example") FormTemplateExample example);

    int updateByPrimaryKeySelective(FormTemplate record);

    int updateByPrimaryKey(FormTemplate record);
}