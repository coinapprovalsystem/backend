package com.me.controller;

import com.me.auth.annotation.SkipAuthentication;
import com.me.mysql.domain.FormTemplate;
import com.me.service.TemplateService;
import com.me.spring.web.handler.annotation.MorphedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * login controller
 *
 * @author zhaohaojie
 * @date 2018-12-29 14:15
 */
@RestController
@MorphedResponse
@RequestMapping(value = "/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/list")
    @SkipAuthentication
    public List<FormTemplate> templateList() {
        return templateService.templateListByCompany("maxwell");
    }
}

