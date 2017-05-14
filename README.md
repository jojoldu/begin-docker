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

* 

### 명령어

* ```docker -v```
  * 도커버전 확인

* ```docker ps -a```
  * 도커 전체 컨테이너 확인

* ```docker run```
  * 도커 다운로드 및 실행
  * 컨테이너에 호스트 포트 할당은 run 시에만 가능([참고](http://stackoverflow.com/questions/19335444/how-do-i-assign-a-port-mapping-to-an-existing-docker-container))

* 

