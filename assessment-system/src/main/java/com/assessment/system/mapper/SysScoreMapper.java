package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysScore;

/**
 * 成绩信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public interface SysScoreMapper 
{
    /**
     * 查询成绩信息
     * 
     * @param id 成绩信息ID
     * @return 成绩信息
     */
    public SysScore selectSysScoreById(Long id);

    /**
     * 查询成绩信息列表
     * 
     * @param sysScore 成绩信息
     * @return 成绩信息集合
     */
    public List<SysScore> selectSysScoreList(SysScore sysScore);

    /**
     * 新增成绩信息
     * 
     * @param sysScore 成绩信息
     * @return 结果
     */
    public int insertSysScore(SysScore sysScore);

    /**
     * 修改成绩信息
     * 
     * @param sysScore 成绩信息
     * @return 结果
     */
    public int updateSysScore(SysScore sysScore);

    /**
     * 删除成绩信息
     * 
     * @param id 成绩信息ID
     * @return 结果
     */
    public int deleteSysScoreById(Long id);

    /**
     * 批量删除成绩信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysScoreByIds(String[] ids);
}
