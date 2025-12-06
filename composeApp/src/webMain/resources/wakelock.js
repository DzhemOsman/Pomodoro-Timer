// wakelock.js

let wakeLock = null;

// Funktion zum Anfordern des Wachzustands
async function requestWakeLockJS() {
    try {
        // Prüfen, ob der Browser das Feature überhaupt unterstützt
        if ('wakeLock' in navigator) {
            wakeLock = await navigator.wakeLock.request('screen');
            console.log('Wake Lock is active');
        } else {
            console.log('Wake Lock not supported by this browser');
        }
    } catch (err) {
        // Kann passieren, wenn Batterie fast leer ist oder System es verbietet
        console.error(`${err.name}, ${err.message}`);
    }
}

// Funktion zum Freigeben
function releaseWakeLockJS() {
    if (wakeLock !== null) {
        wakeLock.release()
            .then(() => {
                wakeLock = null;
                console.log('Wake Lock released');
            });
    }
}