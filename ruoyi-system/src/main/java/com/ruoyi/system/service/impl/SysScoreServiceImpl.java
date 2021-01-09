package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysScoreMapper;
import com.ruoyi.system.domain.SysScore;
import com.ruoyi.system.service.ISysScoreService;
import com.ruoyi.common.core.text.Convert;

/**
 * 成绩信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@Service
public class SysScoreServiceImpl implements ISysScoreService 
{
    @Autowired
    private SysScoreMapper sysScoreMapper;

    /**
     * 查询成绩信息
     * 
     * @param id 成绩信息ID
     * @return 成绩信息
     */
    @Override
    public SysScore selectSysScoreById(Long id)
    {
        return sysScoreMapper.selectSysScoreById(id);
    }

    /**
     * 查询成绩信息列表
     * 
     * @param sysScore 成绩信息
     * @return 成绩信息
     */
    @Override
    public List<SysScore> selectSysScoreList(SysScore sysScore)
    {
        return sysScoreMapper.selectSysScoreList(sysScore);
    }

    /**
     * 新增成绩信息
     * 
     * @param sysScore 成绩信息
     * @return 结果
     */
    @Override
    public int insertSysScore(SysScore sysScore)
    {
        sysScore.setCreateTime(DateUtils.getNowDate());
        return sysScoreMapper.insertSysScore(sysScore);
    }

    /**
     * 修改成绩信息
     * 
     * @param sysScore 成绩信息
     * @return 结果
     */
    @Override
    public int updateSysScore(SysScore sysScore)
    {
        sysScore.setUpdateTime(DateUtils.getNowDate());
        return sysScoreMapper.updateSysScore(sysScore);
    }

    /**
     * 删除成绩信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysScoreByIds(String ids)
    {
        return sysScoreMapper.deleteSysScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除成绩信息信息
     * 
     * @param id 成绩信息ID
     * @return 结果
     */
    @Override
    public int deleteSysScoreById(Long id)
    {
        return sysScoreMapper.deleteSysScoreById(id);
    }
}
