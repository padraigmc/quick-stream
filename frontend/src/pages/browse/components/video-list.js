import React from 'react';
import { Link } from 'react-router-dom';

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
                    {this.state.videos.map((video) =>
                        <li key={video.id}>
                            <Link to={{pathname: "/watch/" + video.id}}>{video.name}</Link>
                        </li>
                    )}
                </ul>
            </div>
		);
	}

}

export default VideoList;