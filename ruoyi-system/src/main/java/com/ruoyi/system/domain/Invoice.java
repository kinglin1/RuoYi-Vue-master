package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单据对象 spark_invoice
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
public class Invoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long invoiceId;

    /** 员工id */
    private Long employeeId;

    /** 员工 */
    @Excel(name = "员工")
    private String employeeName;

    /** 部门 */
    @Excel(name = "部门")
    private String department;

    /** 老板 */
    @Excel(name = "老板")
    private String bossName;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    /** 礼物 */
    @Excel(name = "礼物")
    private Long gift;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payment;

    /** 会员id */
    private Long memberId;

    /** 总金额 */
    @Excel(name = "总金额")
    private Long summoney;

    /** 状态 */
    @Excel(name = "状态")
    private Long staus;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setInvoiceId(Long invoiceId) 
    {
        this.invoiceId = invoiceId;
    }

    public Long getInvoiceId() 
    {
        return invoiceId;
    }
    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setBossName(String bossName) 
    {
        this.bossName = bossName;
    }

    public String getBossName() 
    {
        return bossName;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setGift(Long gift) 
    {
        this.gift = gift;
    }

    public Long getGift() 
    {
        return gift;
    }
    public void setPayment(String payment) 
    {
        this.payment = payment;
    }

    public String getPayment() 
    {
        return payment;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setSummoney(Long summoney) 
    {
        this.summoney = summoney;
    }

    public Long getSummoney() 
    {
        return summoney;
    }
    public void setStaus(Long staus) 
    {
        this.staus = staus;
    }

    public Long getStaus() 
    {
        return staus;
    }
    public void setCompletionTime(Date completionTime) 
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime() 
    {
        return completionTime;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("invoiceId", getInvoiceId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("department", getDepartment())
            .append("bossName", getBossName())
            .append("quantity", getQuantity())
            .append("unitPrice", getUnitPrice())
            .append("gift", getGift())
            .append("payment", getPayment())
            .append("memberId", getMemberId())
            .append("summoney", getSummoney())
            .append("staus", getStaus())
            .append("completionTime", getCompletionTime())
            .append("remarks", getRemarks())
            .toString();
    }
}
