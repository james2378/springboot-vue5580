package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *配送信息：(DistributionInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DistributionInformation")
public class DistributionInformation implements Serializable {

    //DistributionInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distribution_information_id")
    private Integer distribution_information_id;
   // 订单编号
   @Basic
    private String order_number;
   // 物品名称
   @Basic
    private String item_name;
   // 物品类型
   @Basic
    private String item_type;
   // 代送地址
   @Basic
    private String delivery_address;
   // 物品重量
   @Basic
    private String article_weight;
   // 跑腿费用
   @Basic
    private String running_expenses;
   // 收货人
   @Basic
    private Integer consignee;
   // 姓名
   @Basic
    private String full_name;
   // 联系方式
   @Basic
    private String contact_information;
   // 骑手编号
   @Basic
    private Integer rider_number;
   // 骑手姓名
   @Basic
    private String rider_name;
   // 配送状态
   @Basic
    private String distribution_status;
   // 接单数量
   @Basic
    private String order_receiving_quantity;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
