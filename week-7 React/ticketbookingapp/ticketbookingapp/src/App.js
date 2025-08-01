import React, { useState } from 'react';
import './App.css';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
import LoginControl from './LoginControl';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="center-container">
      <h1>Ticket Booking App</h1>
      <LoginControl
        isLoggedIn={isLoggedIn}
        onLogin={handleLogin}
        onLogout={handleLogout}
      />
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
