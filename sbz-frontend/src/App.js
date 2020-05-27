import React from 'react';
import './App.css';

import { BrowserRouter as Router, Route } from 'react-router-dom';
import FindRecipe from './components/FindRecipe/FindRecipe';
import PersonalProfile from './components/PersonalProfile/PersonalProfile';
import HomePage from './components/HomePage/HomePage';
import Register from './components/HomePage/Register/Register';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      loggedIn: false
    }
  }

  changeLoggedInStatus = () => {
    this.setState({loggedIn: !this.state.loggedIn});
  }

  render() {
    return (
      <div className="App">
        <Router>
          <Route exact path="/">
            <HomePage isLoggedIn={this.state.loggedIn} changeLoggedInStatus={this.changeLoggedInStatus} />
          </Route>
          <Route exact path="/blend">
            <FindRecipe />
          </Route>
          <Route exact path="/profile">
            <PersonalProfile />
          </Route>
          <Route exact path="/register" >
            <Register/>
          </Route>
        </Router>
      </div>
    );
  }
}

export default App;
