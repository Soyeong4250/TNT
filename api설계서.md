# API 명세서
- ### 기본 포트 : http://localhost:9999/api  |   http://j6b206.p.ssafy.io:9999/api
[회원](#회원)  
[공지사항 게시판](#공지사항-게시판)  
[뉴스](#뉴스)
[통계](#통계)  
  

## 회원  
---
### 회원가입
- URL
```
POST /users/register
```
- Request
```json
{  
   "user_name":"String", 
   "user_id": "String",
   "user_pwd": "String",         
   "user_email": "String",
   "user_birth": "DateTime",   
   "user_auth": "Char",
}
```
- Response
```json
SUCCESS{ "code": 200, "message": "Success"}
FAIL {    
    "code": 401, "message": "인증 실패",
    "code": 404, "message": "주소 오류",
    "code": 500, "message": "서버 오류"
}
```
  
### 로그인
- URL
```
POST /auth/login
```
- Request
```json
{
    "user_id":"String",
    "user_pwd":"String"
}  
```
- Response
```json
SUCCESS{ 
    "accessToken" : "String",
    "code": 200, 
    "message": "Success"
}
FAIL {
    "code": 500, "message": "Server Error",
    "code": 401, "message": "유효하지 않은 password"
}
```  

### 내 프로필
-  URL
```
GET /users/<string:user_id>
```
- Request
X
- Response
``` json
SUCCESS{    
   "user_name":"String", 
   "user_id": "String",
   "user_pwd": "String",         
   "user_email": "String",
   "user_birth": "DateTime",   
   "user_reg": "DateTime",
   "user_auth": "Char",
}
FAIL {
    "code": 500, "message": "Server Error",
    "code": 401, "message": "본인의 ID가 아닙니다.",
}
```
### 회원 정보 수정
- URL
```
PUT /users/<string:user_id>
```
- Request
```json
{
   "user_name":"String",
   "user_pwd": "String",   
}
```
- Response
```json
SUCCESS{ "code": 200, "message": "Success"}
FAIL {
    "code": 500, "message": "Server Error",
    "code": 401, "message": "본인의 ID가 아닙니다."
}
```
### 회원 정보 삭제
- URL
```
DELETE /users/<string:user_id>
```
- Request
```
X
```
- Response
```json
SUCCESS{ "code": 200, "message": "Success"}
FAIL {
    "code": 500, "message": "Server Error",
    "code": 401, "message": "본인의 ID가 아닙니다."
}
```  

### 아이디 찾기
- URL
```
POST /users/find/id
```
- Request
```json
{
   "user_name":"String",
   "user_email": "String",   
}
```
- Response
```json
{
    "user:id": "String"
}
```

### 비밀번호 찾기
- URL
```
POST /users/find/pwd
```
- Request
```json
{
   "user_id": "String",
   "user_email": "String",   
}
```
- Response
```json
X // 이메일로 비밀번호(user_pwd) 전달
```
  
## 공지사항 게시판
---
### 공지사항 전체 목록
- URL
```
GET /notice
```
- Request
```
X
```
- Response
``` json
SUCCESS{
    "code": 200, "message": "Success",
    "data":[
        {
            "notice_no": "int",
            "notice_title": "String",
            "notice_writer": "String",            
            "notice_date": "DateTime",
        }
    ]
}
FAIL{
    "code": 500, "message": "Server Error",    
}
```


### 공지사항 게시판 글 상세
- URL
```
GET /notice/<int:notice_no>
```
- Request
```
X
```

- Response
``` json
SUCCESS{    
    "notice_title": "String",
    "notice_writer": "String",            
    "notice_content": "String",
    "notice_date": "DateTime"
}
FAIL{
    "code": 500, "message": "Server Error",
    "code": 404, "message": "해당하는 글이 없습니다."
}
```
### 공지사항 게시판 글 작성
- URL
```
POST /notice
```
- Request
```json
{
    "notice_title": "String",
    "notice_writer": "String",               
    "notice_content": "String"
}
```
- Response
``` json
SUCCESS{
    "code":200,"message":"Success",
}
FAIL{
    "code": 500, "message": "Server Error",
    "code": 401, "message": "글 작성 오류"
}
```
### 공지사항 게시판 글 수정
- URL
```
PUT /notice/<int:notice_no>
```
- Request
```json
{
    "notice_title": "String",          
    "notice_content": "String"
}
```
- Response
``` json
SUCCESS{
    "code":200,"message":"Success",    
}
FAIL{
    "code": 500, "message": "Server Error",
    "code": 401, "message": "글 수정 오류"
}
```
### 공지사항 게시판 글 삭제
- URL
```
DELETE /notice/<int:notice_no>
```
- Request
```json
X
```
- Response
``` json
SUCCESS{
    "code":200,"message":"Success",
}
FAIL{
    "code": 500, "message": "Server Error",
    "code": 401, "message": "글 삭제 오류"
}
```
  
## 뉴스

### 뉴스 크롤링(다른 서버를 이용)
### - PORT 9990
- URL
```
POST :9990/api/news/craw
```
- Header
```
Authorization : c3NhZnlCaWc2aXg=
```
- Request
```json
X
```
- Response
``` json
SUCCESS{
    "code":200,"message":"Success : 크롤링한 뉴스 기사 개수 : n",
}
FAIL{
    "code": 500, "message": "Error : 서버 오류 : 오류 내용",
    "code": 401, "message": "올바르지 않는 Header 값 : 오류 내용"
}
```
---

### 뉴스 카테고리 검색
- URL
```
GET /news/find/category?<string:category>&<int:page>
```
- Request
```json
X
```
- Response
``` json
SUCCESS{
    "content": [
        {
            "no": 141179,
            "title": "\"일촌 신청 받아요\"…싸이월드 '도토리 감성' 돌아온다",
            "category": "IT",
            "date": "2022-04-03T03:04:00.000+00:00",
            "reporter": "윤정원 기자",
            "content": "내용",
            "company": "언론사",
            "tumbnailUrl": "섬네일 url",
            "newsUrl": "news 원문 url"
        },
    ],
        "pageable": {
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 10,
        "pageSize": 10,
        "pageNumber": 1,
        "paged": true,
        "unpaged": false
    },
        "last": false,
        "totalPages": 122,
        "totalElements": 1217,
        "size": 10,
        "number": 1,
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "numberOfElements": 10,
        "first": false,
        "empty": false
}
FAIL{
    "code": 500, "message": "Error : 서버 오류 : 오류 내용",
}
```

### 뉴스 단어 제목 검색 
- URL
```
GET /news/find/title?<string:title>&<int:page>
```
- Request
```json
X
```
- Response
``` 
SUCCESS{
    뉴스 카테고리 검색 결과와 같습니다.
}
FAIL{
    "code": 500, "message": "Error : 서버 오류 : 오류 내용",
}
```

### 뉴스 단어 내용 검색
- URL
```
GET /news/find/content?<string:content>&<int:page>
```
- Request
```json
X
```
- Response
``` 
SUCCESS{
    뉴스 카테고리 검색 결과와 같습니다.
}
FAIL{
    "code": 500, "message": "Error : 서버 오류 : 오류 내용",
}
```

### 뉴스 언론사 검색
- URL
```
GET /news/find/company?<string:company>&<int:page>
```
- Request
```json
X
```
- Response
``` 
SUCCESS{
    뉴스 카테고리 검색 결과와 같습니다.
}
FAIL{
    "code": 500, "message": "Error : 서버 오류 : 오류 내용",
}
```
  
## 통계
---
### 데이터 비율

### 인기 키워드
- URL
```
GET /news/keyword
```
- Request
```json
X
```
- Response
```
SUCCESS{
    [
    "당",
    "코로나",
    ".kr",
    "지난해",
    "이날",
    "위원회",
    "윤석열",
    "있다",
    "관련",
    "정보"
    ]
}
FAIL{
    "code": 500, "message": "Error : 서버 오류 : 오류 내용",
}
```

### 뉴스 현황 차트

### 워드 클라우드



