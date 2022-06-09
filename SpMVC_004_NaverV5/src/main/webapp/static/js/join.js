document.addEventListener("DOMContentLoaded", () => {
  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re_password");
  const email = document.querySelector("#email");
  const name = document.querySelector("#name");
  const nickname = document.querySelector("#nickname");
  const btn_join = document.querySelector("#btn-join");

  btn_join?.addEventListener("click", () => {
    if (username.value === "") {
      alert("USER NAME 은 반드시 입력하세요");
      username.focus();
      return false;
    }

    if (username.value.length > 20) {
      alert("USER NAME 은 20자 이내로 입력하세요");
      username.focus();
      return false;
    }

    if (username.value.toUpperCase() === password.value.toUpperCase()) {
      alert("USER NAME 과 비밀번호는 같을수 없습니다");
      password.focus();
      return false;
    }

    // 문자, 숫자, 특수문자가 포함된 8자리 ~ 15자리까지 문자열 검사패턴
    const passRule2 =
      /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

    // 숫자와 문자를 포함하는 6자리 ~ 12자리의 문자열 검사패턴
    const passRule = /^[A-Za-z0-9]{6,12}$/;

    // password.value 의 값이 패턴에 일치하지 않으면
    if (passRule2.test(password.value) === false) {
      alert(
        "비밀번호는 특수문자, 영문자, 숫자 포함 \n8자리 ~ 15자리 까지 입력하세요"
      );
      password.focus();
      return false;
    }

    if (re_password.value === "") {
      alert("비밀번호 확인을 입력해 주세요");
      re_password.focus();
      return false;
    }

    if (password.value !== re_password.value) {
      alert("비밀번호 확인 값이 일치하지 않습니다");
      password.value = "";
      re_password.value = "";
      password.focus();
      return false;
    }

    const emailRule =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if (!emailRule.test(email.value)) {
      alert("이메일 형식이 잘못되었습니다 다시 입력해주세요");
      email.focus();
      return false;
    }
    document.querySelector("form.join")?.submit();
  });
});
