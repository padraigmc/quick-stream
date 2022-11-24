import React from 'react';

class VideoList extends React.Component {
    constructor(props) {
        super(props);
        
        this.state = {
            videos: []
        }
    }

    componentDidMount() {
        fetch("http://localhost:8080/video/all/")
            .then(response => response.json())
            .then(videoList => this.setState({videos: videoList}));
    }

    render() {
		return (
			<div id="video-list">
                <header>
                    <h3>Your videos</h3>
                </header>
                <ul id="your-videos">
                    {this.state.videos.map((video, index) => 
                        <li key={video.id}>
                            <a href={window.location.origin + '?video=' + video.id}>{video.name}</a>
                        </li>
                    )}
                </ul>
            </div>
		);
	}

}

export default VideoList;