import React from 'react';
import { useParams } from 'react-router-dom';

const Watch = () => {
    let { id } = useParams();

    if (isNumeric(id)) {
        return (
            <div id="video-player" >
                <h1 id="now-playing">Now Playing...</h1>
                <video id="video-screen" width="720px" height="480px" controls crossOrigin="true" src={"http://localhost:8080/video/" + id}></video>
            </div>
        );
    } else {
        return <p>No video selected.</p>
    }
}

function isNumeric(str) {
    if (typeof str != "string") return false // we only process strings!  
    return !isNaN(str) && // use type coercion to parse the _entirety_ of the string (`parseFloat` alone does not do this)...
           !isNaN(parseFloat(str)) // ...and ensure strings of whitespace fail
  }

export default Watch;