// 자바스크립트 실행
// 1. 찾기
// 2. 이벤트
// 3. 함수

// 아이디 emailChecked 선택 -> 변수 emailCheckedBtn 선언, 초기화
const emailCheckedBtn=document.querySelector('#emailChecked');
// 이벤트 바인딩 -> click 이벤트가 발생
emailCheckedBtn.addEventListener('click',emailSerachFn);
// 함수 호출 emailSerachFn()
function emailSerachFn(){
    const email=document.querySelector('#email') // 아이디 email선택
    let emailVal=email.value;

    if(emailVal==""||emailVal.length<=0){
        alert('이메일 값을 입력해주세요!')
        email.focus();
        return false; // 이메일 값이 없으면 다시 작성 (함수종료)
    }
    alert('이메일 체크 실행')
    location.href="/memberEmailChecked.do?email="+emailVal;
}   
