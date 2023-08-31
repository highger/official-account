package com.mgy.official.account.service.impl;

import com.mgy.official.account.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Service
public class TestService implements ITestService {

    @Override
    public int getCount() {
        return 2;
    }
}
