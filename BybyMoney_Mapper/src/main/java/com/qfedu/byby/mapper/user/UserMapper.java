package com.qfedu.byby.mapper.user;

import com.qfedu.byby.domain.user.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insert(User record);
    User selectByName(String name);
    int updatePassword(@Param("id")int id, @Param("password") String password);
    int updateFlag(@Param("id") int id,@Param("flag") int flag);
}