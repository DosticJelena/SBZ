import React from 'react';
import './App.css';

import { BrowserRouter as Router, Route } from 'react-router-dom';
import FindRecipe from './components/FindRecipe/FindRecipe';
import PersonalProfile from './components/PersonalProfile/PersonalProfile';
import HomePage from './components/HomePage/HomePage';

function App() {
  return (
    <div className="App">
      <Router>
        <Route exact path="/">
          <HomePage />
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
