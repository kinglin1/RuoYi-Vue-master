import request from '@/utils/request'

// 查询会员余额列表
export function listMember(query) {
  return request({
    url: '/system/member/list',
    method: 'get',
    params: query
  })
}

// 查询会员余额详细
export function getMember(memberId) {
  return request({
    url: '/system/member/' + memberId,
    method: 'get'
  })
}

// 新增会员余额
export function addMember(data) {
  return request({
    url: '/system/member',
    method: 'post',
    data: data
  })
}

// 修改会员余额
export function updateMember(data) {
  return request({
    url: '/system/member',
    method: 'put',
    data: data
  })
}

// 删除会员余额
export function delMember(memberId) {
  return request({
    url: '/system/member/' + memberId,
    method: 'delete'
  })
}
