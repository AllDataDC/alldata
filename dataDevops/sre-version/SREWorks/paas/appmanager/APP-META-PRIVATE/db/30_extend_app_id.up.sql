alter table am_deploy_app modify app_id varchar(64) null comment '应用唯一标识';
alter table am_deploy_component modify app_id varchar(64) null comment '应用唯一标识';
alter table am_component_package modify app_id varchar(64) null comment '应用唯一标识';
alter table am_component_package_task modify app_id varchar(64) null comment '应用唯一标识';
alter table am_app_package modify app_id varchar(64) null comment '应用唯一标识';
alter table am_app_package_task modify app_id varchar(64) null comment '应用唯一标识';
alter table am_app_meta modify app_id varchar(64) null comment '应用唯一标识';
alter table am_k8s_micro_service_meta modify app_id varchar(64) null comment '应用唯一标识';
alter table am_micro_service_host modify app_id varchar(64) null comment '应用唯一标识';
alter table am_micro_service_meta modify app_id varchar(64) null comment '应用唯一标识';