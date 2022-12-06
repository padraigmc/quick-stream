import React from 'react';
import { useNavigate } from 'react-router-dom';

const UploadVideo = () => {
	const navigate = useNavigate();

	const uploadVideo = ev => {
		ev.preventDefault();
		const data = new FormData(ev.target);
		fetch('http://localhost:8080/video', {
			method: 'POST',
			body: data
		}).then(result => result.text()).then(result => {
			console.log(result);
			navigate('/browse');
		});
	}

	return (
		<form id="video-form" onSubmit={uploadVideo}>
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

export default UploadVideo;