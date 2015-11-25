    var recognition = new webkitSpeechRecognition();

    function listen(callback) {
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

    function listenStart() {
      recognition.start();
    }

    function listenStop() {
      recognition.stop();
    }