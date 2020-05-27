import React from 'react';
import { Link } from 'react-router-dom';

class Welcome extends React.Component {

    constructor(props){
        super(props);
  
        this.state = {

        }
    }

    render() {
        return (
            <div className="Welcome">
                <h3>Welcome, Ime Prezime!</h3>
                <div>
                    <Link to="profile"><button>Profile</button></Link>
                    <p onClick={this.props.changeLoggedInStatus}>Log Out</p>
                </div>
            </div>
        );
    }
}

export default Welcome;