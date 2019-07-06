import React from "react";

import "./RiddleSelect.css";

class RiddleSelect extends React.Component {
  render() {
    let options = this.props.options.map((opt, idx) => {
      return <option key={idx} value={opt}>{opt}</option>;
    });
    return (
      <select
        className="riddle-select"
        value={this.props.value}
        onChange={evt => this.props.onChange(evt)}
      >
        <option />
        {options}
      </select>
    );
  }
}

export default RiddleSelect;