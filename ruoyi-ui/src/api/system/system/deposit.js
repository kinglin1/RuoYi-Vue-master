import request from '@/utils/request'

// 查询会员列表
export function listDeposit(query) {
  return request({
    url: '/system/deposit/list',
    method: 'get',
    params: query
  })
}

// 查询会员详细
export function getDeposit(depositId) {
  return request({
    url: '/system/deposit/' + depositId,
    method: 'get'
  })
}

// 新增会员
export function addDeposit(data) {
  return request({
    url: '/system/deposit',
    method: 'post',
    data: data
  })
}

// 修改会员
export function updateDeposit(data) {
  return request({
    url: '/system/deposit',
    method: 'put',
    data: data
  })
}

// 删除会员
export function delDeposit(depositId) {
  return request({
    url: '/system/deposit/' + depositId,
    method: 'delete'
  })
}
