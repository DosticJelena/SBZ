import React from 'react';
import { Link } from 'react-router-dom';

class Welcome extends React.Component {

    constructor(props){
        super(props);
  
        this.state = {

        }
    }

    logOut = () => {
        this.props.changeLoggedInStatus();
        localStorage.removeItem('username');
        localStorage.removeItem('firstName');
        localStorage.removeItem('lastName');
        localStorage.removeItem('age');
        localStorage.removeItem('weight');
        localStorage.removeItem('height');
        localStorage.removeItem('id');
        localStorage.removeItem('calories');
        localStorage.removeItem('goal');
        localStorage.removeItem('loggedIn');
        localStorage.setItem('loggedIn', false);
        console.log(localStorage);
    }

    render() {

        return (
            <div className="Welcome">
                <h3>Welcome, {localStorage.firstName} {localStorage.lastName}!</h3>
                <div>
                    <Link to="profile"><button>Profile</button></Link>
                    <p onClick={this.logOut}>Log Out</p>
                </div>
            </div>
        );
    }
}

export default Welcome;