import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      isLoading: true
    };
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        const posts = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts, isLoading: false });
      })
      .catch((error) => {
        console.error("Error fetching posts:", error);
        this.setState({ hasError: true, isLoading: false });
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("An error occurred: " + error.toString());
    console.error("Error caught by componentDidCatch:", error);
    console.error("Error info:", info);
  }

  render() {
    const { posts, hasError, isLoading } = this.state;

    if (hasError) {
      return <h2 className="error">Error loading posts. Please try again later.</h2>;
    }

    if (isLoading) {
      return <h3 className="loading">Loading posts...</h3>;
    }

    return (
      <div className="posts-container">
        <h1 className="main-heading">Blog Posts</h1>
        {posts.map((post) => (
          <div key={post.id} className="post">
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
