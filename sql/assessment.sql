CREATE TABLE `sys_score` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `project_id` int NOT NULL,
                             `score` int NULL,
                             `create_time` datetime NULL,
                             `update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
                             `student_id` int NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8
    COMMENT='成绩信息表';


CREATE TABLE `sys_project` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `name` varchar(50) NULL COMMENT '课程名',
                               `user_id` int NULL COMMENT '任课老师',
                               `create_time` datetime NULL,
                               `update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8
    COMMENT='课程表';


CREATE TABLE `sys_new_user` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `name` varchar(50) NOT NULL COMMENT '用户名',
                                `pwd` varchar(100) NULL COMMENT '密码',
                                `number` varchar(50) NOT NULL COMMENT '学号',
                                `auth` varchar(20) NOT NULL COMMENT '权限',
                                `create_time` datetime NULL,
                                `update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8;
