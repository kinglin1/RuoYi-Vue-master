import request from '@/utils/request'

// 查询单据列表
export function listInvoice(query) {
  return request({
    url: '/system/invoice/list',
    method: 'get',
    params: query
  })
}

// 查询单据详细
export function getInvoice(invoiceId) {
  return request({
    url: '/system/invoice/' + invoiceId,
    method: 'get'
  })
}

// 新增单据
export function addInvoice(data) {
  return request({
    url: '/system/invoice',
    method: 'post',
    data: data
  })
}

// 修改单据
export function updateInvoice(data) {
  return request({
    url: '/system/invoice',
    method: 'put',
    data: data
  })
}

// 删除单据
export function delInvoice(invoiceId) {
  return request({
    url: '/system/invoice/' + invoiceId,
    method: 'delete'
  })
}
