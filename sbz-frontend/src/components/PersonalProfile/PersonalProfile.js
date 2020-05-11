import React from 'react';
import logo from '../../assets/hop.png';

class PersonalProfile extends React.Component {

    render() {
        return (
            <div className="PersonalProfile">
                <nav>
                <img src={logo} alt="logo-img" width="64" height="64" />
                    <div className="home-logo">
                        <h3>The Recipe Blend</h3>
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