show databases;
-- mysql06 사용 
use mysql06;
-- DB테이블 조회 
show tables;

-- member0630
-- 테이블이 존재 하지 않으면 drop 실행 하지 않는다
drop table if exists member0630;
create table member0630(
	member_id bigint not null auto_increment, -- Long auto_increment->sequence
	member_name varchar(100) not null,
    member_password varchar(100) not null,
    email varchar(255) not null,
    create_time datetime default current_timestamp, -- 자동으로 날짜, 시간 설정
    primary key(member_id)
);
desc member0630;
-- 칼럼을 수정
alter table member0630 modify email varchar(100) not null unique;

insert into member0630(member_name, member_password, email) values ('m1','1111','m1@gmail.com');
insert into member0630(member_name, member_password, email) values ('m2','2111','m2@gmail.com');
insert into member0630(member_name, member_password, email) values ('m3','3111','m3@gmail.com');
insert into member0630(member_name, member_password, email) values ('m4','4111','m4@gmail.com');
insert into member0630(member_name, member_password, email) values ('m5','5111','m5@gmail.com');

select * from member0630;

drop table if exists board0630;
create table board0630(
	board_id bigint not null auto_increment,
    board_title varchar(100) not null,
    board_content varchar(255) not null,
    board_writer varchar(100) not null, -- 외래키 설정(참조키의 타입과 같고 호환가능한 타입이어야 한다)
    create_time datetime default current_timestamp, -- 자동으로 글작성 시간 설정
    primary key(board_id)
);

desc board0630;    

-- 외래키 설정 -> 참조키에 설정도니 값이외의 값을 입력할 수 없다
alter table board0630 -- 외래키(FK)가 있는 테이블
add foreign key(board_writer) -- 외래키 칼럼명
references member0630(email); -- 참조테이블(참조키 -> 기본키나 기본키 성질)  
    
insert into board0630(board_title, board_content, board_writer) values('제목1', '내용1', 'm1@gmail.com');
insert into board0630(board_title, board_content, board_writer) values('제목2', '내용2', 'm1@gmail.com');
insert into board0630(board_title, board_content, board_writer) values('제목3', '내용3', 'm3@gmail.com');
insert into board0630(board_title, board_content, board_writer) values('제목4', '내용4', 'm3@gmail.com');
insert into board0630(board_title, board_content, board_writer) values('제목5', '내용5', 'm5@gmail.com');

-- 전체 게시글
select * from board0630 order by create_time desc;
select count(*) from member0630 where member_id=9;


-- m1@gmail.com 게시글 조회, 게시글 수 -- ~~별 '작성자별'
select count(*) board_writer from board0630 group by board_writer; 
select count(*) board_writer from board0630 group by board_writer order by board_writer desc; 
-- m1@gmail.com 게시글 조회 두테이블의 inner join(내부조인)으로 조회
select count(*)
from member0630 as m inner join board0630 as b
on m.email=b.board_writer
where m.email='m1@gmail.com';

-- 게시글만 조회
select b.*
from member0630 as m inner join board0630 as b
on m.email=b.board_writer;

-- 게시글 내용
select b.content.*
from member0630 as m inner join board0630 as b
on m.email=b.board_writer;

-- 그룹 조회(그룹화 될수 있는 칼럼, 숫자형 타입)
select count(*) as 작성글수 from board0630 group by board_writer having board_writer='m1@gmail.com'; 
    
-- 최신글 순으로 정렬

-- m2@gmail.com 작성한 게시글 조회(제목, 내용, 작성시간)
select b.board_title as 글제목, b.board_content as 글내용, b.create_time as 작성시간 , b.board_writer as 글쓴이
from member0630 as m inner join board0630 as b
on m.email=b.board_writer
where m.email='m3@gmail.com' order by b.create_time desc;

select * from board0630;

