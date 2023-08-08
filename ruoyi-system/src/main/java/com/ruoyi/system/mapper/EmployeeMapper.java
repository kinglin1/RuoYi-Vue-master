package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Employee;

/**
 * 员工Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-07
 */
public interface EmployeeMapper 
{
    /**
     * 查询员工
     * 
     * @param employeeId 员工主键
     * @return 员工
     */
    public Employee selectEmployeeByEmployeeId(Long employeeId);

    /**
     * 查询员工列表
     * 
     * @param employee 员工
     * @return 员工集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增员工
     * 
     * @param employee 员工
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改员工
     * 
     * @param employee 员工
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 删除员工
     * 
     * @param employeeId 员工主键
     * @return 结果
     */
    public int deleteEmployeeByEmployeeId(Long employeeId);

    /**
     * 批量删除员工
     * 
     * @param employeeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmployeeByEmployeeIds(Long[] employeeIds);
}
