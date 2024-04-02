package com.example.demo.common;

import lombok.Data;

import java.util.HashMap;

@Data
//分页拦截器
public class QueryPageParam {

//    默认值

    private static int PAGE_SIZE=20;
    private static int PAGE_NUM=1;
//    需要值
    private int PageSize=PAGE_SIZE;
    private int PageNum=PAGE_NUM;
    private HashMap param;
}
