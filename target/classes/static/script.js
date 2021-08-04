/*audio*/
var playBtn = document.getElementsByClassName('bicho')[0],
    hearbeat = document.getElementById('heartbeat'),
	audios = document.querySelectorAll('audio');

playBtn.addEventListener('mouseover', function() {
[].forEach.call(audios, function(audio) {
  // do whatever
  audio.play();
});
}, false);

playBtn.addEventListener('mouseleave', function() {
  heartbeat.pause();
  heartbeat.currentTime = 0;
}, false);

 