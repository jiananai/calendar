package com.nineton.calendar.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdentificationCodeIsNull() {
            addCriterion("identification_code is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeIsNotNull() {
            addCriterion("identification_code is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeEqualTo(String value) {
            addCriterion("identification_code =", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeNotEqualTo(String value) {
            addCriterion("identification_code <>", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeGreaterThan(String value) {
            addCriterion("identification_code >", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("identification_code >=", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeLessThan(String value) {
            addCriterion("identification_code <", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeLessThanOrEqualTo(String value) {
            addCriterion("identification_code <=", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeLike(String value) {
            addCriterion("identification_code like", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeNotLike(String value) {
            addCriterion("identification_code not like", value, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeIn(List<String> values) {
            addCriterion("identification_code in", values, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeNotIn(List<String> values) {
            addCriterion("identification_code not in", values, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeBetween(String value1, String value2) {
            addCriterion("identification_code between", value1, value2, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andIdentificationCodeNotBetween(String value1, String value2) {
            addCriterion("identification_code not between", value1, value2, "identificationCode");
            return (Criteria) this;
        }

        public Criteria andHaveCoinIsNull() {
            addCriterion("have_coin is null");
            return (Criteria) this;
        }

        public Criteria andHaveCoinIsNotNull() {
            addCriterion("have_coin is not null");
            return (Criteria) this;
        }

        public Criteria andHaveCoinEqualTo(Integer value) {
            addCriterion("have_coin =", value, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinNotEqualTo(Integer value) {
            addCriterion("have_coin <>", value, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinGreaterThan(Integer value) {
            addCriterion("have_coin >", value, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("have_coin >=", value, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinLessThan(Integer value) {
            addCriterion("have_coin <", value, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinLessThanOrEqualTo(Integer value) {
            addCriterion("have_coin <=", value, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinIn(List<Integer> values) {
            addCriterion("have_coin in", values, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinNotIn(List<Integer> values) {
            addCriterion("have_coin not in", values, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinBetween(Integer value1, Integer value2) {
            addCriterion("have_coin between", value1, value2, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andHaveCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("have_coin not between", value1, value2, "haveCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinIsNull() {
            addCriterion("consume_coin is null");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinIsNotNull() {
            addCriterion("consume_coin is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinEqualTo(Integer value) {
            addCriterion("consume_coin =", value, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinNotEqualTo(Integer value) {
            addCriterion("consume_coin <>", value, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinGreaterThan(Integer value) {
            addCriterion("consume_coin >", value, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("consume_coin >=", value, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinLessThan(Integer value) {
            addCriterion("consume_coin <", value, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinLessThanOrEqualTo(Integer value) {
            addCriterion("consume_coin <=", value, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinIn(List<Integer> values) {
            addCriterion("consume_coin in", values, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinNotIn(List<Integer> values) {
            addCriterion("consume_coin not in", values, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinBetween(Integer value1, Integer value2) {
            addCriterion("consume_coin between", value1, value2, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andConsumeCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("consume_coin not between", value1, value2, "consumeCoin");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyIsNull() {
            addCriterion("consume_money is null");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyIsNotNull() {
            addCriterion("consume_money is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyEqualTo(Double value) {
            addCriterion("consume_money =", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyNotEqualTo(Double value) {
            addCriterion("consume_money <>", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyGreaterThan(Double value) {
            addCriterion("consume_money >", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("consume_money >=", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyLessThan(Double value) {
            addCriterion("consume_money <", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyLessThanOrEqualTo(Double value) {
            addCriterion("consume_money <=", value, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyIn(List<Double> values) {
            addCriterion("consume_money in", values, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyNotIn(List<Double> values) {
            addCriterion("consume_money not in", values, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyBetween(Double value1, Double value2) {
            addCriterion("consume_money between", value1, value2, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andConsumeMoneyNotBetween(Double value1, Double value2) {
            addCriterion("consume_money not between", value1, value2, "consumeMoney");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
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