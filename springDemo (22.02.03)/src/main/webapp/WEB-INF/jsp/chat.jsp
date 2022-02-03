<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹소켓 테스트 페이지</title>
<script type="text/javascript">
var g_webSocket = null;
window.onload = function() {
    g_webSocket = new WebSocket("ws://localhost:8080/websocket");
    //http는 채팅프로그램을 만들수 없다 그레서 ws(웹소켓의 약자 endpoint)
    
    
    /* 웹소켓 접속 성공시 실행 */
    g_webSocket.onopen = function(message) {
        addLineToChatBox("Server is connected.");
    };
    
    
    /* 웹소켓 서버로부터 메시지 수신시 실행 */
    g_webSocket.onmessage = function(message) {
        addLineToChatBox(message.data);
    };

    /* 웹소켓 이용자가 연결을 해제하는 경우 실행 */
    g_webSocket.onclose = function(message) {
        addLineToChatBox("Server is disconnected.");
    };

    /* 웹소켓 에러 발생시 실행 */
    g_webSocket.onerror = function(message) {
        addLineToChatBox("Error!");
    };
}

/* 채팅 메시지를 화면에 표시 */
function addLineToChatBox(_line) {
    if (_line == null) {
        _line = "";
    }
    
    var chatBoxArea = document.getElementById("chatBoxArea"); //jquuery var chatBoxArea = $("#chatBoxArea").val();
    chatBoxArea.value += _line + "\n";
    chatBoxArea.scrollTop = chatBoxArea.scrollHeight;    //스크롤바를 탑으로 고정
}

/* Send 버튼 클릭하면 서버로 메시지 전송 */
function sendButton_onclick() {
    var inputMsgBox = document.getElementById("inputMsgBox");
    if (inputMsgBox == null || inputMsgBox.value == null || inputMsgBox.value.length == 0) {
        return false;
    }
    
    var chatBoxArea = document.getElementById("chatBoxArea");
    
    if (g_webSocket == null || g_webSocket.readyState == 3) {
        chatBoxArea.value += "Server is disconnected.\n";
        return false;
    }
    
    // 서버로 메시지 전송
    g_webSocket.send(inputMsgBox.value);
    inputMsgBox.value = "";
    inputMsgBox.focus(); //포커스 보내고 다시 인풋박스에 커서를 줌
    
    return true;//이벤트를 정상으로 처리
}

/* Disconnect 버튼 클릭하는 경우 호출 */
function disconnectButton_onclick() {
    if (g_webSocket != null) {
        g_webSocket.close();    //소캣을 끊기....
    }
}

/* inputMsgBox 키 입력하는 경우 호출 */
function inputMsgBox_onkeypress() {
    if (event == null) {
        return false;
    }
    
    // 엔터키 누를 경우 서버로 메시지 전송
    var keyCode = event.keyCode || event.which;
    if (keyCode == 13) { //엔터키코드 는 `13 임
        sendButton_onclick(); // 센드버튼 누르는 로직
    }
}
</script>
</head>
<body>
    <input id="inputMsgBox" style="width: 250px;" type="text" onkeypress="inputMsgBox_onkeypress()">
    <button id="sendButton" onclick="sendButton_onclick()">보내기</button>
    <input id="disconnectButton" value="Disconnect" type="button" onclick="disconnectButton_onclick()">
    <br/>
    <textarea id="chatBoxArea" style="width: 100%;" rows="10" cols="50" readonly="readonly"></textarea>
</body>
</html>