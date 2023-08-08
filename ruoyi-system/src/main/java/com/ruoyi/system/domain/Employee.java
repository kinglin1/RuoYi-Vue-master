package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工对象 spark_employee
 * 
 * @author ruoyi
 * @date 2023-08-07
 */
public class Employee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long employeeId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 账号 */
    @Excel(name = "账号")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    /** 工资 */
    @Excel(name = "工资")
    private BigDecimal wage;

    /** 分类 */
    @Excel(name = "分类")
    private String employeeCategory;

    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setWage(BigDecimal wage) 
    {
        this.wage = wage;
    }

    public BigDecimal getWage() 
    {
        return wage;
    }
    public void setEmployeeCategory(String employeeCategory) 
    {
        this.employeeCategory = employeeCategory;
    }

    public String getEmployeeCategory() 
    {
        return employeeCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("employeeId", getEmployeeId())
            .append("name", getName())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("unitPrice", getUnitPrice())
            .append("wage", getWage())
            .append("employeeCategory", getEmployeeCategory())
            .toString();
    }
}
