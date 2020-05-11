import React from 'react';
import './App.css';
import logo from './assets/hop.png';

import { BrowserRouter as Router, Link, Route } from 'react-router-dom';
import FindRecipe from './components/FindRecipe/FindRecipe';
import PersonalProfile from './components/PersonalProfile/PersonalProfile';

function App() {
  return (
    <div className="App">
      <Router>
        <Route exact path="/">
          <header>
            <div className="orange-title">
              <h1>The Recipe Blender</h1>
              <img src={logo} alt="logo-img" height="40" width="40" />
              <hr />
              <p>
                Duis reprehenderit id adipisicing nostrud consectetur.
                Laborum labore labore sit voluptate velit amet ea nisi nisi nulla ex Lorem mollit consectetur.
              </p>
            </div>
          </header>

          <menu>
            <div className="menu-content">
              <Link to="/blend"><h4>FindRecipe</h4></Link>
            </div>
          </menu>
        </Route>
        <Route exact path="/blend">
          <FindRecipe />
        </Route>
        <Route exact path="/profile">
          <PersonalProfile />
        </Route>
      </Router>
    </div>
  );
}

export default App;
