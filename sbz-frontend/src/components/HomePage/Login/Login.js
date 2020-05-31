import React from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import {NotificationManager} from 'react-notifications';

class Login extends React.Component {

    constructor(props){
        super(props);
  
        this.state = {
            email: '',
            password: ''
        }
    }

    SendLoginRequest = event => {
        event.preventDefault();
        axios.post("http://localhost:8080/users/login", {
            username: this.state.email,
            password: this.state.password
        })
            .then((response) => {
                localStorage.setItem('loggedIn', true);
                localStorage.setItem('id', response.data.id);
                localStorage.setItem('username', response.data.username);
                localStorage.setItem('firstName', response.data.firstName);
                localStorage.setItem('lastName', response.data.lastName);
                localStorage.setItem('age', response.data.age);
                localStorage.setItem('weight', response.data.weight);
                localStorage.setItem('height', response.data.height);
                localStorage.setItem('calories', response.data.caloriesThreshold);
                localStorage.setItem('goal', response.data.weightGoal);
                this.props.changeLoggedInStatus();
                console.log(localStorage);
            })
            .catch((error) => NotificationManager.error(error.response.data,"Error!",3000))
    }

    handleChange = e => {
        this.setState({ ...this.state, [e.target.name]: e.target.value });
    }

    render() {
        return (
            <div className="Login">
                <h3>Login</h3>
                <form onSubmit={this.SendLoginRequest}>
                    <div className="form-group">
                        <label for="email">Email address</label>
                        <input type="text" name="email" onChange={this.handleChange} className="form-control" id="email" aria-describedby="emailHelp" />
                    </div>
                    <div className="form-group">
                        <label for="pass">Password</label>
                        <input type="password" name="password" onChange={this.handleChange} className="form-control" id="pass" />
                    </div>
                    <button type="submit" className="btn btn-success">Submit</button>
                    <small>Need an account? <Link to="register">Register!</Link></small>
                </form>
            </div>
        );
    }
}

export default Login;