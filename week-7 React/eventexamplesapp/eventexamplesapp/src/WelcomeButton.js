import React from 'react';

function WelcomeButton() {
  const handleWelcome = (msg) => {
    alert(msg);
  };

  return (
    <button onClick={() => handleWelcome("Welcome!")}>
      Say Welcome
    </button>
  );
}

export default WelcomeButton;
