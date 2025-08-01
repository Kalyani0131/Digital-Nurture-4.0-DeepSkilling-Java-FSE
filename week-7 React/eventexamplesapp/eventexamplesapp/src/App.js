import React from 'react';
import Counter from './Counter';
import WelcomeButton from './WelcomeButton';
import SyntheticEventExample from './SyntheticEventExample';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>React Event Handling Examples</h1>
      <Counter />
      <br />
      <WelcomeButton />
      <br />
      <SyntheticEventExample />
      <br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
