package com.project.demo.controller;

import com.project.demo.entity.DistributionEvaluation;
import com.project.demo.service.DistributionEvaluationService;
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
 *配送评价：(DistributionEvaluation)表控制层
 *
 */
@RestController
@RequestMapping("/distribution_evaluation")
public class DistributionEvaluationController extends BaseController<DistributionEvaluation,DistributionEvaluationService> {

    /**
     *配送评价对象
     */
    @Autowired
    public DistributionEvaluationController(DistributionEvaluationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
