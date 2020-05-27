import React from 'react';
import MacrosDiv from './MacrosDiv/MacrosDiv';

class DailyMacros extends React.Component {

    render() {
        return (
            <div className="DailyMacros">
                <div className="row">
                    <div className="col-4">
                        <MacrosDiv name="CARBS" max="123" now="23"/>
                    </div>
                    <div className="col-4">
                        <MacrosDiv name="PROTEIN" max="150" now="45"/>
                    </div>
                    <div className="col-4">
                        <MacrosDiv name="FAT" max="45" now="12"/>
                    </div>
                </div>
            </div>
        );
    }

}

export default DailyMacros;