document.addEventListener("DOMContentLoaded", () => {
  const navs = document.querySelectorAll("nav li");

  const navs_click = (e) => {
    const nav = e.target;
    let url = `${rootPath}/`;
    if (nav.innerText === "학생정보") {
      url += "student";
    } else if (nav.innerText === "성적정보") {
      url += "score";
    }
    document.location.href = url;
  }; // end navs_click

  // querySelectAll 을 통해서 배열로 가져온 li tag 들에
  // 공통 event 설정하기
  for (const nav of navs) {
    nav.addEventListener("click", navs_click);
  }
});
