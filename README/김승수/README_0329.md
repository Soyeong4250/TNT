# 2022-03-29 ✨

## 오늘 한 일 💡
1. BDD/Cucumber 및 자율 프로젝트 안내 - 유튜브라이브
2. 하둡에코시스템, 하둡 클러스터 서버 구조 설계
3. 크롤링 저장 방식 수정
4. 크롤링 기사시간 오류 수정

## Sqoop
> Sqoop (SQL to Hadoop)은 다음과 같이 관계형 데이터베이스(RDB)와 분산 파일 시스템(HDFS) 사이의 양방향 데이터 전송을 위해 설계된 툴이다. 오직 두 포인트 사이의 데이터 통신을 쉽게 다루기 위해서 개발된 프로젝트이다.

![sqoop](https://bygritmind.files.wordpress.com/2020/09/image-4.png?w=470)

+ 보통 원천 데이터는 RDB에 존재한다.
+ 스트리밍용 하둡 에코시스템을 구축한다하더라도 메타 데이터 또는 분석 결과물 등을 저장하기 위해서 RDB를 사용할 필요성이 높다.
+ 어떤 프로젝트든지 **RDB**와 **HDFS** 사이의 통신이 필수적인 요소가 되었고 이 일만 전문적으로 하기 위해 **Sqoop**이 등장했다.

### Sqoop의 동작 방식
1. Sqoop은 하둡의 리소스 관리자인 YARN과 MapReduce, HDFS 위에서 동작한다. 
2. 장점으로 단순히 CLI (Command Line Interface)로 sqoop을 실행할 수 있다.
3. 각 기능마다 한 줄의 CLI로 작성하면 되기에 복잡한 통신 프로세스를 쉘로 통합하여 쉽게 작성할 수 있다.

![sqoop동작방식](https://bygritmind.files.wordpress.com/2020/09/image-5.png?w=631)

## Nutch
> 아파치 너치(Apache Nutch)는 루씬을 기반으로 하여 만든 오픈 소스 검색 엔진이다. 루씬을 기반으로 하였지만 웹 크롤러는 처음부터 다시 만들었다. 여러 가지 플러그인을 붙일 수 있도록 모듈화가 잘 되어 있다. 현재 아파치의 하위 프로젝트이다. 완전히 자바로 작성되어 있지만 자료는 특정 언어와 관계없는 형식으로 저장된다. 100만 페이지 정도를 검색할 수 있다. 여러 대의 머신에서 수행될 수 있도록 맵리듀스와 분산파일처리를 구현하였는데, 이제는 하둡이라는 하위 프로젝트를 통하여 따로 관리되고 있다.

### Apache Nutch 의 구조

![너치구조](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F6zPRv%2Fbtq8okYZ1Az%2FcmywFmbpU6imhTgpH8jmW0%2Fimg.png)

1. Inject
	+ Text 파일 형태의 Seed URL을 Nutch가 URL을 관리하기 위한 메타데이터 저장소에 추가하는 작업을 한다. 크롤링의 시작 URL 역할을 하며 크롤링 중간에 새로운 URL을 강제적으로 주입시키는 역할도 한다.
2. Generate
	+ CrawlDB에 저장된 URL 중 1 cycle (inject→generate→fetch→parse→dbupdate)에 방문할 URL n개를 추출하는 역할을 한다. 이렇게 추출된 URL은 generated URL이라고 부르며 Segment라는 단위로 저장된다.
3. Fetch
	+ Generated된 URL을 방문하여 HTML Raw 파일을 다운받는 역할을 한다. 
4. Parse
	+ Fetched된 HTML 파일을 link, text, metadata로 분리하여 나누어 저장하는 역할을 한다.
5. DBUpdate
	+ segment에 추가된 새로운 데이터를 crawlDB에 추가한다. Apache Nutch는 기존 URL들과 새로운 URL을 합쳐 score, 크롤링 시각, signature(중복 판단을 위한) 등의 정보를 저장한다.
	
### 특화플젝 하둡에코시스템 구조
아파치 너치로 크롤링 및 파싱 -> HDFS저장 -> MapReduce로 분산처리 -> 스쿱을 통해 MariaDB로 export

## 느낀 점 🙄
```
하둡 클러스터 서버의 슈퍼계정의 권한이 교육생에게 없다는 것을 알았다.
전문가 리뷰 시간에 클러스터서버에서 데이터 수집 및 처리를 수행하는 것이 맞다고 들어서,   
클러스터서버에 환경구축을 하려다가 apt-get 권한이 없어 진행하지 못했다.  
EC2서버에 하둡시스템을 구축하여 사용하라고 들었지만, EC2서버와 클러스터 서버를 어떤 방식으로 연결하는지... 감도 오지않는다.  
하지만 하둡시스템에 대한 공부를 하다보니 여러 에코시스템의 프로그램을 알게되었고 구현한 코드를 하둡의 프로그램으로 대체할 수 있을것같다.  
여러모로 머리도 아프고 진행도 잘 되지 않는 날이다...
```

## 내일 할일 🧐
1️⃣ EC2서버의 하둡 클러스터 서버 연동방법 찾아보기
2️⃣ EC2서버 환경구축시도
