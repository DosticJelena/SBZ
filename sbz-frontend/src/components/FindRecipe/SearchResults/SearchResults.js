import React from 'react';

import Recipe from './Recipe/Recipe';
import SmallRecipe from './Recipe/SmallRecipe';

class SearchResults extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            showOther: false,
            buttonText: "Show"
        }
    }

    changeStatus = () => {
        if (this.state.showOther == false) {
            this.setState({ showOther: !this.state.showOther, buttonText: "Hide" });
        } else {
            this.setState({ showOther: !this.state.showOther, buttonText: "Show" });
        }
    }

    render() {

        let otherContent;
        if (this.state.showOther) {
            otherContent = this.props.semiRec.map(rec => {
                return <div className="col-3"><SmallRecipe rec={rec} /></div>
            })
        } else {
            otherContent = null;
        }

        return (
            <div className="search-results">
                <h1>Recipes For You</h1>
                <hr />
                <div className="row">
                    <div className="col">
                        <div className="row">
                            {this.props.validRec.map(rec => {
                                return <div className="col-3"><Recipe rec={rec} /></div>
                            })}
                        </div>
                    </div>
                </div>
                <br />
                <hr />
                <div className="row">
                    <div className="col">
                        <h2>Same Continent Recipes</h2>
                        {this.props.continentRec.map(rec => {
                            return <div className="col-6"><Recipe rec={rec} /></div>
                        })}
                    </div>
                    <div className="col">
                        <h2>Worldwide Recipes</h2>
                        {this.props.worldRec.map(rec => {
                            return <div className="col-6"><Recipe rec={rec} /></div>
                        })}
                    </div>
                </div>
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
                <br />
            </div>
        );
    }
}

export default SearchResults;