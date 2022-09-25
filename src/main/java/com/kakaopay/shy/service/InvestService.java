package com.kakaopay.shy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopay.shy.code.ErrorCode;
import com.kakaopay.shy.code.Status;
import com.kakaopay.shy.common.ApiException;
import com.kakaopay.shy.dto.InvestDto;
import com.kakaopay.shy.model.Product;
import com.kakaopay.shy.model.User;
import com.kakaopay.shy.model.UserInvest;
import com.kakaopay.shy.model.UserInvestPk;
import com.kakaopay.shy.repository.ProductRepository;
import com.kakaopay.shy.repository.UserInvestRepository;
import com.kakaopay.shy.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestService {
	@Autowired
    private ProductRepository productRepository;
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserInvestRepository userInvestRepository;

	@Transactional
    public long insertProducts() {
		int productCnt = 3;
		for(int i = 1; i <= productCnt; i++) {
			Product product = new Product();
			product.setStartedAt(LocalDateTime.now());
//			product.setFinishedAt(LocalDateTime.now().plusDays(1));
			product.setFinishedAt(LocalDateTime.now().plusSeconds(11));
			product.setStatus(Status.Y);
			product.setTitle("투자상품"+i);
			product.setCurrentInvestingAmount(0L);
			product.setTotalInvestingAmount(1000000L);
			product.setInvestCount(0L);
			
			productRepository.save(product);
		}
        return productRepository.count();
    }
	
	@Transactional
	public long insertUsers() {
		int userCnt = 10;
		for(int i = 1; i <= userCnt; i++) {
			User user = new User();
			user.setCretDt(LocalDateTime.now());
			user.setName("user"+i);			
			userRepository.save(user);
		}

		return userRepository.count();
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductList() {
		List<Product> productList = productRepository.findByStartedAtLessThanAndFinishedAtGreaterThan(LocalDateTime.now(), LocalDateTime.now());
		if(productList.size() < 1) {
			throw new ApiException(ErrorCode.PRODUCT_NOT_FOUND);
		}
		return productList;
	}
	
	@Transactional
	private Product updateProductInfo(Long userId, Long productId, long investAmt) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ApiException(ErrorCode.PRODUCT_NOT_FOUND));
		
		long currentInvestingAmount = product.getCurrentInvestingAmount();
		long totalInvestingAmount = product.getTotalInvestingAmount();

		if(product.getStartedAt().isAfter(LocalDateTime.now()) || product.getFinishedAt().isBefore(LocalDateTime.now())) {
			throw new ApiException(ErrorCode.INVEST_INVALID_TERM);
		}
		
		if(product.getStatus() == Status.N) {
			throw new ApiException(ErrorCode.INVEST_SOLD_OUT);
		}
		
		if(investAmt + currentInvestingAmount > totalInvestingAmount) {
			throw new ApiException(ErrorCode.INVEST_AMT_OVER);
		}
		
		if(investAmt + currentInvestingAmount == totalInvestingAmount) {
			product.setStatus(Status.N);
		}
		
		product.doInvest(investAmt);
		product.updateInvestCount();
		
		return productRepository.save(product);
	}
	
	@Transactional
	private User getUserInfo(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
	}
	
	@Transactional
	private UserInvest saveProductInfo(Long userId, Long productId, long investAmt) {
		UserInvestPk userInvestPk = new UserInvestPk();
		userInvestPk.setProductId(productId);
		userInvestPk.setUserId(userId);
		UserInvest userInvest = userInvestRepository.findById(userInvestPk)
				.orElse(new UserInvest());
		if(userInvest.getUserId() == null || userInvest.getProductId() == null) {
			userInvest.setUserId(userId);
			userInvest.setProductId(productId);
			userInvest.setUserInvestingAmount(investAmt);
		}else {
			userInvest.setUserInvestingAmount(userInvest.getUserInvestingAmount()+investAmt);
		}
		
		userInvest.setCretDt(LocalDateTime.now());
		
		userInvest = userInvestRepository.save(userInvest);
		
		return userInvest;
	}
	@Transactional
	public UserInvest insertInvest(Long userId, Long productId, long investAmt) {
		if(userId == null) {
			throw new ApiException(ErrorCode.USER_NOT_FOUND);
		}
		if(productId < 1) {
			throw new ApiException(ErrorCode.PRODUCT_NOT_FOUND);
		}
		if(investAmt < 1) {
			throw new ApiException(ErrorCode.INVEST_AMT_ZERO);
		}		
		
		getUserInfo(userId);
		
		updateProductInfo(userId, productId, investAmt);
		
		UserInvest userInvest = saveProductInfo(userId, productId, investAmt);
		return userInvest;
	}
	
	@Transactional(readOnly = true)
	public List<InvestDto> getInvestList(Long userId) {
		List<UserInvest> userInvestList = userInvestRepository.findAllByUserId(userId);
		if(userInvestList == null || userInvestList.size() == 0) {
			throw new ApiException(ErrorCode.INVEST_NOT_FOUND);	
		}
		
		List<InvestDto> userInvestDtoList = userInvestList.stream().map(o -> new InvestDto(o)).collect(Collectors.toList());
		
		return userInvestDtoList;
	}
}
