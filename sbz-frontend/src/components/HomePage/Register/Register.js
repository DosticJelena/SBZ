import React from 'react';
import { withRouter } from 'react-router-dom';

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
                
            </div>
        );
    }
}

export default withRouter(Register);