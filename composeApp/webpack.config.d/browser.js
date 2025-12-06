if (config.devServer) {
    config.devServer.open = {
        app: {
            name: 'Google Chrome' // Auf macOS ist dies der App-Name
        }
    };
}