import React from 'react';

class MacrosDiv extends React.Component {

    render() {
        
        let progress = parseInt((this.props.now/this.props.max)*100) + "%";

        return (
            <div className="MacrosDiv">
                <div className="macros">
                    {this.props.name}<div>{this.props.now} / {this.props.max}</div>
                </div>
                <div className="progress">
                    <div
                        className="progress-bar progress-bar-striped"
                        role="progressbar"
                        style={{ width: progress }}
                        aria-valuenow={parseInt((this.props.now/this.props.max)*100)} aria-valuemin="0" aria-valuemax="100">
                    </div>
                </div>
            </div>
        );
    }

}

export default MacrosDiv;