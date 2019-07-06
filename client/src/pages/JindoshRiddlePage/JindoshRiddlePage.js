import React from "react";

import JindoshRiddle from "./components/JindoshRiddle";
import RiddleSolution from "./components/RiddleSolution";

import "./JindoshRiddlePage.css";

class JindoshRiddlePage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      solution: undefined
    };
  }

  render() {
    const solution = this.state.solution;
    let solutionComponent = <span />;
    if (solution) {
      solutionComponent = (
        <div className="jindosh-riddle-page-solution-container">
          <RiddleSolution solution={solution} />
        </div>
      );
    }
    return (
      <div className="jindosh-riddle-page">
        <div className="jindosh-riddle-page-content">
          <JindoshRiddle
            onSolutionFound={data => this.setState({ solution: data })}
          />
          {solutionComponent}
        </div>
      </div>
    );
  }
}

export default JindoshRiddlePage;