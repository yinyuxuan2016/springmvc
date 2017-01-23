CREATE TABLE bpo_plan_approve_history (
id  bigint(20) NOT NULL AUTO_INCREMENT ,
subinstance_id  varchar(128),
plan_id  bigint(20),
instance_id  varchar(128)  ,
main_task_node  varchar(45)  ,
main_task_name  varchar(45)  ,
approve_user_id  bigint(20)  ,
approve_user_name  varchar(128)  ,
approve_opition  varchar(45)  ,
approve_result  varchar(1000)  ,
create_time  datetime   ,
update_time  datetime   ,
sub_task_name  varchar(45)  ,
is_last_approve  smallint(1)  DEFAULT 2 ,
is_approve  smallint(1) ,
PRIMARY KEY (id)
)ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=43;
CREATE TABLE bpo_workflow_tasknode_info (
id  bigint(19) NOT NULL AUTO_INCREMENT ,
task_def_key  varchar(100)  ,
task_name  varchar(100)  ,
approver_id  varchar(100)  ,
approver_name  varchar(100)  ,
approver_login_name  varchar(100)  ,
workflow_id  bigint(19) NOT NULL ,
auto_approve_time  int(11)   ,
approve_amount  decimal(20,4)   ,
sms_note  varchar(10)  ,
task_index  int(11)   ,
PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 
AUTO_INCREMENT=991231548961325095;
CREATE TABLE bpo_workflow_info (
id  bigint(19) NOT NULL AUTO_INCREMENT ,
workflow_name  varchar(100)  ,
create_user_id  bigint(19)   ,
create_user_name  varchar(100)  ,
create_time  datetime   ,
initiator_id  varchar(100)  ,
initiator_name  varchar(100)  ,
initiator_login_name  varchar(100)  ,
approve_node  varchar(100)  ,
process_def_id  varchar(100)  ,
custom_def_id  varchar(100)  ,
visible  tinyint(3)   ,
process_def_name  varchar(100)  ,
update_time  datetime   ,
PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 
AUTO_INCREMENT=991231548927770662;
CREATE TABLE bpo_sub_launched_user (
id  bigint(11) NOT NULL AUTO_INCREMENT ,
subprocess_id  bigint(11) NOT NULL ,
subprocess_name  varchar(255)  ,
user_id  bigint(11)   ,
user_name  varchar(255)  ,
PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 
AUTO_INCREMENT=1;
CREATE TABLE bpo_sub_delegate_user (
ID  bigint(20) NOT NULL AUTO_INCREMENT ,
ASSIGNEE_ID  bigint(20) NULL  ,
ASSIGNEE_NAME  varchar(75) ,
CONSIGNER_ID  bigint(20)   ,
CONSIGNER_NAME  varchar(75) ,
COMPANY_ID  bigint(20)   ,
ACCEPT_STATUS  int(11) NOT NULL DEFAULT 1 ,
PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=1;