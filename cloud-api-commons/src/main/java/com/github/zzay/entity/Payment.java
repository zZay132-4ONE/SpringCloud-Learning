package com.github.zzay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zzay
 * @className Payment
 * @description Payment实体类
 * @create 2022/04/28 19:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * Payment serial number
     */
    private String serial;

}
