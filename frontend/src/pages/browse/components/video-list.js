import React, { useEffect, useState } from 'react';
import { Link, useSearchParams } from 'react-router-dom';
import VideoCard from "./video-card"

function VideoList() {
    let [searchParams, setSearchParams] = useSearchParams({page: 0, size: 5});
    const [state, setState] = useState({
        videos: [],
        currentPage: 0,
        totalElements: 0,
        totalPages: 0,
        links: {}
    });

    useEffect(() => {
        var url = "http://localhost:8080/video?" + searchParams;

        console.log(url)
        fetch(url)
            .then(response => response.json())
            .then(response => {
                setState({
                    videos: response._embedded.videoModels,
                    currentPage: response.page.number,
                    totalElements: response.page.totalElements,
                    totalPages: response.page.totalPages,
                    links: response._links
                });
            });
    }, [searchParams]);

    return (
        <div className="videoList">
            <div className="row">
                {state.videos.map((video) =>
                    <Link to={{pathname: "/watch/" + video.id}} key={video.id}>
                        <VideoCard video={video}/>
                    </Link>
                )}
            </div>
            <div className="row">
                <button className="" disabled={!("prev" in state.links)} onClick={() => setSearchParams(new URL(state.links.prev.href).searchParams.toString())}
                >Previous</button>

                <button disabled={!("next" in state.links)} onClick={() => setSearchParams(new URL(state.links.next.href).searchParams.toString())}
                >Next</button>
            </div>
        </div>
    );

}

export default VideoList;