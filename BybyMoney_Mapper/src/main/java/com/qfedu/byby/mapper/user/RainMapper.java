package com.qfedu.byby.mapper.user;

import com.qfedu.byby.domain.user.Rain;

public interface RainMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Rain record);

    Rain selectAll();

}