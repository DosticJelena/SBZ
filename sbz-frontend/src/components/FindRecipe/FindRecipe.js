import React from 'react';
import logo from '../../assets/hop.png';
import locationLogo from '../../assets/pin.png';

import axios from 'axios';
import { Link } from 'react-router-dom';

import SearchResults from './SearchResults/SearchResults';
import SmallModal from '../UI/Modal/SmallModal';

class FindRecipe extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            ingredients: [],
            locations: [],
            allergens: [],
            choosenIngredients: [],
            choosenAllergens: [],
            location: '',
            validRec: [],
            continentRec: [],
            worldRec: [],
            semiRec: [],
            showSearchResults: false,
            smallModalVisible: false
        }
    }

    chooseIngredient = (e) => {
        let tempList = [...this.state.choosenIngredients];
        var index = tempList.indexOf(e.target.value);
        if (index !== -1) {
            tempList.splice(index, 1);
            this.setState({ choosenIngredients: tempList });
        } else {
            this.setState({ choosenIngredients: [...this.state.choosenIngredients, e.target.value] });
        }
    }

    chooseLocation = (e) => {
        this.setState({ location: e.target.value }, console.log(this.state.location));
    }

    modalHandler = () => {
        this.setState({ smallModalVisible: true });
    }

    modalClosedHandler = () => {
        this.setState({ smallModalVisible: false });
    }

    searchRecipes = () => {
        this.modalHandler();
        axios.post("http://localhost:8080/recipes/search", {
            ingredients: this.state.choosenIngredients,
            allergens: this.state.allergens,
            location: this.state.location,
            showSemiValid: true
        })
            .then((response) => {
                console.log(response);
                this.setState({
                    validRec: response.data.validRecipes,
                    continentRec: response.data.continentRecipes,
                    semiRec: response.data.semiValidRecipes,
                    worldRec: response.data.worldwideRecipes,
                    showSearchResults: true
                })
                this.scrollToMyRef();
            })
            .catch(error => {console.log(error); this.modalClosedHandler()})
    }

    componentDidMount() {
        axios.get("http://localhost:8080/ingredients")
            .then((response) => {
                this.setState({ ingredients: response.data });
            })
            .catch(error => console.log(error))

        axios.get("http://localhost:8080/locations")
            .then((response) => {
                this.setState({ locations: response.data });
            })
            .catch(error => console.log(error))

        axios.get("http://localhost:8080/allergens")
            .then((response) => {
                this.setState({ allergens: response.data });
            })
            .catch(error => console.log(error))
    }

    render() {

        let allergenContent;
        this.state.allergens.length === 0 ?
            allergenContent = <label>There is no allergens to list.</label> :
            allergenContent = this.state.allergens.map((alg) => {
                return (
                    <div key={alg.name} className="checkbox">
                        <label>
                            <input name="location" value={alg.name} onClick={this.chooseLocation} type="checkbox" />
                            {alg.name}
                        </label>
                    </div>
                )
            })

        let ingredientContent;
        this.state.ingredients.length === 0 ?
            ingredientContent = <label>Ingredients loading...</label> :
            ingredientContent = this.state.ingredients.map((ing) => {
                return (
                    <div key={ing.name} className="checkbox">
                        <label>
                            <input name="ingredient" value={ing.name} onClick={this.chooseIngredient} type="checkbox" />{ing.name}
                        </label>
                    </div>
                )
            })

        let locationContent;
        this.state.locations.length === 0 ?
            locationContent = <label>Locations loading...</label> :
            locationContent = this.state.locations.map((location) => {
                return (
                    <div key={location.name} className="checkbox">
                        <label>
                            <input name="location" checked={location.name === this.state.location} value={location.name} onClick={this.chooseLocation} type="checkbox" />
                            {location.name} | {location.continent}
                        </label>
                    </div>
                )
            })

        return (
            <div className="FindRecipe">
                <SmallModal show={this.state.smallModalVisible}><h3>Please Wait...</h3></SmallModal>
                <nav>
                    <div className="home-logo">
                        <Link to="/"><h3>The Recipe Blender <img src={logo} alt="logo-img" width="35" height="35" /></h3></Link>
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
                                {ingredientContent}
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
                        <h5>Location</h5>
                        <div className="dropdown">
                            <button className="btn btn-secondary dropdown-toggle ing-dropdown" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Choose Location
                            </button>
                            <div className="dropdown-menu" aria-labelledby="dropdownMenu2">
                                {locationContent}
                            </div>
                        </div>
                        <br />
                        <h5><img src={locationLogo} alt="location" height="32" width="32" /> {this.state.location}</h5>
                        <hr />
                        <br />
                        <h5>Allergens</h5>
                        <div className="dropdown">
                            <button className="btn btn-secondary dropdown-toggle ing-dropdown" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Allergen List
                            </button>
                            <div className="dropdown-menu" aria-labelledby="dropdownMenu2">
                                {allergenContent}
                            </div>
                        </div>
                    </div>
                    <div className="step-3 col-md-4 col-12">
                        <h4>Step 3: Find Recipe!</h4>
                        <hr />
                        <button onClick={this.searchRecipes} className="btn btn-success green-btn">
                            Find Recipes!
                        </button>
                    </div>
                </div>
                <div className="row">
                    {this.state.showSearchResults ? <SearchResults
                        validRec={this.state.validRec}
                        continentRec={this.state.continentRec}
                        worldRec={this.state.worldRec}
                        semiRec={this.state.semiRec}
                        location={this.state.location}
                        ingr={this.state.choosenIngredients}
                        aler={this.state.choosenAllergens}
                    /> : null}
                </div>
            </div>
        );
    }

}

export default FindRecipe;