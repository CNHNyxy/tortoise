ALTER TABLE AssetCategory MODIFY COLUMN create_time DATE COMMENT '新增时间';
ALTER TABLE AssetCategory MODIFY COLUMN update_time DATE COMMENT '修改时间';
ALTER TABLE AssetCategory MODIFY COLUMN is_deleted DATE COMMENT '删除标志,1 删除 ,2 未删除 ';


alter table Asset rename column Date to create_time;
ALTER TABLE Asset MODIFY COLUMN update_time DATE COMMENT '修改时间';
ALTER TABLE Asset MODIFY COLUMN is_deleted DATE COMMENT '删除标志,1 删除 ,2 未删除 ';