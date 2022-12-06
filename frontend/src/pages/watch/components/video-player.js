import React from 'react';

const VideoPlayer = (props) => {

	if (props.match.params.id) {
		return (
			<div id="video-player" >
				<h2 id="now-playing">Now Playing...</h2>
				<video id="video-screen" width="720px" height="480px" controls crossOrigin="true" src={"http://localhost:8080/video/" + props.video_id}></video>
			</div>
		);
	} else {
		return <p>No video selected.</p>
	}
}

export default VideoPlayer;