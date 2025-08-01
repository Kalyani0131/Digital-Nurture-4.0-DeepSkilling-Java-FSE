import React from 'react';

function FlightDetails({ canBook = false }) {
  return (
    <div>
      <h3>Flight Details</h3>
      <ul>
        <li>Flight: AI 202 - Delhi to Mumbai</li>
        <li>Flight: SG 305 - Hyderabad to Bangalore</li>
        <li>Flight: UK 123 - Chennai to Kolkata</li>
      </ul>
      {canBook ? <button>Book Now</button> : <p>Login to book tickets.</p>}
    </div>
  );
}

export default FlightDetails;
