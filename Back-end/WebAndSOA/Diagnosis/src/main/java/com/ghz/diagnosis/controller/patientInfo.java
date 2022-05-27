package com.ghz.diagnosis.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: Gu HungJou
 * @date: 2022/5/14 16:02
 * Describe:
 */

@FeignClient("manageuser-service") // nacos 服务 id
public interface patientInfo {
    @GetMapping("getPatientInfo/{id}")
    public Object getPatientInfo(@PathVariable String id, HttpServletResponse response);
}

