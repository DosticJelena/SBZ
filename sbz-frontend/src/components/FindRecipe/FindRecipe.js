import React from 'react';
import logo from '../../assets/hop.png';

class FindRecipe extends React.Component {

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
                <div className="filter">
                    <div className="step-1">
                        <h4>Step 1: Choose ingredients</h4>
                        <hr />
                    </div>
                    <div className="step-2">
                        <h4>Step 2: Additional filters</h4>
                        <hr />
                    </div>
                    <div className="step-3">
                        <h4>Step 3: Find Recipe!</h4>
                        <hr />
                    </div>
                </div>
            </div>
        );
    }

}

export default FindRecipe;