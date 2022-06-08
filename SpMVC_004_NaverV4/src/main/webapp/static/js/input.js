document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-result");

  // div.modal-result 에 포함된 요소중에서 div.search-content 를 가져와라
  const modal_content = modal_box.querySelector(".search-content");

  const modal_content_table = document.querySelector("table.search-result");

  const inputs = document.querySelectorAll("input");
  const desc = document.querySelector("textarea");

  const book_isbn = document.querySelector("input#isbn");
  const book_title = document.querySelector("input#title");

  /*
        input event
        input tag 에 키보드로 문자를 입력할때마다 발생하는 event
        */
  // if(book_isbn) 을 실행하여 book_isbn 있으면 addEventListener 를 부착하고
  // 만약 book_isbn 객체가 없으면 오류를 발생시키지 말고 실행을 중단하리
  book_isbn?.addEventListener("input", (e) => {
    const isbn = e.target.value;
    if (isbn.length >= 13) {
      alert(isbn);
    }
  });

  book_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      // alert(e.target.value);
      fetch(`${rootPath}/naver/books?title=${e.target.value}`)
        .then((res) => res.text())
        .then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        });
    }
  }); // end book_title

  modal_box.addEventListener("click", (tb) => {
    // table 에 click event 가 발생하면
    // 가장 내부의 tag 정보를 추출하기
    const td = tb.target;
    if (td.tagName === "TD") {
      // td 를 감싸고있는 가장 가까운 영역의 tr 를 추출하기
      const tr = td.closest("TR");
      // 추출된 tr 의 속성중에 data-isbn 으로 설정된 속성의 값을 추출하기
      const codes = tr.dataset.isbn?.split(" ");
      if (codes.length > 1) {
        fetch(`${rootPath}/naver/${codes[1]}/book`)
          .then((res) => res.json())
          .then((result) => console.table(result));
      } else {
        alert("ISBN 코드를 찾을 수 없음");
      }
    }
  });
});
