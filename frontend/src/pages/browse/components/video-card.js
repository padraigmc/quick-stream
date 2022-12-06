import React, { useState } from 'react';

function VideoCard(props) {
    const [backgroundColor, setBackgroundColor] = useState("");

    if ('video' in props) {
        return (
            <div className="col md-5 lg-3"
                onMouseEnter={() => setBackgroundColor("lightgrey")}
                onMouseLeave={() => setBackgroundColor("")}
                style={{ backgroundColor: backgroundColor }} 
            >
                <img className="img-fluid" src="/play_button.png" alt=""></img>
                <div className="video-card-info">
                    <h2>{props.video.name}</h2>
                    <p>{props.video.contentLength}</p>
                </div>
            </div>
        );
    } else {
        return null;
    }
}

export default VideoCard;