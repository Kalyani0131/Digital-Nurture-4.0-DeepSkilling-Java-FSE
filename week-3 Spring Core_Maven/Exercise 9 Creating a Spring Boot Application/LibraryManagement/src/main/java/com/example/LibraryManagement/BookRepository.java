package com.example.LibraryManagement;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Nothing extra needed, CRUD ready!
}
