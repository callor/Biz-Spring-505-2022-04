# 이미지 파일을 갖는 게시판
* 이미지 겔러리 
* 이미지 파일 업로드 기능

## 이미지 파일 업로드를 위한 Dependency 설정하기
* Spring Framework 에서는 기본적으로 파일 업로드를 지원하지 않는다.
* 파일 업로드를 구현하기 위하여 별도의 Dependency 를 가져오기
* Apache 재단에서 제작한 파일 업로드 도구
```
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
```
```
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
```

## 파일 업로드를 위한 bean 설정
* 파일 업로드를 위한 bean 은 root-context.xml 에 작성한다
* root-context.xml 은 프로젝트 전반에서 component(Controller, Service, Dao) 와 함께 다양한 package 의 클래스들이 공통으로 사용할 bean 을 설정하는 부분 대표적인 부분이 파일 업로드와 관련된 bean 이다
* servlet-context.xml 은 주로 controller, service 와 관련된 bean 을 주로 설정한다.

* fileUploadResolver 설정
* fileUploadResolver 에는 동시에 업로드 할수 있는 파일의 크기를 지정해준다
* ```maxUploadSizePerFile``` : 한개의 파일 업로드 제한용량
* ```maxUploadSize``` : 여러개의 파일을 업로드 할때 전체 제한 용량

```
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<property name="maxUploadSizePerFile" value="2000000"/>
	<property name="maxUploadSize" value="20000000"/>
</bean>
```
## Upload 를 위한 form 설정
```
<form method="POST" enctype="multipart/form-data">
```
* 파일 업로드를 하기 위해서는 form tag 의 method 를 반드시 POST로 설정해야 한다. 파일 첨부를 위해서는 method를 절대 GET으로 설정하면 안된다
* enctype 을 설정한다. 기본값은 text 를 업로드하는 형식으로 지정이 되는데 이 type 을 ```multipart/form-data```로 지정해 주어야 한다.

* 업로드할 파일을 선택하기 위하여 ```type=file``` 인 input tag를 설정해 준다
* type 이 file 인 tag 의 이름은 Controller 의 VO 매개변수의 변수 이름에 포함되지 않아야 한다.
```
<input type="file" name="file" accept="image/*">
```

## Controller method 설정
* Controller의 method 중 이미지를 수신할 곳에 파일 수신 매개변수 설정
* ```@RequestParam("file")``` : form 의 type이 file 인 input tag에 붙여진 name 속성값

* form 에서 file 이라는 input tag 에 담겨서 전달된 파일 관련 데이터를 받을 매개변수
```
@RequestParam("file")  MultipartFile file)
```









