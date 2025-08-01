import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = () => {
    const converted = rupees / 90;
    setEuro(converted.toFixed(2));
  };

  return (
    <div>
      <h3>Currency Convertor</h3>
      <input
        type="number"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
        placeholder="Enter amount in INR"
      />
      <button onClick={handleSubmit}>Convert</button>
      {euro && <p>{rupees} INR = {euro} EUR</p>}
    </div>
  );
}

export default CurrencyConvertor;
