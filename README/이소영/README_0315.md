# 2022.03.15

### ✔ 오늘의 할 일

- [x] API 설계서 작성하기
- [x] A형 모의 역량 테스트 참여하기



### 💻 API 설계서

````
# API 명세서
- ### 기본 포트 : http://localhost:9999/api/v1  |   http://j6b206.p.ssafy.io:9999/api/v1
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
---

### 뉴스 검색 카테고리

### 뉴스 검색 검색어 

### 뉴스 검색 상세검색

### 뉴스 상세보기

  
## 통계
---
### 데이터 비율

### 인기 키워드

### 뉴스 현황 차트

### 워드 클라우드
````

👉 뉴스 및 통계 부분은 개발을 진행하면서 데이터가 어떠한 방식으로 넘어오는지를 확인하고 작성할 예정



### 📁 일과 후 할 일

1️⃣ A형 모의 역량 테스트 리뷰

2️⃣ 알고리즘 학습

3️⃣ 개발 관련 개인 학습