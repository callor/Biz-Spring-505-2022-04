const std_num_check_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  if (st_num.value === "") {
    alert("중복검사를 하려면 학번을 먼저 입력하세요");
    st_num.focus();
    return false;
  }
  // alert("입력한 학번 : " + st_num.value);
  if (!std_num_check_cb(st_num.value)) {
    st_num.focus();
  }
};

document.addEventListener("DOMContentLoaded", () => {
  const std_num_check = document.querySelector("button.std-num-check");

  /*
  std_num_check click event handler 를
  std_num_check_cb 이라는 함수로 별도 선언하고
  handler 에는 함수 이름을 매개변수로 전달하였다
  이때 함수이름에는 절대 () 를 붙이지 않다
  */
  if (std_num_check) {
    std_num_check.addEventListener("click", std_num_check_cb); // end callback
  }

  // 현재 html 화면에 있는 클래스가 std-save 인 버튼을 챙겨서
  // 핸들링할 준비를 해달라
  const std_save = document.querySelector("button.std-save");
  // std_save 가 정상적으로 준비되었느냐
  if (std_save) {
    std_save.addEventListener("click", save_cb);
  }
});
