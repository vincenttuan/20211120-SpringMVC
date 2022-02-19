-- 建立 Employee 資料表
create table IF NOT EXISTS employee (
    eid integer not null auto_increment, -- 主鍵，員工 id (自行產生序號: 1, 2, 3, ...)
    ename text, -- 員工姓名
    salary integer, -- 員工薪資
    createtime datetime default current_timestamp, -- 建檔時間
    primary key(eid)
);

-- 建立 Job 資料表
create table IF NOT EXISTS job(
    jid integer not null auto_increment, -- 主鍵，工作 id
    jname text, -- 工作名稱
    eid integer not null, -- 員工 id
    foreign key(eid) references employee(eid), -- 外鍵關聯
    primary key(jid)
);

-- 建立 Employee 範例資料
insert into employee(ename, salary) values('John', 40000);
insert into employee(ename, salary) values('Mary', 50000);
insert into employee(ename, salary) values('Bobo', 60000);
insert into employee(ename, salary) values('Mark', 70000);

-- 建立 Job 範例資料
insert into job(jname, eid) values('Job A', 1);
insert into job(jname, eid) values('Job B', 1);
insert into job(jname, eid) values('Job C', 2);
insert into job(jname, eid) values('Job D', 2);
insert into job(jname, eid) values('Job E', 4);
insert into job(jname, eid) values('Job F', 4);
insert into job(jname, eid) values('Job G', 4);
