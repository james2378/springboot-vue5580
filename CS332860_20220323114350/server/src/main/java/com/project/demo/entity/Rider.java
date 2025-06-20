package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *骑手：(Rider)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Rider")
public class Rider implements Serializable {

    //Rider编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rider_id")
    private Integer rider_id;
   // 骑手编号
   @Basic
    private String rider_number;
   // 骑手姓名
   @Basic
    private String rider_name;
   // 性别
   @Basic
    private String gender;
   // 身份证
   @Basic
    private String id;
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
