    var recognition = new webkitSpeechRecognition();
	var timesCheckedForSpeaking = 0;
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
    setInterval(listenStart, 10000);
    }

    function listenStart() {
    try {
    if(!responsiveVoice.isPlaying()){
    	recognition.start();
    } else {
    	timesCheckedForSpeaking++;
    	if(timesCheckedForSpeaking > 2) {
    		timesCheckedForSpeaking = 0;
    		responsiveVoice.cancel();
    	}
    }
      } catch(err) {
      	console.log(err);
      }
    }

    function listenStop() {
     try {
      recognition.stop();
      } catch(err) {
      	console.log(err);
      }
    }