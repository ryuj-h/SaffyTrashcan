//답변 항목 추가 기능
const addBtn = document.querySelector(".add-btn");
addBtn.onclick = function () {
  console.log("추가 버튼 클릭");

  //<li> 엘리먼트 생성
  const li = document.createElement("li");

  li.innerHTML = `
    <input type="text"><button type="button" onclick="remove(this)">삭제</button>
  `;

  //<ul 태그에 만든 li 추가
  const answerList = document.querySelector(".answer-list");
  answerList.appendChild(li);
};

function remove(el) {
  console.log(el);
  console.log(el.parentElement); //<li>
  el.parentElement.remove();
}

const makeBtn = document.querySelector(".make-btn");
makeBtn.onclick = function () {
  console.log("투표 생성버튼 클릭");

  //로컬스트로지에 투표정보 저장
  const question = document.querySelector(".question").value;

  const inputList = document.querySelectorAll(".answer-list > li > input");
  console.log("input 엘리먼트들 ", inputList);
  const answers = [];
  for (let input of inputList) {
    answers.push(input.value);
  }
  const poll = {
    question,
    answers: answers,
  };
  localStorage.setItem("poll", JSON.stringify(poll));

  window.opener.location.reload(); //부모창 새로고침

  window.close(); //현재 창 종료
};
