import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, title: 'Understanding useEffect', author: 'React Team' },
    { id: 2, title: 'Hooks vs Classes', author: 'Dan Abramov' },
    { id: 3, title: 'React Best Practices', author: 'Ryan Florence' }
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.length > 0 ? (
        blogs.map(blog => (
          <div key={blog.id}>
            <p><strong>{blog.title}</strong> — {blog.author}</p>
          </div>
        ))
      ) : (
        <p>No blogs available</p>
      )}
    </div>
  );
}

export default BlogDetails;
