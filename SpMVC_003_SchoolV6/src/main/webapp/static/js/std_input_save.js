const st_num_fetch = (st_num) => {
  // fetch(rootPath+"/student/st_num_check?st_num="+ st_num.value);
  fetch(`${rootPath}/student/st_num_check?st_num=${st_num}`)
    .then((res) => res.text())
    .then((result) => {
      if (result === "USE") {
        alert("이미 등록된 학번\n다시 입력하에요");
        return false;
      } else {
        alert("사용 가능한 학번입니다");
        return true;
      }
    });
};

const save_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  const st_name = document.querySelector("input[name='st_name']");
  const st_dept = document.querySelector("input[name='st_dept']");
  const st_grade = document.querySelector("input[name='st_grade']");
  const st_addr = document.querySelector("input[name='st_addr']");
  const st_tel = document.querySelector("input[name='st_tel']");

  // JS 코드를 사용하여 Client Size Validation 을 수행
  // JS 코드를 사용하여 Front 단에서 유효성 검사
  // 값을 입력하지 않았을때
  // 경고 메시지를 보여주고 유효성 검사 중단
  if (st_num.value === "") {
    alert("학번은 반드시 입력해야 햡니다");
    st_num.focus();
    return false;
  }

  const st_num_yes = st_num_fetch(st_num.value);
  if (!st_num_yes) {
    st_num.value = "";
    st_num.focus();
    return false;
  }

  if (st_name.value === "") {
    alert("이름은 반드시 입력해야 합니다");
    st_name.focus();
    return false;
  }

  if (st_dept.value === "") {
    alert("학과는 반드시 입력해야 합니다");
    st_dept.focus();
    return false;
  }

  if (st_grade.value === "") {
    alert("학년은 반드시 입력해야 합니다");
    st_grade.focus();
    return false;
  }

  /*
     Number() 함수
     JS 에서 문자열형 숫자를 숫자형으로 바꾸는 함수
  
     parseInt() 함수 
     문자열형 숫자를 정수형 숫자로 바꾸는 함수
  
    문자열형 숫자를 숫자로 바꾸려고 할때
    숫자형이 아닌 다른 데이터가 포함되어 숫자로 바꿀수 없을 경우
    Java 에서는 NumberFormatException 이 발생하고 코드가 중단된다
    코드 중단을 방지하기 위하여 try-catch 로 처리를 해주어야 한다
  
    그런데
    JS 에서는 그러한 상황에 Exception 이 발생하는 대신
    NaN(Not a Number : 숫자가 아니다) 이라는 값을 return 한다
  
    JS 에서 사용되는 특별한 데이터들이 있다
    NaN(숫자가 아니다), undefinded(정의되지 않은 변수)
    null, 0 등등 몇몇의 데이터는 특별하게 사용된다
    변수에 이러한 값들이 저장되어 있을때
    if(변수) 명령문 에서는 false 가 된다
     */
  const num_grade = Number(st_grade.value);

  // 아래의 if() 명령문은 num_grade 에 담긴 값이
  // NaN 이면 이라고 물어보는 명령이다
  if (!num_grade) {
    alert("학년은 숫자로만 입력하세요");
    st_grade.value = "";
    st_grade.focus();
    return false;
  }

  if (num_grade < 1 || num_grade > 4) {
    alert("학년은 1~4 범위내에서 입력하세요");
    st_grade.value = "";
    st_grade.focus();
    return false;
  }

  if (st_tel.value === "") {
    alert("전화번호는 반드시 입력하세요");
    st_tel.focus();
    return false;
  }
  if (st_addr.value === "") {
    alert("주소는 반드시 입력하세요");
    st_addr.focus();
    return false;
  }

  // 이제 모든 유효성 검사를 정상적으로 통과 했으므로
  // 서버로 데이터를 전송하자
  const form = document.querySelector("form");
  form.submit();
};
