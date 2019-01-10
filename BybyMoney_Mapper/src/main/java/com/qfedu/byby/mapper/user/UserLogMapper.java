package com.qfedu.byby.mapper.user;
import com.qfedu.byby.domain.user.UserLog;

import java.util.List;

public interface UserLogMapper {
    int insert(UserLog record);

    List<UserLog> selectAll();
}