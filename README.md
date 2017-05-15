# 신림 프로그래머 도커 스터디

## 2장

### 테스트 환경 구축

* Java 이미지 Pull & 컨테이너 생성

![생성](./images/java-컨테이너-생성.png)

* 컨테이너 실행 및 접속

![접속](./images/컨테이너-실행-접속.png)

* 컨테이너에 git 설치

```
apt-get update && apt-get install -y git
```

* mysql 이미지 받기 & 컨테이너 설치

```
docker run -d --name study-mysql -e MYSQL_ROOT_PASSWORD=study -e MYSQL_DATABASE=study mysql
```


### 명령어

* ```docker -v```
  * 도커버전 확인

* ```docker ps -a```
  * 도커 전체 컨테이너 확인

* ```docker run```
  * 도커 다운로드 및 실행
  * 컨테이너에 호스트 포트 할당은 run 시에만 가능([참고](http://stackoverflow.com/questions/19335444/how-do-i-assign-a-port-mapping-to-an-existing-docker-container))

* ```docker stop $(docker ps -a -q)```
  * 컨테이너 전체 정지
* ```docker rm $(docker ps -a -q)```
  * 컨테이너 전체 삭제

### 도커 링크

각 컨테이너가 하나의 모듈만 가지게 하고, (스프링부트, MySQL 등에 각각 컨테이너 할당) 서로가 접근할수 있는 옵션은 ```--link```이다. 


### 도커 볼륨

도커 이미지로 컨테이너를 생성하면 이미지는 **읽기 전용**이 되며 **변경 사항은 컨테이너**에서 관리한다.  
즉, 컨테이너 삭제할 경우 MySQL 컨테이너와 같이 데이터베이스의 저장된 데이터도 함께 삭제가 된다.  
이를 해결하기 위해 도커 볼륨으로 **호스트 컴퓨터에 저장**하는 기능을 사용한다.

```
docker run -d -v [호스트 디렉토리 위치]:[컨테이너 디렉토리 위치]
```

> /var/lib/mysql은 MySQL의 기본 데이터 저장위치입니다.

![도커볼륨1](./images/도커볼륨1.png)

> -v옵션은 호스트의 디렉토리를 컨테이너의 디렉토리에 마운트합니다.

### 도커 이미지 배포

* [링크](https://hub.docker.com/)에 접속하여 회원가입 & 로그인 후, ```create repository``` 선택

* 배포하길 원하는 **컨테이너의 name**을 지정하여 배포

```
docker commit [로컬컨테이너 이름] [본인계정명]/[이미지 이름]:[버전]
```

예시)

![도커배포1](./images/도커배포1.png)

* CLI에서 도커허브 로그인

![도커배포2](./images/도커배포2.png)

* 도커 배포

```
docker push [본인계정명]/[이미지 이름]:[버전]
```

![도커배포3](./images/도커배포3.png)

이후부터는 다른 이미지를 사용하는것과 동일하게 사용하면 된다.  
(단, latest가 적용된게 아니라서 이미지 이름 뒤에 항상 tag를 붙여야한다.)

![도커배포4](./images/도커배포4.png)

![도커배포5](./images/도커배포5.png)



![]



