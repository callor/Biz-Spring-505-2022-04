# EMS 프로젝트

## DBMS 연동 도구
* mysql-connector-j
* mybatis
* mybatis-spring
* spring-jdbc
* commons-dbcp

## 파일 업로드 도구
* commons-io
* commons-fileupload

## JSON 관련도구
* jackson-bind

## 메일 전송 도구
```
<dependency>
	<groupId>javax.mail</groupId>
	<artifactId>mail</artifactId>
	<version>1.4.7</version>
</dependency>
```		

## 암호화 도구
* spring security core
* jasypt
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>1.9.3</version>
</dependency>
```
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt-spring31 -->
<dependency>
	<groupId>org.jasypt</groupId>
	<artifactId>jasypt-spring31</artifactId>
	<version>${org.jasypt-version}</version>
</dependency>
```
## 데이터 유효성 검사 도구
* 서버(Controller) 단에서 데이터 유효성 검사 도구
* validation api
```
<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
```
* hibernate validation
```
<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.3.Final</version>
</dependency>
```
* Spring framework 5.x 버전에서는 서버단 유효성검사를 위하여 framework 관련 요소를 추가해 주어야 한다
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context-support</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```		

## MIME type
* 인터넷을 통해서 다양한 형태의 데이터를 보낼때 서버와 웹 브라우저, 클라이언트 간에 데이터의 형식을 지정하는 방식
* 일반적으로 html 데이터는 text/html 형식으로 기본값으로 설정되어 있다
* 만약 html 데이터를 text/plan 형식으로 보내면 웹브라우저에 html tag 가 단순한 문자열로 그대로 노출된다
* MIME type 은 인터넷 환경이 발전할 수록 계속 많아지고 더욱 다양해 진다.
* 현재 주로 많이 사용하는 것은 text/html, image/jpg, video/mp4, audio/mp3, application/json 등이 있다

## 링크를 클릭하여 email 인증하기
1. 이메일을 입력하고 인증하기를 클릭하면
2. 이메일만으로 User table 에 데이터를 insert 한다
3. 이때 role 칼럼에 GUEST 로 설정하여 insert 를 한다
4. email 인증을 클릭하면, 다시 사용자 데이터의 role 을 USER 로 설정한다
5. 만약 이메일 인증이 안된 사용자가 로그인을 시도하면(role 이 GUEST 인 사용자) 이메일 인증이 안되었다는 메시지를 보여준다
6. 이메일 인증이 완료된 사용자만 로그인을 할 수 있도록 한다
7. 사용자 정보를 insert 할때 일단 인증할 email 주소를 username 에 저장하고 비밀번호는 임의 값을 설정한다