import request from '@/utils/request'

// 查询图片列表
export function listPath(query) {
  return request({
    url: '/system/path/list',
    method: 'get',
    params: query
  })
}

// 查询图片详细
export function getPath(imageId) {
  return request({
    url: '/system/path/' + imageId,
    method: 'get'
  })
}

// 新增图片
export function addPath(data) {
  return request({
    url: '/system/path',
    method: 'post',
    data: data
  })
}

// 修改图片
export function updatePath(data) {
  return request({
    url: '/system/path',
    method: 'put',
    data: data
  })
}

// 删除图片
export function delPath(imageId) {
  return request({
    url: '/system/path/' + imageId,
    method: 'delete'
  })
}
