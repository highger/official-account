package com.mgy.official.account.service.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRes<T> {
    private List<T> items;

    private Long total;

    public static <T> PageRes<T> empty() {
        return new PageRes<>(Collections.emptyList(), 0L);
    }

    public static <T> PageRes<T> newInstance(List<T> items, Long total) {
        return new PageRes<>(items, total);
    }
}
