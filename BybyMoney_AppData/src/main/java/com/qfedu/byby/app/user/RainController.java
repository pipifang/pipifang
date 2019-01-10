package com.qfedu.byby.app.user;

import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.domain.user.Rain;
import com.qfedu.byby.service.RainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RainController {
    @Autowired
    private RainService service;
    @PostMapping("/save")
   public ResultBean save(Rain rain) {
      return service.save(rain);
   }

   @RequestMapping("/delById")
   public ResultBean delById(int id) {
        return service.del(id);
   }

   @GetMapping("/getAall")
   public List<Rain> queryAll(){
        return service.queryAll();
   }

}