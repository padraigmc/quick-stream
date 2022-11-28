import React from 'react';

class Watch extends React.Component {
    render() {
		if (this.props.match.params.id) {
            return (
                <div id="video-player" >
                    <h1 id="now-playing">Now Playing...</h1>
                    <video id="video-screen" width="720px" height="480px" controls crossOrigin="true" src={"http://localhost:8080/video/" + this.props.match.params.id}></video>
                </div>
		    );
        }
    }
}

export default Watch;