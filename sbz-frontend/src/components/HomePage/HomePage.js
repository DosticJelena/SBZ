import React from 'react';
import logo from '../../assets/hop.png';

import { BrowserRouter as Link} from 'react-router-dom';
import Login from './Login/Login';

function HomePage() {
    return (
        <div className="HomePage">
            <header>
                <div className="row">
                    <div className="col-7">
                        <div className="orange-title">
                            <h1>The Recipe Blender</h1>
                            <img src={logo} alt="logo-img" height="40" width="40" />
                            <hr />
                            <p>
                                Duis reprehenderit id adipisicing nostrud consectetur.
                                Laborum labore labore sit voluptate velit amet ea nisi nisi nulla ex Lorem mollit consectetur.
                            </p>
                        </div>
                    </div>
                    <div className="col-5">
                        <Login />
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

export default HomePage;
