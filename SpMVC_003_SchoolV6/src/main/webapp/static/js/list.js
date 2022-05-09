document.addEventListener("DOMContentLoaded", () => {
  const std_input = document.querySelector("button.std-input");
  if (std_input) {
    std_input.addEventListener("click", () => {
      document.location.href = `${rootPath}/student/input`;
    });
  }
});
