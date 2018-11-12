
/* Drop Tables */

DROP TABLE agecategory CASCADE CONSTRAINTS;
DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE contestreply CASCADE CONSTRAINTS;
DROP TABLE gendercategory CASCADE CONSTRAINTS;
DROP TABLE myrecipe CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE products CASCADE CONSTRAINTS;
DROP TABLE recipereply CASCADE CONSTRAINTS;
DROP TABLE recipeboard CASCADE CONSTRAINTS;
drop sequence boardseq;
drop sequence myrecipeseq;
drop sequence gendercategoryseq;
drop sequence contestreplyseq;
drop sequence replyseq;
drop sequence agecategoryseq;
drop sequence memberseq;
drop sequence productsseq;
drop sequence recipereplyseq;
drop sequence recipeboardseq;

create sequence recipeboardseq;
create sequence recipereplyseq;
create sequence productsseq;
create sequence memberseq;
create sequence agecategoryseq;
create sequence replyseq;
create sequence boardseq;
create sequence contestreplyseq;
create sequence gendercategoryseq;
create sequence myrecipeseq;


/* Create Tables */

CREATE TABLE agecategory
(
	-- 10대
	ten number,
	-- 20대
	twenty number,
	-- 30대
	thirty number,
	-- 40대
	forty number,
	-- 50대
	fifty number,
	-- 60대 이상
	others number,
	-- 게시판 글 번호
	boardNum number NOT NULL
);


CREATE TABLE board
(
	-- 게시글 번호
	boardNum number NOT NULL,
	-- 작성자
	userId varchar2(100) NOT NULL,
	-- 글 제목
	title varchar2(100),
	-- 글 내용
	content varchar2(100),
	-- 작성날짜
	regdate date DEFAULT SYSDATE,
	-- 조회수
	hitCount number,
	-- 저장된 파일
	savedFile varchar2(1000),
	-- 원래 파일
	originalFile varchar2(1000),
	-- 포인트
	point number,
	PRIMARY KEY (boardNum)
);


CREATE TABLE contestreply
(
	-- 댓글 번호
	replyNum number NOT NULL,
	-- 댓글 작성자
	userId varchar2(20) NOT NULL,
	PRIMARY KEY (replyNum)
);


CREATE TABLE gendercategory
(
	-- 남
	male varchar2(10),
	-- 여
	female varchar2(10),
	-- 게시판 글 번호
	boardNum number NOT NULL
);

CREATE TABLE member
(
   -- 회원이름
   userName varchar2(100) NOT NULL,
   -- 회원 비밀번호
   userPwd varchar2(100) NOT NULL,
   -- 회원 ID
   userId varchar2(100) NOT NULL,
   -- 성별
   gender varchar2(100) DEFAULT '남자',
   -- 생년월일
   birth date DEFAULT SYSDATE,
   -- 주소
   address varchar2(1000) NOT NULL,
   -- 이메일 아이디
   emailAccount varchar2(100) NOT NULL,
   -- 이메일 도메인
   emailDomain varchar2(100) NOT NULL,
   -- 인증여부
   verify char DEFAULT 'N',
   -- 포인트
   point number DEFAULT 0,
   -- 권한 (admin/user)
   authority varchar2(20) DEFAULT 'user',
   -- 회원번호
   userNum number,
   PRIMARY KEY (userId)
);


CREATE TABLE myrecipe
(
	-- 회원 ID
	userId varchar2(20) NOT NULL,
	-- 게시판 글 번호
	boardNum number NOT NULL
);

    select * from products;
    CREATE TABLE products
    (
       -- 특산물 번호
       productsNum number NOT NULL,
       -- 특산물 이름(한국어)
       productsNameKor varchar2(500) NOT NULL,
       -- 특산물 위치
       productsLocation varchar2(500) NOT NULL,
       -- 특산물 특징(한국어)
       productsFeatureKor varchar2(500),
       -- 특산물 사진
       productsPicture varchar2(1000),
       -- 특산물 이름(일본어)
       productsNameJap varchar2(500) NOT NULL,
       -- 특산물 특징(일본어)
       productsFeatureJap varchar2(500),
       PRIMARY KEY (productsNum)
    );


CREATE TABLE recipeboard
(
-- 게시판 글 번호
boardNum number NOT NULL,
-- 글제목
title varchar2(1000),
-- 재료
material varchar2(2000),
-- 용량
amount varchar2(2000),
-- 레시피 또는 조리법
recipe clob,
-- 카테고리
category varchar2(1000),
-- 게시글 조회수
hitcount number DEFAULT 0,
-- 이미지링크
imglink varchar2(1000),
-- 팁
tips varchar2(1000),
-- 작성일
regdate date DEFAULT SYSDATE,
PRIMARY KEY (boardNum)
);


CREATE TABLE recipereply
(
	-- 댓글 번호
	replyNum number NOT NULL,
	-- 댓글
	replyText varchar2(100),
	-- 작성자
	userId varchar2(20),
	-- 게시판 글 번호
	boardNum number NOT NULL,
	PRIMARY KEY (replyNum)
);


CREATE TABLE reply
(
	-- 댓글 번호
	replyNum number NOT NULL,
	-- 댓글
	replyText varchar2(100),
	-- 작성자
	userId varchar2(20),
	-- 게시글 번호
	boardNum number NOT NULL,
	PRIMARY KEY (replyNum)
);

select * from board;
select * from member;
SELECT * FROM products;