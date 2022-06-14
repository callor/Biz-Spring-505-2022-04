document.addEventListener("DOMContentLoaded", () => {
  const select = document.querySelector("select.dayset");

  select.addEventListener("change", (e) => {
    const current = e.currentTarget;
    const sc_num = current.value;
    const sc_id = current.dataset.sc_id;
    document.location.href = `${rootPath}/workout/dayset/${sc_id}/${sc_num}/`;
  });
});
