import React from 'react';
import logo from '../../assets/hop.png';

import { Link } from 'react-router-dom';
import CalorieTracking from './CalorieTracking/CalorieTracking';

class PersonalProfile extends React.Component {

    render() {
        return (
            <div className="PersonalProfile">
                <nav>
                    
                    <div className="home-logo">
                        <Link to="/"><h3>The Recipe Blender <img src={logo} alt="logo-img" width="35" height="35" /></h3></Link>
                        <p>{localStorage.firstName} {localStorage.lastName}</p>
                    </div>
                </nav>
                <div className="row">
                    <div className="col-4">
                        <div className="profile-info">
                            <h3>Personal Information</h3>
                            <br />
                            <table>
                                <tr><td>Age: </td><td><span className="user-values">{localStorage.age}</span></td></tr>
                                <tr><td>Weight: </td><td><span className="user-values">{localStorage.weight}</span>kg</td></tr>
                                <tr><td>Height: </td><td><span className="user-values">{localStorage.height}</span>cm</td></tr>
                            </table>
                        </div>
                        <div className="fitness-info">
                            <h3>Fitness goal</h3>
                            <br />
                            <p>
                                <span className={(localStorage.goal === "LOSE") ? "goal active-goal" : "goal"}>LOSE</span>
                                <span className={(localStorage.goal === "MAINTAIN") ? "goal active-goal" : "goal"}>MAINTAIN</span>
                                <span className={(localStorage.goal === "GAIN") ? "goal active-goal" : "goal"}>GAIN</span>
                            </p>
                            <p>Recomended calorie & macros intake:</p>
                            <table>
                                <tr><td>Calories</td><td>Carbs</td><td>Protein</td><td>Fat</td></tr>
                                <tr><td>{parseInt(localStorage.calories)}</td><td>123</td><td>123</td><td>23</td></tr>
                            </table>
                        </div>
                    </div>
                    <div className="col-2"></div>
                    <div className="col-6">
                        <CalorieTracking />
                    </div>
                </div>
            </div>
        );
    }

}

export default PersonalProfile;