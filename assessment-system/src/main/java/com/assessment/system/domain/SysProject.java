package com.assessment.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.assessment.common.annotation.Excel;
import com.assessment.common.core.domain.BaseEntity;

/**
 * 课程对象 sys_project
 * 
 * @author  jiangyi xu
 * @date 2021-01-07
 */
public class SysProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    private Long id;

    /** 课程名 */
    @Excel(name = "课程名")
    private String name;

    /** 任课老师 */
    @Excel(name = "任课老师")
    private String teacherName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("teacherName", getTeacherName())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
