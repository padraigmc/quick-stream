import React from "react";
import VideoList from "./components/video-list";

class Browse extends React.Component {
	render() {
		return (
			<div className='browse'>
				<VideoList />
			</div>
		)
	}
}

export default Browse;