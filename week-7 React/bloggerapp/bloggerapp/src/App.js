import React, { useState } from 'react';
import './App.css';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [view, setView] = useState('book');

  const renderContent = () => {
    if (view === 'book') return <BookDetails />;
    else if (view === 'blog') return <BlogDetails />;
    else if (view === 'course') return <CourseDetails />;
    else return <p>Select a section to view details</p>;
  };

  return (
    <div className="center-container">
      <h1>Blogger App</h1>
      <div className="button-group">
        <button onClick={() => setView('book')}>Book Details</button>
        <button onClick={() => setView('blog')}>Blog Details</button>
        <button onClick={() => setView('course')}>Course Details</button>
      </div>
      <div className="content-box">{renderContent()}</div>
    </div>
  );
}

export default App;
