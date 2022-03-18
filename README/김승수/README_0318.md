# 2022-03-18 ✨

## 오늘 한 일 💡
1. JIRA의 활용 - 유튜브 라이브 수업 
2. Git branch, master브랜치로 전부 merge하기
3. 중간발표

# JIRA

### | JIRA의 활용

:white_check_mark: SSAFY 프로젝트 수행 중 적용하면 좋은 기능 



### | 시연순서

:white_check_mark: BP 사례 소개

:white_check_mark: Component

:white_check_mark: Bulk

:white_check_mark: Watchers and mention

:white_check_mark: Releases



## :white_check_mark: BP 사례 소개

- 우선순위가 잘 정리 되어 있다.
- 에픽, 테스크, 서브테스크가 잘 정리되어 있다.
- 네이밍 규칙이 있다



## :white_check_mark: Bulk

> Jira Issue를 일괄 수정(Bulk edit)하기 위해 사용된다.

### [사용자 가이드 바로가기](https://confluence.curvc.com/display/ASD/Jira+Issue+Bulk+Edit)

### 방법

1. 이슈를 검색한다
2. 오른쪽 상단에 도구(tools) -> 대량 변경에서 이슈 숫자 선택한다.
3. 이슈 리스트에서 수정을 원하는 이슈를 선택한다.
4. 수정 옵션을 선택한다 
   - 이슈 편집 : 필드의 특정 값 변경
   - 이슈 이동 : 이슈를 다른 프로젝트로 이동
   - 이슈 전환 : 이슈 상태를 In Progress에서 Done으로 변경
   - 이슈 삭제 : 이슈 삭제
   - 이슈 지켜보기
   - 이슈 지켜보기 중단
5. 변경 필드 및 값을 선택한다
6. 변경 내용을 확인하고 이상이 없을 경우 변경을 수행한다
7. 변경 처리 및 완료한다.



## :white_check_mark: Watchers and mention

### Watchers

> 이슈를 지켜보는 사람을 등록한다

### 방법

1. JIRA Administration menu > Projects
2.  변경하려는 프로젝트 선택
3. 좌측 메뉴에서 "Permission" 선택
4. 우측 맨 위의 Actions > Edit permissions 선택
5. **Voters & Watchers Permissions section으로 이동**
6. Manage Watchers의 Edit 선택
7. Grant permission popup 창에서 Group 선택 > Anyone 선택 > Grant 선택



### Mention

- 팀원을 @로 태그 할 수 있다.



## :white_check_mark: Component vs Labels

### Labels

- 지라 모든 프로젝트에서 사용하는 Tag들이 모두 올라온다
- 신뢰도의 문제가 생길 수 있다

### Component

### [사용자 가이드 바로가기](https://confluence.curvc.com/pages/viewpage.action?pageId=29949959)

- 이 프로젝트에서 사용하고 있는 Tag만 올라온다
- 데이터 오염이 상대적으로 적다 (컴포넌트를 수정할 수 있는 권한은 매니저만 가능하다)



## :white_check_mark: Releases

> 배포 스케쥴을 정할 때, "그때까지는 이것들은 배포하자" 라고 정하는데 그것을 핸들링하는 것이 releases 이다.

- 스프린트와 따로 관리 할 수 있다.

### 방법

Fix Version 에 releases 할당 한다.

Release에 들어가서 진행상황을 그래프로 한 눈에 볼 수 있다.



## 정리

- 지라는 로깅 뿐만 아니라 `커뮤니케이션`의 도구이다.
- 싸피를 하면서  releases와 component는 꼭 써보자!


## 느낀 점 🙄
```
다른 팀들 모두 멋진 아이디어와 뛰어난 기획능력으로 좋은 발표를 보여줬다.  
보면서 정말 괜찮은 아이디어라고 생각된 몇개의 팀도 있었다.  
우리팀 역시 괜찮은 아이디어였는데 아이디어가 상당히 겹치는 팀이 있었다.  
왠지 그 팀과 협업과 경쟁을 동시에 할 것 같은 느낌이다...  
기술적으로 공유도 하고 서로 더 나은 서비스를 만들기 위해 좋은 관계가 형성될 것 같다.
```
## 내일 할일 🧐
1️⃣ master 브랜치 머지
2️⃣ 중간발표

