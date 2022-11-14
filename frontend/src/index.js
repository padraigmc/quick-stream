import React from 'react';
import ReactDOM from 'react-dom/client';
//import './index.css';
import App from './App';
//import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals(console.log);


/*
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quick Steam</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <main>
        <div id="video-list">
            <header>
                <h3>Your videos</h3>
            </header>
            <ul id="your-videos">
            </ul>
        </div>
        <div id="video-player">
            <header>
                <h3 id="now-playing"></h3>
            </header>
            <video id="video-screen" width="720px" height="480px" controls></video>
        </div>
    </main>
    <script src="main.js"></script>
</body>
</html>
*/