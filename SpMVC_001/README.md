# @Controller에서 JSP 로 데이터 보내기
* @Controller에서 model 에 담아서 보내는 Attribute 들은 JSP 를 rendering 할때 변수로 변환되어 ${변수명} 형식으로 표시할수 있다
* @Controller 의 메서드에서 model.addAttribute() 메서드를 사용하여 변수를 선언하고, JSP 로 전달할 값을 저장할수 있다.
* @Controller 의 메서드를 선언할때 arugment 로 Model type 의 변수를 선언한다.
* 선언된 변수의 addAttribute() 메서드를 사용하여 JSP 로 전달할 값을 설정한다

```
	@RequestMapping()
	public String method(Model model) {
		model.addAttribute("value", 30);
		return "home";
	}
```	
* 위 코드에서 method() 의 매개변수로 선언된 model 변수에 value 라는 이름으로 Attribute를 추가하고, value Attribute 에 30이라는 값을 설정하였다.
* home.jsp 파일이 rendring 될때 파일의 코드중에 ```${value}``` 라는 부분이 있으면 30 이라는 값으로 대체되어 html 코드가 생성된다.

## EL(Expression Lang.) tag
* @Controller 에서 전달된 Attribute 에 담긴 데이터를 표시 하는 용도 : ${변수명}
* 순수 JSP 코드에서는 ```<%= request.getParameter("변수명"); %>``` 처럼 사용하던 코드를 ```${변수명}``` 과 같이 간단한 코드로 대체하였다.
* EL tag 에서는 4 칙연산과 간단한 비교연산, 논리연산을 수행할 수 있다.
