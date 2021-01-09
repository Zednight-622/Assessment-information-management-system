package com.assessment.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.assessment.common.annotation.Excel;
import com.assessment.common.core.domain.BaseEntity;

/**
 * 成绩信息对象 sys_score
 * 
 * @author  jiangyi xu
 * @date 2021-01-02
 */
public class SysScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩Id */
    private Long id;

    /** 课程Id */
    @Excel(name = "课程Id")
    private Long projectId;

    /** 成绩 */
    @Excel(name = "成绩")
    private Long score;

    /** 学生Id */
    @Excel(name = "学生Id")
    private Long studentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("studentId", getStudentId())
            .toString();
    }
}
