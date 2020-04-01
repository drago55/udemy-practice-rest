package com.in28minutes.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.beans.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
