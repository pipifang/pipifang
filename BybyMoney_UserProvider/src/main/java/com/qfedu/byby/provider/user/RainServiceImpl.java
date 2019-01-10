package com.qfedu.byby.provider.user;

import com.qfedu.byby.common.util.ResultUtil;
import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.domain.user.Rain;
import com.qfedu.byby.mapper.user.RainMapper;
import com.qfedu.byby.service.RainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RainServiceImpl implements RainService {
    @Autowired
    private RainMapper mapper;

    @Override
    public ResultBean save(Rain rain) {
        ResultBean rb= ResultUtil.execOp(mapper.insert(rain),"信息增加");
        return rb;
    }

    @Override
    public ResultBean del(int id) {
        ResultBean rb= ResultUtil.execOp(mapper.deleteByPrimaryKey(id),"信息");
        return rb;
    }

    @Override
    public List<Rain> queryAll() {
        return (List<Rain>) mapper.selectAll();
    }
}
