package com.kakaopay.shy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakaopay.shy.model.UserInvest;
import com.kakaopay.shy.model.UserInvestPk;

public interface UserInvestRepository extends JpaRepository<UserInvest, UserInvestPk> {
	List<UserInvest> findAllByUserId(Long userId);
}
