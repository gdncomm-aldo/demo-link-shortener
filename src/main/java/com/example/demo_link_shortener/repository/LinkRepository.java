package com.example.demo_link_shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_link_shortener.entity.Link;

public interface LinkRepository extends JpaRepository<Link, String> {
}
