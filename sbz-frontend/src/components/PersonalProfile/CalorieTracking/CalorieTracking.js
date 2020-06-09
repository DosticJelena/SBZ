import React from 'react';
import DailyMacros from './DailyMacros/DailyMacros';
import WeeklyMacros from './WeeklyMacros/WeeklyMacros';

class CalorieTracking extends React.Component {

    render() {
        return (
            <div className="calorie-tracking">
                <h3>Calorie Tracking</h3>
                <hr style={{ backgroundColor: "rgb(222, 184, 135)" }} />
                <h5>Daily Log</h5>
                <DailyMacros protein={this.props.protein} fat={this.props.fat} carbs={this.props.carbs} />
                <br />
                <hr style={{ backgroundColor: "rgb(222, 184, 135)" }} />
                <h5>Weekly Log</h5>
                <WeeklyMacros />
                <br />
            </div>
        );
    }

}

export default CalorieTracking;