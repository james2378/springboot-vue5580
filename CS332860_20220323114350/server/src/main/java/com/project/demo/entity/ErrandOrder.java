package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *跑腿订单：(ErrandOrder)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ErrandOrder")
public class ErrandOrder implements Serializable {

    //ErrandOrder编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "errand_order_id")
    private Integer errand_order_id;
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
   // 订单数
   @Basic
    private String number_of_orders;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
