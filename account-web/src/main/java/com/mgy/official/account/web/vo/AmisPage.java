package com.mgy.official.account.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmisPage<T> {

    private List<T> items;

    private Long total;

    public static <T> AmisPage<T> empty(){
        return new AmisPage<>(Collections.emptyList(), 0L);
    }

    public static <T> AmisPage<T> newInstance(List<T> items, Long total){
        return new AmisPage<>(items, total);
    }
}
