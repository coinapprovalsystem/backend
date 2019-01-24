/**
 * 秒杀库存表
 */
create table `seckill_inventory` (
	`productId` integer not null auto_increment comment'商品id',
	`productName` varchar (6000) not null default '默认名称'comment'商品名称',
	`productNumber` integer not null comment'商品剩余数量',
	`price` double(6,2) not null comment '商品价格',
	`secStartTime` datetime not null default current_timestamp comment'秒杀开始时间',
	`secEndTime` datetime not null default current_timestamp comment'秒杀结束时间',
	`createTime` datetime not null default current_timestamp comment'创建时间',
	`modifyTime` datetime not null default current_timestamp comment'更新时间',
	primary key (`productId`),
	key index_starttime (`secStartTime`),
	key index_endtime (`secEndTime`),
	key index_createtime (`createTime`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 default charset=utf8 comment '秒杀库存表';
/**
 插入库存数据
 */
insert into seckill_inventory (productName,productNumber,price,secStartTime,secEndTime)
values ('2000抢华为mate20',100,2000.00,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
('1000抢 华为mate10',200,1000.00,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
('3000抢 iphoneXR',300,3000.00,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
('1699抢 ipad Pro',400,1699.98,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
('200抢 iwatch2',300,200.99,'2019-02-01 11:30:00','2019-02-02 23:59:59');

/**
 秒杀成功表
 */
 create table `seckill_success`(
 `productId` integer not null comment '商品id',
 `phoneNumber` bigint not null comment '手机号码',
 `status` tinyint not null comment '状态标识 -1：无效；0：秒杀成功待付款；1：已付款；2：已配送；3：已签收；4：拒签',
 `createTime` datetime not null default current_timestamp comment '插入时间',
primary key (productId,phoneNumber)
 )ENGINE=InnoDB default charset=utf8 comment '秒杀成功记录表';
 insert into seckill_success (productId, phoneNumber, status)values (1001,15026969417,0),(1001,15026969417,0);
/**
 *索引创建
 *一、哪些列需要创建索引
 *1.以后sql查询的时候需要经常根据此列order by的
 *2.
 */
/**
插入测试数据
 */
INSERT INTO mybatis.userInfo (userId,username,PASSWORD)VALUES(1,"jack","12345678");