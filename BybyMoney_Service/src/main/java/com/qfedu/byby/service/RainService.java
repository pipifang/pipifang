package com.qfedu.byby.service;


import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.domain.user.Rain;

import java.util.List;

public interface RainService {
    //新增
    ResultBean save(Rain rain);
    //删除
    ResultBean del(int id);
    //查询
    List<Rain> queryAll();
}
