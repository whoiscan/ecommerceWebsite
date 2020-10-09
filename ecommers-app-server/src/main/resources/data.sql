insert into role(id,name) values (10,'ROLE_ADMIN');
insert into role(id,name) values (20,'ROLE_MODER');
insert into role(id,name) values (30,'ROLE_USER');
-- insert into users(id,email,account_non_expired,account_non_locked,credentials_non_expired,enabled,full_name,password,user_name) values (100,'example@gmail.com',true,true,true,true,'fullname','$2a$10$bu8VAaYrSit.UgXLTO4qJe3GjCi1350X.RP3dbOFrRFMfiPO0tEr.','username');
-- insert into users(id,email,account_non_expired,account_non_locked,credentials_non_expired,enabled,full_name,password,user_name) values (200,'2@gmail.com',true,true,true,true,'fullname 2','$2a$10$bu8VAaYrSit.UgXLTO4qJe3GjCi1350X.RP3dbOFrRFMfiPO0tEr.','username 2');
-- insert into user_role(user_id, role_id) values (100,20);
-- insert into user_role(user_id, role_id) values (200,30);
insert into icon(id,icon)values (10,null);
insert into categoria (id,name, parent_id, icon_id) values (10,'phone',0,10),(20,'iphone',10,null);
insert into product(id,name, price, categoria_id) VALUES(10,'iphonex',1000,20);

insert into detail (id, is_main, name,value)values (10,true,'operation system','ios');
insert into product_detail (product_id, detail_id) values (10,10);
insert into discount (id,expire_date, percentage, start_date) values (10,'04.04.2015',15,'18.06.2019');
insert into product_discount (product_id,discount_id) values (10,10);

insert into  region (id,name) values (1,'Toshkent viloyat');
insert into district (id, name,region_id) values (2,'Angren',1),(1,'Toshkent',1);
insert into  region (id,name) values (2,'Qashqadaryo viloyat');
insert into district (id, name,region_id) values (3,'Denov',2),(4,'Qarshi',2);

-- insert into  ()
-- values ();