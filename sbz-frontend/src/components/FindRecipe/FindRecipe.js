import React from 'react';
import logo from '../../assets/hop.png';

import axios from 'axios';

class FindRecipe extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            ingredients: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/ingredients")
        .then((response) => {
            this.setState({ingredients: response.data});
        })
        .catch(error => console.log(error))
    }

    render() {
        return (
            <div className="FindRecipe">
                <nav>
                    <img src={logo} alt="logo-img" width="64" height="64" />
                    <div className="home-logo">
                        <h3>The Recipe Blend</h3>
                        <p>Find Recipe</p>
                    </div>
                </nav>
                <div className="filter row">
                    <div className="step-1 col-4">
                        <h4>Step 1: Choose ingredients</h4>
                        <hr />
                        {this.state.ingredients.map((ing)=> <p key={ing.name}>{ing.name}</p>)}
                    </div>
                    <div className="step-2 col-4">
                        <h4>Step 2: Additional filters</h4>
                        <hr />
                    </div>
                    <div className="step-3 col-4">
                        <h4>Step 3: Find Recipe!</h4>
                        <hr />
                    </div>
                </div>
            </div>
        );
    }

}

export default FindRecipe;