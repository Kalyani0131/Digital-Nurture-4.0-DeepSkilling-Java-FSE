import React from 'react';

function SyntheticEventExample() {
  const handleClick = (e) => {
    alert("I was clicked");
  };

  return <button onClick={handleClick}>Click Me</button>;
}

export default SyntheticEventExample;
