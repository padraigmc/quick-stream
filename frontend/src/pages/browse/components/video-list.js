import React from 'react';
import { Link, useSearchParams  } from 'react-router-dom';
import VideoCard from "./video-card"

class VideoList extends React.Component {
    constructor(props) {
        super(props);
        
        this.state = {
            videos: [],
            currentPage: 0,
            totalItems: 0,
            totalPages: 0
        }

        //const [searchParams] = useSearchParams();
        //console.log(searchParams)
    }

    componentDidMount() {
        fetch("http://localhost:8080/video/?limit=10")
            .then(response => response.json())
            .then(response => {
                this.setState({
                    videos: response.videos,
                    currentPage: response.currentPage,
                    totalItems: response.totalItems,
                    totalPages: response.totalPages

                });
            });
    }

    render() {
		return (
			<div className="row">
                {this.state.videos.map((video) =>
                    <Link  to={{pathname: "/watch/" + video.id}}>
                        <VideoCard key={video.id} video={video}/>
                    </Link>
                )}
            </div>
		);
	}

}

export default VideoList;