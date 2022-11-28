import { NavLink } from 'react-router-dom';

const NavBar = () => (
    <nav id="navbar">
      <ul>
        <li><NavLink to='/'>Home</NavLink></li>
        <li><NavLink to='/browse'>Browse</NavLink></li>
        <li><NavLink to='/upload'>Upload</NavLink></li>
      </ul>
    </nav>
  );

  export default NavBar;