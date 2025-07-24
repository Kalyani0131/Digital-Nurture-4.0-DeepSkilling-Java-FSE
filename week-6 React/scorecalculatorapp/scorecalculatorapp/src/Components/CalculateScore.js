import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const name = "Kalyani";
  const school = "ZPHS Jawahar Nagar";
  const totalMarks = 450;
  const goal = 500;
  const average = (totalMarks / goal) * 100;

  return (
    <div className="container">
      <h2>Score Calculator</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total Marks:</strong> {totalMarks}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;
