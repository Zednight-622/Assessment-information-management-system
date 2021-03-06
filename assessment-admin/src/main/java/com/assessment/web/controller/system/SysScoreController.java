package com.assessment.web.controller.system;

import java.util.List;

import com.assessment.common.core.domain.entity.SysUser;
import com.assessment.common.utils.ShiroUtils;
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
import com.assessment.system.domain.SysScore;
import com.assessment.system.service.ISysScoreService;
import com.assessment.common.core.controller.BaseController;
import com.assessment.common.core.domain.AjaxResult;
import com.assessment.common.utils.poi.ExcelUtil;
import com.assessment.common.core.page.TableDataInfo;

/**
 * 成绩信息Controller
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/system/score")
public class SysScoreController extends BaseController
{
    private String prefix = "system/score";

    @Autowired
    private ISysScoreService sysScoreService;

    @RequiresPermissions("system:score:view")
    @GetMapping()
    public String score(ModelMap modelMap)
    {
        SysUser sysUser = ShiroUtils.getSysUser();
        modelMap.put("user", sysUser);
        return prefix + "/score";
    }

    /**
     * 查询成绩信息列表
     */
    @RequiresPermissions("system:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysScore sysScore)
    {
        startPage();
        List<SysScore> list = sysScoreService.selectSysScoreList(sysScore);
        return getDataTable(list);
    }

    @RequiresPermissions("system:score:list")
    @PostMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo listById(@PathVariable("id") int id)
    {
        startPage();
        List<SysScore> list = sysScoreService.selectSysScoreListById(id);
        return getDataTable(list);
    }
    /**
     * 导出成绩信息列表
     */
    @RequiresPermissions("system:score:export")
    @Log(title = "成绩信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysScore sysScore)
    {
        List<SysScore> list = sysScoreService.selectSysScoreList(sysScore);
        ExcelUtil<SysScore> util = new ExcelUtil<SysScore>(SysScore.class);
        return util.exportExcel(list, "score");
    }

    /**
     * 新增成绩信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存成绩信息
     */
    @RequiresPermissions("system:score:add")
    @Log(title = "成绩信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysScore sysScore)
    {
        return toAjax(sysScoreService.insertSysScore(sysScore));
    }

    /**
     * 修改成绩信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysScore sysScore = sysScoreService.selectSysScoreById(id);
        mmap.put("sysScore", sysScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存成绩信息
     */
    @RequiresPermissions("system:score:edit")
    @Log(title = "成绩信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysScore sysScore)
    {
        return toAjax(sysScoreService.updateSysScore(sysScore));
    }

    /**
     * 删除成绩信息
     */
    @RequiresPermissions("system:score:remove")
    @Log(title = "成绩信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysScoreService.deleteSysScoreByIds(ids));
    }
}
