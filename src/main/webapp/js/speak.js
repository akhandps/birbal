// say a message
function speak(text, callback) {
    var u = new SpeechSynthesisUtterance();
    u.text = text;
    u.lang = 'en-US';
    Bot.listenStop();
    u.onend = function () {
      Bot.listenStart();
        if (callback) {
            callback();
        }
    };
 
    u.onerror = function (e) {
        Bot.listenStart();
        if (callback) {
            callback(e);
        }
    };
 
    speechSynthesis.speak(u);
}