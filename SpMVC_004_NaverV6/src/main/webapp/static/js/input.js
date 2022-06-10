document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-result");

  // div.modal-result 에 포함된 요소중에서 div.search-content 를 가져와라
  const modal_content = modal_box.querySelector(".search-content");

  const inputs = document.querySelectorAll("input");
  const desc = document.querySelector("textarea");

  const input_index = {
    isbn: 0,
    title: 1,
    author: 2,
    publisher: 3,
    pubdate: 4,
    price: 5,
    link: 6,
    image: 7,
  };

  // 정규식 문법
  // 문자열 중에서 tag 문자열을 무조건 삭제(제거)하기 위한 패턴
  const extractTextPattern = /(<([^>]+)>)/gi;

  const book_isbn = document.querySelector("input#isbn");
  const book_title = document.querySelector("input#title");

  const btn_save = document.querySelector("button.book-save");

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
          .then((result) => {
            inputs[input_index.isbn].value = result.isbn
              .replace(extractTextPattern, "")
              .split(" ")[1];
            inputs[input_index.title].value = result.title;
            inputs[input_index.author].value = result.author;
            inputs[input_index.pubdate].value = result.pubdate;
            inputs[input_index.publisher].value = result.publisher;
            inputs[input_index.price].value = result.price;
            inputs[input_index.link].value = result.link;
            inputs[input_index.image].value = result.image;
            desc.value = result.description.replace(extractTextPattern, "");
            modal_box.style.display = "none";
          });
      } else {
        alert("ISBN 코드를 찾을 수 없음");
      }
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const isbn = inputs[input_index.isbn];
    const title = inputs[input_index.title];
    const author = inputs[input_index.author];
    const publisher = inputs[input_index.publisher];

    if (isbn?.value === "") {
      alert("ISBN 은 반드시 입력하세요");
      isbn.focus();
      return false;
    }
    if (title?.value === "") {
      alert("도서명은 반드시 입력하세요");
      title.focus();
      return false;
    }
    if (author?.value === "") {
      alert("저자는 반드시 입력하세요");
      author.focus();
      return false;
    }
    if (publisher?.value === "") {
      alert("출판사는 반드시 입력하세요");
      publisher.focus();
      return false;
    }

    // click event 가 발생한 tag 에서 가장 가까운 form 을 추출하기
    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); // ContenteLoaded End
