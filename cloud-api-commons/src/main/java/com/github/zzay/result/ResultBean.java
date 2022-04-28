package com.github.zzay.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzay
 * @className ResultBean
 * @description Result Bean
 * @create 2022/04/28 19:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> {

    /**
     * Code
     */
    private Integer code;

    /**
     * Message
     */
    private String msg;

    /**
     * Data
     */
    private T data;

    /**
     * Constructor with two parameters
     *
     * @param code Code
     * @param msg  Message
     */
    public ResultBean(Integer code, String msg) {
        this(code, msg, null);
    }

}
