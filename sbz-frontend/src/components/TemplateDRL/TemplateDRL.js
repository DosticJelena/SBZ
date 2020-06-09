import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../../assets/hop.png';

class TemplateDRL extends React.Component {

    render() {
        return (
            <div className="PersonalProfile">
                <nav>
                    <div className="home-logo">
                        <Link to="/"><h3>The Recipe Blender <img src={logo} alt="logo-img" width="35" height="35" /></h3></Link>
                        <p>Drools template</p>
                    </div>
                </nav>
                <div className="template">
                    <h3>Set Popularity Threshold</h3>
                    <hr />
                    <div className="row">
                        <div className="col-2">
                            <h4>LOW</h4>
                            <p>Min:</p><input />
                            <p>Max:</p><input />
                        </div>
                        <div className="col-2">
                            <h4>MEDIUM</h4>
                            <p>Min:</p><input />
                            <p>Max:</p><input />
                        </div>
                        <div className="col-2">
                            <h4>HIGH</h4>
                            <p>Min:</p><input />
                            <p>Max:</p><input />
                        </div>
                    </div>
                    <hr />
                    <button className="btn">Create</button>
                </div>
            </div>
        );
    }

}

export default TemplateDRL;