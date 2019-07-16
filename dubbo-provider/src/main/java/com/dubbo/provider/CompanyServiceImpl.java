package com.dubbo.provider;

import com.dubbo.api.CompanyService;

import java.util.HashMap;
import java.util.Map;


public class CompanyServiceImpl implements CompanyService {
    @Override
    public Map<String, String> getCompanyInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("B", "百度");
        map.put("A", "阿里");
        map.put("T", "腾讯");
        return map;
    }
}
