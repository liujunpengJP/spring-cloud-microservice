package com.itmuch.cloud.microserviceprovideruser.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TUser {

    @TableId(type = IdType.AUTO)//主键自增长
    private Integer id;

    private String userId;

    private String userName;

    private String passWord;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//插入时间类型格式化
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")//查询时间类型格式化
    private Date insertTime;

    private String deleteState;

}