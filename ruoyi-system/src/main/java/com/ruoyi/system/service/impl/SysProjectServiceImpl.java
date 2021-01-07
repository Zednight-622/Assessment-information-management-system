package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysProjectMapper;
import com.ruoyi.system.domain.SysProject;
import com.ruoyi.system.service.ISysProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Service
public class SysProjectServiceImpl implements ISysProjectService 
{
    @Autowired
    private SysProjectMapper sysProjectMapper;

    /**
     * 查询课程
     * 
     * @param id 课程ID
     * @return 课程
     */
    @Override
    public SysProject selectSysProjectById(Long id)
    {
        return sysProjectMapper.selectSysProjectById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param sysProject 课程
     * @return 课程
     */
    @Override
    public List<SysProject> selectSysProjectList(SysProject sysProject)
    {
        return sysProjectMapper.selectSysProjectList(sysProject);
    }

    /**
     * 新增课程
     * 
     * @param sysProject 课程
     * @return 结果
     */
    @Override
    public int insertSysProject(SysProject sysProject)
    {
        sysProject.setCreateTime(DateUtils.getNowDate());
        return sysProjectMapper.insertSysProject(sysProject);
    }

    /**
     * 修改课程
     * 
     * @param sysProject 课程
     * @return 结果
     */
    @Override
    public int updateSysProject(SysProject sysProject)
    {
        sysProject.setUpdateTime(DateUtils.getNowDate());
        return sysProjectMapper.updateSysProject(sysProject);
    }

    /**
     * 删除课程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysProjectByIds(String ids)
    {
        return sysProjectMapper.deleteSysProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程ID
     * @return 结果
     */
    @Override
    public int deleteSysProjectById(Long id)
    {
        return sysProjectMapper.deleteSysProjectById(id);
    }
}
