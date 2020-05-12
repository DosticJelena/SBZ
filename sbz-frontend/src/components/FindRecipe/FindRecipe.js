import React from 'react';
import logo from '../../assets/hop.png';

import axios from 'axios';
import { Link } from 'react-router-dom';

class FindRecipe extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            ingredients: [],
            choosenIngredients: []
        }
    }

    chooseIngredient = (e) => {
        console.log(e.target.value);
        this.setState({choosenIngredients: [...this.state.choosenIngredients, e.target.value]})
    }

    componentDidMount() {
        axios.get("http://localhost:8080/ingredients")
            .then((response) => {
                this.setState({ ingredients: response.data });
            })
            .catch(error => console.log(error))
    }

    render() {
        return (
            <div className="FindRecipe">
                <nav>
                    <img src={logo} alt="logo-img" width="64" height="64" />
                    <div className="home-logo">
                        <Link to="/"><h3>The Recipe Blend</h3></Link>
                        <p>Find Recipe</p>
                    </div>
                </nav>
                <div className="filter row">
                    <div className="step-1 col-md-4 col-12">
                        <h4>Step 1: Choose ingredients</h4>
                        <hr />
                        <div className="dropdown">
                            <button className="btn btn-secondary dropdown-toggle ing-dropdown" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ingredient List
                            </button>
                            <div className="dropdown-menu" aria-labelledby="dropdownMenu2">
                                {this.state.ingredients.map((ing) => {
                                    return (
                                        <div key={ing.name} className="checkbox">
                                            <label>
                                                <input name="ingredient" value={ing.name} onClick={this.chooseIngredient} type="checkbox" />{ing.name}
                                            </label>
                                        </div>
                                    )
                                })}
                            </div>
                        </div>
                        <hr />
                        <h5>Choosen ingredients:</h5>
                        <div className="choosen-ingredients">
                                {this.state.choosenIngredients.map((ing) => <h6 key={ing}>- {ing}</h6>)}
                        </div>
                    </div>
                    <div className="step-2 col-md-4 col-12">
                        <h4>Step 2: Additional filters</h4>
                        <hr />
                    </div>
                    <div className="step-3 col-md-4 col-12">
                        <h4>Step 3: Find Recipe!</h4>
                        <hr />
                    </div>
                </div>
            </div>
        );
    }

}

export default FindRecipe;