package com.project.demo.controller;

import com.project.demo.entity.Rider;
import com.project.demo.service.RiderService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *骑手：(Rider)表控制层
 *
 */
@RestController
@RequestMapping("/rider")
public class RiderController extends BaseController<Rider,RiderService> {

    /**
     *骑手对象
     */
    @Autowired
    public RiderController(RiderService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> maprider_number = new HashMap<>();
        maprider_number.put("rider_number",String.valueOf(paramMap.get("rider_number")));
        List listrider_number = service.select(maprider_number, new HashMap<>()).getResultList();
        if (listrider_number.size()>0){
            return error(30000, "字段骑手编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
