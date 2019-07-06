import React from "react";

import "./RiddleSelect.css";

class RiddleSelect extends React.Component {
  render() {
    const options = this.props.options.map((opt, idx) => {
      return <option key={idx}>{opt}</option>;
    });
    return (
      <select className="riddle-select">
        <option />
        {options}
      </select>
    );
  }
}

export default RiddleSelect;