package com.kb.itisme.customMenu.repository;

import com.kb.itisme.customMenu.domain.CustomMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomMenuRepository extends JpaRepository<CustomMenu, Long> {
}
