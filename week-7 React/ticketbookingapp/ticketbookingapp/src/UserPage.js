import React from 'react';
import FlightDetails from './FlightDetails';

function UserPage() {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can now book your flight tickets.</p>
      <FlightDetails canBook={true} />
    </div>
  );
}

export default UserPage;
