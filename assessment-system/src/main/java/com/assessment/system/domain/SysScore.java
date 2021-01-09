package com.assessment.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.assessment.common.annotation.Excel;
import com.assessment.common.core.domain.BaseEntity;

/**
 * 成绩信息对象 sys_score
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public class SysScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private String project;

    /**  */
    @Excel(name = "")
    private Long score;

    /**  */
    @Excel(name = "")
    private String studentName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProject(String project) 
    {
        this.project = project;
    }

    public String getProject() 
    {
        return project;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("project", getProject())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("studentName", getStudentName())
            .toString();
    }
}
