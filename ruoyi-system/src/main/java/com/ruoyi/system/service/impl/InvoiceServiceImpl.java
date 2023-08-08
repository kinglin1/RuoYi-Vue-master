package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InvoiceMapper;
import com.ruoyi.system.domain.Invoice;
import com.ruoyi.system.service.IInvoiceService;

/**
 * 单据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
@Service
public class InvoiceServiceImpl implements IInvoiceService 
{
    @Autowired
    private InvoiceMapper invoiceMapper;

    /**
     * 查询单据
     * 
     * @param invoiceId 单据主键
     * @return 单据
     */
    @Override
    public Invoice selectInvoiceByInvoiceId(Long invoiceId)
    {
        return invoiceMapper.selectInvoiceByInvoiceId(invoiceId);
    }

    /**
     * 查询单据列表
     * 
     * @param invoice 单据
     * @return 单据
     */
    @Override
    public List<Invoice> selectInvoiceList(Invoice invoice)
    {
        return invoiceMapper.selectInvoiceList(invoice);
    }

    /**
     * 新增单据
     * 
     * @param invoice 单据
     * @return 结果
     */
    @Override
    public int insertInvoice(Invoice invoice)
    {
        return invoiceMapper.insertInvoice(invoice);
    }

    /**
     * 修改单据
     * 
     * @param invoice 单据
     * @return 结果
     */
    @Override
    public int updateInvoice(Invoice invoice)
    {
        return invoiceMapper.updateInvoice(invoice);
    }

    /**
     * 批量删除单据
     * 
     * @param invoiceIds 需要删除的单据主键
     * @return 结果
     */
    @Override
    public int deleteInvoiceByInvoiceIds(Long[] invoiceIds)
    {
        return invoiceMapper.deleteInvoiceByInvoiceIds(invoiceIds);
    }

    /**
     * 删除单据信息
     * 
     * @param invoiceId 单据主键
     * @return 结果
     */
    @Override
    public int deleteInvoiceByInvoiceId(Long invoiceId)
    {
        return invoiceMapper.deleteInvoiceByInvoiceId(invoiceId);
    }
}
