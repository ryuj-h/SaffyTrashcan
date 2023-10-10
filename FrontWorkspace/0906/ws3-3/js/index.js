console.log("index.js 불러옴");

let pollRawData = localStorage.getItem("poll");

//투표정보가 있는 경우
if (pollRawData) {
  //로컬 스토리지 정보 조회
  const pollData = JSON.parse(pollRawData);

  //투표 정보 div에 들어갈 HTML 작성
  let pollHtml = `
    <div id="title">[당신의 선택]</div>
    <div>${pollData.question}</div>
        <form action="" method="post">
            <ul>
    `;

  //<li> 태그 완성
  for (let answer of pollData.answers) {
    pollHtml += `
        <li>
            <input type="radio" name="option" id="${answer}" />
            <label for="${answer}">${answer}</label>
        </li>
        `;
  }
  pollHtml += `
        </ul>
        <div class="btnDiv">
            <button type="submit">투표하기</button>
            <button type="button">결과보기</button>
        </div>
    </form>
    투표기간 : 23.09.01~23.09.15
  `;

  //DOM에 만든 HTML 요소 추가1
  const choiceDiv = document.querySelector(".choiceDiv");
  choiceDiv.innerHTML = pollHtml;

  const pollBtn = document.querySelector(".poll-btn");
  pollBtn.style = "display:none";
}
//투표정보가 없는 경우
else {
  //투표만들기 버튼에 대한 이벤트리스너 설정
  const pollBtn = document.querySelector(".poll-btn");
  pollBtn.onclick = function () {
    window.open("poll.html", "_blank", "width=500, height=500");
  };
}
