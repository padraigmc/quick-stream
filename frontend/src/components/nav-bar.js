import { NavLink } from 'react-router-dom';

function NavBar() {

  const mediaButtonOnClick = () => {
    document.getElementById("mainLinksDiv").classList.toggle("showList");
    document.getElementById("mediaButton").classList.toggle("active");
  }

  return (
    <nav className="navbar">
      <div className='container'>
        <div className='logo'>
          <NavLink to='/' className={(navData) => (navData.isActive ? 'currentNavlink' : 'navlink')}
          >QuickStream</NavLink>
        </div>
        <div className='mainLinks' id='mainLinksDiv'>
          <ul>
            <li>
              <NavLink to='/browse' className={(navData) => (navData.isActive ? 'currentNavlink' : 'navlink')}
              >Browse</NavLink>
            </li>
            <li>
              <NavLink to='/upload' className={(navData) => (navData.isActive ? 'currentNavlink' : 'navlink')}
              >Upload</NavLink>
            </li>
          </ul>
        </div>
        <div className="mediaButton">
          <button className="mainMediaButton" 
            id="mediaButton"
            title="Media button"
            type="button"
            onClick={() => mediaButtonOnClick()}>
              <span></span>
              <span></span>
              <span></span>
          </button>
        </div>
      </div>
    </nav>
  );
}

export default NavBar;