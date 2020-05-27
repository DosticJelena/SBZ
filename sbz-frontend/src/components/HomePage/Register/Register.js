import React from 'react';
import { withRouter, Link } from 'react-router-dom';

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
            passwordConfirm: ''
        }
    }

    /*
    SendRegisterRequest = event => {
        event.preventDefault();
        console.log(this.state);
        axios.post("https://deployment-isa.herokuapp.com/auth/register", {
            email: this.state.email,
            password: this.state.password,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            address: this.state.address,
            city: this.state.city,
            country: this.state.country,
            phoneNumber: this.state.phoneNumber,
            medicalNumber: this.state.medicalNumber

        })
            .then((resp) => {
                this.props.history.push('/login');
            })
            .catch((error) => NotificationManager.error('Wrong input', 'Error!', 4000))

    }
    */

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
                        <form>
                            <Link to="/"><h2>The Recipe Blender <img src={logo} alt="logo-img" width="35" height="35" /></h2></Link>
                            <hr />
                            <h3>Register</h3>
                            <br />

                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <label for="firstName">First Name</label>
                                        <input type="text" name="firstName" onChange={this.handleChange} className="form-control" id="firstName" aria-describedby="emailHelp" />
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label for="firstName">Last Name</label>
                                        <input type="text" name="lastName" onChange={this.handleChange} className="form-control" id="lastName" aria-describedby="emailHelp" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <label for="email">Email address</label>
                                        <input type="email" name="email" onChange={this.handleChange} className="form-control" id="email" aria-describedby="emailHelp" />
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label for="pass">Password</label>
                                        <input type="password" name="password" onChange={this.handleChange} className="form-control" id="pass" />
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">

                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label for="confPass">Confirm Password</label>
                                        <input type="password" name="passwordConfirm" onChange={this.handleChange} className="form-control" id="confPass" />
                                    </div>
                                </div>
                            </div>

                            <hr />

                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <label for="age">Age</label>
                                        <input type="number" name="age" onChange={this.handleChange} className="form-control" id="age" />
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label for="height">Height</label>
                                        <input type="number" name="height" onChange={this.handleChange} className="form-control" id="height" />cm
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label for="weight">Weight</label>
                                        <input type="number" name="weight" onChange={this.handleChange} className="form-control" id="weight" />kg
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <label for="gender">Gender </label>
                                        <div class="custom-control custom-radio">
                                            <input type="radio" id="female" name="gender" class="custom-control-input" />
                                            <label class="custom-control-label" for="female">Female</label>
                                        </div>
                                        <div class="custom-control custom-radio">
                                            <input type="radio" id="male" name="gender" class="custom-control-input" />
                                            <label class="custom-control-label" for="male">Male</label>
                                        </div>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label for="gender">Fitness Goal </label>
                                    <div class="custom-control custom-radio">
                                        <input type="radio" id="lose" name="goal" class="custom-control-input" />
                                        <label class="custom-control-label" for="lose">Lose</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input type="radio" id="mantain" name="goal" class="custom-control-input" />
                                        <label class="custom-control-label" for="mantain">Mantain</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input type="radio" id="gain" name="goal" class="custom-control-input" />
                                        <label class="custom-control-label" for="gain">Gain</label>
                                    </div>
                                </div>
                            </div>

                            <hr />
                            <button type="submit" className="btn btn-primary">Submit</button>
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