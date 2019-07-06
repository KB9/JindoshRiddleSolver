import React from "react";

import "./RiddleSolution.css";

class RiddleSolution extends React.Component {
  render() {
    if (!this.props.solution || !this.props.solution.found) {
      return <p style={{color: "white", fontStyle: "italic", fontSize: "20px"}}>No solution found</p>
    }

    const { women, heirlooms, drinks, colors, locations } = this.props.solution;
    let rows = [];
    for (let i = 0; i < 5; i++) {
      rows.push(
        <tr>
          <td>{women[i]}</td>
          <td>{heirlooms[i]}</td>
          <td>{drinks[i]}</td>
          <td>{colors[i]}</td>
          <td>{locations[i]}</td>
        </tr>
      );
    }

    return (
      <div className="riddle-solution">
        <div className="riddle-solution-header">
          <p>Solution</p>
        </div>
        <div className="riddle-solution-content">
          <table cellspacing="20">
            <tr>
              <th align="left">Woman</th>
              <th align="left">Heirloom</th>
              <th align="left">Drink</th>
              <th align="left">Color</th>
              <th align="left">Location</th>
            </tr>
            {rows}
          </table>
        </div>
      </div>
    );
  }
}

export default RiddleSolution;