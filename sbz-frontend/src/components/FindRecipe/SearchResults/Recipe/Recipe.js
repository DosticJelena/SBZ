import React from 'react';

class Recipe extends React.Component {

    render() {
        return (
            <div className="Recipe">
                <h4>{this.props.rec.name}</h4>
                <p>{this.props.rec.location.name} | {this.props.rec.location.continent}</p>
            </div>
        );
    }
}

export default Recipe;