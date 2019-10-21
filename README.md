# Java를 활용한 파일 다운로드 방식 비교

## 목표
데이터 전송시 큰 크기(1GB이상)의 파일을 전송하는 방식에 대한 비교
비교 대상
1. DB에서 파일을 만든 후 파일 단위로 전송
2. DB에서 다운로드할 전체 데이터를 JVM에 load 후 전송
3. DB에서 stream을 받아 outputstream으로 전송

## 개발 프레임워크
 - IDE : STS-4.2.2.RELEASE
 - Java : openjdk 12.0.1
 - Spring Boot : 2.1.7
 - Gradle : 5.6
 
## DB연동
### MongoDB
`docker run -p 27017:27017 mongo`


## 샘플 데이터
 - 주기 : 1초, 하루기준 데이터 수 : 86400개, 1.48GB
 
## API 목록
 - 데이터 구축 : Post /data/init
	 - 파일 생성 :
	 	- resource/sample에 파일이 존재하지 않을 경우 수행
	 	- properties에 data-path 설정 필요
	 - MongoDB 구축
	 	- DB : rawdata
	 	- table : rawdata
	 	- pk명칭의 컬럼으로 구분하여 데이터 추가 
 - 다운로드
	 - 파일기반 다운로드 : Get /data/file/{cycle}/{day}
	 - 데이터 로드후  다운로드 : Get /data/db/load/{cycle}/{day}
	 - Streaming기반 다운로드 : Get /data/db/stream/{cycle}/{day}
	 - Streaming기반 다운로드 - find함수에 stream()호출 : Get /data/db/stream/find/{cycle}/{day}
	 
## 다운로드 성능 비교
 - 파일기반 다운로드
 	- 클라이언트의 다운로드 반응 시간 : 즉시
 	- CPU load : 20%
 	- JVM load : 322MB
 - DB기반 데이터 로드후  다운로드
 	- 클라이언트의 다운로드 반응 시간 : 약 17초(DB에서 데이터를 가져오는 시간에 종속)
 	- CPU load : 20%
 	- JVM load : 3,000MB
 - DB기반 Streaming기반 다운로드
 	- 클라이언트의 다운로드 반응 시간 : 즉시
 	- CPU load : 12%
 	- JVM load : 400MB
 - DB기반 Streaming기반 다운로드 - find함수에 stream()호출
 	- 클라이언트의 다운로드 반응 시간 : 
 	- CPU load : 
 	- JVM load : 

## 이슈

### CSV로 다운로드시 한글이 깨질때 해결
```java
response.setContentType("text/csv;charset=EUC-KR");

PrintWriter out = response.getWriter(); 
out.println("한글입니다.")
```