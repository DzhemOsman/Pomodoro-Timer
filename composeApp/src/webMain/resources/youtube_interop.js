// youtube_interop.js

let player;

// Diese Funktion wird von der YouTube API automatisch aufgerufen,
// sobald sie geladen ist.
function onYouTubeIframeAPIReady() {
    player = new YT.Player('youtube-player', {
        height: '0',
        width: '0',
        videoId: 'jfKfPfyJRdk', // Lofi Girl Stream ID (Beispiel)
        events: {
            'onReady': onPlayerReady
        }
    });
}

function onPlayerReady(event) {
    console.log("YouTube Player ist bereit!");
}

// --- Diese Funktionen rufen wir aus Kotlin auf ---

function startMusicJS() {
    if (player && player.playVideo) {
        player.playVideo();
        console.log("Music started via Kotlin");
    }
}

function stopMusicJS() {
    if (player && player.pauseVideo) {
        player.pauseVideo();
        console.log("Music paused via Kotlin");
    }
}

// Lädt die YouTube API asynchron nach
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);