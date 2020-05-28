import React from 'react';
import { withRouter, Link } from 'react-router-dom';
import axios from 'axios';
import {NotificationManager} from 'react-notifications';

import logo from '../../../assets/hop.png';

class Register extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            email: '',
            password: '',
            firstName: '',
            lastName: '',
            age: '',
            gender: '',
            height: '',
            weight: '',
            passwordConfirm: '',
            goal: ''
        }
    }

    SendRegisterRequest = event => {
        event.preventDefault();
        console.log(this.state);
        axios.post("http://localhost:8080/users/register", {
            username: this.state.email,
            password: this.state.password,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            age: this.state.age,
            gender: this.state.gender,
            height: this.state.height,
            weight: this.state.weight,
            weightGoal: this.state.goal

        })
        .then((resp) => {
            console.log(resp.data);
            this.props.history.push('/');
        })
        .catch((error) => {console.log(error.response); NotificationManager.error(error.response.data,"Error!",3000)})

    }

    handleChange = e => {
        this.setState({ ...this.state, [e.target.name]: e.target.value });
    }

    render() {
        return (
            <div className="Register">
                <div className="row">
                    <div className="col-2">

                    </div>
                    <div className="col-8">
                        <form onSubmit={this.SendRegisterRequest}>
                            <Link to="/"><h2>The Recipe Blender <img src={logo} alt="logo-img" width="35" height="35" /></h2></Link>
                            <hr />
                            <h3>Register</h3>
                            <br />

                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="firstName">First Name</label>
                                        <input type="text" name="firstName" onChange={this.handleChange} className="form-control" id="firstName" aria-describedby="emailHelp" />
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="firstName">Last Name</label>
                                        <input type="text" name="lastName" onChange={this.handleChange} className="form-control" id="lastName" aria-describedby="emailHelp" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="email">Email address</label>
                                        <input type="text" name="email" onChange={this.handleChange} className="form-control" id="email" aria-describedby="emailHelp" />
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="pass">Password</label>
                                        <input type="password" name="password" onChange={this.handleChange} className="form-control" id="pass" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">

                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="confPass">Confirm Password</label>
                                        <input type="password" name="passwordConfirm" onChange={this.handleChange} className="form-control" id="confPass" />
                                    </div>
                                </div>
                            </div>

                            <hr />

                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="age">Age</label>
                                        <input type="number" name="age" onChange={this.handleChange} className="form-control" id="age" />
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="height">Height</label>
                                        <input type="number" name="height" onChange={this.handleChange} className="form-control" id="height" />cm
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="weight">Weight</label>
                                        <input type="number" name="weight" onChange={this.handleChange} className="form-control" id="weight" />kg
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label htmlFor="gender">Gender </label>
                                        <div className="custom-control custom-radio">
                                            <input type="radio" id="female" value="0" onChange={this.handleChange} name="gender" className="custom-control-input" />
                                            <label className="custom-control-label" htmlFor="female">Female</label>
                                        </div>
                                        <div className="custom-control custom-radio">
                                            <input type="radio" id="male" value="1" onChange={this.handleChange} name="gender" className="custom-control-input" />
                                            <label className="custom-control-label" htmlFor="male">Male</label>
                                        </div>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="gender">Fitness Goal </label>
                                    <div className="custom-control custom-radio">
                                        <input type="radio" id="lose" value="0" name="goal" onChange={this.handleChange} className="custom-control-input" />
                                        <label className="custom-control-label" htmlFor="lose">Lose</label>
                                    </div>
                                    <div className="custom-control custom-radio">
                                        <input type="radio" id="mantain" value="1" onChange={this.handleChange} name="goal" className="custom-control-input" />
                                        <label className="custom-control-label" htmlFor="mantain">Mantain</label>
                                    </div>
                                    <div className="custom-control custom-radio">
                                        <input type="radio" id="gain" value="2" onChange={this.handleChange} name="goal" className="custom-control-input" />
                                        <label className="custom-control-label" htmlFor="gain">Gain</label>
                                    </div>
                                </div>
                            </div>

                            <hr />
                            <button type="submit" className="btn btn-success">Submit</button>
                            <small>Already have an account? <Link to="/">Log In!</Link></small>
                        </form>
                    </div>
                    <div className="col-2">

                    </div>
                </div>
            </div>
        );
    }
}

export default withRouter(Register);