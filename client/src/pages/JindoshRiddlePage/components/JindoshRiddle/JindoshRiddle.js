import React from "react";

import RiddleSelect from "./components/RiddleSelect";

import "./JindoshRiddle.css";

class ColorSelect extends React.Component {
  render() {
    return <RiddleSelect {...this.props} options={["blue", "green", "purple", "red", "white"]} />;
  }
}

class WomanSelect extends React.Component {
  render() {
    return <RiddleSelect {...this.props} options={["Baroness Finch", "Countess Contee", "Doctor Marcolla", "Lady Winslow", "Madam Natsiou"]} />;
  }
}

class DrinkSelect extends React.Component {
  render() {
    return <RiddleSelect {...this.props} options={["absinthe", "beer", "rum", "whiskey", "wine"]} />;
  }
}

class LocationSelect extends React.Component {
  render() {
    return <RiddleSelect {...this.props} options={["Baleton", "Dabokva", "Dunwall", "Fraeport", "Karnaca"]} />;
  }
}

class HeirloomSelect extends React.Component {
  render() {
    return <RiddleSelect {...this.props} options={["Bird Pendant", "Diamond", "Ring", "Snuff Tin", "War Medal"]} />;
  }
}

const selectors = {
  color: ColorSelect,
  woman: WomanSelect,
  drink: DrinkSelect,
  location: LocationSelect,
  heirloom: HeirloomSelect
};

