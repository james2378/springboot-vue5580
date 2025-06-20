package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *顾客：(Customer)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Customer")
public class Customer implements Serializable {

    //Customer编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customer_id;
   // 姓名
   @Basic
    private String full_name;
   // 性别
   @Basic
    private String gender;
   // 个人介绍
   @Basic
    private String personal_introduction;
    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
