# 2022.03.10

### ✔ 오늘의 할 일

- [x] 유튜브 라이브 시청 - 인공지능 기반 기술의 특화 PJT 기획 : 유상진, 최호근 컨설턴트
- [x] 유튜브 라이브 시청 - 알고리즘 특강 : 서울대 문병로 교수
- [x] 팀 규칙 정하기
- [x] 하둡 개인 학습
- [x] 자치회 회의 참여



### 💬 팀 규칙 정하기

- 시간 엄수

- 스크럼 회의 : 매일 오전 10시

- 프로젝트 집중 시간 : 주말 작업 지양, 9 to 6

- 포지션

  전체 팀장 : 안현호

  부팀장 : 김승수

  프론트 팀장 : 전영서

  백 팀장 : 정희연

  JIRA 담당자 : 이소영

  DevOps : 권영현

  전원 풀스택

- Git & 커밋룰 👉 지난번 정리한대로 진행



### 💻 코드 컨벤션

❗ 기능(Method) 단위로 Commit 최대한 해보기

##### 네이밍

- 왜 존재해야 하는가
- 무슨 작업을 하는가
- 어떻게 사용하는가
- Class 명명 규칙
  - 명사를 사용하되 첫 문자를 대문자로 한다 ex) User
  - DTO 👉 Req, Res로 나누어서 Entity + 기능명 + Http Method + Req/Res ex) UserPostReq
  - Controller, Service, Repository 👉 Entity + Controller, Service, Repository ex) UserController
- Method 명명 규칙
  - 동사로 시작하고, 첫 문자를 소문자로 하며 최대한 자세하게 명명 ex) findNameById
- 변수 명명 규칙
  - 의도를 분명하게 하기 ex) String s (x), String string(O)
  - 맥락을 통해 이해 가능하다면 줄이기 ex) User 클래스의 username 변수 👉 name
- **코드에 반드시 주석 달기**



### 📁 일과 후 할 일

1️⃣ 하둡 개인 학습

2️⃣ 알고리즘 학습