import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function VideoCard(props) {
    const [backgroundColor, setBackgroundColor] = useState("");

    if ('video' in props) {
        return (
            <div className="col md-5 lg-2"
                onMouseEnter={() => setBackgroundColor("lightgrey")}
                onMouseLeave={() => setBackgroundColor("")}
                style={{ backgroundColor: backgroundColor }} 
            >
                <img className="img-fluid" src="/play_button.png" alt=""></img>
                <div className="video-card-info">
                    <p>{props.video.name}</p>
                    <p className="txt-gray">{props.video.contentLength}</p>
                </div>
            </div>
        );
    } else {
        return null;
    }
}

export default VideoCard;