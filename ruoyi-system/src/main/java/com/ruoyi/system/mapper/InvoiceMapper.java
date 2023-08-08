package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Invoice;

/**
 * 单据Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
public interface InvoiceMapper 
{
    /**
     * 查询单据
     * 
     * @param invoiceId 单据主键
     * @return 单据
     */
    public Invoice selectInvoiceByInvoiceId(Long invoiceId);

    /**
     * 查询单据列表
     * 
     * @param invoice 单据
     * @return 单据集合
     */
    public List<Invoice> selectInvoiceList(Invoice invoice);

    /**
     * 新增单据
     * 
     * @param invoice 单据
     * @return 结果
     */
    public int insertInvoice(Invoice invoice);

    /**
     * 修改单据
     * 
     * @param invoice 单据
     * @return 结果
     */
    public int updateInvoice(Invoice invoice);

    /**
     * 删除单据
     * 
     * @param invoiceId 单据主键
     * @return 结果
     */
    public int deleteInvoiceByInvoiceId(Long invoiceId);

    /**
     * 批量删除单据
     * 
     * @param invoiceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInvoiceByInvoiceIds(Long[] invoiceIds);
}
