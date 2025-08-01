import React from 'react';

function App() {
  // Player list with scores
  const players = [
    { name: "Rohit", score: 80 },
    { name: "Virat", score: 95 },
    { name: "Surya", score: 50 },
    { name: "Gill", score: 70 },
    { name: "Iyer", score: 64 },
    { name: "Pant", score: 85 },
    { name: "Jadeja", score: 61 },
    { name: "Bumrah", score: 99 },
    { name: "Ashwin", score: 60 },
    { name: "Shami", score: 90 },
    { name: "Kuldeep", score: 68 },
  ];

  const oldPlayers = players.filter(player => player.score < 70);

  // IndianPlayers section
  const T20players = ["Rohit1", "Virat2", "Surya3"];
  const RanjiPlayers = ["Gill4", "Bumrah5", "Jadeja6"];
  const mergedPlayers = [...T20players, ...RanjiPlayers];

  const oddIndexes = [0, 2, 4];
  const evenIndexes = [1, 3, 5];
  const oddLabels = ["First", "Third", "Fifth"];
  const evenLabels = ["Second", "Fourth", "Sixth"];

  return (
    <div className="App">
      {/* List of Players */}
      <h2>List of Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>Mr. {player.name} {player.score}</li>
        ))}
      </ul>

      {/* Old Players */}
      <hr />
      <h2>List of Players having Scores Less than 70</h2>
      <ul>
        {oldPlayers.map((player, index) => (
          <li key={index}>Mr. {player.name} {player.score}</li>
        ))}
      </ul>

      {/* Indian Players Section */}
      <hr />
      <h2>Odd Players</h2>
      <ul>
        {oddIndexes.map((index, i) => (
          <li key={index}>{oddLabels[i]} : {mergedPlayers[index]}</li>
        ))}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenIndexes.map((index, i) => (
          <li key={index}>{evenLabels[i]} : {mergedPlayers[index]}</li>
        ))}
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
