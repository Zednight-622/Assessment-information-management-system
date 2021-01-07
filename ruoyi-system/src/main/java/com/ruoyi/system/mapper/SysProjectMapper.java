package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysProject;

/**
 * 课程Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public interface SysProjectMapper 
{
    /**
     * 查询课程
     * 
     * @param id 课程ID
     * @return 课程
     */
    public SysProject selectSysProjectById(Long id);

    /**
     * 查询课程列表
     * 
     * @param sysProject 课程
     * @return 课程集合
     */
    public List<SysProject> selectSysProjectList(SysProject sysProject);

    /**
     * 新增课程
     * 
     * @param sysProject 课程
     * @return 结果
     */
    public int insertSysProject(SysProject sysProject);

    /**
     * 修改课程
     * 
     * @param sysProject 课程
     * @return 结果
     */
    public int updateSysProject(SysProject sysProject);

    /**
     * 删除课程
     * 
     * @param id 课程ID
     * @return 结果
     */
    public int deleteSysProjectById(Long id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysProjectByIds(String[] ids);
}
