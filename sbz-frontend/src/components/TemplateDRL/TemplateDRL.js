import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../../assets/hop.png';
import axios from 'axios';

class TemplateDRL extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            lowMin: 0,
            lowMax: 0,
            mediumMin: 0,
            mediumMax: 0,
            highMin: 0,
            highMax: 0
        }
    }

    changeDRLFile = () => {
        console.log(this.state);
        axios.post("http://localhost:8080/templates", {
            lowMin: this.state.lowMin,
            lowMax: this.state.lowMax,
            mediumMin: this.state.mediumMin,
            mediumMax: this.state.mediumMax,
            highMin: this.state.highMin,
            highMax: this.state.highMax
        })
            .then((response) => {
                console.log(response.data);
            })
            .catch(error => console.log(error))
    }

    handleChange = e => {
        this.setState({[e.target.name] : e.target.value});
    }

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
                            <p>Min:</p><input name="lowMin" onChange={this.handleChange} />
                            <p>Max:</p><input name="lowMax" onChange={this.handleChange} />
                        </div>
                        <div className="col-2">
                            <h4>MEDIUM</h4>
                            <p>Min:</p><input name="mediumMin" onChange={this.handleChange} />
                            <p>Max:</p><input name="mediumMax" onChange={this.handleChange} />
                        </div>
                        <div className="col-2">
                            <h4>HIGH</h4>
                            <p>Min:</p><input name="highMin" onChange={this.handleChange} />
                            <p>Max:</p><input name="highMax" onChange={this.handleChange} />
                        </div>
                    </div>
                    <hr />
                    <button onClick={this.changeDRLFile} className="btn">Set</button>
                </div>
            </div>
        );
    }

}

export default TemplateDRL;