import React from 'react';
import MacrosDiv from './MacrosDiv/MacrosDiv';

class DailyMacros extends React.Component {

    render() {
        return (
            <div className="DailyMacros">
                <div className="row">
                    <div className="col-4">
                        <MacrosDiv name="CARBS" max={this.props.carbs} now="23"/>
                    </div>
                    <div className="col-4">
                        <MacrosDiv name="PROTEIN" max={this.props.protein} now="45"/>
                    </div>
                    <div className="col-4">
                        <MacrosDiv name="FAT" max={this.props.fat} now="12"/>
                    </div>
                </div>
            </div>
        );
    }

}

export default DailyMacros;