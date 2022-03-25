# 2022.03.24

### ✔ 오늘의 할 일

- [x] 유튜브 시청 - 셀레니움을 이용하여 프로그램 만들기

- [x] Notice 게시판 CRUD 구현
- [x] Notice 게시판 리스트 화면 구현



### 💻 Notice 게시판 CRUD 구현

영현님이 도와주셨다...감사해요 영현님...😀

```
오늘 학습 부분
Entity 👉 DB 칼럼을 구현하기 위한 클래스로, 수정이 일어나면 안됨(@Setter 삭제)
Dto 👉 엔티티와 같은 역할로, 엔티티에 구현한 내용 외에도 추가할 기능이 있다면 Dto에 작성
Service 👉 기본적으로 @Transactonal이 명시되어 있어야 함
			Transaction은 기본적으로 read only 형태로, create, update, delete와 같이 DB내용이 수정되는 곳에는  @Transactional을 명시해주어야 함
orElseThrow() 👉 오류 처리를 하는 구문으로, 앞에 명시해준 요소에 대해 오류가 생기면 ()안의 내용을 실행
				이 외에도 orElse(), orElseGet()이 있음
```



### 📁 일과 후 할일

1️⃣ 알고리즘 학습하기

2️⃣ JPA 학습하기