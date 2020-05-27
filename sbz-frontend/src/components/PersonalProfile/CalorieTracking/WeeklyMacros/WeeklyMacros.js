import React from 'react';

class WeeklyMacros extends React.Component {

    render() {
        return (
            <div className="WeeklyMacros">
                <div className="row">
                    <div className="col-4">
                        <div className="macros">
                            CARBS
                        </div>
                    </div>
                    <div className="col-4">
                        <div className="macros">
                            PROTEIN
                        </div>
                    </div>
                    <div className="col-4">
                        <div className="macros">
                            FAT
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default WeeklyMacros;