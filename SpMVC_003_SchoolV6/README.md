# Spring CRUD 구현

## VO 클래스 디자인(추상화, 클래스 선언)

## 입력 Form 화면을 디자인
## Form 에서 데이터를 입력하고 전송 데이터 유효성 검사
* Form 에서 입력한 데이터를 유효성 검사를 수행하는 것은  
서버로 데이터를 보내기전에 입력한 사용자에게 데이터가 잘 입력되었나  
확인시키는 절차
* Client Side Validation 이라고 하는데, 보통 이때 JS 코드로 수행한다
* 데이터를 입력하고 저장(전송) button click 하면 Form 에 담긴 데이터는 무조건 서버로 전송이된다
* 이러한 상황이 되면 JS 코드를 사용하여 Client Size Validation을 수행할수 없다.
* Form 에 포함된 모든 버튼의 기본 속성을 무력화하여 무조건 데이터가 서버로 전송되는 것을 방지시켜야 한다.
* Form 에 포함된 버튼의 기본속성이란 버튼을 클릭했을 때 submit event 가 자동으로 수행되는 것을 말한다
* 아래와 같이 form tag 로 감싸진 button 은 클릭했을 때 무조건 form tag의 action 주소로 서버에 요청하도록 사전에 정의 되어 있다
* form tag 내의 button에는 submit 이라는 default event 가 자동으로 설정된다.
* 이러한 상황에서는 JS 코드를 사용하여 데이터 유효성 검사를 할 수 없다
* 때문에 button sumbit event 를 무력화 시켜야 한다.
```
<form action="/school/score">
	<button class="btn-red">서버로 보내기</button>
</form>
```
* form tag 내의 button 은 기본 type 이 ```type="submit"``` 이다
* button 을 클릭하면 서버로 무조건 달려가는 event 가 실행된다.
* 이 button type 을 ```type="button"``` 으로 설정하면 submit event  가 무력화 된다.
```
<form action="/school/score">
	<button type="button" class="btn-red">서버로 보내기</button>
</form>
```

* 또다른 방법으로 form 의 submit() event 를 가로채는 방법도 있다.


## Controller 에 데이터 수신할 method 처리
## Service 로 데이터 전송
## Dao 를 통해서 DBMS insert 요청

## Dao 를 통해서 DBMS 에게게 Select 요청
## Service 에 받고
## Controller 로 return
## JSP 에 View Rendering 수행

## Console 메시지 출력
* 보통 Java 애플리케이션에서는 ```System.out.print()``` 메서드를 사용하여 Console 에 메시지를 출력한다
* 하지만 서버 애프리케이션에서는 절대 ```System.out.print()``` 를 사용하지 않는다
* 서버는 Console 에 출력되는 메시지를 Log 파일로 기록하기도 하는데 경우에 따라 Console 출력을 기록하다가 서버의 저장장치 용량이 과 소비되어 서버가 다운 되는 경우도 있다.
* 서버 애플리케이션을 개발, 테스트하는 단계에서는 현재 진행되는 상황을 Console 출력으로 모니터링을 해야할 경우가 많다
* 서버 애플리케이션을 배포(운영하기 위해 실제 사용하는 서버에 업로드)할때는 Console 출력을 모두 제거해야 한다.
* 서버 애플리케이션을 Console 출력을 상황에 따라 제어할수 있도록 관리한다.
* Spring 서버 애플리케이션에서는 ```slf4j``` 를 사용하여 Console 출력 상황을 관리한다.
* ```slf4j``` 인터페이스 적인 성격으로 단독으로 사용하지 않는다
* ```slf4j```를 구현한 클래스와 함께 사용한다. spring 에서는 여러가지 종류의 클래스가 존재하는데, 최근 경향은 ```logback``` 을 많이 사용한다.

## slf4j 와 logback 설정하기
* pom.xml 에 Dependency 설정
```
<!-- Logging -->
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-api</artifactId>
	<version>${org.slf4j-version}</version>
</dependency>

<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-classic</artifactId>
	<version>1.2.11</version>
</dependency>
```
* 각 Depndency 의 버전은 상황에 따라 적절히 확인 후 사용한다
* 주의할 것 : logback-classasic Dependency 를 설정할때는   
```<scope>test</scope>``` 항목을 반드시 제거해야 한다.

## slf4j Logger 사용하기
* 사용하고자 하는 클래스의 클래스영역에 다음 변수를 선언한다
```
 static final Logger log 
		= LoggerFactory.getLogger(HomeController.class);
```		
* getLogger() 메서드에는 현재 클래스를 주입하여 준다

* import 주의 : org.slf4j.* 인지 확인할 것
```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
```




