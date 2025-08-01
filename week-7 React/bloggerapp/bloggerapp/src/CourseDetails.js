import React from 'react';

function CourseDetails() {
  const courses = [
    { id: 1, name: 'React for Beginners', duration: '4 weeks', instructor: 'John Doe' },
    { id: 2, name: 'Advanced JavaScript', duration: '6 weeks', instructor: 'Jane Smith' },
    { id: 3, name: 'Full Stack Development', duration: '8 weeks', instructor: 'Alex Johnson' }
  ];

  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map(course => (
          <li key={course.id}>
            <strong>{course.name}</strong> <br />
            Duration: {course.duration} <br />
            Instructor: {course.instructor}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
