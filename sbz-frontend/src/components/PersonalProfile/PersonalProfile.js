import React from 'react';
import logo from '../../assets/hop.png';

import {Link} from 'react-router-dom';

class PersonalProfile extends React.Component {

    render() {
        return (
            <div className="PersonalProfile">
                <nav>
                    <img src={logo} alt="logo-img" width="64" height="64" />
                    <div className="home-logo">
                        <Link to="/"><h3>The Recipe Blend</h3></Link>
                        <p>Ime Prezime</p>
                    </div>
                </nav>
                <div className="profile-info">

                </div>
            </div>
        );
    }

}

export default PersonalProfile;