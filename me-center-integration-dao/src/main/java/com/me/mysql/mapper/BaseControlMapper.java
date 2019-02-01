package com.me.mysql.mapper;

import com.me.mysql.domain.BaseControl;
import com.me.mysql.domain.BaseControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseControlMapper {
    long countByExample(BaseControlExample example);

    int deleteByExample(BaseControlExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(BaseControl record);

    int insertSelective(BaseControl record);

    List<BaseControl> selectByExample(BaseControlExample example);

    BaseControl selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") BaseControl record, @Param("example") BaseControlExample example);

    int updateByExample(@Param("record") BaseControl record, @Param("example") BaseControlExample example);

    int updateByPrimaryKeySelective(BaseControl record);

    int updateByPrimaryKey(BaseControl record);
}