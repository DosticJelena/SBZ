import React from 'react';
import axios from 'axios';

import Recipe from './Recipe/Recipe';
import SmallRecipe from './Recipe/SmallRecipe';
import Modal from '../../UI/Modal/Modal';

class SearchResults extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            showOther: false,
            buttonText: "Show",
            modalVisible: false,
            recipeId: '',
            recipe: null
        }
    }

    changeStatus = () => {
        if (this.state.showOther === false) {
            this.setState({ showOther: !this.state.showOther, buttonText: "Hide" });
        } else {
            this.setState({ showOther: !this.state.showOther, buttonText: "Show" });
        }
    }

    setRecipeId = (recipeId) => {
        this.setState({ recipeId: recipeId }, this.getRecipe(recipeId));
    }

    modalHandler = () => {
        this.setState({ modalVisible: true });
    }

    modalClosedHandler = () => {
        this.setState({ modalVisible: false });
    }

    eatRecipeRequest = () => {
        axios.post("http://localhost:8080/meals/add", {
            username: localStorage.username,
            recipeName: this.state.recipe.name
        })
            .then((response) => {
                console.log(response.data);
                this.modalClosedHandler();
            })
            .catch(error => console.log(error))
    }

    getRecipe = (recipeId) => {
        let url = "http://localhost:8080/recipes/" + recipeId;
        axios.get(url, { headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' }, data: {} })
            .then((response) => {
                this.setState({ recipe: response.data }, this.modalHandler);
            })
            .catch(error => console.log(error))
    }

    render() {

        let modal;
        if (this.state.recipe === null) {
            modal = null;
        } else {
            modal = <Modal show={this.state.modalVisible} modalClosed={this.modalClosedHandler}>
                <h2>{this.state.recipe.name}</h2>
                <h4>{this.state.recipe.location.name} | {this.state.recipe.location.continent}</h4>
                <hr />
                <div className="row">
                    <div className="col">
                        <h3>Ingredients</h3>
                        <hr />
                        <div className="ingredients">
                            {this.state.recipe.ingredients.map(ing => <p>- {ing}</p>)}
                        </div>
                    </div>
                    <div className="col">
                        <h3>Details</h3>
                        <hr />
                        <div className="row">
                            <div className="col">
                                <h4 className="modal-span">Macros:</h4>
                                <p>Protein: {this.state.recipe.macros.protein}</p>
                                <p>Carbs: {this.state.recipe.macros.carbs}</p>
                                <p>Fat: {this.state.recipe.macros.fat}</p>
                            </div>
                            <div className="col">
                                <h4 className="modal-span">Calories:</h4>
                                <p>{this.state.recipe.macros.calories}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <hr />
                <div className="row">
                    <div className="col-3">
                        <h5><span className="modal-span">Times Viewed:</span> {this.state.recipe.timesViewed}</h5>
                        <h5><span className="modal-span">Times Eaten:</span> {this.state.recipe.timesEaten}</h5>
                    </div>
                    <div className="col-3">
                        <h5><span className="modal-span">Popularity:</span> {this.state.recipe.popularity}</h5>
                        <h5><span className="modal-span">Rating:</span> {this.state.recipe.rating}</h5>
                    </div>
                    <div className="col-6">
                        <button onClick={this.eatRecipeRequest} disabled={localStorage.username === null} className="btn modal-btn">Eat Recipe!</button>
                    </div>
                </div>
            </Modal>;
        }

        let otherContent;
        if (this.state.showOther) {
            otherContent = this.props.semiRec.map(rec => {
                return <div onClick={() => this.setRecipeId(rec.id)} className="col-3"><SmallRecipe rec={rec} /></div>
            })
        } else {
            otherContent = null;
        }

        let noAtr;
        if (this.props.location === "" && this.props.ingr.length === 0 && this.props.aler.length === 0) {
            noAtr = true;
        } else {
            noAtr = false;
        }

        let noLoc;
        if (this.props.location === "") {
            noLoc = true;
        } else {
            noLoc = false;
        }

        return (
            <div className="search-results">
                {modal}
                <h1>Recipes For You</h1>
                <hr />
                <div className="row">
                    <div className="col">
                        {this.props.validRec.length === 0 ?
                            <div>...[no valid recipes]...</div>
                            :
                            <div className="row">
                                {this.props.validRec.map(rec => {
                                    return <div onClick={() => this.setRecipeId(rec.id)} className="col-4"><Recipe rec={rec} /></div>
                                })}
                            </div>}

                    </div>
                </div>
                {noLoc ? null :
                    <div>
                        <br />
                        <hr />
                    </div>
                }
                {noAtr || noLoc ?
                    null
                    :
                    <div className="row">
                        <div className="col">
                            <h2>Same Continent Recipes</h2>
                            <div className="row">
                                {this.props.continentRec.map(rec => {
                                    return <div onClick={() => this.setRecipeId(rec.id)} className="col-6"><Recipe rec={rec} /></div>
                                })}
                            </div>
                        </div>
                        <div className="col">
                            <h2>Worldwide Recipes</h2>
                            <div className="row">
                                {this.props.worldRec.map(rec => {
                                    return <div onClick={() => this.setRecipeId(rec.id)} className="col-6"><Recipe rec={rec} /></div>
                                })}
                            </div>
                        </div>
                    </div>
                }
                {noAtr ?
                    null
                    :
                    <div>
                        <br />
                        <hr />
                        <div className="row">
                            <div className="col">
                                <h3>Other Recipes <button className="btn show-btn" onClick={this.changeStatus}>{this.state.buttonText}</button></h3>
                                <div className="row">
                                    {otherContent}
                                </div>
                            </div>
                        </div>
                    </div>
                }
                <br />
            </div>
        );
    }
}

export default SearchResults;