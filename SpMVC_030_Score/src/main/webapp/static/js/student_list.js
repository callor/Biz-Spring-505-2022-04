document.addEventListener("DOMContentLoaded", () => {
  const list_body = document.querySelector("div.student.body");

  list_body?.addEventListener("click", (e) => {
    const li = e.target;
    const ul = li.closest("UL");
    const st_num = ul.dataset.stnum;

    document.location.href = `${rootPath}/student/detail?st_num=${st_num}`;
  });
});
