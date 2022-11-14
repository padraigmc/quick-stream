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
            .then(result => result.json())
            .then(result => {
                console.log('Result: ' + result)
                this.setState({...this.state, videos: result});
            }
        );
        console.log(this.state.videos)
    }

    render() {
		return (
			<div id="video-list">
                <header>
                    <h3>Your videos</h3>
                </header>
                <ul id="your-videos">
                    {this.state.videos.map(video => 
                        <li>
                            <a href={window.location.origin + window.location.pathname + '?video=' + video}>{video}</a>
                        </li>
                    )}
                </ul>
            </div>
		);
	}

}

export default VideoList;