class JindoshRiddle extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      hatOwner: "",
      hatColor: "",
      farLeftWoman: "",
      jacketColor: "",
      pairLeftColor: "",
      pairRightColor: "",
      spilledDrinkColor: "",
      spilledDrink: "",
      entirelyColorLocation: "",
      entirelyColor: "",
      braggedAboutHeirloom: "",
      finerHeirloomLocation: "",
      prizedHeirloomOwner: "",
      prizedHeirloom: "",
      scoffingWomanLocation: "",
      scoffingWomanHeirloom: "",
      valuableHeirloom: "",
      nearSpillInstigatorLocation: "",
      nearSpillDrink: "",
      toaster: "",
      toastDrink: "",
      tableJumperLocation: "",
      tableJumperDrink: "",
      centerDrink: "",
      storyTeller: "",
      storyTellerLocation: "",
      firstHeirloom: "",
      secondHeirloom: "",
      thirdHeirloom: "",
      fourthHeirloom: ""
    };
  }

  createSelector(selectorName, stateVariableName) {
    const Select = selectors[selectorName];
    return (
      <Select
        value={this.state[stateVariableName]}
        onChange={evt => this.setState({ [stateVariableName]: evt.target.value })}
      />
    );
  }

  render() {
    const hatOwnerSelect = this.createSelector("woman", "hatOwner");
    const hatColorSelect = this.createSelector("color", "hatColor");
    const farLeftWomanSelect = this.createSelector("woman", "farLeftWoman");
    const jacketColorSelect = this.createSelector("color", "jacketColor");
    const pairLeftColorSelect = this.createSelector("color", "pairLeftColor");
    const pairRightColorSelect = this.createSelector("color", "pairRightColor");
    const spilledDrinkColorSelect = this.createSelector("color", "spilledDrinkColor");
    const spilledDrinkSelect = this.createSelector("drink", "spilledDrink");
    const entirelyColorLocationSelect = this.createSelector("location", "entirelyColorLocation");
    const entirelyColorSelect = this.createSelector("color", "entirelyColor");
    const braggedAboutHeirloomSelect = this.createSelector("heirloom", "braggedAboutHeirloom");
    const finerHeirloomLocationSelect = this.createSelector("location", "finerHeirloomLocation");
    const prizedHeirloomOwnerSelect = this.createSelector("woman", "prizedHeirloomOwner");
    const prizedHeirloomSelect = this.createSelector("heirloom", "prizedHeirloom");
    const scoffingWomanLocationSelect = this.createSelector("location", "scoffingWomanLocation");
    const scoffingWomanHeirloomSelect = this.createSelector("heirloom", "scoffingWomanHeirloom");
    const valuableHeirloomSelect = this.createSelector("heirloom", "valuableHeirloom");
    const nearSpillInstigatorLocationSelect = this.createSelector("location", "nearSpillInstigatorLocation");
    const nearSpillDrinkSelect = this.createSelector("drink", "nearSpillDrink");
    const toasterSelect = this.createSelector("woman", "toaster");
    const toastDrinkSelect = this.createSelector("drink", "toastDrink");
    const tableJumperLocationSelect = this.createSelector("location", "tableJumperLocation");
    const tableJumperDrinkSelect = this.createSelector("drink", "tableJumperDrink");
    const centerDrinkSelect = this.createSelector("drink", "centerDrink");
    const storyTellerSelect = this.createSelector("woman", "storyTeller");
    const storyTellerLocationSelect = this.createSelector("location", "storyTellerLocation");
    const firstHeirloomSelect = this.createSelector("heirloom", "firstHeirloom");
    const secondHeirloomSelect = this.createSelector("heirloom", "secondHeirloom");
    const thirdHeirloomSelect = this.createSelector("heirloom", "thirdHeirloom");
    const fourthHeirloomSelect = this.createSelector("heirloom", "fourthHeirloom");
    return (
      <div>
        <div className="jindosh-riddle-header">
          <p>The Jindosh Riddle</p>
        </div>
        <div className="jindosh-riddle-text">
          <p>At the dinner party were Lady Winslow, Doctor Marcolla, Countess</p>
          <p>Contee, Madam Natsiou, and Baroness Finch.</p>
          <br/>
          <p>The women sat in a row. They all wore different colors and {hatOwnerSelect}</p>
          <p>wore a jaunty {hatColorSelect} hat. {farLeftWomanSelect} was at the far left, next to the</p>
          <p>guest wearing a {jacketColorSelect} jacket. The lady in {pairLeftColorSelect} sat left of someone in {pairRightColorSelect}. I</p>
          <p>remember that {spilledDrinkColorSelect} outfit because the woman spilled her {spilledDrinkSelect} all over</p>
          <p>it. The traveler from {entirelyColorLocationSelect} was dressed entirely in {entirelyColorSelect}. When one of</p>
          <p>the dinner guests bragged about her {braggedAboutHeirloomSelect}, the woman next to her said</p>
          <p>they were finer in {finerHeirloomLocationSelect} where she lived.</p>
          <br/>
          <p>So {prizedHeirloomOwnerSelect} showed off a prized {prizedHeirloomSelect} at which the lady</p>
          <p>from {scoffingWomanLocationSelect} scoffed, saying it was no match for her {scoffingWomanHeirloomSelect}. Someone else</p>
          <p>carried a valuable {valuableHeirloomSelect} and when she saw it, the visitor from</p>
          <p>{nearSpillInstigatorLocationSelect} next to her almost spilled her neighbor's {nearSpillDrinkSelect}. {toasterSelect}</p>
          <p>raised her {toastDrinkSelect} in toast. The lady from {tableJumperLocationSelect}, full of {tableJumperDrinkSelect}, jumped up</p>
          <p>onto the table, falling onto the guest in the center seat, spilling the poor</p>
          <p>woman's {centerDrinkSelect}. Then {storyTellerSelect} captivated them all with a wild story</p>
          <p>about her wild youth in {storyTellerLocationSelect}</p>
          <br />
          <p>In the morning, there were four heirlooms under the table: the {firstHeirloomSelect},</p>
          <p>{secondHeirloomSelect}, the {thirdHeirloomSelect}, and the {fourthHeirloomSelect}.</p>
          <br />
          <p>But who owned each?</p>
        </div>
      </div>
    );
  }
}

export default JindoshRiddle;