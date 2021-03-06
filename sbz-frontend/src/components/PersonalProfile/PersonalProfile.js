import React from 'react';
import logo from '../../assets/hop.png';
import axios from 'axios';

import { Link } from 'react-router-dom';
import CalorieTracking from './CalorieTracking/CalorieTracking';

class PersonalProfile extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            protein: 0,
            carbs: 0,
            fat: 0,
            dailyProtein: 0,
            dailyCarbs: 0,
            dailyFat: 0,
            calories: 0,
            dailyCalories: 0
        }
    }

    componentDidMount() {
        console.log(localStorage.id);
        axios.get("http://localhost:8080/macronutrients/" + localStorage.id)
            .then((response) => {
                console.log(response);
                this.setState({
                    protein: response.data.protein,
                    carbs: response.data.carbs,
                    fat: response.data.fat,
                    calories: response.data.calories
                })
            })
            .catch(error => console.log(error))

        axios.get("http://localhost:8080/users/todayStatus/" + localStorage.id)
            .then((response) => {
                console.log(response);
                this.setState({
                    dailyProtein: response.data.macros.protein,
                    dailyCarbs: response.data.macros.carbs,
                    dailyFat: response.data.macros.fat,
                    dailyCalories: response.data.macros.calories
                })
            })
            .catch(error => console.log(error))

    }

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
                                <tr><td>{parseInt(localStorage.calories)}</td><td>{this.state.carbs}</td><td>{this.state.protein}</td><td>{this.state.fat}</td></tr>
                            </table>
                        </div>
                    </div>
                    <div className="col-2"></div>
                    <div className="col-6">
                        <CalorieTracking
                            protein={this.state.protein}
                            fat={this.state.fat}
                            carbs={this.state.carbs}
                            dailyProtein={this.state.dailyProtein}
                            dailyFat={this.state.dailyFat}
                            dailyCarbs={this.state.dailyCarbs}
                            dailyCalories={this.state.dailyCalories}
                        />
                    </div>
                </div>
            </div>
        );
    }

}

export default PersonalProfile;