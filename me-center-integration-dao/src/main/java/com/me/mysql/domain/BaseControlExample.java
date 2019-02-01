package com.me.mysql.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BaseControlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseControlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andTemplateIDIsNull() {
            addCriterion("templateID is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIDIsNotNull() {
            addCriterion("templateID is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIDEqualTo(Integer value) {
            addCriterion("templateID =", value, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDNotEqualTo(Integer value) {
            addCriterion("templateID <>", value, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDGreaterThan(Integer value) {
            addCriterion("templateID >", value, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("templateID >=", value, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDLessThan(Integer value) {
            addCriterion("templateID <", value, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDLessThanOrEqualTo(Integer value) {
            addCriterion("templateID <=", value, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDIn(List<Integer> values) {
            addCriterion("templateID in", values, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDNotIn(List<Integer> values) {
            addCriterion("templateID not in", values, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDBetween(Integer value1, Integer value2) {
            addCriterion("templateID between", value1, value2, "templateID");
            return (Criteria) this;
        }

        public Criteria andTemplateIDNotBetween(Integer value1, Integer value2) {
            addCriterion("templateID not between", value1, value2, "templateID");
            return (Criteria) this;
        }

        public Criteria andLabelNameIsNull() {
            addCriterion("labelName is null");
            return (Criteria) this;
        }

        public Criteria andLabelNameIsNotNull() {
            addCriterion("labelName is not null");
            return (Criteria) this;
        }

        public Criteria andLabelNameEqualTo(String value) {
            addCriterion("labelName =", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotEqualTo(String value) {
            addCriterion("labelName <>", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameGreaterThan(String value) {
            addCriterion("labelName >", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameGreaterThanOrEqualTo(String value) {
            addCriterion("labelName >=", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameLessThan(String value) {
            addCriterion("labelName <", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameLessThanOrEqualTo(String value) {
            addCriterion("labelName <=", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameLike(String value) {
            addCriterion("labelName like", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotLike(String value) {
            addCriterion("labelName not like", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameIn(List<String> values) {
            addCriterion("labelName in", values, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotIn(List<String> values) {
            addCriterion("labelName not in", values, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameBetween(String value1, String value2) {
            addCriterion("labelName between", value1, value2, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotBetween(String value1, String value2) {
            addCriterion("labelName not between", value1, value2, "labelName");
            return (Criteria) this;
        }

        public Criteria andControlIDIsNull() {
            addCriterion("controlID is null");
            return (Criteria) this;
        }

        public Criteria andControlIDIsNotNull() {
            addCriterion("controlID is not null");
            return (Criteria) this;
        }

        public Criteria andControlIDEqualTo(Integer value) {
            addCriterion("controlID =", value, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDNotEqualTo(Integer value) {
            addCriterion("controlID <>", value, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDGreaterThan(Integer value) {
            addCriterion("controlID >", value, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("controlID >=", value, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDLessThan(Integer value) {
            addCriterion("controlID <", value, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDLessThanOrEqualTo(Integer value) {
            addCriterion("controlID <=", value, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDIn(List<Integer> values) {
            addCriterion("controlID in", values, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDNotIn(List<Integer> values) {
            addCriterion("controlID not in", values, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDBetween(Integer value1, Integer value2) {
            addCriterion("controlID between", value1, value2, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlIDNotBetween(Integer value1, Integer value2) {
            addCriterion("controlID not between", value1, value2, "controlID");
            return (Criteria) this;
        }

        public Criteria andControlTypeIsNull() {
            addCriterion("controlType is null");
            return (Criteria) this;
        }

        public Criteria andControlTypeIsNotNull() {
            addCriterion("controlType is not null");
            return (Criteria) this;
        }

        public Criteria andControlTypeEqualTo(String value) {
            addCriterion("controlType =", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotEqualTo(String value) {
            addCriterion("controlType <>", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThan(String value) {
            addCriterion("controlType >", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("controlType >=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThan(String value) {
            addCriterion("controlType <", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThanOrEqualTo(String value) {
            addCriterion("controlType <=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLike(String value) {
            addCriterion("controlType like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotLike(String value) {
            addCriterion("controlType not like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeIn(List<String> values) {
            addCriterion("controlType in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotIn(List<String> values) {
            addCriterion("controlType not in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeBetween(String value1, String value2) {
            addCriterion("controlType between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotBetween(String value1, String value2) {
            addCriterion("controlType not between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlValueIsNull() {
            addCriterion("controlValue is null");
            return (Criteria) this;
        }

        public Criteria andControlValueIsNotNull() {
            addCriterion("controlValue is not null");
            return (Criteria) this;
        }

        public Criteria andControlValueEqualTo(String value) {
            addCriterion("controlValue =", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueNotEqualTo(String value) {
            addCriterion("controlValue <>", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueGreaterThan(String value) {
            addCriterion("controlValue >", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueGreaterThanOrEqualTo(String value) {
            addCriterion("controlValue >=", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueLessThan(String value) {
            addCriterion("controlValue <", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueLessThanOrEqualTo(String value) {
            addCriterion("controlValue <=", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueLike(String value) {
            addCriterion("controlValue like", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueNotLike(String value) {
            addCriterion("controlValue not like", value, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueIn(List<String> values) {
            addCriterion("controlValue in", values, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueNotIn(List<String> values) {
            addCriterion("controlValue not in", values, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueBetween(String value1, String value2) {
            addCriterion("controlValue between", value1, value2, "controlValue");
            return (Criteria) this;
        }

        public Criteria andControlValueNotBetween(String value1, String value2) {
            addCriterion("controlValue not between", value1, value2, "controlValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("defaultValue is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("defaultValue is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("defaultValue =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("defaultValue <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("defaultValue >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("defaultValue >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("defaultValue <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("defaultValue <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("defaultValue like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("defaultValue not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("defaultValue in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("defaultValue not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("defaultValue between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("defaultValue not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andPropsIsNull() {
            addCriterion("props is null");
            return (Criteria) this;
        }

        public Criteria andPropsIsNotNull() {
            addCriterion("props is not null");
            return (Criteria) this;
        }

        public Criteria andPropsEqualTo(String value) {
            addCriterion("props =", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotEqualTo(String value) {
            addCriterion("props <>", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThan(String value) {
            addCriterion("props >", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThanOrEqualTo(String value) {
            addCriterion("props >=", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLessThan(String value) {
            addCriterion("props <", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLessThanOrEqualTo(String value) {
            addCriterion("props <=", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLike(String value) {
            addCriterion("props like", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotLike(String value) {
            addCriterion("props not like", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsIn(List<String> values) {
            addCriterion("props in", values, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotIn(List<String> values) {
            addCriterion("props not in", values, "props");
            return (Criteria) this;
        }

        public Criteria andPropsBetween(String value1, String value2) {
            addCriterion("props between", value1, value2, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotBetween(String value1, String value2) {
            addCriterion("props not between", value1, value2, "props");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNull() {
            addCriterion("options is null");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsEqualTo(String value) {
            addCriterion("options =", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotEqualTo(String value) {
            addCriterion("options <>", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThan(String value) {
            addCriterion("options >", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("options >=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThan(String value) {
            addCriterion("options <", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThanOrEqualTo(String value) {
            addCriterion("options <=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLike(String value) {
            addCriterion("options like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotLike(String value) {
            addCriterion("options not like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsIn(List<String> values) {
            addCriterion("options in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotIn(List<String> values) {
            addCriterion("options not in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsBetween(String value1, String value2) {
            addCriterion("options between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotBetween(String value1, String value2) {
            addCriterion("options not between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andPlaceholderIsNull() {
            addCriterion("placeholder is null");
            return (Criteria) this;
        }

        public Criteria andPlaceholderIsNotNull() {
            addCriterion("placeholder is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceholderEqualTo(String value) {
            addCriterion("placeholder =", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotEqualTo(String value) {
            addCriterion("placeholder <>", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderGreaterThan(String value) {
            addCriterion("placeholder >", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderGreaterThanOrEqualTo(String value) {
            addCriterion("placeholder >=", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderLessThan(String value) {
            addCriterion("placeholder <", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderLessThanOrEqualTo(String value) {
            addCriterion("placeholder <=", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderLike(String value) {
            addCriterion("placeholder like", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotLike(String value) {
            addCriterion("placeholder not like", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderIn(List<String> values) {
            addCriterion("placeholder in", values, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotIn(List<String> values) {
            addCriterion("placeholder not in", values, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderBetween(String value1, String value2) {
            addCriterion("placeholder between", value1, value2, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotBetween(String value1, String value2) {
            addCriterion("placeholder not between", value1, value2, "placeholder");
            return (Criteria) this;
        }

        public Criteria andReadOnlyIsNull() {
            addCriterion("readOnly is null");
            return (Criteria) this;
        }

        public Criteria andReadOnlyIsNotNull() {
            addCriterion("readOnly is not null");
            return (Criteria) this;
        }

        public Criteria andReadOnlyEqualTo(Boolean value) {
            addCriterion("readOnly =", value, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyNotEqualTo(Boolean value) {
            addCriterion("readOnly <>", value, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyGreaterThan(Boolean value) {
            addCriterion("readOnly >", value, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("readOnly >=", value, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyLessThan(Boolean value) {
            addCriterion("readOnly <", value, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyLessThanOrEqualTo(Boolean value) {
            addCriterion("readOnly <=", value, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyIn(List<Boolean> values) {
            addCriterion("readOnly in", values, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyNotIn(List<Boolean> values) {
            addCriterion("readOnly not in", values, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyBetween(Boolean value1, Boolean value2) {
            addCriterion("readOnly between", value1, value2, "readOnly");
            return (Criteria) this;
        }

        public Criteria andReadOnlyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("readOnly not between", value1, value2, "readOnly");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("required is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("required is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(Boolean value) {
            addCriterion("required =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(Boolean value) {
            addCriterion("required <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(Boolean value) {
            addCriterion("required >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("required >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(Boolean value) {
            addCriterion("required <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(Boolean value) {
            addCriterion("required <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<Boolean> values) {
            addCriterion("required in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<Boolean> values) {
            addCriterion("required not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(Boolean value1, Boolean value2) {
            addCriterion("required between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("required not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("createUser =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("createUser <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("createUser >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("createUser >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("createUser <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("createUser <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("createUser like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("createUser not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("createUser in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("createUser not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("createUser between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("createUser not between", value1, value2, "createUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}