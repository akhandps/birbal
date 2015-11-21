    function listen(callback) {
    var recognition = new webkitSpeechRecognition();
    recognition.continuous = true;
    recognition.interimResults = true;
 
    recognition.onresult = function (e) {
        for (var i = e.resultIndex; i < e.results.length; ++i) {
            if (e.results[i].isFinal) {
                callback(e.results[i][0].transcript);
            }
        }
    }
 
    // start listening
    recognition.start();
    }