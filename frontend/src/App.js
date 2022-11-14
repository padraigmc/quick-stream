import UploadVideo from "./components/upload-video";
import VideoList from "./components/video-list";
import VideoPlayer from "./components/video-player";

function App() {
  return (
    <div className="App">
        <UploadVideo />
        <VideoList />
        <VideoPlayer />
    </div>
  );
}

export default App;