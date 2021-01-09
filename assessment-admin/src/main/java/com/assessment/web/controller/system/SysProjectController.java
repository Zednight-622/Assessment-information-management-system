package com.assessment.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.assessment.common.annotation.Log;
import com.assessment.common.enums.BusinessType;
import com.assessment.system.domain.SysProject;
import com.assessment.system.service.ISysProjectService;
import com.assessment.common.core.controller.BaseController;
import com.assessment.common.core.domain.AjaxResult;
import com.assessment.common.utils.poi.ExcelUtil;
import com.assessment.common.core.page.TableDataInfo;

/**
 * 课程Controller
 * 
 * @author  jiangyi xu
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/project")
public class SysProjectController extends BaseController
{
    private String prefix = "system/project";

    @Autowired
    private ISysProjectService sysProjectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysProject sysProject)
    {
        startPage();
        List<SysProject> list = sysProjectService.selectSysProjectList(sysProject);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @RequiresPermissions("system:project:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysProject sysProject)
    {
        List<SysProject> list = sysProjectService.selectSysProjectList(sysProject);
        ExcelUtil<SysProject> util = new ExcelUtil<SysProject>(SysProject.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程
     */
    @RequiresPermissions("system:project:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysProject sysProject)
    {
        return toAjax(sysProjectService.insertSysProject(sysProject));
    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysProject sysProject = sysProjectService.selectSysProjectById(id);
        mmap.put("sysProject", sysProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("system:project:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysProject sysProject)
    {
        return toAjax(sysProjectService.updateSysProject(sysProject));
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("system:project:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysProjectService.deleteSysProjectByIds(ids));
    }
}
