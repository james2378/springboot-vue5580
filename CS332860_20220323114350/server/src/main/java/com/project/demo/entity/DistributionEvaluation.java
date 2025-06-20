package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *配送评价：(DistributionEvaluation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DistributionEvaluation")
public class DistributionEvaluation implements Serializable {

    //DistributionEvaluation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distribution_evaluation_id")
    private Integer distribution_evaluation_id;
   // 订单编号
   @Basic
    private String order_number;
   // 物品名称
   @Basic
    private String item_name;
   // 收货人
   @Basic
    private Integer consignee;
   // 姓名
   @Basic
    private String full_name;
   // 骑手编号
   @Basic
    private Integer rider_number;
   // 骑手姓名
   @Basic
    private String rider_name;
   // 配送状态
   @Basic
    private String distribution_status;
   // 骑手评分
   @Basic
    private String rider_rating;
   // 评价内容
   @Basic
    private String evaluation_content;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
