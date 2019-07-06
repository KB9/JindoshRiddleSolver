import React from "react";

import JindoshRiddle from "./components/JindoshRiddle";

import "./JindoshRiddlePage.css";

class JindoshRiddlePage extends React.Component {
  render() {
    return (
      <div className="jindosh-riddle-page">
        <JindoshRiddle />
      </div>
    );
  }
}

export default JindoshRiddlePage;