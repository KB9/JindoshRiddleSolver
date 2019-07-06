import React from "react";

import RiddleSelect from "./components/RiddleSelect";

import "./JindoshRiddle.css";

class ColorSelect extends React.Component {
  render() {
    return <RiddleSelect options={["blue", "green", "purple", "red", "white"]} />;
  }
}

class WomanSelect extends React.Component {
  render() {
    return <RiddleSelect options={["Baroness Finch", "Countess Contee", "Doctor Marcolla", "Lady Winslow", "Madam Natsiou"]} />;
  }
}

class DrinkSelect extends React.Component {
  render() {
    return <RiddleSelect options={["absinthe", "beer", "rum", "whiskey", "wine"]} />;
  }
}

class LocationSelect extends React.Component {
  render() {
    return <RiddleSelect options={["Baleton", "Dabokva", "Dunwall", "Fraeport", "Karnaca"]} />;
  }
}

class HeirloomSelect extends React.Component {
  render() {
    return <RiddleSelect options={["Bird Pendant", "Diamond", "Ring", "Snuff Tin", "War Medal"]} />;
  }
}

class JindoshRiddle extends React.Component {
  render() {
    return (
      <div>
        <div className="jindosh-riddle-header">
          <p>The Jindosh Riddle</p>
        </div>
        <div className="jindosh-riddle-text">
          <p>At the dinner party were Lady Winslow, Doctor Marcolla, Countess</p>
          <p>Contee, Madam Natsiou, and Baroness Finch.</p>
          <br/>
          <p>The women sat in a row. They all wore different colors and <WomanSelect/></p>
          <p>wore a jaunty <ColorSelect/> hat. <WomanSelect/> was at the far left, next to the</p>
          <p>guest wearing a <ColorSelect/> jacket. The lady in <ColorSelect/> sat left of someone in <ColorSelect/>. I</p>
          <p>remember that <ColorSelect/> outfit because the woman spilled her <DrinkSelect/> all over</p>
          <p>it. The traveler from <LocationSelect/> was dressed entirely in <ColorSelect/> When one of</p>
          <p>the dinner guests bragged about her <HeirloomSelect/>, the woman next to her said</p>
          <p>they were finer in <LocationSelect/> where she lived.</p>
          <br/>
          <p>So <WomanSelect/> showed off a prized <HeirloomSelect/> at which the lady</p>
          <p>from <LocationSelect/> scoffed, saying it was no match for her <HeirloomSelect/>. Someone else</p>
          <p>carried a valuable <HeirloomSelect/> and when she saw it, the visitor from</p>
          <p><LocationSelect/> next to her almost spilled her neighbor's <DrinkSelect/>. <WomanSelect/></p>
          <p>raised her <DrinkSelect/> in toast. The lady from <LocationSelect/>, full of <DrinkSelect/>, jumped up</p>
          <p>onto the table, falling onto the guest in the center seat, spilling the poor</p>
          <p>woman's <DrinkSelect/>. Then <WomanSelect/> captivated them all with a wild story</p>
          <p>about her wild youth in <LocationSelect/></p>
          <br />
          <p>In the morning, there were four heirlooms under the table: the <HeirloomSelect/>,</p>
          <p><HeirloomSelect/>, the <HeirloomSelect/>, and the <HeirloomSelect/>.</p>
          <br />
          <p>But who owned each?</p>
        </div>
      </div>
    );
  }
}

export default JindoshRiddle;