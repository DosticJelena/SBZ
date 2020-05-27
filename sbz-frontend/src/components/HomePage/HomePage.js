import React from 'react';
import logo from '../../assets/hop.png';

import { Link } from 'react-router-dom';
import Login from './Login/Login';
import Welcome from './Welcome/Welcome';

class HomePage extends React.Component {

    render() {

        let rightMenuContent;
        if (localStorage.loggedIn == "true") {
            rightMenuContent = <Welcome changeLoggedInStatus={this.props.changeLoggedInStatus} />
        } else {
            rightMenuContent = <Login changeLoggedInStatus={this.props.changeLoggedInStatus} />
        }

        return (
            <div className="HomePage">
                <header>
                    <div className="row">
                        <div className="col-7">
                            <div className="orange-title">
                                <h1>The Recipe Blender<img src={logo} alt="logo-img" height="50" width="50" /></h1>
                                <hr />
                                <p>
                                    Duis reprehenderit id adipisicing nostrud consectetur.
                                    Laborum labore labore sit voluptate velit amet ea nisi nisi nulla ex Lorem mollit consectetur.
                            </p>
                            </div>
                        </div>
                        <div className="col-5">
                            {rightMenuContent}
                        </div>
                    </div>
                </header>
                <menu>
                    <div className="menu-content">
                        <Link to="/blend"><h4>FindRecipe</h4></Link>
                    </div>
                </menu>
            </div>
        );
    }
}

export default HomePage;
