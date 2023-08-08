package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmployeeMapper;
import com.ruoyi.system.domain.Employee;
import com.ruoyi.system.service.IEmployeeService;

/**
 * 员工Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-07
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService 
{
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询员工
     * 
     * @param employeeId 员工主键
     * @return 员工
     */
    @Override
    public Employee selectEmployeeByEmployeeId(Long employeeId)
    {
        return employeeMapper.selectEmployeeByEmployeeId(employeeId);
    }

    /**
     * 查询员工列表
     * 
     * @param employee 员工
     * @return 员工
     */
    @Override
    public List<Employee> selectEmployeeList(Employee employee)
    {
        return employeeMapper.selectEmployeeList(employee);
    }

    /**
     * 新增员工
     * 
     * @param employee 员工
     * @return 结果
     */
    @Override
    public int insertEmployee(Employee employee)
    {
        return employeeMapper.insertEmployee(employee);
    }

    /**
     * 修改员工
     * 
     * @param employee 员工
     * @return 结果
     */
    @Override
    public int updateEmployee(Employee employee)
    {
        return employeeMapper.updateEmployee(employee);
    }

    /**
     * 批量删除员工
     * 
     * @param employeeIds 需要删除的员工主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeByEmployeeIds(Long[] employeeIds)
    {
        return employeeMapper.deleteEmployeeByEmployeeIds(employeeIds);
    }

    /**
     * 删除员工信息
     * 
     * @param employeeId 员工主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeByEmployeeId(Long employeeId)
    {
        return employeeMapper.deleteEmployeeByEmployeeId(employeeId);
    }
}
