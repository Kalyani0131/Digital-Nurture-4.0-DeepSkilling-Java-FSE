import React from 'react';


function App() {
  // Featured office object
  const featuredOffice = {
    name: "Innovate Workspaces",
    rent: 55000,
    address: "Hitech City, Hyderabad"
  };

  const rentColor = featuredOffice.rent < 60000 ? 'red' : 'green';

  // List of available office spaces
  const officeSpaces = [
    { name: "Innov8", rent: 45000, location: "Koramangala, Bengaluru" },
    { name: "WeWork", rent: 70000, location: "HSR Layout, Bengaluru" },
    { name: "EcoSpaces", rent: 60000, location: "Gachibowli, Hyderabad" },
    { name: "UrbanDesk", rent: 58000, location: "Banjara Hills, Hyderabad" },
  ];

  return (
    <div style={{ textAlign: 'center', fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      {/* Heading */}
      <h1>Office Space Rental Portal</h1>

      {/* Image */}
      <img
  src="/officepic.jpeg"
  alt="Office Space"
  style={{ width: '600px', height: 'auto', margin: '20px 0' }}
/>

      {/* Featured Office */}
      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {featuredOffice.name}</p>
      <p>
        <strong>Rent:</strong>{' '}
        <span style={{ color: rentColor }}>₹{featuredOffice.rent}</span>
      </p>
      <p><strong>Address:</strong> {featuredOffice.address}</p>

      {/* Available Offices */}
      <h2 style={{ marginTop: '40px' }}>Available Spaces</h2>
      <ul style={{ listStyleType: 'none', padding: 0 }}>
        {officeSpaces.map((office, index) => {
          const style = { color: office.rent < 60000 ? 'red' : 'green' };
          return (
            <li key={index} style={{ marginBottom: '10px' }}>
              <strong>{office.name}</strong> –{' '}
              <span style={style}>₹{office.rent}</span> | {office.location}
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default App; 