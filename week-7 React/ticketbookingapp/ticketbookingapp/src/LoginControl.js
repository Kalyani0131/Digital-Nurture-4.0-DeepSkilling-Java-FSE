import React from 'react';

function LoginControl({ isLoggedIn, onLogin, onLogout }) {
  return (
    <div>
      {isLoggedIn ? (
        <button onClick={onLogout}>Logout</button>
      ) : (
        <button onClick={onLogin}>Login</button>
      )}
    </div>
  );
}

export default LoginControl;
