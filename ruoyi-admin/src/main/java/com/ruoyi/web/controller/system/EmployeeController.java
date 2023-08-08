package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Employee;
import com.ruoyi.system.service.IEmployeeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工Controller
 * 
 * @author ruoyi
 * @date 2023-08-07
 */
@RestController
@RequestMapping("/system/employee")
public class EmployeeController extends BaseController
{
    @Autowired
    private IEmployeeService employeeService;

    /**
     * 查询员工列表
     */
    @PreAuthorize("@ss.hasPermi('system:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(Employee employee)
    {
        startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    /**
     * 导出员工列表
     */
    @PreAuthorize("@ss.hasPermi('system:employee:export')")
    @Log(title = "员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Employee employee)
    {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        ExcelUtil<Employee> util = new ExcelUtil<Employee>(Employee.class);
        util.exportExcel(response, list, "员工数据");
    }

    /**
     * 获取员工详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:query')")
    @GetMapping(value = "/{employeeId}")
    public AjaxResult getInfo(@PathVariable("employeeId") Long employeeId)
    {
        return success(employeeService.selectEmployeeByEmployeeId(employeeId));
    }

    /**
     * 新增员工
     */
    @PreAuthorize("@ss.hasPermi('system:employee:add')")
    @Log(title = "员工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Employee employee)
    {
        return toAjax(employeeService.insertEmployee(employee));
    }

    /**
     * 修改员工
     */
    @PreAuthorize("@ss.hasPermi('system:employee:edit')")
    @Log(title = "员工", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Employee employee)
    {
        return toAjax(employeeService.updateEmployee(employee));
    }

    /**
     * 删除员工
     */
    @PreAuthorize("@ss.hasPermi('system:employee:remove')")
    @Log(title = "员工", businessType = BusinessType.DELETE)
	@DeleteMapping("/{employeeIds}")
    public AjaxResult remove(@PathVariable Long[] employeeIds)
    {
        return toAjax(employeeService.deleteEmployeeByEmployeeIds(employeeIds));
    }
}
