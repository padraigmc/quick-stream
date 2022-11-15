import React from 'react';

class VideoPlayer extends React.Component {

    render() {
        const queryParams = Object.fromEntries(new URLSearchParams(window.location.search));
        console.log(queryParams.video)

		if (queryParams.video) {
            return (
                <div id="video-player" >
                    <h3 id="now-playing">Now Playing... {queryParams.video}</h3>
                    <video id="video-screen" width="720px" height="480px" controls crossOrigin="true" src={"http://localhost:8080/video/" + queryParams.video}></video>
                </div>
		    );
        } else {
            return <p>No video selected.</p>
        }
    }
}

export default VideoPlayer;