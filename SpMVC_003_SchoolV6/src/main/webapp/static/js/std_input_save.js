/*
  비동기 방식의 코드문제로
  return false 또는 return true 가 실행되지 않는 문제를 해결하기 위하여
  Promise(약속, 보장) 방식으로 코드를 변경한다
  함수 선언문에 async 키워드를 부착
  실행 순서를 임의로 조절하기 위하여 
  각 함수 호출문에 await 키워드를 부착한다
*/
const st_num_fetchV2 = async (st_num) => {
  const res = await fetch(`${rootPath}/student/st_num_check?st_num=${st_num}`);
  const result = await res.text();
  if (result === "USE") {
    return false;
  } else {
    return true;
  }
};

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
    }); // end fetch
  // fetch 가 완료되기 전에 실행되어 st_num_fetch 가 종료됨
  // 이 함수가 true 나 false 를 return 할 것으로 기대하고
  // 작성을 했으나 비동기 방식의 이유로
  // 중간의 return 명령이 실행될 기회를 잃는다
}; // end st_num_fetch()

// save_cb 함수를 Promise 방식으로 변경
const save_cb = async () => {
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

  // st_num_yes 에 true 나 false 가 담길것으로 기대하고 있다
  // const st_num_yes = st_num_fetchV2(st_num.value);
  // st_num_fetchV2(st_num.value).then((st_num_yes) => {
  //   console.log("st_num_yes : ", st_num_yes);
  //   if (!st_num_yes) {
  //     st_num.value = "";
  //     st_num.focus();
  //     return false;
  //   }
  // });
  // 서버에 학번 중복검사를 의뢰하고 기다리기
  const st_num_yes = await st_num_fetchV2(st_num.value);
  console.log("st_num_yes", st_num_yes);
  if (!st_num_yes) {
    alert("이미 등록된 학번입니다\n다시 확인하세요");
    st_num.focus();
    return false;
  }

  // false 가 담기면 학번항목을 clear 하고 focus() 를 담는다
  // 중복된 학번일 경우가 해당한다.
  // if (!st_num_yes) {
  //   st_num.value = "";
  //   st_num.focus();
  //   return false;
  // }

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
