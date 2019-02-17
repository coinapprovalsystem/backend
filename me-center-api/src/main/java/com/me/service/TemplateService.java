package com.me.service;

import com.me.mysql.domain.FormTemplate;
import com.me.mysql.domain.FormTemplateExample;
import com.me.mysql.mapper.FormTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    private FormTemplateMapper formTemplateMapper;

    public List<FormTemplate> templateListByCompany(String company) {
        FormTemplateExample formTemplateExample = new FormTemplateExample();
        FormTemplateExample.Criteria criteria = formTemplateExample.createCriteria();
        criteria.andCompanyEqualTo(company);
        formTemplateExample.setOrderByClause("templateID asc");
        return formTemplateMapper.selectByExample(formTemplateExample);
    }
}
