DROP TABLE IF EXISTS sd_dept;
CREATE TABLE sd_dept(
    "id" VARCHAR(19) NOT NULL,
    "parent_id" VARCHAR(19),
    "dept_code" VARCHAR(64),
    "dept_name" VARCHAR(128),
    "leader_user_id" VARCHAR(19),
    "leader_user_name" VARCHAR(128),
    "dept_sort" INT4,
    "phone" VARCHAR(255),
    "email" VARCHAR(255),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_dept IS '部门表';
COMMENT ON COLUMN sd_dept."id" IS 'ID';
COMMENT ON COLUMN sd_dept."parent_id" IS '父部门ID';
COMMENT ON COLUMN sd_dept."dept_code" IS '部门编码';
COMMENT ON COLUMN sd_dept."dept_name" IS '部门名称';
COMMENT ON COLUMN sd_dept."leader_user_id" IS '部门负责人ID';
COMMENT ON COLUMN sd_dept."leader_user_name" IS '部门负责人名称';
COMMENT ON COLUMN sd_dept."dept_sort" IS '显示顺序';
COMMENT ON COLUMN sd_dept."phone" IS '联系电话';
COMMENT ON COLUMN sd_dept."email" IS '联系邮箱';
COMMENT ON COLUMN sd_dept."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_dept."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_dept."revision" IS '乐观锁';
COMMENT ON COLUMN sd_dept."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_dept."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_dept."created_by" IS '创建人';
COMMENT ON COLUMN sd_dept."created_at" IS '创建时间';
COMMENT ON COLUMN sd_dept."updated_by" IS '更新人';
COMMENT ON COLUMN sd_dept."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_dict;
CREATE TABLE sd_dict(
    "id" VARCHAR(19) NOT NULL,
    "dict_code" VARCHAR(64),
    "dict_name" VARCHAR(128),
    "dict_remark" VARCHAR(255),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_dict IS '字典主表';
COMMENT ON COLUMN sd_dict."id" IS 'ID';
COMMENT ON COLUMN sd_dict."dict_code" IS '字典编码';
COMMENT ON COLUMN sd_dict."dict_name" IS '字典名称';
COMMENT ON COLUMN sd_dict."dict_remark" IS '字典描述';
COMMENT ON COLUMN sd_dict."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_dict."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_dict."revision" IS '乐观锁';
COMMENT ON COLUMN sd_dict."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_dict."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_dict."created_by" IS '创建人';
COMMENT ON COLUMN sd_dict."created_at" IS '创建时间';
COMMENT ON COLUMN sd_dict."updated_by" IS '更新人';
COMMENT ON COLUMN sd_dict."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_dict_item;
CREATE TABLE sd_dict_item(
    "id" VARCHAR(19) NOT NULL,
    "dict_code" VARCHAR(64),
    "item_value" VARCHAR(255),
    "item_label" VARCHAR(255),
    "item_remark" VARCHAR(255),
    "item_sort" INT4,
    "item_style" VARCHAR(255),
    "item_css" TEXT,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_dict_item IS '字典项表';
COMMENT ON COLUMN sd_dict_item."id" IS 'ID';
COMMENT ON COLUMN sd_dict_item."dict_code" IS '字典编码';
COMMENT ON COLUMN sd_dict_item."item_value" IS '字典项值';
COMMENT ON COLUMN sd_dict_item."item_label" IS '字典项标签';
COMMENT ON COLUMN sd_dict_item."item_remark" IS '字典项描述';
COMMENT ON COLUMN sd_dict_item."item_sort" IS '字典项排序';
COMMENT ON COLUMN sd_dict_item."item_style" IS '字典项样式';
COMMENT ON COLUMN sd_dict_item."item_css" IS '字典项CSS';
COMMENT ON COLUMN sd_dict_item."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_dict_item."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_dict_item."revision" IS '乐观锁';
COMMENT ON COLUMN sd_dict_item."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_dict_item."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_dict_item."created_by" IS '创建人';
COMMENT ON COLUMN sd_dict_item."created_at" IS '创建时间';
COMMENT ON COLUMN sd_dict_item."updated_by" IS '更新人';
COMMENT ON COLUMN sd_dict_item."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_login_log;
CREATE TABLE sd_login_log(
    "id" VARCHAR(19) NOT NULL,
    "trace_id" VARCHAR(255),
    "user_id" VARCHAR(255),
    "user_type" VARCHAR(255),
    "user_name" VARCHAR(128),
    "user_ip" VARCHAR(255),
    "user_agent" VARCHAR(255),
    "login_result" VARCHAR(255),
    "log_type" VARCHAR(255),
    "log_request" TEXT,
    "log_response" TEXT,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(255),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(255),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_login_log IS '系统登录日志';
COMMENT ON COLUMN sd_login_log."id" IS 'ID';
COMMENT ON COLUMN sd_login_log."trace_id" IS '链路追踪编号';
COMMENT ON COLUMN sd_login_log."user_id" IS '用户编号';
COMMENT ON COLUMN sd_login_log."user_type" IS '用户类型';
COMMENT ON COLUMN sd_login_log."user_name" IS '用户名称';
COMMENT ON COLUMN sd_login_log."user_ip" IS '用户 IP';
COMMENT ON COLUMN sd_login_log."user_agent" IS '浏览器 UA';
COMMENT ON COLUMN sd_login_log."login_result" IS '登陆结果';
COMMENT ON COLUMN sd_login_log."log_type" IS '日志类型';
COMMENT ON COLUMN sd_login_log."log_request" IS '请求日志';
COMMENT ON COLUMN sd_login_log."log_response" IS '响应日志';
COMMENT ON COLUMN sd_login_log."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_login_log."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_login_log."revision" IS '乐观锁';
COMMENT ON COLUMN sd_login_log."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_login_log."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_login_log."created_by" IS '创建人';
COMMENT ON COLUMN sd_login_log."created_at" IS '创建时间';
COMMENT ON COLUMN sd_login_log."updated_by" IS '更新人';
COMMENT ON COLUMN sd_login_log."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_menu;
CREATE TABLE sd_menu(
    "id" VARCHAR(19) NOT NULL,
    "parent_id" VARCHAR(255),
    "menu_code" VARCHAR(64),
    "menu_name" VARCHAR(128),
    "menu_type" VARCHAR(255),
    "menu_path" VARCHAR(255),
    "menu_icon" VARCHAR(255),
    "menu_component" VARCHAR(255),
    "menu_sort" INT4,
    "menu_permission" VARCHAR(255),
    "menu_shortcut" INT2,
    "keep_alive" INT2,
    "visible" INT2,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_menu IS '菜单表';
COMMENT ON COLUMN sd_menu."id" IS 'ID';
COMMENT ON COLUMN sd_menu."parent_id" IS '父菜单ID';
COMMENT ON COLUMN sd_menu."menu_code" IS '菜单编码';
COMMENT ON COLUMN sd_menu."menu_name" IS '菜单名称';
COMMENT ON COLUMN sd_menu."menu_type" IS '菜单类型';
COMMENT ON COLUMN sd_menu."menu_path" IS '路由地址';
COMMENT ON COLUMN sd_menu."menu_icon" IS '菜单图标';
COMMENT ON COLUMN sd_menu."menu_component" IS '组件路径';
COMMENT ON COLUMN sd_menu."menu_sort" IS '显示顺序';
COMMENT ON COLUMN sd_menu."menu_permission" IS '权限标识';
COMMENT ON COLUMN sd_menu."menu_shortcut" IS '是否创建快捷方式（0停用 1启用）';
COMMENT ON COLUMN sd_menu."keep_alive" IS '是否缓存（0不缓存 1缓存）';
COMMENT ON COLUMN sd_menu."visible" IS '是否可见（0正常 1隐藏）';
COMMENT ON COLUMN sd_menu."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_menu."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_menu."revision" IS '乐观锁';
COMMENT ON COLUMN sd_menu."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_menu."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_menu."created_by" IS '创建人';
COMMENT ON COLUMN sd_menu."created_at" IS '创建时间';
COMMENT ON COLUMN sd_menu."updated_by" IS '更新人';
COMMENT ON COLUMN sd_menu."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_operate_log;
CREATE TABLE sd_operate_log(
    "id" VARCHAR(19) NOT NULL,
    "startdistem_module" VARCHAR(255),
    "trace_id" VARCHAR(19),
    "logger_level" VARCHAR(64),
    "logger_info" TEXT,
    "operate_name" VARCHAR(128),
    "operate_action" VARCHAR(255),
    "operate_content" VARCHAR(255),
    "operate_at" TIMESTAMP,
    "operate_exts" VARCHAR(255),
    "cost_time" VARCHAR(255),
    "request_url" VARCHAR(255),
    "request_method" VARCHAR(255),
    "request_body" TEXT,
    "response_code" VARCHAR(255),
    "response_msg" VARCHAR(255),
    "response_data" TEXT,
    "user_id" VARCHAR(19),
    "user_type" VARCHAR(255),
    "user_ip" VARCHAR(255),
    "user_agent" VARCHAR(255),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_operate_log IS '操作日志记录表';
COMMENT ON COLUMN sd_operate_log."id" IS 'ID';
COMMENT ON COLUMN sd_operate_log."startdistem_module" IS '系统模块';
COMMENT ON COLUMN sd_operate_log."trace_id" IS '链路追踪ID';
COMMENT ON COLUMN sd_operate_log."logger_level" IS '日志级别';
COMMENT ON COLUMN sd_operate_log."logger_info" IS '日志详情';
COMMENT ON COLUMN sd_operate_log."operate_name" IS '操作名称';
COMMENT ON COLUMN sd_operate_log."operate_action" IS '操作类型';
COMMENT ON COLUMN sd_operate_log."operate_content" IS '操作内容（接口描述）';
COMMENT ON COLUMN sd_operate_log."operate_at" IS '操作时间';
COMMENT ON COLUMN sd_operate_log."operate_exts" IS '拓展字段';
COMMENT ON COLUMN sd_operate_log."cost_time" IS '请求耗时';
COMMENT ON COLUMN sd_operate_log."request_url" IS '请求地址';
COMMENT ON COLUMN sd_operate_log."request_method" IS '请求方法';
COMMENT ON COLUMN sd_operate_log."request_body" IS '请求入参';
COMMENT ON COLUMN sd_operate_log."response_code" IS '响应状态码';
COMMENT ON COLUMN sd_operate_log."response_msg" IS '响应提示语';
COMMENT ON COLUMN sd_operate_log."response_data" IS '响应出参';
COMMENT ON COLUMN sd_operate_log."user_id" IS '用户ID';
COMMENT ON COLUMN sd_operate_log."user_type" IS '用户类型';
COMMENT ON COLUMN sd_operate_log."user_ip" IS '用户 IP';
COMMENT ON COLUMN sd_operate_log."user_agent" IS '浏览器 UA';
COMMENT ON COLUMN sd_operate_log."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_operate_log."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_operate_log."revision" IS '乐观锁';
COMMENT ON COLUMN sd_operate_log."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_operate_log."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_operate_log."created_by" IS '创建人';
COMMENT ON COLUMN sd_operate_log."created_at" IS '创建时间';
COMMENT ON COLUMN sd_operate_log."updated_by" IS '更新人';
COMMENT ON COLUMN sd_operate_log."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_post;
CREATE TABLE sd_post(
    "id" VARCHAR(19) NOT NULL,
    "post_code" VARCHAR(64),
    "post_name" VARCHAR(128),
    "post_remark" VARCHAR(255),
    "post_sort" INT4,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_post IS '岗位表';
COMMENT ON COLUMN sd_post."id" IS 'ID';
COMMENT ON COLUMN sd_post."post_code" IS '岗位编码';
COMMENT ON COLUMN sd_post."post_name" IS '岗位名称';
COMMENT ON COLUMN sd_post."post_remark" IS '岗位描述';
COMMENT ON COLUMN sd_post."post_sort" IS '显示顺序';
COMMENT ON COLUMN sd_post."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_post."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_post."revision" IS '乐观锁';
COMMENT ON COLUMN sd_post."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_post."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_post."created_by" IS '创建人';
COMMENT ON COLUMN sd_post."created_at" IS '创建时间';
COMMENT ON COLUMN sd_post."updated_by" IS '更新人';
COMMENT ON COLUMN sd_post."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_role;
CREATE TABLE sd_role(
    "id" VARCHAR(19) NOT NULL,
    "role_code" VARCHAR(64),
    "role_name" VARCHAR(128),
    "role_remark" VARCHAR(255),
    "role_type" VARCHAR(255),
    "role_sort" INT4,
    "role_scope" INT2,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_role IS '角色表';
COMMENT ON COLUMN sd_role."id" IS 'ID';
COMMENT ON COLUMN sd_role."role_code" IS '角色代码';
COMMENT ON COLUMN sd_role."role_name" IS '角色名称';
COMMENT ON COLUMN sd_role."role_remark" IS '角色描述';
COMMENT ON COLUMN sd_role."role_type" IS '角色类型';
COMMENT ON COLUMN sd_role."role_sort" IS '显示顺序';
COMMENT ON COLUMN sd_role."role_scope" IS '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）';
COMMENT ON COLUMN sd_role."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_role."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_role."revision" IS '乐观锁';
COMMENT ON COLUMN sd_role."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_role."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_role."created_by" IS '创建人';
COMMENT ON COLUMN sd_role."created_at" IS '创建时间';
COMMENT ON COLUMN sd_role."updated_by" IS '更新人';
COMMENT ON COLUMN sd_role."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_role_menu;
CREATE TABLE sd_role_menu(
    "id" VARCHAR(19) NOT NULL,
    "role_id" VARCHAR(19),
    "menu_id" VARCHAR(19),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_role_menu IS '角色菜单表';
COMMENT ON COLUMN sd_role_menu."id" IS 'ID';
COMMENT ON COLUMN sd_role_menu."role_id" IS '角色ID';
COMMENT ON COLUMN sd_role_menu."menu_id" IS '菜单ID';
COMMENT ON COLUMN sd_role_menu."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_role_menu."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_role_menu."revision" IS '乐观锁';
COMMENT ON COLUMN sd_role_menu."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_role_menu."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_role_menu."created_by" IS '创建人';
COMMENT ON COLUMN sd_role_menu."created_at" IS '创建时间';
COMMENT ON COLUMN sd_role_menu."updated_by" IS '更新人';
COMMENT ON COLUMN sd_role_menu."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_user_role;
CREATE TABLE sd_user_role(
    "id" VARCHAR(19) NOT NULL,
    "user_id" VARCHAR(19),
    "role_id" VARCHAR(19),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_user_role IS '用户角色表';
COMMENT ON COLUMN sd_user_role."id" IS 'ID';
COMMENT ON COLUMN sd_user_role."user_id" IS '用户ID';
COMMENT ON COLUMN sd_user_role."role_id" IS '角色ID';
COMMENT ON COLUMN sd_user_role."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_user_role."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_user_role."revision" IS '乐观锁';
COMMENT ON COLUMN sd_user_role."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_user_role."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_user_role."created_by" IS '创建人';
COMMENT ON COLUMN sd_user_role."created_at" IS '创建时间';
COMMENT ON COLUMN sd_user_role."updated_by" IS '更新人';
COMMENT ON COLUMN sd_user_role."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_sensitive_word;
CREATE TABLE sd_sensitive_word(
    "id" VARCHAR(19) NOT NULL,
    "word_name" VARCHAR(255),
    "word_tags" VARCHAR(255),
    "word_remark" VARCHAR(255),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_sensitive_word IS '系统敏感词表';
COMMENT ON COLUMN sd_sensitive_word."id" IS 'ID';
COMMENT ON COLUMN sd_sensitive_word."word_name" IS '敏感词';
COMMENT ON COLUMN sd_sensitive_word."word_tags" IS '敏感词标签';
COMMENT ON COLUMN sd_sensitive_word."word_remark" IS '敏感词描述';
COMMENT ON COLUMN sd_sensitive_word."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_sensitive_word."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_sensitive_word."revision" IS '乐观锁';
COMMENT ON COLUMN sd_sensitive_word."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_sensitive_word."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_sensitive_word."created_by" IS '创建人';
COMMENT ON COLUMN sd_sensitive_word."created_at" IS '创建时间';
COMMENT ON COLUMN sd_sensitive_word."updated_by" IS '更新人';
COMMENT ON COLUMN sd_sensitive_word."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_user_post;
CREATE TABLE sd_user_post(
    "id" VARCHAR(19) NOT NULL,
    "user_id" VARCHAR(19),
    "post_id" VARCHAR(19),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_user_post IS '用户岗位表';
COMMENT ON COLUMN sd_user_post."id" IS 'ID';
COMMENT ON COLUMN sd_user_post."user_id" IS '用户ID';
COMMENT ON COLUMN sd_user_post."post_id" IS '岗位ID';
COMMENT ON COLUMN sd_user_post."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_user_post."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_user_post."revision" IS '乐观锁';
COMMENT ON COLUMN sd_user_post."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_user_post."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_user_post."created_by" IS '创建人';
COMMENT ON COLUMN sd_user_post."created_at" IS '创建时间';
COMMENT ON COLUMN sd_user_post."updated_by" IS '更新人';
COMMENT ON COLUMN sd_user_post."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_user;
CREATE TABLE sd_user(
    "id" VARCHAR(19) NOT NULL,
    "user_code" VARCHAR(64),
    "user_name" VARCHAR(64),
    "nick_name" VARCHAR(128),
    "user_remark" VARCHAR(255),
    "password" VARCHAR(255),
    "mobile" VARCHAR(19),
    "phone" VARCHAR(255),
    "email" VARCHAR(255),
    "sex" INT2,
    "head_pic" VARCHAR(255),
    "login_ip" VARCHAR(255),
    "login_date" TIMESTAMP,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_user IS '用户表';
COMMENT ON COLUMN sd_user."id" IS 'ID';
COMMENT ON COLUMN sd_user."user_code" IS '用户编码';
COMMENT ON COLUMN sd_user."user_name" IS '用户名称';
COMMENT ON COLUMN sd_user."nick_name" IS '用户昵称';
COMMENT ON COLUMN sd_user."user_remark" IS '用户描述';
COMMENT ON COLUMN sd_user."password" IS '登录密码';
COMMENT ON COLUMN sd_user."mobile" IS '手机号码';
COMMENT ON COLUMN sd_user."phone" IS '电话号码';
COMMENT ON COLUMN sd_user."email" IS '电子邮箱';
COMMENT ON COLUMN sd_user."sex" IS '用户性别（0女性 1男性）';
COMMENT ON COLUMN sd_user."head_pic" IS '头像地址';
COMMENT ON COLUMN sd_user."login_ip" IS '最后登录IP';
COMMENT ON COLUMN sd_user."login_date" IS '最后登录时间';
COMMENT ON COLUMN sd_user."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_user."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_user."revision" IS '乐观锁';
COMMENT ON COLUMN sd_user."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_user."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_user."created_by" IS '创建人';
COMMENT ON COLUMN sd_user."created_at" IS '创建时间';
COMMENT ON COLUMN sd_user."updated_by" IS '更新人';
COMMENT ON COLUMN sd_user."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_company;
CREATE TABLE sd_company(
    "id" VARCHAR(19) NOT NULL,
    "parent_id" VARCHAR(19),
    "company_code" VARCHAR(64),
    "company_name" VARCHAR(128),
    "company_remark" VARCHAR(255),
    "company_address" VARCHAR(255),
    "company_postcode" VARCHAR(128),
    "company_fax" VARCHAR(128),
    "company_wechat" VARCHAR(128),
    "company_blicense" VARCHAR(128),
    "company_other" VARCHAR(255),
    "leader_user_id" VARCHAR(19),
    "leader_user_name" VARCHAR(128),
    "company_sort" INT4,
    "mobile" VARCHAR(19),
    "phone" VARCHAR(255),
    "email" VARCHAR(255),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_company IS '公司表';
COMMENT ON COLUMN sd_company."id" IS 'ID';
COMMENT ON COLUMN sd_company."parent_id" IS '父公司ID';
COMMENT ON COLUMN sd_company."company_code" IS '公司编码';
COMMENT ON COLUMN sd_company."company_name" IS '公司名称';
COMMENT ON COLUMN sd_company."company_remark" IS '公司介绍';
COMMENT ON COLUMN sd_company."company_address" IS '公司地址';
COMMENT ON COLUMN sd_company."company_postcode" IS '公司邮编';
COMMENT ON COLUMN sd_company."company_fax" IS '传真号码';
COMMENT ON COLUMN sd_company."company_wechat" IS '微信二维码';
COMMENT ON COLUMN sd_company."company_blicense" IS '统一信用社会代码';
COMMENT ON COLUMN sd_company."company_other" IS '其它信息';
COMMENT ON COLUMN sd_company."leader_user_id" IS '公司负责人ID';
COMMENT ON COLUMN sd_company."leader_user_name" IS '公司负责人名称';
COMMENT ON COLUMN sd_company."company_sort" IS '显示顺序';
COMMENT ON COLUMN sd_company."mobile" IS '手机号码';
COMMENT ON COLUMN sd_company."phone" IS '电话号码';
COMMENT ON COLUMN sd_company."email" IS '电子邮箱';
COMMENT ON COLUMN sd_company."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_company."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_company."revision" IS '乐观锁';
COMMENT ON COLUMN sd_company."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_company."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_company."created_by" IS '创建人';
COMMENT ON COLUMN sd_company."created_at" IS '创建时间';
COMMENT ON COLUMN sd_company."updated_by" IS '更新人';
COMMENT ON COLUMN sd_company."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_user_field;
CREATE TABLE sd_user_field(
    "id" VARCHAR(19) NOT NULL,
    "field_code" VARCHAR(64),
    "field_name" VARCHAR(128),
    "field_length" INT8,
    "field_remark" VARCHAR(255),
    "field_sort" INT4,
    "required" VARCHAR(19),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_user_field IS '用户字段表';
COMMENT ON COLUMN sd_user_field."id" IS 'ID';
COMMENT ON COLUMN sd_user_field."field_code" IS '字段编码';
COMMENT ON COLUMN sd_user_field."field_name" IS '字段名称';
COMMENT ON COLUMN sd_user_field."field_length" IS '字段长度';
COMMENT ON COLUMN sd_user_field."field_remark" IS '字段描述';
COMMENT ON COLUMN sd_user_field."field_sort" IS '显示顺序';
COMMENT ON COLUMN sd_user_field."required" IS '是否必填（0正常 1必填）';
COMMENT ON COLUMN sd_user_field."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_user_field."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_user_field."revision" IS '乐观锁';
COMMENT ON COLUMN sd_user_field."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_user_field."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_user_field."created_by" IS '创建人';
COMMENT ON COLUMN sd_user_field."created_at" IS '创建时间';
COMMENT ON COLUMN sd_user_field."updated_by" IS '更新人';
COMMENT ON COLUMN sd_user_field."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_user_group;
CREATE TABLE sd_user_group(
    "id" VARCHAR(19) NOT NULL,
    "user_id" VARCHAR(19),
    "user_code" VARCHAR(64),
    "group_id" VARCHAR(19),
    "group_code" VARCHAR(64),
    "sort" INT4,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_user_group IS '用户分组表';
COMMENT ON COLUMN sd_user_group."id" IS 'ID';
COMMENT ON COLUMN sd_user_group."user_id" IS '用户ID';
COMMENT ON COLUMN sd_user_group."user_code" IS '用户编码';
COMMENT ON COLUMN sd_user_group."group_id" IS '分组ID';
COMMENT ON COLUMN sd_user_group."group_code" IS '分组编码';
COMMENT ON COLUMN sd_user_group."sort" IS '显示顺序';
COMMENT ON COLUMN sd_user_group."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_user_group."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_user_group."revision" IS '乐观锁';
COMMENT ON COLUMN sd_user_group."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_user_group."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_user_group."created_by" IS '创建人';
COMMENT ON COLUMN sd_user_group."created_at" IS '创建时间';
COMMENT ON COLUMN sd_user_group."updated_by" IS '更新人';
COMMENT ON COLUMN sd_user_group."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_role_group;
CREATE TABLE sd_role_group(
    "id" VARCHAR(19) NOT NULL,
    "role_id" VARCHAR(19),
    "roler_code" VARCHAR(64),
    "group_id" VARCHAR(19),
    "group_code" VARCHAR(64),
    "sort" INT4,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_role_group IS '角色分组表';
COMMENT ON COLUMN sd_role_group."id" IS 'ID';
COMMENT ON COLUMN sd_role_group."role_id" IS '角色ID';
COMMENT ON COLUMN sd_role_group."roler_code" IS '角色编码';
COMMENT ON COLUMN sd_role_group."group_id" IS '分组ID';
COMMENT ON COLUMN sd_role_group."group_code" IS '分组编码';
COMMENT ON COLUMN sd_role_group."sort" IS '显示顺序';
COMMENT ON COLUMN sd_role_group."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_role_group."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_role_group."revision" IS '乐观锁';
COMMENT ON COLUMN sd_role_group."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_role_group."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_role_group."created_by" IS '创建人';
COMMENT ON COLUMN sd_role_group."created_at" IS '创建时间';
COMMENT ON COLUMN sd_role_group."updated_by" IS '更新人';
COMMENT ON COLUMN sd_role_group."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_group;
CREATE TABLE sd_group(
    "id" VARCHAR(19) NOT NULL,
    "group_code" VARCHAR(64),
    "group_name" VARCHAR(128),
    "group_remark" VARCHAR(255),
    "group_sort" INT4,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_group IS '分组表';
COMMENT ON COLUMN sd_group."id" IS 'ID';
COMMENT ON COLUMN sd_group."group_code" IS '分组编码';
COMMENT ON COLUMN sd_group."group_name" IS '分组名称';
COMMENT ON COLUMN sd_group."group_remark" IS '分组描述';
COMMENT ON COLUMN sd_group."group_sort" IS '显示顺序';
COMMENT ON COLUMN sd_group."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_group."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_group."revision" IS '乐观锁';
COMMENT ON COLUMN sd_group."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_group."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_group."created_by" IS '创建人';
COMMENT ON COLUMN sd_group."created_at" IS '创建时间';
COMMENT ON COLUMN sd_group."updated_by" IS '更新人';
COMMENT ON COLUMN sd_group."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_group_menu;
CREATE TABLE sd_group_menu(
    "id" VARCHAR(19) NOT NULL,
    "group_id" VARCHAR(19),
    "menu_id" VARCHAR(19),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_group_menu IS '分组菜单表';
COMMENT ON COLUMN sd_group_menu."id" IS 'ID';
COMMENT ON COLUMN sd_group_menu."group_id" IS '分组ID';
COMMENT ON COLUMN sd_group_menu."menu_id" IS '菜单ID';
COMMENT ON COLUMN sd_group_menu."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_group_menu."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_group_menu."revision" IS '乐观锁';
COMMENT ON COLUMN sd_group_menu."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_group_menu."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_group_menu."created_by" IS '创建人';
COMMENT ON COLUMN sd_group_menu."created_at" IS '创建时间';
COMMENT ON COLUMN sd_group_menu."updated_by" IS '更新人';
COMMENT ON COLUMN sd_group_menu."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_notice;
CREATE TABLE sd_notice(
    "id" VARCHAR(19) NOT NULL,
    "notice_code" VARCHAR(64),
    "notice_title" VARCHAR(128),
    "notice_content" TEXT,
    "notice_type" INT2,
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_notice IS '通知公告表';
COMMENT ON COLUMN sd_notice."id" IS 'ID';
COMMENT ON COLUMN sd_notice."notice_code" IS '公告编码';
COMMENT ON COLUMN sd_notice."notice_title" IS '公告标题';
COMMENT ON COLUMN sd_notice."notice_content" IS '公告内容';
COMMENT ON COLUMN sd_notice."notice_type" IS '公告类型（1公告 2通知）';
COMMENT ON COLUMN sd_notice."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_notice."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_notice."revision" IS '乐观锁';
COMMENT ON COLUMN sd_notice."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_notice."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_notice."created_by" IS '创建人';
COMMENT ON COLUMN sd_notice."created_at" IS '创建时间';
COMMENT ON COLUMN sd_notice."updated_by" IS '更新人';
COMMENT ON COLUMN sd_notice."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_variable;
CREATE TABLE sd_variable(
    "id" VARCHAR(19) NOT NULL,
    "variable_code" VARCHAR(64),
    "variable_name" VARCHAR(128),
    "variable_key" VARCHAR(255),
    "variable_value" TEXT,
    "variable_type" INT2,
    "variable_remark" VARCHAR(255),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_variable IS '全局变量表';
COMMENT ON COLUMN sd_variable."id" IS 'ID';
COMMENT ON COLUMN sd_variable."variable_code" IS '变量编码';
COMMENT ON COLUMN sd_variable."variable_name" IS '变量名称';
COMMENT ON COLUMN sd_variable."variable_key" IS '变量键名';
COMMENT ON COLUMN sd_variable."variable_value" IS '变量键值';
COMMENT ON COLUMN sd_variable."variable_type" IS '是否内置（0用户定义 1系统内置）';
COMMENT ON COLUMN sd_variable."variable_remark" IS '变量描述';
COMMENT ON COLUMN sd_variable."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_variable."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_variable."revision" IS '乐观锁';
COMMENT ON COLUMN sd_variable."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_variable."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_variable."created_by" IS '创建人';
COMMENT ON COLUMN sd_variable."created_at" IS '创建时间';
COMMENT ON COLUMN sd_variable."updated_by" IS '更新人';
COMMENT ON COLUMN sd_variable."updated_at" IS '更新时间';

DROP TABLE IF EXISTS sd_user_dept;
CREATE TABLE sd_user_dept(
    "id" VARCHAR(19) NOT NULL,
    "user_id" VARCHAR(19),
    "dept_id" VARCHAR(19),
    "status" INT2,
    "deleted" INT2,
    "revision" INT8,
    "group_tenant_id" VARCHAR(19),
    "company_tenant_id" VARCHAR(19),
    "created_by" VARCHAR(64),
    "created_at" TIMESTAMP,
    "updated_by" VARCHAR(64),
    "updated_at" TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sd_user_dept IS '用户部门表';
COMMENT ON COLUMN sd_user_dept."id" IS 'ID';
COMMENT ON COLUMN sd_user_dept."user_id" IS '用户ID';
COMMENT ON COLUMN sd_user_dept."dept_id" IS '部门ID';
COMMENT ON COLUMN sd_user_dept."status" IS '是否启用（0停用 1启用）';
COMMENT ON COLUMN sd_user_dept."deleted" IS '是否删除（0正常 1删除）';
COMMENT ON COLUMN sd_user_dept."revision" IS '乐观锁';
COMMENT ON COLUMN sd_user_dept."group_tenant_id" IS '集团租户ID';
COMMENT ON COLUMN sd_user_dept."company_tenant_id" IS '公司租户ID';
COMMENT ON COLUMN sd_user_dept."created_by" IS '创建人';
COMMENT ON COLUMN sd_user_dept."created_at" IS '创建时间';
COMMENT ON COLUMN sd_user_dept."updated_by" IS '更新人';
COMMENT ON COLUMN sd_user_dept."updated_at" IS '更新时间';

