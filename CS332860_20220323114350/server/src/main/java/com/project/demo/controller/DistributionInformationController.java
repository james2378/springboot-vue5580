package com.project.demo.controller;

import com.project.demo.entity.DistributionInformation;
import com.project.demo.service.DistributionInformationService;
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
 *配送信息：(DistributionInformation)表控制层
 *
 */
@RestController
@RequestMapping("/distribution_information")
public class DistributionInformationController extends BaseController<DistributionInformation,DistributionInformationService> {

    /**
     *配送信息对象
     */
    @Autowired
    public DistributionInformationController(DistributionInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(distribution_information_id) AS max FROM "+"distribution_information";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `errand_order` INNER JOIN `distribution_information` ON errand_order.order_number=distribution_information.order_number WHERE errand_order.number_of_orders &#60; distribution_information.order_receiving_quantity AND distribution_information.distribution_information_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"distribution_information"+" WHERE "+"distribution_information_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"订单已被抢走!");
        }
        sql = "UPDATE `errand_order` INNER JOIN `distribution_information` ON errand_order.order_number=distribution_information.order_number SET errand_order.number_of_orders = errand_order.number_of_orders - distribution_information.order_receiving_quantity WHERE distribution_information.distribution_information_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
