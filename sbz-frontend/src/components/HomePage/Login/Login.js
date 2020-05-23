import React from 'react';
import { Link } from 'react-router-dom';

class Login extends React.Component {

    constructor(props){
        super(props);
  
        this.state = {
            email: '',
            password: ''
        }
    }

    /*
    SendLoginRequest = event => {
        event.preventDefault();
        axios.post("https://deployment-isa.herokuapp.com/auth/login", this.state)
            .then((resp) => {
                localStorage.setItem('token', resp.data.accessToken)
                axios.defaults.headers.common['Authorization'] = `Bearer ${resp.data.accessToken}`;
                axios.get("https://deployment-isa.herokuapp.com/auth/getMyUser")
                    .then((resp) => { })
            })
            .catch((error) => NotificationManager.error('Wrong username or password', 'Error!', 4000)
            )
    }
    */

    handleChange = e => {
        this.setState({ ...this.state, [e.target.name]: e.target.value });
    }

    render() {
        return (
            <div className="Login">
                <h3>Login</h3>
                <form>
                    <div className="form-group">
                        <label for="email">Email address</label>
                        <input type="email" name="email" onChange={this.handleChange} className="form-control" id="email" aria-describedby="emailHelp" />
                    </div>
                    <div className="form-group">
                        <label for="pass">Password</label>
                        <input type="password" name="password" onChange={this.handleChange} className="form-control" id="pass" />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                    <small>Need an account? <Link to="register">Register!</Link></small>
                </form>
            </div>
        );
    }
}

export default Login;