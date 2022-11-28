import React from 'react';

class UploadVideo extends React.Component {
	uploadVideo = ev => {
		ev.preventDefault();
		const data = new FormData(ev.target);
		fetch('http://localhost:8080/video', {
			method: 'POST',
			body: data
		}).then(result => result.text()).then(_ => {
			window.location.href = 'index.html';
		});
	}

    render() {
		return (
			<form id="video-form" onSubmit={this.uploadVideo}>
				<fieldset>
					<label htmlFor="file">Video File</label>
					<input id="file" name="file" type="file" accept="application/mp4" />
					<label htmlFor="name">Video Name</label>
					<input id="name" name="name" type="text" />
					<button type="submit">Save</button>
				</fieldset>
			</form>
		);
	}
}

export default UploadVideo;